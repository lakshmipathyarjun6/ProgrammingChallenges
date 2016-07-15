public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> count = new HashMap<Integer,Integer>();
        for(int num : nums) {
            if(count.containsKey(num)) {
                count.put(num,count.get(num)-1);
                if(count.get(num) == 0) {
                    count.remove(num);
                }
            }
            else {
                count.put(num,2);
            }
        }
        Iterator it = count.keySet().iterator();
        return (int) it.next();
    }
}
