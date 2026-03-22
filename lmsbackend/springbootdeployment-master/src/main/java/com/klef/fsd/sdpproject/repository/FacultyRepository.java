package com.klef.fsd.sdpproject.repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;
	import com.klef.fsd.sdpproject.model.Faculty;

	@Repository
	public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
	    Faculty findByUsernameAndPassword(String username, String password);
	}


