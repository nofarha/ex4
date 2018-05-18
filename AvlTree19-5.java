package oop.ex4.data_structures;

public class AvlTree extends BinaryTree {
    /**
     * This class is the complete and tested implementation of an AVL-tree.
     **/

    private AVLNode root;

    static int LEFT_LEFT_ROTATION = 0;
    static int LEFT_RIGHT_ROTATION = 1;
    static int RIGHT_LEFT_ROTATION = 2;
    static int RIGHT_RIGHT_ROTATION = 3;

    /**
     * A default constructor.
     */
    public AvlTree() {
        super();
        root = new AVLNode();
    }

    /**
     * A constructor that builds the tree by adding the elements in the input
     * array one-by-one If the same values appears twice (or more) in the list, it is ignored.
     *
     * @param data values to add to tree
     */
    public AvlTree(int[] data) {
        super();
        root = new AVLNode();
    }


    /**
     * A copy-constructor that builds the tree from existing tree
     *
     * @param tree tree - tree to be copied
     */
    public AvlTree(AvlTree tree) {
        super();
        root = new AVLNode();
    }


    /**
     * Add a new AVLNode with key newValue into the tree.
     *
     * @param newValue new value to add to the tree.
     * @return false iff newValue already exist in the tree.
     */
    public boolean add(int newValue) {
        if (this.contains(newValue) != -1) {
            return false;
        }
        AVLNode current = this.root;
        while (!current.isLeaf()) {
            if (newValue < current.getData()) {
                current = (AVLNode) current.getLeft();
            } else {
                current = (AVLNode) current.getRight();
            }
        }
        AVLNode newNode = new AVLNode(newValue);
        if (newValue < current.getData()) {
            current.setLeft(newNode);
            current.getLeft().setParent(current);
        } else {
            current.setRight(newNode);
            current.getRight().setParent(current);
        }
        size++;
        balanceTree(1, newNode);
        return true;
    }


    private boolean reBalanceFactor(AVLNode currentNode, int factor) {
        while (currentNode.getParent() != null) {
            AVLNode parent = (AVLNode) currentNode.getParent();
            if (parent.getLeft() == currentNode) {
                parent.left_depth = parent.left_depth + factor;
            }
            else {
                parent.right_depth = parent.right_depth + factor;
            }
            int BF = parent.right_depth - parent.left_depth;
            if (BF > 1 || BF < -1) {
                rotate(parent);
                return true;
            }
            if (parent.max_depth == Math.max(parent.left_depth, parent.right_depth)) {
                return true;
            }
            parent.max_depth = Math.max(parent.left_depth, parent.right_depth);
            currentNode = parent;
        }
        return true;
    }
        


    private void rotate(AVLNode unBalanced) {
        


    }

    /**
     *Does tree contain a given input value.
     * @param searchVal value to search for
     * @return if val is found in the tree, return the depth of its AVLNode (where 0 is the root).
     * Otherwise -- return -1.
     */
//    public int contains(int searchVal){
//        return super.contains(searchVal);
//    }

    /**
     *Remove a AVLNode from the tree, if it exists.
     * @param toDelete value to delete
     * @return true iff toDelete found and deleted
     */
    public boolean delete(int toDelete) {
        boolean value =  super.delete(toDelete);
        balanceTree(-1);
        return value;
    }


    /**
     * Tree size.
     * @return number of AVLNodes in the tree
     */
//    public int size(){
//        return 0;
//    }

    /**
     * @return an iterator for the Avl Tree. The returned iterator iterates over the tree AVLNodes
     * ∗ in an ascending order, and does NOT implement the remove() method.
     */
    public java.util.Iterator<java.lang.Integer> iterator(){
        return null;
    }

    /**
     * A method that calculates the minimum numbers of AVLNodes in an AVL tree of height h,
     * @param h height of the tree (a non-negative number).
     * @return minimum number of AVLNodes of height h
     */
    public static int findMinAVLNodes(int h){
        return 0;
    }


    /**
     * A method that calculates the maximum number of AVLNodes in an AVL tree of height h,
     * @param h height of the tree (a non-negative number).
     * @return maximum number of AVLNodes of height h
     */
    public static int findMaxAVLNodes(int h){
        return 0;
    }


//    private getUnBalancedAVLNode(){

//    }

//
    private void balanceTree(int factor, AVLNode changed){
       reBalanceFactor(changed, factor);
    }




    /**
     * main method.
     * @param args received from user.
     */
    public static void main(java.lang.String[] args){

    }




    private class AVLNode extends Node {

        int balanceFactor;
        int right_depth;
        int left_depth;
        int max_depth;

        public AVLNode(){
        }

        public AVLNode(int dataValue) {
            super(dataValue);
            balanceFactor = 0;
            right_depth = 0;
            left_depth = 0;
            max_depth = 0;
//          setBalanceFactor();
        }

//        private setBalanceFactor(){

        }


    }


}
