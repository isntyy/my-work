package com.yy.study.test.binaryTreee;

import java.util.Comparator;

/**
 * @author wyy
 * @desc
 * @since 2021-04-20 20:48
 */
public class Demo {


    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abcd";
        System.out.println(s1.compareTo(s2));


        Comparator<Person2> compator1 = new Comparator<Person2>() {
            @Override
            public int compare(Person2 e1, Person2 e2) {
                return e1.getAge() - e2.getAge() ;
            }
        };

        Comparator<Person2> compator2 = new Comparator<Person2>() {
            @Override
            public int compare(Person2 e1, Person2 e2) {
                return e2.getAge() - e1.getAge() ;
            }
        };

        //
        BinarySearchTree<Person2> tree = new BinarySearchTree<Person2>(compator1);
        tree.add(new Person2(12));
        tree.add(new Person2(20));

        BinarySearchTree<Person2> tree1 = new BinarySearchTree<Person2>(new Comparator<Person2>() {
            @Override
            public int compare(Person2 o1, Person2 o2) {
                return 0;
            }
        });
    }
}
