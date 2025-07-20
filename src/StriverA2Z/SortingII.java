package StriverA2Z;

public class SortingII {

    public int[] mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
        return arr;
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int n = mid - low + 1;
        int m = high - mid;

        int[] l = new int[n];
        int[] r = new int[m];

        for(int x = 0;x<n;x++) {
            l[x] = arr[low + x];
        }

        for(int x=0;x<m;x++) {
            r[x] = arr[mid+1+x];
        }

        int i = 0;
        int j = 0;
        int k = low;
        while(i < n && j< m) {
            if(l[i] < r[j]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }

        while(i<n) {
            arr[k] = l[i];
            i++;
            k++;
        }

        while(j<m) {
            arr[k] = r[j];
            j++;
            k++;
        }
    }

    public int[] quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j=low;j<high;j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);

        return i+1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int[] recursiveBubbleSort(int[] arr, int n) {
        if(n == 0) return arr;

        for(int i = 0;i<n;i++) {
            if(arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
        return recursiveBubbleSort(arr, n - 1);
    }

    public int[] recursiveSelectionSort(int[] arr, int n) {
        if(n == arr.length - 1) return arr;
        int index = n;
        for(int i = n+1;i< arr.length;i++) {
            if(arr[i] < arr[index]) {
                index = i;
            }
        }
        swap(arr, n, index);

        return recursiveSelectionSort(arr, n + 1);
    }

    public int[] recursiveInsertionSort(int[] arr, int n) {
        if(n == arr.length) return arr;
        int key = arr[n];
        int j = n - 1;
        while(j>=0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;

        return recursiveInsertionSort(arr, n + 1);
    }
}
