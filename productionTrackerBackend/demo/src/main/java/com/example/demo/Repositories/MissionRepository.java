package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Mission;
import com.example.demo.entities.StatusMission;

public interface MissionRepository extends JpaRepository<Mission,Long>{

	
	 @Query("SELECT m FROM Mission m WHERE YEAR(m.year) = :year AND m.status = :status")
	    List<Mission> findByYearAndStatus(@Param("year") int year, @Param("status") StatusMission status);
	 
	 @Query("SELECT COUNT(m) FROM Mission m WHERE YEAR(m.year) = :year AND m.status = :status")
	   int countByYearAndStatus(@Param("year") int year, @Param("status") StatusMission status);
	
}
