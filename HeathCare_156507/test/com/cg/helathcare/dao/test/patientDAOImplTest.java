package com.cg.helathcare.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.healthcare.model.Patient;
import com.cg.helathcare.dao.PatientDAO;
import com.cg.helathcare.dao.patientDAOImpl;
import com.cg.helathcare.exceptions.HealthCareException;

public class patientDAOImplTest {

	PatientDAO dao = null;

	@Before
	public void setUp() {
		dao = new patientDAOImpl();
	}

	@After
	public void tearDown() {
		dao = null;
	}

	@Test
	public void testFixAppointment() {

		Patient patient = new Patient();
		patient.setMobileNo(90909099876l);
		patient.setProblem("ENT");
		patient.setName("Ravikumar");

		try {
			Integer id = dao.fixAppointment(patient);
			assertNotNull(id);

		} catch (HealthCareException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testGetDoctorName() {

		Patient patient = new Patient();
		patient.setProblem("ENT");

		try {
			String doctor = dao.getDoctorName(patient.getProblem());
			assertEquals("siva", doctor);
		} catch (HealthCareException e) {
			e.printStackTrace();
		}

	}

}
