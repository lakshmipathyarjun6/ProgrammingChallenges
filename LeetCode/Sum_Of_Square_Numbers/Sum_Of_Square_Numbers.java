class Solution {
    public boolean judgeSquareSum(int c) {
        int ub = (int) Math.sqrt((double) c);
        for(int i = 0; i <= ub; i++) {
            int diff = c - i*i;
            double remRoot = Math.sqrt((double) diff);
            if ((remRoot == Math.floor(remRoot)) && !Double.isInfinite(remRoot)) {
                return true;
            }
        }
        return false;
    }
}
