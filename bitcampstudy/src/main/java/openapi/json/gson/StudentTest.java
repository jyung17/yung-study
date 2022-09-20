package openapi.json.gson;

public class StudentTest {

  public static void main(String[] args) {
    Student st = new Student();
    st.no = 10;
    st.name = "홍길동";
    System.out.println(st.no);
    System.out.println(st.name);

    st.setNo(10);
    System.out.println(st.getNo());

    st.setName("홍길동");
    System.out.println(st.getName());
  }
}
