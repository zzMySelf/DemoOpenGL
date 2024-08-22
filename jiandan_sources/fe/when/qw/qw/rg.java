package fe.when.qw.qw;

import com.itextpdf.awt.geom.AffineTransform;
import com.itextpdf.awt.geom.PathIterator;
import java.util.NoSuchElementException;

public abstract class rg extends th {
    public static final int OUT_BOTTOM = 8;
    public static final int OUT_LEFT = 1;
    public static final int OUT_RIGHT = 4;
    public static final int OUT_TOP = 2;

    public static class ad extends rg {

        /* renamed from: ad  reason: collision with root package name */
        public float f9918ad;

        /* renamed from: th  reason: collision with root package name */
        public float f9919th;

        /* renamed from: uk  reason: collision with root package name */
        public float f9920uk;

        /* renamed from: yj  reason: collision with root package name */
        public float f9921yj;

        public ad() {
        }

        public void ad(float f, float f2, float f3, float f4) {
            this.f9918ad = f;
            this.f9919th = f2;
            this.f9921yj = f3;
            this.f9920uk = f4;
        }

        public rg createIntersection(rg rgVar) {
            rg rgVar2;
            if (rgVar instanceof qw) {
                rgVar2 = new qw();
            } else {
                rgVar2 = new ad();
            }
            rg.intersect(this, rgVar, rgVar2);
            return rgVar2;
        }

        public rg createUnion(rg rgVar) {
            rg rgVar2;
            if (rgVar instanceof qw) {
                rgVar2 = new qw();
            } else {
                rgVar2 = new ad();
            }
            rg.union(this, rgVar, rgVar2);
            return rgVar2;
        }

        public rg getBounds2D() {
            return new ad(this.f9918ad, this.f9919th, this.f9921yj, this.f9920uk);
        }

        public double getHeight() {
            return (double) this.f9920uk;
        }

        public double getWidth() {
            return (double) this.f9921yj;
        }

        public double getX() {
            return (double) this.f9918ad;
        }

        public double getY() {
            return (double) this.f9919th;
        }

        public boolean isEmpty() {
            return this.f9921yj <= 0.0f || this.f9920uk <= 0.0f;
        }

        public int outcode(double d, double d2) {
            int i2;
            float f = this.f9921yj;
            if (f <= 0.0f) {
                i2 = 5;
            } else {
                float f2 = this.f9918ad;
                i2 = d < ((double) f2) ? 1 : d > ((double) (f2 + f)) ? 4 : 0;
            }
            float f3 = this.f9920uk;
            if (f3 <= 0.0f) {
                return i2 | 10;
            }
            float f4 = this.f9919th;
            if (d2 < ((double) f4)) {
                return i2 | 2;
            }
            return d2 > ((double) (f4 + f3)) ? i2 | 8 : i2;
        }

        public void setRect(double d, double d2, double d3, double d4) {
            this.f9918ad = (float) d;
            this.f9919th = (float) d2;
            this.f9921yj = (float) d3;
            this.f9920uk = (float) d4;
        }

        public String toString() {
            return ad.class.getName() + "[x=" + this.f9918ad + ",y=" + this.f9919th + ",width=" + this.f9921yj + ",height=" + this.f9920uk + "]";
        }

        public ad(float f, float f2, float f3, float f4) {
            ad(f, f2, f3, f4);
        }

        public void setRect(rg rgVar) {
            this.f9918ad = (float) rgVar.getX();
            this.f9919th = (float) rgVar.getY();
            this.f9921yj = (float) rgVar.getWidth();
            this.f9920uk = (float) rgVar.getHeight();
        }
    }

    public class de implements PathIterator {

        /* renamed from: ad  reason: collision with root package name */
        public double f9922ad;

        /* renamed from: de  reason: collision with root package name */
        public double f9923de;

        /* renamed from: fe  reason: collision with root package name */
        public double f9924fe;
        public double qw;

        /* renamed from: rg  reason: collision with root package name */
        public AffineTransform f9925rg;

        /* renamed from: th  reason: collision with root package name */
        public int f9926th;

        public de(rg rgVar, rg rgVar2, AffineTransform affineTransform) {
            this.qw = rgVar2.getX();
            this.f9922ad = rgVar2.getY();
            this.f9923de = rgVar2.getWidth();
            double height = rgVar2.getHeight();
            this.f9924fe = height;
            this.f9925rg = affineTransform;
            if (this.f9923de < 0.0d || height < 0.0d) {
                this.f9926th = 6;
            }
        }

