package com.digital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digital.dao.Shopping_trolley_foodDAO;
import com.digital.pojo.Shopping_trolley_food;
import com.digital.service.Shopping_trolley_foodService;

@Service("shopping_trolley_foodService")
public class Shopping_trolley_foodServiceImpl implements
		Shopping_trolley_foodService {

	@Autowired
	private Shopping_trolley_foodDAO shopping_trolley_foodDao;
	
	@Override
	public List<Shopping_trolley_food> getShopping_trolley_foodList(int sid) {
		return shopping_trolley_foodDao.getShopping_trolley_foodList(sid);
	}

	@Override
	public Shopping_trolley_food getSTFoodBySidAndFId(Shopping_trolley_food stf) {
		return shopping_trolley_foodDao.getSTFoodBySidAndFId(stf);
	}

	@Override
	public void AddFoodToShopping_trolley(Shopping_trolley_food stf) {
		shopping_trolley_foodDao.AddFoodToShopping_trolley(stf);
	}

	@Override
	public void UpdateAmountOfSTFood(Shopping_trolley_food stf) {
		shopping_trolley_foodDao.UpdateAmountOfSTFood(stf);
	}

	@Override
	public Shopping_trolley_food getSTFInfoBySfid(int sfid) {
		return shopping_trolley_foodDao.getSTFInfoBySfid(sfid);
	}

	@Override
	public void deleteSTFInfoBySfid(int sfid) {
		shopping_trolley_foodDao.deleteSTFInfoBySfid(sfid);
	}

	@Override
	public void DeleteSTFBySid(int sid) {
		shopping_trolley_foodDao.DeleteSTFBySid(sid);
	}

	@Override
	public List<Shopping_trolley_food> getShopping_trolley_food() {
		return shopping_trolley_foodDao.getShopping_trolley_food();
	}

	@Override
	public void updateShopping_trolley_food(Shopping_trolley_food stf) {
		shopping_trolley_foodDao.updateShopping_trolley_food(stf);
	}

	@Override
	public List<Shopping_trolley_food> getSTFListBySfid(int sfid) {
		return shopping_trolley_foodDao.getSTFListBySfid(sfid);
	}

}
