public class LRUCache {
    int cap;
    HashMap<Integer,Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;
    
    public LRUCache(int capacity) {
        cap = capacity;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
    
    public void remove(Node n){
        if(n.previous != null) {
            n.previous.next = n.next;
        }
        else {
            head = n.next;
        }
 
        if(n.next != null) {
            n.next.previous = n.previous;
        }
        else{
            end = n.previous;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.previous = null;
 
        if(head != null) {
            head.previous = n;
        }
 
        head = n;
 
        if(end == null) {
            end = head;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }
        else {
            Node created = new Node(key, value);
            if(map.size() >= cap) {
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }
            else {
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
}

class Node {
    int key;
    int value;
    Node previous;
    Node next;
 
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
