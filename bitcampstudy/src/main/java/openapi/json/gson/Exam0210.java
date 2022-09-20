package openapi.json.gson;


import com.google.gson.Gson;
import java.sql.Date;

public class Exam0210 {

  public static void main(String[] args) {
    Member m1 = new Member();
    m1.setNo(101);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m2 = new Member();
    m2.setNo(201);
    m2.setName("임꺽정");
    m2.setEmail("leam@test.com");
    m2.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m3 = new Member();
    m3.setNo(301);
    m3.setName("안창호");
    m3.setEmail("ahn@test.com");
    m3.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member[] members = {m1, m2, m3};

    String jsonStr = new Gson().toJson(members);
    System.out.println(jsonStr);

    Member[] arr = new Gson().fromJson(jsonStr, Member[].class);
    for (Member m : members) {
      System.out.println(m);
    }
  }
}
