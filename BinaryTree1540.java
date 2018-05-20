package oop.ex4.data_structures;


import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class BinaryTree implements Iterable<Integer> {

    int size = 0;
    Node root;
    Node lastAddedNode;
    Node lastDeletedNode;

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
        System.out.println("super part of adding, value "+ newValue);
        if (this.contains(newValue) != -1) {
//            System.out.println("containing value");
            return false;
        }
        if (size() == 0){
//            System.out.println("size is 0");
            root = new Node(newValue);
            size++;
            lastAddedNode = root;
            return true;
        }
        Node current = this.root;
        while (!current.isLeaf()) {
            if (newValue < current.getData()) {
                if (current.getLeft() == null) {
                    break;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null){
                    break;
                }
                current = current.getRight();
            }
        }
        Node newNode = new Node(newValue);
        if (newValue < current.getData()) {
            current.setLeft(newNode);
            newNode.setParent(current);
        } else {
            current.setRight(newNode);
            newNode.setParent(current);
        }
        size++;
        lastAddedNode = newNode;
        System.out.println("added succesfully, finisehd super part");
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
        if (size() == 0) {
            return -1;
        }
        int depth = 0;
        if (root.getData() == searchVal) {
            return depth;
        }
        Node current = root;
        while (!current.isLeaf()) {
            if (current.getData() == searchVal) {
                return depth;
            }
            if (current.getData() > searchVal) {
                current = current.getLeft();
                if (current == null){
                    return -1;
                }
            }
            else {
                current = current.getRight();
                if (current == null){
                    return -1;
                }
            }
            depth++;

            }
        return -1;
    }

    private void removeLeaf(Node currentNode, boolean isRight) {
        if (isRight) {
            currentNode.getParent().setRight(null);
        } else {
            currentNode.getParent().setLeft(null);
        }
    }

    private void removeOnlyChild(Node currentNode, boolean isRight) {
        if (currentNode.getLeft() == null) {
            if (isRight) {
                currentNode.getParent().setRight(currentNode.getRight());
                currentNode.getRight().setParent(currentNode.getParent());
            } else {
                currentNode.getParent().setLeft(currentNode.getRight());
                currentNode.getRight().setParent(currentNode.getParent());
            }
        } else {
            if (isRight) {
                currentNode.getParent().setRight(currentNode.getLeft());
                currentNode.getLeft().setParent(currentNode.getParent());
            } else {
                currentNode.getParent().setLeft(currentNode.getLeft());
                currentNode.getLeft().setParent(currentNode.getParent());
            }
        }
    }

    private void removeTwoChild(Node currentNode, boolean isRight) {
        Node nextNode = successor(currentNode);
        if (nextNode == null) {
            return;
        }
        if (isRight) {
            if (nextNode.getRight() != null) {
                nextNode.getRight().setParent(nextNode.getParent());
                nextNode.getParent().setLeft(nextNode.getRight());
            }
            currentNode.getParent().setRight(nextNode);
            nextNode.setParent(currentNode.getParent());
            nextNode.getParent().setLeft(null);
            nextNode.setRight(currentNode.getRight());
            nextNode.setLeft(currentNode.getLeft());
            nextNode.getRight().setParent(nextNode);
            nextNode.getLeft().setParent(nextNode);
        }
        currentNode.getParent().setLeft(nextNode);
    }


    private void removeNode(Node currentNode) {
        boolean isRight;
        isRight = currentNode.getData() > currentNode.getParent().getData();
        if (currentNode.isLeaf()) {
            removeLeaf(currentNode, isRight);
        }
        if (currentNode.getLeft() == null || currentNode.getRight() == null) {
            removeOnlyChild(currentNode, isRight);
        } else {
            removeTwoChild(currentNode, isRight);
        }
    }


    /**
     * Remove a node from the tree, if it exists.
     *
     * @param toDelete value to delete
     * @return true iff toDelete found and deleted
     */
    public boolean delete(int toDelete) {
        Node currentNode = root;
        while (!currentNode.isLeaf()) {
            if (currentNode.getData() > toDelete) {
                currentNode = currentNode.getLeft();
            }
            if (currentNode.getData() < toDelete) {
                currentNode = currentNode.getRight();
            }
            if (currentNode.getData() == toDelete) {
                removeNode(currentNode);
                size--;
            }
            lastDeletedNode = currentNode;
            return true;
        }
        return false;
    }

    /**
     * Tree size.
     *
     * @return number of nodes in the tree
     */
    public int size() {
        return size;
    }


    private Node getSmallest() {
        Node current = root;
        while (!current.isLeaf()) {
            if (current.getLeft() == null) {
                return current;
            }
            current = current.getLeft();
        }
        return current;
    }


    /**
     * @return an iterator for the Avl Tree. The returned iterator iterates over the tree nodes
     * ∗ in an ascending order, and does NOT implement the remove() method.
     */
    public java.util.Iterator<java.lang.Integer> iterator() {
        if (root == null){
            return Collections.<Integer>emptySet().iterator();
        }
        return new Iterator<Integer>() {
            private Node smallest = getSmallest();
            private Node currentNode;
            @Override
            public boolean hasNext() {
                if (currentNode == null){
                    return (size() != 0);
                }
                return successor(currentNode) != null;
            }
            @Override
            public Integer next() {
                if (currentNode == null) {
                    currentNode = smallest;
                    return smallest.getData();
                }
                if (successor(currentNode) == null) {
                    throw new NoSuchElementException();
                }
                currentNode = successor(currentNode);
                assert currentNode != null;
                return currentNode.getData();
            }
        };
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


    private Node successor(Node currentNode) {
        if (currentNode == root && currentNode.getRight() == null) {
             return null;
        }
        else if (currentNode == root || currentNode.getRight() != null) {
            Node nextNode = currentNode.getRight();
            while (!nextNode.isLeaf()) {
                if (nextNode.getLeft() == null) {
                    break;
              }
              nextNode = nextNode.getLeft();
             }
            return nextNode;
        }
        if (currentNode.getData() < currentNode.getParent().getData()) {
            return currentNode.getParent();
        }
        else if (currentNode.getData() > currentNode.getParent().getData()){
            Node nextNode = currentNode;
            while (nextNode.getParent() != null && nextNode.getParent().getData() < currentNode.getData()) {
                if (nextNode.getParent().getParent() == null) {
                    return null;
                }
                nextNode = nextNode.getParent();
            }
            return nextNode;
        }
        return null;
    }



   
    }

