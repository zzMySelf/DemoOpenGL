package rg.qw;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SuppressLint({"CommitPrefEdits"})
public abstract class uk<T> {

    /* renamed from: ad  reason: collision with root package name */
    public final qw f10451ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f10452de;

    /* renamed from: fe  reason: collision with root package name */
    public T f10453fe;
    public final Future<SharedPreferences> qw;

    public interface qw<T> {
        String ad(T t);

        T load(String str);

        T qw();
    }

    public uk(Future<SharedPreferences> future, String str, qw<T> qwVar) {
        this.qw = future;
        this.f10451ad = qwVar;
        this.f10452de = str;
    }

    public T ad() {
        Object obj;
        if (this.f10453fe == null) {
            synchronized (this.qw) {
                String str = null;
                try {
                    SharedPreferences sharedPreferences = this.qw.get();
                    if (sharedPreferences != null) {
                        str = sharedPreferences.getString(this.f10452de, (String) null);
                    }
                } catch (ExecutionException e) {
                    e.getCause();
                } catch (InterruptedException unused) {
                }
                if (str == null) {
                    obj = this.f10451ad.qw();
                } else {
                    obj = this.f10451ad.load(str);
                }
                if (obj != null) {
                    qw(obj);
                }
            }
        }
        return this.f10453fe;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017 A[Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x0014 }, DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0019 A[Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x0014 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void qw(T r5) {
        /*
            r4 = this;
            r4.f10453fe = r5
            java.util.concurrent.Future<android.content.SharedPreferences> r5 = r4.qw
            monitor-enter(r5)
            java.util.concurrent.Future<android.content.SharedPreferences> r0 = r4.qw     // Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x0014 }
            java.lang.Object r0 = r0.get()     // Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x0014 }
            android.content.SharedPreferences r0 = (android.content.SharedPreferences) r0     // Catch:{ ExecutionException -> 0x0010, InterruptedException -> 0x0014 }
            goto L_0x0015
        L_0x000e:
            r0 = move-exception
            goto L_0x0039
        L_0x0010:
            r0 = move-exception
            r0.getCause()     // Catch:{ all -> 0x000e }
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 != 0) goto L_0x0019
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            return
        L_0x0019:
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x000e }
            java.lang.String r1 = r4.f10452de     // Catch:{ all -> 0x000e }
            rg.qw.uk$qw r2 = r4.f10451ad     // Catch:{ all -> 0x000e }
            T r3 = r4.f10453fe     // Catch:{ all -> 0x000e }
            java.lang.String r2 = r2.ad(r3)     // Catch:{ all -> 0x000e }
            r0.putString(r1, r2)     // Catch:{ all -> 0x000e }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x000e }
            r2 = 9
            if (r1 < r2) goto L_0x0034
            r0.apply()     // Catch:{ all -> 0x000e }
            goto L_0x0037
        L_0x0034:
            r0.commit()     // Catch:{ all -> 0x000e }
        L_0x0037:
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            return
        L_0x0039:
            monitor-exit(r5)     // Catch:{ all -> 0x000e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: rg.qw.uk.qw(java.lang.Object):void");
    }
}
