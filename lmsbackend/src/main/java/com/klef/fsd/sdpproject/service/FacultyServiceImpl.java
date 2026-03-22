package com.klef.fsd.sdpproject.service;

	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import com.klef.fsd.sdpproject.model.Faculty;
	import com.klef.fsd.sdpproject.repository.FacultyRepository;

	@Service
	public class FacultyServiceImpl implements FacultyService {

	    @Autowired
	    private FacultyRepository facultyRepository;

	    @Override
	    public Faculty checkFacultyLogin(String username, String password) {
	        return facultyRepository.findByUsernameAndPassword(username, password);
	    }

	    @Override
	    public String addFaculty(Faculty faculty) {
	        facultyRepository.save(faculty);
	        return "Faculty Added Successfully";
	    }

	    @Override
	    public List<Faculty> viewAllFaculty() {
	        return facultyRepository.findAll();
	    }

	    @Override
	    public Faculty getFacultyById(int id) {
	        return facultyRepository.findById(id).orElse(null);
	    }
	}


