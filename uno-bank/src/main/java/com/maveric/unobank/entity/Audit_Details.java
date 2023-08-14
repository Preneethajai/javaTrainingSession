package com.maveric.unobank.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@Data
public class Audit_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;
	@NonNull
	@Column(length = 50)
	private String createdBy;
	@NonNull
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@CreatedDate
	private LocalDateTime createdDate;
	@NonNull
	private String details;
	@NonNull
	@Column(length = 50)
	private String caseId;
	
	
	 public Audit_Details() {
	        this.createdDate = LocalDateTime.now();
	    }
	 
	 
	 
}
