package quiz;

import java.util.Scanner;

public class Main10809 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String a = sc.nextLine();
    int[] arr = new int[26];
    
    for (int i = 0; i < arr.length; i++) {
      arr[i] = -1;
    }
    
    for (int i = 0; i < a.length(); i++) {
      char ch = a.charAt(i);
      
      if (arr[ch - 'a'] == -1) {
        arr[ch - 'a'] = i;
      }
    }
    
    for (int val : arr) {
      System.out.print(val + " ");
    }
  }
}
