package fe.fe.ddd.p000if.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.searchbox.elasticthread.task.ElasticTask;

/* renamed from: fe.fe.ddd.if.i.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile qw f1471ad;
    public long qw = 0;

    public static qw ad() {
        if (f1471ad == null) {
            synchronized (qw.class) {
                if (f1471ad == null) {
                    f1471ad = new qw();
                }
            }
        }
        return f1471ad;
    }

    public ElasticTask qw(@NonNull Runnable runnable, @NonNull String str, int i2) {
        ElasticTask elasticTask;
        if (runnable == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("illegal params");
        }
        synchronized (this) {
            long j = this.qw + 1;
            this.qw = j;
            elasticTask = new ElasticTask(runnable, str, j, i2);
        }
        return elasticTask;
    }
}
