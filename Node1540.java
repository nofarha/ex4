package oop.ex4.data_structures;

public class Node {
    /* Node Data */
    private int data;
    private int balanceFactor;
    private int rightDepth;
    private int leftDepth;
    private int maxDepth;
    /* Node left daughter node, smaller int. */
    private Node leftDaughter;

    /* Node right daughter node, larger int */
    private Node rightDaughter;

    private Node parent;


    public Node(){
    }

    public Node(int dataValue){
        this.data = dataValue;
        balanceFactor = 0;
        rightDepth = 0;
        leftDepth = 0;
        maxDepth = 0;
    }

    int getData(){
        return data;
    }

    void setData(int value){
        data = value;
    }

    Node getRight(){
        return rightDaughter;
    }

    Node getLeft(){
        return leftDaughter;
    }

    Node getParent(){
        return parent;
    }
    int getRightDepth(){
        return rightDepth;
    }
    int getLeftDepth(){
        return leftDepth;
    }
    int getMaxDepth(){
        return maxDepth;
    }

    void setRight(Node newRight){
        rightDaughter = newRight;
    }

    void setLeft(Node newLeft){
        leftDaughter = newLeft;
    }

    void setParent(Node newPrent){
        parent = newPrent;
    }
    void setLeftDepth(int depth){
        leftDepth = depth;
    }

    void setRightDepth(int depth){
        rightDepth = depth;
    }
    void setMaxDepth(){
        maxDepth = Math.max(leftDepth,rightDepth);
    }


    boolean isLeaf(){
        return  (leftDaughter == null && rightDaughter == null);

    }
}
