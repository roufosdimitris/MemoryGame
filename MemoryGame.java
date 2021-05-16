// Roufos Dimitrios, 5090

import java.util.*;

class MemoryGame
{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int n = Integer.parseInt(args[0]);
    Board board = new Board(n); // Creates the Board

    System.out.println("\n\nWelcome to Memory Game!!\n");
    System.out.println("Do you want to play with a human player or against the computer?\n");
    System.out.print("Write 1 for human or 2 for computer: ");
    int opponent = input.nextInt();
    while (true){
      if (opponent == 1){
        System.out.println("\nSetting a 2 player game...\n");
        break;

      }else if (opponent == 2){
        System.out.println("\nSetting a player versus computer game...\n");
        break;
      }else{
        System.out.println("\nInvalid input. Choose again.");
        System.out.print("Write 1 for human or 2 for computer:");
        opponent = input.nextInt();
      }
    }
    input.nextLine(); // Used to fix a problem with nextInt skipping the next nextLine

    boolean gameEnd = false;

    if (opponent == 1){
      System.out.print("\nPlayer one choose your name: ");
      HumanPlayer player1 = new HumanPlayer(input.nextLine());
      System.out.print("\nPlayer two choose your name: ");
      HumanPlayer player2 = new HumanPlayer(input.nextLine());

      board.print();

      while (gameEnd == false){
        player1.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        player2.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        System.out.println(player1+" points: "+player1.getPoints()+"    "+player2+" points: "+player2.getPoints()+"\n\n");
      }
      if (player1.getPoints() > player2.getPoints()){
        System.out.println("\n"+player1+" is the winner!!");
      }else if(player1.getPoints() < player2.getPoints()){
        System.out.println("\n"+player2+" is the winner!!");
      }else{
        System.out.println("\nIt's a draw!!");
      }

    }else if (opponent == 2){
      System.out.print("Choose your name: ");
      HumanPlayer player1 = new HumanPlayer(input.nextLine());
      ComputerPlayer player2 = new ComputerPlayer("Brainiac", n);

      board.print();

      while (gameEnd == false){
        player1.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        player2.play(board);
        if (board.allPairsFound() == true){
          break;
        }
        System.out.println(player1+" points: "+player1.getPoints()+"    "+player2+" points: "+player2.getPoints()+"\n\n");
      }
      if (player1.getPoints() > player2.getPoints()){
        System.out.println("\n"+player1+" is the winner!!");
      }else if(player1.getPoints() < player2.getPoints()){
        System.out.println("\n"+player2+" is the winner!!");
      }else{
        System.out.println("\nIt's a draw!!");
      }
    }
  }
}
