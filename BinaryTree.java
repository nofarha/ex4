package oop.ex4.data_structures;


public abstract class BinaryTree implements Iterable<Integer> {

    protected int size = 0;
    private Node root;


    public BinaryTree() {
    }

    /**
     * A constructor that builds the tree by adding the elements in the input
     * array one-by-one If the same values appears twice (or more) in the list, it is ignored.
     *
     * @param data values to add to tree
     */
    public BinaryTree(int[] data) {
    }


    /**
     * A copy-constructor that builds the tree from existing tree
     *
     * @param tree tree - tree to be copied
     */
    public BinaryTree(AvlTree tree) {
    }


    /**
     * Add a new node with key newValue into the tree.
     *
     * @param newValue new value to add to the tree.
     * @return false iff newValue already exist in the tree.
     */
    public boolean add(int newValue) {
        if (this.contains(newValue) != -1) {
            return false;
        }
        Node current = this.root;
        while (!current.isLeaf()) {
            if (newValue < current.data) {
                current = current.leftDaughter;
            } else {
                current = current.rightDoughter;
            }
        }
        if (newValue < current.data) {
            current.leftDaughter= new Node(newValue);
        } else {
            current.rightDoughter= new Node(newValue);
        }
        return true;
    }

    /**
     * Does tree contain a given input value.
     *
     * @param searchVal value to search for
     * @return if val is found in the tree, return the depth of its node (where 0 is the root).
     * Otherwise -- return -1.
     */
    public int contains(int searchVal) {
        if (size == 0){
            return -1;
        }
        int depth = 0;
        if (root.data == searchVal){return depth;}
        Node current = root;
        while (!current.isLeaf()){
            if (current.data > searchVal){
                current = current.leftDaughter;
            }
            else {
                current = current.rightDoughter;
            }
            depth ++;
            if (current.data == searchVal){
                return depth;
            }
        }
        return -1;
    }


    /**
     * Remove a node from the tree, if it exists.
     *
     * @param toDelete value to delete
     * @return true iff toDelete found and deleted
     */
    public boolean delete(int toDelete) {
//        if (size == 0){
//            return false;
//        }
//        if (root.data == toDelete){
//
//            return true;}
//        Node current = root;
//        while (!current.isLeaf()){
//            if (current.data > toDelete){
//                current = current.leftDaughter;
//            }
//            else {
//                current = current.rightDoughter;
//            }
//            if (current.data == toDelete){
//                return true;
//            }
//        }
        return false;
    }

    /**
     * Tree size.
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return 0;
    }

    /**
     * @return an iterator for the Avl Tree. The returned iterator iterates over the tree nodes
     * ∗ in an ascending order, and does NOT implement the remove() method.
     */
    public java.util.Iterator<java.lang.Integer> iterator() {
        return null;
    }

    /**
     * A method that calculates the minimum numbers of nodes in an AVL tree of height h,
     *
     * @param h height of the tree (a non-negative number).
     * @return minimum number of nodes of height h
     */
    public static int findMinNodes(int h) {
        return 0;
    }


    /**
     * A method that calculates the maximum number of nodes in an AVL tree of height h,
     *
     * @param h height of the tree (a non-negative number).
     * @return maximum number of nodes of height h
     */
    public static int findMaxNodes(int h) {
        return 0;
    }
    private class Node{
        /* Node Data */
        private int data;

        /* Node left daughter node, smaller int. */
        private Node leftDaughter;

        /* Node right daughter node, larger int */
        private Node rightDoughter;


        private Node parent;

        public Node(int dataValue){
            this.data = dataValue;
        }
        private boolean isLeaf(){
            return  (root.leftDaughter == null && root.rightDoughter == null);

        }
    }
}
