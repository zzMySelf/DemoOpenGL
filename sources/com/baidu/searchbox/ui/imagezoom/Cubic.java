package com.baidu.searchbox.ui.imagezoom;

public class Cubic implements Easing {
    public double easeOut(double time, double start, double end, double duration) {
        double d2 = (time / duration) - 1.0d;
        double time2 = d2;
        return (((d2 * time2 * time2) + 1.0d) * end) + start;
    }

    public double easeIn(double time, double start, double end, double duration) {
        double d2 = time / duration;
        double time2 = d2;
        return (d2 * end * time2 * time2) + start;
    }

    public double easeInOut(double time, double start, double end, double duration) {
        double d2 = time / (duration / 2.0d);
        double time2 = d2;
        if (d2 < 1.0d) {
            return ((end / 2.0d) * time2 * time2 * time2) + start;
        }
        double d3 = time2 - 2.0d;
        double time3 = d3;
        return ((end / 2.0d) * ((d3 * time3 * time3) + 2.0d)) + start;
    }
}
