package com.klef.fsd.sdpproject.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.klef.fsd.sdpproject.model.Course;
	import com.klef.fsd.sdpproject.service.CourseService;

	@RestController
	@RequestMapping("/course")
	public class CourseController {

	    @Autowired
	    private CourseService courseService;

	    @PostMapping("/add")
	    public Course addCourse(@RequestBody Course course) {
	        return courseService.addCourse(course);
	    }

	    @GetMapping("/{id}")
	    public Course getCourse(@PathVariable int id) {
	        return courseService.getCourseById(id);
	    }

	    @DeleteMapping("/{id}")
	    public String deleteCourse(@PathVariable int id) {
	        return courseService.deleteCourse(id);
	    }

	    @PutMapping("/{id}")
	    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
	        return courseService.updateCourse(id, course);
	    }
	}


