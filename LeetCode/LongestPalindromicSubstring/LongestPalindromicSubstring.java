public class Solution {
    
    public boolean isPalindrome(String s) {
        for(int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
    
    public String longestPalindrome(String s) {
        int n = s.length();
        
        boolean [][] results = new boolean[n][n];
        
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            results[i][i] = true;
        }
        
        int start = 0;
        for (int i = 0; i < n-1; i++)
        {
            if (s.charAt(i) == s.charAt(i+1))
            {
                results[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        for (int k = 3; k <= n; ++k)
        {
            // Fix the starting index
            for (int i = 0; i < n-k+1 ; ++i)
            {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;
                
                // checking for sub-string from ith index to
                // jth index iff str[i+1] to str[j-1] is a
                // palindrome
                if (results[i+1][j-1] && s.charAt(i) == s.charAt(j))
                {
                    results[i][j] = true;
                    
                    if (k > maxLength)
                    {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        
        return s.substring(start,start + maxLength);
    }
}