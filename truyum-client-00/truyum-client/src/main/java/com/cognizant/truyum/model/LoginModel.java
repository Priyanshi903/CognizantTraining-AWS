package com.cognizant.truyum.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class LoginModel {

    @NotBlank(message = "Username cannot be empty.")
    private String userName;

    @NotBlank(message = "Password cannot be empty.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Password should contain alpha numeric values")
    private String password;

	public LoginModel() {
		super();
	}

	public LoginModel(@NotBlank(message = "Username cannot be empty.") String userName,
			@NotBlank(message = "Password cannot be empty.") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Password should contain alpha numeric values") String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
