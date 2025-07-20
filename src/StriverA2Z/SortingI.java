package StriverA2Z;

public class SortingI {

    public int[] selectionSort(int[] arr) {

        for(int i = 0;i<arr.length;i++) {
            int index = i;
            for(int j = i+1;j<arr.length;j++) {
                if(arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, i, index);

        }
        return arr;
    }

    public int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0;i<n;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr) {
        int n = arr.length;
        for(int i = 1;i<n;i++) {
            int key = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
