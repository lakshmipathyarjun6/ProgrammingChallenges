public class Solution {
    public int findNthDigit(int n) {
        long m = n; // convert int to long 
        long targetNum = 1;
        long numDigits = 1;
        long count = 9;
 
        while(m > numDigits * count) {
            m -= numDigits*count;
            numDigits++;
            count *= 10;
            targetNum *= 10;
        }
 
        // identify the number
        targetNum = targetNum + (m-1)/numDigits;
 
        // identify the digit
        String target = String.valueOf(targetNum);
        return target.charAt((int) ((m-1) % numDigits)) - '0';
    }
}
