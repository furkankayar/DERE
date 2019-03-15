/*
  The Agent class keeps the information of Customers just like database table.
  It has an static counter that counts created object number and assigns id.
  This class extends person class.
*/

public class Customer extends Person{

  private int id;
  private boolean active;
  private static int autoincrement = 1;

  //Constructor of Agent class. It also calls Person class' constructor.
  public Customer(String name, Date birthdate, Address address, Phone phone, String gender ){

    super(name, birthdate, address, phone, gender);
    this.active = true;
    this.id = autoincrement++;
  }


  public int getId(){
    return this.id;
  }
  public boolean isActive(){
    return this.active;
  }
  public void setActive(boolean active){
    this.active = active;
  }

  //Gives proper output when an customer is printed.
  @Override
  public String toString(){

    return String.format("%-5d %-73s", this.id, super.toString());
  }
}
