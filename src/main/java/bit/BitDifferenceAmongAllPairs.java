package bit;

/**
 * Given an integer array of n integers,
 * find sum of bit differences in all pairs that can be formed from array elements.
 * Bit difference of a pair (x, y) is count of different bits at same positions in binary representations of x and y.
 For example, bit difference for 2 and 7 is 2.
 Binary representation of 2 is 010 and 7 is 111 ( first and last bits differ in two numbers).

 Examples:

 Input: arr[] = {1, 2}
 Output: 4
 All pairs in array are (1, 1), (1, 2)
 (2, 1), (2, 2)
 Sum of bit differences = 0 + 2 +
 2 + 0
 = 4

 Input:  arr[] = {1, 3, 5}
 Output: 8
 All pairs in array are (1, 1), (1, 3), (1, 5)
 (3, 1), (3, 3) (3, 5),
 (5, 1), (5, 3), (5, 5)
 Sum of bit differences =  0 + 1 + 1 +
 1 + 0 + 2 +
 1 + 2 + 0
 = 8
 */
public class BitDifferenceAmongAllPairs {

    public static void main(String... args) {
//        System.out.println(countBitDifference(new int[]{1,2}));
//        System.out.println(countBitDifference(new int[]{1,3,5}));

        System.out.println(efficient(new int[]{1,2}));
        System.out.println(efficient(new int[]{1,3,5}));
    }

    private static int countBitDifference(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                while (xor != 0) {
                    int and = xor & 1;
                    if (and == 1) {
                        cnt++;
                    }
                    xor = xor >> 1;
                }
            }
        }
        return cnt * 2;
    }

    /**
     * count * (n - count) gives the permutation of all numbers from two sets.
     * This product will be multiplied by 2 because you have to take the product from both the sides.
     * In the example, for bit position 0, {1} will be in one set and {2} will be other set.
     * Product here is {1, 2} and {2, 1} since you need to take from both the sides or else it will be just {1, 2}
     * @param nums
     * @return
     */
    private static int efficient(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if((nums[j] & (1 << i)) != 0) count++;
            }
            cnt += (count * (nums.length - count) * 2);
        }
        return cnt;
    }
}
