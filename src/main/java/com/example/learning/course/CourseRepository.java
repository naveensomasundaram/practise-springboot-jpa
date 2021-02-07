package com.example.learning.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {
	
	// @Query("SELECT * from course as course where course.id = :Id")
	public List<Course> findByTopicId(String Id);
}
