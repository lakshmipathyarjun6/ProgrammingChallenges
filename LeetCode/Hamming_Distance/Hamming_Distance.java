class Solution {
    public int hammingDistance(int x, int y) {
        int xorResult = x ^ y;
        return Integer.bitCount(xorResult);
    }
}
