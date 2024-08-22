package com.baidu.wallet.lightapp.multipage;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.Vector;

public class f {
    public Collection<Collection<c>> a;

    public static class a {
        public static f a = new f();
    }

    public static f a() {
        return a.a;
    }

    public void b(Collection<c> collection) {
        if (collection != null) {
            this.a.remove(collection);
        }
    }

    public float c() {
        Runtime runtime = Runtime.getRuntime();
        float maxMemory = (float) (((runtime.maxMemory() - runtime.totalMemory()) + runtime.freeMemory()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        LogUtil.d("LangbridgeRamMonitor", "FreeRam:" + maxMemory);
        return maxMemory;
    }

    public f() {
        this.a = new Vector();
    }

    public void a(Collection<c> collection) {
        if (collection != null) {
            this.a.add(collection);
        }
    }

    public int b() {
        int i2 = 0;
        for (Collection<c> size : this.a) {
            i2 += size.size();
        }
        LogUtil.d("LangbridgeRamMonitor", "UsingCellCount:" + i2);
        return i2;
    }

    public boolean a(Context context) {
        LangbridgeSettings a2 = h.a().a(context);
        boolean z = a2.MW_LANG_CELL_LIMIT == -1 || b() < a2.MW_LANG_CELL_LIMIT;
        boolean z2 = a2.MW_LANG_RAM_LIMIT == -1.0d || ((double) c()) > a2.MW_LANG_RAM_LIMIT;
        boolean z3 = z && z2;
        if (!z3) {
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            String str = "1";
            sb.append(z ? str : "0");
            if (!z2) {
                str = "0";
            }
            sb.append(str);
            strArr[0] = sb.toString();
            DXMSdkSAUtils.onEventWithValues("#MW_LRM_NoNewCell", Arrays.asList(strArr));
        }
        return z3;
    }
}
