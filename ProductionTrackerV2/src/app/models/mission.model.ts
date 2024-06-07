export enum StatusMission {
  DONE = 'DONE',
  IN_PROGRESS = 'IN_PROGRESS'
}

export class Mission {
  id: number;
  name: string;
  status: StatusMission;
  year: string;



  constructor(id: number, name: string, status: StatusMission, year: string) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.year = year;
}
}
