package com.cg.mobile.service;

import java.util.List;

import com.cg.mobile.bean.Mobile;
import com.cg.mobile.dao.IMobileDao;
import com.cg.mobile.dao.MobileDaoImpl;

public class MobileServiceImpl implements IMobileService{
	
	IMobileDao dao = new MobileDaoImpl();
	
	public String display() {
		return dao.display();
	}

	@Override
	public List<Mobile> getMobileByPrice(double price) {
		return dao.getMobileByPrice(price);
	}

	@Override
	public List<Mobile> getAllMobiles() {
		// TODO Auto-generated method stub
		return dao.getAllMobiles();
	}

	@Override
	public String deleteMobile(int mobileId) {
		return dao.deleteMobile(mobileId);
	}
}
