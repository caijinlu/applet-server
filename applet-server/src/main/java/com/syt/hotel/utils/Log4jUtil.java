package com.syt.hotel.utils;

import java.text.MessageFormat;

import org.apache.log4j.Logger;

/**
 * 日志辅助类，帮助记录处理日志输出
 * @author xiaoyou
 */
public class Log4jUtil {
	
	private static Logger logger = Logger.getLogger(Log4jUtil.class);
	
	public static final String LOG_PREFIX ="====>";
	
    public static void warn(Logger logger,String msg,Object ...args){
    	logger.warn(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
	
	public static void error(Logger logger,String msg,Object ...args){
		logger.error(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
	
    public static void info(Logger logger,String msg,Object ...args){
    	logger.info(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
    
    public static void debug(Logger logger,String msg,Object ...args){
    	logger.debug(MessageFormat.format(LOG_PREFIX.concat(msg), args));
  	}
    
    
    public static void warn(String msg,Object ...args){
    	logger.warn(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
	
	public static void error(String msg,Object ...args){
		logger.error(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
	
    public static void info(String msg,Object ...args){
    	logger.info(MessageFormat.format(LOG_PREFIX.concat(msg), args));
	}
    
    public static void debug(String msg,Object ...args){
    	logger.debug(MessageFormat.format(LOG_PREFIX.concat(msg), args));
  	}
    
    public static void warn(String msg){
    	logger.warn(MessageFormat.format(LOG_PREFIX.concat(msg), null));
	}
	
	public static void error(String msg){
		logger.error(MessageFormat.format(LOG_PREFIX.concat(msg), null));
	}
	
    public static void info(String msg){
    	logger.info(MessageFormat.format(LOG_PREFIX.concat(msg), null));
	}
    
    public static void debug(String msg){
    	logger.debug(MessageFormat.format(LOG_PREFIX.concat(msg), null));
  	}
}
