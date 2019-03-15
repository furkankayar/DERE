/*
  The Phone class keeps phone information.
*/
public class Phone{

  private String number;

  //Constructor of Phone class. It also checks the format of given number. If number is valid, it creates object.
  public Phone(String number){

    if(!number.startsWith("0") || number.length() != 11 || !number.matches("[0-9]+"))
      throw new IllegalArgumentException("Wrong phone number entered! The phone number must have 11 digits with leading zero.");

    this.number = number;
  }

  public String getNumber(){
    return this.number;
  }

  //Gives proper output when a phone is printed.
  @Override
  public String toString(){

    return this.number;
  }

}
