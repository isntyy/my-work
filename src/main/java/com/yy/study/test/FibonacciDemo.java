package com.yy.study.test;

/**
 * @author wyy
 * @since 2021-04-08 20:29
 */
public class FibonacciDemo {

    public static void main(String[] args) {
        System.out.println(fib1(200));
    }

    public static int fib1(int num){
        if (num <= 1) return num;

        int first = 0;
        int second = 1;
        for (int i = 0; i < num -1; i++) {
             int sum = first + second;
             first = second;
             second = sum;
        }
        return second;
    }
}
