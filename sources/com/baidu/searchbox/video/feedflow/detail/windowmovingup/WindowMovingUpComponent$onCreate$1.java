package com.baidu.searchbox.video.feedflow.detail.windowmovingup;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "ev", "Landroid/view/MotionEvent;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowMovingUpComponent.kt */
final class WindowMovingUpComponent$onCreate$1 extends Lambda implements Function1<MotionEvent, Unit> {
    final /* synthetic */ WindowMovingUpComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowMovingUpComponent$onCreate$1(WindowMovingUpComponent windowMovingUpComponent) {
        super(1);
        this.this$0 = windowMovingUpComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((MotionEvent) p1);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(android.view.MotionEvent r8) {
        /*
            r7 = this;
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r0 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r0.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x002d
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0015
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0016
        L_0x0015:
            r3 = r1
        L_0x0016:
            if (r3 == 0) goto L_0x001f
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState> r4 = com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0020
        L_0x001f:
            r3 = r1
        L_0x0020:
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState r3 = (com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState) r3
            if (r3 == 0) goto L_0x002d
            boolean r0 = r3.getWindowMovingUpShowing()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L_0x003a
            int r4 = r8.getAction()
            if (r4 != 0) goto L_0x003a
            r4 = r3
            goto L_0x003b
        L_0x003a:
            r4 = r2
        L_0x003b:
            if (r4 == 0) goto L_0x0058
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r4 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r4 = r4.getStore()
            boolean r4 = com.baidu.searchbox.video.feedflow.common.CommonStateExtKt.isActive(r4)
            if (r4 == 0) goto L_0x0058
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r4 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r4 = r4.getStore()
            if (r4 == 0) goto L_0x0058
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction$DownAction r5 = com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction.DownAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            r4.dispatch(r5)
        L_0x0058:
            if (r8 == 0) goto L_0x0061
            int r4 = r8.getAction()
            if (r4 != 0) goto L_0x0061
            r2 = r3
        L_0x0061:
            if (r2 == 0) goto L_0x00c4
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r2 = r7.this$0
            boolean r2 = r2.isTouchInView(r8)
            if (r2 != 0) goto L_0x00c4
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x00c4
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r2 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x0094
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r2.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0089
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x008a
        L_0x0089:
            r5 = r1
        L_0x008a:
            if (r5 == 0) goto L_0x0092
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState> r1 = com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState.class
            java.lang.Object r1 = r5.select(r1)
        L_0x0092:
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState r1 = (com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpState) r1
        L_0x0094:
            if (r1 != 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r1.setTouchActionFromWindowUp(r3)
        L_0x009a:
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r1 = r7.this$0
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpView r1 = r1.getWindowMovingUpView()
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r2 = r7.this$0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r2.getManager()
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r4 = r7.this$0
            int r4 = r4.getShowHeight()
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r5 = r7.this$0
            boolean r5 = r5.isMiniVideo()
            r1.hideViewWithAnim(r3, r2, r4, r5)
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r1 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r1 = r1.getStore()
            if (r1 == 0) goto L_0x00c4
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction$WindowMovingUpHideByClickOutside r2 = com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction.WindowMovingUpHideByClickOutside.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent$onCreate$1.invoke(android.view.MotionEvent):void");
    }
}
