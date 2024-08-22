package fe.rg.qw.ggg.o;

import androidx.annotation.NonNull;

public abstract class ad {

    /* renamed from: fe.rg.qw.ggg.o.ad$ad  reason: collision with other inner class name */
    public static class C0203ad extends ad {
        public volatile boolean qw;

        public C0203ad() {
            super();
        }

        public void ad(boolean z) {
            this.qw = z;
        }

        public void de() {
            if (this.qw) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    @NonNull
    public static ad qw() {
        return new C0203ad();
    }

    public abstract void ad(boolean z);

    public abstract void de();

    public ad() {
    }
}
