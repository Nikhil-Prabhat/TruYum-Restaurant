package com.cognizant.dao;

import com.cognizant.model.Cart;

public interface CartDao {
	
	public void addCartItem(String userid, long menuItemId);
	
	public Cart getAllCartItems(String userid) throws CartEmptyException;
	
	public void removeCartItem(String userid, long menuItemId);

}
