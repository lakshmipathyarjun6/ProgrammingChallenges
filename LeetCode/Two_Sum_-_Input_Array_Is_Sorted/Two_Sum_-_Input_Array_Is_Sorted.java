public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
        int [] result = new int[2];
        
        for(int i = 0; i < numbers.length; i++) {
            int toFind = target - numbers[i];
            if(indexMap.containsKey(toFind)) {
                result[0] = indexMap.get(toFind) + 1;
                result[1] = i + 1;
                break;
            }
            else {
                if(!indexMap.containsKey(numbers[i])) {
                    indexMap.put(numbers[i],i);
                }
            }
        }
        
        return result;
    }
}
