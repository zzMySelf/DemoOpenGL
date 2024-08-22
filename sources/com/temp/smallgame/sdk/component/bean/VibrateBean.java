package com.temp.smallgame.sdk.component.bean;

public class VibrateBean {
    public static final String INTERVAL = "interval";
    public static final String PATTERN = "pattern";
    public static final String TYPE = "type";
    private int interval;
    private String pattern;
    private int type;

    public int getType() {
        return this.type;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setType(int type2) {
        this.type = type2;
    }

    public void setInterval(int interval2) {
        this.interval = interval2;
    }

    public void setPattern(String pattern2) {
        this.pattern = pattern2;
    }
}
