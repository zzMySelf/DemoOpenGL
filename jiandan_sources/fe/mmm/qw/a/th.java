package fe.mmm.qw.a;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

public final class th {

    /* renamed from: ad  reason: collision with root package name */
    public static final int f7616ad;
    @NotNull
    @JvmField

    /* renamed from: de  reason: collision with root package name */
    public static final ThreadPoolExecutor f7617de;
    public static final int qw;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        qw = availableProcessors;
        f7616ad = (availableProcessors * 2) + 1;
        int i2 = f7616ad;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new qw("io"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f7617de = threadPoolExecutor;
        int i3 = qw;
        new ThreadPoolExecutor(i3, i3, 0, TimeUnit.SECONDS, new LinkedBlockingDeque(), new qw("cpu"));
    }
}
