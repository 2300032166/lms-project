package com.klef.fsd.sdpproject.repository;

	import java.util.List;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.Modifying;
	import org.springframework.data.jpa.repository.Query;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.klef.fsd.sdpproject.model.Student;

	@Repository
	public interface StudentRepository extends JpaRepository<Student, Integer> {

	    // Find Student by username and password
	    public Student findByUsernameAndPassword(String username, String password);

	    // Find Students by gender
	    @Query("select s from Student s where s.gender=?1")
	    public List<Student> displayStudentByGender(String gender);

	    // Delete Students by location
	    @Modifying
	    @Transactional
	    @Query("delete from Student s where s.location=?1")
	    public int deleteStudentByLocation(String location);

	    // Count the total number of Students
	    @Query("select count(s) from Student s")
	    public long studentCount();
	}


