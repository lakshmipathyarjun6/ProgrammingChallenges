class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        List<String> aWords = Arrays.asList(A.split("\\s+"));
        List<String> bWords = Arrays.asList(B.split("\\s+"));
        
        Map<String, Integer> wordFrequency = new HashMap<String, Integer>();
        
        for(String word : aWords) {
            if(wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word)+1);
            }
            else {
                wordFrequency.put(word, 1);
            }
        }
        for(String word : bWords) {
            if(wordFrequency.containsKey(word)) {
                wordFrequency.put(word, wordFrequency.get(word)+1);
            }
            else {
                wordFrequency.put(word, 1);
            }
        }
        
        String [] uncommonWords = new String[wordFrequency.size()];
        int i = 0;
        for(String word : wordFrequency.keySet()) {
            if(wordFrequency.get(word) == 1) {
                uncommonWords[i] = word;
                i++;
            }
        }
        
        return Arrays.copyOfRange(uncommonWords, 0, i);
    }
}
