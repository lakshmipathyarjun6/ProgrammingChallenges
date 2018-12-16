oclass Solution {
    public String customSortString(String S, String T) {
        Map<Character,Integer> freqCount = new HashMap<Character,Integer>();
        
        for(int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            if(freqCount.containsKey(ch)) {
                Integer priorCount = freqCount.get(ch);
                freqCount.put(ch, priorCount+1);
            }
            else {
                freqCount.put(ch, 1);
            }
        }
        
        StringBuilder sortedString = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(freqCount.containsKey(ch)) {
                while(freqCount.get(ch) > 0) {
                    sortedString.append(ch);
                    Integer priorCount = freqCount.get(ch);
                    freqCount.put(ch, priorCount-1);
                }
                freqCount.remove(ch);
            }
        }
        
        for(Character ch : freqCount.keySet()) {
            while(freqCount.get(ch) > 0) {
                sortedString.append(ch);
                Integer priorCount = freqCount.get(ch);
                freqCount.put(ch, priorCount-1);
            }
        }
        
        return sortedString.toString();
    }
}
