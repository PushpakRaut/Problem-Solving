package StriverA2Z;

import java.util.*;

public class ArrayEasy {

    public int largestElementArray(int[] arr) {
        int largestEle = 0;
        for(int ele: arr) {
            if(ele > largestEle) {
                largestEle = ele;
            }
        }

        return largestEle;
    }

    public int[] findSecondSmallestAndLargest(int[] arr) {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int secondLarge = Integer.MIN_VALUE;

        //1st solution
//        for(int i = 0;i<arr.length;i++) {
//            if(arr[i] < small) {
//                small = arr[i];
//            }
//            if(arr[i] > large) {
//                large = arr[i];
//            }
//        }
//
//        for(int i = 0;i<arr.length;i++) {
//            if(arr[i] < secondSmall && arr[i] != small) {
//                secondSmall = arr[i];
//            }
//            if(arr[i] > secondLarge && arr[i] != large){
//                secondLarge = arr[i];
//            }
//        }


        //2nd solution
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] < small) {
                secondSmall = small;
                small = arr[i];
            } else if(arr[i] < secondSmall && arr[i] != small) {
                secondSmall = arr[i];
            }
            if(arr[i] > large) {
                secondLarge = large;
                large = arr[i];
            } else if(arr[i] > secondLarge && arr[i] != large){
                secondLarge = arr[i];
            }
        }

        //common
        System.out.println("small : " + small + " secondSmall : " + secondSmall );
        System.out.println("large : " + large + " secondLarge : " + secondLarge );

        return new int[]{secondSmall, secondLarge};
    }

    public boolean checkArrayIsSorted(int[] arr) {
        int n = arr.length;
        //1st solution
        for(int i = 0;i<n-1;i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }

    public int[] removeDuplicatesFromSortedArray(int[] arr) {
        int i = 0, j = 1;

        while(j < arr.length) {
            if(arr[i] != arr[j]) {
                i++;
                swap(arr,i, j);
            }
            j++;
        }
        while(i<arr.length-1) {
            i++;
            arr[i] = 0;
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] leftRotateArrayBy1(int[] arr) {
        int key = arr[0];
        for(int i = 1;i<arr.length;i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length - 1] = key;

        return arr;
    }

    public int[] leftRotateArrayByK(int[] arr, int k) {
        int[] ans = new int[arr.length];
        int n = arr.length;
        if(n == 1) return arr;
        k = k%n;

        for(int j = 0;j<n;j++) {
            ans[(j+k) % n] = arr[j];
        }

        for(int j = 0;j<n;j++) {
            arr[j] = ans[j];
        }

        return arr;
    }

    public int[] moveAllZeroToEnd(int[] arr) {
        int n = arr.length;
        //1st solution
//        int i = 0, j = -1;
//        while(i<n) {
//            if(arr[i] == 0) {
//                j = i;
//                break;
//            }
//            i++;
//        }
//
//        i = j + 1;
//        while(i < n) {
//            if(arr[i] != 0) {
//                swap(arr, i, j);
//                j++;
//            }
//            i++;
//        }
//        return arr;

        //2nd solution
        int i = 0;
        for(int j = 0;j<n;j++){
            if(arr[j]!=0) {
                swap(arr, i, j);
                i++;
            }
        }
        return arr;
    }

    public int linearSearch(int[] arr, int k) {
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] == k) return i;
        }
        return -1;
    }

    public int[] unionTwoSortedArray(int[] a, int[] b) {
        HashSet<Integer> hs = new LinkedHashSet<>();
        for(int e : a) {
            hs.add(e);
        }
        for(int e : b) {
            hs.add(e);
        }
        int[] arr = new int[hs.size()];
        int i = 0;
        for(int e : hs) {
            arr[i++] = e;
        }
        return arr;
    }

    public int findMissingNumberArray(int[] arr) {
//        int n = arr.length;
//        int[] ans = new int[n];
//        for(int e : arr) {
//            if(e < n) {
//                ans[e] = -1;
//            }
//        }
//        for(int i = 0;i<n;i++) {
//            if(ans[i] == 0) {
//                return i;
//            }
//        }
//
//        return n;

        //2nd solution : works with non-duplicate array
        int n = arr.length;
        int sumN = (n*(n+1))/2;
        int sum = 0;
        for(int e : arr) {
            sum+=e;
        }
        return sumN - sum;
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        for(int e : nums) {
            if(e == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);

        return maxCount;
    }

    public int longestSubarrayWithKSum(int[] arr, int k) {
//        int n = arr.length;
//        int len = 0;
//        for(int i = 0;i<n;i++) {
//            int sum = 0;
//            for(int j=i;j<n;j++) {
//                sum += arr[j];
//
//                if(sum == k) {
//                    len = Math.max(len, j-i+1);
//                }
//            }
//        }
//        return len;


        //2nd solution

//        int len = 0;
//        int n = arr.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        int sum = 0;
//        for(int i = 0;i<n;i++) {
//            sum += arr[i];
//
//            if(sum == k) {
//                len = Math.max(len, i+1);
//            }
//
//            if(map.containsKey(sum - k)) {
//                len = Math.max(len, i - map.get(sum - k));
//            }
//
//            if(!map.containsKey(sum)){
//                map.put(sum, i);
//            }
//        }
//        return len;


        //3rd solution

        int n = arr.length;
        int len = 0;
        int left = 0, right = 0;
        int sum = 0;
        while(right < n) {
            sum += arr[right];
            if(sum == k) {
                len = Math.max(len, right - left + 1);
            }

            while(sum > k && left <= right) {
                sum -= arr[left];
                left++;
            }

            right++;
        }
        return len;
    }

    public int longestSubarrayWithKSumPositiveAndNegative(int[] arr, int k) {
//        int n = arr.length;
//        int len = 0;
//
//        for(int i=0;i<n;i++) {
//            int sum = 0;
//            for(int j = i;j<n;j++) {
//                sum+=arr[j];
//                if(sum == k) {
//                    len = Math.max(len, j-i+1);
//                }
//            }
//        }
//        return len;


        //2nd solution - Hashing
        Map<Integer, Integer> map = new HashMap<>();
        int len = 0;
        int sum = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++) {
            sum += arr[i];
            if(sum == k) {
                len = Math.max(len, i+1);
            }

            if(map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }

            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }
}
