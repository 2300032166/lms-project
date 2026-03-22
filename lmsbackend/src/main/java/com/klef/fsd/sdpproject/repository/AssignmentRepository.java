package com.klef.fsd.sdpproject.repository;

	import com.klef.fsd.sdpproject.model.Assignment;
	import org.springframework.data.jpa.repository.JpaRepository;
	import java.util.List;

	public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
	    List<Assignment> findByCourseId(Long courseId);
	}
