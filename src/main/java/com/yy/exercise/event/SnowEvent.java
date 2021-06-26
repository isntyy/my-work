package com.yy.exercise.event;

/**
 * @author wyy
 * @since 2020-07-07 22:42
 */
public class SnowEvent extends WeatherEvent {

    @Override
    String getWeather() {
        return "woo,snowing~";
    }
}
