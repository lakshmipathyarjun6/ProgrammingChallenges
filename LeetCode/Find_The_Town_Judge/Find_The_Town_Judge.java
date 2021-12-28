class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 1 && trust.length == 0) {
            return 1;
        }
        
        int numTrusts = trust.length;
        
        Set<Integer> candidates = new HashSet<Integer>();
        Set<Integer> blacklist = new HashSet<Integer>();
        Map<Integer, Set<Integer>> trustMap = new HashMap<Integer, Set<Integer>>();
        
        for(int i = 0; i < numTrusts; i++) {
            int [] trustEntry = trust[i];
            
            int trustor = trustEntry[0];
            int trustee = trustEntry[1];
            
            if(candidates.contains(trustor)) {
                candidates.remove(trustor);
            }
            
            blacklist.add(trustor);
            
            if(!blacklist.contains(trustee)) {
                candidates.add(trustee);
            }
            
            if(!trustMap.containsKey(trustor)) {
                Set<Integer> trustSet = new HashSet<Integer>();
                trustSet.add(trustee);
                trustMap.put(trustor, trustSet);
            }
            else {
                Set<Integer> trustSet = trustMap.get(trustor);
                trustSet.add(trustee);
            }
        }
        
        if(candidates.size() != 1) {
            return -1;
        }
        
        Integer candidate = candidates.iterator().next();
        
        for (Map.Entry<Integer,Set<Integer>> entry : trustMap.entrySet()) {
            Set<Integer> trustSet = entry.getValue();
            
            if(!trustSet.contains(candidate)) {
                return -1;
            }
        }
        
        return candidates.iterator().next();
    }
}
