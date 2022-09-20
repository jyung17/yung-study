package quiz;

import java.util.Scanner;

public class Main_2884 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner scanner = new Scanner(System.in);
    int hour = scanner.nextInt();
    int min = scanner.nextInt();
    scanner.close();
    
    if (min < 45) {
      hour--;
      if (hour < 0) {
        hour = 23;
      }
      System.out.printf("%d %d", hour, min + 15);
    } else {
      System.out.printf("%d %d", hour, (min - 45));
    }
  }
}
