package com.syt.hotel.type;



/**
 * 
 * @author zengjuhua
 * @Description:CommonType 枚举写的太死，写一个类，以防扩展
 */
public class BaseEnumeType {

	
	private Object[] args;
	
	private Integer db;

	private String description;

	/**
	 * 未知的
	 * @param args
	 */
	public BaseEnumeType(Object ... args) {
			this.args = args;
	}
	
	/**
	 * 返回对应的值
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getValue(int index){
		return (T) args[index];
	}

	/**
	 * 默认的
	 * @param d
	 * @param r
	 */
	public BaseEnumeType(Integer d, String r) {
			this.db = d;
			this.description = r;
			//兼容
			args = new Object[2];
			args[0] = d;
			args[1] = r;
	}
	
	
	public Integer getDb() {
		return db;
	}

	public String getDescription() {
		return description;
	}
}
