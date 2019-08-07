package com.digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.BossInfoDAO;
import com.digital.pojo.BossInfo;
import com.digital.service.BossInfoService;

@Service("bossInfoService")
public class BossInfoServiceImpl implements BossInfoService {

	@Autowired
	private BossInfoDAO bossInfoDao;
	
	@Override
	public BossInfo getBossInfoByCode(BossInfo bi) {
		return bossInfoDao.getBossInfoByCode(bi);
	}

	@Override
	public BossInfo getBossInfoByBid(int bid) {
		return bossInfoDao.getBossInfoByBid(bid);
	}

}
