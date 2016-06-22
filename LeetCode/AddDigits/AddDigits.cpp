class Solution {
    public:
    int addDigits(int num) {
        int retVal = num;
        while((retVal / 10) > 0) {
            int sum = 0;
            int tempNum = retVal;
            while(tempNum > 0) {
                sum += tempNum % 10;
                tempNum /= 10;
            }
            retVal = sum;
        }
        return retVal;
    }
};