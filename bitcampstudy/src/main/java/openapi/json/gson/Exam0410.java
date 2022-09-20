package openapi.json.gson;

import com.google.gson.Gson;
import java.sql.Date;

public class Exam0410 {

  public static void main(String[] args) {
    Member m = new Member();
    m.setNo(100);
    m.setName("홍길동");
    m.setEmail("hong@test.com");
    m.setPassword("1111");
    m.setPhoto("hong.gif");
    m.setTel("010-2222-1111");
    m.setRegisteredDate(new Date(System.currentTimeMillis()));

    Board b = new Board();
    b.setNo(1);
    b.setTitle("제목");
    b.setContent("내용");
    b.setWriter(m);
    b.setViewCount(98);
    b.setLike(5);
    b.setRegisteredDate(new Date(System.currentTimeMillis()));

    String jsonStr = new Gson().toJson(b);
    System.out.println(jsonStr);

    Board b2 = new Gson().fromJson(jsonStr, Board.class);
    System.out.println(b2);
  }
}
