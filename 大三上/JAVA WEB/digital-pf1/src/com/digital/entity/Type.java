package com.digital.entity;

import java.util.HashSet;
import java.util.Set;

public class Type {

	private int id;
	private String name;
	private Set<ProductInfo> pis = new HashSet<ProductInfo>(0);
	public Type(){
	}
	
	public Set<ProductInfo> getPis() {
		return pis;
	}

	public void setPis(Set<ProductInfo> pis) {
		this.pis = pis;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Type [id=" + id + ", name=" + name  + "]\n";
	}

	
	
	
}
