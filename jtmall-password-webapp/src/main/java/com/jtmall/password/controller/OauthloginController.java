package com.jtmall.password.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jtmall.userPojo.UmsMember;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthQqRequest;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.request.AuthWeiboRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Badribbit
 * @create 2020/4/16 15:50
 * @Define
 * @Tutorials
 * @Opinion
 */
@Controller
public class OauthloginController {

    //GITHUB登录
    @RequestMapping("/render/{name}")
    public void render(HttpServletResponse response, @PathVariable("name") String name) throws IOException {
        AuthRequest authRequest = getAuthRequest(name);
        response.sendRedirect(authRequest.authorize("state"));
    }

    @ResponseBody
    @RequestMapping("/oauthLogin/{name}")
    public Object oauthLogin(AuthCallback code,@PathVariable("name") String name) {
        AuthRequest authRequest = getAuthRequest(name);
        AuthResponse response= authRequest.login(code);
        String  jsonS= JSON.toJSONString(response);
        JSONObject jsonObject = (JSONObject) JSON.parseObject(jsonS).get("data");
        System.out.println((String) jsonObject.get("username"));



        return response;
    }

    private AuthRequest getAuthRequest(String name) {
        switch (name){
            case "qq" :
                return new AuthQqRequest(AuthConfig.builder()
                        .clientId("1110350977")
                        .clientSecret("tuPXHKzF7VQpy8lt")
                        .redirectUri("http://127.0.0.1:9095/oauthLogin/qq")
                        .build());
            case "github":
                return new AuthGithubRequest(AuthConfig.builder()
                        .clientId("ed78a74932adec77b20d")
                        .clientSecret("7fabdaac7738efb74335a9de276415b29cebb7fc")
                        .redirectUri("http://127.0.0.1:9095/oauthLogin/github")
                        .build());
            case "weibo":
                return new AuthWeiboRequest(AuthConfig.builder()
                        .clientId("2977058238")
                        .clientSecret("b96025234b0e6cccddde39a459d95b83")
                        .redirectUri("http://127.0.0.1:9095/oauthLogin/weibo")
                        .build());
        }
       return  null;
    }

    private UmsMember packUser(JSONObject jsonObject){

        return null;
    }
}
