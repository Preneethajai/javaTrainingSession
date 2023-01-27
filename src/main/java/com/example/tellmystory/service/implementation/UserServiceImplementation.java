package com.example.tellmystory.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tellmystory.model.Publishers;
import com.example.tellmystory.model.StoryUser;
import com.example.tellmystory.model.UserTellStory;
import com.example.tellmystory.model.dto.GetAllPostDto;
import com.example.tellmystory.model.dto.MyPostDto;
import com.example.tellmystory.model.dto.StoryRequestDto;
import com.example.tellmystory.model.dto.UserDto;
import com.example.tellmystory.model.dto.WriteContentDto;
import com.example.tellmystory.repository.PublishersRepository;
import com.example.tellmystory.repository.StoryRepository;
import com.example.tellmystory.repository.UserRepository;
import com.example.tellmystory.service.UserService;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private StoryRepository storyRepository;

	@Autowired
	private PublishersRepository publishersRepository;

	@Override
	public StoryUser registerUser(UserDto userDto) {
		StoryUser user = new StoryUser();
		BeanUtils.copyProperties(userDto, user);
		return repository.save(user);
	}

	@Override
	public UserTellStory writeStory(WriteContentDto writeContentDto) {
		UserTellStory userStory = new UserTellStory();
		BeanUtils.copyProperties(writeContentDto, userStory);
		if(writeContentDto.getPublisherId()!=0) {
		Optional<StoryUser> email = repository.findById(writeContentDto.getEmail());
		Optional<Publishers> publisher = publishersRepository.findById(writeContentDto.getPublisherId());
		Publishers publishers = publisher.get();
		StoryUser storyUser = email.get();
		userStory.setStoryUser(storyUser);
		userStory.setPublishers(publishers);
		return storyRepository.save(userStory);
		}else {
			Optional<StoryUser> email = repository.findById(writeContentDto.getEmail());
			StoryUser storyUser = email.get();
			userStory.setStoryUser(storyUser);
			return storyRepository.save(userStory);
		}
		
	}

	@Override
	public List<Publishers> sendRequest() {
		return publishersRepository.findAll();
	}

	@Override
	public String requestForStory(StoryRequestDto storyRequestDto) {
		UserTellStory userStory = new UserTellStory();
		String publisherRequest = publisherRequest(storyRequestDto.getRequest());
		Optional<UserTellStory> findByEmail = storyRepository.findByTitle(storyRequestDto.getTitle());
		UserTellStory userTellStory = findByEmail.get();
		userTellStory.setStatus(publisherRequest);
		storyRepository.save(userStory);
		return storyRequestDto.getRequest();
	}

	public String publisherRequest(String request) {
		if (request.equalsIgnoreCase("approved")) {
			return "approved";
		} else if (request.equalsIgnoreCase("rejected")) {
			return "rejected";
		} else {
			return "pending";
		}
	}

	@Override
	public Optional<StoryUser> myProfile(String email) {
		return repository.findById(email);
	}

	@Override
	public List<MyPostDto> myPost(String email) {
		List<UserTellStory> findAll = storyRepository.findByStoryUserEmail(email);
		 ArrayList<MyPostDto> arrayList = new ArrayList<>();
		for (UserTellStory post : findAll) {
			String name = post.getName();
			String title = post.getTitle();
			String content = post.getContent();
			arrayList.add(new MyPostDto(name,title,content));
		}
		return arrayList;
	}

	@Override
	public List<UserTellStory> approvedPost(String email) {
		return storyRepository.findByStoryUserEmailAndStatus(email,"approved");
	}

	@Override
	public List<UserTellStory> rejectPost(String email) {
		return storyRepository.findByStoryUserEmailAndStatus(email,"rejected");
	}

	@Override
	public List<GetAllPostDto> getAllPost() {
		List<GetAllPostDto> getAllPost = new ArrayList<>();
		List<UserTellStory> storyAll = storyRepository.findAll();
		for (UserTellStory userTellStory : storyAll) {
			Integer id = userTellStory.getId();
			String name = userTellStory.getName();
			String title = userTellStory.getTitle();
			String content = userTellStory.getContent();
			StoryUser storyUser = userTellStory.getStoryUser();
			Publishers publishers = userTellStory.getPublishers();
			getAllPost.add(new GetAllPostDto(id, name, title, content, publishers.getName(),storyUser.getEmail()));
		}
		return getAllPost;
	}

}

//StoryRequestDto requestDto = new StoryRequestDto("approved","string@gmail.com");
//String publisherRequest = publisherRequest(requestDto.getRequest());
//userStory.setStatus(publisherRequest);
