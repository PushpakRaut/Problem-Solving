package StriverA2Z;

import java.util.HashMap;
import java.util.Map;

public class ArrayMedium {

    public int[] twoSum(int[] arr, int k) {
//        for(int i = 0;i<arr.length;i++) {
//            for(int j = 0;j<arr.length;j++) {
//                if(arr[i] + arr[j] == k) return new int[]{i, j};
//            }
//        }
//        return new int[]{-1,-1};


        //2nd solution
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int i=0;i<arr.length;i++) {
//            if(map.containsKey(k - arr[i])) {
//                return new int[]{i, map.get(k-arr[i])};
//            }
//
//            map.put(arr[i], i);
//        }
//        return new int[]{-1, -1};

        //3rd solution - two pointer
        int left = 0, right = arr.length - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == k) {
                return new int[]{left, right};
            } else if(sum < k) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    public int[] sortArray0s1s2s(int[] arr) {
        int n = arr.length;

//        mergeSort(arr, 0, n-1);

        //2nd solution
//        int a=0,b=0,c=0;
//        for(int e:arr){
//            if(e==0)a++;
//            else if(e==1)b++;
//            else c++;
//        }
//
//        for(int i=0;i<a;i++) arr[i]=0;
//        for(int i=a;i<a+b;i++) arr[i]=1;
//        for(int i=a+b;i<n;i++) arr[i]=2;


        //3rd solution - Dutch national flag algorithm
        int low = 0, mid = 0, high= n - 1;

        while(mid<=high) {
            if(arr[mid] == 0){
                swap(arr, mid, low);
                low++;
                mid++;
            } else if(arr[mid] == 1){
                mid++;
            }else {
                swap(arr, mid, high);
                high--;
            }
        }
        return arr;
    }
    private void  swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private void mergeSort(int[] arr, int low, int high) {
        if(low<high) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    private void merge(int[] arr, int low, int mid, int high) {
        int n = mid - low + 1;
        int m = high - mid;

        int[] l = new int[n];
        int[] r = new int[m];

        for(int x = 0;x<n;x++) {
            l[x] = arr[low+x];
        }

        for(int x=0;x<m;x++) {
            r[x] = arr[mid+1+x];
        }

        int i =0, j=0, k=low;
        while(i<n&&j<m) {
            if(l[i]<r[j]){
                arr[k]=l[i];
                i++;
            } else{
                arr[k]=r[j];
                j++;
            }
            k++;
        }
        while(i<n){
            arr[k]=l[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k]=r[j];
            j++;
            k++;
        }
    }


    public int majorityElementNby2(int[] arr) {
        int n = arr.length;
//
//        for(int i = 0;i<n;i++) {
//            int count= 0;
//            for(int j = 0;j<n;j++) {
//                if(arr[i] == arr[j]) count++;
//            }
//            if(count > n/2) {
//                return arr[i];
//            }
//        }
//        return -1;

        //2nd solution
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int e:arr) {
//            map.put(e, map.getOrDefault(e, 0)+1);
//        }
//
//        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
//            if(e.getValue() > n/2) return e.getKey();
//        }
//
//        return -1;

        //3rd solution - Moore's voting algo
        int el = -1;
        int count = 0;
        for(int e:arr) {
            if(count == 0) {
                el = e;
                count = 1;
            } else if(el == e) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for(int e: arr) {
            if(el == e) count++;
        }
        if(count > n/2) return el;
        return -1;
    }

    public int maximumSubarraySumKadanesAlgo(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++) {
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum+=arr[j];
            }
            max = Math.max(max, sum);
        }
        return max;

        // kadanes algorithm
//        int n = arr.length;
//        int max = Integer.MIN_VALUE;
//        int sum = 0;
//        for(int e: arr) {
//            sum+=e;
//
//            if(sum > max) {
//                max = sum;
//            }
//
//            if(sum < 0) {
//                sum = 0;
//            }
//        }
//        return max;
    }

    public int maximumSubarraySumKadanesAlgoWithSubarray(int[] arr) {
//        int n = arr.length;
//        int max = Integer.MIN_VALUE;
//        int start = 0, end = 0;
//        for(int i = 0;i<n;i++) {
//            int sum = 0;
//            for(int j=i;j<n;j++) {
//                sum+=arr[j];
//                if(sum > max) {
//                    max = sum;
//                    start = i;
//                    end = j;
//                }
//            }
//        }
//
//        for(int i=start;i<=end;i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        return max;

        //kadane's algorithm
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int start =0,end =0;
        int sum = 0;
        for(int i=0;i<n;i++) {
            if(sum == 0) start = i;
            sum+=arr[i];

            if(sum > max) {
                max = sum;
                end = i;
            }

            if(sum < 0) {
                sum = 0;
            }
        }

        for(int i = start;i<=end;i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        return max;
    }

    public int stocksBuyAndSellSingleTransactionAllowed(int[] arr){
        int n = arr.length;
        int max = Integer.MIN_VALUE;

//        for(int i=0;i<n;i++){
//            int sum = 0;
//            for(int j=i+1;j<n;j++){
//                if(arr[j]>arr[i]){
//                    max = Math.max(max, arr[j] - arr[i]);
//                }
//            }
//        }
//
//        return max;


//        int[] aux = new int[n];
//        int maxEl = 0;
//        for(int i=n-1;i>=0;i--){
//            if(arr[i] > maxEl) {
//                maxEl = arr[i];
//            }
//            aux[i] = maxEl;
//        }
//
//        for(int i=0;i<n;i++) {
//            max = Math.max(max, aux[i]-arr[i]);
//        }
//        return max;
        int mini = arr[0];
        for(int i=1;i<n;i++) {
            int cost = arr[i] - mini;
            max = Math.max(max, cost);
            mini = Math.min(mini, arr[i]);
        }
        return max;
    }

}
