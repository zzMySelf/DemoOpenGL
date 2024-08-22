package b.a.a.a.c.q;

import android.content.SharedPreferences;
import com.baidu.platform.comapi.walknavi.a;

/* compiled from: WNaviPreference */
public class o extends a {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f1414a = b.a.a.a.c.q.b.a.a().getSharedPreferences("walknavi_preference", 0);

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f1415b = null;

    public String a(String str, String str2) {
        return this.f1414a.getString(str, str2);
    }

    public boolean b(String str, boolean z) {
        SharedPreferences.Editor edit = this.f1414a.edit();
        this.f1415b = edit;
        edit.putBoolean(str, z);
        return this.f1415b.commit();
    }

    public boolean ready() {
        return true;
    }

    public void release() {
    }

    public boolean a(String str, boolean z) {
        return this.f1414a.getBoolean(str, z);
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor edit = this.f1414a.edit();
        this.f1415b = edit;
        edit.putString(str, str2);
        return this.f1415b.commit();
    }
}
