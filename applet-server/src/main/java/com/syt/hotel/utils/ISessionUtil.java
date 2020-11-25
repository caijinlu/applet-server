package com.syt.hotel.utils;

import com.syt.hotel.model.SytUser;
import com.syt.hotel.vo.LoginMsg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @program: springboot
 * @description:
 * @author: jinlu
 * @create: 2020-11-24 16:39
 **/
public class ISessionUtil {

    public static final String AUTH_SESSION_KEY = "ASK";

    /**
     *  获取用户
     * @param request
     * @return
     */
    public static SytUser getLoginMsg(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        return (SytUser) httpSession.getAttribute(AUTH_SESSION_KEY);
    }

    /**
     * 设置session信息
     */
    public static void setSession(HttpServletRequest request, LoginMsg msg){
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute(AUTH_SESSION_KEY,msg);
    }
}