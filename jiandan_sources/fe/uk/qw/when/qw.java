package fe.uk.qw.when;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

public class qw {
    public final List<C0250qw<?>> qw = new ArrayList();

    /* renamed from: fe.uk.qw.when.qw$qw  reason: collision with other inner class name */
    public static final class C0250qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Encoder<T> f6063ad;
        public final Class<T> qw;

        public C0250qw(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.qw = cls;
            this.f6063ad = encoder;
        }

        public boolean qw(@NonNull Class<?> cls) {
            return this.qw.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <T> Encoder<T> ad(@NonNull Class<T> cls) {
        for (C0250qw next : this.qw) {
            if (next.qw(cls)) {
                return next.f6063ad;
            }
        }
        return null;
    }

    public synchronized <T> void qw(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.qw.add(new C0250qw(cls, encoder));
    }
}
