class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer,Integer> difficultyPayout = new HashMap<Integer,Integer>();
        int maxDifficulty = 0;
        for(int i = 0; i < difficulty.length; i++) {
            if(difficultyPayout.containsKey(difficulty[i])) {
                difficultyPayout.put(difficulty[i], Math.max(difficultyPayout.get(difficulty[i]),profit[i]));
            }
            else {
                difficultyPayout.put(difficulty[i], profit[i]);
            }
            maxDifficulty = Math.max(maxDifficulty, difficulty[i]);
        }
        
        int [] maxPossiblePayoutPerDifficultyLevel = new int[maxDifficulty+1];
        for(int i = 0; i < maxPossiblePayoutPerDifficultyLevel.length; i++) {
            if(difficultyPayout.containsKey(i)) {
                maxPossiblePayoutPerDifficultyLevel[i] = (i == 0) ? 
                    difficultyPayout.get(i) : Math.max(maxPossiblePayoutPerDifficultyLevel[i-1], difficultyPayout.get(i));
            }
            else {
                maxPossiblePayoutPerDifficultyLevel[i] = (i == 0) ? 0 : maxPossiblePayoutPerDifficultyLevel[i-1];
            }
        }
        
        int maxProfit = 0;
        for(int i = 0; i < worker.length; i++) {
            maxProfit += 
                (worker[i] >= maxPossiblePayoutPerDifficultyLevel.length) ? 
                maxPossiblePayoutPerDifficultyLevel[maxPossiblePayoutPerDifficultyLevel.length-1] :                            maxPossiblePayoutPerDifficultyLevel[worker[i]];
        }
        
        return maxProfit;
    }
}
