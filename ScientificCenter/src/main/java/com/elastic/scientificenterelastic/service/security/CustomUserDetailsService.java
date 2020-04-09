package com.elastic.scientificenterelastic.service.security;

import com.elastic.scientificenterelastic.domain.Role;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			Set<GrantedAuthority> grantedAuthority = new HashSet<GrantedAuthority>();
			Set<Role> roles = user.getRoles();
			for(Role role: roles)
			grantedAuthority.add(new SimpleGrantedAuthority(role.getName()));

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthority);
		}
	}

}
