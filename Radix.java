import java.util.Arrays;

public class Radix {
  //int[] test = {1, 3, 90, 9841, 7519, 958};
  public static void radixsort(int[] data) {
    boolean digitsLeft = true;
    int digitsPlace = 1;
    MyLinkedList<Integer> numbers = new MyLinkedList<Integer>();
    while (digitsLeft) {
      digitsLeft = false;
      for (int i = 0; i < data.length; ++i) {
        numbers.add(data[i]);
      }

      int[] bucket0 = new int[data.length];
      int[] bucket1 = new int[data.length];
      int[] bucket2 = new int[data.length];
      int[] bucket3 = new int[data.length];
      int[] bucket4 = new int[data.length];
      int[] bucket5 = new int[data.length];
      int[] bucket6 = new int[data.length];
      int[] bucket7 = new int[data.length];
      int[] bucket8 = new int[data.length];
      int[] bucket9 = new int[data.length];

      for (int i = 0; i < data.length; ++i) {
        if (numbers.removeFront() / 10 ^ i
      }

      System.out.println(numbers);
    }
  }
}
