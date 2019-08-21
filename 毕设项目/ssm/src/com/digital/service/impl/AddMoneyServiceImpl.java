package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.AddMoneyDAO;
import com.digital.dao.BossInfoDAO;
import com.digital.pojo.AddMoney;
import com.digital.service.AddMoneyService;

@Service("addMoneyService")
public class AddMoneyServiceImpl implements AddMoneyService {

	@Autowired
	private AddMoneyDAO addMoneyDao;

	@Override
	public void creatPetition(AddMoney am) {
		addMoneyDao.creatPetition(am);
	}

	@Override
	public List<AddMoney> getAllRequest() {
		return addMoneyDao.getAllRequest();
	}

	@Override
	public AddMoney getAddMoneyByAid(int aid) {
		return addMoneyDao.getAddMoneyByAid(aid);
	}

	@Override
	public void permit(AddMoney am) {
		addMoneyDao.permit(am);
	}

	@Override
	public void refuse(AddMoney am) {
		addMoneyDao.refuse(am);
	}
	
}
