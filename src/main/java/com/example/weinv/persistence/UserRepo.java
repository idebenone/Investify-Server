package com.example.weinv.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.weinv.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
	Optional<User> findByEmail(String email);
}
