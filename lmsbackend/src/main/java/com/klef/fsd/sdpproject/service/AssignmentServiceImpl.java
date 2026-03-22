package com.klef.fsd.sdpproject.service;


	import com.klef.fsd.sdpproject.dto.AssignmentDTO;
	import com.klef.fsd.sdpproject.model.Assignment;
	import com.klef.fsd.sdpproject.model.Course;
	import com.klef.fsd.sdpproject.repository.AssignmentRepository;
	import com.klef.fsd.sdpproject.repository.CourseRepository;
	import com.klef.fsd.sdpproject.service.AssignmentService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import java.util.List;

	@Service
	public class AssignmentServiceImpl implements AssignmentService {

	    @Autowired
	    private AssignmentRepository assignmentRepository;

	    @Autowired
	    private CourseRepository courseRepository;

	    @Override
	    public void createAssignment(AssignmentDTO assignmentDTO) {
	        Assignment assignment = new Assignment();
	        assignment.setTitle(assignmentDTO.getTitle());
	        assignment.setDescription(assignmentDTO.getDescription());
	        assignment.setDueDate(assignmentDTO.getDueDate());

	        Course course = courseRepository.findById(assignmentDTO.getCourseId().intValue())
                    .orElseThrow(() -> new RuntimeException("Course not found"));


	        assignment.setCourse(course);
	        assignmentRepository.save(assignment);
	    }

	    @Override
	    public List<Assignment> getAssignmentsByCourse(Long courseId) {
	        return assignmentRepository.findByCourseId(courseId);
	    }
	}

