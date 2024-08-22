package fe.uk.qw.vvv.pf;

import androidx.annotation.NonNull;

public abstract class ad {

    /* renamed from: fe.uk.qw.vvv.pf.ad$ad  reason: collision with other inner class name */
    public static class C0248ad extends ad {
        public volatile boolean qw;

        public C0248ad() {
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
        return new C0248ad();
    }

    public abstract void ad(boolean z);

    public abstract void de();

    public ad() {
    }
}
