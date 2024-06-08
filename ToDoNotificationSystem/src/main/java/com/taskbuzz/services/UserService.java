package com.taskbuzz.services;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.taskbuzz.entities.User;
import com.taskbuzz.repository.UserRepository;
import com.taskbuzz.request.AddUserRequest;





@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public UserService() {
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}


	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		return userRepository.save(user);

	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
	}

	public User addUser(AddUserRequest userRequest) {
		
		User user = new User();
		user.setname(userRequest.getUsername());	
		user.setEmailId(userRequest.getEmailId());
		user.setPassword(userRequest.getPassword());
		user.setRole(userRequest.getRole());
		return userRepository.save(user);
	}
}
