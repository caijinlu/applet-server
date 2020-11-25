package com.syt.hotel.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 时间处理的辅助类
 * @author xiaoyou
 *
 */
public class ExceptionPropUtil {
	
	private static Logger logger = Logger.getLogger(ExceptionPropUtil.class);
	
	private static Properties prop;
	
	static{
		//初始化异常配置文件
		prop = new Properties();
		InputStream in = ExceptionPropUtil.class.getResourceAsStream("/exception.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			//读取配置文件异常
			Log4jUtil.error(logger, "异常配置文件加载错误：{0}", e.getMessage());
		}
	}
	
	public static String getValue(String key){
		return prop.getProperty(key);
	}
}
