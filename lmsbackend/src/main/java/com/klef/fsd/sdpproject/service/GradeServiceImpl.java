package com.klef.fsd.sdpproject.service;

	import com.klef.fsd.sdpproject.dto.GradeDTO;
	import com.klef.fsd.sdpproject.model.Assignment;
	import com.klef.fsd.sdpproject.model.Grade;
	import com.klef.fsd.sdpproject.model.Student;
	import com.klef.fsd.sdpproject.repository.AssignmentRepository;
	import com.klef.fsd.sdpproject.repository.GradeRepository;
	import com.klef.fsd.sdpproject.repository.StudentRepository;
	import com.klef.fsd.sdpproject.service.GradeService;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import java.util.List;

	@Service
	public class GradeServiceImpl implements GradeService {

	    @Autowired
	    private GradeRepository gradeRepository;

	    @Autowired
	    private AssignmentRepository assignmentRepository;

	    @Autowired
	    private StudentRepository studentRepository;

	    @Override
	    public void assignGrade(GradeDTO gradeDTO) {
	        Grade grade = new Grade();

	        Assignment assignment = assignmentRepository.findById(gradeDTO.getAssignmentId())
	                                .orElseThrow(() -> new RuntimeException("Assignment not found"));

	        Student student = studentRepository.findById(gradeDTO.getStudentId().intValue())
                    .orElseThrow(() -> new RuntimeException("Student not found"));


	        grade.setAssignment(assignment);
	        grade.setStudent(student);
	        grade.setGradeValue(gradeDTO.getGradeValue());

	        gradeRepository.save(grade);
	    }

	    @Override
	    public List<Grade> getGradesByStudent(Long studentId) {
	        return gradeRepository.findByStudentId(studentId);
	    }
	}

