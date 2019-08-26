package com.digital.entity;

public class ProductInfo {

	private int id;
	private String code;//商品编号
	private String name;//商品名称
	private Type type;//商品类型
	private String brand;//商品品牌
	private String pic;//商品图片
	private int num;//商品数量
	private double price;//商品价格
	private String intro;//商品简介
	private int status;//商品状态
	private String bigpic;//商品大图
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getBigpic() {
		return bigpic;
	}
	public void setBigpic(String bigpic) {
		this.bigpic = bigpic;
	}
	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductInfo [id=" + id + ", code=" + code + ", name=" + name
				+ ", type=" + type + ", brand=" + brand + ", pic=" + pic
				+ ", num=" + num + ", price=" + price + ", intro=" + intro
				+ ", status=" + status + ", bigpic=" + bigpic + "]\n";
	}
	
	
	
}
