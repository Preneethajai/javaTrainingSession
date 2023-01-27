package com.example.tellmystory.service;


import java.util.List;
import java.util.Optional;

import com.example.tellmystory.model.Publishers;
import com.example.tellmystory.model.StoryUser;
import com.example.tellmystory.model.UserTellStory;
import com.example.tellmystory.model.dto.GetAllPostDto;
import com.example.tellmystory.model.dto.MyPostDto;
import com.example.tellmystory.model.dto.StoryRequestDto;
import com.example.tellmystory.model.dto.UserDto;
import com.example.tellmystory.model.dto.WriteContentDto;

public interface UserService {
StoryUser registerUser(UserDto userDto);
UserTellStory writeStory(WriteContentDto writeContentDto);
List<Publishers> sendRequest();
String requestForStory(StoryRequestDto storyRequestDto);
Optional<StoryUser> myProfile(String email);
List<MyPostDto> myPost(String email);
List<UserTellStory> approvedPost(String email);
List<UserTellStory> rejectPost(String email);
List<GetAllPostDto> getAllPost();
}
