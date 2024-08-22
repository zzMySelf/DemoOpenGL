package com.baidu.mapapi.walknavi.model;

public class WalkRouteDetailInfo {
    public float altitude;
    public double avSpeed;
    public float diffAltitude;
    public double maxSpeed;
    public double speed;

    public double getAltitude() {
        return (double) this.altitude;
    }

    public double getAvSpeed() {
        return this.avSpeed;
    }

    public double getDiffAltitude() {
        return (double) this.diffAltitude;
    }

    public double getMaxSpeed() {
        return this.maxSpeed;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setAltitude(float f2) {
        this.altitude = f2;
    }

    public void setAvSpeed(double d2) {
        this.avSpeed = d2;
    }

    public void setDiffAltitude(float f2) {
        this.diffAltitude = f2;
    }

    public void setMaxSpeed(double d2) {
        this.maxSpeed = d2;
    }

    public void setSpeed(double d2) {
        this.speed = d2;
    }
}
