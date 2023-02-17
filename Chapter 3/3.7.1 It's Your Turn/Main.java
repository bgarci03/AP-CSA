import java.util.ArrayList;

public class Main
{
  public static void main(String[] args)
  {
    ArrayList<Person> myList = new ArrayList<Person>();
    myList.add(new Person(5, 2018, "Jose"));
    myList.add(new Person(16, 2007, "Kiara"));
    myList.add(new Person(20, 2003, "Reyna"));
    System.out.println(myList);
  }
}