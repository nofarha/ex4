package oop.ex4.data_structures;

public class Node {
    /* Node Data */
    private int data;
    private int balanceFactor;
    private int right_depth;
    private int left_depth;
    private int max_depth;
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
        right_depth = 0;
        left_depth = 0;
        max_depth = 0;
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
        return right_depth;
    }
    int getLeftDepth(){
        return left_depth;
    }
    int getMaxDepth(){
        return max_depth;
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
        left_depth = depth;
    }

    void setRightDepth(int depth){
        right_depth = depth;
    }
    void setMaxDepth(int depth){
        max_depth = depth;
    }


    boolean isLeaf(){
        return  (leftDaughter == null && rightDaughter == null);

    }
}
