package fe.uk.qw.vvv;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class th<T, Y> {

    /* renamed from: ad  reason: collision with root package name */
    public long f6054ad;

    /* renamed from: de  reason: collision with root package name */
    public long f6055de;
    public final Map<T, qw<Y>> qw = new LinkedHashMap(100, 0.75f, true);

    public static final class qw<Y> {

        /* renamed from: ad  reason: collision with root package name */
        public final int f6056ad;
        public final Y qw;

        public qw(Y y, int i2) {
            this.qw = y;
            this.f6056ad = i2;
        }
    }

    public th(long j) {
        this.f6054ad = j;
    }

    public void ad() {
        m393switch(0);
    }

    public int i(@Nullable Y y) {
        return 1;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public synchronized Y m392if(@NonNull T t) {
        qw remove = this.qw.remove(t);
        if (remove == null) {
            return null;
        }
        this.f6055de -= (long) remove.f6056ad;
        return remove.qw;
    }

    public void o(@NonNull T t, @Nullable Y y) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0049, code lost:
        return r5;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized Y pf(@androidx.annotation.NonNull T r8, @androidx.annotation.Nullable Y r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            int r0 = r7.i(r9)     // Catch:{ all -> 0x004a }
            long r1 = (long) r0     // Catch:{ all -> 0x004a }
            long r3 = r7.f6054ad     // Catch:{ all -> 0x004a }
            r5 = 0
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 < 0) goto L_0x0012
            r7.o(r8, r9)     // Catch:{ all -> 0x004a }
            monitor-exit(r7)
            return r5
        L_0x0012:
            if (r9 == 0) goto L_0x0019
            long r3 = r7.f6055de     // Catch:{ all -> 0x004a }
            long r3 = r3 + r1
            r7.f6055de = r3     // Catch:{ all -> 0x004a }
        L_0x0019:
            java.util.Map<T, fe.uk.qw.vvv.th$qw<Y>> r1 = r7.qw     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x001f
            r2 = r5
            goto L_0x0024
        L_0x001f:
            fe.uk.qw.vvv.th$qw r2 = new fe.uk.qw.vvv.th$qw     // Catch:{ all -> 0x004a }
            r2.<init>(r9, r0)     // Catch:{ all -> 0x004a }
        L_0x0024:
            java.lang.Object r0 = r1.put(r8, r2)     // Catch:{ all -> 0x004a }
            fe.uk.qw.vvv.th$qw r0 = (fe.uk.qw.vvv.th.qw) r0     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0041
            long r1 = r7.f6055de     // Catch:{ all -> 0x004a }
            int r3 = r0.f6056ad     // Catch:{ all -> 0x004a }
            long r3 = (long) r3     // Catch:{ all -> 0x004a }
            long r1 = r1 - r3
            r7.f6055de = r1     // Catch:{ all -> 0x004a }
            Y r1 = r0.qw     // Catch:{ all -> 0x004a }
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x004a }
            if (r9 != 0) goto L_0x0041
            Y r9 = r0.qw     // Catch:{ all -> 0x004a }
            r7.o(r8, r9)     // Catch:{ all -> 0x004a }
        L_0x0041:
            r7.th()     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0048
            Y r5 = r0.qw     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r7)
            return r5
        L_0x004a:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.uk.qw.vvv.th.pf(java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized void m393switch(long j) {
        while (this.f6055de > j) {
            Iterator<Map.Entry<T, qw<Y>>> it = this.qw.entrySet().iterator();
            Map.Entry next = it.next();
            qw qwVar = (qw) next.getValue();
            this.f6055de -= (long) qwVar.f6056ad;
            Object key = next.getKey();
            it.remove();
            o(key, qwVar.qw);
        }
    }

    public final void th() {
        m393switch(this.f6054ad);
    }

    public synchronized long uk() {
        return this.f6054ad;
    }

    @Nullable
    public synchronized Y yj(@NonNull T t) {
        qw qwVar;
        qwVar = this.qw.get(t);
        return qwVar != null ? qwVar.qw : null;
    }
}
