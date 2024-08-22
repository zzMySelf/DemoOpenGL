package com.tera.scan.flutter.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.aiscan.R;
import com.baidu.ubc.UBCManager;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.p024if.uk.qw;
import fe.mmm.qw.p024if.when.ad;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0014H\u0014J\b\u0010\u0018\u001a\u00020\u0014H\u0014J\b\u0010\u0019\u001a\u00020\u0014H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/tera/scan/flutter/ui/FlutterBusinessActivity;", "Lcom/tera/scan/flutter/ui/FlutterBaseActivity;", "()V", "param", "", "getParam", "()Ljava/lang/String;", "setParam", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "getBackgroundMode", "Lio/flutter/embedding/android/FlutterActivityLaunchConfigs$BackgroundMode;", "getBuinessParams", "", "", "initFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "reportSearch", "flutter-core_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class FlutterBusinessActivity extends FlutterBaseActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public String param = "";
    @Nullable
    public String path = "";

    private final Map<String, Object> getBuinessParams() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Bundle extras = getIntent().getExtras();
        Object obj = extras != null ? extras.get("extra_args") : null;
        if (obj instanceof Map) {
            linkedHashMap.putAll((Map) obj);
            return linkedHashMap;
        } else if (!(obj instanceof Bundle)) {
            return linkedHashMap;
        } else {
            Bundle bundle = (Bundle) obj;
            for (String str : bundle.keySet()) {
                Object obj2 = bundle.get(str);
                if (obj2 instanceof Boolean) {
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    linkedHashMap.put(str, ((Boolean) obj2).booleanValue() ? Boolean.TRUE : Boolean.FALSE);
                } else {
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    linkedHashMap.put(str, obj2);
                }
            }
            return linkedHashMap;
        }
    }

    private final void reportSearch() {
        String str;
        Intent intent = getIntent();
        if (intent != null && Intrinsics.areEqual((Object) this.path, (Object) "/netdisk/search")) {
            String stringExtra = intent.getStringExtra(UBCManager.CONTENT_KEY_SOURCE);
            if (stringExtra != null) {
                int hashCode = stringExtra.hashCode();
                if (hashCode != -2027574035) {
                    if (hashCode == 110363525 && stringExtra.equals("tiles")) {
                        str = "tiles_search";
                        if (str == null) {
                        }
                    }
                } else if (stringExtra.equals("shortcuts")) {
                    str = "shortcut_search";
                    if (str == null) {
                    }
                }
            }
            str = null;
            if (str == null) {
            }
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @NotNull
    public FlutterActivityLaunchConfigs.BackgroundMode getBackgroundMode() {
        return FlutterActivityLaunchConfigs.BackgroundMode.transparent;
    }

    @Nullable
    public final String getParam() {
        return this.param;
    }

    @Nullable
    public final String getPath() {
        return this.path;
    }

    @Nullable
    public Fragment initFragment() {
        String str = this.path;
        if (str == null) {
            finish();
            return null;
        }
        Map<String, Object> buinessParams = getBuinessParams();
        try {
            String str2 = this.param;
            if (str2 != null) {
                buinessParams.putAll(qw.ad(new JSONObject(Uri.decode(this.param))));
            } else {
                str2 = null;
            }
            ExpectKt.success(str2);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        Fragment qw = ad.qw(str, buinessParams);
        beginTransaction.replace((int) R.id.content, qw, "com.tera.scan.flutter.ui.FlutterBusinessActivity");
        beginTransaction.commitAllowingStateLoss();
        return qw;
    }

    public void onCreate(@Nullable Bundle bundle) {
        String str = this.path;
        boolean z = false;
        if (str != null) {
            if (!(str.length() == 0)) {
                z = true;
            }
        }
        if (!z) {
            this.path = getIntent().getStringExtra("extra_path");
        }
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        reportSearch();
    }

    public void onPause() {
        try {
            Object systemService = getSystemService("input_method");
            InputMethodManager inputMethodManager = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
            ExpectKt.success(inputMethodManager != null ? Boolean.valueOf(inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getApplicationWindowToken(), 0)) : null);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public final void setParam(@Nullable String str) {
        this.param = str;
    }

    public final void setPath(@Nullable String str) {
        this.path = str;
    }
}
