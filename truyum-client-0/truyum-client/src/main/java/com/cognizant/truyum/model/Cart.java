package com.cognizant.truyum.model;


import java.util.List;

public class Cart {
	private long cartId;
	private List<MenuItem> menuItem;
	private User user;

	public Cart() {
		super();
	}

	public Cart(long cartId, List<MenuItem> menuItem, User user) {
		super();
		this.cartId = cartId;
		this.menuItem = menuItem;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	

	public List<MenuItem> getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(List<MenuItem> menuItem) {
		this.menuItem = menuItem;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", menuItem=" + menuItem + ", user=" + user + "]";
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

}
