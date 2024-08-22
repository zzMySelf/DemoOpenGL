package com.itextpdf.awt.geom;

import fe.when.qw.qw.rg;

public interface Shape {
    boolean contains(double d, double d2);

    boolean contains(double d, double d2, double d3, double d4);

    rg getBounds2D();

    PathIterator getPathIterator(AffineTransform affineTransform);

    boolean intersects(double d, double d2, double d3, double d4);
}
