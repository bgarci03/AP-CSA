public class Game
{
  // Attributes
  private int[][] board;
  private int turn;
  private boolean end;
  private boolean noWinner;
  // Constructor
  public Game()
  {
    this.board = new int[3][3];
    this.turn = 1;
    this.end = false;
    this.noWinner = false;
  }

  // Methods
  public boolean playTurn(int row, int col)
  {
    if (row < 0 || row >= this.board.length || col < 0 || col >= this.board[0].length || this.board[row][col] != 0)
      return false;

    if (turn < 2)
    {
      this.board[row][col] = turn;
      turn++;
    }
    else
    {
      this.board[row][col] = turn;
      turn--;
    }
    this.checkForWinner();
    return true;
  }

  private void checkForWinner()
  {
    // Row-major order
    for (int[] row: this.board)
    {
      if (row[0] > 0)
      {
        this.end = true;
        int lookingFor = row[0];
        for (int col = 1; col < this.board[0].length; col++)
        {
          if (row[col] != lookingFor)
            this.end = false;
        }
        if (this.end)
          break;
      }
    }

    // Column-major order
    if (!this.end)
    {
      for (int col = 0; col < this.board[0].length; col++)
      {
        if (this.board[0][col] > 0)
        {
          this.end = true;
          int lookingFor = this.board[0][col];
          for (int row = 1; row < this.board.length; row++)
          {
            if (this.board[row][col] != lookingFor)
              this.end = false;
          }
          if (this.end)
            break;
        }
      }
    }

    // Diagonally
    if (!this.end && this.board[0][0] > 0)
      this.end = this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2];
    if (!this.end && this.board[2][0] > 0)
      this.end = this.board[2][0] == this.board[1][1] && this.board[2][0] == this.board[0][2];

    // Check to see if no 0s
    for (int[] row: this.board)
    {
      for (int loc : row)
      {
        if (loc > 0)
          this.noWinner = true;
        else
          this.noWinner = false;
      }
    }
    if (this.noWinner)
      this.end = true;
  }

  public void display()
  {
    for (int[] row: this.board)
    {
      for (int loc: row)
        System.out.print(loc + " ");
      System.out.println();
    }
  }

  // Accessors
  public int getTurn()
  {
    return this.turn;
  }

  public boolean getEnd()
  {
    return this.end;
  }

  public boolean getNoWinner()
  {
    return this.noWinner;
  }
}
