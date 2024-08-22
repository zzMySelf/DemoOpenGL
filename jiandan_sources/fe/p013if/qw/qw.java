package fe.p013if.qw;

import android.os.Looper;
import java.util.LinkedHashMap;

/* renamed from: fe.if.qw.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public int f4627ad = 100;
    public final LinkedHashMap<Long, StackTraceElement[]> qw = new LinkedHashMap<>();

    public LinkedHashMap<Long, StackTraceElement[]> ad() {
        return this.qw;
    }

    public void qw() {
        int size = this.qw.size();
        int i2 = this.f4627ad;
        if (size == i2 && i2 > 0) {
            LinkedHashMap<Long, StackTraceElement[]> linkedHashMap = this.qw;
            linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
        }
        this.qw.put(Long.valueOf(System.currentTimeMillis()), Looper.getMainLooper().getThread().getStackTrace());
    }
}
