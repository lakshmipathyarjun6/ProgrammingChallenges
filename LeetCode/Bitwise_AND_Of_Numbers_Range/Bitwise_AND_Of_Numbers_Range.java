public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == n) {
            return m;
        }
        String binaryM = to32BitString(m);
        String binaryN = to32BitString(n);
        
        String result = "";
        int index = 0;
        while(binaryM.charAt(index) == binaryN.charAt(index)) {
            result += Character.toString(binaryM.charAt(index));
            index++;
        }

        while(index < 31) {
            result += "0";
            index++;
        }
        
        return Integer.parseInt(result,2);
    }
    
    public String to32BitString(int m) {
        String original = Integer.toBinaryString(m);
        while(original.length() < 31) {
            original = "0" + original;
        }
        return original;
    }
}
