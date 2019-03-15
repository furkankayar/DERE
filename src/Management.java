/*
  The Management class manages all models(Customer, Agent, Agency, Contract, Real Estate).
  It performs all required operations on these models.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Management{

  private ArrayList agencies;
  private ArrayList agents;
  private ArrayList customers;
  private ArrayList realEstates;
  private ArrayList contracts;

  private UserInterface ui;
  public static boolean isStreaming = false;


  public Management(UserInterface ui){

    this.agencies = new ArrayList();
    this.agents = new ArrayList();
    this.customers = new ArrayList();
    this.realEstates = new ArrayList();
    this.contracts = new ArrayList();
    this.ui = ui;

  }

  /////////////////

  private void addNewAgency(String name, Address address, Phone phone){

    Agency agency = new Agency(name, address, phone);
    agencies.add(agency);
    ui.printSuccess("The agency has been added successfully! ID: " + agency.getId());
  }

  private void displayAgencies(){

    ui.printHeader(String.format("%69s \n\n %-5s %-20s %-28s %-12s %-10s %-13s", "----- Agencies -----", "ID", "Name", "Address", "Town", "City", "Phone"));

    boolean trigger = isStreaming;
    isStreaming = true;
    int i = 1;
    for(Object agency: agencies.toList())
      ui.print(agency.toString(), i++);

    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");
  }

  private Agency findAgency(int id) {

    try{
      return (Agency)agencies.get(id-1);
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The agency has not been found! Check given ID and try again: " + id);
    }
  }

  /////////////////

  private void addNewAgent(Agency agency, String name, String birthdate, Address address, Phone phone, String gender) {

    String[] date = birthdate.split("/");
    int day = 0;
    int month = 0;
    int year = 0;

    try{
      day = Integer.valueOf(date[0]);
      month = Integer.valueOf(date[1]);
      year = Integer.valueOf(date[2]);
    }catch(Exception e){
      throw new IllegalArgumentException("Wrong date format! Expected: dd/mm/yyyy");
    }

    Agent agent = new Agent(agency, name, new Date(day, month, year), address, phone, gender);
    agents.add(agent);
    ui.printSuccess("The agent has been added successfully! ID: " + agent.getId());
  }

  private void displayAgents(){

    ui.printHeader(String.format("%68s \n\n %-5s %-15s %-12s %-28s %-12s %-10s %-13s %-5s","----- Agents -----", "ID", "Name", "Birthdate", "Address", "Town", "City","Phone" , "Gender"));

    boolean trigger = isStreaming;
    isStreaming = true;
    int i = 1;
    for(Object obj: agents.toList()){
      Agent agent = (Agent)obj;
      if (agent.isActive())
        ui.print(agent.toString(), i++);
      else
        ui.printDeletedRecord(agent.toString());
    }
    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");
  }

  private Agent findAgent(int id) {

    try{
      Agent agent = (Agent)agents.get(id-1);
      if(agent.isActive())
        return agent;
      else
        throw new IllegalArgumentException("The agent has not been found! Check given ID and try again: " + id);
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The agent has not been found! Check given ID and try again: " + id);
    }
  }

  private void deleteAgent(int id) {

    Agent agent = findAgent(id);
    agent.setActive(false);
    ui.printSuccess("The agent has been deleted successfully! ID: " + agent.getId());
  }

  /////////////////

  private void addNewCustomer(String name, String birthdate, Address address, Phone phone, String gender ) {

    String[] date = birthdate.split("/");
    int day = 0;
    int month = 0;
    int year = 0;

    try{
      day = Integer.valueOf(date[0]);
      month = Integer.valueOf(date[1]);
      year = Integer.valueOf(date[2]);
    }catch(Exception e){
      throw new IllegalArgumentException("Wrong date format! Expected: dd/mm/yyyy");
    }

    Customer customer = new Customer(name, new Date(day,month,year), address, phone, gender);
    customers.add(customer);
    ui.printSuccess("The customer has been added succesfully! ID: " + customer.getId());
  }

  private void displayCustomers(){

    ui.printHeader(String.format("%68s \n\n %-5s %-15s %-12s %-28s %-12s %-10s %-13s %-5s","----- Customers -----", "ID", "Name", "Birthdate", "Address", "Town", "City","Phone" , "Gender"));

    boolean trigger = isStreaming;
    isStreaming = true;
    int i = 1;
    for(Object obj: customers.toList()){
      Customer customer = (Customer)obj;
      if (customer.isActive())
        ui.print(customer.toString(), i++);
      else
        ui.printDeletedRecord(customer.toString());
    }
    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");

  }

  private Customer findCustomer(int id){

    try{
      Customer customer = (Customer)customers.get(id-1);
      if(customer.isActive())
        return customer;
      else
        throw new IllegalArgumentException("The customer has not been found! Check given ID and try again: " + id);
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The customer has not been found! Check given ID and try again: " + id);
    }
  }

  private void deleteCustomer(int id) {

    Customer customer = findCustomer(id);
    customer.setActive(false);
    ui.printSuccess("The customer has been deleted successfully! ID: " + customer.getId());
  }

  /////////////////

  private void addNewRealEstate(String type, String status, Address address, int surfaceArea, double price, int roomNumber) {

    RealEstate realEstate = new RealEstate(type, status, address, surfaceArea, price, roomNumber);
    realEstates.add(realEstate);
    ui.printSuccess("The real estate has been added succesfully! ID: " + realEstate.getId());
  }

  private void displayRealEstates(){

    ui.printHeader(String.format("%70s \n\n %-4s %-15s %-12s %-28s %-12s %-8s %-9s %-8s %-2s","----- Real Estates -----", "ID", "Type", "Status", "Address", "Town", "City", "S.Area", "Price", "Room N."));

    boolean trigger = isStreaming;
    isStreaming = true;
    int i = 1;
    for(Object obj: realEstates.toList()){
      RealEstate realEstate = (RealEstate)obj;
      if (realEstate.isAvailable())
        ui.print(realEstate.toString(), i++);
      else
        ui.printDeletedRecord(realEstate.toString());
    }

    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");

  }

  private RealEstate findRealEstate(int id) {

    try{
      RealEstate realEstate = (RealEstate)realEstates.get(id-1);
      if(realEstate.isAvailable())
        return realEstate;
      else
        if(realEstate.getStatus().equalsIgnoreCase("Rented"))
          throw new IllegalArgumentException("The real estate is already rented! ID: " + id);
        else
          throw new IllegalArgumentException("The real estate is already sold! ID: " + id);
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The real estate has not been found! Check given ID and try again: " + id);
    }
  }

  private void deleteRealEstate(int id) {

    RealEstate realEstate = findRealEstate(id);
    realEstate.setAvailable(false);
    ui.printSuccess("The real estate has been deleted successfully! ID: " + realEstate.getId());
  }

  /////////////////

  private void addNewContract(int realEstateId, int customerId, int agentId, String contractDate){

    String[] date = contractDate.split("/");
    int day = 0;
    int month = 0;
    int year = 0;

    try{
      day = Integer.valueOf(date[0]);
      month = Integer.valueOf(date[1]);
      year = Integer.valueOf(date[2]);
      RealEstate realEstate = findRealEstate(realEstateId);
      Contract contract = new Contract(realEstate, findCustomer(customerId), findAgent(agentId), new Date(day,month,year));
      realEstate.setAvailable(false);
      if(realEstate.getStatus().equalsIgnoreCase("For Rent")) realEstate.setStatus("Rented");
      else if(realEstate.getStatus().equalsIgnoreCase("For Sale")) realEstate.setStatus("Sold");
      contracts.add(contract);
      ui.printSuccess("The contract has been added succesfully! ID: " + contract.getId());
    }
    catch(ArrayIndexOutOfBoundsException e){
      throw new IllegalArgumentException("Wrong date format! Expected : dd/mm/yyyy");
    }
    catch(NumberFormatException e){
      throw new IllegalArgumentException("Wrong date format! Expected : dd/mm/yyyy");
    }

  }

  private void displayContracts(){

    ui.printHeader(String.format("%67s \n\n %-6s %-14s %-14s %-23s %-22s %-11s %-13s","----- Contracts -----", "ID", "Real E. ID", "Status","Customer", "Agent", "Price", "Contract Date"));

    boolean trigger = isStreaming;
    isStreaming = true;

    int i = 1;
    for(Object obj: contracts.toList()){
      Contract contract = (Contract)obj;
      ui.print(contract.toString(), i++);
    }

    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");

  }

  /////////////////

  //It calculates the salaries of agents on given month. It counts the commision of agents from their contracts and determies salaries.
  private void calculateSalaries(String command){

    String[] data = command.split("/");
    if(data.length != 2 ){
      throw new IllegalArgumentException("Wrong date format! Expected: mm/yyyy");
    }

    Date date = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
    boolean trigger = isStreaming;
    isStreaming = true;
    int i = 1;

    ui.printHeader(String.format("%46s \n\n %-22s %-28s %-20s ","----- Salaries "+ date.getMonth() + "/" + date.getYear() +" -----", "ID", "Agent", "Salary"));

    for(Object agentObj: agents.toList()){
      Agent agent = (Agent)agentObj;
      double salary = agent.getSalary();
      for(Object contractObj : contracts.toList()){
        Contract contract = (Contract)contractObj;
        if (contract.getAgent().getId() == agent.getId() && contract.getContractDate().equals(date)){
          RealEstate realEstate = contract.getRealEstate();
          double commission = realEstate.getAgentCommission();
          salary += commission;
        }
      }
      if(agent.isActive())
        ui.print(String.format("%-20d %-30s %-10.2f",agent.getId(),agent.getName(),salary),i++);
      else
        ui.printDeletedRecord(String.format("%-20d %-30s %-10.2f",agent.getId(),agent.getName(),salary));
    }

    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");

  }

  //Calculates total income on given month. It counts the all company commision on given month.
  private void calculateTotalIncome(String command){

    String[] data = command.split("/");
    if(data.length != 2 ){
      throw new IllegalArgumentException("Wrong date format! Expected: mm/yyyy");
    }

    Date date = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
    double totalIncome = 0.0d;
    for(Object contractObj : contracts.toList()){
      Contract contract = (Contract)contractObj;
      if(contract.getContractDate().equals(date)){
        totalIncome += contract.getRealEstate().getCompanyComission();
      }
    }
    ui.append(" Total Income on ", 255, 255, 255);
    ui.append(date.getMonth() + "/" + date.getYear(), 34, 133, 232);
    ui.append(" is ", 255, 255, 255);
    ui.append(String.format("%,.2f",totalIncome), 34, 133, 232);
    ui.append(" TL.\n", 255, 255, 255);
    ui.print("");
  }

  //Calculates most profitable agency on given month. It counts the commisions of agencies from contracts and determines best agency.
  private void mostProfitableAgency(String command){

    String[] data = command.split("/");
    if(data.length != 2 ){
      throw new IllegalArgumentException("Wrong date format! Expected: mm/yyyy");
    }

    Date date = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
    Agency mostProfitableAgency = null;
    double maxProfit = 0.0d;

    for(Object agencyObj : agencies.toList()){
      Agency agency = (Agency)agencyObj;
      double totalProfit = 0.0d;
      for(Object contractObj : contracts.toList()){
        Contract contract = (Contract)contractObj;
        if(agency.equals(contract.getAgent().getAgency()) && contract.getContractDate().equals(date)){
          totalProfit += contract.getRealEstate().getCompanyComission();
        }
      }

      if(totalProfit > maxProfit){
        maxProfit = totalProfit;
        mostProfitableAgency = agency;
      }
    }

    if(mostProfitableAgency != null){
      ui.append(" The most profitable agency on ", 255, 255, 255);
      ui.append(date.getMonth() + "/" + date.getYear(), 34, 133, 232);
      ui.append(" is ", 255, 255, 255);
      ui.append(mostProfitableAgency.getName(), 34, 133, 232);
      ui.append(" with total income: ", 255, 255, 255);
      ui.append(String.format("%,.2f", maxProfit), 34, 133, 232);
      ui.append(" TL.\n", 255, 255, 255);
      ui.print("");
    }
    else{
      ui.printError("There is not any sales or rentals on given month.");
    }
  }

  // Calculates the agent of the given month. It counts the commissions of all agents from their contracts and determines the best agent.
  private void agentOfTheMonth(String command){

    String[] data = command.split("/");
    if(data.length != 2 ){
      throw new IllegalArgumentException("Wrong date format! Expected: mm/yyyy");
    }

    Date date = new Date(Integer.valueOf(data[0]), Integer.valueOf(data[1]));
    Agent agentOfTheMonth = null;
    int maxRentals = 0;
    int maxSales = 0;
    double maxProfit = 0.0d;

    for(Object agentObj : agents.toList()){
      Agent agent = (Agent)agentObj;
      int totalRentals = 0;
      int totalSales = 0;
      double totalProfit = 0.0d;
      for(Object contractObj : contracts.toList()){
        Contract contract = (Contract)contractObj;
        if(contract.getAgent().getId() == agent.getId() && contract.getContractDate().equals(date)){
          RealEstate realEstate = contract.getRealEstate();
          if(realEstate.getStatus().equals("For Sale"))
            totalSales++;
          else
            totalRentals++;
          totalProfit += realEstate.getAgentCommission();
        }
      }
      if(totalRentals + totalSales > maxRentals + maxSales || (totalRentals + totalSales == maxRentals + maxSales && totalProfit > maxProfit)){
        maxRentals = totalRentals;
        maxSales = totalSales;
        maxProfit = totalProfit;
        agentOfTheMonth = agent;
      }
    }
    if(agentOfTheMonth != null){

      ui.append(" The best agent of ", 255, 255, 255);
      ui.append(date.getMonth() + "/" + date.getYear(), 34, 133, 232);
      ui.append(" is ", 255, 255, 255);
      ui.append(agentOfTheMonth.getName(), 34, 133, 232);
      ui.append(" with ", 255, 255, 255);
      ui.append(maxSales + " sales", 34, 133, 232);
      ui.append(" and ", 255, 255, 255);
      ui.append(maxRentals + " rentals", 34, 133, 232);
      ui.append(" from ", 255, 255, 255);
      ui.append(agentOfTheMonth.getAgency().getName() + "\n", 34, 133, 232);
      ui.print("");
    }
    else{
      ui.printError("There is not any sales or rentals on given month.");
    }
  }

  //It searches real estates with given parameters. Empty parameters does not do any changes.
  private void search(String type, String status, String town, String city, String surfaceAreaRange, String priceRange, String roomRange){

    int surfaceAreaMin = 0;
    int surfaceAreaMax = 0;
    double priceMin = 0;
    double priceMax = 0;
    int roomMin = 0;
    int roomMax = 0;
    try{
      surfaceAreaMin = !surfaceAreaRange.equals("") ? Integer.valueOf(surfaceAreaRange.split("-")[0]) : 0;
      surfaceAreaMax = !surfaceAreaRange.equals("") ? Integer.valueOf(surfaceAreaRange.split("-")[1]) : 0;
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The surface area parameter must be in range!");
    }
    try{
      priceMin = !priceRange.equals("") ? Double.valueOf(priceRange.split("-")[0]) : 0;
      priceMax = !priceRange.equals("") ? Double.valueOf(priceRange.split("-")[1]) : 0;
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The price parameter must be in range!");
    }
    try{
      roomMin = !roomRange.equals("") ? Integer.valueOf(roomRange.split("-")[0]) : 0;
      roomMax = !roomRange.equals("") ? Integer.valueOf(roomRange.split("-")[1]) : 0;
    }
    catch(IndexOutOfBoundsException ex){
      throw new IllegalArgumentException("The room number parameter must be in range!");
    }

    ui.printHeader(String.format("%70s \n\n %-4s %-15s %-12s %-28s %-12s %-8s %-9s %-8s %-2s","----- Search Results -----", "ID", "Type", "Status", "Address", "Town", "City", "S.Area", "Price", "Room N."));

    boolean trigger = isStreaming;
    isStreaming = true;

    int i = 1;
    for(Object realEstateObj : realEstates.toList()){
      RealEstate realEstate = (RealEstate)realEstateObj;

      if(!type.equals("") && !realEstate.getType().equalsIgnoreCase(type))
        continue;
      else if(!status.equals("") && !realEstate.getStatus().equalsIgnoreCase(status))
        continue;
      else if(!town.equals("") && !realEstate.getAddress().getTown().equalsIgnoreCase(town))
        continue;
      else if(!city.equals("") && !realEstate.getAddress().getCity().equalsIgnoreCase(city))
        continue;
      else if(surfaceAreaMin != 0 && realEstate.getSurfaceArea() < surfaceAreaMin)
        continue;
      else if(surfaceAreaMax != 0 && realEstate.getSurfaceArea() > surfaceAreaMax)
        continue;
      else if(priceMin != 0 && realEstate.getPrice() < priceMin)
        continue;
      else if(priceMax != 0 && realEstate.getPrice() > priceMax)
        continue;
      else if(roomMin != 0 && realEstate.getRoomNumber() < roomMin)
        continue;
      else if(roomMax != 0 && realEstate.getRoomNumber() > roomMax)
        continue;

      if(realEstate.isAvailable())
        ui.print(realEstate.toString(), i++);
      else
        ui.printDeletedRecord(realEstate.toString());
    }


    if(trigger) isStreaming = true; else isStreaming = false;
    ui.print("");

  }

  //It creates a new command object and executes required operation for given command.
  public void executeCommand(String arg){
    Command command = null;
    try{
      command = new Command(arg);

      switch(command.get(0).toLowerCase()){
          case "load": readFile(command.get(1));break;
          case "addagency": addNewAgency(command.get(1), new Address(command.get(2), command.get(3), command.get(4)), new Phone(command.get(5)));break;
          case "displayagencies": displayAgencies();break;
          case "addagent": addNewAgent(findAgency(Integer.valueOf(command.get(1))), command.get(2), command.get(3), new Address(command.get(4),command.get(5),command.get(6)), new Phone(command.get(7)), command.get(8));break;
          case "deleteagent": deleteAgent(Integer.valueOf(command.get(1)));break;
          case "displayagents": displayAgents();break;
          case "addrealestate": addNewRealEstate(command.get(1), command.get(2), new Address(command.get(3), command.get(4), command.get(5)), Integer.valueOf(command.get(6)), Double.valueOf(command.get(7)), Integer.valueOf(command.get(8)));break;
          case "deleterealestate": deleteRealEstate(Integer.valueOf(command.get(1)));break;
          case "displayrealestates": displayRealEstates();break;
          case "addcustomer": addNewCustomer(command.get(1), command.get(2), new Address(command.get(3),command.get(4),command.get(5)), new Phone(command.get(6)), command.get(7));break;
          case "deletecustomer": deleteCustomer(Integer.valueOf(command.get(1)));break;
          case "displaycustomers": displayCustomers();break;
          case "addcontract": addNewContract(Integer.valueOf(command.get(1)), Integer.valueOf(command.get(2)), Integer.valueOf(command.get(3)), command.get(4));break;
          case "displaycontracts": displayContracts();break;
          case "search": search(command.get(1), command.get(2), command.get(3), command.get(4), command.get(5), command.get(6), command.get(7));break;
          case "calculatesalaries": calculateSalaries(command.get(1));break;
          case "calculatetotalincome": calculateTotalIncome(command.get(1));break;
          case "mostprofitableagency": mostProfitableAgency(command.get(1));break;
          case "agentofthemonth": agentOfTheMonth(command.get(1));break;
          case "exit": System.exit(0);break;
          case "clear": ui.clear();break;
          case "": ui.print("");break;

      }
    }
    catch(FileNotFoundException e){
      ui.printError("The input file has not been found: " + command.get(1));
    }
    catch(IOException e){
      ui.printError("An error occured while reading the file.");
    }
    catch(NumberFormatException e){
      String[] message = e.getMessage().split(" ");
      ui.printError("Wrong number format has been entered: " + message[3]);
    }
    catch(IllegalArgumentException e){
      ui.printError(e.getMessage());
    }
  }

  //Reads input file line by line and executes all commands in input file.
  private void readFile(String fileName) throws FileNotFoundException, IOException{

    BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
    isStreaming = true;
    String row = null;
    while((row = br.readLine()) != null){
      if(!row.split(";")[0].equals("load"))
        executeCommand(row);
    }
    br.close();
    isStreaming = false;
    System.out.print("> ");

  }
}
