package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Mission;


public interface MissionService {
	public List<Mission> getAllMissionList();
    public Mission saveMission(Mission Mission );
    public Mission getMissionById(Long id);
    public Mission editMission(Mission Mission) ;
    public Long countMissions();
    public void deleteMissionById(Long id);
	List<Mission> EndMissions(int year);
	double calculateMissionsPercentage(int year);

}
