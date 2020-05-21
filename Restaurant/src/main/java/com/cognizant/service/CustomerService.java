package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.CustomerDaoImpl;
import com.cognizant.model.Customer;

@Component
public class CustomerService {
	
	@Autowired
	private CustomerDaoImpl customer;

	public CustomerDaoImpl getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDaoImpl customer) {
		this.customer = customer;
	}
	
	public Customer find(String name,String password)
	{
		Customer customer2 = customer.find(name, password);
		return customer2;
	}

}
