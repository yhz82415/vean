package challenges;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of distinct elements. The task is to find triplets in array whose sum is zero.

 Examples:
 Input : arr[] = {0, -1, 2, -3, 1}
 Output : 0 -1 1
          2 -3 1

 Input : arr[] = {1, -2, 1, 0, 5}
 Output : 1 -2  1
 */
public class AllTripletsWithZeroSum {

    public static void main(String... args) {
        tripletsWithZeroSum(new int[]{0,-1,2,-3,1});
//        tripletsWithZeroSum(new int[]{1,-2,1,0,5});
    }
    public static void tripletsWithZeroSum(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-(nums[i] + nums[j]))) {
                    System.out.println(nums[i] + ", " + nums[j] + "," + -(nums[i] + nums[j]));
                } else {
                    set.add(nums[j]);
                }
            }
        }
    }
}
