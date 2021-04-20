package com.yy.study.test.binaryTreee;

/**
 * @author wyy
 * @desc
 * @since 2021-04-20 20:50
 */
public class Person1 implements Comparable<Person1> {

    private int age;

    public Person1(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @param person1
     * @return
     */
    @Override
    public int compareTo(Person1 person1) {
        return age - person1.age;
    }
}
