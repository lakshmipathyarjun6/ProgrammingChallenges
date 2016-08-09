import java.util.Random;

public class RandomizedSet {

    private Map<Integer,Integer> valToIndex;
    private Map<Integer,Integer> indexToVal;
    private List<Integer> indices;
    private int nextAvailableIndex;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        valToIndex = new HashMap<Integer,Integer>();
        indexToVal = new HashMap<Integer,Integer>();
        indices = new LinkedList<Integer>();
        nextAvailableIndex = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val,nextAvailableIndex);
        indexToVal.put(nextAvailableIndex,val);
        indices.add(nextAvailableIndex);
        nextAvailableIndex++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valToIndex.containsKey(val)) {
            return false;
        }
        Integer index = valToIndex.get(val);
        valToIndex.remove(val);
        indexToVal.remove(index);
        indices.remove(index);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rn = new Random();
        int ind = rn.nextInt(indices.size());
        Integer index = indices.get(ind);
        return indexToVal.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
