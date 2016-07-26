public class Solution {
    public int myAtoi(String str) {
        Integer retVal = 0;
        boolean isNegative = false;
        
        if(str.equals("")) {
            return 0;
        }
        
        int i = 0;
        while(str.charAt(i) == ' ' || str.charAt(i) == '\t') {
            i++;
        }
        
        int sign = 0;
        if(str.charAt(i) == '-') {
            isNegative = true;
            i++;
            sign = -1;
        }
        else if(str.charAt(i) == '+') {
            i++;
            sign = 1;
        }
        else {
            sign = 1;
        }
        
        if(i >= str.length()) {
            return 0;
        }
        
        Integer retValPrev = 0;
        while(Character.isDigit(str.charAt(i))) {
            retVal = 10*retVal + Character.getNumericValue(str.charAt(i));
            i++;
            if(retVal/10 != retValPrev) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            if(i >= str.length()) {
                break;
            }
            retValPrev = retVal;
        }
        
        if(isNegative) {
            retVal *= -1;
        }
        
        return retVal;
    }
}