package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1110 {
  
  public static void main(String[] args) throws IOException {
    // Scanner sc = new Scanner(System.in);
    // int startNo = sc.nextInt();
    // int count = 0;
    
    // ArrayList<Integer> cycle = new ArrayList<Integer>();
    // cycle.add(startNo);
    
    // while(true) {
    //     int a = cycle.get(count) / 10;
    //     int b = cycle.get(count) % 10;
    //     cycle.add((b*10) + ((a+b) % 10));
    
    //     count++;
    //     if(true == (cycle.get(0) == cycle.get(count))) {
    //         System.out.println(count);
    //         break;
    //     }
    // }
    // sc.close();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int N = Integer.parseInt(br.readLine());
    
    int cnt = 0;
    int copy = N;
    
    do {
      N = ((N % 10) * 10) + (((N / 10) + (N % 10)) % 10);
      cnt++;
    } while (copy != N);
    
    System.out.println(cnt);
  }
}
