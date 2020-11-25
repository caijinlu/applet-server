package com.syt.hotel.utils;

import com.syt.hotel.page.PageData;

import java.util.Collection;

/**
 * ajax 返回的数据对象
 * @author xiaoyou
 *
 * @param <T>
 */
public class Result<T> {
	
	// 操作是否成功
	private boolean success = true;
	
	//error code 
	private String err_code;
	
	// 消息信息
	private String msg;
	
	private String redirect;
	
	// 返回给客户端的对象
	private T obj;

	// 返回给客户端的list
	private Collection<T> rows;
	
	// 返回给客户端额外的data,兼容老版本的方式
	private Collection<T> data;
	
	private String url;
	
	private int code;
	
	private PageData<T> pageData = new PageData<T>();
	
 	
	private long total;
	
	//error_code 
	private int error_code;
	
	public Result(){
		
	}
	
	public Result(boolean success){
		this.success = success;
	}
	
	public Result(boolean success, String msg){
		this.success =success;
		this.msg = msg;
	}
	
	public Result(boolean success, String msg,int error_code){
		this.success =success;
		this.msg = msg;
		this.error_code = error_code;
	}
	
	
	public Result(Collection<T> rows){
		this.rows = rows;
	}
	
	
    public Result(PageData data){
		this.pageData = data;
	}
	
    public Result(T obj) {
    	this.obj = obj;
    }
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.success = false;
		this.msg = msg;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Collection<T> getRows() {
		return rows;
	}

	public void setRows(Collection<T> rows) {
		this.rows = rows;
	}

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public PageData<T> getPageData() {
		return pageData;
	}

	public void setPageData(PageData<T> pageData) {
		this.pageData = pageData;
	}

	public int getCode() {
		if(!success && code==0){
			code = -1;
		}
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}

	public int getError_code() {
		return error_code;
	}

	public void setError_code(int error_code) {
		this.error_code = error_code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	
}
