package com.syt.hotel.utils;

import java.util.List;


/**
 * 
 * @author 
 * @Description: list操作工具类
 */
public class ListUtils {

	/**
	 * 获取first第一个对象
	 * 
	 * @param list
	 * @return
	 */
	public static <T> T first(List<T> list) {
		return list != null && !list.isEmpty() ? list.get(0) : null;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNotEmpty(List list){
		return list !=  null && !list.isEmpty();
	}
}
