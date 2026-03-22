package com.klef.fsd.sdpproject.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.fsd.sdpproject.model.Student;
import com.klef.fsd.sdpproject.dto.CourseDTO;
import com.klef.fsd.sdpproject.dto.EnrollCourseDTO;
import com.klef.fsd.sdpproject.model.Course;
import com.klef.fsd.sdpproject.model.EnrollCourse;
import com.klef.fsd.sdpproject.service.StudentService;
import com.klef.fsd.sdpproject.service.CourseService;  // Add this import

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;  // Inject the CourseService

    // Home endpoint
    @GetMapping("/")
    public String home() {
        return "LMS Student Module";
    }

    // Student registration
    @PostMapping("/registration")
    public ResponseEntity<String> studentRegistration(@RequestBody Student student) {
        try {
            String output = studentService.studentRegistration(student);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Student Registration Failed: " + e.getMessage());
        }
    }

    // Student login check
    @PostMapping("/checkstudentlogin")
    public ResponseEntity<?> checkStudentLogin(@RequestBody Student student) {
        try {
            Student s = studentService.checkStudentLogin(student.getUsername(), student.getPassword());
            if (s != null) {
                return ResponseEntity.ok(s);
            } else {
                return ResponseEntity.status(401).body("Invalid Username or Password");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Login Failed: " + e.getMessage());
        }
    }

    // Update student profile
    @PutMapping("/updateprofile")
    public ResponseEntity<String> studentUpdateProfile(@RequestBody Student student) {
        try {
            String output = studentService.studentUpdateProfile(student);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Update Student: " + e.getMessage());
        }
    }

 // View all courses
    @GetMapping("/viewallcourses")
    public ResponseEntity<List<CourseDTO>> viewAllCourses() {
        try {
            List<Course> courses = studentService.viewAllCourses();
            List<CourseDTO> courseDTOs = courses.stream()
                                                .map(this::convertToCourseDTO)
                                                .collect(Collectors.toList());
            return ResponseEntity.ok(courseDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    // Enroll in a course
    @PostMapping("/enrollCourse")
    public ResponseEntity<String> enrollCourse(@RequestBody EnrollCourse enrollCourse) {
        try {
            // Generate random enrollment ID
            Random rand = new Random();
            int enrollId = rand.nextInt(900000) + 100000;
            enrollCourse.setId(enrollId);  // Set the random ID

            // Retrieve student and course using IDs
            Student student = studentService.getStudentById(enrollCourse.getStudentId());
            Course course = courseService.getCourseById(enrollCourse.getCourseId());

            // Null checks to avoid invalid enrollments
            if (student == null) {
                return ResponseEntity.status(404).body("Student not found with ID: " + enrollCourse.getStudentId());
            }

            if (course == null) {
                return ResponseEntity.status(404).body("Course not found with ID: " + enrollCourse.getCourseId());
            }

            // Set student and course in enrollment
            enrollCourse.setStudentId(student.getId());
            enrollCourse.setCourseId(course.getId());
            enrollCourse.setEnrollmentDate(java.time.LocalDate.now().toString());  // Set the enrollment date

            // Enroll student in the course
            String output = studentService.enrollCourse(enrollCourse);
            return ResponseEntity.ok(output);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to Enroll in Course: " + e.getMessage());
        }
    }

 // Get enrolled courses for a student
    @GetMapping("/enrolledcourses/{sid}")
    public ResponseEntity<List<EnrollCourseDTO>> getEnrolledCourses(@PathVariable int sid) {
        try {
            List<EnrollCourse> enrolledCourses = studentService.getEnrolledCoursesByStudent(sid);
            List<EnrollCourseDTO> enrollCourseDTOs = enrolledCourses.stream()
                                                                   .map(this::convertToEnrollCourseDTO)
                                                                   .collect(Collectors.toList());
            return ResponseEntity.ok(enrollCourseDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    
 // Method to convert Course entity to CourseDTO
    public CourseDTO convertToCourseDTO(Course course) {
        return new CourseDTO(course.getId(), course.getName(), course.getDescription(), course.getDuration());
    }


    // Method to convert EnrollCourse entity to EnrollCourseDTO
    public EnrollCourseDTO convertToEnrollCourseDTO(EnrollCourse enrollCourse) {
        return new EnrollCourseDTO(enrollCourse.getId(), enrollCourse.getStudentId(), enrollCourse.getCourseId(), enrollCourse.getEnrollmentDate());
    }

}
