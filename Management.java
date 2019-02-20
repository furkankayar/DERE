
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Management{

  private ArrayList<Agency> agencies;
  private ArrayList<Agent> agents;
  private ArrayList<Customer> customers;
  private ArrayList<RealEstate> realEstates;
  private ArrayList<Contract> contracts;

  public Management(){

    this.agencies = new ArrayList<Agency>();
    this.agents = new ArrayList<Agent>();
    this.customers = new ArrayList<Customer>();
    this.realEstates = new ArrayList<RealEstate>();
    this.contracts = new ArrayList<Contract>();

  }

  public ArrayList<Agency> getAgencies(){
    return this.agencies;
  }
  public ArrayList<Agent> getAgents(){
    return this.agents;
  }
  public ArrayList<Customer> getCustomers(){
    return this.customers;
  }
  public ArrayList<RealEstate> getRealEstates(){
    return this.realEstates;
  }
  public ArrayList<Contract> getContracts(){
    return this.contracts;
  }

  public void addNewAgency(String name, Address address, String phone){

    Agency agency = new Agency(name, address, phone);
    agencies.add(agency);
    System.out.println("The agency has been added successfully!");
  }

  public void displayAgencies(){

    for(Agency agency: agencies){
      System.out.println(agency);
    }
  }

  public void addNewAgent(Agency agency, String name, String birthdate,
                            Address address, String phone, String gender){

    Agent agent = new Agent(agency, name, birthdate, address, phone, gender);
    agents.add(agent);
  }

  public void addNewCustomer(String name, String birthdate, Address address, String phone, String gender ){

    Customer customer = new Customer(name, birthdate, address, phone, gender);
    customers.add(customer);
  }

  public void addNewRealEstate(String type, String status, Address address,
                                int surfaceArea, double price, int roomNumber){

    RealEstate realEstate = new RealEstate(type, status, address, surfaceArea, price, roomNumber);
    realEstates.add(realEstate);
  }

  public void addNewContract(int realEstateId, int customerId, int agentId, int contractDate){

    Contract contract = new Contract(realEstateId, customerId, agentId, contractDate);
    contracts.add(contract);
  }



  public void executeCommand(String command){

    String[] data = command.split(";");
    try{
      switch(data[0]){

          case "load": readFile(data[1]);break;
          case "addAgency": addNewAgency(data[1], new Address(data[2], data[3], data[4]), data[5]);break;
          case "displayAgencies": displayAgencies();break;
          case "addAgent": System.out.println("AddAgent");break;
          case "deleteAgent": System.out.println("DeleteAgent");break;
          case "displayAgents": System.out.println("DisplayAgents");break;
          case "addRealEstate": System.out.println("AddRealEstate");break;
          case "deleteRealEstate": System.out.println("DeleteRealEstate");break;
          case "displayRealEstates": System.out.println("DisplayRealEstates");break;
          case "addCustomer": System.out.println("AddCustomer");break;
          case "deleteCustomer": System.out.println("DeleteCustomer");break;
          case "displayCustomers": System.out.println("DisplayCustomers");break;
          case "addContract": System.out.println("AddContract");break;
          case "displayContracts": System.out.println("DisplayContracts");break;
          case "search": System.out.println("Search");break;
          case "calculateSalaries": System.out.println("CalculateSalaries");break;
          case "calculateTotalIncome": System.out.println("CalculateTotalIncome");break;
          case "mostProfitableAgency": System.out.println("MostProfitableAgency");break;
          case "agentOfTheMonth": System.out.println("AgentOfTheMonth");break;
          default: System.out.println("Unknown command!");break;

      }
    }
    catch(ArrayIndexOutOfBoundsException e){
      e.printStackTrace();
    }
    catch(FileNotFoundException e){
      e.printStackTrace();
    }
    catch(IOException e){
      e.printStackTrace();
    }

  }

  public void readFile(String fileName) throws FileNotFoundException, IOException{

    BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

    String row = null;
    int a = 1;
    while((row = br.readLine()) != null){
      System.out.print(a++ + " ");
      executeCommand(row);
    }
  }



}
