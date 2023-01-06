package com.te.pcm.pcmcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.pcm.pcmdto.AppResponse;
import com.te.pcm.pcmdto.DepartmentsDto;
import com.te.pcm.pcmdto.EmployeeDto;
import com.te.pcm.pcmdto.EmployeesDto;
import com.te.pcm.pcmdto.ProductByIdDto;
import com.te.pcm.pcmdto.SearchCategoryDto;
import com.te.pcm.pcmentity.DepartmentsEntity;
import com.te.pcm.pcmentity.OptionTypesEntity;
import com.te.pcm.pcmentity.OptionsEntity;
import com.te.pcm.pcmentity.ProductEntity;
import com.te.pcm.pcmentity.VariationTypesEntity;
import com.te.pcm.pcmentity.VariationsEntity;
import com.te.pcm.pcmservice.PcmService;

@RestController
@RequestMapping(path = "/user")
public class RegisterController {
	@Autowired
	private AppResponse response;
	
	@Autowired
	private PcmService service;
	
	@PostMapping(path ="/register")
	public ResponseEntity<AppResponse> register(@RequestBody DepartmentsDto departmentsDto) {
		if(service.register(departmentsDto)!=null) {
			response.setMessage("registered");
			response.setSatus("successfully");
			response.setData(departmentsDto);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	@PostMapping(path ="/empRegister")
	public ResponseEntity<AppResponse> empRegister(@RequestBody EmployeesDto employee){ 
		if(service.empRegister(employee)!=null) {
			response.setMessage("registered");
			response.setSatus("successfully");
			response.setData(employee);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/getEmployee")
	public ResponseEntity<AppResponse> getEmployee() {
		List<EmployeeDto> employee = service.getEmployee();
		if(employee!=null) {
			response.setMessage("got all");
			response.setSatus("Sucessufully");
			response.setData(employee);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path ="/searchById")
	public ResponseEntity<AppResponse> getById(@RequestBody ProductByIdDto productByIdDto) {
		List<DepartmentsEntity> byId = service.getById(productByIdDto);
		if (byId != null) {
			response.setMessage("product list ");
			response.setSatus("Sucessufully list");
			response.setData(byId);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(path ="/searchCategory")
	public ResponseEntity<AppResponse> searchCategory(int catogorysId) {
		List<SearchCategoryDto> serachCategory = service.serachCategory(catogorysId);
		if(serachCategory!=null) {
			response.setMessage("sucessfully category");
			response.setSatus("updated search catergory");
			response.setData(serachCategory);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortProduct")
	public ResponseEntity<AppResponse> sortProduct() {
	List<ProductEntity> sortProducts = service.sortProducts();
	if(sortProducts!=null) {
		response.setMessage("sucessfully product");
		response.setSatus("updated product");
		response.setData(sortProducts);
	}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortByVariation")
	public ResponseEntity<AppResponse> sortByVariation() {
		List<VariationsEntity> sortByVariation = service.sortByVariation();
		if(sortByVariation!=null) {
			response.setMessage("sucessfully variation");
			response.setSatus("updated variation");
			response.setData(sortByVariation);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortByVariationType")
	public ResponseEntity<AppResponse> sortByVariationType() {
		List<VariationTypesEntity> sortByVariationType = service.sortByVariationType();
		if(sortByVariationType!=null) {
			response.setMessage("sucessfully sortVariationType");
			response.setSatus("updated variationType");
			response.setData(sortByVariationType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortOptions")
	public ResponseEntity<AppResponse> sortByOption() {
		List<OptionsEntity> sortByOption = service.sortByOption();
		if(sortByOption!=null) {
			response.setMessage("sucessfully sortOption");
			response.setSatus("updated option");
			response.setData(sortByOption);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping(path ="/sortOptionsType")
	public ResponseEntity<AppResponse> sortByOptionType() {
		List<OptionTypesEntity> sortByOptionType = service.sortByOptionType();
		if(sortByOptionType!=null) {
			response.setMessage("sucessfully optionType");
			response.setSatus("updated option");
			response.setData(sortByOptionType);
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	


}
