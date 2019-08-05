package com.digital.service;

import java.util.List;

import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.MeauInfo;


public interface MeauInfoService {
	//这个方法里的其那台和后台的方法区分开来，因为前台使用MeauInfoAdd类，但后台使用MeauInfo类

//	public List<MeauInfo> getMeauInfo();

	public List<MeauInfo> getMeauInfoByrid(int rid);

	public int getRidByMid(int mid);
	
	//以下是后台的5个方法
	public List<MeauInfo> getMeauInfoBymid(int mid);

	public List<MeauInfo> getMeauInfoBymidOfRid(ForSearchOfRid fe);
		
	public List<MeauInfo> getMeauInfo();
		
	public void addMeauInfo(MeauInfo mia);
		
	public void deleteMeauInfo(int mid);
		
	public void updateMeauInfo(MeauInfo mia);
}
