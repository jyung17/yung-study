package quiz;

import java.util.Scanner;

public class Main_11022 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int r = sc.nextInt();
    for (int i = 1; i <= r; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.printf("Case #%d: %d + %d = %d\n", i, a, b, a + b);
    }
  }
}
