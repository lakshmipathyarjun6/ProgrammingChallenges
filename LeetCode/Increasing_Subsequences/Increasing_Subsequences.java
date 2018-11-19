class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> finalSet = new HashSet<List<Integer>>();
        List<List<Integer>> buildList = new LinkedList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++) {
            int currentValue = nums[i];
            if(i == 0) {
                List<Integer> firstItemList = new LinkedList<Integer>();
                firstItemList.add(currentValue);
                buildList.add(firstItemList);
            }
            else {
                LinkedList<List<Integer>> tempStorage = new LinkedList<List<Integer>>();
                for(List<Integer> candidateList : buildList) {
                    if(currentValue >= candidateList.get(candidateList.size()-1)) {
                        List<Integer> nextCandidateList = new LinkedList<Integer>(candidateList);
                        nextCandidateList.add(currentValue);
                        tempStorage.add(nextCandidateList);
                    }
                }
                List<Integer> currentItemList = new LinkedList<Integer>();
                currentItemList.add(currentValue);
                tempStorage.add(currentItemList);
                buildList.addAll(tempStorage);
            }
        }
        
        for(List<Integer> sequence : buildList) {
            if(sequence.size() > 1) {
                finalSet.add(sequence);
            }
        }
        
        List<List<Integer>> finalList = new LinkedList<List<Integer>>();
        finalList.addAll(finalSet);
        return finalList;
    }
}
