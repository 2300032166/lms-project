package com.klef.fsd.sdpproject.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.klef.fsd.sdpproject.model.EnrollCourse;

	@Repository
	public interface EnrollCourseRepository extends JpaRepository<EnrollCourse, Integer> {

	    List<EnrollCourse> findByStudentId(int studentId);

	    List<EnrollCourse> findByCourseId(int courseId);
	}

