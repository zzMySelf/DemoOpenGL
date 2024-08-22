package com.baidu.searchbox.interaction.encourage.manager;

import com.baidu.searchbox.appframework.SimpleActivityLifeCycle;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/interaction/encourage/manager/EasterEggManager$simpleLifeCycle$1", "Lcom/baidu/searchbox/appframework/SimpleActivityLifeCycle;", "onActivityDestroyed", "", "activity", "Landroid/app/Activity;", "lib-interaction-encourage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EasterEggManager.kt */
public final class EasterEggManager$simpleLifeCycle$1 extends SimpleActivityLifeCycle {
    final /* synthetic */ EasterEggManager this$0;

    EasterEggManager$simpleLifeCycle$1(EasterEggManager $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getContentView();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityDestroyed(android.app.Activity r4) {
        /*
            r3 = this;
            com.baidu.searchbox.interaction.encourage.manager.EasterEggManager r0 = r3.this$0
            android.widget.PopupWindow r0 = r0.container
            r1 = 0
            if (r0 == 0) goto L_0x0014
            android.view.View r0 = r0.getContentView()
            if (r0 == 0) goto L_0x0014
            android.content.Context r0 = r0.getContext()
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            boolean r2 = r0 instanceof android.app.Activity
            if (r2 == 0) goto L_0x001c
            r1 = r0
            android.app.Activity r1 = (android.app.Activity) r1
        L_0x001c:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0027
            com.baidu.searchbox.interaction.encourage.manager.EasterEggManager r0 = r3.this$0
            r0.dismissContainer(r4)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.interaction.encourage.manager.EasterEggManager$simpleLifeCycle$1.onActivityDestroyed(android.app.Activity):void");
    }
}
