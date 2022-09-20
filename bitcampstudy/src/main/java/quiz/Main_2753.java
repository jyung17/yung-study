package quiz;

import java.util.Scanner;

public class Main_2753 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    int score;
    score = scanner.nextInt();
    
    if (90 <= score && score <= 100) {
      System.out.println("A");
    } else if (80 <= score && score < 90) {
      System.out.println("B");
    } else if (70 <= score && score < 80) {
      System.out.println("C");
    } else if (60 <= score && score < 70) {
      System.out.println("D");
    } else {
      System.out.println("F");
    }
    
  }
  
}
