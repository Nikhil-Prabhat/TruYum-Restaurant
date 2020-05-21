package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.cognizant.model.Customer;
import com.cognizant.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "getCustomerLoginPage",method = RequestMethod.GET)
	public ModelAndView showCustomerLoginPage(Customer customer) {
		System.out.println("This is customer login page");
		ModelAndView mv = new ModelAndView();
		mv.addObject("customer", customer);
		mv.setViewName("customer_login");
		return mv;

	}
	
	@RequestMapping(value = "submit_customer", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("customer") Customer customer,RedirectAttributes request) {
		System.out.println("This is authentication page");
		
		Customer find = customerService.find(customer.getName(), customer.getPassword());
		
		System.out.println(customer);

		if (find != null) 
		{
			
		request.addAttribute("username", find.getName());

		return "redirect:show-menu-list-customer";
		}
		
		return "wrongpass";

	
	}

}
