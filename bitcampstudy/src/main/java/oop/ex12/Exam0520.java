package oop.ex12;

public class Exam0520 {
  
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
    
    public static int power(int a) {
      return a * 2;
    }
  }
  
  interface Calculator {
    
    int compute(int a, int b);
  }
  
  public static void main(String[] args) {
    Calculator c01 = MyCalculator::plus;
    Calculator c02 = MyCalculator::minus;
    Calculator c03 = MyCalculator::multiple;
    Calculator c04 = MyCalculator::divide;
    
    Calculator c1 = new Calculator() {
      @Override
      public int compute(int a, int b) {
        return MyCalculator.plus(a, b);
      }
    };
    
    System.out.println(c01 == c02);
    System.out.println(c01.compute(200, 100));
    System.out.println(c1.compute(200, 100));
  }
}
