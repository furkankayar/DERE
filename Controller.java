

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller{

  private ArrayList<String> commands;


  public Controller(){

    commands = new ArrayList<String>();

  }


  public void readFile(String fileName) throws FileNotFoundException, IOException{

    BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));

    String row = null;
    while((row = br.readLine()) != null){
      commands.add(row);
    }
  }


  public void executeFileCommands(){

    for(String command: commands){

      String[] properties = command.split(";");
      System.out.println(properties[0]);
    }
  }

  public static void main(String[] args){

    Controller controller = new Controller();


  }



}
