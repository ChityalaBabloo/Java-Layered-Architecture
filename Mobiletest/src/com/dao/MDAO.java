package com.dao;

import com.exceptions.MobileException;
import com.model.Customer;

public interface MDAO {

	int store(Customer customer) throws MobileException;

}
