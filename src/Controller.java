/*
  This class is main class.
  It initiliazes user interface and management classes.
  It takes input and gives to management class to execute them.
*/


public class Controller{

  private static final String INPUT_FILE_NAME = "input.txt";
  private static final String SOFTWARE_NAME = "Dokuz Eylül Real Estate";
  private static final int WINDOW_WIDTH = 115;
  private static final int WINDOW_HEIGHT = 37;
  private static final int FONT_SIZE = 19;

  private Management management;
  private UserInterface ui;

  //Constructor of Controller class.
  public Controller(){

    this.ui = new UserInterface(SOFTWARE_NAME, WINDOW_WIDTH, WINDOW_HEIGHT, FONT_SIZE);
    this.management = new Management(ui);
    management.executeCommand("load;" + INPUT_FILE_NAME);
    run();
  }

  //Program loop.
  private void run(){

    while(true){
      management.executeCommand(ui.getInput());
    }
  }

  public static void main(String[] args){


    new Controller();

  }

}
