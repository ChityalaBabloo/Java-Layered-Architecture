package com.cg.mobile.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cg.mobile.bean.Mobile;

public class MobileDaoImpl implements IMobileDao {
	
	@Override
	public String display() {
		return "Mobile App Interface";
	}

	@Override
	public List<Mobile> getMobileByPrice(double price) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String pwd = "Capgemini123";
			Connection con = DriverManager.getConnection (url,user,pwd);
			//System.out.println("connected");
			String sql = "Select * from mobiles where price >= ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, price);
			ResultSet rs = ps.executeQuery();
			Mobile m = null;
			List<Mobile> list = new ArrayList();
			while(rs.next()) {
				m = new Mobile();
				m.setMobileId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getDouble(3));
				m.setQuantity(rs.getString(4));
				list.add(m);
			}
			return list;
		}
		catch(Exception e) {}
		return null;
	}

	@Override
	public List<Mobile> getAllMobiles() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String pwd = "Capgemini123";
			Connection con = DriverManager.getConnection (url,user,pwd);
			//System.out.println("connected");
			String sql = "Select * from mobiles";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Mobile m = null;
			List<Mobile> list = new ArrayList();
			while(rs.next()) {
				m = new Mobile();
				m.setMobileId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getDouble(3));
				m.setQuantity(rs.getString(4));
				list.add(m);
			}
			return list;
		}
		catch(Exception e) {}
		return null;
	}

	@Override
	public String deleteMobile(int mobileId) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "system";
			String pwd = "Capgemini123";
			Connection con = DriverManager.getConnection (url,user,pwd);
			//System.out.println("connected");
			String sql = "delete from mobiles where mobileid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, mobileId);
			ps.executeUpdate();
			return ("Successfully deleted Mobile With Id: "+mobileId);
		}
		catch(Exception e) {}
		return null;
	}
}
