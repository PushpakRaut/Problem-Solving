package StriverA2Z;

public class BasicRecursion {

    public void printNameNTime(String name, int n) {
        if(n == 0) return;

        System.out.println(name);
        printNameNTime(name, n - 1);
    }

    public void print1ToN(int n) {
        if(n == 0) return;
        print1ToN(n-1);
        System.out.println(n);
    }

    public void printNTo1(int n) {
        if(n == 0) return;
        System.out.println(n);
        printNTo1(n-1);
    }

    public int sumOfNNummbers(int n) {
        if(n <= 1) return 1;

        return n + sumOfNNummbers(n-1);
    }

    public int factorialOfNumber(int n) {
        if(n == 1) return 1;

        return n * factorialOfNumber(n-1);
    }

    public int[] reverseArrayRecursive(int[] arr, int start, int high) {
        if(start < high) {

            swap(arr, start, high);

            reverseArrayRecursive(arr, start + 1, high - 1);
        }
        return arr;
    }

    public boolean checkStringPalindromeReursive(String str, int start, int end) {
        if(start < end) {
            if(str.charAt(start) != str.charAt(end)) return false;

            checkStringPalindromeReursive(str, start + 1, end - 1);
        }
        return true;
    }

    public void fibonacciNumber(int num) {
        for(int i = 0;i<=num;i++) {
            System.out.println(fibonacciNumberReursive(i));
        }
    }

    private int fibonacciNumberReursive(int num) {
        if(num <= 1) return num;

        return fibonacciNumberReursive(num-1) + fibonacciNumberReursive(num - 2);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
