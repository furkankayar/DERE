
public class Contract{

  private int id;
  private int realEstateId;
  private int customerId;
  private int agentId;
  private int contractDate;

  private static int autoincrement;

  public Contract(int realEstateId, int customerId, int agentId, int contractDate){

    this.realEstateId = realEstateId;
    this.customerId = customerId;
    this.agentId = agentId;
    this.contractDate = contractDate;
    this.id = autoincrement++;
  }

  public int getId(){
    return this.id;
  }
  public int getRealEstateId(){
    return this.realEstateId;
  }
  public int getCustomerId(){
    return this.customerId;
  }
  public int getAgentId(){
    return this.agentId;
  }
  public int getContractDate(){
    return this.contractDate;
  }



}
