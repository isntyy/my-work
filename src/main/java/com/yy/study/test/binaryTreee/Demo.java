package com.yy.study.test.binaryTreee;

import com.yy.study.test.binaryTreee.printer.BinaryTrees;

import java.util.Comparator;

/**
 * @author wyy
 * @desc
 * @since 2021-04-20 20:48
 */
public class Demo {


    public static void main(String[] args) {
        /*Comparator<Person2> compator1 = new Comparator<Person2>() {
            @Override
            public int compare(Person2 e1, Person2 e2) {
                return e1.getAge() - e2.getAge() ;
            }
        };*/

        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.add(33);
        tree.add(55);
        tree.add(66);
        tree.add(14);
        tree.add(51);
        BinaryTrees.print(tree);
        System.out.println("\n");
        tree.preorderTraversal1();
    }
}
