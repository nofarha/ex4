package oop.ex4.data_structures;

public class AvlTree extends BinaryTree {
    /**
     * This class is the complete and tested implementation of an AVL-tree.
     **/

    private Node root;

    static int LEFT_LEFT_ROTATION = 0;
    static int LEFT_RIGHT_ROTATION = 1;
    static int RIGHT_LEFT_ROTATION = 2;
    static int RIGHT_RIGHT_ROTATION = 3;

    /**
     * A default constructor.
     */
    public AvlTree() {
        super();
        root = new Node();
    }

    /**
     * A constructor that builds the tree by adding the elements in the input
     * array one-by-one If the same values appears twice (or more) in the list, it is ignored.
     *
     * @param data values to add to tree
     */
    public AvlTree(int[] data) {
        super();
        root = new Node();
        for (int value: data){
            add(value);
        }
    }


    /**
     * A copy-constructor that builds the tree from existing tree
     *
     * @param tree tree - tree to be copied
     */
    public AvlTree(AvlTree tree) {
        super();
        root = new Node();
        for (int data: tree){
            add(data);
        }
    }


    /**
     * Add a new AVLNode with key newValue into the tree.
     *
     * @param newValue new value to add to the tree.
     * @return false iff newValue already exist in the tree.
     */
    public boolean add(int newValue) {
//        System.out.println(" trying to add:" + newValue);
        if (super.add(newValue)) {
              Node lastAdded = lastAddedNode;
//              System.out.println("created AVL node: " + lastAdded.getClass());
              if(lastAdded.getParent() != null){
                System.out.println("node parent: " + lastAdded.getParent().getData());}
            if (size() > 0) {
//                System.out.println("size not 1, rebalancing");
                reBalanceTree(lastAdded, 1);
            }
//            System.out.println("size is :"+ size());
            return true;
        }
        return false;
    }


    private void reBalanceTree(Node currentNode, int factor) {
        while (currentNode.getParent() != null) {
            System.out.println("current node factoring parent: "+ currentNode.getParent().getData());
            System.out.println(currentNode.getParent().getClass());
            Node parent = currentNode.getParent();
            if (parent.getLeft() == currentNode) {
                parent.setLeftDepth(parent.getLeftDepth() + factor);
                System.out.println();
            }
            else {
                parent.setRightDepth(parent.getRightDepth() + factor);
            }
            System.out.println("left depth of :"+ currentNode.getParent().getData() +"  "+parent.getLeftDepth());
            System.out.println("right depth of :"+ currentNode.getParent().getData()+"  " +parent.getRightDepth());
            int BF = parent.getRightDepth() - parent.getLeftDepth();
            if (BF > 1 || BF < -1) {
                System.out.println("ro1");
                rotate(parent);
            }
            if (parent.getMaxDepth() == Math.max(parent.getLeftDepth(), parent.getRightDepth())) {
                return;
            }
            parent.setMaxDepth();
            currentNode = parent;
        }

    }


    private void rotateLeft(Node unbalanced){
        Node daughter =  unbalanced.getLeft();
        if (daughter.getRightDepth() - daughter.getLeftDepth() == 1){
            daughter.getRight().setParent(unbalanced);
            unbalanced.setLeft(daughter.getRight());
            daughter.setRight(daughter.getRight().getLeft());
            daughter.getRight().setParent(daughter);
            daughter.setParent(unbalanced.getLeft());
            unbalanced.getLeft().setLeft(daughter);
            // updating depth after rotations
            daughter.setRightDepth(unbalanced.getLeft().getLeftDepth());
            daughter.setMaxDepth();
            unbalanced.getLeft().setLeftDepth(daughter.getMaxDepth() + 1);
            unbalanced.getLeft().setMaxDepth();
            System.out.println("is correct should be true: "+ (unbalanced.getLeftDepth() == unbalanced.getLeft().getMaxDepth() + 1));
        }
        Node middle = unbalanced.getLeft();
        middle.setParent(unbalanced.getParent());
        unbalanced.setParent(middle);
        unbalanced.setLeft(middle.getRight());
        if (unbalanced.getLeft() != null){unbalanced.getLeft().setParent(unbalanced);}
        middle.setRight(unbalanced);
        // updating depth after rotations
        unbalanced.setLeftDepth(middle.getRightDepth());
        unbalanced.setMaxDepth();
        middle.setRightDepth(middle.getRight().getMaxDepth() + 1);
        middle.setMaxDepth();
    }

