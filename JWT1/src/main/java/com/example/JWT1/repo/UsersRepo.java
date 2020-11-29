package com.example.JWT1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.JWT1.entity.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
	Users findByUsername(String username);
	
	Users findUsersById(Long id);
}
