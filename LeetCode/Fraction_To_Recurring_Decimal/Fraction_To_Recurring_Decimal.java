public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            return "";
        }
        else if(numerator == 0) {
            return "0";
        }
        
        String result = "";
        if((numerator < 0) ^ (denominator < 0)) {
            result += "-";
        }
        long numeratorAbsVal = Math.abs((long) numerator);
        long denominatorAbsVal = Math.abs((long) denominator);
        long divResult = numeratorAbsVal / denominatorAbsVal;
        result += String.valueOf(divResult);
        
        long remainderTimes10 = (numeratorAbsVal % denominatorAbsVal)*10;
        if(remainderTimes10 == 0) {
            return result;
        }
        result += ".";
        
        Map<Long,String> previousRemainders = new HashMap<Long,String>();
        while(remainderTimes10 != 0) {
            if(previousRemainders.containsKey(remainderTimes10)) {
                String previousString = previousRemainders.get(remainderTimes10);
                String repeatingPart = result.substring(previousString.length());
                previousString += "(" + repeatingPart + ")";
                return previousString;
            }
            previousRemainders.put(remainderTimes10,result);
            divResult = remainderTimes10 / denominatorAbsVal;
            result += String.valueOf(divResult);
            remainderTimes10 = (remainderTimes10 % denominatorAbsVal)*10;
        }
        return result;
    }
}
