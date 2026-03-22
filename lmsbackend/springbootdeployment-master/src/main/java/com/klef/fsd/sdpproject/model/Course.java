package com.klef.fsd.sdpproject.model;

	import jakarta.persistence.*;

	@Entity
	@Table(name = "course_table")
	public class Course {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "course_id")
	    private int id;

	    @Column(length = 100, nullable = false)
	    private String name;

	    @Column(length = 255)
	    private String description;

	    @Column(length = 20, nullable = false)
	    private String duration;

	    @Column(nullable = false)
	    private int creditHours;

	    // Getters and Setters
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

	    public int getCreditHours() {
	        return creditHours;
	    }

	    public void setCreditHours(int creditHours) {
	        this.creditHours = creditHours;
	    }
	}


