package fe.when.qw.qw;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.PathIterator;
import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.awt.geom.Shape;
import fe.when.qw.qw.rg;

public abstract class th implements Shape, Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public boolean contains(fe feVar) {
        return contains(feVar.getX(), feVar.getY());
    }

    public Rectangle getBounds() {
        int floor = (int) Math.floor(getMinX());
        int floor2 = (int) Math.floor(getMinY());
        return new Rectangle((double) floor, (double) floor2, (double) (((int) Math.ceil(getMaxX())) - floor), (double) (((int) Math.ceil(getMaxY())) - floor2));
    }

    public double getCenterX() {
        return getX() + (getWidth() / 2.0d);
    }

    public double getCenterY() {
        return getY() + (getHeight() / 2.0d);
    }

    public rg getFrame() {
        return new rg.qw(getX(), getY(), getWidth(), getHeight());
    }

    public abstract double getHeight();

    public double getMaxX() {
        return getX() + getWidth();
    }

    public double getMaxY() {
        return getY() + getHeight();
    }

    public double getMinX() {
        return getX();
    }

    public double getMinY() {
        return getY();
    }

    public abstract PathIterator getPathIterator(AffineTransform affineTransform, double d);

    public abstract double getWidth();

    public abstract double getX();

    public abstract double getY();

    public boolean intersects(rg rgVar) {
        return intersects(rgVar.getX(), rgVar.getY(), rgVar.getWidth(), rgVar.getHeight());
    }

    public abstract boolean isEmpty();

    public abstract void setFrame(double d, double d2, double d3, double d4);

    public void setFrame(fe feVar, qw qwVar) {
        setFrame(feVar.getX(), feVar.getY(), qwVar.getWidth(), qwVar.getHeight());
    }

    public void setFrameFromCenter(double d, double d2, double d3, double d4) {
        double abs = Math.abs(d3 - d);
        double abs2 = Math.abs(d4 - d2);
        setFrame(d - abs, d2 - abs2, abs * 2.0d, abs2 * 2.0d);
    }

    public void setFrameFromDiagonal(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        if (d < d3) {
            d6 = d3 - d;
            d5 = d;
        } else {
            d6 = d - d3;
            d5 = d3;
        }
        double d9 = d6;
        if (d2 < d4) {
            d8 = d4 - d2;
            d7 = d2;
        } else {
            d8 = d2 - d4;
            d7 = d4;
        }
        setFrame(d5, d7, d9, d8);
    }

    public boolean contains(rg rgVar) {
        return contains(rgVar.getX(), rgVar.getY(), rgVar.getWidth(), rgVar.getHeight());
    }

    public void setFrame(rg rgVar) {
        setFrame(rgVar.getX(), rgVar.getY(), rgVar.getWidth(), rgVar.getHeight());
    }

    public void setFrameFromDiagonal(fe feVar, fe feVar2) {
        setFrameFromDiagonal(feVar.getX(), feVar.getY(), feVar2.getX(), feVar2.getY());
    }

    public void setFrameFromCenter(fe feVar, fe feVar2) {
        setFrameFromCenter(feVar.getX(), feVar.getY(), feVar2.getX(), feVar2.getY());
    }
}
