import java.io.*;
import java.util.*;

public class BasicLinkedListImpl {
    
    private static Node head;
    private static Node tail;
    private static int size;
    
    public BasicLinkedListImpl() {
        
        this.head = null;
        this.tail = null;
        this.size = 0;
        
    }
    
    public void addToFront(Integer value) {
        
        Node container = new Node(value);
        
        if(size == 0) {
            addFirstElement(container);
        }
        else {
            container.setNext(head);
            head = container;
        }
        size++;
        
    }
    
    public Integer getFirst() {
        return head.getData();
    }
    
    public Integer getLast() {
        return tail.getData();
    }
    
    public void addToEnd(Integer value) {
        
        Node container = new Node(value);
        
        if(size == 0) {
            addFirstElement(container);
        }
        else {
            tail.setNext(container);
            tail = container;
        }
        size++;
        
    }
    
    private void addFirstElement(Node firstNode) {
        
        head = tail = firstNode;
        
    }
    
    public boolean hasLoop() {
        
        if(head == null) // list does not exist..so no loop either.
            return false;
        
        Node slow, fast; // create two references.
        
        slow = fast = head; // make both refer to the start of the list.
        
        while(true) {
            
            slow = slow.getNext();          // 1 hop.
            
            if(fast.getNext() != null)
                fast = fast.getNext().getNext(); // 2 hops.
            else
                return false;          // next node null => no loop.
            
            if(slow == null || fast == null) // if either hits null..no loop.
                return false;
            
            if(slow == fast) // if the two ever meet...we must have a loop.
                return true;
        }
    }
    
    private Node nthElement(int n) {
        
        Node target = null;
        
        if(head != null) {
            
            target = head;
            
            while(n > 1) {
                target = target.getNext();
                n--;
            }
        }
        
        return target;
    }
    
    private Node nthFromLastElement(int n) {
        Node main_ptr = head;
        Node ref_ptr = head;
        
        Node target = null;
        
        int count = 0;
        if (head != null)
        {
            while (count < n)
            {
                if (ref_ptr == null)
                {
                    System.out.println(n+" is greater than the no "+" of nodes in the list");
                    return null;
                }
                ref_ptr = ref_ptr.getNext();
                count++;
            }
            while (ref_ptr != null)
            {
                main_ptr = main_ptr.getNext();
                ref_ptr = ref_ptr.getNext();
            }
            //System.out.println("Node no. "+n+" from last is "+main_ptr.getData());
            target = main_ptr;
        }
        return target;
    }
    
    public void swapNthFrontEndElements(int index) {
        
        if(index == ((size % index) + 1)) {
            return;
        }
        
        if(index > size / 2) {
            index = (size % index) + 1;
        }
        
        Node nthNode = nthElement(index);
        Node nthFromLastNode = nthFromLastElement(index);
        
        if(index == 1) {
            
            Node nthNodeNext = nthNode.getNext();
            Node nthFromLastNodePrev = nthFromLastElement(index+1);
            
            nthFromLastNodePrev.setNext(nthNode);
            nthFromLastNode.setNext(nthNodeNext);
            
            nthNode.setNext(null);
            head = tail;
            tail = nthNode;
            
        }
        
        else if(nthNode.getNext() == nthFromLastNode) {
            
            Node nthNodePrev = nthElement(index-1);
            Node nthFromLastNodeNext = nthFromLastNode.getNext();
            
            nthNodePrev.setNext(nthFromLastNode);
            nthNode.setNext(nthFromLastNodeNext);
            nthFromLastNode.setNext(nthNode);
            
        }
        
        else {
            
            Node nthNodeNext = nthNode.getNext();
            Node nthFromLastNodePrev = nthFromLastElement(index+1);
            Node nthNodePrev = nthElement(index-1);
            Node nthFromLastNodeNext = nthFromLastNode.getNext();
            
            nthNodePrev.setNext(nthFromLastNode);
            nthFromLastNodePrev.setNext(nthNode);
            nthNode.setNext(nthFromLastNodeNext);
            nthFromLastNode.setNext(nthNodeNext);
            
        }
        
    }
    
    public String toString() {
        
        Node currentNode = head;
        String returnString = "";
        
        if(currentNode != null) {
            
            if(hasLoop()) {
                System.out.print("WARNING: Loop detected in Linked List");
            }
            
            else {
                returnString = returnString.concat(currentNode.getData().toString());
                while(currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                    returnString = returnString.concat(" -> " + currentNode.getData().toString());
                }
            }
        }
        
        return returnString;
    }

    public static void main(String [] args) {
        
        BasicLinkedListImpl linkedlist = new BasicLinkedListImpl();
        
        linkedlist.addToFront(new Integer(3));
        linkedlist.addToFront(new Integer(4));
        linkedlist.addToFront(new Integer(5));
        
        linkedlist.addToEnd(new Integer(7));
        linkedlist.addToEnd(new Integer(9));
        linkedlist.addToEnd(new Integer(10));
        linkedlist.addToEnd(new Integer(11));
    
        System.out.println(linkedlist.toString());
        
        linkedlist.swapNthFrontEndElements(3);
        System.out.println(linkedlist.toString());
        
        linkedlist.tail.setNext(head.getNext());
        
        System.out.println(linkedlist.toString());
    }

}

class Node {

    private Integer data;
    private Node next;
    
    public Node() {
        this.data = null;
        this.next = null;
    }
    
    public Node(Integer dat)
    {
        this.data = dat;
        this.next = null;
    }
    
    public void setData(Integer theData) {
        this.data = theData;
    }
    
    public Integer getData() {
        return this.data;
    }
    
    public void setNext(Node nextNode) {
        this.next = nextNode;
    }
    
    public Node getNext() {
        return this.next;
    }

}






