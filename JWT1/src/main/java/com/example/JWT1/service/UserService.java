package com.example.JWT1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.JWT1.entity.Users;
import com.example.JWT1.repo.UsersRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UsersRepo userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userrepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
	}

	public UserDetails loadUserById(Long userId) {
		Users user = userrepo.findUsersById(userId);
		if (user == null) {
            log.info("Khong tim thay");
        }
        return new CustomUserDetails(user);
	}
}
