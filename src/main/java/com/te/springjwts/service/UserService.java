package com.te.springjwts.service;

import java.util.Optional;

import com.te.springjwts.model.AppUser;

public interface UserService {
	Integer saveUser(AppUser appUser);
	Optional<AppUser> findByUsername(String name);
}
