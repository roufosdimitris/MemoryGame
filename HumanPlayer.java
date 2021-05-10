// Roufos Dimitrios, 5090

import java.util.*;

class HumanPlayer
{
  private String name;
  private int points;

  public HumanPlayer(String name){
    this.name = name;
    this.points = points;
    points = 0;
  }

  public void play(Board board){
    Scanner input = new Scanner(System.in);
    //while (true){
      System.out.print("Select first position to open: ");
      int x = input.nextInt();
      System.out.println("User input is "+x);

      System.out.print("Select second position to open: ");
      int y = input.nextInt();
      System.out.println("User input is "+y);

      /*if ((x == y) || (x > board.getN()) || (y > board.getN())){ // missing conditions
        System.out.println("Invalid input, choose again.");
      }else{
        break;
      }*/
    //}
    boolean bool = board.openPositions(x,y);
    if (bool){
      points++;
    }
  }

  public int getPoints(){
    return points;
  }

  public String toString(){
    return name;
  }

  public static void main(String[] args){
    Board board = new Board(3);
    HumanPlayer player = new HumanPlayer("Jim");
    player.play(board);
  }
}
