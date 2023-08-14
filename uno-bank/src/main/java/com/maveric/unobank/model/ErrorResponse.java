package com.maveric.unobank.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ErrorResponse {
	private Boolean success;
	private String message;
	private Integer error_code;
	private Object data;
}
