package com.maveric.unobank.service;

import java.util.List;

import com.maveric.unobank.entity.Audit_Details;
import com.maveric.unobank.exceptions.InvalidException;
import com.maveric.unobank.exceptions.NotFoundException;
import com.maveric.unobank.model.AuditDetailsDto;

public interface AuditDetailsService {

	Audit_Details create_AuditDetails(AuditDetailsDto dto) throws InvalidException;

	List<Audit_Details> list_AuditDetails(String id) throws NotFoundException;

}
