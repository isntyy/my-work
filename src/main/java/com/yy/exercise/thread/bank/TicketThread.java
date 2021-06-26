package com.yy.exercise.thread.bank;

/**
 * @author wyy
 * @desc
 * @since 2021-06-26 11:49
 */
public class TicketThread extends Thread{

    public static final int MAX = 50;
    public static int START = 1;

    private String name;


    public TicketThread(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while (START <= MAX){
            System.out.println("柜台: "+name+" 出票第"+ START++ +"张");
        }
    }
}
