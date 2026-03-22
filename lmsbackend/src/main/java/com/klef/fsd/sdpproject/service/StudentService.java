package com.klef.fsd.sdpproject.service;

import java.util.List;

import com.klef.fsd.sdpproject.model.EnrollCourse;
import com.klef.fsd.sdpproject.model.Student;
import com.klef.fsd.sdpproject.model.Course;

public interface StudentService {
  
    // Method to register a student
    public String studentRegistration(Student student);
    
    // Method to check student login
    public Student checkStudentLogin(String username, String password);
    
    // Method to update student profile
    public String studentUpdateProfile(Student student);
    
    // Method to view all available courses
    public List<Course> viewAllCourses();
    
    // Method to get student details by ID
    public Student getStudentById(int sid);
    
    // Method to get course details by ID
    public Course getCourseById(int courseId);
    
    // Method to enroll a student in a course
    public String enrollCourse(EnrollCourse enrollCourse);
    
    // Method to get enrolled courses by student
    public List<EnrollCourse> getEnrolledCoursesByStudent(int sid);
}
