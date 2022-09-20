package quiz;

import java.util.Scanner;

public class Main_2525 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    Scanner sc = new Scanner(System.in);
    
    int h = sc.nextInt();
    int m = sc.nextInt();
    int time = sc.nextInt();
    
    h = h + time / 60;
    m = m + time % 60;
    
    if (m > 59) {
      h++;
      m = m - 60;
    }
    
    if (h > 23) {
      h = h - 24;
    }
    
    System.out.printf("%d %d", h, m);
  }
}
