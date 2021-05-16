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
    System.out.print("\n"+name+", select positions to open: ");
    Scanner input = new Scanner(System.in);
    int x = input.nextInt();
    int y = input.nextInt();
    System.out.println("");

    while (true){
      if (x == y || x > board.getN() || y > board.getN() || x < 0 || y < 0){
        System.out.println("\nInvalid input, choose again.");
        System.out.println("select positions to open: ");
        x = input.nextInt();
        y = input.nextInt();
      }else if(board.getFoundCard(x) == true || board.getFoundCard(y) == true){
        System.out.println("\nPlease choose cards that are not found yet.");
        System.out.println("select positions to open: ");
        x = input.nextInt();
        y = input.nextInt();
      }else{
        break;
      }
    }
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
