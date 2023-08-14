package com.maveric.unobank.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maveric.unobank.entity.Audit_Details;
import com.maveric.unobank.exceptions.InvalidException;
import com.maveric.unobank.exceptions.NotFoundException;
import com.maveric.unobank.model.AuditDetailsDto;
import com.maveric.unobank.repository.Audit_detailsRepository;

@Service
public class AuditDetailsServiceImpl implements AuditDetailsService {

	@Autowired
	private Audit_detailsRepository repository;


	@Override
	public Audit_Details create_AuditDetails(AuditDetailsDto dto) throws InvalidException {
		if(dto!=null) {
		Audit_Details audit_Details = new Audit_Details();
		BeanUtils.copyProperties(dto, audit_Details);
		return repository.save(audit_Details);
		}
		throw new InvalidException("Invalid input Exception");
	}
	
	@Override
	public List<Audit_Details> list_AuditDetails(String id) throws NotFoundException{
		
		List<Audit_Details> findAllByCase_id = repository.findAllByCaseId(id);
		if(findAllByCase_id!=null) {
			return findAllByCase_id;
		}
		throw new NotFoundException("The list of audit deatils not found exception");
	}
	
	

}