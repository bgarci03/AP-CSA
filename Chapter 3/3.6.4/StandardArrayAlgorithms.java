/*
 * Activity 3.6.4
 */
public class StandardArrayAlgorithms
{
  public static void main(String[] args)
  {
    int[] goals = {1, 2, 0, 3, 2, 4, 2, 1, 0, 2, 0, 1, 3, 2};

    // Modified to also find average
    int sum = 0;
    for (int i = 0; i < goals.length; i++)
      sum += goals[i];
    double average = (double) sum / goals.length;

    System.out.println("All goals: " + sum);
    System.out.println("Average: " + average);

    // Max and Min Algorithm
    int max = goals[0];
    int min = max;
    for (int goal: goals)
    {
      if (goal > max)
        max = goal;
      else if (goal < min)
        min = goal;
    }

    System.out.println("Maximum: " + max);
    System.out.println("Minimum: " + min);

    // Mode Algorithm
    /*
     * Pre-Condition:
     *  The goal count for each game cannot be more than 10
     *  No more than 1 mode
     */
    int[] goalCounter = new int[10];
    int mode = goalCounter[0];
    int timesAppeared = 0;
    for (int goal: goals)
    {
      goalCounter[goal]++;

      if (goalCounter[goal] > timesAppeared)
      {
        mode = goal;
        timesAppeared = goalCounter[goal];
      }
    }
    System.out.println("Mode is " + mode);

    // If one at least has a certain property
    Player[] players = {new Player("Alex", 12), new Player("Aiden", 13),
                        new Player("Bobbie", 18), new Player("Blaine", 20),
                        new Player("Chris", 15), new Player("Charlie", 15) };
    boolean hasValue = false;
    int index = 0;
    while (!hasValue && index < players.length)
    {
      if (players[index].getAge() >= 18)
        hasValue = true;
      index++;
    }
    if (hasValue)
      System.out.println("Property found!");
    else
      System.out.println("Property not found!");

    // If all elements have a certain property
    boolean allHaveValue = true;
    for (Player player: players)
    {
      if (player.getAge() >= 21)
        allHaveValue = false;
    }
    if (allHaveValue)
      System.out.println("All have property!");
    else
      System.out.println("All don't have property!");

    // Number of elements meeting a specific criteria
    int withProperty = 0;
    for (Player player: players)
    {
      if (player.getAge() == 15)
        withProperty++;
    }

    System.out.println("Count of 15 years olds: " + withProperty);

    // All consecutive Pairs of elements
    for (int i = 0; i < players.length; i += 2)
    {
      String pair = players[i].getName() + " and " + players[i+1].getName();
      System.out.println(pair);
    }

    // Mystery Algorithm 1
    // Moves the last element to the first index while also shifting the array
    String[] arr = {"A", "B", "C", "D", "E", "F"};
    for (int i = arr.length; i > 1; i--)
    {
      String tmp = arr[i - 2];
      arr[i - 2] = arr[i - 1];
      arr[i - 1] = tmp;
    }
    for (String letter: arr)
      System.out.println(letter);

    // Mystery Algorithm 2
    // Reverses the order of the array
    String[] arr2 = {"A", "B", "C", "D", "E", "F"};
    for (int i = 0; i < arr2.length/2; i++)
    {
      String tmp = arr2[i];
      arr2[i] = arr2[arr2.length - i - 1];
      arr2[arr2.length - i - 1] = tmp;
    }
    for (String letter: arr2)
      System.out.println(letter);
  }
  
}