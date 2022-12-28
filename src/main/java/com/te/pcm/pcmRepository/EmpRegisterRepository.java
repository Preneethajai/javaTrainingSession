package com.te.pcm.pcmRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmDto.EmployeeDto;
import com.te.pcm.pcmEntity.EmployeeEntity;
import com.te.pcm.pcmServiceImp.EmployeesDto;
@Repository
public interface EmpRegisterRepository extends JpaRepository<EmployeeEntity, Integer> {

//	EmployeeEntity findByEmpRoles(String empRoles);

	EmployeeEntity findByEmpName(String empName);

//	EmployeeEntity save(EmployeesDto employeesDto);

}
