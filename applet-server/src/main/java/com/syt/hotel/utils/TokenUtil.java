package com.syt.hotel.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.auth0.jwt.interfaces.Verification;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot
 * @description: tokenSecret 使用openID
 * @author: jinlu
 * @create: 2020-11-24 15:03
 **/
public class TokenUtil {

    //设置过期时间
    private static final long EXPIRE_DATE=3600000;

    private static final String TOKEN_SECRET="AE126DDBBC926FD147192BA16CED85EB";

    /**
    * @Description: 生成token
    * @Param:  tokenSecret 密钥
    * @return:
    * @Author: jinlu
    * @Date:
    */
    public static String token(String modile, String tokenSecret){
        String token = "";
        try {
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("modile",modile)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return token;
    }

   /**
   * @Description: 效验token
   * @Param:
   * @return:
   * @Author: jinlu
   * @Date:
   */
    public static boolean verify(String token, String tokenSecret){

        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public static DecodedJWT decrypt(String token, String tokenSecret){
        DecodedJWT jwt = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            return verifier.verify(token);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String token = token("13650096499", "caijinlu");
        DecodedJWT jwt = decrypt(token, "caijinlu");
        System.out.println(token);
        System.out.println(jwt.getClaim("modile").asString());
        System.out.println(jwt.getClaim("exp").asDate());
        System.out.println();
        Map<String, Claim> claims = jwt.getClaims();
        for (String s : claims.keySet()) {
            System.out.println(s);
        }
    }
}