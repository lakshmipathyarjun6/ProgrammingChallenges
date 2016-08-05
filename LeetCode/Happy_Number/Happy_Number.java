public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> previousResults = new HashSet<Integer>();
        while(true) {
            if(previousResults.contains(n)) {
                return false;
            }
            else if(n == 1) {
                break;
            }
            previousResults.add(n);
            int nextNum = 0;
            while(n > 0) {
                int toSquare = n % 10;
                nextNum += toSquare*toSquare;
                n /= 10;
            }
            n = nextNum;
        }
        return true;
    }
}
