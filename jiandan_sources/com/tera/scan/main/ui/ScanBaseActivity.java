package com.tera.scan.main.ui;

import android.os.Bundle;
import android.view.View;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;
import fe.mmm.qw.f.fe.ad.ad;
import fe.mmm.qw.xxx.when.th;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, d2 = {"Lcom/tera/scan/main/ui/ScanBaseActivity;", "Lcom/tera/scan/framework/BaseActivity;", "Lcom/tera/scan/ui/widget/titlebar/ICommonTitleBarClickListener;", "()V", "backLayoutVisible", "", "isBlackStatusText", "middleTitle", "", "needSetStatusBar", "onBackButtonClicked", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRightButtonClicked", "view", "Landroid/view/View;", "setDarkStatusBar", "setLightStatusBar", "setRightLayoutVisible", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class ScanBaseActivity extends BaseActivity implements ICommonTitleBarClickListener {
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

    public boolean backLayoutVisible() {
        return true;
    }

    public boolean isBlackStatusText() {
        return true;
    }

    @NotNull
    public String middleTitle() {
        return "";
    }

    public boolean needSetStatusBar() {
        return false;
    }

    public void onBackButtonClicked() {
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        th.qw(this);
        ad adVar = new ad(this);
        this.mTitleBar = adVar;
        adVar.when(middleTitle());
        this.mTitleBar.o(backLayoutVisible());
        this.mTitleBar.xxx(setRightLayoutVisible());
        this.mTitleBar.mmm(fe.mmm.qw.th.qw.th.th.ad(this));
        this.mTitleBar.aaa(this);
        if (isBlackStatusText()) {
            setLightStatusBar();
        }
    }

    public void onRightButtonClicked(@Nullable View view) {
    }

    public final void setDarkStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility((getWindow().getDecorView().getSystemUiVisibility() | 8192) ^ 8192);
    }

    public final void setLightStatusBar() {
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 8192);
    }

    public boolean setRightLayoutVisible() {
        return false;
    }
}
