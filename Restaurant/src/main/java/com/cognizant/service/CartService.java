package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.CartDaoImpl;
import com.cognizant.dao.CartEmptyException;
import com.cognizant.model.Cart;

@Component
public class CartService {

	@Autowired
	private CartDaoImpl cartdao;

	public CartDaoImpl getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDaoImpl cartdao) {
		this.cartdao = cartdao;
	}

	public void addCartItem(String userid, long menuItemId) {
		cartdao.addCartItem(userid, menuItemId);
	}

	public Cart getAllCartItems(String userid) throws CartEmptyException {
		Cart cart = cartdao.getAllCartItems(userid);
		System.out.println(cart);
		return cart;
	}

	public void removeCartItem(String userid, long menuItemId) {
		cartdao.removeCartItem(userid, menuItemId);
	}

}
