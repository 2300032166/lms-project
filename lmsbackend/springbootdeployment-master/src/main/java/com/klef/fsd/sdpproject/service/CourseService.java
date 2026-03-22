package com.klef.fsd.sdpproject.service;

	import com.klef.fsd.sdpproject.model.Course;

	public interface CourseService {
	    Course addCourse(Course course);
	    Course getCourseById(int courseId);
	    String deleteCourse(int courseId);
	    Course updateCourse(int courseId, Course course);
	}


