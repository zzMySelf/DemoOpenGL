package com.baidu.searchbox.video.feedflow.detail.sandwich;

import com.baidu.searchbox.video.feedflow.detail.player.SimplePlayerComponentListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/sandwich/SandwichPortraitTimePlugin$playerListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/sandwich/SandwichPortraitTimePlugin$playerListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SandwichPortraitTimePlugin.kt */
final class SandwichPortraitTimePlugin$playerListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ SandwichPortraitTimePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SandwichPortraitTimePlugin$playerListener$2(SandwichPortraitTimePlugin sandwichPortraitTimePlugin) {
        super(0);
        this.this$0 = sandwichPortraitTimePlugin;
    }

    public final AnonymousClass1 invoke() {
        final SandwichPortraitTimePlugin sandwichPortraitTimePlugin = this.this$0;
        return new SimplePlayerComponentListener() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onResume() {
                /*
                    r5 = this;
                    com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimePlugin r0 = r1
                    com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
                    r1 = 0
                    if (r0 == 0) goto L_0x0020
                    r2 = 0
                    com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
                    boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
                    if (r4 == 0) goto L_0x0015
                    com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
                    goto L_0x0016
                L_0x0015:
                    r3 = r1
                L_0x0016:
                    if (r3 == 0) goto L_0x001e
                    java.lang.Class<com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState> r1 = com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState.class
                    java.lang.Object r1 = r3.select(r1)
                L_0x001e:
                    com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState r1 = (com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimeState) r1
                L_0x0020:
                    if (r1 != 0) goto L_0x0023
                    goto L_0x002a
                L_0x0023:
                    long r2 = java.lang.System.currentTimeMillis()
                    r1.setLastUpdateTime(r2)
                L_0x002a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.sandwich.SandwichPortraitTimePlugin$playerListener$2.AnonymousClass1.onResume():void");
            }

            public void onPause() {
                sandwichPortraitTimePlugin.updatePlayTime();
            }
        };
    }
}
