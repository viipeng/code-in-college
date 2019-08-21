package com.digital.pojo;

public class MerchantInfo {

	private int mnid;
	private String merchantName;
	private String mpassword;
	private float account_balance;
	private int rid;
	public int getMnid() {
		return mnid;
	}
	public void setMnid(int mnid) {
		this.mnid = mnid;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public float getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(float account_balance) {
		this.account_balance = account_balance;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "MerchantInfo [mnid=" + mnid + ", merchantName=" + merchantName
				+ ", account_balance=" + account_balance + ", mpassword="
				+ mpassword + ", rid=" + rid + "]";
	}
	
}
