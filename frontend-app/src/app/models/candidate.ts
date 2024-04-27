export class Candidate {
  id?:number
  name:string
  email:string
  dob:string
  partyName:string
  address:string

  constructor(id: number, name: string, email: string, dob: string, partyName: string, address: string) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
    this.partyName = partyName;
    this.address = address;
  }
}
