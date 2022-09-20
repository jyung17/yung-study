package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2577 {
  
  public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] arr = new int[10];
    
    int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine())
        * Integer.parseInt(br.readLine());
    
    String str = String.valueOf(val);
    
    for (int i = 0; i < str.length(); i++) {
      arr[(str.charAt(i) - 48)]++;
      // charAt를 사용할 경우 -'0' 또는 -48을 연산해야 아스키 대응하는 문자로 반환하지 않음.
    }
    
    for (int v : arr) {
      System.out.println(v);
    }
  }
}

