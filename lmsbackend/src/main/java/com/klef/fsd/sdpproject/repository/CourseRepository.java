package com.klef.fsd.sdpproject.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import com.klef.fsd.sdpproject.model.Course;

	public interface CourseRepository extends JpaRepository<Course, Integer> {
	    public Course findByName(String name);
	}


