package com.cognizant.dao;

import com.cognizant.model.Admin;

public interface AdminDao {
	
	public Admin find(String email, String password);

}
