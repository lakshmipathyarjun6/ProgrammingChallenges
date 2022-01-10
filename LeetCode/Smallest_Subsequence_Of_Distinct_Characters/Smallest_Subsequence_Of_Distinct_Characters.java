class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> lastIndex = new HashMap<Character, Integer>();
        Set<Character> observed = new HashSet<Character>();
        
        Stack<Character> str = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            
            if(!str.isEmpty()) {
                Character lastChar = str.peek();
                if(lastChar >= c && !observed.contains(c)) {
                    while(!str.isEmpty() && lastChar >= c && i < lastIndex.get(lastChar)) {
                        str.pop();
                        observed.remove(lastChar);
                        
                        if(!str.isEmpty()) {
                            lastChar = str.peek();
                        }
                    }
                    
                    if(!observed.contains(c)) {
                        str.push(c);
                        observed.add(c);
                    }
                }
            }
            
            if(!observed.contains(c)) {
                str.push(c);
                observed.add(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!str.isEmpty()) {
            result.append(str.pop());
        }
        
        return result.reverse().toString();
    }
}