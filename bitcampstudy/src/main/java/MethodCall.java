import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class MethodCall {
  
  public static void main(String[] args) throws Exception {
    HashMap map = new HashMap();
    System.out.println("before:" + map);
    
    ModelController mc = new ModelController();
    String viewName = mc.main(map);
    
    System.out.println("after : " + map);
    
    render(map, viewName);
  }
  
  static void render(HashMap map, String viewName) throws IOException {
    String result = "";
    // 1. 뷰의 내용을 한줄씩 읽어서 하나의 문자열로 만든다.
    Scanner sc = new Scanner(new File(viewName + ".txt"));
    
    while (sc.hasNextLine()) {
      result += sc.nextLine() + System.lineSeparator();
    }
    
    Iterator it = map.keySet().iterator();
    
    while (it.hasNext()) {
      String key = (String) it.next();
      
      // 3. replace()로 Key를 value 치환한다.
      result = result.replace("${" + key + "}", (String) map.get(key));
    }
    
    // 4. 렌더링 결과를 출력한다.
    System.out.println(result);
  }
}

class ModelController {
  
  public String main(HashMap map) {
    map.put("id", "test");
    map.put("pwd", "1111");
    
    return "txtView2";
  }
  
}
