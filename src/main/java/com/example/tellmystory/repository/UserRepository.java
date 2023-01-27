package com.example.tellmystory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tellmystory.model.StoryUser;

public interface UserRepository extends JpaRepository<StoryUser, String> {

}
