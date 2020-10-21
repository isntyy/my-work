package com.yy.study.event;

/**
 * @author wyy
 * @since 2020-07-07 23:03
 */
public class WeatherEventMulticaster extends AbbstractEventMulticaster {
    @Override
    void doStart() {
        System.out.println("BEGIN multicaster event weather");
    }

    @Override
    void doEnd() {
        System.out.println("END multicaster event weather");
    }
}
