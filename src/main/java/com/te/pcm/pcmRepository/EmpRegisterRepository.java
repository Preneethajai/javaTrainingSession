package com.te.pcm.pcmrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.pcm.pcmdto.EmployeeDto;
import com.te.pcm.pcmentity.EmployeeEntity;
@Repository
public interface EmpRegisterRepository extends JpaRepository<EmployeeEntity, Integer> {

//	EmployeeEntity findByEmpRoles(String empRoles);

	EmployeeEntity findByEmpName(String empName);

//	EmployeeEntity save(EmployeesDto employeesDto);

}
