package jdbc.ex01;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueTest {
  
  public static void main(String[] args) {
    
    int[] array = {3, 5, 6, 9, 2, 4, 7};
    
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>(Collections.reverseOrder());
    
    for (int i = 0; i < array.length; i++) {
      priorityQueue.add(array[i]);
      priorityQueue2.add(array[i]);
    }
    System.out.println(priorityQueue);
    System.out.println(priorityQueue2);
    
    for (int i = 0; i < array.length; i++) {
      System.out.print(priorityQueue.poll() + " ");
    }
    
    System.out.println();
    
    for (int i = 0; i < array.length; i++) {
      System.out.print(priorityQueue2.poll() + " ");
    }
    
  }
}
