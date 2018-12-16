oclass Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqCount = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(freqCount.containsKey(ch)) {
                Integer priorCount = freqCount.get(ch);
                freqCount.put(ch, priorCount+1);
            }
            else {
                freqCount.put(ch, 1);
            }
        }
        
        List<Pair> sortedFreqs = new LinkedList<Pair>();
        for(Character c : freqCount.keySet()) {
            sortedFreqs.add(new Pair(c, freqCount.get(c)));
        }
        
        Collections.sort(sortedFreqs, new MaxFrequencyComparator());
        
        StringBuilder sb = new StringBuilder();
        for(Pair p : sortedFreqs) {
            for(int i = 0; i < p.frequency; i++) {
                sb.append(p.ch);
            }
        }
        
        return sb.toString();
    }
}

class Pair {
    Character ch;
    Integer frequency;
    
    public Pair(Character c, Integer f) {
        this.ch = c;
        this.frequency = f;
    }
    
    @Override
    public String toString() {
        return this.ch + ": " + this.frequency;
    }
}

class MaxFrequencyComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair a, Pair b) {
        return -a.frequency.compareTo(b.frequency);
    }
}
