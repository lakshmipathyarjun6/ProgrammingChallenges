public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(new Node(beginWord,1));
        
        while(queue.size() != 0) {
            Node top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)) {
                return top.depth;
            }
            
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i] != c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordList.contains(newWord)){
                        queue.add(new Node(newWord, top.depth+1));
                        wordList.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
        
        return 0;
    }
    
}

class Node {
    String word;
    int depth;
    
    public Node(String str, int dep) {
        word = str;
        depth = dep;
    }
}
