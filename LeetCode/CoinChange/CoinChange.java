public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) {
            return 0;
        }
        int [] arr = new int[amount+1];
        arr[0] = 0; // do not need any coin to get 0 amount
        
        for(int i=1; i <= amount; i++) {
            arr[i] = -1;
        }
        
        int minCoin = Integer.MAX_VALUE;
        
        for(int coin: coins){ 
            if(coin <= amount) {
                arr[coin] = 1;
            }
            if(coin < minCoin) {
                minCoin = coin;
            }
        }
        
        if(arr[amount] == 1) {
            return 1;
        }
        
        if(minCoin < amount) {
            for(int k = 0; k < minCoin; k++) {
                arr[k] = -1;
            }
        }
        
        for(int i = minCoin; i <= amount; i++) {
            if(arr[i] == 1) {
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(int coin : coins) {
                int remaining = i - coin;
                if(remaining >= 0 && arr[remaining] != -1) {
                    if(arr[remaining] + 1 < min) {
                        min = arr[remaining] + 1;
                    }
                }
            }
            if(min != Integer.MAX_VALUE) {
                arr[i] = min;
            }
        }
 
        return arr[amount];
        
    }
}
