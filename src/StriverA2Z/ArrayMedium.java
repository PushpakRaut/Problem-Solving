package StriverA2Z;

import java.util.*;

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

    public int stocksBuyAndSellMultipleTransactionAllowed(int[] arr) {
        int  n = arr.length;
        int profit = 0;

        for(int i=1;i<n;i++) {
            if(arr[i] > arr[i-1]){
                profit += arr[n -1];
            }
        }
        return profit;
    }

    public int[] rearrangeArrayWithPositiveAndNegative(int[] arr) {
        int[] ans  = new int[arr.length];
        int n =arr.length;
        int i =0, j=1;
        for(int e: arr) {
            if(e > 0) {
                ans[i] = e;
                i+=2;
            } else{
                ans[j] = e;
                j+=2;
            }
        }
        return ans;
    }

    public Set<ArrayList<Integer>> printAllPermutationsWithExtraSpace(int[] arr) {
        List<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[arr.length];
        recursivePermWithExtraSpace(arr, ans, ds, freq);
        Set<ArrayList<Integer>> set = new HashSet<>();
        for(ArrayList<Integer> e: ans){
            set.add(e);
        }
        return set;
    }

    private void recursivePermWithExtraSpace(int[] arr, List<ArrayList<Integer>> set, ArrayList<Integer> ds, boolean[] freq) {
        if(ds.size() == arr.length) {
            set.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<arr.length;i++) {
            if(!freq[i]) {
                freq[i]=true;
                ds.add(arr[i]);
                recursivePermWithExtraSpace(arr, set, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    public Set<ArrayList<Integer>> printAllPermutationsWithoutExtraSpace(int[] arr) {
        Set<ArrayList<Integer>> set = new HashSet<>();

        recursivePermWithoutExtraSpace(arr, set, 0);
        return set;
    }

    private void recursivePermWithoutExtraSpace(int[] arr, Set<ArrayList<Integer>> set, int pointer){
        if(pointer == arr.length) {
            ArrayList<Integer> ds = new ArrayList<>();
            for(int e: arr){
                ds.add(e);
            }
            set.add(ds);
            return;
        }

        for(int i=pointer;i<arr.length;i++) {
            swap(arr, i, pointer);
            recursivePermWithoutExtraSpace(arr, set, pointer + 1);
            swap(arr, i, pointer);
        }
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length;
        int idx = -1;
        for(int i = n-2;i>=0;i--) {
            if(arr[i] < arr[i+1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            reverse(arr, 0, n-1);
            return;
        }

        for(int i=n-1;i>=idx;i--) {
            if(arr[i] > arr[idx]) {
                swap(arr, i, idx);
                break;
            }
        }

        reverse(arr, idx+1, n-1);
        System.out.println(Arrays.toString(arr));

    }
    private void reverse(int[] arr, int low, int high) {
        while(low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public ArrayList<Integer> leadersInArray(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i=0;i<n;i++) {
//            boolean flag = true;
//            for(int j=i+1;j<n;j++) {
//                if(arr[i] < arr[j]) {
//                    flag = false;
//                }
//            }
//            if(flag){
//                ans.add(arr[i]);
//            }
//        }
//        return ans;


        //2nd solution

        int max = arr[n-1];
        ans.add(max);
        for(int i=n-2;i>=0;i--) {
            if(arr[i] > max){
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }

    public int longestConsecutive(int[] arr) {
//        int longest = 0;
//        int n = arr.length;
//        for(int i=0;i<n;i++) {
//            int x = arr[i];
//            int count=0;
//            while(linearSearch(arr, x)){
//                count++;
//                x=x+1;
//            }
//            if(count> longest) {
//                longest = count;
//            }
//        }
//        return longest;

        //better solution

//        if(arr.length == 0) return 0;
//        int longest = 1;
//        int lastSmaller = Integer.MIN_VALUE;
//        int count = 0;
//        Arrays.sort(arr);
//        for(int e: arr) {
//            if(e == lastSmaller + 1) {
//                count++;
//                lastSmaller = e;
//            } else if(e != lastSmaller) {
//                lastSmaller = e;
//                count = 1;
//            }
//
//            if(count > longest) {
//                longest = count;
//            }
//        }
//        return longest;


        //optimal solution

        if(arr.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int longest = 1;
        for(int e: arr) {
            set.add(e);
        }
        for(int e : set) {
            if(!set.contains(e-1)) {
                int count = 1;
                int x = e;
                while(set.contains(x+1)) {
                    x=x+1;
                    count++;
                }
                if(count > longest) {
                    longest = count;
                }
            }
        }
        return longest;
    }
    private boolean linearSearch(int[] arr, int x) {
        for(int e: arr) {
            if(e==x) {
                return true;
            }
        }
        return false;
    }

    public void setZeroes(int[][] matrix) {
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//
//
//        for(int i = 0;i<matrix.length;i++) {
//            for(int j=0;j<matrix[0].length;j++) {
//                if(matrix[i][j]==0) {
//                    ArrayList<Integer> ds = new ArrayList<>();
//                    ds.add(i);
//                    ds.add(j);
//                    list.add(ds);
//                }
//            }
//        }
//
//        for(ArrayList<Integer> e: list) {
//            for(int k = 0;k<matrix[0].length;k++) {
//                matrix[e.get(0)][k] = 0;
//            }
//
//            for(int k = 0;k<matrix.length;k++) {
//                matrix[k][e.get(1)] = 0;
//            }
//        }


        int col0 = 1;
        for(int i =0;i<matrix.length;i++) {
            for(int j =0;j<matrix[0].length;j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if(j!=0) {
                        matrix[0][j] = 0;
                    } else{
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1;i< matrix.length;i++) {
           for(int j=1;j<matrix[0].length;j++) {
               if(matrix[i][j]!=0) {
                   if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                       matrix[i][j] = 0;
                   }
               }
           }
        }

        if(matrix[0][0] == 0) {
            for(int j=0;j<matrix[0].length;j++) {
                matrix[0][j] = 0;
            }
        }
        if(col0==0) {
            for(int i=0;i<matrix.length;i++) {
                matrix[i][0] = 0;
            }
        }

        for(int[] e: matrix)
            System.out.println(Arrays.toString(e));
    }

    public void rotateMatrixBy90Degree(int[][] matrix) {
        //1st with extra space of n*m
//        int[][] rotated = new int[matrix.length][matrix[0].length];
//
//        for(int i=0;i<matrix.length;i++) {
//            for(int j=0;j<matrix[0].length;j++) {
//                rotated[j][matrix.length - i - 1] = matrix[i][j];
//            }
//        }
//
//        for(int[] e: rotated){
//            System.out.println(Arrays.toString(e));
//        }

        //2nd with in place solution

        for(int i=0;i<matrix.length;i++) {
            for(int j=i;j<matrix[0].length;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] ints : matrix) {
            reverse(ints, 0, ints.length - 1);
        }

        for(int[] e: matrix) {
            System.out.println(Arrays.toString(e));
        }
    }

    public void spiralTraversalOfMatrix(int[][] matrix) {
        int top=0, left=0,right=matrix[0].length, bottom = matrix.length;

        while(top < bottom && left < right) {

            for(int i=left;i<right;i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for(int i = top;i<bottom;i++) {
                System.out.print(matrix[i][right-1] + " ");
            }
            right--;

            if(!(top < bottom && left < right)) {
                break;
            }

            for(int i = right-1;i>=left;i--) {
                System.out.print(matrix[bottom-1][i] + " ");
            }
            bottom--;

            for(int i = bottom-1;i>=top;i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;
        }
    }
}
