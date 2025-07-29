import StriverA2Z.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        BasicMath cn = new BasicMath();
//        System.out.println(cn.checkPrime(97));
//        cn.printAllDivisors(36);
//        BasicRecursion br = new BasicRecursion();
//        br.fibonacciNumber(5);
//        String str = "aba";
//        System.out.println(br.checkStringPalindromeReursive(str, 0, str.length() - 1));
//        int[] arr = {4,6,8,2,1,0,7};
//        System.out.println(Arrays.toString(br.reverseArrayRecursive(arr, 0, arr.length - 1)));

//        BasicHashing bh = new BasicHashing();
//        bh.countHighestLowestFrequency(new int[]{10,15, 5, 10, 15, 10});

//        SortingI sI = new SortingI();
//        System.out.println(Arrays.toString(sI.insertionSort(arr)));

//        SortingII sII = new SortingII();
//        System.out.println(Arrays.toString(sII.quickSort(arr, 0, arr.length - 1)));
//        System.out.println(Arrays.toString(sII.recursiveInsertionSort(arr, 1)));

//        ArrayEasy ae = new ArrayEasy();
//        System.out.println(Arrays.toString(ae.findSecondSmallestAndLargest(arr)));
//        int[] arr = {1,2,0,2,3,0,0,3,0,4,5};
//        int arr1[] = {1,2,3,4,5};
//        int arr2[] = {2,3,4,0,5};
//        int arr3[] = {1,1,0,1,1,1};
//        int[] arr4 = {2,3,9,-1, 1, 1};
//        System.out.println(Arrays.toString(ae.unionTwoSortedArray(arr1, arr2)));
//        System.out.println(ae.linearSearch(arr, 57));
//        System.out.println(ae.longestSubarrayWithKSumPositiveAndNegative(arr4, 10));

        ArrayMedium am = new ArrayMedium();
        int[] arr = {7,1,5,3,6,4};
        int[] arr1 = {0,1,2,1,1,1,0,0,2,0,2,2,1};
        int[] arr2 = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
//        System.out.println(Arrays.toString(am.sortArray0s1s2s(arr1)));
        System.out.println(am.stocksBuyAndSellSingleTransactionAllowed(arr));
    }
}