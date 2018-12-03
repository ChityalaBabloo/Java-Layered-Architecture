package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dao.MDAO;
import com.dao.MDAOImpl;
import com.exceptions.MobileException;
import com.model.Customer;

public class MserviceImpl implements MService {

	MDAO dao = new MDAOImpl();

	List<String> list = new ArrayList<String>();

	@Override
	public int storeDetails(Customer customer) throws MobileException {
		return dao.store(customer);
	}

	@Override
	public boolean validateFileds(Customer customer) throws MobileException {

		boolean flag = false;

		if (!validateMobileId(customer.getMobileId())) {
			list.add("mobile should be 3 digits");
		}

		if (!validateName(customer.getName())) {
			list.add("name length 6 to 20");
		}

		if (!list.isEmpty()) {
			flag = false;
			throw new MobileException(list + "");
		} else {
			flag = true;
		}
		return flag;

	}

	public boolean validateMobileId(int mobileId) {
		String mobileRegEx = "[0-9]{3}";
		Pattern pattern = Pattern.compile(mobileRegEx);
		Matcher matcher = pattern.matcher(String.valueOf(mobileId));
		return matcher.matches();
	}

	public boolean validateName(String name) {
		String nameRegEx = "[a-zA-Z]{6,20}";
		Pattern pattern = Pattern.compile(nameRegEx);
		Matcher matcher = pattern.matcher(name);
		return matcher.matches();
	}

}
