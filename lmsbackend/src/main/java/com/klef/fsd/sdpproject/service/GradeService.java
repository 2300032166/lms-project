package com.klef.fsd.sdpproject.service;

	import com.klef.fsd.sdpproject.dto.GradeDTO;
	import com.klef.fsd.sdpproject.model.Grade;
	import java.util.List;

	public interface GradeService {
	    void assignGrade(GradeDTO gradeDTO);
	    List<Grade> getGradesByStudent(Long studentId);
	}
