package com.baidu.searchbox.download.center.ui.fusion.template;

import android.view.View;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.download.center.clearcache.ClearCacheDataChangeEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/download/center/ui/fusion/template/ClassificationTemplate$createView$8", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/download/center/clearcache/ClearCacheDataChangeEvent;", "call", "", "type", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassificationTemplate.kt */
public final class ClassificationTemplate$createView$8 implements Action<ClearCacheDataChangeEvent> {
    final /* synthetic */ ClassificationTemplate this$0;

    ClassificationTemplate$createView$8(ClassificationTemplate $receiver) {
        this.this$0 = $receiver;
    }

    public void call(ClearCacheDataChangeEvent type) {
        Intrinsics.checkNotNullParameter(type, "type");
        ClassificationTemplate classificationTemplate = this.this$0;
        View access$getMRootView$p = classificationTemplate.mRootView;
        if (access$getMRootView$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            access$getMRootView$p = null;
        }
        classificationTemplate.updateGarbageView(access$getMRootView$p);
        this.this$0.updateSpaceView();
    }
}
