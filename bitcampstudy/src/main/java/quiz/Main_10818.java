package quiz;

import java.io.IOException;
import java.util.Scanner;

public class Main_10818 {
  
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int no = sc.nextInt();
    int[] x = new int[no];
    
    int min = 1000000;
    int max = -1000000;
    
    for (int i = 0; i < x.length; i++) {
      x[i] = sc.nextInt();
      if (x[i] > max) {
        max = x[i];
      }
      if (x[i] < min) {
        min = x[i];
      }
    }
    
    System.out.println(min + " " + max);
  }
}
