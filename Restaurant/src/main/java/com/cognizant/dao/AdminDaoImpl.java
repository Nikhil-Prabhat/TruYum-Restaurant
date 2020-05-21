package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.Admin;

@Component
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public Admin find(String email, String password) {
		Admin admin = null;
		try {
			String sql = "select * from admin_login where email=? and password=? ";
			admin = template.queryForObject(sql, new Object[] { email, password },
					(rs, rowNum) -> new Admin(rs.getString(1), rs.getString(2)));

		} catch (Exception e) {
			admin = null;
		}

		return admin;
	}

}
