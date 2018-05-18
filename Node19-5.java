package oop.ex4.data_structures;

public class Node {
    /* Node Data */
    private int data;

    /* Node left daughter node, smaller int. */
    private Node leftDaughter;

    /* Node right daughter node, larger int */
    private Node rightDaughter;

    private Node parent;

    public Node(){
    }

    public Node(int dataValue){
        this.data = dataValue;
    }

    int getData(){
        return data;
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

    void setRight(Node newRight){
        rightDaughter = newRight;
    }

    void setLeft(Node newLeft){
        leftDaughter = newLeft;
    }

    void setParent(Node newPrent){
        parent = newPrent;
    }


    boolean isLeaf(){
        return  (leftDaughter == null && rightDaughter == null);

    }
}
