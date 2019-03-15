/*
  The Address class keeps address information.
  It is used by Person, Real Estate and Agency classes.
*/
public class Address{

  private String location;
  private String town;
  private String city;

  public Address(String location, String town, String city){

    this.location = location;
    this.town = town;
    this.city = city;

  }

  public String getLocation(){
    return this.location;
  }
  public String getTown(){
    return this.town;
  }
  public String getCity(){
    return this.city;
  }

  @Override
  public String toString(){

    return String.format("%-28s %-12s %-10s",this.location, this.town, this.city);
  }
}
