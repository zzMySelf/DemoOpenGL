package fe.fe.ddd.when.fe;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.java.Supplier;
import fe.fe.ddd.i.qw.qw;
import fe.fe.ddd.when.fe.qw;
import java.io.File;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile th f1685ad;
    @NonNull
    public yj qw;

    public th(@NonNull yj yjVar) {
        this.qw = yjVar;
    }

    @NonNull
    public static th ad() {
        if (f1685ad == null) {
            synchronized (th.class) {
                if (f1685ad == null) {
                    uk();
                }
            }
        }
        return f1685ad;
    }

    public static synchronized void i(@NonNull yj yjVar) {
        synchronized (th.class) {
            f1685ad = new th(yjVar);
        }
    }

    public static File o(@NonNull String str) {
        File file = ad().de().get();
        if (TextUtils.isEmpty(str)) {
            return file;
        }
        return new File(file, str.replace(":", "_"));
    }

    public static synchronized void uk() {
        synchronized (th.class) {
            i(yj.de(qw.qw()).fe());
        }
    }

    public static void yj() {
        yj.ad();
    }

    @NonNull
    public Supplier<File> de() {
        return this.qw.qw().qw();
    }

    @NonNull
    public File fe() {
        return new File(qw(), qw.qw());
    }

    public File qw() {
        return new File(de().get(), "crashpad");
    }

    @Nullable
    public File rg(@NonNull qw.C0090qw qwVar) {
        String ad2 = qw.C0090qw.ad(qwVar);
        if (!TextUtils.isEmpty(ad2)) {
            return new File(qw(), ad2);
        }
        return null;
    }

    @Nullable
    public File th(@NonNull String str) {
        qw.C0090qw qw2 = qw.C0090qw.qw(str);
        if (qw2 != null) {
            return rg(qw2);
        }
        return null;
    }
}
