package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.MeauInfoDAO;
import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.MeauInfo;
import com.digital.service.MeauInfoService;

@Service("meauInfoService")
public class MeauInfoServiceImpl implements MeauInfoService {

	@Autowired
	private MeauInfoDAO meauInfoDao;
	
	/*@Override
	public List<MeauInfo> getMeauInfo() {
		return meauInfoDao.getMeauInfo();
	}*/

	@Override
	public List<MeauInfo> getMeauInfoByrid(int rid) {
		return meauInfoDao.getMeauInfoByrid(rid);
	}

	@Override
	public int getRidByMid(int mid) {
		return meauInfoDao.getRidByMid(mid);
	}

	//以下是后台的5个方法
	@Override
	public List<MeauInfo> getMeauInfoBymid(int mid) {
		return meauInfoDao.getMeauInfoBymid(mid);
	}

	@Override
	public List<MeauInfo> getMeauInfoBymidOfRid(ForSearchOfRid fe) {
		return meauInfoDao.getMeauInfoBymidOfRid(fe);
	}

	@Override
	public List<MeauInfo> getMeauInfo() {
		return meauInfoDao.getMeauInfo();
	}

	@Override
	public void addMeauInfo(MeauInfo mia) {
		meauInfoDao.addMeauInfo(mia);
	}

	@Override
	public void deleteMeauInfo(int mid) {
		meauInfoDao.deleteMeauInfo(mid);
	}

	@Override
	public void updateMeauInfo(MeauInfo mia) {
		meauInfoDao.updateMeauInfo(mia);
	}
}
