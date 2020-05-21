package com.cognizant.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.MenuItem;
import com.cognizant.service.MenuItemService;

@Controller
public class MenuItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	private MenuItemService menuItemService;

	public MenuItemService getMenuItemService() {
		return menuItemService;
	}

	public void setMenuItemService(MenuItemService menuItemService) {
		this.menuItemService = menuItemService;
	}

	@GetMapping("show-menu-list-admin")
	public String showMenuItemListAdmin(ModelMap model) {
		LOGGER.info("start");
		List<MenuItem> menuItemListAdmin = menuItemService.getMenuItemListAdmin();
		model.put("adminlist", menuItemListAdmin);
		LOGGER.info("End");
		return "menu-item-list-admin";
	}
	
	@GetMapping("show-menu-list-customer")
	public String showMenuItemListCustomer(@RequestParam(required = false) boolean addcartstatus,@RequestParam("username") String username,@RequestParam(defaultValue = "0") long menuitemid ,ModelMap model) {
		LOGGER.info("start");
		List<MenuItem> menuItemListCustomer = menuItemService.getMenuItemListCustomer();
		model.put("customerlist", menuItemListCustomer);
		model.put("addcartstatus",addcartstatus);
		model.put("menuitemid", menuitemid);
		model.put("username", username);
		LOGGER.info("end");
		return "customer";
	}

	@GetMapping("show-edit-menu-item")
	public String showEditMenuItem(@RequestParam int id, ModelMap model) {
		LOGGER.info("Start");
		MenuItem menuItem = menuItemService.getMenuItem(id);
		model.put("menuitem", menuItem);
		LOGGER.info("End");
		return "editmenu";
	}
	

	@PostMapping("edit-menu-item")
	public String editMenuItem(@ModelAttribute("menuitem") MenuItem menuItem,BindingResult result)
	{
		LOGGER.info("Start");
		
		if(result.hasErrors())
		{
			System.out.println(result.toString());
			
			//menuItemService.modifyMenuItem(menuItem);
			return "editmenu";
		}
		else
		{
			//System.out.println(menuItem);
			menuItemService.modifyMenuItem(menuItem);
			return "editmenustatus";
		}
		
		
		
	}

	@ModelAttribute("categoryList")
	public List<String> getNumbersList() {
		List<String> numbersList = new ArrayList<>();
		numbersList.add("Starters");
		numbersList.add("Main Course");
		numbersList.add("Dessert");
		numbersList.add("Drinks");
		return numbersList;
	}

}
