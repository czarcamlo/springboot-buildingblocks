package com.stackssimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackssimplify.restservices.entity.User;
import com.stackssimplify.restservices.repository.UserRepository;



@Service
public class UserService {
	//Autowired the UserRepository -
	@Autowired
	private UserRepository userRepository;
	
	//getAllUser method
	public List<User> getAllUsers(){
		return userRepository.findAll();
		}
	
	public User createUser (User user) {
		return userRepository.save(user);
	}
	
	//getUserBy Id
	
	public Optional<User> getUsetById (Long id) {
		Optional<User> user = userRepository.findById(id);
		
		return user;
	}
	
	//Update user by Id
	public User updateUserById(Long id, User user) {
		user.setId(id);
		return userRepository.save(user);
	}
	//delete user by id
	public void deleteUserById(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
	//find by user name
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	

}
