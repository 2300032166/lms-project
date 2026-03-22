package com.klef.fsd.sdpproject.service;

	import java.util.List;
	import com.klef.fsd.sdpproject.model.EnrollCourse;

	public interface EnrollCourseService {

	    String enrollCourse(EnrollCourse enrollCourse);

	    List<EnrollCourse> viewAllEnrollments();

	    List<EnrollCourse> viewEnrollmentsByStudent(int studentId);

	    List<EnrollCourse> viewEnrollmentsByCourse(int courseId);

	    String deleteEnrollment(int enrollId);
	}

