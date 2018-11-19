/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class PQElement {
    public Node node;
    public int level;
    
    public PQElement() {}

    public PQElement(Node n,int _level) {
        node = n;
        level = _level;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null)
            return new LinkedList<List<Integer>>();
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentLevelList = new ArrayList<Integer>();
        
        int currentLevel = 0;
        Queue<PQElement> pq = new LinkedList<PQElement>();
        PQElement firstElem = new PQElement(root, 0);
        pq.add(firstElem);
        
        while(pq.peek() != null) {
            PQElement elem = pq.remove();
            if(elem.level == currentLevel) {
                currentLevelList.add(elem.node.val);
            }
            else {
                result.add(currentLevelList);
                currentLevelList = new ArrayList<Integer>();
                currentLevelList.add(elem.node.val);
                currentLevel++;
            }
            
            for (Node n : elem.node.children) {
                PQElement next_elem = new PQElement(n, elem.level+1);
                pq.add(next_elem);
            }
        }
        result.add(currentLevelList);
         
        return result;
    }
}
