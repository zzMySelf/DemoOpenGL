package fe.uk.qw.ppp.th;

import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.request.transition.Transition;
import com.dxmbumptech.glide.request.transition.TransitionFactory;

public class qw<R> implements Transition<R> {

    /* renamed from: ad  reason: collision with root package name */
    public static final TransitionFactory<?> f6039ad = new C0247qw();
    public static final qw<?> qw = new qw<>();

    /* renamed from: fe.uk.qw.ppp.th.qw$qw  reason: collision with other inner class name */
    public static class C0247qw<R> implements TransitionFactory<R> {
        public Transition<R> qw(DataSource dataSource, boolean z) {
            return qw.qw;
        }
    }

    public static <R> TransitionFactory<R> ad() {
        return f6039ad;
    }

    public boolean qw(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
