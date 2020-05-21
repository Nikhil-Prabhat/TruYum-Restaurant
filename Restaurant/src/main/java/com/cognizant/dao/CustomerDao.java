package com.cognizant.dao;

import com.cognizant.model.Customer;

public interface CustomerDao {
	
	public Customer find(String name, String password);

}
