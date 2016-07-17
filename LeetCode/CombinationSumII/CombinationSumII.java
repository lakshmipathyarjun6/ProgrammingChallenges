public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null) {
            return null;
        }
        
        Arrays.sort(candidates);
        
        Set<List<Integer>> allCombs = new HashSet<List<Integer>>();
        List<Set<List<Integer>>> possible = new LinkedList<Set<List<Integer>>>();
        Map<List<Integer>,Integer> sums = new HashMap<List<Integer>,Integer>();
        
        List<Integer> first = new ArrayList<Integer>();
        first.add(candidates[0]);
        
        if(candidates[0] == target) {
            allCombs.add(first);
            possible.add(null);
        }
        else if(candidates[0] < target) {
            Set<List<Integer>> firstCand = new HashSet<List<Integer>>();
            firstCand.add(first);
            possible.add(firstCand);
            sums.put(first,candidates[0]);
        }
        else {
            possible.add(null);
        }
        
        for(int i = 1; i < candidates.length; i++) {
            Set<List<Integer>> cand = new HashSet<List<Integer>>();
            
            if(possible.get(i-1) != null) {
                Set<List<Integer>> cands = possible.get(i-1);
                for(List<Integer> candidate : cands) {
                    Integer currSum = sums.get(candidate);
                    Integer possibleSum = currSum + candidates[i];
                    if(possibleSum <= target) {
                        List<Integer> list = new ArrayList<Integer>(candidate);
                        list.add(candidates[i]);
                        if(possibleSum == target) {
                            allCombs.add(list);
                        }
                        else if(possibleSum < target) {
                            cand.add(list);
                            sums.put(list,possibleSum);
                        }
                    }
                }
                cand.addAll(cands);
            }
            
            List<Integer> current = new ArrayList<Integer>();
            current.add(candidates[i]);
            if(candidates[i] == target) {
                allCombs.add(current);
            }
            else if(candidates[i] < target) {
                cand.add(current);
                sums.put(current,candidates[i]);
            }
            
            if(cand.size() == 0) {
                possible.add(null);
            }
            else {
                possible.add(cand);
            }
        }
        
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        ret.addAll(allCombs);
        return ret;
    }
}
