/*
  The Agent class keeps the information of agents just like database table.
  It has an static counter that counts created object number and assigns id.
  This class extends person class.
*/

public class Agent extends Person{

  private int id;
  private boolean active;
  private Agency agency;
  private double salary;
  private static int autoincrement = 1;

  //Constructor of Agent class. It also calls Person class' constructor.
  public Agent(Agency agency, String name, Date birthdate, Address address, Phone phone, String gender ){

    super(name, birthdate, address, phone, gender);
    if(!address.getCity().equalsIgnoreCase(agency.getAddress().getCity()))
      throw new IllegalArgumentException("Agent and Agency city mismatch! Agent must be in same city with agency.");

    this.agency = agency;
    this.salary = 2000.00;
    this.active = true;
    this.id = autoincrement++;

  }
  public int getId(){
    return this.id;
  }
  public Agency getAgency(){
    return this.agency;
  }
  public double getSalary(){
    return this.salary;
  }
  public boolean isActive(){
    return this.active;
  }
  public void setActive(boolean active){
    this.active = active;
  }

  //Gives proper output when an agent is printed.
  @Override
  public String toString(){

    return String.format("%-5d %-73s", this.id, super.toString());
  }
}
