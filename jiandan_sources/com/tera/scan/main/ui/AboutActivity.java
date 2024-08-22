package com.tera.scan.main.ui;

import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import com.tera.scan.permission.util.NotificationPermissionHelper;
import com.tera.scan.ui.view.layout.UILinearLayout;
import fe.mmm.qw.xxx.p032if.qw.o;
import fe.mmm.qw.xxx.pf.de;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016J-\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/tera/scan/main/ui/AboutActivity;", "Lcom/tera/scan/main/ui/ScanBaseActivity;", "()V", "getLayoutId", "", "initView", "", "middleTitle", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AboutActivity extends ScanBaseActivity {
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
        return R.layout.activity_about;
    }

    public void initView() {
        List<ISettingItem> ad2 = o.qw.ad();
        int i2 = 0;
        for (T next : ad2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ISettingItem iSettingItem = (ISettingItem) next;
            UILinearLayout uILinearLayout = (UILinearLayout) _$_findCachedViewById(R.id.item_container);
            SettingItemView settingItemView = new SettingItemView(this, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
            settingItemView.setTitle(iSettingItem.name());
            settingItemView.dividerVisible(o.qw.de() && i2 != CollectionsKt__CollectionsKt.getLastIndex(ad2));
            iSettingItem.th(settingItemView);
            uILinearLayout.addView(settingItemView, new ViewGroup.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.dimen_50dp)));
            i2 = i3;
        }
        ((TextView) _$_findCachedViewById(R.id.tv_bottom_tip)).setText(o.qw.qw(this));
        de.fe("PCntrAbt", "PCntr", (String) null, (Map) null, 12, (Object) null);
    }

    @NotNull
    public String middleTitle() {
        String string = getString(R.string.about_us);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.about_us)");
        return string;
    }

    public void onRequestPermissionsResult(int i2, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        NotificationPermissionHelper.qw(this, i2, strArr, iArr);
    }
}
