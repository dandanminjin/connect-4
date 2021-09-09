public class Game
{
  Coin[][] board = new Coin[6][8]; 
  boolean VictoryAchieved = false; 

  public Game ()
  {
    while (!VictoryAchieved) 
    {
      DisplayBoard(); 
      System.out.println("Write the column number you'd like to enter a coin in!"); 
      PlayerMove();
      //AImove();
    }
    DisplayBoard(); 
  }


  void DisplayBoard()
  {
    //ClearConsole (); 
    for(int i = 0;i < board.length; i++)
    {
      for(int j = 0;j<board[0].length; j++)
      {
        Coin c = board[i][j]; 
        if (c == null) 
        {
          System.out.print("0"); 
        }else {
          System.out.print(c.GetCoinString()); 
        }
      }
      System.out.println("");
    }
  }
  void EnterCoin (int column, boolean Player)
  {
    Coin c = new Coin(); 
    c.isPlayer = Player;

    for (int i = board.length-1; i>=0; i--)
    {
      if (board[i][column] == null)
      {
          
        board[i][column] = c; 
        CheckForVictory(i, column);   
        return; 
    
      }
    }
    
  }

  void AImove()
  {
    int aiColumn = Main.rand.nextInt(board.length);  
    EnterCoin(aiColumn, false); 
  }

  void PlayerMove ()
  {
    try
    {
      int playerColumn = Integer.parseInt(Main.input.next()); 
      EnterCoin(playerColumn, true); 
    } catch(Exception e) 
    {
      System.out.println(e.getMessage()); 
      PlayerMove ();  
    }
  } 
  void CheckForVictory(int x, int y) 
  {
    CheckNeighbour(1, x, y, 1, 0); //down
    //CheckNeighbour(1, x, y, -1, 0);  // up
    CheckNeighbour(1, x, y, 0, -1); //left
    CheckNeighbour(1, x, y, 0, 1); //right
    CheckNeighbour(1, x, y, -1, -1); //top left
    CheckNeighbour(1, x, y, -1, 1); //top right
    CheckNeighbour(1, x, y, 1, -1); //bottom left
    CheckNeighbour(1, x, y, 1, 1); //bottom right
  }


  void CheckOneWay(int nInRow, int posX, int posY, int dirX, int dirY)
  {
    System.out.println(nInRow + " " + posX + " " + posY + " " + dirX + " " + dirY + " "); 
    Coin coin = board[posX][posY]; 
    /*posX += dirX; 
    posY += dirY; */

    int neighbourX = posX + dirX;
    int neighbourY = posY + dirY;

    if (neighbourX < 0)
    {
      System.out.println("too far up");
      return; 
    } 
    if (neighbourX >= board.length) 
    {
      System.out.println("too far down");
      return; 
    } 
    if (neighbourY < 0)
    {
      System.out.println("too far left");
      return; 
    }
    if (neighbourY >= board[0].length) 
    {
      System.out.println("too far right");
      return; 
    }
    //if neighbourX < 0
    //if neighbourX > board.length (board[0].length)
    //return;
    System.out.println("neighbour: " + " " + neighbourX + " " + neighbourY);
    Coin neighbour = board[neighbourX][neighbourY]; 
    if (neighbour == null) 
    {
      System.out.println("neighbour null");
      return; 
    }
    //if neighbour is null
    //return;
    nInRow++; 
    if (nInRow == 4) 
    {
      System.out.println("victory");
      VictoryAchieved = true;  
      return; 
    }
    if(coin.isPlayer == neighbour.isPlayer)
    {
      CheckNeighbour(nInRow, neighbourX, neighbourY, dirX, dirY); 
    }
    
  }

  void CheckNeighbour(int nInRow, int posX, int posY, int dirX, int dirY)
  {
    System.out.println(nInRow + " " + posX + " " + posY + " " + dirX + " " + dirY + " "); 
    Coin coin = board[posX][posY]; 
    /*posX += dirX; 
    posY += dirY; */
    if (nInRow == 3)
    {
      CheckOneWay (nInRow, posX, posY, dirX * -3, dirY * -3);    
    }

    int neighbourX = posX + dirX;
    int neighbourY = posY + dirY;

    if (neighbourX < 0)
    {
      System.out.println("too far up");
      return; 
    } 
    if (neighbourX >= board.length) 
    {
      System.out.println("too far down");
      return; 
    } 
    if (neighbourY < 0)
    {
      System.out.println("too far left");
      return; 
    }
    if (neighbourY >= board[0].length) 
    {
      System.out.println("too far right");
      return; 
    }
    //if neighbourX < 0
    //if neighbourX > board.length (board[0].length)
    //return;
    System.out.println("neighbour: " + " " + neighbourX + " " + neighbourY);
    Coin neighbour = board[neighbourX][neighbourY]; 
    if (neighbour == null) 
    {
      System.out.println("neighbour null");
      return; 
    }
    //if neighbour is null
    //return;
    nInRow++; 
    if (nInRow == 4) 
    {
      System.out.println("victory");
      VictoryAchieved = true;  
      return; 
    }
    if(coin.isPlayer == neighbour.isPlayer)
    {
      CheckNeighbour(nInRow, neighbourX, neighbourY, dirX, dirY); 
    } 
  }
  static void ClearConsole() 
  {
    System.out.print("\033[H\033[2J"); 
  }

  }
  
