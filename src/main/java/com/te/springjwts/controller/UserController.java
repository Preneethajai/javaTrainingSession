package com.te.springjwts.controller;

import java.nio.file.Path;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springjwts.model.AppUser;
import com.te.springjwts.model.UserRequest;
import com.te.springjwts.model.UserResponse;
import com.te.springjwts.service.UserService;
import com.te.springjwts.util.JwtUtils;

@RestController()
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody AppUser appUser) {
		Integer saveUser = userService.saveUser(appUser);
		String body = "user Saved";
		return ResponseEntity.ok(body);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));
		String token = jwtUtils.generateToken(userRequest.getUsername());
		return ResponseEntity.ok(new UserResponse(token, "successful"));
	}

	// after login
	@PostMapping("/welcome")
	public ResponseEntity<String> accessData(Principal principal) {/*-p using this we can read the security
																	 details-->principle interface*/
		return ResponseEntity.ok("Hello User" + principal.getName());
	}

}
