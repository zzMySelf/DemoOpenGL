package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.dxmpay.wallet.core.NoProguard;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class i implements Application.ActivityLifecycleCallbacks, NoProguard {
    public Stack<String> a;

    public static class a {
        public static i a = new i();
    }

    public static i a() {
        return a.a;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity != null && (activity instanceof d)) {
            this.a.add(((d) activity).getLangbridgeStamp());
        }
    }

    public void onActivityDestroyed(Activity activity) {
        if (activity != null && (activity instanceof d)) {
            this.a.remove(((d) activity).getLangbridgeStamp());
        }
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public i() {
        this.a = new Stack<>();
    }

    public String[] a(Context context) {
        Iterator<String> it;
        int i2;
        int size = this.a.size();
        HashSet<String> langbridgeCellHashStampByGroup = LangbridgePreloadCellCenter.getInstance(DxmApplicationContextImpl.getApplicationContext(context)).getLangbridgeCellHashStampByGroup(LangbridgePreloadCellCenter.PRELOAD_POOL_TAG_FROM_NA);
        if (langbridgeCellHashStampByGroup == null || langbridgeCellHashStampByGroup.size() <= 0) {
            it = null;
            i2 = 0;
        } else {
            i2 = langbridgeCellHashStampByGroup.size();
            it = langbridgeCellHashStampByGroup.iterator();
        }
        Iterator it2 = this.a.iterator();
        String[] strArr = new String[(size + i2 + 1)];
        strArr[0] = "";
        int i3 = 1;
        while (it2.hasNext()) {
            strArr[i3] = (String) it2.next();
            i3++;
        }
        while (it != null && it.hasNext()) {
            strArr[i3] = it.next();
            i3++;
        }
        return strArr;
    }
}
