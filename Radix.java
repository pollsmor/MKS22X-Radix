import java.util.Arrays;

public class Radix {
  //int[] test = {1, 3, 90, 9841, 7519, 958};
  public static void radixsort(int[] data) {
    boolean digitsLeft = true;
    int digitsFromRight = 1;
    MyLinkedList<Integer> numbers = new MyLinkedList<Integer>();
    while (digitsLeft) {
      digitsLeft = false;
      for (int i = 0; i < data.length; ++i) {
        numbers.add(data[i]);
      }

      @SuppressWarnings("unchecked")
      MyLinkedList<Integer>[] buckets = new MyLinkedList[20];


      System.out.println(numbers);
    }
  }

  private static int getNthDigit(int input, int digitsFromRight) {
    String num = String.valueOf(input);
    char[] digits = num.toCharArray();

    if (digits.length - digitsFromRight >= 0)
      return digits[digits.length - digitsFromRight];

    return 0;
  }
}
