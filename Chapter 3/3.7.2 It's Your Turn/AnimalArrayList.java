import java.util.Scanner;
import java.util.ArrayList;

public class AnimalArrayList
{
  public static void main(String[] args)
  {
     ArrayList<String> animalList = new ArrayList<String>();
     animalList.add("Dog");
     animalList.add("Cat");
     animalList.add("Falcon");
     Scanner sc = new Scanner(System.in);
     boolean loop = true;
     while (loop)
     {
        System.out.println(animalList);
        System.out.println("Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace, or (q)uit?");
        String choice = sc.nextLine();
        if (choice.equals("a")) {
           System.out.println("Enter an animal:");
           String element = sc.nextLine();
           animalList.add(element);
        } else if (choice.equals("i")) {
           System.out.println("Enter an animal:");
           String element = sc.nextLine();
           System.out.println("Enter a position:");
           int index = sc.nextInt() - 1;
           if (index < 0 || index > animalList.size())
              System.out.println("Bad position!");
           else
              animalList.add(index, element);
        } else if (choice.equals("r")) {
           System.out.println("Enter a position");
           int index = sc.nextInt() - 1;
           if (index < 0 || index > animalList.size())
              System.out.println("Bad position!");
           else
              animalList.remove(index);
        } else if (choice.equals("p")) {
           System.out.println("Enter an animal:");
           String element = sc.nextLine();
           System.out.println("Enter a position:");
           int index = sc.nextInt() - 1;
           if (index < 0 || index > animalList.size())
              System.out.println("Bad position!");
           else
              animalList.set(index, element);
        } else if (choice.equals("q"))
           loop = false;
     }
  }
}