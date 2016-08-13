import java.util.Random;

public class Solution {
    
    private int [] original;
    private int [] shuffled;
    Random rand;

    public Solution(int[] nums) {
        shuffled = nums;
        original = Arrays.copyOfRange(nums,0,nums.length);
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> indices = new ArrayList<Integer>();
        for(int i = 0; i < original.length; i++) {
            indices.add(i);
        }
        int shuffledIndex = 0;
        while(indices.size() > 0) {
            int randomIndex = rand.nextInt(indices.size());
            shuffled[shuffledIndex] = original[indices.get(randomIndex)];
            indices.remove(randomIndex);
            shuffledIndex++;
        }
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
