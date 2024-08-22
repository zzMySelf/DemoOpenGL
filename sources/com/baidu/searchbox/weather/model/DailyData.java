package com.baidu.searchbox.weather.model;

import com.baidu.searchbox.weather.util.DateUtil;
import java.util.Date;
import java.util.TimeZone;

public class DailyData {
    AirQuality airQuality;
    Date date;
    String dayIconKey;
    String dayIconUri;
    float humidity = Float.MIN_VALUE;
    String listIconKey;
    String listIconUri;
    String nightIconKey;
    String nightIconUri;
    String precipitationProbability;
    String precipitationProbabilityDay;
    String precipitationProbabilityNight;
    String restrictDriving;
    Date sunriseTime;
    Date sunsetTime;
    float temperatureDay = Float.MIN_VALUE;
    float temperatureNight = Float.MIN_VALUE;
    TimeZone timeZone;
    String ultraviolet;
    String weatherDay;
    String weatherNight;
    String windDirectionDay;
    String windDirectionNight;
    String windPowerDay;
    String windPowerNight;

    public String getWeatherDay() {
        return this.weatherDay;
    }

    public AirQuality getAirQuality() {
        return this.airQuality;
    }

    public String getWeatherNight() {
        return this.weatherNight;
    }

    public String getWindDirectionDay() {
        return this.windDirectionDay;
    }

    public String getWindDirectionNight() {
        return this.windDirectionNight;
    }

    public float getTemperatureDay() {
        return this.temperatureDay;
    }

    public float getTemperatureNight() {
        return this.temperatureNight;
    }

    public String getWindPowerDay() {
        return this.windPowerDay;
    }

    public String getWindPowerNight() {
        return this.windPowerNight;
    }

    public Date getDate() {
        return this.date;
    }

    public Date getSunsetTime() {
        return this.sunsetTime;
    }

    public Date getSunriseTime() {
        return this.sunriseTime;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public String getUltraviolet() {
        return this.ultraviolet;
    }

    public TimeZone getTimeZone() {
        TimeZone timeZone2 = this.timeZone;
        return timeZone2 == null ? DateUtil.defaultTimeZone() : timeZone2;
    }

    public String getDayIconUri() {
        return this.dayIconUri;
    }

    public String getNightIconUri() {
        return this.nightIconUri;
    }

    public String getListIconUri() {
        return this.listIconUri;
    }

    public String getPrecipitationProbability() {
        return this.precipitationProbability;
    }

    public String getPrecipitationProbabilityDay() {
        return this.precipitationProbabilityDay;
    }

    public String getPrecipitationProbabilityNight() {
        return this.precipitationProbabilityNight;
    }

    public String getRestrictDriving() {
        return this.restrictDriving;
    }
}
