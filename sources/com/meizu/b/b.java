package com.meizu.b;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.searchbox.hissug.util.common.SceneConstantsKt;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import com.meizu.p0.e;
import java.util.HashMap;
import java.util.Map;

public class b {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4807d = "b";

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, String> f4808a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Object> f4809b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f4810c;

    /* renamed from: com.meizu.b.b$b  reason: collision with other inner class name */
    public static class C0076b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Context f4811a = null;

        public C0076b a(Context context) {
            this.f4811a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(C0076b bVar) {
        this.f4808a = new HashMap<>();
        this.f4809b = new HashMap<>();
        this.f4810c = new HashMap<>();
        d();
        if (bVar.f4811a != null) {
            d(bVar.f4811a);
            c(bVar.f4811a);
            b(bVar.f4811a);
            a(bVar.f4811a);
        }
        DebugLogger.i(f4807d, "Subject created successfully.");
    }

    private void a(Context context) {
        a("pn", (Object) context.getPackageName());
        a("pv", (Object) MzSystemUtils.getAppVersionName(context));
        a("pvc", (Object) Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a("st", (Object) Integer.valueOf(TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ^ true ? 1 : 0));
    }

    private void a(String str, int i2, int i3) {
        this.f4808a.put(str, i2 + "." + i3);
    }

    private void a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!(obj instanceof String) || !((String) obj).isEmpty()) {
                this.f4809b.put(str, obj);
            }
        }
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f4808a.put(str, str2);
        }
    }

    private void b(Context context) {
        b("nt", MzSystemUtils.getNetWorkType(context));
    }

    private void b(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!(obj instanceof String) || !((String) obj).isEmpty()) {
                this.f4810c.put(str, obj);
            }
        }
    }

    private void d() {
        a("br", Build.BRAND);
        a("dc", Build.MODEL);
        a(SceneConstantsKt.SCENE_OTHER, Build.VERSION.RELEASE);
        a("ov", Build.DISPLAY);
        a("ll", MzSystemUtils.getCurrentLanguage());
    }

    private void d(Context context) {
        a("op", e.c(context));
    }

    public Map<String, Object> a() {
        return this.f4809b;
    }

    public Map<String, String> b() {
        return this.f4808a;
    }

    public Map<String, Object> c() {
        return this.f4810c;
    }

    public void c(Context context) {
        Point b2 = e.b(context);
        if (b2 == null) {
            DebugLogger.e(f4807d, "screen information not available.");
        } else {
            a("ss", b2.x, b2.y);
        }
    }
}
