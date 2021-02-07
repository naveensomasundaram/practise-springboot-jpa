package com.example.learning.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.learning.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String courseId;
	private String name;
	private String description;
	@ManyToOne
	private Topic topic;
	
	public Course() {
	}
	
	public Course(String id, String name, String description, String topicId) {
		super();
		this.courseId = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
	}
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String id) {
		courseId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	
}
