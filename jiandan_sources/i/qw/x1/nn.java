package i.qw.x1;

import i.qw.z0;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.jvm.JvmField;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import org.jetbrains.annotations.NotNull;

public final class nn {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f6281ad = d.rg("kotlinx.coroutines.fast.service.loader", true);
    @NotNull
    @JvmField

    /* renamed from: de  reason: collision with root package name */
    public static final z0 f6282de = qw.qw();
    @NotNull
    public static final nn qw = new nn();

    public final z0 qw() {
        List<MainDispatcherFactory> list;
        T t;
        Class cls = MainDispatcherFactory.class;
        try {
            if (f6281ad) {
                list = pf.qw.de();
            } else {
                list = SequencesKt___SequencesKt.toList(SequencesKt__SequencesKt.asSequence(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator<T> it = list.iterator();
            if (!it.hasNext()) {
                t = null;
            } else {
                t = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) t).getLoadPriority();
                    do {
                        T next = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            t = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) t;
            if (mainDispatcherFactory == null) {
                return mmm.ad((Throwable) null, (String) null, 3, (Object) null);
            }
            return mmm.fe(mainDispatcherFactory, list);
        } catch (Throwable th2) {
            return mmm.ad(th2, (String) null, 2, (Object) null);
        }
    }
}
