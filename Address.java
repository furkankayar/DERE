
public class Address{

  private String address;
  private String town;
  private String city;

  public Address(String address, String town, String city){

    this.address = address;
    this.town = town;
    this.city = city;
  }

  public String getAddress(){
    return this.address;
  }
  public String getTown(){
    return this.town;
  }
  public String getCity(){
    return this.city;
  }

  @Override
  public String toString(){

    return "Address: " + this.address + " Town: " + this.town + " City: " + this.city; 
  }
}
