package oop.ex12;

public class Exam0510 {
  
  static class MyCalculator {
    
    public static int plus(int a, int b) {
      return a + b;
    }
    
    public static int minus(int a, int b) {
      return a - b;
    }
    
    public static int multiple(int a, int b) {
      return a * b;
    }
    
    public static int divide(int a, int b) {
      return a / b;
    }
  }
  
  interface Calculator {
    
    int compute(int x, int y);
  }
  
  public static void main(String[] args) {
    Calculator objc = new Calculator() {
      @Override
      public int compute(int x, int y) {
        return x * y;
      }
    };
    
    Calculator obj2 = (x, y) -> x + y;
    System.out.println(obj2.compute(10, 15));
    
    Calculator c1 = MyCalculator::plus;
    System.out.println(c1.compute(10, 15));
  }
}
