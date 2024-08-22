package com.itextpdf.awt.geom;

import fe.when.qw.qw.fe;
import java.io.Serializable;

public class Point extends fe implements Serializable {
    public static final long serialVersionUID = -5276940640259749850L;
    public double x;
    public double y;

    public Point() {
        setLocation(0, 0);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        if (this.x == point.x && this.y == point.y) {
            return true;
        }
        return false;
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void move(int i2, int i3) {
        move((double) i2, (double) i3);
    }

    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    public String toString() {
        return Point.class.getName() + "[x=" + this.x + ",y=" + this.y + "]";
    }

    public void translate(int i2, int i3) {
        translate((double) i2, (double) i3);
    }

    public void move(double d, double d2) {
        setLocation(d, d2);
    }

    public void setLocation(int i2, int i3) {
        setLocation((double) i2, (double) i3);
    }

    public void translate(double d, double d2) {
        this.x += d;
        this.y += d2;
    }

    public Point(int i2, int i3) {
        setLocation(i2, i3);
    }

    public void setLocation(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public Point(double d, double d2) {
        setLocation(d, d2);
    }

    public Point(Point point) {
        setLocation(point.x, point.y);
    }
}
