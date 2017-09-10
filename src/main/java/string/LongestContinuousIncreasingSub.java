package string;

/**
 * Longest Continuous Increasing Subsequence
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class LongestContinuousIncreasingSub {

    public static void main(String... args) {
        int[] arr1 = {1,3,5,4,7};
        int result1 = findLengthOfLCIS(arr1);
        assert result1 == 3;
        int[] arr2 = {2,2,2,2,2};
        int result2 = findLengthOfLCIS(arr2);
        assert result2 == 1;
    }
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            results[i] = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j - 1] < nums[j]) {
                    results[i]++;
                } else {
                    break;
                }
            }
        }
        int max = results[0];
        for (int k = 1; k < results.length; k++) {
            if(results[k] > max) {
                max = results[k];
            }
        }
        return max;
    }
}
