public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return new int[0];
        }
        int [] result = new int[nums.length-k+1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return -i1.compareTo(i2);
            }
        });
        int windowMin = 0;
        int windowMax = k-1;
        for(int i = windowMin; i <= windowMax; i++) {
            maxHeap.offer(nums[i]);
        }
        while(windowMax < nums.length-1) {
            result[windowMin] = maxHeap.peek();
            maxHeap.remove(nums[windowMin]);
            windowMin++;
            windowMax++;
            maxHeap.offer(nums[windowMax]);
        }
        result[windowMin] = maxHeap.peek(); 
        return result;
    }
}
