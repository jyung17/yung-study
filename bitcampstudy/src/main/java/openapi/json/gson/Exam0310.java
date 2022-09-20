package openapi.json.gson;

import com.google.gson.Gson;
import java.sql.Date;
import java.util.ArrayList;

public class Exam0310 {

  public static void main(String[] args) {
    // 1) ArrayList 준비
    Member m1 = new Member();
    m1.setNo(101);
    m1.setName("홍길동");
    m1.setEmail("hong@test.com");
    m1.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m2 = new Member();
    m2.setNo(102);
    m2.setName("임꺽정");
    m2.setEmail("leem@test.com");
    m2.setRegisteredDate(new Date(System.currentTimeMillis()));

    Member m3 = new Member();
    m3.setNo(103);
    m3.setName("안창호");
    m3.setEmail("ahn@test.com");
    m3.setRegisteredDate(new Date(System.currentTimeMillis()));

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    String jsonStr = new Gson().toJson(list);
    System.out.println(jsonStr);
  }
}
