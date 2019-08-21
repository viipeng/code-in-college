package com.digital.service;

import com.digital.pojo.BossInfo;

public interface BossInfoService {

	public BossInfo getBossInfoByCode(BossInfo bi);

	public BossInfo getBossInfoByBid(int bid);

}
