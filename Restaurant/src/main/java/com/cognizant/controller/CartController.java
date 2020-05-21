package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cognizant.dao.CartEmptyException;
import com.cognizant.model.Cart;
import com.cognizant.model.MenuItem;
import com.cognizant.service.CartService;

@Controller
public class CartController 
{
	private static final Logger logger=LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private CartService cartdaoservice;

	public CartService getCartdaoservice() {
		return cartdaoservice;
	}

	public void setCartdaoservice(CartService cartdaoservice) {
		this.cartdaoservice = cartdaoservice;
	}
	
	@GetMapping("add-to-cart")
	public String addToCart(@RequestParam("menuitemid") long menuitemid,@RequestParam("username") String username,RedirectAttributes request)
	{
		
		System.out.println("yo");
		
		cartdaoservice.addCartItem(username, menuitemid);
		request.addAttribute("addcartstatus", true);
		request.addAttribute("username",username);
		request.addAttribute("menuitemid",menuitemid);
		
		return "redirect:show-menu-list-customer";
	}
	
	@GetMapping("show-cart")
	public String showCart(@RequestParam(required = false) boolean removecartstatus,@RequestParam("custid") String userid,ModelMap model) throws CartEmptyException
	{
		
		
		
		Cart allCartItems = cartdaoservice.getAllCartItems(userid);
	//	List<MenuItem> allCartItems = cartItems.getMenuItemList();
		model.put("userid", userid);
		
		if(allCartItems.getMenuItemList().isEmpty())
		{
			return "emptycart";
		}
		else
		{
			model.put("cartitems", allCartItems);
			model.put("removecartstatus", removecartstatus);
			return "cart";
		}
		
		
				
	}
	
	@GetMapping("remove-cart")
	public String removeCart(@RequestParam("menuid") int menuid,@RequestParam("userid") String userid,RedirectAttributes request)
	{
		request.addAttribute("removecartstatus", true);
		request.addAttribute("custid", userid);
		cartdaoservice.removeCartItem(userid, menuid);
		return "redirect:show-cart";
		
		
		
	}
	
	
	
}
