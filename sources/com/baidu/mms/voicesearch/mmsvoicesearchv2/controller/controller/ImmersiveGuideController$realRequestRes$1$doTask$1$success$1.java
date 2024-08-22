package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller;

import com.baidu.ttsplugin.google.gson.JsonObject;
import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/controller/controller/ImmersiveGuideController$realRequestRes$1$doTask$1$success$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImmersiveGuideController.kt */
public final class ImmersiveGuideController$realRequestRes$1$doTask$1$success$1 extends NormalTask {
    final /* synthetic */ JsonObject $resourceJson;
    final /* synthetic */ ImmersiveGuideController this$0;

    ImmersiveGuideController$realRequestRes$1$doTask$1$success$1(ImmersiveGuideController $receiver, JsonObject $resourceJson2) {
        this.this$0 = $receiver;
        this.$resourceJson = $resourceJson2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doTask() {
        /*
            r8 = this;
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r0 = r8.this$0
            com.baidu.ttsplugin.google.gson.JsonObject r1 = r8.$resourceJson
            com.baidu.mms.voicesearch.voice.bean.dao.BubbleGuideModel r0 = r0.processGuideTips(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.lang.String r2 = r0.getBubbleType()
            goto L_0x0011
        L_0x0010:
            r2 = r1
        L_0x0011:
            java.lang.String r3 = "assistant_weak_guide"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0022
            if (r0 != 0) goto L_0x001c
            goto L_0x0022
        L_0x001c:
            java.lang.String r2 = "切换"
            r0.setBtnText(r2)
        L_0x0022:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r2 = r8.this$0
            boolean r2 = r2.isFromIme
            java.lang.String r3 = "no_permission_guide"
            r4 = 0
            if (r2 != 0) goto L_0x00bf
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController$Companion r2 = com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController.Companion
            boolean r2 = r2.isVoiceAssistantDefault()
            if (r2 != 0) goto L_0x00bf
            boolean r2 = com.baidu.mms.voicesearch.voice.utils.GlobalConstant.canShowAfx
            if (r2 != 0) goto L_0x003b
            goto L_0x00bf
        L_0x003b:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r2 = r8.this$0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive.VoiceImmersiveSmallUpScreenRootView r2 = r2.mRootView
            if (r2 == 0) goto L_0x0048
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.AiAssistantView r2 = r2.getAssistantView()
            goto L_0x0049
        L_0x0048:
            r2 = r1
        L_0x0049:
            r5 = 1
            if (r2 == 0) goto L_0x0080
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r2 = r8.this$0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive.VoiceImmersiveSmallUpScreenRootView r2 = r2.mRootView
            if (r2 == 0) goto L_0x0062
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.AiAssistantView r2 = r2.getAssistantView()
            if (r2 == 0) goto L_0x0062
            int r2 = r2.getVisibility()
            if (r2 != 0) goto L_0x0062
            r2 = r5
            goto L_0x0063
        L_0x0062:
            r2 = r4
        L_0x0063:
            if (r2 == 0) goto L_0x0080
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r2 = r8.this$0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive.VoiceImmersiveSmallUpScreenRootView r2 = r2.mRootView
            if (r2 == 0) goto L_0x007b
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.AiAssistantView r2 = r2.getAssistantView()
            if (r2 == 0) goto L_0x007b
            boolean r2 = r2.isPlaying()
            if (r2 != r5) goto L_0x007b
            r2 = r5
            goto L_0x007c
        L_0x007b:
            r2 = r4
        L_0x007c:
            if (r2 == 0) goto L_0x0080
            r2 = r5
            goto L_0x0081
        L_0x0080:
            r2 = r4
        L_0x0081:
            if (r2 != 0) goto L_0x0096
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.guideModelCache = r0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            java.lang.String r1 = r1.TAG
            java.lang.String r3 = "缓存起来稍后展示"
            android.util.Log.d(r1, r3)
            goto L_0x00d7
        L_0x0096:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r6 = r8.this$0
            java.lang.String r6 = r6.TAG
            java.lang.String r7 = "有人物且满足展示条件直接展示"
            android.util.Log.d(r6, r7)
            if (r0 == 0) goto L_0x00a8
            java.lang.String r1 = r0.getBubbleUiType()
        L_0x00a8:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x00b4
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.showNoPermissionGuide(r0, r4)
            goto L_0x00b9
        L_0x00b4:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.showNewGuide(r0)
        L_0x00b9:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.hasGuideShown = r5
            goto L_0x00d7
        L_0x00bf:
            if (r0 == 0) goto L_0x00c6
            java.lang.String r1 = r0.getBubbleUiType()
        L_0x00c6:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x00d2
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.showNoPermissionGuide(r0, r4)
            goto L_0x00d7
        L_0x00d2:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            r1.showNewGuide(r0)
        L_0x00d7:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive.VoiceImmersiveSmallUpScreenRootView r1 = r1.mRootView
            if (r1 == 0) goto L_0x00ff
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            boolean r1 = r1.isFromIme
            if (r1 != 0) goto L_0x00ff
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.immersive.VoiceImmersiveSmallUpScreenRootView r1 = r1.mRootView
            if (r1 == 0) goto L_0x00f4
            com.baidu.ttsplugin.google.gson.JsonObject r2 = r8.$resourceJson
            r1.setSugData(r2)
        L_0x00f4:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController r1 = r8.this$0
            com.baidu.ttsplugin.google.gson.JsonObject r2 = r8.$resourceJson
            com.baidu.mms.voicesearch.voice.bean.dao.SilenceGuideModel r2 = r1.processSilenceGuide(r2)
            r1.silenceGuideCache = r2
        L_0x00ff:
            boolean r1 = super.doTask()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.ImmersiveGuideController$realRequestRes$1$doTask$1$success$1.doTask():boolean");
    }
}
