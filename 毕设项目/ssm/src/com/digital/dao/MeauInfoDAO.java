package com.digital.dao;

import java.util.List;

import com.digital.pojo.ForSearchOfRid;
import com.digital.pojo.MeauInfo;
import com.digital.pojo.MeauInfo;

public interface MeauInfoDAO {

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
