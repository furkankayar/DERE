
public class RealEstate{

  private int id;
  private String type;
  private String status;
  private String availability;
  private String address;
  private int surfaceArea;
  private double price;
  private int roomNumber;

  private static int autoincrement = 1;

  public RealEstate(String type, String status, String availability, String address,
                      int surfaceArea, double price, int roomNumber){

    this.type = type;
    this.status = status;
    this.availability = availability;
    this.address = address;
    this.surfaceArea = surfaceArea;
    this.price = price;
    this.roomNumber = roomNumber;
    this.id = autoincrement;
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
  public String getAvailability(){
    return this.availability;
  }
  public String getAddress(){
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
