package quiz;

import java.util.Scanner;

public class Main_2438 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int in = sc.nextInt();
    
    for (int i = 0; i < in; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
