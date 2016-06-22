public class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            int newVal = digits[i] + 1;
            if(i == 0) {
                digits[i] = newVal;
            }
            else {
                digits[i] = newVal % 10;
            }
            if(newVal < 10) {
                break;
            }
        }
        
        if(digits[0] >= 10) {
            int [] expandedarr = new int[digits.length+1];
            expandedarr[0] = 1;
            digits = expandedarr;
        }
        
        return digits;
    }
}