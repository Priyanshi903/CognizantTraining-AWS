package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.InvalidTokenException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.feign.AuthFeign;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.userService;

@RequestMapping("/carts")
@RestController
public class CartController {
//	
	@Autowired
	private CartService cartService;

	@Autowired
	private userService userservice;

	@Autowired
	private AuthFeign authorisationClient;

	@GetMapping("/{userid}")
	public Cart getCartForUser(@RequestHeader(name = "Authorization") String token, @PathVariable String userid)
			throws CartEmptyException, InvalidTokenException {
		if (authorisationClient.validate(token)) {
			User user = userservice.getUser(userid);
			return (cartService.getCart(user));
		} else {
			throw new InvalidTokenException("You not logged in");
		}
	}

	@PostMapping("/{userid}/{menuItemId}")
	public Cart addcartItem(@RequestHeader(name = "Authorization") String token, @PathVariable String userid,
			@PathVariable long menuItemId) throws InvalidTokenException {
		if (authorisationClient.validate(token)) {
			return cartService.addcartItem(userid, menuItemId);
		} else {
			throw new InvalidTokenException("You not logged in");
		}
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public Cart removeCartItem(@RequestHeader(name = "Authorization") String token, @PathVariable String userId,
			@PathVariable long menuItemId) throws MenuItemNotFoundException, CartEmptyException, InvalidTokenException {
		if (authorisationClient.validate(token)) {
			cartService.removeCartItem(userId, menuItemId);
			return cartService.getCartForUser(userId);
		} else {
			throw new InvalidTokenException("You not logged in");
		}
	}

}
