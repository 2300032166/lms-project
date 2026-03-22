package com.klef.fsd.sdpproject.dto;

	public class GradeDTO {
	    private Long assignmentId;
	    private Long studentId;
	    private Double gradeValue;

	    // Getters and Setters
	    public Long getAssignmentId() { return assignmentId; }
	    public void setAssignmentId(Long assignmentId) { this.assignmentId = assignmentId; }

	    public Long getStudentId() { return studentId; }
	    public void setStudentId(Long studentId) { this.studentId = studentId; }

	    public Double getGradeValue() { return gradeValue; }
	    public void setGradeValue(Double gradeValue) { this.gradeValue = gradeValue; }
	}
