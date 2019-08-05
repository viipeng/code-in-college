package com.digital.dao;

import com.digital.pojo.BossInfo;

public interface BossInfoDAO {

	public BossInfo getBossInfoByCode(BossInfo bi);

	public BossInfo getBossInfoByBid(int bid);

}
