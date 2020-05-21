package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.Admin;
import com.cognizant.model.MenuItem;

@Component
public class MenuItemDaoImpl implements MenuItemDao {

	@Autowired
	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		List<MenuItem> menuList = new ArrayList<>();
		try {
			String sql = "select * from menu";
			menuList = template.query(sql, (rs, rowNum) -> new MenuItem(rs.getLong(1), rs.getString(2), rs.getString(3),
					rs.getFloat(4), rs.getBoolean(5), rs.getDate(6), rs.getString(7), rs.getBoolean(8)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuList = new ArrayList<>();
		String sql = "select * from menu where active=1 and dateOfLaunch < CURDATE()";

		try {
			menuList = template.query(sql, (rs, rowNum) -> new MenuItem(rs.getLong(1), rs.getString(2), rs.getString(3),
					rs.getFloat(4), rs.getBoolean(5), rs.getDate(6), rs.getString(7), rs.getBoolean(8)));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		String sql = "update menu set name=?,price=?,active=?,dateOfLaunch=?,category=?,freeDelivery=? where id=?";
		int update = template.update(sql, menuItem.getName(), menuItem.getPrice(), menuItem.isActive(),
				menuItem.getDateOfLaunch(), menuItem.getCategory(), menuItem.isFreeDelivery(),menuItem.getId());
		System.out.println("Total record inserted: " + update);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuitem = null;

		try {
			String sql = "select * from menu where id=?";
			menuitem = template.queryForObject(sql, new Object[] { menuItemId },
					(rs, rowNum) -> new MenuItem(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getFloat(4),
							rs.getBoolean(5), rs.getDate(6), rs.getString(7), rs.getBoolean(8)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuitem;
	}

}
