package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.FoodInfoDAO;
import com.digital.pojo.FoodInfo;
import com.digital.pojo.ForSearchFood;
import com.digital.pojo.ForSearchOfRid;
import com.digital.service.FoodInfoService;

@Service("foodInfoService")
public class FoodInfoServiceImpl implements FoodInfoService{

	@Autowired
	private FoodInfoDAO foodInfoDao;

	@Override
	public List<FoodInfo> searchFood(ForSearchFood forSearchFood) {
		return foodInfoDao.searchFood(forSearchFood);
	}

	@Override
	public List<FoodInfo> getFoodInfoByPrice(int mid) {
		return foodInfoDao.getFoodInfoByPrice(mid);
	}

	@Override
	public List<FoodInfo> getFoodInfoByPrice1(int mid) {
		return foodInfoDao.getFoodInfoByPrice1(mid);
	}

	@Override
	public List<FoodInfo> getFoodInfoBySales_volume(int mid) {
		return foodInfoDao.getFoodInfoBySales_volume(mid);
	}

	@Override
	public List<FoodInfo> getFoodInfoByMid(int mid) {
		return foodInfoDao.getFoodInfoByMid(mid);
	}

	@Override
	public List<FoodInfo> getRankingList() {
		return foodInfoDao.getRankingList();
	}

	@Override
	public void addGreat(FoodInfo food) {
		foodInfoDao.addGreat(food);
	}

	@Override
	public int getMidByFid(int fid){
		return foodInfoDao.getMidByFid(fid);
	}

	@Override
	public void updateFsales_volume(FoodInfo food){
		foodInfoDao.updateFsales_volume(food);
	}
	
	@Override
	public List<FoodInfo> getFoodInfo() {
		return foodInfoDao.getFoodInfo();
	}

	@Override
	public List<FoodInfo> getFoodInfoByRid(int rid) {
		return foodInfoDao.getFoodInfoByRid(rid);
	}

	@Override
	public List<FoodInfo> getFoodInfoByFid(int fid) {
		return foodInfoDao.getFoodInfoByFid(fid);
	}

	@Override
	public List<FoodInfo> getFoodInfoByFidOfRid(ForSearchOfRid fe) {
		return foodInfoDao.getFoodInfoByFidOfRid(fe);
	}

	@Override
	public void addFoodInfo(FoodInfo fi) {
		foodInfoDao.addFoodInfo(fi);
	}

	@Override
	public void deleteFoodInfo(int fid) {
		foodInfoDao.deleteFoodInfo(fid);
	}

	@Override
	public void updateFoodInfo(FoodInfo fi) {
		foodInfoDao.updateFoodInfo(fi);
	}

}
