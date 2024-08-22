package fe.fe.ddd.when.qw.rg;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import com.baidu.searchbox.logsystem.javacrash.ProcessExceptionListener;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import fe.fe.ddd.when.fe.i.ad.fe;
import fe.fe.ddd.when.fe.i.ad.rg;
import fe.fe.ddd.when.qw.fe.uk;
import java.io.File;
import java.util.List;

public class ad extends qw {

    /* renamed from: th  reason: collision with root package name */
    public final Supplier<List<rg>> f1703th;

    public ad(@NonNull Context context, @Nullable List<ProcessExceptionListener> list, @Nullable Supplier<List<rg>> supplier) {
        super(context, list);
        this.f1703th = supplier;
    }

    public final fe de() {
        fe feVar = new fe();
        feVar.fe(new fe.fe.ddd.when.qw.fe.ad());
        feVar.fe(new uk());
        feVar.fe(new fe.fe.ddd.when.qw.fe.fe());
        feVar.fe(new fe.fe.ddd.when.qw.fe.rg());
        Supplier<List<rg>> supplier = this.f1703th;
        if (supplier != null) {
            feVar.rg(supplier.get());
        }
        return feVar;
    }

    public void th(@NonNull Context context, @NonNull String str, @Nullable File file, @Nullable LogExtra logExtra) {
        fe.fe.ddd.when.qw.ad.fe(context, LogType.JAVA_CRASH, str, file, logExtra);
    }

    public ad(@Nullable Context context) {
        this(context, (List<ProcessExceptionListener>) null, (Supplier<List<rg>>) null);
    }
}
