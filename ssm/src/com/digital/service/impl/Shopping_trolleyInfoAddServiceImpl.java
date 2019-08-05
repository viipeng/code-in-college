package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.Shopping_trolleyInfoAddDAO;
import com.digital.pojo.Shopping_trolleyInfoAdd;
import com.digital.service.Shopping_trolleyInfoAddService;

@Service("shopping_trolleyInfoAddService")
public class Shopping_trolleyInfoAddServiceImpl implements Shopping_trolleyInfoAddService {

	@Autowired
	private Shopping_trolleyInfoAddDAO shopping_trolleyInfoAddDao;
	
	/*@Override
	public Shopping_trolleyInfoAdd getShopping_trolleyInfo(Shopping_trolleyInfoAdd trolley) {
		return shopping_trolleyInfoAddDao.getShopping_trolleyInfo(trolley);
	}*/

}
