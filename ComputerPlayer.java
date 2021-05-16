// Roufos Dimitrios, 5090

import java.util.*;

class ComputerPlayer
{
  private String name;
  private int[] seenCards;
  private int points;
  private int n;

  public ComputerPlayer(String name, int pairs){ // Computer name and number of pairs
    this.name = name;
    n = 2*pairs;
    this.n = n;

    int[] seenCards = new int[n];
    this.seenCards = seenCards;
    for (int i = 0; i < n; i++){
      seenCards[i] = -1;
    }

    this.points = points;
    points = 0;
  }

  public void play(Board board){
    int x = board.getRandomPosition();
    for (int j = 0; j < n; j++){
      if ((board.getCard(x) == seenCards[j]) && (x != j)){
        System.out.println(name+" chose cards "+x+" and "+j);
        System.out.println("first choice\n");
        board.openPositions(x,j);
        points++;
        break;
      }
    }
    int y = board.getRandomPosition(x);
    System.out.println(name+" chose cards "+x+" and "+y+"\nsecond choice\n");
    board.delay(2);
    boolean bool = board.openPositions(x,y);
    if (bool == false){
      seenCards[x] = board.getCard(x);
      seenCards[y] = board.getCard(y);
    }else{
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
    Board testBoard = new Board(3);
    ComputerPlayer comp = new ComputerPlayer("MEMORY-MAN", 3);

    for (int i = 0; i < 5; i++){
      comp.play(testBoard);
      int x = comp.getPoints();
      System.out.println("points: "+x+"\n");
      boolean z = testBoard.allPairsFound();
      if (z){
        break;
      }
    }
  }
}
