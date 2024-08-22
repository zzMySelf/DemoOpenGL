package com.itextpdf.awt.geom;

import fe.when.ad.aaa;
import fe.when.qw.qw.rg;
import java.io.Serializable;

public class Rectangle extends rg implements Shape, Serializable {
    public static final long serialVersionUID = -4345857070255674764L;
    public double height;
    public double width;
    public double x;
    public double y;

    public Rectangle() {
        setBounds(0, 0, 0, 0);
    }

    public void add(int i2, int i3) {
        add((double) i2, (double) i3);
    }

    public boolean contains(int i2, int i3) {
        return contains((double) i2, (double) i3);
    }

    public rg createIntersection(rg rgVar) {
        if (rgVar instanceof Rectangle) {
            return intersection((Rectangle) rgVar);
        }
        rg.qw qwVar = new rg.qw();
        rg.intersect(this, rgVar, qwVar);
        return qwVar;
    }

    public rg createUnion(rg rgVar) {
        if (rgVar instanceof Rectangle) {
            return union((Rectangle) rgVar);
        }
        rg.qw qwVar = new rg.qw();
        rg.union(this, rgVar, qwVar);
        return qwVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        if (rectangle.x == this.x && rectangle.y == this.y && rectangle.width == this.width && rectangle.height == this.height) {
            return true;
        }
        return false;
    }

    public Rectangle getBounds() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }

    public rg getBounds2D() {
        return getBounds();
    }

    public double getHeight() {
        return this.height;
    }

    public Point getLocation() {
        return new Point(this.x, this.y);
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public double getWidth() {
        return this.width;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void grow(int i2, int i3) {
        translate((double) i2, (double) i3);
    }

    public Rectangle intersection(Rectangle rectangle) {
        double max = Math.max(this.x, rectangle.x);
        double max2 = Math.max(this.y, rectangle.y);
        return new Rectangle(max, max2, Math.min(this.x + this.width, rectangle.x + rectangle.width) - max, Math.min(this.y + this.height, rectangle.y + rectangle.height) - max2);
    }

    public boolean intersects(Rectangle rectangle) {
        return !intersection(rectangle).isEmpty();
    }

    public boolean isEmpty() {
        return this.width <= 0.0d || this.height <= 0.0d;
    }

    public int outcode(double d, double d2) {
        int i2;
        double d3 = this.width;
        if (d3 <= 0.0d) {
            i2 = 5;
        } else {
            double d4 = this.x;
            i2 = d < d4 ? 1 : d > d4 + d3 ? 4 : 0;
        }
        double d5 = this.height;
        if (d5 <= 0.0d) {
            return i2 | 10;
        }
        double d6 = this.y;
        if (d2 < d6) {
            return i2 | 2;
        }
        return d2 > d6 + d5 ? i2 | 8 : i2;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        setBounds((double) i2, (double) i3, (double) i4, (double) i5);
    }

    public void setLocation(int i2, int i3) {
        setLocation((double) i2, (double) i3);
    }

    public void setRect(double d, double d2, double d3, double d4) {
        int floor = (int) Math.floor(d);
        int floor2 = (int) Math.floor(d2);
        setBounds(floor, floor2, ((int) Math.ceil(d + d3)) - floor, ((int) Math.ceil(d2 + d4)) - floor2);
    }

    public void setSize(int i2, int i3) {
        setSize((double) i2, (double) i3);
    }

    public String toString() {
        return Rectangle.class.getName() + "[x=" + this.x + ",y=" + this.y + ",width=" + this.width + ",height=" + this.height + "]";
    }

    public void translate(int i2, int i3) {
        translate((double) i2, (double) i3);
    }

    public Rectangle union(Rectangle rectangle) {
        Rectangle rectangle2 = new Rectangle(this);
        rectangle2.add(rectangle);
        return rectangle2;
    }

    public void add(double d, double d2) {
        double min = Math.min(this.x, d);
        double max = Math.max(this.x + this.width, d);
        double min2 = Math.min(this.y, d2);
        setBounds(min, min2, max - min, Math.max(this.y + this.height, d2) - min2);
    }

    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double d3 = this.x;
        if (d < d3) {
            return false;
        }
        double d4 = this.y;
        if (d2 < d4) {
            return false;
        }
        double d5 = d2 - d4;
        if (d - d3 >= this.width || d5 >= this.height) {
            return false;
        }
        return true;
    }

    public void grow(double d, double d2) {
        this.x -= d;
        this.y -= d2;
        this.width += d + d;
        this.height += d2 + d2;
    }

    public void setBounds(double d, double d2, double d3, double d4) {
        this.x = d;
        this.y = d2;
        this.height = d4;
        this.width = d3;
    }

    public void setLocation(double d, double d2) {
        this.x = d;
        this.y = d2;
    }

    public void setSize(double d, double d2) {
        this.width = d;
        this.height = d2;
    }

    public void translate(double d, double d2) {
        this.x += d;
        this.y += d2;
    }

    public Rectangle(Point point) {
        setBounds(point.x, point.y, 0.0d, 0.0d);
    }

    public void setLocation(Point point) {
        setLocation(point.x, point.y);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public Rectangle(Point point, Dimension dimension) {
        setBounds(point.x, point.y, dimension.width, dimension.height);
    }

    public boolean contains(Point point) {
        return contains(point.x, point.y);
    }

    public boolean contains(int i2, int i3, int i4, int i5) {
        return contains(i2, i3) && contains((i2 + i4) - 1, (i3 + i5) - 1);
    }

    public void setBounds(Rectangle rectangle) {
        setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(double d, double d2, double d3, double d4) {
        setBounds(d, d2, d3, d4);
    }

    public void add(Point point) {
        add(point.x, point.y);
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        return contains(d, d2) && contains((d + d3) - 0.01d, (d2 + d4) - 0.01d);
    }

    public void add(Rectangle rectangle) {
        double min = Math.min(this.x, rectangle.x);
        double max = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        double min2 = Math.min(this.y, rectangle.y);
        setBounds(min, min2, max - min, Math.max(this.y + this.height, rectangle.y + rectangle.height) - min2);
    }

    public boolean contains(Rectangle rectangle) {
        return contains(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(int i2, int i3) {
        setBounds(0, 0, i2, i3);
    }

    public Rectangle(Rectangle rectangle) {
        setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle(aaa aaa) {
        aaa.c();
        setBounds((double) aaa.vvv(), (double) aaa.when(), (double) aaa.rrr(), (double) aaa.ggg());
    }

    public Rectangle(Dimension dimension) {
        setBounds(0.0d, 0.0d, dimension.width, dimension.height);
    }
}
