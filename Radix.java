import java.util.Arrays;

public class Radix {
  //int[] test = {1, 3, 90, 9841, 7519, 958};
  public static void radixsort(int[] data) {
    boolean digitsLeft = true;
    while (digitsLeft) {
      digitsLeft = false;
      MyLinkedList<Integer> numbers = new MyLinkedList<Integer>();
      for (int i = 0; i < data.length; ++i) {
        numbers.add(data[i]);
      }

      System.out.println(numbers);
    }
  }
}
