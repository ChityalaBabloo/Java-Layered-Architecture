package com.capgemini.tcc.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.tcc.bean.PatientBean;
import com.capgemini.tcc.dao.PatientDAO;
import com.capgemini.tcc.exception.ClinicApplicationException;

public class PatientDAOTest {

	PatientDAO dao = null;
	
	@Before
	public void setUp() {
		dao = new PatientDAO();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	public void testaddPatientDetails() {
		
		PatientBean patient = new PatientBean();
		patient.setPatientName("Smith");
		patient.setAge(35);
		patient.setPhone(9768587350l);
		patient.setDescription("sufferong from fever");
		
		try {
			Integer id = dao.addPatientDetails(patient);
			assertNotNull(id);
		} catch (ClinicApplicationException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetPatientDetails() {
		PatientBean patient = null;
		dao = new PatientDAO();
		try {
			patient = dao.getPatientDetails(1000);
			assertEquals("Smith",patient.getPatientName());
			
		} catch (ClinicApplicationException e) {
			e.printStackTrace();
		}
		}

}
