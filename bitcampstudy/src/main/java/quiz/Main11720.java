package quiz;

import java.util.Scanner;

public class Main11720 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int len = sc.nextInt();
    sc.nextLine();
    String a = sc.nextLine();
    int sum = 0;

    for (int i = 0; i < len; i++) {
      sum += a.charAt(i) - '0';
    }
    System.out.println(sum);
  }
}
