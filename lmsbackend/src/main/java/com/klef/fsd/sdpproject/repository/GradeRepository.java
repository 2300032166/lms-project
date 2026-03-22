package com.klef.fsd.sdpproject.repository;

	import com.klef.fsd.sdpproject.model.Grade;
	import org.springframework.data.jpa.repository.JpaRepository;
	import java.util.List;

	public interface GradeRepository extends JpaRepository<Grade, Long> {
	    List<Grade> findByStudentId(Long studentId);
	    List<Grade> findByAssignmentId(Long assignmentId);
	}
