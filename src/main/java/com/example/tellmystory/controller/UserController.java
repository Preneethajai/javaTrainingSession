package com.example.tellmystory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tellmystory.model.AppResponse;
import com.example.tellmystory.model.Publishers;
import com.example.tellmystory.model.StoryUser;
import com.example.tellmystory.model.UserTellStory;
import com.example.tellmystory.model.dto.GetAllPostDto;
import com.example.tellmystory.model.dto.MyPostDto;
import com.example.tellmystory.model.dto.StoryRequestDto;
import com.example.tellmystory.model.dto.UserDto;
import com.example.tellmystory.model.dto.WriteContentDto;
import com.example.tellmystory.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private AppResponse response;
	
	@PostMapping("/userSave")
	public ResponseEntity<AppResponse> registerUser(@RequestBody UserDto userDto) {
		StoryUser registerUser = userService.registerUser(userDto);
		if(registerUser!=null) {
			response.setMessage("successfully");
			response.setStatus("200");
			response.setData(registerUser);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/writeStory")
	public ResponseEntity<AppResponse> writeStory(@RequestBody WriteContentDto writeContentDto) {
		UserTellStory writeStory = userService.writeStory(writeContentDto);
		if(writeStory!=null) {
			response.setMessage("successfully saved");
			response.setStatus("200");
			response.setData(writeStory);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/listAllPublishers")
	public ResponseEntity<AppResponse> sendRequest() {
		List<Publishers> sendRequest = userService.sendRequest();
		if(sendRequest!=null) {
			response.setMessage("List of All publisher's");
			response.setStatus("200");
			response.setData(sendRequest);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/requestForStory")
	public ResponseEntity<AppResponse> requestForStory(@RequestBody StoryRequestDto storyRequestDto) {
		String requestForStory = userService.requestForStory(storyRequestDto);
		if(requestForStory!=null) {
			response.setMessage("request Sent Successfully");
			response.setStatus("200");
			response.setData(requestForStory);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/myProfile/{email}")
	public ResponseEntity<AppResponse> myProfile(@PathVariable String email ) {
		Optional<StoryUser> myProfile = userService.myProfile(email);
		if(myProfile.isPresent()) {
			response.setMessage("your profile");
			response.setStatus("200");
			response.setData(myProfile);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/myPost/{email}")
	public ResponseEntity<AppResponse> myPost(@PathVariable String email) {
		List<MyPostDto> myPost = userService.myPost(email);
		if(myPost!=null) {
			response.setMessage("List of post");
			response.setStatus("200");
			response.setData(myPost);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/approvedPost/{email}")
	public ResponseEntity<AppResponse> approvedPost(@PathVariable String email) {
		List<UserTellStory> approvedPost = userService.approvedPost(email);
		if(approvedPost!=null) {
			response.setMessage("List of post");
			response.setStatus("200");
			response.setData(approvedPost);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping("/rejectPost/{email}")
	public ResponseEntity<AppResponse> rejectPost(@PathVariable String email) {
		List<UserTellStory> approvedPost = userService.rejectPost(email);
		if(approvedPost!=null) {
			response.setMessage("List of post");
			response.setStatus("200");
			response.setData(approvedPost);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllPost")
	public ResponseEntity<AppResponse> getAllPost() {
		List<GetAllPostDto> allPost = userService.getAllPost();
		if(allPost!=null) {
			response.setMessage("List of post");
			response.setStatus("200");
			response.setData(allPost);
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	
}
