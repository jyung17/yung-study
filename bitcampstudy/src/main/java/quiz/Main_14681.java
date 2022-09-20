package quiz;

import java.util.Scanner;

public class Main_14681 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();
    
    if (x > 0 && y > 0) {
      System.out.println("1");
    } else if (x > 0 && y < 0) {
      System.out.println("4");
    } else if (x < 0 && y < 0) {
      System.out.println("3");
    } else if (x < 0 && y > 0) {
      System.out.println("2");
    }
  }
}
