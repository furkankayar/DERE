
public class Customer{

  private int id;
  private String name;
  private String birthdate;
  private Address address;
  private String phone;
  private String gender;
  private boolean activity;

  private static int autoincrement = 1;

  public Customer(String name, String birthdate, Address address, String phone, String gender ){

    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
    this.activity = true;
    this.id = autoincrement++;
  }

  public Customer(int id, String name, String birthdate, Address adress, String phone, String gender){

    this.id = id;
    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
    this.activity = true;
  }

  public int getId(){
    return this.id;
  }
  public String getName(){
    return this.name;
  }
  public String getBirthdate(){
    return this.birthdate;
  }
  public Address getAddress(){
    return this.address;
  }
  public String getPhone(){
    return this.phone;
  }
  public String getGender(){
    return this.gender;
  }
  public boolean isActive(){
    return this.activity;
  }

}
