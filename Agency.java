

public class Agency{

  private int id;
  private String name;
  private String address;
  private String phone;

  private static int autoincrement = 1;

  public Agency(String name, String address, String phone){

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
  public String getAddress(){
    return this.address;
  }
  public String getPhone(){
    return this.phone;
  }


}
