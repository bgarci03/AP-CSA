/**
 * Project 3.6.5
 *
 * The Memory Game shows a random sequence of "memory strings" in a variety of buttons.
 * After wathcing the memory strings appear in the buttons one at a time, the
 * player recreates the sequence from memory.
 */
public class MemoryGame
{
  public static void main(String[] args) {

    // Create the "memory strings" - an array of single character strings to
    // show in the buttons, one element at a time. This is the sequence
    // the player will have to remember.
    String[] memoryStrings = {"a", "b", "c", "d", "e"};

    // Create the game and gameboard. Configure a randomized board with 3 buttons.
    // (Later, you can change options to configure more or less buttons
    // and turn randomization on or off.)
    MemoryGameGUI gameBoard = new MemoryGameGUI();
    gameBoard.createBoard(3, true);

    // Play the game until user wants to quit.
    boolean play = true;
    int score = 0;
    int rounds = 0;
    while (play)
    {

      // Create a new array that will contain the randomly ordered memory strings.
      String[] randomOrderMemoryStrings = new String[memoryStrings.length];

      // Create a list of randomly ordered integers with no repeats, the length
      // of memory strings. Use it to create a random sequence of the memory strings.
      // - OR -
      // Overload the next method in RandomPermutation to create a random sequence
      // of the memory strings, passed as a parameter.
      randomOrderMemoryStrings = RandomPermutation.next(memoryStrings);

      // Play one sequence, delaying half a second for the strings to show
      // in the buttons. Save the player's guess.
      // (Later, you can speed up or slow down the game.)
      String guess = gameBoard.playSequence(randomOrderMemoryStrings, 0.5);

      // Determine if player's guess matches all elements of the random sequence.
      boolean matchesElements = true;
      for (String letter: randomOrderMemoryStrings)
        if (guess.indexOf(letter) == -1)
          matchesElements = false;

      // Cleanup the guess - remove commas and spaces. Refer to a new String method
      // replace to make this easy.
      while (guess.indexOf(" ") != - 1)
        guess = guess.replace(" ", "");
      while (guess.indexOf(",") != -1)
        guess = guess.replace(",", "");

      // iterate to determine if guess matches sequence
      boolean match = true;
      if (matchesElements)
      {
        for (int i = 0; i < randomOrderMemoryStrings.length; i++)
          if (guess.indexOf(randomOrderMemoryStrings[i]) != i)
            match = false;
      }
      else
        match = false;

      // If match, increase score, and signal a match, otherwise, try again.
      if (match)
      {
        score++;
        gameBoard.matched();
      }
      else
      {
        while (!match) {
          gameBoard.tryAgain();
          guess = gameBoard.playSequence(randomOrderMemoryStrings, 0.5);
          match = true;
          for (int i = 0; i < randomOrderMemoryStrings.length; i++)
            if (guess.indexOf(randomOrderMemoryStrings[i]) != i)
              match = false;
        }
        rounds++;
      }

      // Ask if user wants to play another round of the game
      // and track the number of games played.
      play = gameBoard.playAgain();
    }

    // When done playing, show score and end the game.
    gameBoard.showScore(score, rounds);
    gameBoard.quit();
  }
}