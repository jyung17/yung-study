package quiz;

import java.util.Scanner;

public class Main1157 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int chr[] = new int[26];
    int max = 0;
    char a = 0;
    
    for (int i = 0; i < str.length(); i++) {
      int ch = Character.toLowerCase(str.charAt(i));
      chr[ch - 'a'] += 1;
    }
    
    for (int i = 0; i < chr.length; i++) {
      if (max == chr[i]) {
        a = '?';
      }
      if (max < chr[i]) {
        max = chr[i];
        a = (char) (i + 'A');
      }
    }
    
    System.out.println(a);
  }
}
