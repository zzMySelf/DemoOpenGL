package com.itextpdf.awt.geom;

import fe.when.qw.qw.qw;
import java.io.Serializable;

public class Dimension extends qw implements Serializable {
    public static final long serialVersionUID = 4723952579491349524L;
    public double height;
    public double width;

    public Dimension(Dimension dimension) {
        this(dimension.width, dimension.height);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (dimension.width == this.width && dimension.height == this.height) {
            return true;
        }
        return false;
    }

    public double getHeight() {
        return this.height;
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        fe.when.qw.qw.uk.qw qwVar = new fe.when.qw.qw.uk.qw();
        qwVar.qw(this.width);
        qwVar.qw(this.height);
        return qwVar.hashCode();
    }

    public void setSize(int i2, int i3) {
        this.width = (double) i2;
        this.height = (double) i3;
    }

    public String toString() {
        return Dimension.class.getName() + "[width=" + this.width + ",height=" + this.height + "]";
    }

    public Dimension() {
        this(0, 0);
    }

    public Dimension(double d, double d2) {
        setSize(d, d2);
    }

    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    public void setSize(double d, double d2) {
        setSize((int) Math.ceil(d), (int) Math.ceil(d2));
    }

    public Dimension(int i2, int i3) {
        setSize(i2, i3);
    }
}
