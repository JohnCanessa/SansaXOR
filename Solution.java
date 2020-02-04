import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

  /**
   * 1. When the number of values is EVEN, the resulting subarrays are:
   *
   * Sample case: {1, 2 ,3, 4}
   * 
   * 1⊕2⊕3⊕4⊕(1⊕2)⊕(2⊕3)⊕(3⊕4)⊕(1⊕2⊕3)⊕(2⊕3⊕4)⊕(1⊕2⊕3⊕4)
   *
   * Notice that 1 occurs an EVEN number of times, so as for 2, 3, and 4. XORing
   * any number an EVEN number of times results in 0.
   * 
   * 2. When the number of values is ODD, the resulting subarrays are:
   *
   * Sample case: {1, 2, 3, 4, 5}
   *
   * 1⊕2⊕3⊕4⊕5⊕(1⊕2)⊕(2⊕3)⊕(3⊕4)⊕(4⊕5)⊕(1⊕2⊕3)⊕(2⊕3⊕4)⊕(3⊕4⊕5)⊕(1⊕2⊕3⊕4)⊕(2⊕3⊕4⊕5)⊕(1⊕2⊕3⊕4⊕5)
   *
   * Notice that every EVEN index (0, 2, 4, ...) occurs an ODD number of times and
   * every ODD index (1, 3, 5, ...) occurs an EVEN number of times.
   */
  static int sansaXor(int[] arr) {

    // **** for starters ****
    int sum = 0;

    // **** get the number of elements in the array ****
    int n = arr.length;

    // **** process array when n is ODD ****
    if ((n % 2) == 1) {

      // **** initilaize sum (i == 0) ****
      sum = arr[0];

      // **** loop through all EVEN indices in arr (i: [2, 4, 6, ...]) ****
      for (int i = 2; i < n; i += 2) {
        sum ^= arr[i];
      }
    }

    // **** return sum ****
    return sum;
  }

  // **** open the scanner ****
  private static final Scanner scanner = new Scanner(System.in);

  /**
   * Test scaffolding.
   */
  public static void main(String[] args) throws IOException {

    // **** buffered writer to system.out****
    // BufferedWriter bufferedWriter = new BufferedWriter(new
    // FileWriter(System.getenv("OUTPUT_PATH")));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // **** number of test cases ****
    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    // **** loop once per test case ****
    for (int tItr = 0; tItr < t; tItr++) {

      // **** ****
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      // **** instantiate the array of integers ****
      int[] arr = new int[n];

      // **** read all the integer values ****
      String[] arrItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      // **** load the array of integers ****
      for (int i = 0; i < n; i++) {
        int arrItem = Integer.parseInt(arrItems[i]);
        arr[i] = arrItem;
      }

      // **** compute result ****
      int result = sansaXor(arr);

      // **** display result ****
      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    // **** close the buffered writter ****
    bufferedWriter.close();

    // **** close the scanner ****
    scanner.close();
  }
}