package com.stackssimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stackssimplify.restservices.entity.User;
import com.stackssimplify.restservices.exceptions.UserExistException;
import com.stackssimplify.restservices.exceptions.UserNotFoundException;
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
	
	
	public User createUser (User user) throws UserExistException {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser != null) {
			throw new UserExistException("User already existing repository");
		}
		return userRepository.save(user);
	}
	
	//getUserBy Id
	public Optional<User> getUsetById (Long id) throws UserNotFoundException {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User not found in user repository");
			
		}
		return user;
	}
	
	//Update user by Id
	public User updateUserById(Long id, User user)throws UserNotFoundException {
Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new UserNotFoundException("User not found in user repository, provide the correct User ID");
		}
		user.setId(id);
		return userRepository.save(user);
	}
	
	//delete user by id
	public void deleteUserById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in user repository, provide the correct User ID");
		}
		userRepository.deleteById(id);
	}
	
	//find by user name
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	

}
