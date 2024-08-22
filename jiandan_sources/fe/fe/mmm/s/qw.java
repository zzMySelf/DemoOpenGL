package fe.fe.mmm.s;

import android.content.Context;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.ubc.IUBCABTest;
import com.baidu.ubc.inter.IAppConfigService;
import fe.fe.mmm.q.de;
import fe.fe.mmm.tt;
import fe.fe.yj.de.ad;

public class qw implements IAppConfigService {
    public String ad(String str) {
        IUBCABTest pf2 = tt.pf();
        if (pf2 == null || !pf2.fe()) {
            return ad.th().uk(str);
        }
        return ad.th().ad(str, 1);
    }

    public boolean de() {
        return AppConfig.rg();
    }

    public String fe(boolean z) {
        if (z) {
            return "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox?action=zubc";
        }
        return tt.pf().ad() ? "https://h2tcbox.baidu.com/ztbox?action=zubc" : "https://tcbox.baidu.com/ztbox?action=zubc";
    }

    public int getInt(String str, int i2) {
        return de.qw().getInt(str, i2);
    }

    public long getLong(String str, long j) {
        return de.qw().getLong(str, j);
    }

    public String getString(String str, String str2) {
        return de.qw().getString(str, str2);
    }

    public void putInt(String str, int i2) {
        de.qw().putInt(str, i2);
    }

    public void putLong(String str, long j) {
        de.qw().putLong(str, j);
    }

    public void putString(String str, String str2) {
        de.qw().putString(str, str2);
    }

    public void qw(int i2) {
        fe.fe.ddd.o.qw.qw().putInt("ubc_key_flow_handle", i2);
    }

    public int rg() {
        return fe.fe.ddd.o.qw.qw().getInt("ubc_key_flow_handle", 0);
    }

    public Context th() {
        return fe.fe.ddd.i.qw.qw.qw();
    }

    public String uk(String str) {
        return ad.th().o(str);
    }

    public String yj() {
        return "";
    }
}
