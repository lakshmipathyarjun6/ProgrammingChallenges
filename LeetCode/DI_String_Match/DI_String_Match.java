class Solution {
    public int[] diStringMatch(String S) {
        int [] original = new int[S.length() + 1];
        int [] output = new int[S.length() + 1];
        
        for(int i = 0; i < original.length; i++) {
            original[i] = i;
        }
        
        int lowerIndex = 0;
        int upperIndex = original.length - 1;
        boolean lowerWasLast = false;
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(ch == 'I') {
                output[i] = original[lowerIndex];
                lowerIndex++;
                lowerWasLast = true;
            }
            else {
                output[i] = original[upperIndex];
                upperIndex--;
                lowerWasLast = false;
            }
        }
        
        output[output.length-1] = (lowerWasLast) ? original[lowerIndex] : original[upperIndex];
        return output;
    }
}
