package com.klef.fsd.sdpproject.service;

	import java.util.List;

	import com.klef.fsd.sdpproject.model.Admin;
	import com.klef.fsd.sdpproject.model.Student;
	import com.klef.fsd.sdpproject.model.Faculty;

	public interface AdminService 
	{
	    public Admin checkadminlogin(String username, String password);

	    public String addFaculty(Faculty faculty);
	    public List<Faculty> displayFacultys();
	    public String deleteFaculty(int id);

	    public List<Student> displayStudents();
	    public String deleteStudent(int id);

	    public long displayStudentCount();
	    public long displayFacultyCount();
	    public long displayCourseCount();
	}


