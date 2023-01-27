package com.example.tellmystory.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class WriteContentDto {
	private String name;
	private String title;
	private String content;
	private String email;
	private Integer publisherId;
	
}
