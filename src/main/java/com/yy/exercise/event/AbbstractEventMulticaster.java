package com.yy.exercise.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wyy
 * @since 2020-07-07 22:57
 */
public abstract class AbbstractEventMulticaster implements WeatherMulticaster {
    private List<WeatherListener> listeners = new ArrayList<>();

    @Override
    public void multicasterEvent(WeatherEvent event) {
        doStart();
        listeners.forEach(i->i.onWeatherListen(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(WeatherListener listener) {
        listeners.remove(listener);
    }

    abstract void doStart();

    abstract void doEnd();
}