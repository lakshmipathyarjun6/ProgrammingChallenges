public class Solution {
    private int numDecodingsHelper(String s) {
        int [] computationResults = new int[s.length()];
        
        for(int i = s.length()-1; i >= 0; i--) {
            if(i == s.length()-1) {
                computationResults[i] = (s.charAt(i) == '0') ? 0 : 1;
            }
            else {
                int index1 = (i+1 >= s.length()) ? i : i+1;
                int index2 = (i+2 >= s.length()) ? ((i+1 >= s.length()) ? i : i+1) : i+2;
                if(i == s.length()-2 && (s.charAt(i) == '1' || s.charAt(i) == '2') && s.charAt(index1) == '0') {
                    computationResults[i] = 1;
                }
                else if(s.charAt(i) == '0') {
                    computationResults[i] = 0;
                }
                else if(s.charAt(i) == '1') {
                    computationResults[i] = computationResults[index1] + computationResults[index2];
                }
                else if(s.charAt(i) == '2') {
                    int nextInt = Character.getNumericValue(s.charAt(index1));
                    if(nextInt < 7) {
                        computationResults[i] = computationResults[index1] + computationResults[index2];
                    }
                    else {
                        computationResults[i] = computationResults[index1];
                    }
                }
                else {
                    computationResults[i] = computationResults[index1];
                }
            }
        }
        return computationResults[0];
    }
    
    private boolean preCheck(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                return false;
            }
        }
        return true;
    }
    public int numDecodings(String s) {
        if(s.length() == 0 || preCheck(s)) {
            return 0;
        }
        return numDecodingsHelper(s);
    }
}