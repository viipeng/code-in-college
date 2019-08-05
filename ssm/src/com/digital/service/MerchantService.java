package com.digital.service;

import com.digital.pojo.MerchantInfo;

public interface MerchantService {

    public MerchantInfo getMerchantByCode(MerchantInfo mi);
    
    public float queryAccount(int rid);

    public void changePassword(MerchantInfo mi);

    public String getPasswordByRid(int rid);

    public MerchantInfo getMerchantByRid(int rid);

    public void haveRefund(MerchantInfo mi);

    public String getNameByRid(int rid);

    public void addMoney(MerchantInfo mi);

}
