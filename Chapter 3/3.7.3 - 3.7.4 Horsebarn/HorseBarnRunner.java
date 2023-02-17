/*
 * Activity 3.7.3
 */
import java.util.ArrayList;

public class HorseBarnRunner
{
  public static void main(String[] args)
  {
    /* your code here */
    HorseBarn barn = new HorseBarn();
    ArrayList<Horse> barnSpaces = new ArrayList<Horse>();
    barnSpaces = barn.getSpaces();

    for (Horse h: barnSpaces)
    {
      System.out.println(h);
      /* Modifying the size of the ArrayList causes an error
      if (h.getName().equals("Patches"))
        barnSpaces.remove(h);
      */
    }

    /* For loop
    int removed = 0;
    for (int i = 0; i < barnSpaces.size()+removed; i++)
    {
      Horse h = barnSpaces.get(i-removed);
      if (h.getName().equals("Patches"))
      {
        System.out.println("Bye bye " + barnSpaces.remove(i - removed));
        removed++;
      }
      else if (h.getName().equals("Lady"))
      {
        System.out.println("Bye bye " + barnSpaces.remove(i - removed));
        removed++;
      }
    }
    */

    int index = 0;
    while (index < barnSpaces.size())
    {
      Horse h = barnSpaces.get(index);
      if (h.getName().equals("Patches"))
      {
        System.out.println("Bye bye " + barnSpaces.remove(index));
        index--;
      }
      else if (h.getName().equals("Lady"))
      {
        System.out.println("Bye bye " + barnSpaces.remove(index));
        index--;
      }
      index++;
    }

    System.out.println(barnSpaces);
  }
} 