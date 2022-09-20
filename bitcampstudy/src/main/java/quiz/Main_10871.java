package quiz;

import java.util.Scanner;

public class Main_10871 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int x = sc.nextInt();
    for (int i = 0; i < a; i++) {
      int n = sc.nextInt();
      if (n < x) {
        System.out.print(n + " ");
      }
    }
  }
}