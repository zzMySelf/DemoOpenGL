package com.baidu.wallet.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.base.statistics.StatServiceEvent;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ActLifecycleCbs implements Application.ActivityLifecycleCallbacks {
    public static final String a = ActLifecycleCbs.class.getName();
    public static final String b = "#invoke_config_impact_js_result";
    public static int c = 30000;
    public boolean d = false;
    public ArrayList<b> e = new ArrayList<>();
    public HandlerThread f;
    public Handler g;
    public Runnable h;

    public enum FROM {
        RESUME,
        POLL
    }

    public interface a {
        boolean onInvoke(Context context, FROM from);
    }

    public static class b {
        public a a;
        public long b;
        public long c = System.currentTimeMillis();

        public b(a aVar, long j) {
            this.a = aVar;
            this.b = j;
        }
    }

    public static final class c {
        public static final ActLifecycleCbs a = new ActLifecycleCbs();
    }

    private void b() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.h = null;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        LogUtil.d("poll", "onActivityPaused activity = " + activity.getLocalClassName());
        b();
    }

    public void onActivityResumed(Activity activity) {
        LogUtil.d("poll", "onActivityResumed activity = " + activity.getLocalClassName());
        a((Context) activity, FROM.RESUME);
        a(activity);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        LogUtil.d("poll", "onActivityStopped activity = " + activity.getLocalClassName());
        a.a();
    }

    public static ActLifecycleCbs a() {
        return c.a;
    }

    public void a(Application application) {
        if (!this.d && application != null) {
            HandlerThread handlerThread = new HandlerThread("poll");
            this.f = handlerThread;
            handlerThread.start();
            try {
                this.g = new Handler(this.f.getLooper());
                a.a(application);
                LocalRouter.getInstance(application).route(application, new RouterRequest().provider("langbrige").action("langbrige_getToImapctJsFiles").data("configs", new String[]{"config.json"}).data(SavedStateHandle.KEYS, new String[]{"common", "multi-webview"}), new RouterCallback() {
                    public void onResult(int i2, HashMap hashMap) {
                        LogUtil.d("jsHook", "routercb resultCode = " + i2);
                    }
                });
                application.registerActivityLifecycleCallbacks(this);
                this.d = true;
            } catch (Exception e2) {
                DXMSdkSAUtils.onEventWithValues(StatServiceEvent.POLL_INIT_EXCEPTION, Arrays.asList(new String[]{e2.getMessage()}));
            }
        }
    }

    public void a(a aVar, long j) {
        if (this.d && aVar != null) {
            int i2 = 0;
            while (i2 < this.e.size()) {
                b bVar = this.e.get(i2);
                if (bVar == null || aVar != bVar.a) {
                    i2++;
                } else {
                    bVar.b = j;
                    return;
                }
            }
            this.e.add(new b(aVar, j));
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, FROM from) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                b bVar = this.e.get(i2);
                if (bVar != null && currentTimeMillis - bVar.c >= bVar.b && bVar.a.onInvoke(context, from)) {
                    bVar.c = currentTimeMillis;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Activity activity) {
        final WeakReference weakReference = new WeakReference(activity);
        if (this.h == null) {
            this.h = new Runnable() {
                public void run() {
                    Activity activity = (Activity) weakReference.get();
                    if (activity != null) {
                        LogUtil.d("poll", "任务轮询30s一次");
                        ActLifecycleCbs.this.a((Context) activity, FROM.POLL);
                        ActLifecycleCbs.this.a(activity);
                    }
                }
            };
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.postDelayed(this.h, (long) c);
        }
    }
}
