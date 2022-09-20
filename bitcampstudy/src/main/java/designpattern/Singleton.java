package designpattern;

class SingletonTest {

  private static class singleInstanceHolder {

    private static final SingletonTest INSTANCE = new SingletonTest();
  }

  public static synchronized SingletonTest getInstance() {
    return singleInstanceHolder.INSTANCE;
  }
}

public class Singleton {

  public static void main(String[] args) {
    SingletonTest a = SingletonTest.getInstance();
    SingletonTest b = SingletonTest.getInstance();
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    if (a == b) {
      System.out.println(true);
    }
  }
}
