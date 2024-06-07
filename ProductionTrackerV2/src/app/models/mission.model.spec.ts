import { Mission, StatusMission } from './mission.model';

describe('Mission', () => {
  it('should create an instance', () => {
    const MissionCONSTRUCTOR = new Mission(1, "Sample Mission", StatusMission.IN_PROGRESS, "2023");
    expect(MissionCONSTRUCTOR).toBeTruthy();
  });
});
