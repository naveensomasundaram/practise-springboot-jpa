package com.example.learning.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.topic.TopicService;
import com.example.learning.topic.Topic;

@RestController
public class TopicController {

	
	@Autowired
	private TopicService topicsService;
	
	@RequestMapping("/topics")
	public List<Topic> topics() {
		return topicsService.getTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicsService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public String addTopic(@RequestBody Topic topic) {
		topicsService.addTopic(topic);
		return "";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicsService.updateTopic(topic);
		return "";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public String updateTopic(@PathVariable String id) {
		topicsService.deleteTopic(id);
		return "";
	}

	

}
