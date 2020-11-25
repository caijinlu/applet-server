package com.syt.hotel.service.impl;

import java.util.Date;
import java.util.List;

import com.syt.hotel.dao.SytDeptMapper;
import com.syt.hotel.dao.SytUserBookMapper;
import com.syt.hotel.dao.SytUserMapper;
import com.syt.hotel.model.SytUser;
import com.syt.hotel.model.SytUserBook;
import com.syt.hotel.model.SytUserBookExample;
import com.syt.hotel.model.SytUserExample;
import com.syt.hotel.page.PageBean;
import com.syt.hotel.page.Pager;
import com.syt.hotel.service.impl.inft.ISytMealService;
import com.syt.hotel.type.CommonType;
import com.syt.hotel.type.SytBookEnum;
import com.syt.hotel.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SytMealServiceImpl implements ISytMealService {

	@Autowired
	private SytUserMapper userMapper;
	@Autowired
	private SytUserBookMapper bookMapper;
	@Autowired
	private SytDeptMapper deptMapper;
	
	@Override
	public void applyEating(String modeil, Date eatIngDate, SytBookEnum bookEnum, SytBookEnum fooEnum) {
		SytUser sytUser = getUser(modeil);
		SytUserBook book = new SytUserBook();
		book.setBookDate(eatIngDate);
		book.setBookType(bookEnum.getVal());
		book.setCreateTime(new Date());
		book.setFoodType(fooEnum.getVal());
		book.setStatus(SytBookEnum.getDb(SytBookEnum.status_not_eating));
		book.setUserId(sytUser.getId());
		bookMapper.insert(book);
	}

	@Override
	public void checkEating(Long bookId, Long checkUid) {
		SytUserBook userBook = bookMapper.selectByPrimaryKey(bookId);
		if (userBook == null || userBook.getStatus() != SytBookEnum.status_not_eating.getVal()) {
			throw new UnsupportedOperationException("未匹配到该就餐记录或已就餐");
		}
		userBook.setCheckTime(new Date());
		userBook.setCheckUid(checkUid);
		bookMapper.updateByPrimaryKey(userBook);
	}

	@Override
	public Pager<SytUserBook> userBookPage(int type, Long userId, int currentPage, int pageSize) {
		Pager<SytUserBook> pager = new Pager<>(currentPage,pageSize);
		pager.setDatas(bookMapper.findAllByPage(type, userId, pager.getStart(), pager.getEnd()));
		pager.setTotal(bookMapper.findAllByPageCount(type, userId));
		return pager;
	}

	@Override
	public SytUser getUser(String modeil) {
		SytUserExample userExample = new SytUserExample();
		userExample.createCriteria().andMobileEqualTo(modeil).andStatusEqualTo(CommonType.ACTIVE);
		List<SytUser> users = userMapper.selectByExample(userExample);
		if (users == null || users.size() > 1) {
			throw new UnsupportedOperationException("无法获取员工信息！");
		}
		SytUser sytUser = ListUtils.first(users);
		return sytUser;
	}
}
