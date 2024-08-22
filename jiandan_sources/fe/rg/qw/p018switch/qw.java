package fe.rg.qw.p018switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fe.rg.qw.switch.qw  reason: invalid package */
public class qw {
    public final List<C0215qw<?>> qw = new ArrayList();

    /* renamed from: fe.rg.qw.switch.qw$qw  reason: collision with other inner class name */
    public static final class C0215qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Encoder<T> f5033ad;
        public final Class<T> qw;

        public C0215qw(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.qw = cls;
            this.f5033ad = encoder;
        }

        public boolean qw(@NonNull Class<?> cls) {
            return this.qw.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> Encoder<T> ad(@NonNull Class<T> cls) {
        for (C0215qw next : this.qw) {
            if (next.qw(cls)) {
                return next.f5033ad;
            }
        }
        return null;
    }

    public synchronized <T> void qw(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.qw.add(new C0215qw(cls, encoder));
    }
}
