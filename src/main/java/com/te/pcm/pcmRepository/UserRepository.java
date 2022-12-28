package com.te.pcm.pcmRepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.te.pcm.pcmEntity.AppUser;
import com.te.pcm.pcmEntity.EmployeeEntity;

@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{
 AppUser findByuserName(String username);
//Optional<AppUser> findByEmployeeEntityEmpId(int empId);
}
