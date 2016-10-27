public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start == null || end == null || start.length() != end.length()) {
            return -1;
        }
        
        Set<String> geneBank = new HashSet<String>(Arrays.asList(bank));
        Set<Integer> discrepencyIndices = new HashSet<Integer>();
        
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) != end.charAt(i)) {
                discrepencyIndices.add(i);
            }
        }
        if(discrepencyIndices.size() == 0) {
            return 0;
        }
        
        return (canCompleteChain(geneBank, start, end, discrepencyIndices)) ? discrepencyIndices.size() : -1;
    }
    
    private boolean canCompleteChain(Set<String> geneBank, String current, String end, Set<Integer> discrepencyIndices) {
        if(current.equals(end)) {
            return true;
        }
        
        for(Integer index : discrepencyIndices) {
            String mutation = new String(current.substring(0,index) + end.charAt(index) + current.substring(index+1));
            boolean valid = false;
            if(geneBank.contains(mutation)) {
                Set<Integer> remainingDiscrepencyIndices = new HashSet<Integer>(discrepencyIndices);
                remainingDiscrepencyIndices.remove(index);
                valid = canCompleteChain(geneBank, mutation, end, remainingDiscrepencyIndices);
            }
            if(valid == true) {
                return true;
            }
        }
        
        return false;
    }
}
