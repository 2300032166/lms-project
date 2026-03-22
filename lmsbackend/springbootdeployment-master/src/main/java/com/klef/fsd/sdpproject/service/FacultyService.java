package com.klef.fsd.sdpproject.service;

	import java.util.List;
	import com.klef.fsd.sdpproject.model.Faculty;

	public interface FacultyService {
	    Faculty checkFacultyLogin(String username, String password);
	    String addFaculty(Faculty faculty);
	    List<Faculty> viewAllFaculty();
	    Faculty getFacultyById(int id);
	}

