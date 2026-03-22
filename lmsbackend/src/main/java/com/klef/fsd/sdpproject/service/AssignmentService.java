package com.klef.fsd.sdpproject.service;

	import com.klef.fsd.sdpproject.dto.AssignmentDTO;
	import com.klef.fsd.sdpproject.model.Assignment;
	import java.util.List;

	public interface AssignmentService {
	    void createAssignment(AssignmentDTO assignmentDTO);
	    List<Assignment> getAssignmentsByCourse(Long courseId);
	}

