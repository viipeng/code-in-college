package com.digital.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.Shopping_trolleyInfoDAO;
import com.digital.pojo.Shopping_trolleyInfo;
import com.digital.service.Shopping_trolleyInfoService;

@Service("shopping_trolleyInfoService")
public class Shopping_trolleyInfoServiceImpl implements Shopping_trolleyInfoService{

	@Autowired
	private Shopping_trolleyInfoDAO shopping_trolleyInfoDao;

	@Override
	public Shopping_trolleyInfo getSidByUidAndRid(Shopping_trolleyInfo sti) {
		return shopping_trolleyInfoDao.getSidByUidAndRid(sti);
	}

	@Override
	public void CompleteShopping_trolley(Shopping_trolleyInfo sti) {
		shopping_trolleyInfoDao.CompleteShopping_trolley(sti);
	}
	
	@Override
	public void AddShopping_trolley(Shopping_trolleyInfo sti) {
		/*Date date= new Date();
		String time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date.getTime());
		Shopping_trolleyInfo sti= new Shopping_trolleyInfo();
		sti.setSdate(time);
		sti.setUid(uid);
		sti.setFid(fid);*/
		shopping_trolleyInfoDao.AddShopping_trolley(sti);
	}

	@Override
	public void DeleteShopping_trolley(int sid) {
		shopping_trolleyInfoDao.DeleteShopping_trolley(sid);
	}

	@Override
	public void DeleteSTOfUid(int uid) {
		shopping_trolleyInfoDao.DeleteSTOfUid(uid);
	}

	@Override
	public List<Shopping_trolleyInfo> getSTInfoBySid(int sid) {
		return shopping_trolleyInfoDao.getSTInfoBySid(sid);
	}

	@Override
	public List<Integer> getSidByUid(int uid) {
		return shopping_trolleyInfoDao.getSidByUid(uid);
	}

	//ºóÌ¨
	@Override
	public List<Shopping_trolleyInfo> getShopping_trolleyInfo() {
		return shopping_trolleyInfoDao.getShopping_trolleyInfo();
	}

	@Override
	public void addSTInfo(Shopping_trolleyInfo sti) {
		shopping_trolleyInfoDao.addSTInfo(sti);
	}

	@Override
	public void updateSTInfo(Shopping_trolleyInfo sti) {
		shopping_trolleyInfoDao.updateSTInfo(sti);
	}

}
