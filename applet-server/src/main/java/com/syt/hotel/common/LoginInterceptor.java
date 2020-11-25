package com.syt.hotel.common;

import com.syt.hotel.utils.ISessionUtil;
import com.syt.hotel.utils.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: springboot
 * @description: 登录拦截
 * @author: jinlu
 * @create: 2020-11-25 09:29
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("开始拦截" + httpServletRequest.getRequestURI());
        HttpSession session = httpServletRequest.getSession();
        String token = (String) session.getAttribute("token");
        if (token == null){
            System.out.println("没有token");
            return false;
        }
        return TokenUtil.verify(token, ISessionUtil.getLoginMsg(httpServletRequest).getOpenid());
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}