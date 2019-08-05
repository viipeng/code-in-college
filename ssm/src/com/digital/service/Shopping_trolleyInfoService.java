package com.digital.service;

import java.util.List;

import com.digital.pojo.Shopping_trolleyInfo;

public interface Shopping_trolleyInfoService {

	public Shopping_trolleyInfo getSidByUidAndRid(Shopping_trolleyInfo sti);

	public void CompleteShopping_trolley(Shopping_trolleyInfo sti);
	
	public void AddShopping_trolley(Shopping_trolleyInfo sti);
	
	public void DeleteShopping_trolley(int sid);

	public void DeleteSTOfUid(int uid);

	public List<Shopping_trolleyInfo> getSTInfoBySid(int sid);

	public List<Integer> getSidByUid(int sid);
	
	//ºóÌ¨
	public List<Shopping_trolleyInfo> getShopping_trolleyInfo();

	public void addSTInfo(Shopping_trolleyInfo sti);

	public void updateSTInfo(Shopping_trolleyInfo sti);
	

}
