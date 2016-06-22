public class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie prefixes = new Trie();
        for(int i = 0; i < strs.length; i++) {
            prefixes.addWord(strs[i]);
        }
        return prefixes.getLongestPrefix();
    }
}

class Trie {
    
    private TrieNode root;
    private Integer maxDepth;
    
    public Trie() {
        this.root = new TrieNode();
        maxDepth = Integer.MAX_VALUE;
    }
    
    public void addWord(String word) {
        TrieNode refNode = root;
        if(word.length() < maxDepth) {
            maxDepth = word.length();
        }
        for(int i = 0; i < word.length(); i++) {
            Character letter = word.charAt(i);
            if(!refNode.hasCharacter(letter)) {
                refNode.addCharacter(letter);
            }
            refNode = refNode.getChild(letter);
        }
    }
    
    public String getLongestPrefix() {
        StringBuffer buff = new StringBuffer();
        
        TrieNode refNode = root;
        Set<Character> allChildren = refNode.getAllChildren();
        int depth = 0;
        
        while(allChildren.size() == 1 && depth < maxDepth) {
            Iterator iter = allChildren.iterator();
            Character child = (Character) iter.next();
            buff.append(child);
            depth++;
            refNode = refNode.getChild(child);
            allChildren = refNode.getAllChildren();
        }
        
        return buff.toString();
    }
    
}

class TrieNode {
    
    private HashMap<Character,TrieNode> children;
    
    public TrieNode() {
        this.children = new HashMap<Character,TrieNode>();
    }
    
    public boolean hasCharacter(Character value) {
        return this.children.containsKey(value);
    }
    
    public void addCharacter(Character value) {
        this.children.put(value, new TrieNode());
    }
    
    public TrieNode getChild(Character value) {
        return this.children.get(value);
    }
    
    public Set<Character> getAllChildren() {
        return this.children.keySet();
    }
    
}