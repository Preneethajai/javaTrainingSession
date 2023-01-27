package com.example.tellmystory.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserTellStory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@Column(unique = true)
	private String title;
	private String content;
	private String status;

	@ManyToOne(cascade =  CascadeType.ALL)
	@JsonIgnore
	private StoryUser storyUser;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Publishers publishers;
	
}
