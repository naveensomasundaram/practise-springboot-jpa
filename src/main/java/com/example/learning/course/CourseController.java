package com.example.learning.course;

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
public class CourseController {

	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{Id}")
	public Optional<Course> getCourse(@PathVariable String topicId, @PathVariable String Id) {
		return courseService.getCourse(Id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public String addTopic(@PathVariable String topicId, @RequestBody Course course) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
		return "";
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{Id}")
	public String updateTopic(@RequestBody Course course,@PathVariable String topicId ,@PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
		return "";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{Id}")
	public String updateTopic(@PathVariable String Id) {
		courseService.deleteCourse(Id);
		return "";
	}

	

}
