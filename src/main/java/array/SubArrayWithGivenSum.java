package array;

import java.util.Arrays;

/**
 * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.

 Examples:

 Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
 Ouptut: Sum found between indexes 2 and 4

 Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
 Ouptut: Sum found between indexes 1 and 4

 Input: arr[] = {1, 4}, sum = 0
 Output: No subarray found
 There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
 */
public class SubArrayWithGivenSum {

    public static void main(String... args) {
        subArr(new char[]{1,4,20,3,10,5}, 33);
    }

    private static void subArr(char[] arr, int sum) {
        int low = 0, high = 0;
        int currSum = arr[low];
        subArr(arr, sum, low, high, currSum);
    }

    private static void subArr(char[] arr, int sum, int low, int high, int currSum) {
        while (high < arr.length) {
            if (currSum == sum) {
                System.out.println("low: " + low + ". high: " + high);
                return;
            } else if (currSum < sum) {
                high++;
                if (high < arr.length) {
                    currSum += arr[high];
                } else {
                    throw new RuntimeException("high index out out bound");
                }
            } else if (currSum > sum) {
                if (low <= high) {
                    currSum -= arr[low];
                    low++;
                } else {
                    throw new RuntimeException("low is higher than high");
                }
            }
        }
        throw new RuntimeException("Not found");
    }
}
