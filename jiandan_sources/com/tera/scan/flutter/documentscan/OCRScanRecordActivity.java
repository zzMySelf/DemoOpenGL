package com.tera.scan.flutter.documentscan;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.baidu.aiscan.R;
import com.idlefish.flutterboost.containers.FlutterBoostFragment;
import com.tera.scan.flutter.ui.FlutterBaseActivity;
import io.flutter.embedding.android.TransparencyMode;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/tera/scan/flutter/documentscan/OCRScanRecordActivity;", "Lcom/tera/scan/flutter/ui/FlutterBaseActivity;", "()V", "initFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "lib-flutter_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OCRScanRecordActivity extends FlutterBaseActivity {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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
    public Fragment initFragment() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("from", getIntent().getStringExtra("from"));
        linkedHashMap.put(OCRRectifyActivity.EXTRA_SAVE_PATH, getIntent().getStringExtra(OCRRectifyActivity.EXTRA_SAVE_PATH));
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "supportFragmentManager.beginTransaction()");
        FlutterBoostFragment.qw qwVar = new FlutterBoostFragment.qw(FlutterBoostFragment.class);
        qwVar.th("/netdisk/doc_scan_list");
        qwVar.yj(linkedHashMap);
        qwVar.de(false);
        qwVar.fe(true);
        qwVar.rg(TransparencyMode.opaque);
        FlutterBoostFragment qw = qwVar.qw();
        beginTransaction.replace((int) R.id.content, (Fragment) qw, "com.tera.scan.flutter.documentscan.OCRScanRecordActivity");
        beginTransaction.commitAllowingStateLoss();
        Intrinsics.checkNotNullExpressionValue(qw, "fragment");
        return qw;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }
}
