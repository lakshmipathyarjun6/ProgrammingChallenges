class Solution {
    public boolean rotateString(String A, String B) {
        String doubleString = A + A;
        return B.length() == A.length() && doubleString.indexOf(B) != -1;
    }
}
