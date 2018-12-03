package com.capgemini.tcc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.exception.ClinicApplicationException;
import com.capgemini.tcc.utility.JdbcUtility;


public class PatientDAO implements IPatientDAO {
	
	static Logger log = Logger.getLogger(PatientDAO.class);
	
	Connection con = null;
	PreparedStatement ps = null;
	
	@Override
	public int addPatientDetails(PatientBean patient) throws ClinicApplicationException {
			
		log.info("addPatientDetails method in dao.....");
		
		int patientId = 0;
		
		con = JdbcUtility.getConnection();
		
		try {
			ps = con.prepareStatement(QueryConstants.insertQuery);
			ps.setString(1, patient.getPatientName());
			ps.setInt(2, patient.getAge());
			ps.setLong(3, patient.getPhone());
			ps.setString(4, patient.getDescription());
			ps.executeUpdate();
			
			ps  = con.prepareStatement(QueryConstants.getIdQuery);
			ResultSet resultSet = ps.executeQuery();
			resultSet.next();

			patientId = resultSet.getInt(1);
		} catch (SQLException e) {
			log.error("PreparedStatatement not created in dao..");
			throw new ClinicApplicationException("PreparedStatatement not created in dao..");
			
		}
		return patientId;
	}

	@Override
	public PatientBean getPatientDetails(int patientId) throws ClinicApplicationException {
		
		log.info("getPatientDetails method in dao.....");
		
		con = JdbcUtility.getConnection();
		
		PatientBean patient = null;
		try {
			ps = con.prepareStatement(QueryConstants.getPatientQuery);
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				patient = new PatientBean();
				patient.setPatientId(rs.getInt(1));
				patient.setPatientName(rs.getString(2));
				patient.setAge(rs.getInt(3));
				patient.setPhone(rs.getLong(4));
				patient.setDescription(rs.getString(5));
				patient.setConsultationDate(rs.getDate(6));
				
				return patient;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
