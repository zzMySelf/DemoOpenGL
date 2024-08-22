package fe.mmm.qw.yj;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tera.scan.config.IAccountChecker;

public class uk {

    /* renamed from: th  reason: collision with root package name */
    public static volatile uk f8724th;

    /* renamed from: ad  reason: collision with root package name */
    public String f8725ad;

    /* renamed from: de  reason: collision with root package name */
    public IAccountChecker f8726de;

    /* renamed from: fe  reason: collision with root package name */
    public SharedPreferences f8727fe;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public boolean f8728rg;

    public static uk ad() {
        if (f8724th == null) {
            synchronized (uk.class) {
                if (f8724th == null) {
                    f8724th = new uk();
                }
            }
        }
        return f8724th;
    }

    public String de(String str) {
        return fe(str, "");
    }

    public String fe(String str, String str2) {
        return th() ? this.f8727fe.getString(str, str2) : str2;
    }

    public void qw() {
        this.qw = null;
        this.f8725ad = null;
        this.f8726de = null;
        this.f8727fe = null;
        this.f8728rg = false;
        f8724th = null;
    }

    public void rg(@NonNull Context context, @NonNull String str, @Nullable IAccountChecker iAccountChecker) {
        this.qw = context;
        this.f8725ad = str + "netdisksettings";
        this.f8726de = iAccountChecker;
        this.f8728rg = true;
    }

    public boolean th() {
        if (!this.f8728rg) {
            return false;
        }
        IAccountChecker iAccountChecker = this.f8726de;
        if (iAccountChecker != null && !iAccountChecker.ad()) {
            return false;
        }
        if (this.f8727fe != null) {
            return true;
        }
        this.f8727fe = this.qw.getSharedPreferences(this.f8725ad, 0);
        return true;
    }
}
