import java.util.*;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuffer smallerString;
        StringBuffer largerString;
        
        if (a.length() < b.length()) {
            smallerString = new StringBuffer(a);
            largerString = new StringBuffer(b);
        }
        else {
            smallerString = new StringBuffer(b);
            largerString = new StringBuffer(a);
        }
        while(smallerString.length() != largerString.length()) {
            smallerString.insert(0,"0");
        }
        
        Integer cout = 0;
        StringBuffer outputString = new StringBuffer();
        
        for(int i = largerString.length()-1; i >= 0; i--) {
            Integer lsval = Character.getNumericValue(largerString.charAt(i));
            Integer ssval = Character.getNumericValue(smallerString.charAt(i));
            Integer sum = lsval ^ ssval ^ cout;
            cout = (lsval & ssval) | (lsval & cout) | (ssval & cout);
            outputString.insert(0,sum.toString());
        }
        
        if(cout == 1) {
            outputString.insert(0,"1");
        }
        
        return outputString.toString();
    }
}