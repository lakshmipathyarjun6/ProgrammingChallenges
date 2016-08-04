public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
 
        // init an array to track prime numbers
        boolean [] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
 
        for (int i = 2; i <= Math.sqrt(n-1); i++) {
            if (isPrime[i]) {
                for (int j = 2*i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
 
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
 
        return count;
    }
}
