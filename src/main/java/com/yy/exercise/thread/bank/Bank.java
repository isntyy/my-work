package com.yy.exercise.thread.bank;

/**
 * @author wyy
 * @desc
 * @since 2021-06-26 11:54
 */
public class Bank {

    public static void main(String[] args) {

        TicketThread thread1 = new TicketThread("1");
        thread1.start();

        TicketThread thread2 = new TicketThread("2");
        thread2.start();

        TicketThread thread3 = new TicketThread("3");
        thread3.start();
    }
}
