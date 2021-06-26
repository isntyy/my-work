package com.yy.exercise.event;

/**
 * @author wyy
 * @since 2020-07-07 22:45
 */
public class SnowListener implements WeatherListener {
    @Override
    public void onWeatherListen(WeatherEvent event) {
        if (event instanceof SnowEvent){
            System.out.println("listening: "+ event.getWeather());
        }
    }
}
