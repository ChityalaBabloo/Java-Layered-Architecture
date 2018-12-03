package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exceptions.MobileException;
import com.model.Customer;
import com.utility.JdbcUtility;

public class MDAOImpl implements MDAO {

	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public int store(Customer customer) throws MobileException {

		int quantity = getQuantity(customer.getMobileId());
	
		connection = JdbcUtility.getConnection();

		int id = 0;

		if (customer.getQunatity() < quantity) {

			try {
				statement = connection
						.prepareStatement(QueryConstants.insertQuery);
				statement.setString(1, customer.getName());
				statement.setInt(2, customer.getMobileId());
				statement.setInt(3, customer.getQunatity());

				statement.executeUpdate();

				id = getId();

				statement = connection
						.prepareStatement(QueryConstants.updateQuery);
				statement.setInt(1, customer.getQunatity());
				statement.setInt(2, customer.getMobileId());
				statement.executeUpdate();

			} catch (SQLException e) {
				throw new MobileException("statement not created");
				//e.printStackTrace();
			}
		}

		return id;
	}

	public int getQuantity(int mobileId) throws MobileException {

		connection = JdbcUtility.getConnection();
		int quantity = 0;
		try {

			statement = connection
					.prepareStatement(QueryConstants.checkIdQuery);
			statement.setInt(1, mobileId);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();

			quantity = resultSet.getInt(1);

		} catch (SQLException exception) {
			throw new MobileException("statement not cretaed..");
			//exception.printStackTrace();
		}
		return quantity;

	}

	public int getId() throws MobileException {

		connection = JdbcUtility.getConnection();
		int id = 0;
		try {

			statement = connection.prepareStatement(QueryConstants.getId);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();

			id = resultSet.getInt(1);

		} catch (SQLException exception) {
			throw new MobileException("statement not cretaed..");
			//exception.printStackTrace();
		}
		return id;

	}

}
