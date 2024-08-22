package fe.when.qw.qw;

public abstract class fe implements Cloneable {

    public static class ad extends fe {

        /* renamed from: ad  reason: collision with root package name */
        public float f9914ad;

        /* renamed from: th  reason: collision with root package name */
        public float f9915th;

        public ad() {
        }

        public double getX() {
            return (double) this.f9914ad;
        }

        public double getY() {
            return (double) this.f9915th;
        }

        public void setLocation(double d, double d2) {
            this.f9914ad = (float) d;
            this.f9915th = (float) d2;
        }

        public String toString() {
            return ad.class.getName() + "[x=" + this.f9914ad + ",y=" + this.f9915th + "]";
        }

        public ad(float f, float f2) {
            this.f9914ad = f;
            this.f9915th = f2;
        }
    }

    public static class qw extends fe {

        /* renamed from: ad  reason: collision with root package name */
        public double f9916ad;

        /* renamed from: th  reason: collision with root package name */
        public double f9917th;

        public double getX() {
            return this.f9916ad;
        }

        public double getY() {
            return this.f9917th;
        }

        public void setLocation(double d, double d2) {
            this.f9916ad = d;
            this.f9917th = d2;
        }

        public String toString() {
            return qw.class.getName() + "[x=" + this.f9916ad + ",y=" + this.f9917th + "]";
        }
    }

    public static double distance(double d, double d2, double d3, double d4) {
        return Math.sqrt(distanceSq(d, d2, d3, d4));
    }

    public static double distanceSq(double d, double d2, double d3, double d4) {
        double d5 = d3 - d;
        double d6 = d4 - d2;
        return (d5 * d5) + (d6 * d6);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public double distanceSq(double d, double d2) {
        return distanceSq(getX(), getY(), d, d2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fe)) {
            return false;
        }
        fe feVar = (fe) obj;
        if (getX() == feVar.getX() && getY() == feVar.getY()) {
            return true;
        }
        return false;
    }

    public abstract double getX();

    public abstract double getY();

    public int hashCode() {
        fe.when.qw.qw.uk.qw qwVar = new fe.when.qw.qw.uk.qw();
        qwVar.qw(getX());
        qwVar.qw(getY());
        return qwVar.hashCode();
    }

    public abstract void setLocation(double d, double d2);

    public void setLocation(fe feVar) {
        setLocation(feVar.getX(), feVar.getY());
    }

    public double distance(double d, double d2) {
        return Math.sqrt(distanceSq(d, d2));
    }

    public double distanceSq(fe feVar) {
        return distanceSq(getX(), getY(), feVar.getX(), feVar.getY());
    }

    public double distance(fe feVar) {
        return Math.sqrt(distanceSq(feVar));
    }
}
