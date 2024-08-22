package fe.uk.qw.pf.th.i;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.resource.transcode.ResourceTranscoder;
import java.util.ArrayList;
import java.util.List;

public class rg {
    public final List<qw<?, ?>> qw = new ArrayList();

    public static final class qw<Z, R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<R> f5985ad;

        /* renamed from: de  reason: collision with root package name */
        public final ResourceTranscoder<Z, R> f5986de;
        public final Class<Z> qw;

        public qw(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.qw = cls;
            this.f5985ad = cls2;
            this.f5986de = resourceTranscoder;
        }

        public boolean qw(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.qw.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5985ad);
        }
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> ad(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (qw<?, ?> qw2 : this.qw) {
            if (qw2.qw(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void de(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.qw.add(new qw(cls, cls2, resourceTranscoder));
    }

    @NonNull
    public synchronized <Z, R> ResourceTranscoder<Z, R> qw(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return th.ad();
        }
        for (qw next : this.qw) {
            if (next.qw(cls, cls2)) {
                return next.f5986de;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
