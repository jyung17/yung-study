package quiz;

import java.util.Scanner;

public class Main_2439 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int in = sc.nextInt();
    
    for (int i = 1; i <= in; i++) {
      for (int j = i; j <= in - 1; j++) {
        System.out.print(" ");
      }
      for (int k = 1; k <= i; k++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
