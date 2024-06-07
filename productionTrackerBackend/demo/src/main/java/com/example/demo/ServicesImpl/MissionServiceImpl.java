package com.example.demo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.MissionRepository;
import com.example.demo.Services.MissionService;
import com.example.demo.entities.Mission;
import com.example.demo.entities.StatusMission;
@Service
public class MissionServiceImpl implements MissionService{
	
	
	@Autowired
	MissionRepository misrep;
	
	@Autowired
	public MissionServiceImpl(MissionRepository misrep) {
		super();
		this.misrep = misrep;
	}

	
	
	@Override
	public List<Mission> getAllMissionList() {
		// TODO Auto-generated method stub
		return misrep.findAll();
	}

	

	@Override
	public Mission saveMission(Mission Mission) {
		// TODO Auto-generated method stub
		return misrep.save(Mission);
	}

	@Override
	public Mission getMissionById(Long id) {
		// TODO Auto-generated method stub
		return misrep.getById(id);
	}

	@Override
	public Mission editMission(Mission Mission) {
		// TODO Auto-generated method stub
		return misrep.save(Mission);
	}

	@Override
	public Long countMissions() {
		// TODO Auto-generated method stub
		return misrep.count();
	}

	@Override
	public void deleteMissionById(Long id) {
		// TODO Auto-generated method stub
	
		misrep.delete(misrep.getById(id));
	}



	@Override
	public List<Mission> EndMissions(int year) {
			// TODO Auto-generated method stub
		return misrep.findByYearAndStatus(year, StatusMission.DONE);
	}
	@Override
	public double calculateMissionsPercentage(int year) {
	    // Count total number of missions
	    long totalMissions = misrep.count(); 
	    
	    if (totalMissions == 0) {
	        return 0.0; // Avoid division by zero
	    }
	    
	    // Count number of missions completed in the specified year
	    int missionsCompletedInYear = misrep.countByYearAndStatus(year, StatusMission.DONE); 
	    
	    // Calculate percentage
	    double percentage = ((double) missionsCompletedInYear / totalMissions) * 100.0;
	    
	    return percentage;
	}

}
