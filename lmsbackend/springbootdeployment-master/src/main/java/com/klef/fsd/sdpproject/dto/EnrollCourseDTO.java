package com.klef.fsd.sdpproject.dto;

	public class EnrollCourseDTO {

	    private int enrollId;
	    private int studentId;
	    private int courseId;
	    private String enrollmentDate;

	    // Constructors
	    public EnrollCourseDTO() {}

	    public EnrollCourseDTO(int enrollId, int studentId, int courseId, String enrollmentDate) {
	        this.enrollId = enrollId;
	        this.studentId = studentId;
	        this.courseId = courseId;
	        this.enrollmentDate = enrollmentDate;
	    }

	    // Getters & Setters
	    public int getEnrollId() {
	        return enrollId;
	    }

	    public void setEnrollId(int enrollId) {
	        this.enrollId = enrollId;
	    }

	    public int getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(int studentId) {
	        this.studentId = studentId;
	    }

	    public int getCourseId() {
	        return courseId;
	    }

	    public void setCourseId(int courseId) {
	        this.courseId = courseId;
	    }

	    public String getEnrollmentDate() {
	        return enrollmentDate;
	    }

	    public void setEnrollmentDate(String enrollmentDate) {
	        this.enrollmentDate = enrollmentDate;
	    }
	}

