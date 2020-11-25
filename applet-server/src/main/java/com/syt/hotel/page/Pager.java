package com.syt.hotel.page;

import java.util.List;

/**
 * 分页对象
 * @author 
 * @param <T> 传递的泛型对象
 */
public class Pager<T> {
	/**
	 * 每页显示条数
	 */
	private int pageSize = 10;
	/**
	 * 分页的起始页
	 */
	private int start;
	
	/**
	 * 分页的结束页
	 */
	private int end;
	
	/**
	 * 第几页
	 */
	private int pageNum;
	
	/**
	 * 第几页的简写
	 */
	private int p = 0;
	
	/**
	 * 查询的总数
	 */
	private long total;
	/**
	 * 分页的结果数据
	 */
	private List<T> datas;
	
	
	private List<String> strDatas;
	
	
	
	
	public Pager(){}
	
	public Pager(int total, List<T> datas) {
		this.total = total;
		this.datas = datas;
	}
	
	public Pager(int pageNum, int pageSize){
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.start = (pageNum >= 1)?((pageNum-1) * pageSize):0;
		this.end = pageSize;
	}
		
	public Pager(long total, List<T> datas, int pageNum, int pageSize){
		this.total = total;
		this.datas = datas;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.start = (pageNum >= 1)?((pageNum-1) * pageSize):0;
		this.end = pageSize;
	}

	public int getSize() {
		return pageSize;
	}
	public void setSize(int size) {
		this.pageSize = size;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	public List<String> getStrDatas() {
		return strDatas;
	}

	public void setStrDatas(List<String> strDatas) {
		this.strDatas = strDatas;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	
	
}
