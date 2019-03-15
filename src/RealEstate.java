/*
  The RealEstate class keeps informatin of real estates.
  It has a static counter that counts created object number and assigns id.
*/
public class RealEstate{

  private int id;
  private String type;
  private String status;
  private boolean available;
  private Address address;
  private int surfaceArea;
  private double price;
  private int roomNumber;

  private static int autoincrement = 1;

  //Constructor of RealEstate class. It also check given status of real estate and if the status is acceptible, it creates object.
  public RealEstate(String type, String status, Address address, int surfaceArea, double price, int roomNumber) throws IllegalArgumentException{

    if(!"For Rent".equalsIgnoreCase(status) && !"For Sale".equalsIgnoreCase(status))
      throw new IllegalArgumentException("Wrong real estate status! Expected : For Rent, For Sale");
    else{
      this.type = type;
      this.status = status;
      this.available = true;
      this.address = address;
      this.surfaceArea = surfaceArea;
      this.price = price;
      this.roomNumber = roomNumber;
      this.id = autoincrement++;
    }
  }

  public int getId(){
    return this.id;
  }
  public String getType(){
    return this.type;
  }
  public String getStatus(){
    return this.status;
  }
  public boolean isAvailable(){
    return this.available;
  }
  public Address getAddress(){
    return this.address;
  }
  public int getSurfaceArea(){
    return this.surfaceArea;
  }
  public double getPrice(){
    return this.price;
  }
  public int getRoomNumber(){
    return this.roomNumber;
  }

  //Returns the agent comission from this real estate.
  public double getAgentCommission(){

    if("Rented".equals(this.status))
      return price / 5; // 20/100

    return price / 200; // 5/1000

  }
  //Returns the company comission from this real estate.
  public double getCompanyComission(){

    if("Rented".equals(this.status))
      return (price / 5) * 4; // 80/100

    return (price / 200) * 3; // 15/1000
  }

  public void setAvailable(boolean available) {
  	this.available = available;
  }

  public void setStatus(String status){
    this.status = status;
  }

  //Gives proper output when a real estate is printed.
  @Override
  public String toString(){

    return String.format("%-4d %-15s %-12s %-27s %-5d %,10.2f %5d ",this.id, this.type, this.status, this.address, this.surfaceArea, this.price, this.roomNumber);
  }
}
