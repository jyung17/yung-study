package quiz;

import java.util.Scanner;

public class Main_2480 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    
    sc.close();
    
    if (a == b && a == c && b == c) {
      System.out.printf("%d", (10000 + a * 1000));
    } else if (a == b || a == c) {
      System.out.printf("%d", (1000 + a * 100));
    } else if (b == c) {
      System.out.printf("%d", (1000 + b * 100));
    } else {
      System.out.printf("%d", (Math.max(a, Math.max(b, c)) * 100));
    }
  }
}
