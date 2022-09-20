package basic.ex03arraylist;

public class SimpleArrayList {
  private int size;
  private Object[] elementData = new Object[5];

  public void add(Object value) {
    elementData[size++] = value;
  }

  public Object get(int idx) {
    return elementData[idx];
  }
}