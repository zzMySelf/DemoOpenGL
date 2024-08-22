package fe.fe.ddd.mmm.qw;

import androidx.annotation.NonNull;
import java.util.LinkedList;

public final class ad<E> {

    /* renamed from: ad  reason: collision with root package name */
    public int f1497ad;
    public final LinkedList<E> qw = new LinkedList<>();

    public ad(int i2) {
        this.f1497ad = i2;
    }

    public static <E> ad<E> qw(int i2) {
        if (i2 >= 0) {
            return new ad<>(i2);
        }
        throw new IllegalArgumentException("capacity should not < 0");
    }

    public LinkedList<E> ad() {
        return this.qw;
    }

    public boolean de(@NonNull E e) {
        if (e != null) {
            while (this.qw.size() > 0 && this.qw.size() >= this.f1497ad) {
                this.qw.pollFirst();
            }
            if (this.f1497ad == 0) {
                return true;
            }
            this.qw.offerLast(e);
            return true;
        }
        throw new NullPointerException("element should not be null");
    }

    public E fe() {
        return this.qw.peekLast();
    }
}
