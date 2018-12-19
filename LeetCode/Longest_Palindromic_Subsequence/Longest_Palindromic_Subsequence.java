class Solution {
    public int longestPalindromeSubseq(String s) {
        
        int [][] K = new int[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            K[i][i] = 1;
        }
        
        for(int j = 1; j < s.length(); j++) {
            for(int i = 0; i < s.length()-1; i++) {
                if(i+j < s.length()) {
                    if(s.charAt(i) == s.charAt(i+j)) {
                        K[i][i+j] = 2 + K[i+1][i+j-1];
                    }
                    else {
                        K[i][i+j] = Math.max(K[i][i+j-1], K[i+1][i+j]);
                    }
                }
            }
        }
        
        return K[0][s.length()-1];
    }
}
