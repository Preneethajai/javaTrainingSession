package com.te.springjwts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.springjwts.model.AppUser;
@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer>{
	Optional<AppUser> findByUsername(String name);
}
