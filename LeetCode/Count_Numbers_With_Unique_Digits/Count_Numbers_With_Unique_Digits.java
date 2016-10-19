public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] arr = new int[n+1];
        arr[0] = 1; // x can be 0
 
        for(int i = 1; i <= n; i++){
            arr[i] = 9;
            for(int j = 9; j >= 9 - i + 2; j--){
                arr[i] *= j;
            }
        }
 
        int result =0;
        for(int i: arr) {
            result += i;
        }
 
        return result;
    }
}
