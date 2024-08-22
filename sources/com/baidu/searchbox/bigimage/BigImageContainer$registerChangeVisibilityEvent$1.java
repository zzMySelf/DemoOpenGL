package com.baidu.searchbox.bigimage;

import android.util.Log;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bigimage.event.ChangeVisibilityEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/bigimage/BigImageContainer$registerChangeVisibilityEvent$1", "Lcom/baidu/searchbox/bdeventbus/Action;", "Lcom/baidu/searchbox/bigimage/event/ChangeVisibilityEvent;", "call", "", "type", "lib-bigimage-bee-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageContainer.kt */
public final class BigImageContainer$registerChangeVisibilityEvent$1 implements Action<ChangeVisibilityEvent> {
    final /* synthetic */ BigImageContainer this$0;

    BigImageContainer$registerChangeVisibilityEvent$1(BigImageContainer $receiver) {
        this.this$0 = $receiver;
    }

    public void call(ChangeVisibilityEvent type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual((Object) type.getToken(), (Object) this.this$0.token)) {
            if (BigImageContainerKt.DEBUG) {
                Log.d("BigImageContainer", "change visibility = " + type.isVisible());
            }
            this.this$0.rootView().setVisibility(type.isVisible() ? 0 : 8);
        }
    }
}
