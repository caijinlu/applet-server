package com.syt.hotel.type;

/**
 *  SytUserBook 类型
 *  @author jinlu
 *  @date 2020年11月24日上午8:53:59
 */
public enum SytBookEnum {
	
	/** BOOK_TYPE **/
	book_breakfast(1,1,"早餐"),
	
	book_lunch(2,2,"午餐"),
	
	book_dinner(3,3,"晚餐"),
	
	/** FOOD_TYPE **/
	food_hot(4,1,"辣"),
	
	food_not_hot(5,2,"不辣"),
	
	/** STATUS **/
	status_eating(6,1,"已就餐"),
	
	status_not_eating(7,0,"未就餐"),
	;
	
	// 类型
	private Integer type;
	
	// 存数据库的真实值
	private Integer val;
	
	// 状态描述
	private String desc;
	
	private SytBookEnum(Integer type, Integer val, String desc) {
		this.type = type;
		this.val = val;
		this.desc = desc;
	}
	
	public static Integer getDb(SytBookEnum enum1) {
		return enum1.getVal();
	}
	
	public static SytBookEnum getEnum(Integer type) {
		SytBookEnum[] values = SytBookEnum.values();
		if (values != null) {
			for (SytBookEnum sytBookEnum : values) {
				if (sytBookEnum.getType() == type) {
					return sytBookEnum;
				}
			}
		}
		return null;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
