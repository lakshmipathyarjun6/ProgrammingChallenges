import java.util.*;

public class Solution {
    
    private static List<List<Integer>> createPerms(List<Integer> original) {
        if(original.size() == 2) {
            List<List<Integer>> retVal = new LinkedList<List<Integer>>();
            
            List<Integer> originalCopy = new LinkedList<Integer>(original);
            List<Integer> swapped = new LinkedList<Integer>();
            swapped.add(originalCopy.get(1));
            swapped.add(originalCopy.get(0));
            
            retVal.add(originalCopy);
            retVal.add(swapped);
            
            return retVal;
        }
        else {
            List<List<Integer>> subListPerms = new LinkedList<List<Integer>>();
            for(int i = 0; i < original.size(); i++) {
                List<Integer> sublist = original.subList(1,original.size());
                List<List<Integer>> subMuts = createPerms(sublist);
                for(List<Integer> list : subMuts) {
                    list.add(0,original.get(0));
                }
                subListPerms.addAll(subMuts);
                Collections.rotate(original,1);
            }
            return subListPerms;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = new LinkedList<Integer>();
        List<List<Integer>> allPerms = new LinkedList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        
        if(numList.size() == 1) {
            allPerms.add(numList);
            return allPerms;
        }
        
        return createPerms(numList);
    }
}