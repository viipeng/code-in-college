package com.digital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.MerchantDAO;
import com.digital.pojo.MerchantInfo;
import com.digital.service.MerchantService;

@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
	private MerchantDAO merchantDAO;

	@Override
	public MerchantInfo getMerchantByCode(MerchantInfo mi) {
		return merchantDAO.getMerchantByCode(mi);
	}

	@Override
	public float queryAccount(int rid){
		return merchantDAO.queryAccount(rid);
	}

	@Override
	public void changePassword(MerchantInfo mi) {
		merchantDAO.changePassword(mi);
	}

	@Override
	public String getPasswordByRid(int rid) {
		return merchantDAO.getPasswordByRid(rid);
	}

	@Override
	public MerchantInfo getMerchantByRid(int rid) {
		return merchantDAO.getMerchantByRid(rid);
	}

	@Override
	public void haveRefund(MerchantInfo mi) {
		merchantDAO.haveRefund(mi);
	}

	@Override
	public String getNameByRid(int rid) {
		return merchantDAO.getNameByRid(rid);
	}

	@Override
	public void addMoney(MerchantInfo mi) {
		merchantDAO.addMoney(mi);
	}

}
