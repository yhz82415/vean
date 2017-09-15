package challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Count pairs with given sum
 Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array whose sum is equal to ‘sum’.

 Examples:
 Input  :  arr[] = {1, 5, 7, -1},
 sum = 6
 Output :  2
 Pairs with sum 6 are (1, 5) and (7, -1)

 Input  :  arr[] = {1, 5, 7, -1, 5},
 sum = 6
 Output :  3
 Pairs with sum 6 are (1, 5), (7, -1) &
 (1, 5)

 Input  :  arr[] = {1, 1, 1, 1},
 sum = 2
 Output :  6
 There are 3! pairs with sum 2.

 Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6,
 5, 4, 2, 1, 1, 1},
 sum = 11
 Output :  9

 Expected time complexity O(n)
 */
public class CountPairsWithGivenSum {

    public static void main(String... args) {
        System.out.println(count(new int[]{1,5,7,-1}, 6));
        System.out.println(count(new int[]{1, 5, 7, -1, 5}, 6));
        System.out.println(count(new int[]{1, 1, 1, 1}, 2));
        System.out.println(count(new int[]{10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1}, 11));
    }

    private static int count(int[] nums, int sum) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int n : nums) {
            Integer cnt = numMap.get(n);
            if(cnt == null) {
                cnt = 0;
            }
            numMap.put(n, ++cnt);
        }
        int total = 0;
        for (int n : nums) {
            Integer cnt = numMap.get(sum - n);
            if (cnt != null) {
                total += cnt;
            }
            if (sum - n == n) total--;
        }
        return total / 2;
    }
}
