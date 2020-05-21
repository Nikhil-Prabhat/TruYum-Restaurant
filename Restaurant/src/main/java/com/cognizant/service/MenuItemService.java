package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.MenuItemDao;
import com.cognizant.model.MenuItem;

@Component
public class MenuItemService {
	@Autowired
	private MenuItemDao menuitemdao;

	public MenuItemDao getMenuitemdao() {
		return menuitemdao;
	}

	public void setMenuitemdao(MenuItemDao menuitemdao) {
		this.menuitemdao = menuitemdao;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		List<MenuItem> menuItemListAdmin = getMenuitemdao().getMenuItemListAdmin();
		return menuItemListAdmin;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = getMenuitemdao().getMenuItemListCustomer();
		return menuItemListCustomer;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		getMenuitemdao().modifyMenuItem(menuItem);
	}

	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = getMenuitemdao().getMenuItem(menuItemId);
		return menuItem;
	}

}
