package com.te.pcm.pcmrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmentity.AppUser;
import com.te.pcm.pcmentity.EmployeeEntity;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{
 AppUser findByUserName(String username);
//Optional<AppUser> findByEmployeeEntityEmpId(int empId);
}
