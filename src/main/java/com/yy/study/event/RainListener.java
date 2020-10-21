package com.yy.study.event;

/**
 * @author wyy
 * @since 2020-07-07 22:45
 */
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherListen(WeatherEvent event) {
        if (event instanceof RainEvent){
            System.out.println("listening: "+ event.getWeather());
        }
    }
}
