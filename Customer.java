
public class Customer{

  private int id;
  private String name;
  private String birthdate;
  private String address;
  private String phone;
  private String gender;

  private static int autoincrement = 1;

  public Customer(String name, String birthdate, String address, String phone, String gender ){

    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
    this.id = autoincrement++;
  }

  public Customer(int id, String name, String birthdate, String adress, String phone, String gender){

    this.id = id;
    this.name = name;
    this.birthdate = birthdate;
    this.address = address;
    this.phone = phone;
    this.gender = gender;
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
  public String getAddress(){
    return this.address;
  }
  public String getPhone(){
    return this.phone;
  }
  public String getGender(){
    return this.gender;
  }

}
