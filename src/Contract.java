/*
  The contract class keeps contract information.
  It keeps related Real Estate, Agent and Customer.
  It has a static counter that counts created object number and assigns id.
*/
public class Contract{

  private int id;
  private RealEstate realEstate;
  private Customer customer;
  private Agent agent;
  private Date contractDate;

  private static int autoincrement = 1;

  //Constructor of Contract class. It also checks cities of real estate and agent. If cities are same, it creates a new contract.
  public Contract(RealEstate realEstate, Customer customer, Agent agent, Date contractDate){

    if(!agent.getAddress().getCity().equalsIgnoreCase(realEstate.getAddress().getCity()))
      throw new IllegalArgumentException("Agent and Real Estate city mismatch! Agent can not sell or rent real estate from another city.");

    this.realEstate = realEstate;
    this.customer = customer;
    this.agent = agent;
    this.contractDate = contractDate;
    this.id = autoincrement++;
  }

  public int getId(){
    return this.id;
  }
  public RealEstate getRealEstate(){
    return this.realEstate;
  }
  public Customer getCustomer(){
    return this.customer;
  }
  public Agent getAgent(){
    return this.agent;
  }
  public Date getContractDate(){
    return this.contractDate;
  }

  @Override
  public String toString(){

    return String.format("%-10d %-10d %-12s %-22s %-22s %,10.2f %15s  ",this.id, this.realEstate.getId(), this.realEstate.getStatus(), this.customer.getName(), this.agent.getName(), this.realEstate.getPrice(), this.contractDate);
  }

}
