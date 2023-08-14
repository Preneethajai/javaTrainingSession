package com.maveric.unobank.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AppResponse {
	private Boolean success;
	private String message;
	private Object data;
}
