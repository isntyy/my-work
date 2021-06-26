package com.yy.exercise.event;

/**
 * @author wyy
 * @since 2020-07-07 23:04
 */
public class TestWeatherEvent {

    public static void main(String[] args) {
        WeatherEventMulticaster multicaster = new WeatherEventMulticaster();
        SnowListener snowListener = new SnowListener();
        RainListener rainListener = new RainListener();
        multicaster.addListener(snowListener);
        multicaster.addListener(rainListener);
        multicaster.multicasterEvent(new SnowEvent());
        multicaster.multicasterEvent(new RainEvent());

    }
}
