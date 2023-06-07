package com.cognizant.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Model class for storing user data in database
 *
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Entity(name = "user")
public class MyUser {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "id")
	private int userId;

//	@Column(name = "name")
//	@NotBlank(message = "User name cannot be empty")
	private String userName;

//	@NotBlank(message = "Password cannot be blank")
//	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String password;
//	@Enumerated(EnumType.STRING)
	private Role role;
	


}
