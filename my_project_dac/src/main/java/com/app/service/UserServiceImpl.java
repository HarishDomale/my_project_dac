package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.dao.RoleRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.pojos.UserRole;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder encoder;

	

	@Override
	public User saveUser(User user) {
		System.out.println("save user"+user);
		user.setActive(true);
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public String linkUserRole(String userName, UserRole roleName) {
		//get user from user name
		User user=userRepo.findByUserName(userName).orElseThrow(()->new RuntimeException("User Not Found!!!"));
		
		Role userRole=roleRepo.findByRole(roleName).orElseThrow(()->new RuntimeException("Role Not Found!!!"));
		
		user.getRoles().add(userRole);
		return "Link Role to User...";
	}
	
	
	
	

	

}
