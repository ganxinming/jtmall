package com.jtmall.password.controller;

import com.alibaba.fastjson.JSON;
import com.jtmall.commons.utils.HttpclientUtil;
import com.jtmall.userInterface.UserService;
import com.jtmall.userPojo.UmsMember;
import com.jtmall.util.JwtUtil;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.request.AuthQqRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PassportController {


    @Reference(version = "${demo.service.user}")
    UserService userService;


    @RequestMapping("vlogin")
    public String vlogin(String code,HttpServletRequest request){

        // 授权码换取access_token
        // 换取access_token
        // client_secret=f043fe09dcab7e9b90cdd7491e282a8f
        // client_id=2173054083
        String s3 = "https://api.weibo.com/oauth2/access_token?";
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("client_id","2977058238");
        paramMap.put("client_secret","b96025234b0e6cccddde39a459d95b83");
        paramMap.put("grant_type","authorization_code");
        paramMap.put("redirect_uri","http://127.0.0.1:9095/vlogin");
        paramMap.put("code",code);// 授权有效期内可以使用，没新生成一次授权码，说明用户对第三方数据进行重启授权，之前的access_token和授权码全部过期
        String access_token_json = HttpclientUtil.doPost(s3, paramMap);

        Map<String,Object> access_map = JSON.parseObject(access_token_json,Map.class);

        // access_token换取用户信息
        String uid = (String)access_map.get("uid");
        String access_token = (String)access_map.get("access_token");
        String show_user_url = "https://api.weibo.com/2/users/show.json?access_token="+access_token+"&uid="+uid;
        String user_json = HttpclientUtil.doGet(show_user_url);
        Map<String,Object> user_map = JSON.parseObject(user_json,Map.class);

        // 将用户信息保存数据库，用户类型设置为微博用户
        UmsMember umsMember = new UmsMember();
        umsMember.setSourceType(2);
        umsMember.setAccessCode(code);
        umsMember.setAccessToken(access_token);

        String s1=user_map.get("idstr").toString();
        long sid=Long.parseLong(s1);
        umsMember.setSourceUid((int)sid);
        umsMember.setCity((String)user_map.get("location"));
        umsMember.setNickname((String)user_map.get("screen_name"));
        String g = "0";
        String gender = (String)user_map.get("gender");
        if(gender.equals("m")){
            g = "1";
        }
        umsMember.setGender(Integer.parseInt(g));

        UmsMember umsCheck = new UmsMember();
        umsCheck.setSourceUid(umsMember.getSourceUid());
        UmsMember umsMemberCheck = userService.checkOauthUser(umsCheck);// 检查该用户(社交用户)以前是否登陆过系统

        if(umsMemberCheck==null){
            umsMember = userService.addOauthUser(umsMember);
        }else{
            umsMember = umsMemberCheck;
        }

        // 生成jwt的token，并且重定向到首页，携带该token
        String token = null;
        Integer memberId = umsMember.getId();// rpc的主键返回策略失效
        String nickname = umsMember.getNickname();
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("memberId",memberId);// 是保存数据库后主键返回策略生成的id
        userMap.put("nickname",nickname);


        String ip = request.getHeader("x-forwarded-for");// 通过nginx转发的客户端ip
        if(StringUtils.isBlank(ip)){
            ip = request.getRemoteAddr();// 从request中获取ip
            if(StringUtils.isBlank(ip) || ip.equals("0:0:0:0:0:0:0:1")){
                ip = "127.0.0.1";
            }
        }

        // 按照设计的算法对参数进行加密后，生成token
        token = JwtUtil.encode("2019gmall0105", userMap, ip);

        // 将token存入redis一份
        userService.addUserToken(token,memberId);


        return "redirect:http://localhost:9091/index?token="+token;
    }


    @RequestMapping("verify")
    @ResponseBody
    public String verify(String token,String currentIp,HttpServletRequest request){

        // 通过jwt校验token真假
        Map<String,String> map = new HashMap<>();

        Map<String, Object> decode = JwtUtil.decode(token, "2019gmall0105", currentIp);

        if(decode!=null){
            map.put("status","success");
            System.out.println(decode.get("memberId").toString()+decode.get("nickname").toString());
            map.put("memberId", decode.get("memberId").toString());
            map.put("nickname",decode.get("nickname").toString());
        }else{
            map.put("status","fail");
        }


        return JSON.toJSONString(map);
    }


    @RequestMapping("login")
    @ResponseBody
    public String login(UmsMember umsMember, HttpServletRequest request){

        String token = "";

        // 调用用户服务验证用户名和密码
        UmsMember umsMemberLogin = userService.login(umsMember);

        if(umsMemberLogin!=null){
            // 登录成功

            // 用jwt制作token
            Integer memberId = umsMemberLogin.getId();
            String nickname = umsMemberLogin.getNickname();
            Map<String,Object> userMap = new HashMap<>();
            userMap.put("memberId",memberId);
            userMap.put("nickname",nickname);


            String ip = request.getHeader("x-forwarded-for");// 通过nginx转发的客户端ip
            if(StringUtils.isBlank(ip)){
                ip = request.getRemoteAddr();// 从request中获取ip
                if(StringUtils.isBlank(ip) || ip.equals("0:0:0:0:0:0:0:1")){
                    ip = "127.0.0.1";
                }
            }


            // 按照设计的算法对参数进行加密后，生成token
            token = JwtUtil.encode("2019gmall0105", userMap, ip);

            // 将token存入redis一份
            userService.addUserToken(token,memberId);

        }else{
            // 登录失败
            token = "fail";
        }
        System.out.println("token:"+token);
        return token;
    }

//    @RequestMapping("index")
//    public String index(String ReturnUrl, ModelMap map){
//        if (ReturnUrl != null ){
//            map.put("ReturnUrl",ReturnUrl);
//        }
//        return "index";
//    }
    //登出
    @RequestMapping("vlogout")
    public String vlogout(ModelMap map){
        return "index";
    }
    //qq登录
    @RequestMapping("/qqRender")
    public void qqRender(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = getqqAuthRequest();
        response.sendRedirect(authRequest.authorize("state"));
    }

    @RequestMapping("/qlogin")
    public Object qlogin(AuthCallback code) {
        AuthRequest authRequest = getqqAuthRequest();
        return authRequest.login(code);
    }

    private AuthRequest getqqAuthRequest() {
        return new AuthQqRequest(AuthConfig.builder()
                .clientId("1110350977")
                .clientSecret("tuPXHKzF7VQpy8lt")
                .redirectUri("http://127.0.0.1:9095/qlogin")
                .build());
    }

    @RequestMapping("index")
    public String index(String ReturnUrl, ModelMap map){
        if (ReturnUrl != null ){
            map.put("ReturnUrl",ReturnUrl);
        }
        return "/mall/login";
    }
}
