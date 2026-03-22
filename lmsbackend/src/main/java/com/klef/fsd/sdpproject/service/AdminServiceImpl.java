package com.klef.fsd.sdpproject.service;

	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.klef.fsd.sdpproject.model.Admin;
	import com.klef.fsd.sdpproject.model.Student;
	import com.klef.fsd.sdpproject.model.Faculty;
	import com.klef.fsd.sdpproject.repository.AdminRepository;
	import com.klef.fsd.sdpproject.repository.StudentRepository;
	import com.klef.fsd.sdpproject.repository.FacultyRepository;
	import com.klef.fsd.sdpproject.repository.CourseRepository;

	@Service
	public class AdminServiceImpl implements AdminService
	{
	    @Autowired
	    private AdminRepository adminRepository;

	    @Autowired
	    private FacultyRepository facultyRepository;

	    @Autowired
	    private StudentRepository studentRepository;

	    @Autowired
	    private CourseRepository courseRepository;

	    @Override
	    public Admin checkadminlogin(String username, String password) 
	    {
	        return adminRepository.findByUsernameAndPassword(username, password);
	    }

	    @Override
	    public String addFaculty(Faculty faculty) 
	    {
	        facultyRepository.save(faculty);
	        return "Faculty Added Successfully";
	    }

	    @Override
	    public List<Faculty> displayFacultys() 
	    {
	        return facultyRepository.findAll();
	    }

	    @Override
	    public List<Student> displayStudents() 
	    {
	        return studentRepository.findAll();
	    }

	    @Override
	    public String deleteStudent(int id) 
	    {
	        Optional<Student> student = studentRepository.findById(id);

	        if (student.isPresent()) 
	        {
	            studentRepository.deleteById(id);
	            return "Student Deleted Successfully";
	        } 
	        else 
	        {
	            return "Student ID Not Found";
	        }
	    }

	    @Override
	    public String deleteFaculty(int id) 
	    {
	        Optional<Faculty> faculty = facultyRepository.findById(id);

	        if (faculty.isPresent()) 
	        {
	            facultyRepository.deleteById(id);
	            return "Faculty Deleted Successfully";
	        } 
	        else 
	        {
	            return "Faculty ID Not Found";
	        }
	    }

	    @Override
	    public long displayStudentCount() 
	    {
	        return studentRepository.count();
	    }

	    @Override
	    public long displayFacultyCount() 
	    {
	        return facultyRepository.count();
	    }

	    @Override
	    public long displayCourseCount() 
	    {
	        return courseRepository.count();
	    }
	}


