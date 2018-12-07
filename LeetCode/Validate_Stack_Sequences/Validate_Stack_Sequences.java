import java.util.Stack;

class Solution {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int pushIndex = 0;
        int popIndex = 0;
        
        Stack<Integer> state = new Stack<Integer>();
        while(pushIndex < pushed.length && popIndex < popped.length) {
            while(!state.empty() && 
                  popIndex < popped.length && 
                  state.peek() == popped[popIndex]) {
                state.pop();
                popIndex++;
            }
            state.push(pushed[pushIndex]);
            pushIndex++;
        }
        
        while(!state.empty() && 
                 popIndex < popped.length && 
                  state.peek() == popped[popIndex]) {
                state.pop();
                popIndex++;
        }
        
        return pushIndex == pushed.length && popIndex == popped.length;
    }
}


