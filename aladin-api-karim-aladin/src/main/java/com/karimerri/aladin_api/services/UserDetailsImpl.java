package com.karimerri.aladin_api.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.karimerri.aladin_api.entities.Role;
import com.karimerri.aladin_api.entities.User;

public class UserDetailsImpl implements UserDetails, UserDetailsService {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private final Collection<? extends GrantedAuthority> authorities;

	private final String email;
	private final String password;
	private final boolean enabled;

	public UserDetailsImpl(User user) {
		email = user.getEmail();
		password = user.getPasswordHash();
		authorities = translate(user.getRoles());
		enabled = user.isStatus();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		if (enabled)
			return true;
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Translates the List<Role> to a List<GrantedAuthority>
	 *
	 * @param roles the input list of roles.
	 * @return a list of granted authorities
	 */
	private Collection<? extends GrantedAuthority> translate(List<Role> roles) {
		final List<GrantedAuthority> authorities = new ArrayList<>();
		for (final Role role : roles) {
			String name = role.getName().toUpperCase();
			// Make sure that all roles start with "ROLE_"
			if (!name.startsWith("ROLE_"))
				name = "ROLE_" + name;
			authorities.add(new SimpleGrantedAuthority(name));
		}
		return authorities;
	}

}
