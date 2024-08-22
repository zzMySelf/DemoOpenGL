package fe.fe.ddd.mmm.qw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class uk {

    /* renamed from: yj  reason: collision with root package name */
    public static SimpleDateFormat f1500yj = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss:SSS");

    /* renamed from: ad  reason: collision with root package name */
    public String f1501ad;

    /* renamed from: de  reason: collision with root package name */
    public String f1502de;

    /* renamed from: fe  reason: collision with root package name */
    public String f1503fe;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public long f1504rg;

    /* renamed from: th  reason: collision with root package name */
    public String f1505th;

    public uk(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, long j, @NonNull String str8) {
        this.qw = str;
        this.f1501ad = str2;
        this.f1502de = str3;
        this.f1503fe = str4;
        this.f1504rg = j;
        this.f1505th = str8;
    }

    public static String th(long j) {
        return f1500yj.format(new Date(j));
    }

    @Nullable
    public static String[] uk(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("\t")) != null && split.length == 4) {
            return split;
        }
        return null;
    }

    public String ad() {
        return this.f1501ad;
    }

    public String de() {
        return this.f1505th;
    }

    public String fe() {
        return this.f1502de;
    }

    public String qw() {
        return this.qw;
    }

    public String rg() {
        return this.f1503fe;
    }

    @NonNull
    @Deprecated
    public String toString() {
        StringBuilder sb = new StringBuilder(th(this.f1504rg));
        sb.append("\t");
        sb.append(this.f1504rg);
        sb.append("\t");
        sb.append(this.qw);
        sb.append(this.f1501ad);
        if (!TextUtils.isEmpty(this.f1502de)) {
            sb.append("->");
            sb.append(this.f1502de);
            if (!TextUtils.isEmpty(this.f1503fe)) {
                sb.append(this.f1503fe);
            }
        }
        sb.append("\t");
        sb.append(this.f1505th);
        return sb.toString();
    }

    public long yj() {
        return this.f1504rg;
    }
}
