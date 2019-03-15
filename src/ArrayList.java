/*
  The ArrayList class is used to store data efficiently.
*/

public class ArrayList{

  //It can keep all type of objects. Because it has an array of Object type.
  private Object[] base;
  //Loadfactor determines the solidity ratio of array.
  private static final float LOADFACTOR = 0.7f;
  private static final int CAPACITY = 30;
  private int threshold;

  // Constructor of ArrayList class creates a ArrayList and calculates threshold value.
  public ArrayList(){

    base = new Object[CAPACITY];
    threshold = (int)(LOADFACTOR * CAPACITY);

  }

  //Adds new element to ArrayList.
  public void add(Object element){

    int counter = size();
    if(counter >= threshold)
      resize(counter);

    base[counter] = element;
  }

  //Resizes the base array of ArrayList.
  private void resize(int elementNum){

    Object[] temp = new Object[base.length];

    for(int i = 0 ; i < elementNum ; i++)
      temp[i] = base[i];

    base = new Object[base.length * 2];
    threshold = (int)(base.length * LOADFACTOR);

    for(int i = 0 ; i < elementNum ; i++)
      base[i] = temp[i];

  }

  //Returns a iterable list without null values.
  public Object[] toList(){

    int size = size();
    Object[] list = new Object[size];

    for(int i=0 ; i < size ; i++){
      list[i] = base[i];
    }

    return list;
  }
  
  //Returns the size of ArrayList without null values.
  public int size(){

    int counter = 0;
    while(base[counter] != null)
     counter++;

    return counter;
  }

  //Returns the element on specific index.
  public Object get(int index){

    if(index > size() - 1)
      throw new IndexOutOfBoundsException();

    return base[index];
  }

  //Returns the size of ArrayList.
  public int getCapacity(){
    return base.length;
  }
}
