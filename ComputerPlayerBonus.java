// Roufos Dimitrios, 5090

import java.util.*;

class ComputerPlayerBonus
{
  private String name;
  private int[] seenCards;
  private int points;
  private int n;

  public ComputerPlayerBonus(String name, int pairs){ // Computer name and number of pairs
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
    boolean option1 = false; // used to control whether option 1 or 2 or 3 is chosen
     // the first option where the computer knows the positions of a pair
    for (int k = 0; k < n; k++){
      for (int i = (k+1); i < n; i++){
        if ((seenCards[k] > -1) && (seenCards[k] == seenCards[i]) && (board.containsCard(k))){
          System.out.println(name+" chose cards "+k+" and "+i);
          System.out.println("first choice / bonus option");
          board.openPositions(k,i);
          points++;
          option1 = true;
          break;
        }
      }
      if (option1){
        break;
      }
    }
    boolean option2 = false;  // used to control whether option 1 or 2 or 3 is chosen
    int x = board.getRandomPosition();
     // the second option where the computer will choose a random card and then checks whether or not it has seen this card
    if (!(option1)){
      for (int j = 0; j < n; j++){
        if ((board.getCard(x) == seenCards[j]) && (x != j)){
          System.out.println(name+" chose cards "+x+" and "+j);
          System.out.println("second choice\n");
          board.openPositions(x,j);
          points++;
          option2 = true;
          break;
        }
      }
    }
     // the last option where the computer will choose two random cards
    if (!(option1) && !(option2)){
      int y = board.getRandomPosition(x);
      System.out.println(name+" chose cards "+x+" and "+y+"\nthird choice\n");
      board.delay(2);
      boolean bool = board.openPositions(x,y);
      if (bool == false){
        seenCards[x] = board.getCard(x);
        seenCards[y] = board.getCard(y);
      }else{
        points++;
      }
    }
  }

  public int getPoints(){
    return points;
  }

  public String toString(){
    return name;
  }

  public static void main(String[] args){
    Board testBoard = new Board(5);
    ComputerPlayerBonus comp = new ComputerPlayerBonus("MEMORY-MAN", 5);

    for (int i = 0; i < 7; i++){
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
