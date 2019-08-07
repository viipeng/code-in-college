package com.digital.service;

import java.util.List;

import com.digital.pojo.AddMoney;

public interface AddMoneyService {

	public void creatPetition(AddMoney am);

	public List<AddMoney> getAllRequest();

	public AddMoney getAddMoneyByAid(int aid);

	public void permit(AddMoney am);

	public void refuse(AddMoney am);

}
