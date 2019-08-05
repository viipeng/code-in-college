package com.digital.dao;

import java.util.List;

import com.digital.pojo.AddMoney;

public interface AddMoneyDAO {

	public void creatPetition(AddMoney am);

	public List<AddMoney> getAllRequest();

	public AddMoney getAddMoneyByAid(int aid);

	public void permit(AddMoney am);

	public void refuse(AddMoney am);

}
