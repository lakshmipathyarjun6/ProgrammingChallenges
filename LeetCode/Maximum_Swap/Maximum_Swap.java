class Solution {
    public int compressToInt(char [] num) {
        int total = 0;
        for(int i = 0; i < num.length; i++) {
            total = 10*total + (num[i] - '0');
        }
        return total;
    }
    
    public int maximumSwap(int num) {
        char[] potNumOrig = ("" + num).toCharArray();
        for(int i = 0; i < potNumOrig.length; i++) {
            int maxValInIteration = 0;
            for(int j = i+1; j < potNumOrig.length; j++) {
                char [] tmpNum = new char[potNumOrig.length];
                System.arraycopy(potNumOrig, 0, tmpNum, 0, potNumOrig.length);
                char tmp = tmpNum[j];
                tmpNum[j] = tmpNum[i];
                tmpNum[i] = tmp;
                int newNum = compressToInt(tmpNum);
                maxValInIteration = Math.max(maxValInIteration, newNum);
            }
            if(maxValInIteration > num) {
                return maxValInIteration;
            }
        }
        
        return num;
    }
}
