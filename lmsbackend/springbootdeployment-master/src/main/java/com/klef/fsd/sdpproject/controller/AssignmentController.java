package com.klef.fsd.sdpproject.controller;


	import com.klef.fsd.sdpproject.dto.AssignmentDTO;
	import com.klef.fsd.sdpproject.model.Assignment;
	import com.klef.fsd.sdpproject.service.AssignmentService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	import java.util.List;

	@RestController
	@RequestMapping("/assignments")
	public class AssignmentController {

	    @Autowired
	    private AssignmentService assignmentService;

	    @PostMapping("/create")
	    public ResponseEntity<String> createAssignment(@RequestBody AssignmentDTO assignmentDTO) {
	        assignmentService.createAssignment(assignmentDTO);
	        return ResponseEntity.ok("Assignment created successfully");
	    }

	    @GetMapping("/course/{courseId}")
	    public ResponseEntity<List<Assignment>> getAssignmentsByCourse(@PathVariable Long courseId) {
	        List<Assignment> assignments = assignmentService.getAssignmentsByCourse(courseId);
	        return ResponseEntity.ok(assignments);
	    }
	}

