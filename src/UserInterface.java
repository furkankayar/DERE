/*
  User interface class is used by Controller and Management Classes.
  This class can write outputs in different styles and colors.
  And it can take input from user.
  It uses Enigma Console.
*/


import enigma.core.Enigma;
import enigma.console.Console;
import enigma.console.TextAttributes;
import java.awt.Color;



public class UserInterface{

  public Console console;
  private final TextAttributes defaultColor;
  private final TextAttributes errorColor;
  private final TextAttributes successColor;
  private final TextAttributes headerColor;
  private final TextAttributes tableColor;
  private final TextAttributes deletedRecordColor;

  //Constructor of UserInterface class.
  public UserInterface(String name, int width, int height, int fontSize){

    this.console = Enigma.getConsole(name, width, height, fontSize, 0);
    this.defaultColor = new TextAttributes(new Color(230,230,230));
    this.errorColor = new TextAttributes(new Color(255,51,51));
    this.successColor = new TextAttributes(new Color(9,199,69));
    this.headerColor = new TextAttributes(new Color(157,169,182));
    this.tableColor = new TextAttributes(new Color(230,230,230), new Color(50,50,50));
    this.deletedRecordColor = new TextAttributes(new Color(230,230,230), new Color(114,37,37));
  }

  //Writes output in red color.
  public void printError(String message){

    console.setTextAttributes(errorColor);
    System.out.println(" " + message);
    console.setTextAttributes(defaultColor);
    if(!Management.isStreaming)
      System.out.print("> ");
  }

  //Writes output in green color.
  public void printSuccess(String message){

    console.setTextAttributes(successColor);
    System.out.println(" " + message);
    console.setTextAttributes(defaultColor);
    if(!Management.isStreaming)
      System.out.print("> ");

  }

  //Writes output in white color with gray or black background.
  public void print(String message, int indicator){

    if(indicator % 2 == 0){

      System.out.println(" " + message);
      if(!Management.isStreaming)
        System.out.print("> ");
    }
    else{

      console.setTextAttributes(tableColor);
      System.out.println(" " + message);
      if(!Management.isStreaming)
        System.out.print("> ");
      console.setTextAttributes(defaultColor);
    }
  }

  //Writes output in white color.
  public void print(String message){

    System.out.println(" " + message);
    if(!Management.isStreaming)
      System.out.print("> ");

  }

  //Writes output with red background.
  public void printDeletedRecord(String message){

    console.setTextAttributes(deletedRecordColor);
    System.out.println(" " + message);
    if(!Management.isStreaming)
      System.out.print("> ");
    console.setTextAttributes(defaultColor);
  }

  //Writes output in gray color.
  public void printHeader(String message){

    console.setTextAttributes(headerColor);
    System.out.println("\n" + message + "\n");
    console.setTextAttributes(defaultColor);
  }

  //Writes output without newline character.
  public void append(String message, int red, int green, int blue){

    console.setTextAttributes(new TextAttributes(new Color(red,green,blue)));
    System.out.print(message);
    console.setTextAttributes(defaultColor);
  }

  //Takes input from user.
  public String getInput(){

    return console.readLine();
  }

  //Clears console screen and puts cursor at the position of (0,0)
  public void clear(){

    for(int i = 0; i < console.getTextWindow().getRows(); i++)
      System.out.print("\n");

    console.getTextWindow().setCursorPosition(0, 0);
    System.out.print("> ");
  }
}
