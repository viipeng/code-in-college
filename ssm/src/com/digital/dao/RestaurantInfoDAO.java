package com.digital.dao;
import java.util.List;

import com.digital.pojo.BossInfo;
import com.digital.pojo.Pagination;
import com.digital.pojo.RestaurantInfo;

public interface RestaurantInfoDAO {

	public List<RestaurantInfo> getRestaurantInfoByBid(int bid);
	
	public int selectRestaurantNum();
	
//	public List<RestaurantInfo> PageRestaurantInfo(Pagination pagination);

	public List<RestaurantInfo> getRrestaurantInfo();
	
	public List<RestaurantInfo> searchRestaurant(String name);
	
	public List<RestaurantInfo> selectByArrival();
	
	public List<RestaurantInfo> selectByMinute();
	
	public List<RestaurantInfo> selectByStar();
	
	public List<RestaurantInfo> selectBySending_fee();
	
	public List<RestaurantInfo> selectByShipping_fee();

	public List<RestaurantInfo> selectByCpc();

	public List<RestaurantInfo> selectByCpc1();

	public List<RestaurantInfo> selectBySales_volume();

	public List<RestaurantInfo> selectByDistance();
	
	public void updateDisAndMin(RestaurantInfo ri);

	public void updateRstar(RestaurantInfo restaurant);

	public void updateSalesAndCpc(RestaurantInfo restaurant);
	
	//以下是后台的5个方法
	public List<RestaurantInfo> getRestaurantInfoByRid(int rid);
	
	public List<RestaurantInfo> getRestaurantInfo();
	
	public void addRestaurantInfo(RestaurantInfo ri);
	
	public void deleteRestaurantInfo(int rid);
	
	public void updateRestaurantInfo(RestaurantInfo ri);
}
