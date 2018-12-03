package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.exceptions.MobileException;

public class JdbcUtility {

	private static Connection connection = null;

	public static Connection getConnection() throws MobileException {

		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new MobileException("class not loaded.");
		}

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "system",
					"Capgemini123");
		} catch (SQLException exception) {
			throw new MobileException("connection issue");
		}
		return connection;

	}

}
