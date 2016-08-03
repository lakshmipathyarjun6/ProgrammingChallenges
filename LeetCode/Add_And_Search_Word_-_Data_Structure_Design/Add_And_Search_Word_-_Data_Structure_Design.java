public class WordDictionary {
    
    Trie reference = new Trie();
    Map<String,Boolean> previousResults = new HashMap<String,Boolean>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        reference.insert(word);
        previousResults = new HashMap<String,Boolean>(); // invalidate all previous results
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(previousResults.containsKey(word)) {
            return previousResults.get(word);
        }
        boolean result = reference.search(word);
        previousResults.put(word,result);
        return result;
    }
}

class TrieNode {
    Map<Character,TrieNode> children;
    boolean terminal;
    
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        terminal = false;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        int index = 0;
        while(index < word.length()) {
            Map<Character,TrieNode> currChildren = current.children;
            if(!currChildren.containsKey(word.charAt(index))) {
                TrieNode newNode = new TrieNode();
                currChildren.put(word.charAt(index), newNode);
            }
            current = currChildren.get(word.charAt(index));
            index++;
        }
        current.terminal = true;
    }
    
    public boolean search(String word) {
        return searchUtil(root,word);
    }
    
    private boolean searchUtil(TrieNode current, String word) {
        if(word.equals("")) {
            if(current.terminal) {
                return true;
            }
            return false;
        }
        else if(word.charAt(0) == '.'){
            for(Character ch : current.children.keySet()) {
                boolean result = searchUtil(current.children.get(ch), word.substring(1));
                if(result) {
                    return true;
                }
            }
            return false; 
        }
        else {
            if(!current.children.containsKey(word.charAt(0))) {
                return false;
            }
            return searchUtil(current.children.get(word.charAt(0)), word.substring(1));
        }
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
