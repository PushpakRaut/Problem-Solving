package StriverA2Z;

public class BasicMath {
    public int countDigits(int num) {
//        return (int)Math.log10(num) + 1;
        int count = 0;
        while(num > 0) {
            count++;
            num/=10;
        }
        return count;
    }

    public int reverseDigits(int num) {
//        int rev = 0;
//        while(num > 0) {
//            int rem = num % 10;
//            rev = (rev * 10) + rem;
//            num /= 10;
//        }
//        return rev;
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        return Integer.parseInt(sb.reverse().toString());
    }

    public boolean checkPalindrome(int num) {
        int temp = num;
        int rev = 0;
        while(num > 0) {
            int rem = num % 10;
            rev = (rev * 10) + rem;
            num /= 10;
        }
        return temp == rev;
    }

    public int gcdHcf(int a, int b) {
        if(a%b==0) return b;

        return gcdHcf(b, a%b);
    }

    public boolean armstrongNumber(int num) {
        int sum = 0;
        int temp = num;
        while(num > 0) {
            int rem = num % 10;
            sum = sum + (rem * rem * rem);
            num /= 10;
        }

        return sum == temp;
    }

    public void printAllDivisors(int num) {
        System.out.println(1);
        for(int i = 2;i<=num/2;i++) {
            if(num % i == 0) {
                System.out.println(i);
            }
        }
        System.out.println(num);
    }

    public boolean checkPrime(int num) {
        if(num == 2 || num == 3) return true;

//        for(int i = 2;i<num/2;i++) {
//            if(num % i == 0) {
//                return false;
//            }
//        }
        for(int i = 2;i<Math.sqrt(num);i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
