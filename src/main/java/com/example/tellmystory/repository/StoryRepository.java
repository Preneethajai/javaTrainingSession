package com.example.tellmystory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tellmystory.model.UserTellStory;

public interface StoryRepository extends JpaRepository<UserTellStory, Integer>{

	Optional<UserTellStory> findByTitle(String email);

	List<UserTellStory> findByStoryUserEmail(String email);
//	List<UserTellStory> findByStoryUserEmail();
	List<UserTellStory> findByStoryUserEmailAndStatus(String email , String status);
}
