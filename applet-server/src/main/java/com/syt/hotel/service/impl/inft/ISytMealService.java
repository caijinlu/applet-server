package com.syt.hotel.service.impl.inft;

import java.util.Date;

import com.syt.hotel.model.SytUser;
import com.syt.hotel.model.SytUserBook;
import com.syt.hotel.page.PageBean;
import com.syt.hotel.page.Pager;
import com.syt.hotel.type.SytBookEnum;

/**
 *  SYT 用餐接口服务 
 *  @author jinlu
 *  @date 2020年11月24日上午8:51:34
 */
public interface ISytMealService {
	
	SytUser getUser(String modeil);
	
	/**
	 *  申请就餐
	 *  @author jinlu
	 *  @date 2020年11月24日上午9:08:14
	 *  @param modeil
	 *  @param eatIngDate
	 *  @param bookEnum
	 */
	void applyEating(String modeil, Date eatIngDate, SytBookEnum bookEnum, SytBookEnum fooEnum);
	
	/**
	 *  核销就餐
	 *  @author jinlu
	 *  @date 2020年11月24日上午9:16:10
	 *  @param bookId
	 *  @param checkUid
	 */
	void checkEating(Long bookId, Long checkUid);

	/**
	* @Description: 订餐分页记录
	* @Param:  type 1 未就餐 2 今天就餐 3 已就餐
	* @return:
	* @Author: jinlu
	* @Date:
	*/
	Pager<SytUserBook> userBookPage(int type, Long userId, int currentPage, int pageSize);
}
