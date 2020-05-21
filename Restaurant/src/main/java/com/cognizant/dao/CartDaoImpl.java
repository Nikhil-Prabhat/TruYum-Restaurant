package com.cognizant.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.Cart;
import com.cognizant.model.MenuItem;

@Component
public class CartDaoImpl implements CartDao {

	@Autowired
	private JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	@Override
	public void addCartItem(String userid, long menuItemId) {
		
		String sql = "insert into cart values(?,?)";
		int update = template.update(sql,userid,menuItemId);
		System.out.println("Total record inserted: " + update);
		
	}

	@Override
	public Cart getAllCartItems(String userid) throws CartEmptyException {
		String sql = "select * from menu where id in (select id from cart where userid = ?)";
		List<Map<String, Object>> queryForList = template.queryForList(sql,userid); 
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		for(Map<String,Object> m : queryForList)
		{
			MenuItem menu = new MenuItem();
			menu.setId((int) m.get("id"));
			menu.setPic((String) m.get("pic"));
			menu.setName((String)m.get("name"));
			menu.setPrice((float)m.get("price"));
			menu.setActive((boolean) m.get("active"));
			menu.setDateOfLaunch((Date)m.get("dateOfLaunch"));
			menu.setCategory((String)m.get("category"));
			menu.setFreeDelivery((boolean)m.get("freeDelivery"));
			
			menuItemList.add(menu);
		}
		
		
		Cart cart = new Cart();
		cart.setMenuItemList(menuItemList);
		
		Double cost = 0.0;
		
		for(MenuItem m : menuItemList)
		{
			cost += m.getPrice();
		}
		
		cart.setTotal(cost);
		
		return cart;
				
	}

	@Override
	public void removeCartItem(String userid, long menuItemId) {
		
		String sql = "delete from cart where id=? and userid=?";
		
		int update = template.update(sql,menuItemId,userid);
		System.out.println("Total rows deleted" + update);
		
	}

	

}
