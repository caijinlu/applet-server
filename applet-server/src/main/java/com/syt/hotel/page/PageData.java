package com.syt.hotel.page;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页数据集对象
 * 
 * @author xiaoyou
 * @param <T>
 */
public class PageData<T> {
	
	private List<T> list = new ArrayList<T>();
	
	private T obj;
	
	private String page;

	public PageData(){
		
	}
	
	public PageData(List<T> list){
		this.list = list;
	}
	
	public PageData(List<T> list,String page){
		this(list);
		this.page = page;
	}
	
	
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	
	
}
