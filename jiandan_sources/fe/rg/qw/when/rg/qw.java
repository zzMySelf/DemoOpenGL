package fe.rg.qw.when.rg;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.request.transition.TransitionFactory;

public class qw<R> implements Transition<R> {

    /* renamed from: ad  reason: collision with root package name */
    public static final TransitionFactory<?> f5101ad = new C0218qw();
    public static final qw<?> qw = new qw<>();

    /* renamed from: fe.rg.qw.when.rg.qw$qw  reason: collision with other inner class name */
    public static class C0218qw<R> implements TransitionFactory<R> {
        public Transition<R> qw(DataSource dataSource, boolean z) {
            return qw.qw;
        }
    }

    public static <R> TransitionFactory<R> ad() {
        return f5101ad;
    }

    public boolean qw(Object obj, Transition.ViewAdapter viewAdapter) {
        return false;
    }
}
