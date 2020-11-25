package com.syt.hotel;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaUserService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.WxMaInMemoryConfig;
import com.syt.hotel.common.StringToDateConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 *  启动类
 * @author 0200077
 * @create 2018-10-30 10:26
 **/
@Configuration
@MapperScan("com.syt.hotel.dao")
@SpringBootApplication
public class AppletServerApplication extends SpringBootServletInitializer{

    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    @Value("${applets.appid}")
    private String appId;
    @Value("${applets.secret}")
    private String secret;

   /* @Bean
    WxMaService getWxService(){
        WxMaService  userService = new WxMaServiceImpl();
        return userService;
    }*/

    @Bean
    WxMaInMemoryConfig getWxMaInMemoryCofig(){
        WxMaInMemoryConfig wxMaInMemoryConfig = new WxMaInMemoryConfig();
        wxMaInMemoryConfig.setAppid(appId);
        wxMaInMemoryConfig.setSecret(secret);
        return wxMaInMemoryConfig;
    }

    @Bean
    WxMaServiceImpl getWxMaServiceImpl(WxMaInMemoryConfig config){
        WxMaServiceImpl wxMaService = new WxMaServiceImpl();
        wxMaService.setWxMaConfig(config);
        return wxMaService;
    }

    @PostConstruct
    public void initEditableAvlidation() {
        ConfigurableWebBindingInitializer initializer = (ConfigurableWebBindingInitializer)handlerAdapter.getWebBindingInitializer();
        if(initializer.getConversionService()!=null) {
            GenericConversionService genericConversionService = (GenericConversionService)initializer.getConversionService();

            genericConversionService.addConverter(new StringToDateConverter());

        }

    }

    @RequestMapping("hello")
    public String hello(){
        return  "Hello Word!";
    }

    public static void main(String[] args) {
        SpringApplication.run(AppletServerApplication.class,args);
    }

}
