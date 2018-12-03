package com.cg.core;

import static org.junit.Assert.*;

import  org.junit.Test;

import com.cg.bank.bean.DemandDraft;
import com.cg.bank.dao.DemandDraftDAO;

public class JunitTest {
	@Test
	public void testAddDemandDraftDetails(){
		
		DemandDraft demandDraft = new DemandDraft();
		demandDraft.setName("Test");
		demandDraft.setMobile("9876543210");
		demandDraft.setForName("RR Estates");
		demandDraft.setDdAmount(500000);
		demandDraft.setRemarks("Test Remark");
		demandDraft.setCommission(306);
		
		DemandDraftDAO test = new DemandDraftDAO();
		
		assertEquals(10003, test.addDemandDraftDetails(demandDraft));
	}
}
