package com.tera.scan.main.ui;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.aiscan.R;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import com.tera.scan.ui.view.layout.UIFrameLayout;
import com.tera.scan.ui.view.layout.UILinearLayout;
import fe.mmm.qw.ggg.qw;
import fe.mmm.qw.xxx.p032if.rg.th;
import fe.mmm.qw.xxx.pf.de;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\b\u0010\u000b\u001a\u00020\u0006H\u0014¨\u0006\f"}, d2 = {"Lcom/tera/scan/main/ui/SettingActivity;", "Lcom/tera/scan/main/ui/ScanBaseActivity;", "()V", "getLayoutId", "", "initView", "", "middleTitle", "", "onDestroy", "onPause", "onResume", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SettingActivity extends ScanBaseActivity {
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

    public int getLayoutId() {
        return R.layout.activity_setting;
    }

    public void initView() {
        List<ISettingItem> qw = th.qw.qw();
        int i2 = 0;
        for (T next : qw) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ISettingItem iSettingItem = (ISettingItem) next;
            if (Intrinsics.areEqual((Object) iSettingItem.name(), (Object) getString(R.string.logout))) {
                SettingItemView settingItemView = new SettingItemView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                settingItemView.setTitle(iSettingItem.name());
                iSettingItem.th(settingItemView);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.dimen_48dp));
                int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_15dp);
                layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, getResources().getDimensionPixelSize(R.dimen.dimen_20dp));
                layoutParams.gravity = 80;
                Unit unit = Unit.INSTANCE;
                ((UIFrameLayout) _$_findCachedViewById(R.id.root)).addView(settingItemView, layoutParams);
            } else {
                UILinearLayout uILinearLayout = (UILinearLayout) _$_findCachedViewById(R.id.item_container);
                SettingItemView settingItemView2 = new SettingItemView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
                settingItemView2.setTitle(iSettingItem.name());
                String rg2 = iSettingItem.rg();
                if (rg2 != null) {
                    settingItemView2.setTips(rg2);
                }
                settingItemView2.dividerVisible(i2 != CollectionsKt__CollectionsKt.getLastIndex(qw));
                iSettingItem.th(settingItemView2);
                uILinearLayout.addView(settingItemView2, new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.dimen_50dp)));
            }
            i2 = i3;
        }
        de.fe("PCntrSet", "PCntr", (String) null, (Map) null, 12, (Object) null);
    }

    @NotNull
    public String middleTitle() {
        String string = getString(R.string.settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.settings)");
        return string;
    }

    public void onDestroy() {
        super.onDestroy();
        for (ISettingItem onDestroy : th.qw.qw()) {
            onDestroy.onDestroy();
        }
    }

    public void onPause() {
        super.onPause();
        for (ISettingItem onPause : th.qw.qw()) {
            onPause.onPause();
        }
    }

    public void onResume() {
        super.onResume();
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "sidebar_settings_show", (List) null, 2, (Object) null);
        for (ISettingItem onResume : th.qw.qw()) {
            onResume.onResume();
        }
    }
}
