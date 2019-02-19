

public class Agent{

  private int id;
  private String name;
  private Agency agency;
  private String birthdate;
  private String address;
  private String phone;
  private String gender;
  private double salary;

  private static int autoincrement = 1;

  public Agent(String name, Agency agency, String birthdate,
                String address, String phone, String gender, double salary ){

    this.name = name;
    this.agency = agency;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
    this.salary = salary;
    this.id = autoincrement++;
  }

  public int getId(){
    return this.id;
  }
  public String getName(){
    return this.name;
  }
  public Agency getAgency(){
    return this.agency;
  }
  public String getBirthdate(){
    return this.birthdate;
  }
  public String getAddress(){
    return this.address;
  }
  public String getPhone(){
    return this.phone;
  }
  public String getGender(){
    return this.gender;
  }
  public double getSalary(){
    return this.salary;
  }


}
