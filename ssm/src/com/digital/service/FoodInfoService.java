package com.digital.service;

import java.util.List;

import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchFood;
import com.digital.pojo.ForSearchOfRid;

public interface FoodInfoService {

	public List<FoodInfo> searchFood(ForSearchFood forSearchFood);

	public List<FoodInfo> getFoodInfoByPrice(int mid);

	public List<FoodInfo> getFoodInfoByPrice1(int mid);

	public List<FoodInfo> getFoodInfoBySales_volume(int mid);
	
	public List<FoodInfo> getFoodInfoByMid(int mid);
	
	public List<FoodInfo> getRankingList();

	public void addGreat(FoodInfo food);

	public int getMidByFid(int fid);

	public void updateFsales_volume(FoodInfo food);

	//后台所需的5个接口
	public List<FoodInfo> getFoodInfo();

	public List<FoodInfo> getFoodInfoByRid(int rid);
	
	public List<FoodInfo> getFoodInfoByFid(int fid);

	public List<FoodInfo> getFoodInfoByFidOfRid(ForSearchOfRid fe);
	
	public void addFoodInfo(FoodInfo fi);
	
	public void deleteFoodInfo(int fid);
	
	public void updateFoodInfo(FoodInfo fi);
}
