public class Coin
{
   String ANSI_RESET = "\u001B[0m"; 
    String ANSI_RED = "\u001B[31m"; 
    String ANSI_Green = "\u001b[32m";
    boolean isPlayer = true;
    
  public Coin()
  {
   
  }

    public String GetCoinString () 
    {
      if(isPlayer){
        return ANSI_RED + "0" + ANSI_RESET;
      }
      else{
        return ANSI_Green + "0" + ANSI_RESET;
      }
    }
  
}