

public class Agent extends Customer{

  private Agency agency;
  private double salary;

  private static int autoincrement = 1;

  public Agent(Agency agency, String name, String birthdate,
                Address address, String phone, String gender ){

    super(autoincrement++, name, birthdate, address, phone, gender);
    this.agency = agency;
    this.salary = 2000.00;

  }


  public Agency getAgency(){
    return this.agency;
  }
  public double getSalary(){
    return this.salary;
  }


}
