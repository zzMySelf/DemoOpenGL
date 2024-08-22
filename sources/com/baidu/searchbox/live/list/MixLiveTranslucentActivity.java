package com.baidu.searchbox.live.list;

import android.os.Bundle;
import android.view.View;
import com.baidu.live.arch.ServiceLocator;
import com.baidu.searchbox.live.service.MixNotifyBackgroundService;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/live/list/MixLiveTranslucentActivity;", "Lcom/baidu/searchbox/live/list/MixLiveActivity;", "()V", "finish", "", "finishByNotifyWithNoAnim", "getCaptureBgColor", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "overrideEnterAnim", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MixLiveTranslucentActivity.kt */
public final class MixLiveTranslucentActivity extends MixLiveActivity {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view2 = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceLocator.Companion.registerGlobalServices(MixNotifyBackgroundService.class, new MixLiveTranslucentActivity$onCreate$1(this));
    }

    public final void finishByNotifyWithNoAnim() {
        super.finish();
        overridePendingTransition(0, 0);
        ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
    }

    public void finish() {
        super.finish();
        ServiceLocator.Companion.unregisterGlobalService(MixNotifyBackgroundService.class);
    }

    public void overrideEnterAnim() {
        if (getIntent().getBooleanExtra("enterWithAnimation", false)) {
            super.overrideEnterAnim();
        } else {
            overridePendingTransition(0, 0);
        }
    }

    public int getCaptureBgColor() {
        if (getIntent().getBooleanExtra("enterWithAnimation", false)) {
            return -16777216;
        }
        return 0;
    }
}
