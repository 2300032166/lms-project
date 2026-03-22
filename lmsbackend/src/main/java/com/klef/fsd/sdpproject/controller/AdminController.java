package com.klef.fsd.sdpproject.controller;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;

	import com.klef.fsd.sdpproject.model.Admin;
	import com.klef.fsd.sdpproject.model.Student;
	import com.klef.fsd.sdpproject.model.Faculty;
	import com.klef.fsd.sdpproject.service.AdminService;

	@RestController
	@RequestMapping("/admin")
	@CrossOrigin("*")
	public class AdminController {
	  @Autowired
	  private AdminService adminService;
	  
	  @PostMapping("/checkadminlogin")
	  public ResponseEntity<?> checkAdminLogin(@RequestBody Admin admin)
	  {
	      try 
	      {
	          Admin a = adminService.checkadminlogin(admin.getUsername(), admin.getPassword());

	          if (a != null) 
	          {
	              return ResponseEntity.ok(a); // login successful
	          } 
	          else 
	          {
	              return ResponseEntity.status(401).body("Invalid Username or Password");
	          }
	      } 
	      catch (Exception e) 
	      {
	          System.out.println(e.getMessage());
	          return ResponseEntity.status(500).body("Login failed: " + e.getMessage());
	      }
	  }
	  
	  @GetMapping("/viewallstudents")
	  public ResponseEntity<List<Student>> viewAllStudents()
	  {
	      List<Student> students = adminService.displayStudents();
	      return ResponseEntity.ok(students); // 200 - success
	  }
	  
	  @PostMapping("/addfaculty")
	  public ResponseEntity<String> addInstructor(@RequestBody Faculty faculty)
	  {
	      try
	      {
	          String output = adminService.addFaculty(faculty);
	          return ResponseEntity.ok(output);
	      }
	      catch(Exception e)
	      {
	          return ResponseEntity.status(500).body("Failed to Add Faculty ... !!");
	      }
	  }
	  
	  @GetMapping("/viewallinstructors")
	  public ResponseEntity<List<Faculty>> viewAllInstructors()
	  {
	      List<Faculty> facultys = adminService.displayFacultys();
	      return ResponseEntity.ok(facultys);
	  }
	  
	  @DeleteMapping("/deletestudent")
	  public ResponseEntity<String> deleteStudent(@RequestParam int sid)
	  {
	      try
	      {
	          String output = adminService.deleteStudent(sid);
	          return ResponseEntity.ok(output);
	      }
	      catch(Exception e)
	      {
	          return ResponseEntity.status(500).body("Failed to Delete Student ... !!");
	      }
	  }
	  
	  @DeleteMapping("/deletefaculty")
	  public ResponseEntity<String> deleteFaculty(@RequestParam int iid)
	  {
	      try
	      {
	          String output = adminService.deleteFaculty(iid);
	          return ResponseEntity.ok(output);
	      }
	      catch(Exception e)
	      {
	          return ResponseEntity.status(500).body("Failed to Delete Faculty ... !!");
	      }
	  }
	  
	  @GetMapping("/studentcount")
	  public ResponseEntity<Long> getStudentCount()
	  {
	      long count = adminService.displayStudentCount();
	      return ResponseEntity.ok(count);
	  }

	  @GetMapping("/facultycount")
	  public ResponseEntity<Long> getFacultyCount()
	  {
	      long count = adminService.displayFacultyCount();
	      return ResponseEntity.ok(count);
	  }

	  @GetMapping("/coursecount")
	  public ResponseEntity<Long> getCourseCount()
	  {
	      long count = adminService.displayCourseCount();
	      return ResponseEntity.ok(count);
	  }
	  
	}


