/*
  The Date class keeps date information. It also checks given dates is valid or not.
*/
public class Date{

  private int day;
  private int month;
  private int year;
  private int[] daysOfMonths;

  //Constructor of Date class. It creates a new date if given values are valid.
  public Date(int day, int month, int year) throws IllegalArgumentException{

    daysOfMonths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    if(year < 1 || year > 2300)
      throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year + ". Year must be in range of 1 and 2300");

    if(isLeapYear(year)) daysOfMonths[1]++;

    if(month < 1 || month > 12)
      throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
    else if(day < 1 || day > daysOfMonths[month - 1])
      throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);

    else{
      this.day = day;
      this.month = month;
      this.year = year;
    }
  }

  public Date(int month, int year) throws IllegalArgumentException{

    if(year < 0 || year > 2300)
      throw new IllegalArgumentException("Invalid date: " + month + "/" + year + ". Year must be in range of 1 and 2300");
    else if(month < 1 || month > 12)
      throw new IllegalArgumentException("Invalid date: " + month + "/" + year);
    else{
      this.month = month;
      this.year = year;
    }
  }

  public int getDay(){
    return this.day;
  }
  public int getMonth(){
    return this.month;
  }
  public int getYear(){
    return this.year;
  }

  //Checks given year is leap year.
  private boolean isLeapYear(int year){

    if(( year % 400 == 0 || year % 100 != 0 ) && year % 4 == 0)
      return true;
    return false;
  }

  //Used to compare two dates properly.
  @Override
  public boolean equals(Object obj){

    if(obj.getClass().getName().equals("Date")){

      Date date = (Date)obj;
      if(date.getDay() != 0 && this.day != 0 && this.day != date.getDay()){
        return false;
      }
      else if(date.getMonth() != this.month || date.getYear() != this.year)
        return false;
    }

    return true;
  }

  @Override
  public String toString(){
    String day = null;
    String month = null;
    if(this.day < 10 ) day = "0" + this.day;
    else day = String.valueOf(this.day);
    if(this.month < 10 ) month = "0" + this.month;
    else month = String.valueOf(this.month);
    return day + "/" + month + "/" + this.year;
  }

}
