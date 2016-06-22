// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    
    Iterator<Integer> current;
    Integer prevVal;
    Integer actualVal;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        prevVal = null;
        current = iterator;
        actualVal = current.next();
    }
    
    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return actualVal;
    }
    
    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        prevVal = actualVal;
        actualVal = (current.hasNext()) ? current.next() : null;
        return prevVal;
    }
    
    @Override
    public boolean hasNext() {
        return actualVal != null;
    }
}