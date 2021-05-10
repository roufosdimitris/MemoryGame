// Roufos Dimitrios, 5090

import java.util.*;

class Board
{
  private int n;
  private int[] cardArray;
  private boolean[] foundCards;
  private Random random;
  private int arrayLength;
  private int cardsRemaining;

  public Board(int n){ // Constructor works
    this.n = n;

    Random random = new Random(); // Creates a random object, **will have to remove seed**
    this.random = random;


    int[] cardArray = new int[2*n];
    this.cardArray = cardArray;
    for (int i = 0; i < (cardArray.length/2); i++){  //initializes an unsuffled array
      cardArray[i] = i;
      cardArray[i+ (cardArray.length/2)] = i;
    }
    cardShuffle(cardArray); // Shuffles array

    this.arrayLength = arrayLength;
    arrayLength = 0;
    for (int i = 0; i < cardArray.length; i++){
      arrayLength++;
    }

    boolean[] foundCards = new boolean[2*n];
    this.foundCards = foundCards;

    this.cardsRemaining = cardsRemaining;
    cardsRemaining = 0;
    for (int i = 0; i < arrayLength; i++){
      if (foundCards[i] == false){
        cardsRemaining++;
      }
    }
  }

  private void cardShuffle(int[] unsuffledArray){ // it works
    int index, temp;
    for (int i = unsuffledArray.length - 1; i >= 0; i --){
      index = random.nextInt(i + 1);
      temp = unsuffledArray[index];
      unsuffledArray[index] = unsuffledArray[i];
      unsuffledArray[i] = temp;
    }
  }

  public void print(){ // Prints the table
    //System.out.println(Arrays.toString(cardArray));
    for (int i = 0; i < cardArray.length; i++){
      System.out.printf("%3d ", i);
    }
    System.out.println("");
    for (int i = 0; i < arrayLength; i++){
      System.out.print("----");
    }
    System.out.println("");
    for (int i = 0; i < arrayLength; i++){
      if (foundCards[i] == true){
        System.out.printf("%3s ", " ");
      }else{
        System.out.printf("%3s ", "*");
      }
    }
    System.out.println("\n");
  }

  public void flash(int pos1, int pos2){
    //System.out.println(Arrays.toString(cardArray));
    for (int i = 0; i < arrayLength; i++){
      System.out.printf("%3d ", i);
    }
    System.out.println("");
    for (int i = 0; i < arrayLength; i++){
      System.out.print("----");
    }
    System.out.println("");
    for (int i = 0; i < arrayLength; i++){
      if ((i == pos1) || (i == pos2)){
        System.out.printf("%3d ", cardArray[i]);
      }else{
        if (foundCards[i] == true){
          System.out.printf("%3s ", " ");
        }else{
          System.out.printf("%3s ", "*");
        }
      }
    }
    delay(5); // Waits for x seconds -------------------------------------------
    System.out.print("\r");
    for (int i = 0; i < arrayLength; i++){
      if (foundCards[i] == true){
        System.out.printf("%3s ", " ");
      }else{
        System.out.printf("%3s ", "*");
      }
    }
    System.out.println("\n");
  }

  public boolean openPositions(int position1, int position2){
    if (cardArray[position1] == cardArray[position2]){
      System.out.println("Pair found!\n");
      foundCards[position1] = true;
      foundCards[position2] = true;
      print();
      return true;
    }else{
      flash(position1, position2);
      return false;
    }
  }

  public int getRandomPosition(){ // may work right
    while (true){
      int nxt = random.nextInt(2*n);
      if (foundCards[nxt] == false){
        return nxt;
      }
    }
  }

  public int getRandomPosition(int position){ // may also work
    while (true){
      int nxt = random.nextInt(2*n);
      if ((position != nxt) && (foundCards[nxt] == false)){
        return nxt;
      }
    }
  }

  public boolean containsCard(int x){
    if (foundCards[x] == false){
      return true;
    }else{
      return false;
    }
  }

  public int getCard(int x){
    return cardArray[x];
  }

  public boolean allPairsFound(){
    boolean notFound = false;
    for (int j = 0; j < arrayLength; j++){
      if (foundCards[j] == false){
        notFound = true;
        break;
      }else{
        notFound = false;
      }
    }
    if (notFound == false){
      System.out.println("All pairs found!");
      return true;
    }else{
      return false;
    }
  }

  private void delay(int sec){
		try {
			Thread.currentThread().sleep(1000*sec);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

  public int getN(){
    return n;
  }

  /*public static void main(String[] args){
    Board testBoard = new Board(3);
    //System.out.println("Hello");
    testBoard.print();
    for (int i = 0; i < 6; i++){
      System.out.print(testBoard.getCard(i)+"  ");
    }
    System.out.println("\nTesting flash then openPositions then print");
    testBoard.flash(testBoard.getRandomPosition(),testBoard.getRandomPosition());
    testBoard.openPositions(0,1);
    testBoard.print();

    System.out.println("\nTesting openPositions then print");
    testBoard.openPositions(0,2);
    testBoard.print();

    System.out.println("\nTesting containsCard pn 5 and 0\n");
    System.out.println(testBoard.containsCard(5)+"\n");
    System.out.println(testBoard.containsCard(0)+"\n");

    System.out.println("\nopenPositions(4,5)");
    testBoard.openPositions(4,5);

    System.out.println("2 times getRandomPosition");
    System.out.println(testBoard.getRandomPosition()+"\n");
    System.out.println(testBoard.getRandomPosition()+"\n");

    System.out.println(testBoard.allPairsFound());
    testBoard.openPositions(1,3);
    System.out.println(testBoard.allPairsFound());
  }*/
}
