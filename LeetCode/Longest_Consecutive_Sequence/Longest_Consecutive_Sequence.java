class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Map<Integer,Integer> foundNumsChain= new HashMap<Integer,Integer>();
        Map<Integer,Node> nodeMap = new HashMap<Integer,Node>();
       
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            nodeMap.put(num, new Node(num));
            
            foundNumsChain.put(num,null);
            if(foundNumsChain.containsKey(num+1) || foundNumsChain.containsKey(num-1)) {
                if(foundNumsChain.containsKey(num+1)) {
                    foundNumsChain.put(num,num+1);
                }
                if(foundNumsChain.containsKey(num-1)) {
                    foundNumsChain.put(num-1,num);
                }
            }
        }
        
        Set<Integer> startNodes = new HashSet<Integer>();
        Set<Integer> removedNodes = new HashSet<Integer>();
        for(Integer key : foundNumsChain.keySet()) {
            Integer nextInChain = foundNumsChain.get(key);
            if(nextInChain != null) {
                nodeMap.get(key).next = nodeMap.get(nextInChain);
                if(startNodes.contains(key+1)) {
                    startNodes.remove(key+1);
                    removedNodes.add(key+1);
                }   
                if(!startNodes.contains(key-1) && !removedNodes.contains(key-1)) {
                    startNodes.add(key);
                }
                else {
                    removedNodes.add(key);
                }
            }
        }
        
        if(startNodes.size() == 0) {
            return 1;
        }
        
        int maxSequence = 0;
        for(Integer start : startNodes) {
            int sequence = 0;
            Node current = nodeMap.get(start);
            while(current != null) {
                current = current.next;
                sequence++;
            }
            maxSequence = Math.max(maxSequence, sequence);
        }
        
        return maxSequence;
    }
}

class Node {
    public Integer value;
    public Node next;
    
    public Node(Integer v) {
        this.value = v;
        this.next = null;
    }

    public String toString() {
        return "{" + this.value + ", " + ((this.next != null) ? this.next.value : "null") + "}";
    }
}
