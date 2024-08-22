package fe.when.qw.qw;

public abstract class qw implements Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public abstract double getHeight();

    public abstract double getWidth();

    public abstract void setSize(double d, double d2);

    public void setSize(qw qwVar) {
        setSize(qwVar.getWidth(), qwVar.getHeight());
    }
}
