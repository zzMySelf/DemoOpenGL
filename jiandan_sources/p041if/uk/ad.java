package p041if.uk;

import p041if.fe.qw;

/* renamed from: if.uk.ad  reason: invalid package */
public abstract class ad {
    public final String ad(Object obj) {
        try {
            return de(obj);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return obj.getClass().getName() + ".errorRendering";
        } catch (Throwable th2) {
            qw.rg(th2);
            return obj.getClass().getName() + ".errorRendering";
        }
    }

    public String de(Object obj) throws InterruptedException {
        return null;
    }

    @Deprecated
    public void qw(Throwable th2) {
    }
}
