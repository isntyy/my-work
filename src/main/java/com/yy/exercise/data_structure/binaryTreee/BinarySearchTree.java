package com.yy.exercise.data_structure.binaryTreee;

import com.yy.exercise.data_structure.binaryTreee.printer.BinaryTreeInfo;

import java.util.Comparator;

/**
 * @author wyy
 * @desc
 * @since 2021-04-19 21:50
 */

// public class BinarySearchTree<E extends Comparable>
public class BinarySearchTree<E> implements BinaryTreeInfo {

    private int size;
    private Node<E> root;
    private Comparator<E> compator;
    public BinarySearchTree(Comparator<E> compator) {
        this.compator = compator;
    }
    public BinarySearchTree() {
        this(null);
    }

    public void add(E element) {

        if (root == null) {
            // 根节点为空，则传入元素为root节点
            root = new Node<>(element, null);
            size++;
            return;
        }
        // 根节点
        Node<E> currentNode = root;
        // 待添加节点元素的父节点
        Node<E> currentParent = root;
        int compare = 0;
        while (currentNode != null) {
            compare = compare(element, currentNode.element);
            currentParent = currentNode;
            if (compare > 0) {
                currentNode = currentNode.right;
            } else if (compare < 0) {
                currentNode = currentNode.left;
            } else {
                return;
            }
        }

        // 记录下带添加元素要插入的的位置方向
        Node<E> newNode = new Node<>(element, currentParent);
        if (compare > 0) {
            currentParent.right = newNode;
        } else if (compare < 0) {
            currentParent.left = newNode;
        }
        size++;
    }

    public void preorderTraversal1(){
        preorderTraversal(root);
    }
    /**
     * 前序遍历
     * @param node
     */
    private void preorderTraversal(Node<E> node){
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public int compare(E e1, E e2) {
        if (compator != null){
            return compator.compare(e1,e2);
        }
        return ((Comparable<E>)e1).compareTo(e2);
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }


    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>)node).element;
    }
}
