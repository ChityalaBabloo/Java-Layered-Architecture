package com.main;

import com.exceptions.MobileException;
import com.model.Customer;

public interface MService {

	public int storeDetails(Customer customer) throws MobileException;

	public boolean validateFileds(Customer customer) throws MobileException;
}