        public int ad(double[] dArr) {
            if (!isDone()) {
                int i2 = this.f9926th;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    dArr[0] = this.qw;
                    dArr[1] = this.f9922ad;
                } else {
                    if (i2 == 1) {
                        dArr[0] = this.qw + this.f9923de;
                        dArr[1] = this.f9922ad;
                    } else if (i2 == 2) {
                        dArr[0] = this.qw + this.f9923de;
                        dArr[1] = this.f9922ad + this.f9924fe;
                    } else if (i2 == 3) {
                        dArr[0] = this.qw;
                        dArr[1] = this.f9922ad + this.f9924fe;
                    } else if (i2 == 4) {
                        dArr[0] = this.qw;
                        dArr[1] = this.f9922ad;
                    }
                    i3 = 1;
                }
                AffineTransform affineTransform = this.f9925rg;
                if (affineTransform != null) {
                    affineTransform.transform(dArr, 0, dArr, 0, 1);
                }
                return i3;
            }
            throw new NoSuchElementException(fe.when.qw.qw.uk.ad.qw("awt.4B"));
        }

        public int de(float[] fArr) {
            if (!isDone()) {
                int i2 = this.f9926th;
                if (i2 == 5) {
                    return 4;
                }
                int i3 = 0;
                if (i2 == 0) {
                    fArr[0] = (float) this.qw;
                    fArr[1] = (float) this.f9922ad;
                } else {
                    if (i2 == 1) {
                        fArr[0] = (float) (this.qw + this.f9923de);
                        fArr[1] = (float) this.f9922ad;
                    } else if (i2 == 2) {
                        fArr[0] = (float) (this.qw + this.f9923de);
                        fArr[1] = (float) (this.f9922ad + this.f9924fe);
                    } else if (i2 == 3) {
                        fArr[0] = (float) this.qw;
                        fArr[1] = (float) (this.f9922ad + this.f9924fe);
                    } else if (i2 == 4) {
                        fArr[0] = (float) this.qw;
                        fArr[1] = (float) this.f9922ad;
                    }
                    i3 = 1;
                }
                AffineTransform affineTransform = this.f9925rg;
                if (affineTransform != null) {
                    affineTransform.transform(fArr, 0, fArr, 0, 1);
                }
                return i3;
            }
            throw new NoSuchElementException(fe.when.qw.qw.uk.ad.qw("awt.4B"));
        }

        public boolean isDone() {
            return this.f9926th > 5;
        }

        public void next() {
            this.f9926th++;
        }

