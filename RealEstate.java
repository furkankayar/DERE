
public class RealEstate{

  private int id;
  private String type;
  private String status;
  private boolean availability;
  private Address address;
  private int surfaceArea;
  private double price;
  private int roomNumber;


  private static int autoincrement = 1;

  public RealEstate(String type, String status, Address address,
                      int surfaceArea, double price, int roomNumber){

    this.type = type;
    this.status = status;
    this.availability = true;
    this.address = address;
    this.surfaceArea = surfaceArea;
    this.price = price;
    this.roomNumber = roomNumber;
    this.id = autoincrement++;
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
    return this.availability;
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
}
