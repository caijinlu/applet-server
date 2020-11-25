package com.syt.hotel.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import com.syt.hotel.utils.ISessionUtil;
import com.syt.hotel.utils.Log4jUtil;
import com.syt.hotel.utils.Result;
import com.syt.hotel.utils.TokenUtil;
import com.syt.hotel.vo.LoginMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @program: springboot
 * @description: 登录控制
 * @author: jinlu
 * @create: 2020-11-24 15:19
 **/
@RestController
@RequestMapping("applet")
public class LoginController {

    @Autowired
    private WxMaConfig config;
   /* @Autowired
    private WxMaInMyConfig myConfig;*/
    @Autowired
    private WxMaService wxMaService;

    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response){
        System.out.println(config.getAppid());
        System.out.println(config.getSecret());
        /*System.out.println(myConfig.getSecret());
        System.out.println(myConfig.getAppid());*/
        HttpSession session = request.getSession();
        session.setAttribute("token","1233");
        session.setAttribute("openId","456");
        session.setAttribute("sessionKey","aadfaf");
    }
    
    /** 
    * @Description: 小程序登录 
    * @Param:  
    * @return:  
    * @Author: jinlu 
    * @Date:  
    */
    @RequestMapping("login")
    public Result appletLogin(HttpServletRequest request, String code) {
        Result result = new Result();
       try {
           /** 用JSCODE获取用户信息 **/
           //WxMaJscode2SessionResult sessionInfo = wxMaService.getUserService().getSessionInfo(code);
           WxMaJscode2SessionResult sessionInfo = new WxMaJscode2SessionResult();
           sessionInfo.setOpenid("12312");
           sessionInfo.setSessionKey("4646465646");
           sessionInfo.setUnionid("1213");
           Log4jUtil.info("小程序登录，session openId:"+sessionInfo.getOpenid());
           /** 用openID生成token **/
           String token = TokenUtil.token(System.currentTimeMillis() + "_" + Math.random(), sessionInfo.getOpenid());
           /** 将用户信息暂存在session中 **/
           LoginMsg msg = new LoginMsg();
           msg.setOpenId(sessionInfo.getOpenid());
           msg.setSessionKey(sessionInfo.getSessionKey());
           msg.setUnionid(sessionInfo.getUnionid());
           msg.setToken(token);
           ISessionUtil.setSession(request,msg);
           result.setObj(msg);
       }catch (Exception e){
           e.printStackTrace();
           return new Result(false,e.getMessage());
       }
        return result;
    }
    
    /** 
    * @Description: 注册登录 
    * @Param:  
    * @return:  
    * @Author: jinlu 
    * @Date:  
    */
    @RequestMapping("register")
    public Result appletRegister(HttpServletRequest request, String modeil, String name, String pwd, String deptId){
        return new Result();
    }

}