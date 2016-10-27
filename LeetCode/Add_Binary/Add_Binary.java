import java.util.*;

public class Solution {
    public String addBinary(String a, String b) {
        String smallerString = (a.length() < b.length()) ? a : b;
        String largerString = (a.length() < b.length()) ? b : a;

        Integer cout = 0;
        String outputString = "";
        
        for(int i = 0; i < largerString.length(); i++) {
            int largerIndex = largerString.length() - i - 1;
            int smallerIndex = smallerString.length() - i - 1;
            Integer lsval = Character.getNumericValue(largerString.charAt(largerIndex));
            Integer ssval = (smallerIndex >= 0) ? Character.getNumericValue(smallerString.charAt(smallerIndex)) : 0;
            Integer sum = (smallerIndex >= 0) ? lsval ^ ssval ^ cout : lsval ^ cout;
            cout = (smallerIndex >= 0) ? (lsval & ssval) | (lsval & cout) | (ssval & cout) : (lsval & cout);
            outputString += sum.toString();
        }
        
        if(cout == 1) {
            outputString += "1";
        }
        
        return new StringBuilder(outputString).reverse().toString();
    }
}
