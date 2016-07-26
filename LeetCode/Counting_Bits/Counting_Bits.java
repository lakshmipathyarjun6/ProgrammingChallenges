public class Solution {
    
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
    
    public int[] countBits(int num) {
        int [] arr = new int[num+1];
        for(int i = 0; i <= num; i++) {
            arr[i] = hammingWeight(i);
        }
        return arr;
    }
}