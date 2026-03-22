package com.klef.fsd.sdpproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.fsd.sdpproject.model.EnrollCourse;
import com.klef.fsd.sdpproject.model.Student;
import com.klef.fsd.sdpproject.model.Course;
import com.klef.fsd.sdpproject.repository.EnrollCourseRepository;
import com.klef.fsd.sdpproject.repository.StudentRepository;
import com.klef.fsd.sdpproject.repository.CourseRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollCourseRepository enrollCourseRepository;

    @Override
    public String studentRegistration(Student student) {
        studentRepository.save(student);
        return "Student Registered Successfully";
    }

    @Override
    public Student checkStudentLogin(String username, String password) {
        // Check for a valid student using the provided username and password
        Student student = studentRepository.findByUsernameAndPassword(username, password);
        if (student == null) {
            throw new IllegalArgumentException("Invalid username or password");
        }
        return student;
    }

    @Override
    public String studentUpdateProfile(Student student) {
        Optional<Student> object = studentRepository.findById(student.getId());

        String msg = null;

        if (object.isPresent()) {
            Student s = object.get();

            s.setName(student.getName());
            s.setDob(student.getDob());
            s.setMobileno(student.getMobileno());
            s.setEmail(student.getEmail());
            s.setPassword(student.getPassword());
            s.setLocation(student.getLocation());

            studentRepository.save(s);

            msg = "Student Profile Updated Successfully";
        } else {
            msg = "Student ID Not Found to Update";
        }
        return msg;
    }

    @Override
    public List<Course> viewAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Student getStudentById(int sid) {
        return studentRepository.findById(sid).orElse(null);
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public String enrollCourse(EnrollCourse enrollCourse) {
        enrollCourseRepository.save(enrollCourse);
        return "Course Enrolled Successfully";
    }

    @Override
    public List<EnrollCourse> getEnrolledCoursesByStudent(int sid) {
        Student student = studentRepository.findById(sid).orElse(null);
        
        if (student == null) {
            throw new IllegalArgumentException("Student not found with ID: " + sid);
        }
        
        return enrollCourseRepository.findByStudentId(sid);
    }
}
