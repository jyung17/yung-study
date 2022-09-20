package basic.ex03arraylist;

import java.util.ArrayList;

public class Exam0130 {

  public static void main(String[] args) {
    class Member {

      String name;
      int age;

      public Member() {
      }

      public Member(String name, int age) {
        this.name = name;
        this.age = age;
      }

      public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj) {
          return true;
        }
        return true;
      }
    } // Member

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);
    System.out.println(list);

    Member m4 = new Member("임꺽정", 30);
    System.out.println(list.contains(m4));
    System.out.println(m2 == m4);
    System.out.println(m2.equals(m4));
    System.out.println(m2.hashCode());
    System.out.println(m4.hashCode());

//    for (Member arr : list) {
//      System.out.println(arr);
//    }

  } // Main
}
