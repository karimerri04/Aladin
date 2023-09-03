package com.karimerri.aladin_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.karimerri.aladin_api.entities.User;
import com.karimerri.aladin_api.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User getUserByOpt(int otpnum) {
		return userRepository.getUserByOpt(otpnum);
	}

}
