package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.UserDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.feign.AuthFeign;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private MenuItemDao menuItemDao;
	
	@Autowired
	private AuthFeign authFeign;
	
	
	public Cart getCart(User user) {
		return(cartDao.findByUser(user));
	}

	public Cart getCartForUser(String userid)  {
		User user = authFeign.getUser(userid);
		return cartDao.findByUser(user);
	}

	public Cart addcartItem(String userid, long menuItemId) {
		User user = authFeign.getUser(userid);
		System.out.println("-----------"+user);
		MenuItem menuItem = menuItemDao.findById(menuItemId).get();
		Cart cart = cartDao.findByUser(user);
		System.out.println(user);
		if(cart==null) {
			
			cart=new Cart(menuItemId, user, new ArrayList<>(), 0);

		}
		cart.getMenuItemList().add(menuItem);
		cart.setTotal(cart.getMenuItemList().stream().collect(Collectors.summingDouble(m->m.getPrice())));
		return cartDao.save(cart);
	}

	public void removeCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		User user = authFeign.getUser(userId);
		Cart cart=cartDao.findByUser(user);
		MenuItem menuItem = menuItemDao.findById(menuItemId).get();
		cart.getMenuItemList().remove(menuItem);
		cartDao.saveAndFlush(cart);
		
	}
	
}
