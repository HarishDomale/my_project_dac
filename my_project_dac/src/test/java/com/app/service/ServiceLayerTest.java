package com.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@SpringBootTest
public class ServiceLayerTest {

	@Autowired
	private IUserService userService;
	
	@Test
	void saveUser()
	{
		User transientuser=new User("Harish", "domaleharish@gmail.com", "harish@123");
		User persistentuser=userService.saveUser(transientuser);
		System.out.println();
		assertEquals(1, persistentuser.getId());
	}
	
	@Test
	void addAdminRole()
	{
		Role role1=userService.addRole(new Role(UserRole.ROLE_ADMIN));
		System.out.println(role1);
	}
	
	@Test
	void addHospitalRole()
	{
		Role role1=userService.addRole(new Role(UserRole.ROLE_HOSPITAL));
		System.out.println(role1);
	}
	
	@Test
	void addBenificiaryRole()
	{
		Role role1=userService.addRole(new Role(UserRole.ROLE_BENIFICIARY));
		System.out.println(role1);
	}
	
	@Test
	void linkUserRole()
	{
		System.out.println(userService.linkUserRole("Harish", UserRole.ROLE_ADMIN));
	}
}
