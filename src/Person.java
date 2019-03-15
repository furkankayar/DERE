/*
  The Person class keeps person information. It is super class of Agent and Customer classes.
*/
public class Person{

  private String name;
  private Date birthdate;
  private Address address;
  private Phone phone;
  private String gender;

  //Constructor of Person class.
  public Person(String name, Date birthdate, Address address, Phone phone, String gender){

    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;

  }

  public String getName(){
    return this.name;
  }
  public Date getBirthdate(){
    return this.birthdate;
  }
  public Address getAddress(){
    return this.address;
  }
  public Phone getPhone(){
    return this.phone;
  }
  public String getGender(){
    return this.gender;
  }

  //Gives proper output when a person is printed.
  @Override
  public String toString(){
    return String.format("%-15s %-12s %-27s %-13s %-6s", this.name, this.birthdate, this.address, this.phone, this.gender);
  }
}
