package basic.ex03arraylist;

public class SimpleArrayListTest {
  public static void main(String[] args) {
    SimpleArrayList simpleArrayList = new SimpleArrayList();
    simpleArrayList.add(50);
    simpleArrayList.add(100);

    System.out.println(simpleArrayList.get(0));
    System.out.println(simpleArrayList.get(1));
  }
}
