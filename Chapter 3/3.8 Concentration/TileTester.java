/*
 * Activity 3.8.1
 */
public class TileTester
{
  private static String[] tileValues =
  { "lion", "lion",
    "penguin", "penguin",
    "dolphin", "dolphin",
    "fox", "fox",
    "monkey", "monkey",
    "turtle", "turtle" }; 

  public static void main(String[] args)
  {
    
    /* your code here */
    Tile[][] gameboard = new Tile[3][4];
    int index = 0;

    for (int i = 0; i < 3; i++)
    {
      for (int j = 0; j < 4; j++)
      {
        gameboard[i][j] = new Tile(tileValues[index]);
        index++;
      }
    }

    System.out.println(java.util.Arrays.toString(gameboard[0]));
    System.out.println(java.util.Arrays.toString(gameboard[1]));
    System.out.println(java.util.Arrays.toString(gameboard[2]));
    
  }
}
