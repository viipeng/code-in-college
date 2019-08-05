package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.RestaurantInfoDAO;
import com.digital.pojo.Pagination;
import com.digital.pojo.RestaurantInfo;
import com.digital.service.RestaurantInfoService;

@Service("restaurantInfoService")
public class RestaurantInfoServiceImpl implements RestaurantInfoService {

	@Autowired
	private RestaurantInfoDAO restaurantInfoDao;


	@Override
	public int selectRestaurantNum() {
		return restaurantInfoDao.selectRestaurantNum();
	}

	@Override
	public List<RestaurantInfo> getRestaurantInfoByBid(int bid){
		return restaurantInfoDao.getRestaurantInfoByBid(bid);
	}

	/*@Override
	public List<RestaurantInfo> PageRestaurantInfo(Pagination pagination)
	{
		return restaurantInfoDao.PageRestaurantInfo(pagination);
	}*/

	@Override
	public List<RestaurantInfo> getRrestaurantInfo(){
		return restaurantInfoDao.getRrestaurantInfo();
	}

	@Override
	public List<RestaurantInfo> searchRestaurant(String name){
		return restaurantInfoDao.searchRestaurant(name);
	}

	@Override
	public List<RestaurantInfo> selectByArrival(){
		return restaurantInfoDao.selectByArrival();
	}

	@Override
	public List<RestaurantInfo> selectByMinute(){
		return restaurantInfoDao.selectByMinute();
	}

	@Override
	public List<RestaurantInfo> selectByStar(){
		return restaurantInfoDao.selectByStar();
	}

	@Override
	public List<RestaurantInfo> selectBySending_fee(){
		return restaurantInfoDao.selectBySending_fee();
	}

	@Override
	public List<RestaurantInfo> selectByShipping_fee(){
		return restaurantInfoDao.selectByShipping_fee();
	}

	@Override
	public List<RestaurantInfo> selectByCpc(){
		return restaurantInfoDao.selectByCpc();
	}

	@Override
	public List<RestaurantInfo> selectByCpc1(){
		return restaurantInfoDao.selectByCpc1();
	}

	@Override
	public List<RestaurantInfo> selectBySales_volume(){
		return restaurantInfoDao.selectBySales_volume();
	}

	@Override
	public List<RestaurantInfo> selectByDistance(){
		return restaurantInfoDao.selectByDistance();
	}

	@Override
	public void updateDisAndMin(RestaurantInfo ri) {
		restaurantInfoDao.updateDisAndMin(ri);
	}

	@Override
	public void updateRstar(RestaurantInfo restaurant) {
		restaurantInfoDao.updateRstar(restaurant);
	}

	@Override
	public void updateSalesAndCpc(RestaurantInfo restaurant) {
		restaurantInfoDao.updateSalesAndCpc(restaurant);
	}

	@Override
	public List<RestaurantInfo> getRestaurantInfoByRid(int rid) {
		return restaurantInfoDao.getRestaurantInfoByRid(rid);
	}

	@Override
	public List<RestaurantInfo> getRestaurantInfo() {
		return restaurantInfoDao.getRestaurantInfo();
	}

	@Override
	public void addRestaurantInfo(RestaurantInfo ri) {
		restaurantInfoDao.addRestaurantInfo(ri);
	}

	@Override
	public void deleteRestaurantInfo(int rid) {
		restaurantInfoDao.deleteRestaurantInfo(rid);
	}

	@Override
	public void updateRestaurantInfo(RestaurantInfo ri) {
		restaurantInfoDao.updateRestaurantInfo(ri);
	}
}
