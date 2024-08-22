package fe.fe.ddd.ddd.ad;

import android.text.TextUtils;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public static final boolean f1316ad = AppConfig.rg();
    public ListHolder<fe.fe.ddd.ddd.fe.qw> qw;

    public static class ad {
        public static final qw qw = new qw((C0066qw) null);
    }

    public /* synthetic */ qw(C0066qw qwVar) {
        this();
        de();
    }

    public static qw ad() {
        return ad.qw;
    }

    public void de() {
        fe.fe.vvv.qw.qw.ad de2 = fe.fe.vvv.qw.qw.ad.de();
        this.qw = de2;
        de2.ad(new fe.fe.ddd.ddd.fe.ad());
    }

    public List<fe.fe.ddd.ddd.fe.qw> qw() {
        List<fe.fe.ddd.ddd.fe.qw> qw2;
        ListHolder<fe.fe.ddd.ddd.fe.qw> listHolder = this.qw;
        if (listHolder == null || (qw2 = listHolder.qw()) == null || qw2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z = false;
        try {
            for (fe.fe.ddd.ddd.fe.qw next : qw2) {
                String ad2 = next.ad();
                if (TextUtils.isEmpty(ad2)) {
                    arrayList.add(next);
                    z = true;
                    if (f1316ad) {
                        throw new RuntimeException("only debug mode has this crash ===>>>> local fetch type is null ");
                    }
                } else if (arrayList2.contains(ad2)) {
                    arrayList3.add(next);
                } else {
                    arrayList2.add(ad2);
                }
            }
            if (z) {
                qw2.removeAll(arrayList);
            }
            return qw2;
        } catch (Exception e) {
            if (!f1316ad) {
                return null;
            }
            throw e;
        }
    }

    public qw() {
    }
}
