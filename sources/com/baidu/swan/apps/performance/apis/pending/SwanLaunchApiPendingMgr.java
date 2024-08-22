package com.baidu.swan.apps.performance.apis.pending;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.swan.apps.performance.template.SwanLaunchTriggerMgr;
import com.baidu.swan.apps.performance.template.interfaces.ISwanLaunchTrigger;
import com.baidu.swan.apps.pullrefresh.ISwanPerformance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwanLaunchApiPendingMgr implements ISwanPerformance {
    private ISwanLaunchTrigger mLaunchTrigger;
    CopyOnWriteArrayList<ISwanApiPendingListener> mListenerList;
    private List<String> mPendingApiList;
    /* access modifiers changed from: private */
    public boolean mPendingStatus;

    private static class Holder {
        static final SwanLaunchApiPendingMgr sInstance = new SwanLaunchApiPendingMgr();

        private Holder() {
        }
    }

    private SwanLaunchApiPendingMgr() {
        this.mPendingApiList = new ArrayList();
        this.mListenerList = new CopyOnWriteArrayList<>();
        this.mPendingStatus = false;
        this.mLaunchTrigger = new ISwanLaunchTrigger() {
            public String getName() {
                return "GlobalJsBridge";
            }

            public void consumeTask(Runnable runnable, String taskName) {
            }

            public void triggerLaunch(String source) {
                boolean unused = SwanLaunchApiPendingMgr.this.mPendingStatus = true;
            }

            public void triggerFcp(String url) {
            }

            public void triggerFmp(boolean timeout) {
                boolean unused = SwanLaunchApiPendingMgr.this.mPendingStatus = false;
                if (!SwanLaunchApiPendingMgr.this.mListenerList.isEmpty()) {
                    long start = System.currentTimeMillis();
                    Iterator<ISwanApiPendingListener> it = SwanLaunchApiPendingMgr.this.mListenerList.iterator();
                    while (it.hasNext()) {
                        it.next().triggerFmp();
                    }
                    if (ISwanPerformance.DEBUG) {
                        Log.d(ISwanPerformance.TAG, "pending api dispatch cost = " + (System.currentTimeMillis() - start) + "ms, listener count = " + SwanLaunchApiPendingMgr.this.mListenerList.size());
                    }
                }
            }

            public void triggerDestroy() {
                boolean unused = SwanLaunchApiPendingMgr.this.mPendingStatus = false;
            }
        };
        this.mPendingApiList.clear();
        this.mPendingApiList.add(UnitedSchemeEntity.UNITED_SCHEME + "swanAPI" + "/openStatisticEvent?");
    }

    public static SwanLaunchApiPendingMgr get() {
        return Holder.sInstance;
    }

    public void register(ISwanApiPendingListener listener) {
        if (listener != null) {
            this.mListenerList.add(listener);
            SwanLaunchTriggerMgr.get().register(this.mLaunchTrigger, 4000);
        }
    }

    public boolean checkPendingApi(String scheme) {
        if (TextUtils.isEmpty(scheme) || !this.mPendingStatus) {
            return false;
        }
        for (String suffix : this.mPendingApiList) {
            if (scheme.startsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        this.mListenerList.clear();
    }
}
