package com.klef.fsd.sdpproject.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.klef.fsd.sdpproject.model.EnrollCourse;
	import com.klef.fsd.sdpproject.repository.EnrollCourseRepository;

	@Service
	public class EnrollCourseServiceImpl implements EnrollCourseService {

	    @Autowired
	    private EnrollCourseRepository enrollCourseRepository;

	    @Override
	    public String enrollCourse(EnrollCourse enrollCourse) {
	        enrollCourseRepository.save(enrollCourse);
	        return "Enrolled Successfully!";
	    }

	    @Override
	    public List<EnrollCourse> viewAllEnrollments() {
	        return enrollCourseRepository.findAll();
	    }

	    @Override
	    public List<EnrollCourse> viewEnrollmentsByStudent(int studentId) {
	        return enrollCourseRepository.findByStudentId(studentId);
	    }

	    @Override
	    public List<EnrollCourse> viewEnrollmentsByCourse(int courseId) {
	        return enrollCourseRepository.findByCourseId(courseId);
	    }

	    @Override
	    public String deleteEnrollment(int enrollId) {
	        enrollCourseRepository.deleteById(enrollId);
	        return "Enrollment Deleted Successfully!";
	    }
	}
