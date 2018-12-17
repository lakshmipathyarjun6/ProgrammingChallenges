class Solution {
    public Pair countZerosAndOnes(String s) {
        Pair p = new Pair();
        for(int i = 0; i < s.length(); i++) {
            p.update(s.charAt(i));
        }
        return p;
    }
    
    public int findMaxForm(String[] strs, int m, int n) {
        Pair [] zeroOneCounts = new Pair[strs.length];
        
        for(int i = 0; i < strs.length; i++) {
            String s = strs[i];
            zeroOneCounts[i] = countZerosAndOnes(s);
        }
        
        int s = strs.length;
        int K[][][] = new int[s+1][m+1][n+1]; 
        
        for(int i = 0; i <= s; i++) {
            int si = i-1;
            for(int j = 0; j <= m; j++) {
                for(int k = 0; k <= n; k++) {
                    if(i == 0) {
                        K[i][j][k] = 0;
                    }
                    else if(j >= zeroOneCounts[si].zeros && k >= zeroOneCounts[si].ones && zeroOneCounts[si].zeros <= m && zeroOneCounts[si].ones <= n) {
                        K[i][j][k] = Math.max(1 + K[si][j-zeroOneCounts[si].zeros][k-zeroOneCounts[si].ones], K[si][j][k]);
                    }
                    else {
                        K[i][j][k] = K[si][j][k];
                    }
                }
            }
        }
        
        return K[s][m][n];
    }
}

class Pair {
    int zeros;
    int ones;
    
    public Pair() {
        this.zeros = 0;
        this.ones = 0;
    }
    
    public void update(char c) {
        int val = Character.getNumericValue(c);
        if(val == 0) {
            this.zeros++;
        }
        else {
            this.ones++;
        }
    }
}

