public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String stringRep = Integer.toBinaryString(n);
        int counter = 0;
        
        for(int i = 0; i < stringRep.length(); i++) {
            if(stringRep.charAt(i) == '1') {
                counter++;
            }
        }
        
        return counter;
    }
}