package com.jtmall.util;

import io.jsonwebtoken.*;

import java.util.Map;

public class JwtUtil {

    /**
     *
     * @param key  服务器公共key (服务器生成)
     * @param param 用户基本信息
     * @param salt 盐  (浏览器生成，一般根据（ip，time）生成)
     * @return
     */
    public static String encode(String key, Map<String,Object> param, String salt){
        if(salt!=null){
            key+=salt;
        }
        JwtBuilder jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS256,key);

        jwtBuilder = jwtBuilder.setClaims(param);

        String token = jwtBuilder.compact();
        return token;

    }


    public  static Map<String,Object>  decode(String token ,String key,String salt){
        Claims claims=null;
        if (salt!=null){
            key+=salt;
        }
        try {
            claims= Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch ( JwtException e) {
           return null;
        }
        return  claims;
    }
}
