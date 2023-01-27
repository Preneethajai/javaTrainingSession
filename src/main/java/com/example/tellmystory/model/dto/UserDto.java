package com.example.tellmystory.model.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
public class UserDto {
	private Integer id;
	private String name;
	private String email;
	private Integer phoneNo;
	private String password;
}
