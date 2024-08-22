package p041if.rg.fe.i;

/* renamed from: if.rg.fe.i.i  reason: invalid package */
public final class i<E> extends Cswitch<E> {
    public i(int i2) {
        super(i2);
    }

    public boolean isEmpty() {
        return pf() == uk();
    }

    public boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f11223th;
            long j = this.f11222ad;
            long uk2 = uk();
            long qw = qw(uk2);
            if (rg(eArr, qw) == null) {
                yj(eArr, qw, e);
                i(uk2 + 1);
            } else if (uk2 - pf() > j) {
                return false;
            } else {
                do {
                } while (rg(eArr, qw) != null);
            }
            yj(eArr, qw, e);
            i(uk2 + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public E peek() {
        E fe2;
        long j = m2365if();
        do {
            long pf2 = pf();
            if (pf2 >= j) {
                long uk2 = uk();
                if (pf2 >= uk2) {
                    return null;
                }
                m2366switch(uk2);
            }
            fe2 = fe(qw(pf2));
        } while (fe2 == null);
        return fe2;
    }

    public E poll() {
        long pf2;
        long j = m2365if();
        do {
            pf2 = pf();
            if (pf2 >= j) {
                long uk2 = uk();
                if (pf2 >= uk2) {
                    return null;
                }
                m2366switch(uk2);
            }
        } while (!o(pf2, 1 + pf2));
        long qw = qw(pf2);
        E[] eArr = this.f11223th;
        E de2 = de(eArr, qw);
        th(eArr, qw, null);
        return de2;
    }

    public int size() {
        long pf2 = pf();
        while (true) {
            long uk2 = uk();
            long pf3 = pf();
            if (pf2 == pf3) {
                return (int) (uk2 - pf3);
            }
            pf2 = pf3;
        }
    }
}
