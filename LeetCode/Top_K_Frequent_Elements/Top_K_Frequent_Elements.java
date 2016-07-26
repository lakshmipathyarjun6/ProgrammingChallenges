public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freqTable = new HashMap<Integer,Integer>();
        
        for(int num: nums){
            if(freqTable.containsKey(num)){
                freqTable.put(num, freqTable.get(num)+1);
            }else{
                freqTable.put(num, 1);
            }
        }
        
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count-b.count;
            }
        });
        
        for(Map.Entry<Integer, Integer> entry: freqTable.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            if(queue.size()>k){
                queue.poll();
            }
        }
        
        List<Integer> retList = new LinkedList<Integer>();
        
        while(queue.size()>0){
            retList.add(queue.poll().num);
        }

        Collections.reverse(retList);
        
        return retList;
    }
}

class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}
