package bit;

/**
 * Let us see an example.
 arr[] = {2, 4, 7, 9, 2, 4}
 1) Get the XOR of all the elements.
 xor = 2^4^7^9^2^4 = 14 (1110)
 2) Get a number which has only one set bit of the xor.
 Since we can easily get the rightmost set bit, let us use it.
 set_bit_no = xor & ~(xor-1) = (1110) & ~(1101) = 0010
 Now set_bit_no will have only set as rightmost set bit of xor.
 3) Now divide the elements in two sets and do xor of
 elements in each set, and we get the non-repeating
 elements 7 and 9. Please see implementation for this
 step.
 */
public class FindTwoNonRepeatingElementInArr {

    public static void main(String... args) {
        find(new int[]{2,4,7,9,2,4});
    }

    private static void find(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor = xor ^ n;
        }
        int setBit = xor & ~(xor - 1);
        int x = 0, y = 0;
        for (int n : nums) {
            if ((n & setBit) == 0) {
                x = x ^ n;
            } else {
                y = y ^ n;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }
}
