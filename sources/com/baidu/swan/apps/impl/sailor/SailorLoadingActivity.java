package com.baidu.swan.apps.impl.sailor;

import android.os.Bundle;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.swan.apps.impl.R;
import com.baidu.swan.apps.runtime.EventSubscriber;
import com.baidu.swan.apps.runtime.Swan;
import com.baidu.swan.apps.runtime.SwanEvent;
import com.baidu.swan.apps.util.SwanAppUIUtils;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.apps.util.typedbox.TypedMapping;

public class SailorLoadingActivity extends SwanAppBaseActivity implements TypedCallback<SwanEvent.Impl> {
    private final EventSubscriber mEventSubscriber = new EventSubscriber();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (checkSailorIsInstalled()) {
            finish();
            return;
        }
        SwanAppUIUtils.applyDefaultImmersion(this);
        setContentView(R.layout.activity_sailor_install);
        initEventHandler();
    }

    private void initEventHandler() {
        Swan.get().addEventCallback(this.mEventSubscriber);
        this.mEventSubscriber.addEventFilter(new TypedMapping<SwanEvent.Impl, Boolean>() {
            public Boolean map(SwanEvent.Impl k) {
                return Boolean.valueOf(!SailorLoadingActivity.this.isDestroyed());
            }
        }).subscribe(this, "event_launch_swan");
    }

    private boolean checkSailorIsInstalled() {
        return SailorLoadingHelper.getInstance().shouldStopLoading();
    }

    public void onBackPressed() {
        super.onBackPressed();
        SailorLoadingHelper.getInstance().onCancelLoading();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Swan.get().delEventCallback(this.mEventSubscriber);
        super.onDestroy();
    }

    public void onCallback(SwanEvent.Impl msg) {
        finish();
    }
}
