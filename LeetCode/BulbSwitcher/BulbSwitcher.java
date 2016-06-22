public class Solution {
    public int bulbSwitch(int n) {
        if(n == 0) {
            return 0;
        }
        int perfectSquareCount = 0;
        int squareVal = 1;
        while(squareVal*squareVal <= n) {
            perfectSquareCount++;
            squareVal++;
        }
        return perfectSquareCount;
    }
}