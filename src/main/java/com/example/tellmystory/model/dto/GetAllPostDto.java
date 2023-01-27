package com.example.tellmystory.model.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPostDto {
private Integer id;
private String content;
private String name;
private String title;
private String publisherName;
private String StoryUserEmail;
}
