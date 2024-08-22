package com.baidu.searchbox.ugc.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.ugc.R;
import com.baidu.searchbox.ugc.handler.UgcASyncPublishHandler;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.view.UgcOutboxView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0014J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/ugc/activity/UgcOutboxActivity;", "Lcom/baidu/searchbox/appframework/BaseActivity;", "()V", "rootView", "Lcom/baidu/searchbox/ugc/view/UgcOutboxView;", "finish", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcOutboxActivity.kt */
public final class UgcOutboxActivity extends BaseActivity {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private UgcOutboxView rootView;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ugc_outbox_layout);
        UgcOutboxView ugcOutboxView = (UgcOutboxView) findViewById(R.id.ugc_outbox_view);
        this.rootView = ugcOutboxView;
        if (ugcOutboxView != null) {
            ugcOutboxView.setUgcOutboxViewListener(new UgcOutboxActivity$onCreate$1(this));
        }
        UgcOutboxView ugcOutboxView2 = this.rootView;
        if (ugcOutboxView2 != null) {
            ugcOutboxView2.showBottomBack();
        }
        UgcASyncPublishHandler.INSTANCE.setShowInOutboxActivity(true);
        UgcUBCUtils.ugcAsyncUploadOutboxShowStatistics(UgcUBCUtils.UGC_ASYNC_UPLOAD_OUTBOX_SHOW_TYPE_FULL);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.ugc_slide_right_out);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        UgcASyncPublishHandler.INSTANCE.setShowInOutboxActivity(false);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        UgcOutboxView ugcOutboxView = this.rootView;
        if (ugcOutboxView != null) {
            ugcOutboxView.refresh();
        }
    }
}
