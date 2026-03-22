package com.klef.fsd.sdpproject.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.klef.fsd.sdpproject.model.EnrollCourse;
	import com.klef.fsd.sdpproject.service.EnrollCourseService;

	@CrossOrigin(origins = "*")
	@RestController
	@RequestMapping("/api/enrollments")
	public class EnrollCourseController {

	    @Autowired
	    private EnrollCourseService enrollCourseService;

	    @PostMapping("/add")
	    public String enrollCourse(@RequestBody EnrollCourse enrollCourse) {
	        return enrollCourseService.enrollCourse(enrollCourse);
	    }

	    @GetMapping("/viewall")
	    public List<EnrollCourse> viewAllEnrollments() {
	        return enrollCourseService.viewAllEnrollments();
	    }

	    @GetMapping("/bystudent/{studentId}")
	    public List<EnrollCourse> viewEnrollmentsByStudent(@PathVariable int studentId) {
	        return enrollCourseService.viewEnrollmentsByStudent(studentId);
	    }

	    @GetMapping("/bycourse/{courseId}")
	    public List<EnrollCourse> viewEnrollmentsByCourse(@PathVariable int courseId) {
	        return enrollCourseService.viewEnrollmentsByCourse(courseId);
	    }

	    @DeleteMapping("/delete/{enrollId}")
	    public String deleteEnrollment(@PathVariable int enrollId) {
	        return enrollCourseService.deleteEnrollment(enrollId);
	    }
	}