    private void rotateRight(Node unbalanced){
        Node daughter =  unbalanced.getRight();
        if(daughter.getRightDepth() - daughter.getLeftDepth() == -1){
            daughter.getLeft().setParent(unbalanced);
            unbalanced.setRight(daughter.getLeft());
            daughter.setLeft(daughter.getRight().getRight());
            daughter.getLeft().setParent(daughter);
            unbalanced.getRight().setRight(daughter);
            daughter.setParent(unbalanced.getRight());
            // updating depth after rotating
            daughter.setLeftDepth(unbalanced.getRight().getRightDepth());
            daughter.setMaxDepth();
            unbalanced.getRight().setRightDepth(daughter.getMaxDepth() + 1);
            unbalanced.getRight().setMaxDepth();

        }
        Node middle = unbalanced.getRight();
        middle.setParent(unbalanced.getParent());
        unbalanced.setParent(middle);
        unbalanced.setRight(middle.getLeft());
        if (unbalanced.getLeft() != null){unbalanced.getLeft().setParent(unbalanced);}
        middle.setLeft(unbalanced);
        // updating dapth after rotating
        if (middle.getRight().getData() == 10) {
            System.out.println("updating depth of 10, left depth is: " + middle.getRight().getLeftDepth());
        }
        unbalanced.setRightDepth(middle.getLeftDepth());
        unbalanced.setMaxDepth();
        middle.setLeftDepth(unbalanced.getMaxDepth() + 1);
        middle.setMaxDepth();
    }


    private void rotate(Node unBalanced) {
        if (unBalanced.getRightDepth() - unBalanced.getLeftDepth() == -2){
            rotateLeft(unBalanced);
        }
        else if (unBalanced.getRightDepth() - unBalanced.getLeftDepth() == 2){
            rotateRight(unBalanced);
        }
    }

    /**
     *Does tree contain a given input value.
     * @param searchVal value to search for
     * @return if val is found in the tree, return the depth of its AVLNode (where 0 is the root).
     * Otherwise -- return -1.
     */


    /**
     *Remove a AVLNode from the tree, if it exists.
     * @param toDelete value to delete
     * @return true iff toDelete found and deleted
     */
    public boolean delete(int toDelete) {
        if (super.delete(toDelete)) {
            reBalanceTree( lastDeletedNode, -1);
            return true;
        }
        return false;
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


        /**
         * A method that calculates the minimum numbers of AVLNodes in an AVL tree of height h,
         * @param h height of the tree (a non-negative number).
         * @return minimum number of AVLNodes of height h
         */
        public static int findMinAVLNodes ( int h){
            return 0;
        }


        /**
         * A method that calculates the maximum number of AVLNodes in an AVL tree of height h,
         * @param h height of the tree (a non-negative number).
         * @return maximum number of AVLNodes of height h
         */
        public static int findMaxAVLNodes ( int h){
            return 0;
        }


        /**
         * main method.
         * @param args received from user.
         */
        public static void main (java.lang.String[]args){
            int [] inti = new int[9];

            // test 1: bu
            inti[0] = 10;
            inti[1] = 5;
            inti[2] = 3;
            inti[3] = 7;
            inti[4] = 6;
            inti[5] = 15;
            inti[6] = 13;
            inti[7] = 17;
            inti[8] = 18;
            AvlTree tree =  new AvlTree();
            for (int value : inti){
                tree.add(value);
            }


        }




//    private class AVLNode extends Node {
//
//        int balanceFactor;
//        int right_depth;
//        int left_depth;
//        int max_depth;
//
//        public AVLNode() {
//            super();
//
//        }
//
//        public AVLNode(int dataValue) {
//            super(dataValue);
//            balanceFactor = 0;
//            right_depth = 0;
//            left_depth = 0;
//            max_depth = 0;
////          setBalanceFactor();
//        }
//
////        private setBalanceFactor(){
//
//
//        public AVLNode(Node node){
//            setData(node.getData());
//            setParent(node.getParent());
//            setLeft(node.getLeft());
//            setRight(node.getRight());
//        }
//
//    }
    }



