/*
  The Agency class keeps agenct information.
  It has an static counter that counts created object number and assigns id.
*/

public class Agency{

  private int id;
  private String name;
  private Address address;
  private Phone phone;

  private static int autoincrement = 1;

  public Agency(String name, Address address, Phone phone){

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
  public Phone getPhone(){
    return this.phone;
  }

  @Override
  public String toString(){

    return String.format("%-5d %-20s %-27s %-13s",this.id, this.name, this.address, this.phone);
  }

}
