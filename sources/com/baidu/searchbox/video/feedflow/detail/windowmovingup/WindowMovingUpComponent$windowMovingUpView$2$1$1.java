package com.baidu.searchbox.video.feedflow.detail.windowmovingup;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/video/feedflow/detail/windowmovingup/WindowMovingUpView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WindowMovingUpComponent.kt */
final class WindowMovingUpComponent$windowMovingUpView$2$1$1 extends Lambda implements Function1<WindowMovingUpView, Unit> {
    final /* synthetic */ WindowMovingUpView $this_apply;
    final /* synthetic */ WindowMovingUpComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowMovingUpComponent$windowMovingUpView$2$1$1(WindowMovingUpView windowMovingUpView, WindowMovingUpComponent windowMovingUpComponent) {
        super(1);
        this.$this_apply = windowMovingUpView;
        this.this$0 = windowMovingUpComponent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((WindowMovingUpView) p1);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpView r8) {
        /*
            r7 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpView r0 = r7.$this_apply
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r1 = r7.this$0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r1 = r1.getManager()
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r2 = r7.this$0
            int r2 = r2.getShowHeight()
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r3 = r7.this$0
            boolean r3 = r3.isMiniVideo()
            r4 = 1
            r0.hideViewWithAnim(r4, r1, r2, r3)
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r0 = r7.this$0
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r0.getManager()
            r1 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r2 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r0 = r0.getService(r2)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r0 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r0
            r1 = 0
            if (r0 == 0) goto L_0x0034
            java.util.List r0 = r0.getDataSource()
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r2 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r2.getStore()
            if (r2 == 0) goto L_0x0063
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r2.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0049
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x004a
        L_0x0049:
            r5 = r1
        L_0x004a:
            if (r5 == 0) goto L_0x0053
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r6 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0054
        L_0x0053:
            r5 = r1
        L_0x0054:
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x0063
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r5.getRunTimeStatus()
            if (r2 == 0) goto L_0x0063
            int r2 = r2.getPosition()
            goto L_0x0064
        L_0x0063:
            r2 = -1
        L_0x0064:
            if (r2 < 0) goto L_0x009c
            int r3 = r2 + 1
            if (r0 == 0) goto L_0x006f
            int r5 = r0.size()
            goto L_0x0070
        L_0x006f:
            r5 = 0
        L_0x0070:
            if (r3 < r5) goto L_0x0073
            goto L_0x009c
        L_0x0073:
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent r3 = r7.this$0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r3.getStore()
            if (r3 == 0) goto L_0x0085
            com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction$WindowMovingUpClickAction r5 = new com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction$WindowMovingUpClickAction
            r5.<init>(r2)
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r3, r5)
        L_0x0085:
            if (r0 == 0) goto L_0x0095
            int r3 = r2 + 1
            java.lang.Object r3 = r0.get(r3)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r3 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r3
            if (r3 == 0) goto L_0x0095
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r1 = r3.getRunTimeStatus()
        L_0x0095:
            if (r1 != 0) goto L_0x0098
            goto L_0x009b
        L_0x0098:
            r1.setWindowMovingUpState(r4)
        L_0x009b:
            return
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpComponent$windowMovingUpView$2$1$1.invoke(com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpView):void");
    }
}
