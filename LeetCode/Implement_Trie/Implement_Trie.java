class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> children;
    boolean terminal;
    
    public TrieNode() {
        children = new HashMap<Character,TrieNode>();
        terminal = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        // assume root is not null
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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        // assume root is not null
        TrieNode current = root;
        int index = 0;
        while(index < word.length()) {
            Map<Character,TrieNode> currChildren = current.children;
            if(!currChildren.containsKey(word.charAt(index))) {
                return false;
            }
            current = currChildren.get(word.charAt(index));
            index++;
        }
        if(current.terminal) {
            return true;
        }
        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int index = 0;
        while(index < prefix.length()) {
            Map<Character,TrieNode> currChildren = current.children;
            if(!currChildren.containsKey(prefix.charAt(index))) {
                return false;
            }
            current = currChildren.get(prefix.charAt(index));
            index++;
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
