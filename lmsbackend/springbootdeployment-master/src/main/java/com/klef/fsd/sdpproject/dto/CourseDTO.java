package com.klef.fsd.sdpproject.dto;

	public class CourseDTO {

	    private int id;
	    private String name;
	    private String description;
	    private String duration;

	    // Constructors
	    public CourseDTO() {}

	    public CourseDTO(int id, String name, String description, String duration) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.duration = duration;
	    }

	    // Getters & Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getDuration() {
	        return duration;
	    }

	    public void setDuration(String duration) {
	        this.duration = duration;
	    }
	}

