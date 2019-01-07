class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqList = new HashMap<String, Integer>();
        for(String s : words) {
            if(freqList.containsKey(s)) {
                freqList.put(s, freqList.get(s)+1);
            }
            else {
                freqList.put(s, 1);
            }
        }
        
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(new PairComparator());
        for(String s : freqList.keySet()) {
            heap.offer(new Pair(s, freqList.get(s)));
        }
        
        List<String> kWords = new LinkedList<String>();
        for(int i = 0; i < k; i++) {
            kWords.add(heap.poll().word);
        }
        
        return kWords;
    }
}

class Pair {
    public String word;
    public Integer frequency;
    
    public Pair(String s, Integer f) {
        this.word = s;
        this.frequency = f;
    }
    
    public String toString() {
        return "{" + this.word + ": " + this.frequency + "}";
    }
}

class PairComparator implements Comparator<Pair> 
{ 
    public int compare(Pair a, Pair b) 
    { 
        if(a.frequency == b.frequency) {
            return a.word.compareTo(b.word);
        }
        return -a.frequency.compareTo(b.frequency);
    } 
}
