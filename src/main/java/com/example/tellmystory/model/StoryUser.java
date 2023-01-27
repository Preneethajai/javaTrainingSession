package com.example.tellmystory.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StoryUser {
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@Id
	@Column(unique = true)
	private String email;
	private Integer phoneNo;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "storyUser")
	@JsonIgnore
	private List<UserTellStory> userStories;
}
