import java.util.Arrays;

public class Radix {
  //int[] test = {1, 3, 90, 9841, 7519, 958};
  public static void radixsort(int[] data) {
    boolean digitsLeft = true;
    int digitsFromRight = 1;
    MyLinkedList<Integer> numbers = new MyLinkedList<Integer>();
    for (int i = 0; i < data.length; ++i)
      numbers.add(data[i]);

    while (digitsLeft) {
      digitsLeft = false;

      @SuppressWarnings("unchecked")
      MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
      for (int i = 0; i < 20; ++i)
        buckets[i] = new MyLinkedList<Integer>();

      while (numbers.size() > 0) {
        int num = numbers.removeFront();
        if (Math.abs(num) == num) { //positive #
          buckets[getNthDigit(num, digitsFromRight) + 10].add(num); //thx Jerry for explanation, would've done 10 conditionals otherwise
          digitsLeft = true;
        }

        else { //negative #
          buckets[9 - getNthDigit(num, digitsFromRight)].add(num);
          digitsLeft = true;
        }
      }

      ++digitsFromRight;
      for (int i = 0; i < buckets.length; ++i)
        System.out.println(buckets[i]);

      for (int i = 0; i < buckets.length; ++i) {
        while (buckets[i].size() > 0) {
          //System.out.println("lol");
          int num = buckets[i].removeFront();
          //System.out.println(num);
          numbers.add(num);
        }
      }
    }

    for (int i = 0; i < data.length; ++i)
      data[i] = numbers.removeFront();

    System.out.println(Arrays.toString(data));
  }

  public static int getNthDigit(int input, int digitsFromRight) {
    String num = String.valueOf(input);
    char[] digits = num.toCharArray();

    if (digits.length - digitsFromRight >= 0) {
      return Character.getNumericValue(digits[digits.length - digitsFromRight]);
    }

    return 0;
  }
}
