/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    public Stack<NestedInteger> stack = new Stack<NestedInteger>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            if(containsAtLeastOneElement(nestedList.get(i))) {
                stack.push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
       while (!stack.peek().isInteger()) {
            List<NestedInteger> tmp = stack.pop().getList();
            for (int i = tmp.size() - 1; i >= 0; i--) {
                stack.push(tmp.get(i));
            }
       }
       return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        if(!stack.empty() && !stack.peek().isInteger() && stack.peek().getList().size() == 0) {
            stack.pop();
        }
        return !stack.empty();
    }
    
    private boolean containsAtLeastOneElement(NestedInteger ni) {
        if(ni.isInteger()) {
            return true;
        }
        else if(ni.getList().size() == 0) {
            return false;
        }
        for(NestedInteger n : ni.getList()) {
            boolean res = containsAtLeastOneElement(n);
            if(res) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
