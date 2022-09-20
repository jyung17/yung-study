package basic.ex03arraylist;

import java.util.ArrayList;

class Tv {

}

class Audio {

}

public class GenericTest {

  public static void main(String[] args) {
    ArrayList<Object> list1 = new ArrayList<>();

    ArrayList<Tv> list2 = new ArrayList<>();

    list1.add(new Tv());
    list1.add(new Audio());

    list2.add(new Tv());

    Tv tv1 = (Tv) list1.get(0);
    Audio tv3 = (Audio) list1.get(1);
    Tv tv2 = list2.get(0);
  }
}
