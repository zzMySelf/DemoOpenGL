package fe.fe.p007switch.qw;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: fe.fe.switch.qw.when  reason: invalid package */
public abstract class when {
    public abstract SharedPreferences ad(Context context);

    public String de(Context context, String str, String str2) {
        return ad(context).getString(str, str2);
    }

    public void fe(Context context, String str) {
        ad(context).edit().remove(str).commit();
    }

    public int qw(Context context, String str, int i2) {
        return ad(context).getInt(str, i2);
    }

    public boolean rg(Context context, String str, boolean z) {
        return ad(context).getBoolean(str, z);
    }

    public void th(Context context, String str, int i2) {
        ad(context).edit().putInt(str, i2).commit();
    }

    public void uk(Context context, String str, boolean z) {
        ad(context).edit().putBoolean(str, z).commit();
    }

    public void yj(Context context, String str, String str2) {
        ad(context).edit().putString(str, str2).commit();
    }
}
