package fe.p036switch.qw;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: fe.switch.qw.h  reason: invalid package */
public class h {
    public static String ad(String str) {
        return UUID.randomUUID().toString() + "_" + str;
    }

    public static FlutterView de(View view) {
        if (view instanceof FlutterView) {
            return (FlutterView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            FlutterView de2 = de(viewGroup.getChildAt(i2));
            if (de2 != null) {
                return de2;
            }
        }
        return null;
    }

    public static e fe(FlutterEngine flutterEngine) {
        if (flutterEngine == null) {
            return null;
        }
        try {
            return (e) flutterEngine.getPlugins().get(Class.forName("fe.switch.qw.e"));
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static Map<Object, Object> qw(Bundle bundle) {
        HashMap hashMap = new HashMap();
        if (bundle != null && !bundle.keySet().isEmpty()) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    hashMap.put(str, qw(bundle.getBundle(str)));
                } else if (obj != null) {
                    hashMap.put(str, obj);
                }
            }
        }
        return hashMap;
    }
}
