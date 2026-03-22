package com.klef.fsd.sdpproject.model;

	import jakarta.persistence.*;

	@Entity
	public class Grade {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    private Assignment assignment;

	    @ManyToOne
	    private Student student;

	    private Double gradeValue;

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public Assignment getAssignment() { return assignment; }
	    public void setAssignment(Assignment assignment) { this.assignment = assignment; }

	    public Student getStudent() { return student; }
	    public void setStudent(Student student) { this.student = student; }

	    public Double getGradeValue() { return gradeValue; }
	    public void setGradeValue(Double gradeValue) { this.gradeValue = gradeValue; }
	}

