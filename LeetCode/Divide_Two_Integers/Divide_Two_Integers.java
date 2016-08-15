public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
 
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
 
        int result = 0;
        while(pDividend>=pDivisor){
            int leftShifts = 0;    
            while(pDividend >= (pDivisor << leftShifts)) {
                leftShifts++;
            }

            result += 1 << (leftShifts-1);
            pDividend -= (pDivisor << (leftShifts-1));
        }
 
        if((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return result;
        }
        else{
            return -result;
        }
    }
}
