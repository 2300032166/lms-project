package com.klef.fsd.sdpproject.service;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.klef.fsd.sdpproject.model.Course;
	import com.klef.fsd.sdpproject.repository.CourseRepository;

	@Service
	public class CourseServiceImpl implements CourseService {

	    @Autowired
	    private CourseRepository courseRepository;

	    @Override
	    public Course addCourse(Course course) {
	        return courseRepository.save(course);
	    }

	    @Override
	    public Course getCourseById(int courseId) {
	        return courseRepository.findById(courseId).orElse(null);
	    }

	    @Override
	    public String deleteCourse(int courseId) {
	        courseRepository.deleteById(courseId);
	        return "Course deleted successfully.";
	    }

	    @Override
	    public Course updateCourse(int courseId, Course course) {
	        course.setId(courseId);
	        return courseRepository.save(course);
	    }
	}


