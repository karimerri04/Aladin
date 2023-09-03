package com.karimerri.aladin_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.karimerri.aladin_api.entities.User;
import com.karimerri.aladin_api.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		final User user = userRepository.findByEmail(username);
		if (user == null)
			throw new UsernameNotFoundException(username);
		return new UserDetailsImpl(user);
	}
}
