// Roufos Dimitrios, 5090

import java.util.*;

class MemoryGame
{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.print("choose number of pairs: ");
    int n = input.nextInt();
    Board board = new Board(n); // Creates the Board

    System.out.println("Do you want to play with a human player or the *best* AI ever made?");
    System.out.println("Write 1 for human or 2 if you want to get rekt:");
    int opponent = input.nextInt();
    while (true){
      if (opponent == 1){
        System.out.println("Setting a 2 player game...");
        //HumanPlayer player1 = new HumanPlayer("player1"); // will have to change args to take input
        //HumanPlayer player2 = new HumanPlayer("player2");
        break;

      }else if (opponent == 2){
        System.out.println("Setting a player versus computer game...");
        //HumanPlayer player1 = new HumanPlayer("player");
        //ComputerPlayer player2 = new ComputerPlayer("computer", n);
        break;
      }else{
        System.out.println("Invalid input. Choose again.");
        System.out.println("Write 1 for human or 2 if you want to get rekt:");
        opponent = input.nextInt();
      }
    }
    boolean gameEnd = false;

    if (opponent == 1){
      HumanPlayer player1 = new HumanPlayer("player1"); // will have to change args to take input
      HumanPlayer player2 = new HumanPlayer("player2");

      while (gameEnd == false){
        player1.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        player2.play(board);
        if (board.allPairsFound() == true){
          break;
        }
      }
      if (player1.getPoints() > player2.getPoints()){
        System.out.println(player1+"is the winner!!");
      }else if(player1.getPoints() < player2.getPoints()){
        System.out.println(player2+"is the winner!!");
      }else{
        System.out.println("It's a draw!!");
      }

    }else if (opponent == 2){
      HumanPlayer player1 = new HumanPlayer("player");
      ComputerPlayer player2 = new ComputerPlayer("computer", n);

      while (gameEnd == false){
        player1.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        player2.play(board);
        if (board.allPairsFound() == true){
          break;
        }
      }
      if (player1.getPoints() > player2.getPoints()){
        System.out.println(player1+"is the winner!!");
      }else if(player1.getPoints() < player2.getPoints()){
        System.out.println(player2+"is the winner!!");
      }else{
        System.out.println("It's a draw!!");
      }
    }
    
    /*while (gameEnd == false){
      player1.play(board);
      if (board.allPairsFound() == true){
        break;
      }
      player2.play(board);
      if (board.allPairsFound() == true){
        break;
      }
    }
    if (player1.getPoints() > player2.getPoints()){
      System.out.println(player1+"is the winner!!");
    }else if(player1.getPoints() < player2.getPoints()){
      System.out.println(player2+"is the winner!!");
    }else{
      System.out.println("It's a draw!!");
    }*/
  }
}
