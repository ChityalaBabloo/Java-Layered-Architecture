package com.cg.helathcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.exceptions.HealthCareException;
import com.cg.helathcare.utility.JdbcUtility;

public class patientDAOImpl implements PatientDAO {

	static Logger logger = Logger.getLogger(patientDAOImpl.class);

	Connection connection = null;
	PreparedStatement statement = null;

	@Override
	public int fixAppointment(Patient patient) throws HealthCareException {

		logger.info("in fix appoiment method..");

		int patientId = 0;

		connection = JdbcUtility.getConnection();

		String doctorname = getDoctorName(patient.getProblem());

		if (doctorname != null) {

			try {
				statement = connection.prepareStatement(QueryConstants.insertQuery);
				statement.setString(1, patient.getName());
				statement.setLong(2, patient.getMobileNo());
				statement.setString(3, doctorname);
				statement.setString(4, patient.getProblem());
				statement.executeUpdate();

				statement = connection.prepareStatement(QueryConstants.getIdQuery);
				ResultSet resultSet = statement.executeQuery();
				resultSet.next();

				patientId = resultSet.getInt(1);

			} catch (SQLException e) {
				logger.error("statement not created..");
				throw new HealthCareException("statement not created");

			}
		} else {
			logger.info("no doctor present with the given problem");
			throw new HealthCareException("no doctor present for the given problem");
		}

		return patientId;

	}

	public String getDoctorName(String problemName) throws HealthCareException {

		logger.info("in doctor mehtod..");

		connection = JdbcUtility.getConnection();
		String doctorName = "";
		try {
			statement = connection.prepareStatement(QueryConstants.selectDoctorNameQuery);
			statement.setString(1, problemName);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();

			doctorName = resultSet.getString(1);

		} catch (SQLException e) {
			logger.error("in doctor method ex is: " + e.getMessage());
			throw new HealthCareException("statement not created..");
		}

		return doctorName;

	}

}
