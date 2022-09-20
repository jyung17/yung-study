package quiz;

public class Main_11021 {
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    java.util.Scanner sc = new java.util.Scanner(System.in);
    int lotate = sc.nextInt();
    for (int i = 1; i <= lotate; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      System.out.printf("Case #%d: %d\n", i, a + b);
    }
    sc.close();
  }
}
