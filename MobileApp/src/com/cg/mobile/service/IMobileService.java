package com.cg.mobile.service;

import java.util.List;

import com.cg.mobile.bean.Mobile;

public interface IMobileService {

	public String display();
	
	public List<Mobile> getMobileByPrice(double price);

	public List<Mobile> getAllMobiles();
	
	public String deleteMobile(int mobileId);
}
