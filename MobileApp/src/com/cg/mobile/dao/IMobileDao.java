package com.cg.mobile.dao;

import java.util.List;

import com.cg.mobile.bean.Mobile;

public interface IMobileDao {
	
	public String display();
	
	public List<Mobile> getMobileByPrice(double price);
	public List<Mobile> getAllMobiles();
	public String deleteMobile(int mobileId);
}
