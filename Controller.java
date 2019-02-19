

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller{

  private final String FILENAME;
  private ArrayList<String> commands;


  public Controller(String fileName){

    this.FILENAME = fileName;
    commands = new ArrayList<String>();

  }


  public void readFile() throws FileNotFoundException, IOException{

    BufferedReader br = new BufferedReader(new FileReader(new File(FILENAME)));

    String row = null;
    while((row = br.readLine()) != null){
      commands.add(row);
    }
  }


  public void executeCommands(){

    for(String command: commands){

      String[] properties = command.split(";");
      System.out.println(properties[0]);
    }
  }

  public static void main(String[] args){

    Controller controller = new Controller("input.txt");
    Exception exception = null;
    try{
      controller.readFile();

    }
    catch(FileNotFoundException e){
      System.out.println("Given file does not exist.");
      exception = e;
    }
    catch(IOException e){
      System.out.println("An error occured while reading the lines.");
      exception = e;
    }
    finally{

      if( exception == null ){

        controller.executeCommands();
      }
      else{

        //Initialize the consoleUI
      }
    }
  }




}
