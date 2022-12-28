package com.te.pcm.pcmController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.pcm.pcmDto.AppResponse;
import com.te.pcm.pcmDto.EmployeeDto;
import com.te.pcm.pcmEntity.DepartmentsEntity;
import com.te.pcm.pcmEntity.EmployeeEntity;
import com.te.pcm.pcmServiceImp.EmployeesDto;
import com.te.pcm.pcmservice.PcmService;

@RestController
@RequestMapping("/controller")
public class RegisterController {
	@Autowired
	private AppResponse response;
	
	@Autowired
	private PcmService service;
	
	@PostMapping("/register")
	public ResponseEntity<AppResponse> register(@RequestBody DepartmentsEntity departmentsEntity) {
		if(service.register(departmentsEntity)!=null) {
			response.setMessage("registered");
			response.setSatus("successfully");
			response.setData(departmentsEntity);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	@PostMapping("/empRegister")
	public ResponseEntity<AppResponse> empRegister(@RequestBody EmployeesDto employee){ 
		if(service.empRegister(employee)!=null) {
			response.setMessage("registered");
			response.setSatus("successfully");
			response.setData(employee);
		}
		return new ResponseEntity<AppResponse>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<AppResponse> getEmployee() {
		List<EmployeeDto> employee = service.getEmployee();
		if(employee!=null) {
			response.setMessage("got all");
			response.setSatus("Sucessufully");
			response.setData(employee);
		}
		return new ResponseEntity<AppResponse>(response, HttpStatus.OK);
	}
}
