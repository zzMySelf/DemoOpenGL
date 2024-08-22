package p041if.rg.fe.i;

/* renamed from: if.rg.fe.i.vvv  reason: invalid package */
public final class vvv<E> extends aaa<E> {
    public vvv(int i2) {
        super(i2);
    }

    public final long i() {
        return e.qw.getLongVolatile(this, qqq.f11216pf);
    }

    public boolean isEmpty() {
        return i() == uk();
    }

    public final void o(long j) {
        e.qw.putOrderedLong(this, ddd.f529if, j);
    }

    public boolean offer(E e) {
        if (e != null) {
            E[] eArr = this.f11223th;
            long j = this.producerIndex;
            long qw = qw(j);
            if (rg(eArr, qw) != null) {
                return false;
            }
            th(eArr, qw, e);
            pf(j + 1);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    public E peek() {
        return fe(qw(this.consumerIndex));
    }

    public final void pf(long j) {
        e.qw.putOrderedLong(this, qqq.f11216pf, j);
    }

    public E poll() {
        long j = this.consumerIndex;
        long qw = qw(j);
        E[] eArr = this.f11223th;
        E rg2 = rg(eArr, qw);
        if (rg2 == null) {
            return null;
        }
        th(eArr, qw, null);
        o(j + 1);
        return rg2;
    }

    public int size() {
        long uk2 = uk();
        while (true) {
            long i2 = i();
            long uk3 = uk();
            if (uk2 == uk3) {
                return (int) (i2 - uk3);
            }
            uk2 = uk3;
        }
    }

    public final long uk() {
        return e.qw.getLongVolatile(this, ddd.f529if);
    }
}
