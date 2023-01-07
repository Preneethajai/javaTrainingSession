package com.te.springjwts.servceimp;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.springjwts.model.AppUser;
import com.te.springjwts.repository.UserRepository;
import com.te.springjwts.service.UserService;

@Service
public class UserServiceImp implements UserService,UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUser(AppUser appUser) {
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		return repository.save(appUser).getId();
	}

	@Override
	public Optional<AppUser> findByUsername(String name) {
		return repository.findByUsername(name);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> app = findByUsername(username);
		AppUser appUser = app.get();
		if(app.isEmpty()) {
			throw new UsernameNotFoundException("username doesnot Exist");
		}
		return new User(username, appUser.getPassword(), appUser.getRoles().stream().map((role->new SimpleGrantedAuthority(role))).collect(Collectors.toList()));
	}
}
