package com.maveric.unobank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.maveric.unobank.entity.Audit_Details;
import com.maveric.unobank.model.AppResponse;
import com.maveric.unobank.model.AuditDetailsDto;
import com.maveric.unobank.service.AuditDetailsService;

@RestController
@RequestMapping("/case/auditTrail")
public class AuditDetailsController {

	@Autowired
	private AuditDetailsService service;
	
	@Autowired
	private AppResponse appResponse;
	
	@PostMapping("/createAuditTrail")
	public ResponseEntity<AppResponse> create_AuditDetails(@RequestBody AuditDetailsDto dto) throws Exception{
		Audit_Details create_AuditDetails = service.create_AuditDetails(dto);
			appResponse.setSuccess(true);
			appResponse.setMessage("value is inserted");
			appResponse.setData(create_AuditDetails);
		return new ResponseEntity<>(appResponse,HttpStatus.OK);
		
	}
	
	@GetMapping("/getAuditTrail/{id}")
	public ResponseEntity<AppResponse> list_AuditDetails(@PathVariable String id) throws Exception{
		List<Audit_Details> list_AuditDetails = service.list_AuditDetails(id);
			appResponse.setSuccess(true);
			appResponse.setMessage("all Audit details");
			appResponse.setData(list_AuditDetails);
		return new ResponseEntity<>(appResponse,HttpStatus.OK);
	}
	
}