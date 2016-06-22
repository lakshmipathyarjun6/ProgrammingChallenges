import java.io.*;
import java.util.*;

public class BasicBinaryTreeImpl {
    
    private BinaryTreeNode root;
    
    public BasicBinaryTreeImpl() {
        this.root = null;
    }
    
    public BinaryTreeNode getRoot() {
        return this.root;
    }
    
    public void setRootNode(Integer value) {
        this.root = new BinaryTreeNode(value);
    }
    
    private static int levelLeavesHelper(BinaryTreeNode parent, int level) {
        if(parent.getLeftChild() == null && parent.getRightChild() == null) { // leaf node reached
            return level;
        }
        else if(parent.getRightChild() == null) {
            return levelLeavesHelper(parent.getLeftChild(), level+1);
        }
        else if(parent.getLeftChild() == null) {
            return levelLeavesHelper(parent.getRightChild(), level+1);
        }
        else {
            int leftChildDepth = levelLeavesHelper(parent.getLeftChild(),level+1);
            int rightChildDepth = levelLeavesHelper(parent.getRightChild(),level+1);
            if(leftChildDepth == rightChildDepth) {
                return leftChildDepth;
            }
            else {
                return -1;
            }
        }
    }
    
    public static boolean levelLeaves(BasicBinaryTreeImpl tree) {
        if(tree.root == null) { // An empty tree technically does have all leaves at the same level
            return true;
        }
        int result = levelLeavesHelper(tree.root,0);
        if(result == -1) {
            return false;
        }
        return true;
    }

    public static void main(String [] args) {
    
        BasicBinaryTreeImpl treeOne = new BasicBinaryTreeImpl();
    
        treeOne.setRootNode(new Integer(12));
        treeOne.getRoot().setLeftChild(new Integer(5));
        treeOne.getRoot().getLeftChild().setLeftChild(new Integer(3));
        treeOne.getRoot().getLeftChild().setRightChild(new Integer(9));
        treeOne.getRoot().getLeftChild().getLeftChild().setLeftChild(new Integer(1));
        treeOne.getRoot().getLeftChild().getRightChild().setLeftChild(new Integer(2));
        if (levelLeaves(treeOne)) {
            System.out.println("Tree One leaves are at same level");
            
        } else {
            System.out.println("Tree One leaves are not at same level");
        }
        
        BasicBinaryTreeImpl treeTwo = new BasicBinaryTreeImpl();
        
        treeTwo.setRootNode(new Integer(12));
        treeTwo.getRoot().setLeftChild(new Integer(5));
        treeTwo.getRoot().getLeftChild().setLeftChild(new Integer(3));
        treeTwo.getRoot().setRightChild(new Integer(7));
        treeTwo.getRoot().getRightChild().setRightChild(new Integer(1));
        if (levelLeaves(treeTwo)) {
            System.out.println("Tree Two leaves are at same level");
            
        } else {
            System.out.println("Tree Two leaves are not at same level");
        }
        
        BasicBinaryTreeImpl treeThree = new BasicBinaryTreeImpl();
        
        treeThree.setRootNode(new Integer(12));
        treeThree.getRoot().setLeftChild(new Integer(5));
        treeThree.getRoot().getLeftChild().setLeftChild(new Integer(3));
        treeThree.getRoot().setRightChild(new Integer(7));
        if (levelLeaves(treeThree)) {
            System.out.println("Tree Three leaves are at same level");
            
        } else {
            System.out.println("Tree Three leaves are not at same level");
        }
    }

}

class BinaryTreeNode {
    
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;
    private Integer data;
    
    public BinaryTreeNode(Integer value) {
        this.leftChild = null;
        this.rightChild = null;
        this.data = value;
    }
    
    public BinaryTreeNode getLeftChild()
    {
        return this.leftChild;
    }
    
    public void setLeftChild(Integer childValue)
    {
        this.leftChild = new BinaryTreeNode(childValue);
    }
    
    public BinaryTreeNode getRightChild()
    {
        return this.rightChild;
    }
    
    public void setRightChild(Integer childValue)
    {
        this.rightChild = new BinaryTreeNode(childValue);
    }
    
    public Integer getData()
    {
        return this.data;
    }
    
}