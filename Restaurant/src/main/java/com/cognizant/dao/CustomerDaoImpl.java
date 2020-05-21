package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import com.cognizant.model.Customer;

@Component
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	@Override
	public Customer find(String name, String password) {
		
		Customer customer = null;
		try {
			String sql = "select * from customer_login where name=? and password=? ";
			customer = template.queryForObject(sql, new Object[] { name, password },
					(rs, rowNum) -> new Customer(rs.getString(1), rs.getString(2)));

		} catch (Exception e) {
			customer = null;
		}

		return customer;
	}

	
}
