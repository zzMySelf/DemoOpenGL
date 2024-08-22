package fe.fe.ddd.when.fe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.logsys.LogType;
import fe.fe.ddd.when.yj.ad;
import java.io.File;

public class rg extends ad {
    @NonNull

    /* renamed from: ad  reason: collision with root package name */
    public String f1679ad = null;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public String f1680de = null;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public File f1681fe = null;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public File f1682rg = null;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public LogExtra f1683th;

    /* renamed from: yj  reason: collision with root package name */
    public String f1684yj = null;

    public rg(@NonNull LogType logType, @NonNull String str, @Nullable String str2, @Nullable File file, @Nullable File file2, @Nullable LogExtra logExtra, @NonNull String str3) {
        if (LogType.NONE != logType || !ad.qw) {
            this.qw = logType;
            this.f1679ad = str;
            this.f1680de = str2;
            if (file != null && file.exists() && file.isFile()) {
                this.f1681fe = file;
            }
            if (file2 != null && file2.exists() && file2.isFile()) {
                this.f1682rg = file2;
            }
            this.f1683th = logExtra;
            this.f1684yj = str3;
            return;
        }
        throw new RuntimeException("logType should not be LogType.NONE in LogObject instance.");
    }

    public String ad() {
        return this.f1680de;
    }

    public File de() {
        return this.f1681fe;
    }

    public LogExtra fe() {
        return this.f1683th;
    }

    public void i(boolean z) {
    }

    public String qw() {
        return this.f1684yj;
    }

    public File rg() {
        return this.f1682rg;
    }

    public String th() {
        return this.f1679ad;
    }

    public void uk(@NonNull File file) {
        this.f1681fe = file;
    }

    public void yj(@NonNull String str) {
        this.f1680de = str;
    }
}
