package oop.ex4.data_structures;

public class AvlTree extends BinaryTree{
   /** This class is the complete and tested implementation of an AVL-tree.**/


     /**
     * A default constructor.
     */
   public AvlTree(){
   }

    /**
     *A constructor that builds the tree by adding the elements in the input
     * array one-by-one If the same values appears twice (or more) in the list, it is ignored.
     * @param data values to add to tree
     */
    public AvlTree(int[] data){
    }


    /**
     *     A copy-constructor that builds the tree from existing tree
     * @param tree     tree - tree to be copied
     */
    public AvlTree(AvlTree tree){
    }


    /**
     *Add a new node with key newValue into the tree.
     * @param newValue new value to add to the tree.
     * @return false iff newValue already exist in the tree.
     */
    public boolean add(int newValue){
        return false;
    }

    /**
     *Does tree contain a given input value.
     * @param searchVal value to search for
     * @return if val is found in the tree, return the depth of its node (where 0 is the root).
     * Otherwise -- return -1.
     */
    public int contains(int searchVal){
        return -1;
    }

    /**
     *Remove a node from the tree, if it exists.
     * @param toDelete value to delete
     * @return true iff toDelete found and deleted
     */
    public boolean delete(int toDelete){
        return false;
    }

    /**
     * Tree size.
     * @return number of nodes in the tree
     */
    public int size(){
        return 0;
    }

    /**
     * @return an iterator for the Avl Tree. The returned iterator iterates over the tree nodes
     * ∗ in an ascending order, and does NOT implement the remove() method.
     */
    public java.util.Iterator<java.lang.Integer> iterator(){
        return null;
    }

    /**
     * A method that calculates the minimum numbers of nodes in an AVL tree of height h,
     * @param h height of the tree (a non-negative number).
     * @return minimum number of nodes of height h
     */
    public static int findMinNodes(int h){
        return 0;
    }


    /**
     * A method that calculates the maximum number of nodes in an AVL tree of height h,
     * @param h height of the tree (a non-negative number).
     * @return maximum number of nodes of height h
     */
    public static int findMaxNodes(int h){
        return 0;
    }


    /**
     * main method.
     * @param args received from user.
     */
    public static void main(java.lang.String[] args){

    }

}
