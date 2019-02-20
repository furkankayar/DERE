

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Controller{



  public static void main(String[] args){

    Management management = new Management();

    management.executeCommand("load;input.txt");

  }



}
