package com.digital.dao;

import java.util.List;

import com.digital.pojo.Shopping_trolley_food;

public interface Shopping_trolley_foodDAO {

	public List<Shopping_trolley_food> getShopping_trolley_foodList(int sid);

	public Shopping_trolley_food getSTFoodBySidAndFId(Shopping_trolley_food stf);

	public void AddFoodToShopping_trolley(Shopping_trolley_food stf);

	public void UpdateAmountOfSTFood(Shopping_trolley_food stf);

	public Shopping_trolley_food getSTFInfoBySfid(int sfid);

	public void deleteSTFInfoBySfid(int sfid);

	public void DeleteSTFBySid(int sid);
	
	//ºóÌ¨
	public List<Shopping_trolley_food> getShopping_trolley_food();

	public void updateShopping_trolley_food(Shopping_trolley_food stf);

	public List<Shopping_trolley_food> getSTFListBySfid(int sfid);
	
}
