class Solution {
    
    Set<String> validCombinations;
    Set<String> discoveredCombinations;
    
    public int determineMinRemovalCount(String s) {
        Stack<Integer> openParenLocations = new Stack<Integer>();
        
        int minRemovalCount = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                openParenLocations.push(i);
            }
            else if(ch == ')') {
                if(openParenLocations.size() > 0) {
                    openParenLocations.pop();
                }
                else {
                    minRemovalCount++;
                }
            }
        }
        
        minRemovalCount += openParenLocations.size();
        
        return minRemovalCount;
    }
    
    public boolean validParentheses(String s) {
        Stack<Integer> openParenLocations = new Stack<Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                openParenLocations.push(i);
            }
            else if(ch == ')') {
                if(openParenLocations.size() > 0) {
                    openParenLocations.pop();
                }
                else {
                    return false;
                }
            }
        }
        
        return openParenLocations.size() == 0;
    }
    
    public void generateAllValidCombinations(String s, int maxDepth) {
        if(maxDepth < 0 || discoveredCombinations.contains(s)) {
            return;
        }
        else if(validParentheses(s)) {
            discoveredCombinations.add(s);
            validCombinations.add(s);
            return;
        }
        discoveredCombinations.add(s);
        for(int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            generateAllValidCombinations(sb.toString(), maxDepth-1);
        }
        
    }
    
    public List<String> removeInvalidParentheses(String s) {
        int minRemovalCount = determineMinRemovalCount(s);
        validCombinations = new HashSet<String>();
        discoveredCombinations = new HashSet<String>();
        
        generateAllValidCombinations(s, minRemovalCount);
        List<String> allCombinations = new LinkedList<String>();
        allCombinations.addAll(validCombinations);
        
        return allCombinations;
    }
}
