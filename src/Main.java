import StriverA2Z.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        BasicMath cn = new BasicMath();
//        System.out.println(cn.checkPrime(97));
//        cn.printAllDivisors(36);
//        BasicRecursion br = new BasicRecursion();
//        br.fibonacciNumber(5);
        String str = "aba";
//        System.out.println(br.checkStringPalindromeReursive(str, 0, str.length() - 1));
        int[] arr = {4,6,8,2,1,0,7};
//        System.out.println(Arrays.toString(br.reverseArrayRecursive(arr, 0, arr.length - 1)));

//        BasicHashing bh = new BasicHashing();
//        bh.countHighestLowestFrequency(new int[]{10,15, 5, 10, 15, 10});

//        SortingI sI = new SortingI();
//        System.out.println(Arrays.toString(sI.insertionSort(arr)));

        SortingII sII = new SortingII();
//        System.out.println(Arrays.toString(sII.quickSort(arr, 0, arr.length - 1)));
        System.out.println(Arrays.toString(sII.recursiveInsertionSort(arr, 1)));
    }
}