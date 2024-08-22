package fe.fe.ddd.de.rg;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.de.fe.ad;
import fe.fe.ddd.fe.qw.pf.de;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class qw implements IANRRegister {

    /* renamed from: ad  reason: collision with root package name */
    public de f1394ad = new de();

    /* renamed from: de  reason: collision with root package name */
    public List<File> f1395de = new ArrayList();
    public String qw = "anr";

    public boolean ad() {
        return ad.f1391de;
    }

    public final void de(List<File> list) {
        if (list != null && list.size() > 0) {
            for (File deleteFile : list) {
                FileUtils.deleteFile(deleteFile);
            }
        }
    }

    public final void fe(List<File> list, String str) {
        if (!list.isEmpty() && !TextUtils.isEmpty(str)) {
            this.f1394ad.ggg(list, str, this.qw);
        }
    }

    public void qw(Context context, fe.fe.ddd.de.ad.ad adVar) {
        if (ad()) {
            boolean rg2 = AppConfig.rg();
            this.f1395de.clear();
            File file = null;
            if (!TextUtils.isEmpty(adVar.fe())) {
                file = new File(adVar.fe());
                if (file.exists()) {
                    this.f1395de.add(file);
                }
            }
            if (!TextUtils.isEmpty(adVar.yj())) {
                File file2 = new File(adVar.yj());
                if (file2.exists() && file2.canRead()) {
                    this.f1395de.add(file2);
                    fe(this.f1395de, adVar.de());
                    FileUtils.deleteFile(file);
                    return;
                }
            }
            if (!TextUtils.isEmpty(adVar.qw())) {
                File file3 = new File(adVar.qw());
                if (file3.exists()) {
                    this.f1395de.add(file3);
                    fe(this.f1395de, adVar.de());
                    de(this.f1395de);
                }
            }
        }
    }

    public void rg() {
        if (de.yj()) {
            this.f1394ad.ppp();
        }
    }
}
