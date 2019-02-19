

public class Agent extends Customer{

  private Agency agency;
  private double salary;

  private static int autoincrement = 1;

  public Agent(String name, Agency agency, String birthdate,
                String address, String phone, String gender, double salary ){
                  
    super(autoincrement++, name, birthdate, address, phone, gender);
    this.agency = agency;
    this.salary = salary;

  }


  public Agency getAgency(){
    return this.agency;
  }
  public double getSalary(){
    return this.salary;
  }


}
