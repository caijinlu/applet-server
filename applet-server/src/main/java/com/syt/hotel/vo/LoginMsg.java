package com.syt.hotel.vo;

/**
 * @program: springboot
 * @description:
 * @author: jinlu
 * @create: 2020-11-24 16:44
 **/
public class LoginMsg {

    private String openId;

    private String sessionKey;

    private String unionid;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}