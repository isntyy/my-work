package com.yy.exercise.event;

/**
 * @author wyy
 * @since 2020-07-07 22:52
 */
public interface WeatherMulticaster {

    void multicasterEvent(WeatherEvent event);

    void addListener(WeatherListener listener);

    void removeListener(WeatherListener listener);
}
