package fe.rg.qw.p018switch;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: fe.rg.qw.switch.rg  reason: invalid package */
public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public final Map<String, List<qw<?, ?>>> f5034ad = new HashMap();
    public final List<String> qw = new ArrayList();

    /* renamed from: fe.rg.qw.switch.rg$qw */
    public static class qw<T, R> {

        /* renamed from: ad  reason: collision with root package name */
        public final Class<R> f5035ad;

        /* renamed from: de  reason: collision with root package name */
        public final ResourceDecoder<T, R> f5036de;
        public final Class<T> qw;

        public qw(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.qw = cls;
            this.f5035ad = cls2;
            this.f5036de = resourceDecoder;
        }

        public boolean qw(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.qw.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f5035ad);
        }
    }

    @NonNull
    public synchronized <T, R> List<ResourceDecoder<T, R>> ad(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.qw) {
            List<qw> list = this.f5034ad.get(str);
            if (list != null) {
                for (qw qwVar : list) {
                    if (qwVar.qw(cls, cls2)) {
                        arrayList.add(qwVar.f5036de);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public final synchronized List<qw<?, ?>> de(@NonNull String str) {
        List<qw<?, ?>> list;
        if (!this.qw.contains(str)) {
            this.qw.add(str);
        }
        list = this.f5034ad.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f5034ad.put(str, list);
        }
        return list;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> fe(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.qw) {
            List<qw> list = this.f5034ad.get(str);
            if (list != null) {
                for (qw qwVar : list) {
                    if (qwVar.qw(cls, cls2) && !arrayList.contains(qwVar.f5035ad)) {
                        arrayList.add(qwVar.f5035ad);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void qw(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        de(str).add(new qw(cls, cls2, resourceDecoder));
    }

    public synchronized void rg(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList<>(this.qw);
        this.qw.clear();
        this.qw.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.qw.add(str);
            }
        }
    }
}
