package com.dao;

public class QueryConstants {

	public static final String insertQuery = "insert into cusomer values(mobile_seq.nextval,?,?,?)";
	public static final String checkIdQuery = "select quantity from mobile_test where mobileid=?";
	public static final String getId = "select max(id) from cusomer";
	public static final String updateQuery = "update mobile_test set quantity=quantity-? where mobileid=?";
}
