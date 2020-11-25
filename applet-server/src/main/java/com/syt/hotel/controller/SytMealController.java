package com.syt.hotel.controller;

import java.util.Date;

import com.syt.hotel.model.SytUser;
import com.syt.hotel.model.SytUserBook;
import com.syt.hotel.page.PageData;
import com.syt.hotel.page.Pager;
import com.syt.hotel.service.impl.inft.ISytMealService;
import com.syt.hotel.type.SytBookEnum;
import com.syt.hotel.utils.ISessionUtil;
import com.syt.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *  订餐控制
 *  @author jinlu
 *  @date 2020年11月24日上午10:17:52
 */
@RestController
@RequestMapping("meal")
public class SytMealController extends BaseController{
	
	@Autowired
	private ISytMealService mealService;
	
	@RequestMapping("get_user")
	public SytUser getUser(String modeil) {
		return mealService.getUser(modeil);
	}
	
	/**
	 *  订餐
	 *  @author jinlu
	 *  @date 2020年11月24日上午10:22:09
	 *  @param modeil
	 *  @param eatIngDate
	 *  @param bookType
	 *  @param fooType
	 *  @return
	 */
	@PostMapping("apply_eat")
	public Result applyEating(String modeil, Date eatIngDate, Integer bookType, Integer fooType) {
		try {
			mealService.applyEating(modeil, new Date(), SytBookEnum.getEnum(bookType), SytBookEnum.getEnum(fooType));
		} catch (UnsupportedOperationException e) {
			return new Result(false,e.getMessage());
		}
		return new Result();
	}
	
	/**
	 *  核销
	 *  @author jinlu
	 *  @date 2020年11月24日上午10:32:44
	 *  @param bookId
	 *  @return
	 */
	@PostMapping("check_eat")
	public Result checkEating(Long bookId) {
		try {
			mealService.checkEating(bookId, 0l);
		} catch (UnsupportedOperationException e) {
			return new Result(false,e.getMessage());
		}
		return new Result();
	}
	
	/** 
	* @Description: 订餐记录列表
	* @Param:  
	* @return:  
	* @Author: jinlu 
	* @Date:  
	*/
	@RequestMapping("list")
	public Result userBookPage(int type, Long userId, int currentPage, int pageSize){
		Pager<SytUserBook> pager = mealService.userBookPage(type, userId, currentPage, pageSize);
		return pageResult(pager.getDatas(),pager.getTotal(),pageSize,currentPage);
	}
}
