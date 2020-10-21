package com.yy.study.event;

/**
 * @author wyy
 * @since 2020-07-07 22:42
 */
public class RainEvent extends WeatherEvent {

    @Override
    String getWeather() {
        return "woo,rainning~";
    }
}
