package fe.fe.ddd.ddd.de.de.fe;

import android.text.TextUtils;
import com.baidu.android.util.sp.SharedPrefsWrapper;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static volatile qw f1323ad;
    public SharedPrefsWrapper qw = new SharedPrefsWrapper("com.baidu.searchbox.fetch.task");

    public static qw ad() {
        if (f1323ad == null) {
            synchronized (qw.class) {
                if (f1323ad == null) {
                    f1323ad = new qw();
                }
            }
        }
        return f1323ad;
    }

    public String de() {
        return this.qw.getString("fetch_task_origin", "");
    }

    public int fe() {
        return this.qw.getInt("fetch_task_retry_count", 0);
    }

    public void qw() {
        th("");
    }

    public boolean rg() {
        return this.qw.getBoolean("fetch_debug_key", false);
    }

    public void th(String str) {
        SharedPrefsWrapper sharedPrefsWrapper = this.qw;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        sharedPrefsWrapper.putString("fetch_task_origin", str);
    }

    public void yj(int i2) {
        this.qw.putInt("fetch_task_retry_count", i2);
    }
}
