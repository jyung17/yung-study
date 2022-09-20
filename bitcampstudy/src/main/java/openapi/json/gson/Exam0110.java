package openapi.json.gson;

import com.google.gson.Gson;
import java.sql.Date;

public class Exam0110 {

  public static void main(String[] args) {
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    Gson gson = new Gson();

    String jsonStr = gson.toJson(m);
    System.out.println(jsonStr);

    Member m2 = gson.fromJson(jsonStr, Member.class);
    System.out.println(m2);
  }
}
