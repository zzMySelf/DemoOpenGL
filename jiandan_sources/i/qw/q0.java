package i.qw;

import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.Nullable;

public class q0 extends v0 implements CompletableJob {

    /* renamed from: th  reason: collision with root package name */
    public final boolean f6159th = q0();

    public q0(@Nullable Job job) {
        super(true);
        L(job);
    }

    public boolean E() {
        return this.f6159th;
    }

    public boolean F() {
        return true;
    }

    public final boolean q0() {
        ChildHandle H = H();
        mmm mmm = H instanceof mmm ? (mmm) H : null;
        if (mmm == null) {
            return false;
        }
        v0 t = mmm.t();
        while (!t.E()) {
            ChildHandle H2 = t.H();
            mmm mmm2 = H2 instanceof mmm ? (mmm) H2 : null;
            if (mmm2 == null) {
                return false;
            }
            t = mmm2.t();
        }
        return true;
    }
}
