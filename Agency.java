

public class Agency{

  private int id;
  private String name;
  private Address address;
  private String phone;

  private static int autoincrement = 1;

  public Agency(String name, Address address, String phone){

    this.name = name;
    this.address = address;
    this.phone = phone;
    this.id = autoincrement++;
  }

  public int getId(){
    return this.id;
  }
  public String getName(){
    return this.name;
  }
  public Address getAddress(){
    return this.address;
  }
  public String getPhone(){
    return this.phone;
  }

  @Override
  public String toString(){

    return "Name: " + this.name + " " + this.address + " Phone: " + this.phone;  
  }

}
