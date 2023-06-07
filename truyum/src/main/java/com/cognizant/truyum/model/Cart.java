package com.cognizant.truyum.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.truyum.feign.AuthFeign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private long cart_id;
	
	@OneToOne
	@JoinTable(name = "user_cart", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = {
			@JoinColumn(name = "username") })
	private User user;
	
//	private String userName;

	@ManyToMany
	@JoinTable(name = "cart_menu", joinColumns = {
			@JoinColumn(name = "cart_id") }, inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private List<MenuItem> menuItemList;
	private double total;

	public void setTotal(Double total) {
		BigDecimal bd = new BigDecimal(total).setScale(2, RoundingMode.FLOOR);
		this.total = bd.doubleValue();
	}

}