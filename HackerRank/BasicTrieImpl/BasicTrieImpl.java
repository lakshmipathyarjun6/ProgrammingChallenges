import java.io.*;
import java.util.*;

public class BasicTrieImpl {

    private TrieNode root;
    
    public BasicTrieImpl() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        
        TrieNode refNode = root;
        
        for(int i = 0; i < word.length(); i++) {
            
            Character letter = word.charAt(i);
            
            if(!refNode.hasCharacter(letter)) {
                refNode.addCharacter(letter);
            }
            
            refNode = refNode.getChild(letter);
            
        }
        
    }

    public boolean wordExists(String word) {
        
        TrieNode refNode = root;
        
        for(int i = 0; i < word.length(); i++) {
            
            Character letter = word.charAt(i);
            
            if(!refNode.hasCharacter(letter)) {
                return false;
            }
            
            refNode = refNode.getChild(letter);
            
        }
        
        return true;
        
    }
    
    public static void main(String [] args) {
        
        BasicTrieImpl trie = new BasicTrieImpl();
        
        trie.addWord("Hello");
        trie.addWord("Hell");
        trie.addWord("Bob");
        trie.addWord("Foo");
        trie.addWord("Foomen");
        
        System.out.println(trie.wordExists("Hello"));
        System.out.println(trie.wordExists("Hell"));
        System.out.println(trie.wordExists("Help"));
        
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
    
}