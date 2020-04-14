package com.jtmall.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.impl.Base64UrlCodec;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestJwt {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("memberId","1");
        map.put("nickname","zhangsan");
        String ip = "127.0.0.1";
        String time = new SimpleDateFormat("yyyyMMdd HHmm").format(new Date());
        //用户密钥，用户对象，盐
        String encode = JwtUtil.encode("2019gmall0105", map, ip + time);
        System.err.println(encode);

        Map<String,Object> map2=JwtUtil.decode("eyJhbGciOiJIUzI1NiJ9.eyJuaWNrbmFtZSI6Iui_meS4quaYteensOWkqumVv-S6huS6hiIsIm1lbWJlcklkIjozfQ.askEeuacDaKyK8s5B7fBVUVTPXzW4N5wFwLrvVTrsqk","2019gmall0105","0.0.0.0.0.0.0.1");

        Base64UrlCodec base64UrlCodec = new Base64UrlCodec();
        byte[] tokenBytes = base64UrlCodec.decode("eyJuaWNrbmFtZSI6Iui_meS4quaYteensOWkqumVv-S6huS6hiIsIm1lbWJlcklkIjozfQ");
        String tokenJson = null;
        try {
            tokenJson = new String(tokenBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Map map1 = JSON.parseObject(tokenJson, Map.class);
        System.out.println("64="+map1);


    }
}
