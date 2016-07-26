class Solution {
    public:
    int reverse(int x) {
        
        int ret = 0;
        int retPrev = 0;
        
        while(x != 0) {
            retPrev = ret;
            ret *= 10;
            if(retPrev != (ret / 10)) {
                return 0;
            }
            ret += (x % 10);
            x /= 10;
        }
        
        return ret;
    }
};