package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.model.Admin;
import com.cognizant.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value = "getIndexPage", method = RequestMethod.GET)
	public ModelAndView showIndexPage() {
		ModelAndView mv = new ModelAndView();
		System.out.println("In the index page");
		mv.setViewName("index");

		return mv;

	}

	@RequestMapping(value = "getUserLoginPage",method = RequestMethod.GET)
	public ModelAndView showUserLoginPage(Admin admin) {
		System.out.println("This is admin login page");
		ModelAndView mv = new ModelAndView();
		mv.addObject("admin", admin);
		mv.setViewName("admin_login");
		return mv;

	}
	
	@RequestMapping(value = "submit_admin", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("admin") Admin admin,RedirectAttributes request) {
		System.out.println("This is authentication page");
		
		Admin find = getAdminService().find(admin.getEmail(), admin.getPassword());
		System.out.println(admin);

		if (find != null) 
		{

		return "redirect:show-menu-list-admin";
		}
		else
		{
			return "wrongpass";
		}

	
	}

	


}
