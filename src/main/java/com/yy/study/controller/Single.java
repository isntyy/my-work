package com.yy.study.controller;

/**
 * @author wyy
 * @since 2020-08-17 10:19
 */
public class Single {
    
    private static Single single = null;
    public Single(){};

    public static Single getSingle() {
        if (single == null){
            return new Single();
        }
        return single;
    }

    public static void main(String[] args) {
       /* int[] arr ={2,4,3,7,5};
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int tep = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tep;
                }
            }
        }
        System.out.println(111);*/

        double n1 = 1;
        double n2 = 20.2;
        double n3 = 300.03;
        int i = (int) ((n1 + n2 + n3) * 100);
        System.out.println(i);


    }
    
}
