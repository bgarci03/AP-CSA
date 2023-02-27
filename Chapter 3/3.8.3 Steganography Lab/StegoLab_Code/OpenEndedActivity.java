import java.util.Scanner;

public class OpenEndedActivity
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    Game game = new Game();

    System.out.println("Welcome to Tic-Tac-Toe!");

    while (!game.getEnd())
    {
      game.display();
      System.out.println("Player " + game.getTurn() + " go!\nEnter coordinates (row, col):");
      int row = sc.nextInt();
      int col = sc.nextInt();
      while (!game.playTurn(row, col))
      {
        System.out.println("Invalid input!\nTry again:");
        row = sc.nextInt();
        col = sc.nextInt();
      }
    }

    game.display();
    if (game.getNoWinner())
      System.out.println("No one won!");
    else
    {
      if (game.getTurn() < 1)
        System.out.println("Player " + (game.getTurn()+1) + " won!");
      else
        System.out.println("Player " + (game.getTurn()-1) + " won!");
    }
  }
}