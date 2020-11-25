package com.syt.hotel.common;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: springboot
 * @description: 全局转换String-Date
 * @author: jinlu
 * @create: 2020-11-24 14:12
 **/
public class CustomDate implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
        // TODO Auto-generated method stub
        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}