        public int qw() {
            return 1;
        }
    }

    public static class qw extends rg {

        /* renamed from: ad  reason: collision with root package name */
        public double f9927ad;

        /* renamed from: th  reason: collision with root package name */
        public double f9928th;

        /* renamed from: uk  reason: collision with root package name */
        public double f9929uk;

        /* renamed from: yj  reason: collision with root package name */
        public double f9930yj;

        public qw() {
        }

        public rg createIntersection(rg rgVar) {
            qw qwVar = new qw();
            rg.intersect(this, rgVar, qwVar);
            return qwVar;
        }

        public rg createUnion(rg rgVar) {
            qw qwVar = new qw();
            rg.union(this, rgVar, qwVar);
            return qwVar;
        }

        public rg getBounds2D() {
            return new qw(this.f9927ad, this.f9928th, this.f9930yj, this.f9929uk);
        }

        public double getHeight() {
            return this.f9929uk;
        }

        public double getWidth() {
            return this.f9930yj;
        }

        public double getX() {
            return this.f9927ad;
        }

        public double getY() {
            return this.f9928th;
        }

        public boolean isEmpty() {
            return this.f9930yj <= 0.0d || this.f9929uk <= 0.0d;
        }

        public int outcode(double d, double d2) {
            int i2;
            double d3 = this.f9930yj;
            if (d3 <= 0.0d) {
                i2 = 5;
            } else {
                double d4 = this.f9927ad;
                i2 = d < d4 ? 1 : d > d4 + d3 ? 4 : 0;
            }
            double d5 = this.f9929uk;
            if (d5 <= 0.0d) {
                return i2 | 10;
            }
            double d6 = this.f9928th;
            if (d2 < d6) {
                return i2 | 2;
            }
            return d2 > d6 + d5 ? i2 | 8 : i2;
        }

        public void setRect(double d, double d2, double d3, double d4) {
            this.f9927ad = d;
            this.f9928th = d2;
            this.f9930yj = d3;
            this.f9929uk = d4;
        }

        public String toString() {
            return qw.class.getName() + "[x=" + this.f9927ad + ",y=" + this.f9928th + ",width=" + this.f9930yj + ",height=" + this.f9929uk + "]";
        }

        public qw(double d, double d2, double d3, double d4) {
            setRect(d, d2, d3, d4);
        }

        public void setRect(rg rgVar) {
            this.f9927ad = rgVar.getX();
            this.f9928th = rgVar.getY();
            this.f9930yj = rgVar.getWidth();
            this.f9929uk = rgVar.getHeight();
        }
    }

    public static void intersect(rg rgVar, rg rgVar2, rg rgVar3) {
        double max = Math.max(rgVar.getMinX(), rgVar2.getMinX());
        double max2 = Math.max(rgVar.getMinY(), rgVar2.getMinY());
        rg rgVar4 = rgVar3;
        rgVar4.setFrame(max, max2, Math.min(rgVar.getMaxX(), rgVar2.getMaxX()) - max, Math.min(rgVar.getMaxY(), rgVar2.getMaxY()) - max2);
    }

    public static void union(rg rgVar, rg rgVar2, rg rgVar3) {
        double min = Math.min(rgVar.getMinX(), rgVar2.getMinX());
        double min2 = Math.min(rgVar.getMinY(), rgVar2.getMinY());
        rg rgVar4 = rgVar3;
        rgVar4.setFrame(min, min2, Math.max(rgVar.getMaxX(), rgVar2.getMaxX()) - min, Math.max(rgVar.getMaxY(), rgVar2.getMaxY()) - min2);
    }

    public void add(double d, double d2) {
        double min = Math.min(getMinX(), d);
        double min2 = Math.min(getMinY(), d2);
        setRect(min, min2, Math.max(getMaxX(), d) - min, Math.max(getMaxY(), d2) - min2);
    }

    public boolean contains(double d, double d2) {
        if (isEmpty()) {
            return false;
        }
        double x = getX();
        double y = getY();
        double width = getWidth() + x;
        double height = getHeight() + y;
        if (x > d || d >= width || y > d2 || d2 >= height) {
            return false;
        }
        return true;
    }

    public abstract rg createIntersection(rg rgVar);

    public abstract rg createUnion(rg rgVar);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof rg)) {
            return false;
        }
        rg rgVar = (rg) obj;
        if (getX() == rgVar.getX() && getY() == rgVar.getY() && getWidth() == rgVar.getWidth() && getHeight() == rgVar.getHeight()) {
            return true;
        }
        return false;
    }

    public rg getBounds2D() {
        return (rg) clone();
    }

    public PathIterator getPathIterator(AffineTransform affineTransform) {
        return new de(this, this, affineTransform);
    }

    public int hashCode() {
        fe.when.qw.qw.uk.qw qwVar = new fe.when.qw.qw.uk.qw();
        qwVar.qw(getX());
        qwVar.qw(getY());
        qwVar.qw(getWidth());
        qwVar.qw(getHeight());
        return qwVar.hashCode();
    }

    public boolean intersects(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= 0.0d || d4 <= 0.0d) {
            return false;
        }
        double x = getX();
        double y = getY();
        double width = getWidth() + x;
        double height = getHeight() + y;
        if (d + d3 <= x || d >= width || d2 + d4 <= y || d2 >= height) {
            return false;
        }
        return true;
    }

    public boolean intersectsLine(double d, double d2, double d3, double d4) {
        double x = getX();
        double y = getY();
        double width = x + getWidth();
        double height = y + getHeight();
        return (x <= d && d <= width && y <= d2 && d2 <= height) || (x <= d3 && d3 <= width && y <= d4 && d4 <= height) || de.th(x, y, width, height, d, d2, d3, d4) || de.th(width, y, x, height, d, d2, d3, d4);
    }

    public abstract int outcode(double d, double d2);

    public int outcode(fe feVar) {
        return outcode(feVar.getX(), feVar.getY());
    }

    public void setFrame(double d, double d2, double d3, double d4) {
        setRect(d, d2, d3, d4);
    }

    public abstract void setRect(double d, double d2, double d3, double d4);

    public void setRect(rg rgVar) {
        setRect(rgVar.getX(), rgVar.getY(), rgVar.getWidth(), rgVar.getHeight());
    }

    public PathIterator getPathIterator(AffineTransform affineTransform, double d) {
        return new de(this, this, affineTransform);
    }

    public void add(fe feVar) {
        add(feVar.getX(), feVar.getY());
    }

    public boolean contains(double d, double d2, double d3, double d4) {
        if (isEmpty() || d3 <= 0.0d || d4 <= 0.0d) {
            return false;
        }
        double x = getX();
        double y = getY();
        double width = getWidth() + x;
        double height = getHeight() + y;
        if (x > d || d + d3 > width || y > d2 || d2 + d4 > height) {
            return false;
        }
        return true;
    }

    public boolean intersectsLine(de deVar) {
        return intersectsLine(deVar.ad(), deVar.fe(), deVar.de(), deVar.rg());
    }

    public void add(rg rgVar) {
        union(this, rgVar, this);
    }
}
