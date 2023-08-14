package com.maveric.unobank.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditDetailsDto {
	private String createdBy;
	private String details;
	private String caseId;
}
