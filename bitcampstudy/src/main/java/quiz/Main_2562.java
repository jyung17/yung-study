package quiz;

import java.util.Scanner;

public class Main_2562 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int[] x = new int[9];
    
    int max = 0;
    int maxNo = 0;
    
    for (int i = 0; i < x.length; i++) {
      x[i] = sc.nextInt();
      if (x[i] > max) {
        max = x[i];
      }
      if (x[i] == max) {
        maxNo = (i + 1);
      }
    }
    sc.close();
    
    System.out.println(max);
    System.out.println(maxNo);
  }
}
