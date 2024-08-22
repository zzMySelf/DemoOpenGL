package fe.rg.qw.p018switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fe.rg.qw.switch.th  reason: invalid package */
public class th {
    public final List<qw<?>> qw = new ArrayList();

    /* renamed from: fe.rg.qw.switch.th$qw */
    public static final class qw<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final ResourceEncoder<T> f5037ad;
        public final Class<T> qw;

        public qw(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.qw = cls;
            this.f5037ad = resourceEncoder;
        }

        public boolean qw(@NonNull Class<?> cls) {
            return this.qw.isAssignableFrom(cls);
        }
    }

    @Nullable
    public synchronized <Z> ResourceEncoder<Z> ad(@NonNull Class<Z> cls) {
        int size = this.qw.size();
        for (int i2 = 0; i2 < size; i2++) {
            qw qwVar = this.qw.get(i2);
            if (qwVar.qw(cls)) {
                return qwVar.f5037ad;
            }
        }
        return null;
    }

    public synchronized <Z> void qw(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.qw.add(new qw(cls, resourceEncoder));
    }
}
