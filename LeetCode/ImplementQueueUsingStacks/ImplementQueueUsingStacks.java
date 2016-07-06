class MyQueue {
    
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    
    int frontVal = -1;
    
    
    // Push element x to the back of queue.
    public void push(int x) {
        if(s1.empty()) {
            frontVal = x;
        }
        s1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.pop();
        frontVal = (!s2.empty()) ? s2.peek() : -1;
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
    }

    // Get the front element.
    public int peek() {
        return frontVal;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty();
    }
}
