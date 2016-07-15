class MyStack {
    
    LinkedList<Integer> q1 = new LinkedList<Integer>();
    LinkedList<Integer> q2 = new LinkedList<Integer>();
    
    int top;
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // Removes the element on top of the stack.
    public void pop() {
        while(q1.size() > 1) {
            q2.add(q1.remove());
        }
        q1.remove();
        while(q2.size() > 0) {
            Integer x = q2.remove();
            q1.add(x);
            top = x;
        }
    }

    // Get the top element.
    public int top() {
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.size() == 0;
    }
}
