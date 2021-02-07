package com.example.learning.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.*; 

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	/*
	private List<Topic> topics = new ArrayList<>( 
			Arrays.asList(
			new Topic("1", "Topic 1", "Topic 1 Description"),
			new Topic("2", "Topic 2", "Topic 2 Description"),
			new Topic("3", "Topic 3", "Topic 3 Description")));
			*/
	
	public List<Topic> getTopics() {
		List<Topic> topics = new ArrayList<>();		
		topicRepository.findAll().forEach(topics:: add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
		// return topics.stream().filter(item -> item.getId().toLowerCase().equals(id)).findFirst().get();
	}	
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		// topics.add(topic);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
		/*
		for(int i = 0; i< topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(topic.getId())) {
				topics.set(i, topic);
				return;
			}
		}
		*/
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		// topics.removeIf(topic -> topic.getId().equals(id));
	}
}
