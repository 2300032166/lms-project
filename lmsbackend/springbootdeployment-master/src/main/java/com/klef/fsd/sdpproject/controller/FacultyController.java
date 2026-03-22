package com.klef.fsd.sdpproject.controller;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.*;

	import com.klef.fsd.sdpproject.model.Faculty;
	import com.klef.fsd.sdpproject.service.FacultyService;

	@RestController
	@RequestMapping("/api/faculty")
	@CrossOrigin(origins = "*")
	public class FacultyController {

	    @Autowired
	    private FacultyService facultyService;

	    // Login
	    @PostMapping("/login")
	    public Faculty login(@RequestParam String username, @RequestParam String password) {
	        return facultyService.checkFacultyLogin(username, password);
	    }

	    // Add new faculty
	    @PostMapping("/add")
	    public String addFaculty(@RequestBody Faculty faculty) {
	        return facultyService.addFaculty(faculty);
	    }

	    // View all faculty
	    @GetMapping("/all")
	    public List<Faculty> getAllFaculty() {
	        return facultyService.viewAllFaculty();
	    }

	    // Get faculty by id
	    @GetMapping("/{id}")
	    public Faculty getFacultyById(@PathVariable int id) {
	        return facultyService.getFacultyById(id);
	    }
	}


