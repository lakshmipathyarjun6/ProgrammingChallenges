public class Solution {
    public String getPermutation(int n, int k) {
        boolean[] usedVals = new boolean[n];
        StringBuilder buf = new StringBuilder("");
 
        int [] numCombinations = new int[n];
        numCombinations[0] = 1;
 
        for (int i = 1; i < n; i++) {
            numCombinations[i] = numCombinations[i-1] * i;
        }
 
        for (int i = n - 1; i >= 0; i--) {
            int toAppend = 1;
            while (k > numCombinations[i]) {
                toAppend++;
                k -= numCombinations[i];
            }
            for (int j = 0; j < n; j++) {
                if (j + 1 <= toAppend && usedVals[j]) {
                    toAppend++;
                }
            }
            usedVals[toAppend-1] = true;
            buf.append(Integer.toString(toAppend));
        }
 
        return buf.toString();
    }
    
}
