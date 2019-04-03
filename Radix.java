import java.util.Arrays;

public class Radix {
  //int[] test = {1, 3, 90, 9841, 7519, 958};
  public static void radixsort(int[] data) {
    int maxDigits = findDigits(data);

    int digitsFromRight = 1;
    MyLinkedList<Integer> numbers = new MyLinkedList<Integer>();
    for (int i = 0; i < data.length; ++i)
      numbers.add(data[i]);

    while (digitsFromRight <= maxDigits) {

      @SuppressWarnings("unchecked")
      MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
      for (int i = 0; i < 20; ++i)
        buckets[i] = new MyLinkedList<Integer>();

      while (numbers.size() > 0) {
        int num = numbers.removeFront();
        if (Math.abs(num) == num) { //positive #
          buckets[getNthDigit(num, digitsFromRight) + 10].add(num); //thx Jerry for explanation, would've done 10 conditionals otherwise
        }

        else { //negative #
          buckets[9 - getNthDigit(num, digitsFromRight)].add(num);
        }
      }

      ++digitsFromRight;

      for (int i = 0; i < buckets.length; ++i) {
        while (buckets[i].size() > 0) {
          int num = buckets[i].removeFront();
          numbers.add(num);
          //System.out.println(buckets[i]);
        }
      }
    }

    for (int i = 0; i < data.length; ++i)
      data[i] = numbers.removeFront();
  }

  public static int getNthDigit(int input, int digitsFromRight) {
    while (digitsFromRight > 1) {
      input /= 10;
      --digitsFromRight;
    }

    return Math.abs(input % 10);
  }

  private static int findDigits(int[] data) {
    //Empty list, shouldn't ever happen?
    if (data.length == 0)
      return 0;

    int max = Math.abs(data[0]); //"base", also using abs since all we care about is digits not the sign
    for (int i = 0; i < data.length; ++i)
      if (Math.abs(data[i]) > max)
        max = Math.abs(data[i]);

    return (int)Math.log10(max) + 1; //finds the exponent
  }
}
