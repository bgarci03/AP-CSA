/** 
 * A game board of NxM board of tiles.
 * 
 *  @author PLTW
 * @version 2.0
 */

/** 
 * A Board class for concentration
 */
public class Board
{  
  private static String[] tileValues = {"lion", "lion",
                                        "penguin", "penguin",
                                        "dolphin", "dolphin",
                                        "fox", "fox",
                                        "monkey", "monkey",
                                        "turtle", "turtle"}; 
  private Tile[][] gameboard = new Tile[3][4];

  /**  
   * Constructor for the game. Creates the 2D gameboard
   * by populating it with card values
   * 
   */
  public Board()
  {
   
    /* your code here */
    /* Truncated
    int index = 0;
    for (int i = 0; i < this.gameboard.length; i++)
    {
      for (int j = 0; j < this.gameboard[0].length; j++)
      {
        this.gameboard[i][j] = new Tile(tileValues[index]);
        index++;
      }
    } */

    /* Testing purposes only
    for (Tile[] row: gameboard)
    {
      for (Tile item : row)
      {
        System.out.print(item + "\t");
      }
      System.out.println();
    } */

    // Random Permutation
    int index = tileValues.length-1;
    for (int i = 0; i < this.gameboard.length; i++)
    {
      for (int j = 0; j < this.gameboard[0].length; j++)
      {
        int random = (int) (Math.random() * index);
        this.gameboard[i][j] = new Tile(tileValues[random]);
        tileValues[random] = tileValues[index];
        tileValues[index] = this.gameboard[i][j].toString();
        index--;
      }
    }
  }

 /** 
   * Returns a string representation of the board, getting the state of
   * each tile. If the tile is showing, displays its value, 
   * otherwise displays it as hidden.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return a string represetation of the board
   */
  public String toString()
  {
 
    /* your code here */
    String tiles = "";
    for (Tile[] row: this.gameboard)
    {
      for (Tile item: row)
      {
        if (item.isShowingValue())
          tiles += item.getValue() + "\t";
        else
          tiles += item.getHidden() + "\t";
      }
      tiles += "\n";
    }
 
    return tiles;
  }

  /** 
   * Determines if the board is full of tiles that have all been matched,
   * indicating the game is over.
   * 
   * Precondition: gameboard is populated with tiles
   * 
   * @return true if all tiles have been matched, false otherwse
   */
  public boolean allTilesMatch()
  {

    /* your code  here */
    boolean allMatched = true;
    for (Tile[] row: this.gameboard)
    {
      for (Tile item: row)
      {
        if (!item.matched())
          allMatched = false;
      }
    }
    
    return allMatched;
  }

  /** 
   * Sets the tile to show its value (like a playing card face up)
   * 
   * Preconditions:
   *   gameboard is populated with tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row the row value of Tile
   * @param column the column value of Tile
   */
  public void showValue (int row, int column)
  {
   
    /* your code here */
    this.gameboard[row][column].show();
  }  

  /** 
   * Checks if the Tiles in the two locations match.
   * 
   * If Tiles match, show Tiles in matched state and return a "matched" message
   * If Tiles do not match, re-hide Tiles (turn face down).
   * 
   * Preconditions:
   *   gameboard is populated with Tiles,
   *   row values must be in the range of 0 to gameboard.length,
   *   column values must be in the range of 0 to gameboard[0].length
   * 
   * @param row1 the row value of Tile 1
   * @param col1 the column value of Tile 1
   * @param row2 the row value of Tile 2
   * @param col2 the column vlue of Tile 2
   * @return a message indicating whether or not a match occured
   */
  public String checkForMatch(int row1, int col1, int row2, int col2)
  {
    String msg = "";

     /* your code here */
    if (this.gameboard[row1][col1].equals(this.gameboard[row2][col2]))
    {
      this.gameboard[row1][col1].foundMatch();
      this.gameboard[row2][col2].foundMatch();
      msg = "You matched!";
    }
    else
    {
      this.gameboard[row1][col1].hide();
      this.gameboard[row2][col2].hide();
    }
    
     return msg;
  }

  /** 
   * Checks the provided values fall within the range of the gameboard's dimension
   * and that the tile has not been previously matched
   * 
   * @param rpw the row value of Tile
   * @param col the column value of Tile
   * @return true if row and col fall on the board and the row,col tile is unmatched, false otherwise
   */
  public boolean validateSelection(int row, int col)
  {

    /* your code here */
    boolean validated = true;
    if (row >= this.gameboard.length || row < 0 || col >= this.gameboard[0].length || col < 0)
      validated = false;
    else if (this.gameboard[row][col].isShowingValue())
      validated = false;

    return validated;
  }

}
