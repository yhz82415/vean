package bit;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    /**
     * Concept

     If we take XOR of zero and some bit, it will return that bit
     a^0 = a
     If we take XOR of two same bits, it will return 0
     a^a = 0
     a^b^a = (a^a)^b = 0^b = b
     So we can XOR all bits together to find the unique number.
     * @param args
     */
    public static void main(String... args) {
        int[] nums1 = {1,2,3,4,2,5,3,4,1};
        System.out.println(singleNumber(nums1));
    }

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
