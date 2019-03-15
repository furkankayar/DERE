/*
  The Command class checks given command is valid or not. And keeps the data is given by command.
*/

public class Command{

  private String[] command;
  //Patterns of all commands.
  private static final Object[][] COMMAND_PATTERN = new Object[][]{
    {2, "load", "load;file_name"},
    {6, "addAgency", "addAgency;name;address;town;city;phone"},
    {9, "addAgent", "addAgent;agency_id;name;birthdate;address;town;city;phone;gender"},
    {9, "addRealEstate", "addRealEstate;type;status;address;town;city;surface_area;price;number_of_rooms"},
    {8, "addCustomer", "addCustomer;name;birthdate;address;town;city;phone;gender"},
    {5, "addContract", "addContract;real_estate_id;customer_id;agent_id;contract_date"},
    {2, "deleteAgent", "deleteAgent;agent_id"},
    {2, "deleteRealEstate", "deleteRealEstate;real_estate_id"},
    {2, "deleteCustomer", "deleteCustomer;customer_id"},
    {1, "displayAgencies", "displayAgencies"},
    {1, "displayAgents", "displayAgents"},
    {1, "displayRealEstates", "displayRealEstates"},
    {1, "displayCustomers", "displayCustomers"},
    {1, "displayContracts", "displayContracts"},
    {8, "search", "search;type;status;town;city;min_surface_area-max_surface_area;min_price-max_price;min_number_of_rooms-max_number_of_rooms"},
    {2, "calculateSalaries", "calculateSalaries;month/year"},
    {2, "calculateTotalIncome", "calculateTotalIncome;month/year"},
    {2, "mostProfitableAgency", "mostProfitableAgency;month/year"},
    {2, "agentOfTheMonth", "agentOfTheMonth;month/year"},
    {1, "clear", "clear"},
    {1, "exit", "exit"},
  };

  //Constructor of command class. If it validates given command, creates object.
  public Command(String command){

    String[] args = trim(command.split(";", -1));
    if(validate(args))
      this.command = args;
    else
      throw new IllegalArgumentException("Unknown command: " + args[0]);

  }

  //Deletes white spaces from beginning and end of the parameters of command.
  private String[] trim(String[] args){

    for(int i = 0 ; i < args.length ; i++){
      args[i] = args[i].trim();
    }
    return args;
  }

  //Checks given command is acceptible or not.
  private boolean validate(String[] command){

    for(int i = 0 ; i < COMMAND_PATTERN.length ; i++ ){
      if(command[0].replaceAll("ı", "i").equalsIgnoreCase((String)COMMAND_PATTERN[i][1])){
        if(command.length != (int)COMMAND_PATTERN[i][0])
          throw new IllegalArgumentException("Wrong prototype!\n Expected: " + (String)COMMAND_PATTERN[i][2] + " ");
        else
          return true;
      }
    }
    return false;
  }

  public String get(int index){

    return command[index];
  }




}
