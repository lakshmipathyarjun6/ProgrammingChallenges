public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0) {
            return true;
        }
        else if(z > x + y) {
            return false;
        }
        boolean divX = (x != 0) ? z % x == 0 : false;
        boolean divY = (y != 0) ? z % y == 0 : false;
        return divX || divY || gcd(x,y) == 1;
    }
    
    private int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return a+b;
        } 
        return gcd(b,a%b);
    }
}
