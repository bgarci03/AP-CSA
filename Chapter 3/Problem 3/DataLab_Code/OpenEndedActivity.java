import java.util.Scanner;

public class OpenEndedActivity
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    CustomaryConverter converter = new CustomaryConverter();

    System.out.println("Enter the unit name's abbreviation you want to convert (in, ft, yd, or mi):");
    String unitName = sc.nextLine();
    while (!converter.validateUnit(unitName))
    {
      System.out.println("Invalid unit name (in, ft, yd, or mi)!\nTry again:");
      unitName = sc.nextLine();
    }

    System.out.println("Enter the length value:");
    double length = sc.nextDouble();

    double result = converter.convertLength(unitName, length);
    System.out.println("Final result: " + result);
  }
}
