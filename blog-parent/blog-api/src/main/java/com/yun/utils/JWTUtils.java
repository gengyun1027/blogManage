package com.yun.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : ljg
 * @date : 2022/5/20 16:09
 * @description :
 */
public class JWTUtils {

    private static final String jwtToken = "GengYun";


    public static String createToken(Long userId) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                /*签发算法，秘钥为jwtToken*/
                .signWith(SignatureAlgorithm.HS256, jwtToken)
                /*body数据，唯一，自行设置*/
                .setClaims(claims)
                /*设置签发时间*/
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));
        String token = jwtBuilder.compact();
        return token;
    }
    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse=Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token= JWTUtils.createToken(100L);
        System.out.println(token);
        Map<String, Object> stringObjectMap = JWTUtils.checkToken(token);
        System.out.println(stringObjectMap.get("userId"));
    }
}
