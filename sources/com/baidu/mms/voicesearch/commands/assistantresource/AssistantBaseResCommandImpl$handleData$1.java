package com.baidu.mms.voicesearch.commands.assistantresource;

import com.baidu.searchbox.launch.IdleLaunchTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/commands/assistantresource/AssistantBaseResCommandImpl$handleData$1", "Lcom/baidu/searchbox/launch/IdleLaunchTask;", "execute", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantBaseResCommandImpl.kt */
public final class AssistantBaseResCommandImpl$handleData$1 extends IdleLaunchTask {
    final /* synthetic */ AssistantBaseResCommandImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssistantBaseResCommandImpl$handleData$1(AssistantBaseResCommandImpl $receiver, String $super_call_param$1) {
        super($super_call_param$1, 1);
        this.this$0 = $receiver;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute() {
        /*
            r9 = this;
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController r0 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.INSTANCE     // Catch:{ Exception -> 0x00d0 }
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataModel r0 = r0.getNewAssistantBaseData()     // Catch:{ Exception -> 0x00d0 }
            r1 = 0
            if (r0 == 0) goto L_0x000f
            java.util.ArrayList r2 = r0.getResArray()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0010
        L_0x000f:
            r2 = r1
        L_0x0010:
            if (r2 == 0) goto L_0x00ce
            java.util.ArrayList r2 = r0.getResArray()     // Catch:{ Exception -> 0x00d0 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x00d0 }
            if (r2 != 0) goto L_0x001e
            goto L_0x00ce
        L_0x001e:
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController$Companion r2 = com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController.Companion     // Catch:{ Exception -> 0x00d0 }
            int r2 = r2.getVoiceAssistantType()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x00d0 }
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController$Companion r3 = com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController.Companion     // Catch:{ Exception -> 0x00d0 }
            boolean r3 = r3.canAutoChangeDuxiaoxiao()     // Catch:{ Exception -> 0x00d0 }
            if (r3 == 0) goto L_0x005d
            java.util.ArrayList r3 = r0.getResArray()     // Catch:{ Exception -> 0x00d0 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ Exception -> 0x00d0 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00d0 }
        L_0x003b:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00d0 }
            if (r4 == 0) goto L_0x005a
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00d0 }
            r5 = r4
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem r5 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem) r5     // Catch:{ Exception -> 0x00d0 }
            r6 = 0
            if (r5 == 0) goto L_0x0050
            java.lang.String r7 = r5.getId()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0051
        L_0x0050:
            r7 = r1
        L_0x0051:
            java.lang.String r8 = "1"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x003b
            r1 = r4
        L_0x005a:
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem r1 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem) r1     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0087
        L_0x005d:
            java.util.ArrayList r3 = r0.getResArray()     // Catch:{ Exception -> 0x00d0 }
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ Exception -> 0x00d0 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00d0 }
        L_0x0068:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00d0 }
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00d0 }
            r5 = r4
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem r5 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem) r5     // Catch:{ Exception -> 0x00d0 }
            r6 = 0
            if (r5 == 0) goto L_0x007d
            java.lang.String r7 = r5.getId()     // Catch:{ Exception -> 0x00d0 }
            goto L_0x007e
        L_0x007d:
            r7 = r1
        L_0x007e:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r2)     // Catch:{ Exception -> 0x00d0 }
            if (r7 == 0) goto L_0x0068
            r1 = r4
        L_0x0085:
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem r1 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantBaseDataItem) r1     // Catch:{ Exception -> 0x00d0 }
        L_0x0087:
            if (r1 != 0) goto L_0x008b
            return
        L_0x008b:
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl$Companion r3 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl.Companion     // Catch:{ Exception -> 0x00d0 }
            boolean r3 = r3.getHasTryDelete()     // Catch:{ Exception -> 0x00d0 }
            if (r3 != 0) goto L_0x00a5
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController r3 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.INSTANCE     // Catch:{ Exception -> 0x00d0 }
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController r4 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.INSTANCE     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r4 = r4.getDownloadedBaseVersion(r2)     // Catch:{ Exception -> 0x00d0 }
            r3.deleteOldFiles(r2, r4)     // Catch:{ Exception -> 0x00d0 }
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl$Companion r3 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl.Companion     // Catch:{ Exception -> 0x00d0 }
            r4 = 1
            r3.setHasTryDelete(r4)     // Catch:{ Exception -> 0x00d0 }
        L_0x00a5:
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController r3 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.INSTANCE     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r3 = r3.getDownloadedBaseVersion(r2)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r4 = r1.getVersion()     // Catch:{ Exception -> 0x00d0 }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)     // Catch:{ Exception -> 0x00d0 }
            if (r3 != 0) goto L_0x00bf
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController r3 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.INSTANCE     // Catch:{ Exception -> 0x00d0 }
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r4 = r1
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResController.startDownloadRes$default(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00d0 }
        L_0x00bf:
            com.baidu.voicesearch.component.utils.TaskDispatcher r3 = com.baidu.voicesearch.component.utils.TaskDispatcher.getSharedInstance()     // Catch:{ Exception -> 0x00d0 }
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl$handleData$1$execute$1 r4 = new com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl$handleData$1$execute$1     // Catch:{ Exception -> 0x00d0 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x00d0 }
            com.baidu.voicesearch.component.utils.Task r4 = (com.baidu.voicesearch.component.utils.Task) r4     // Catch:{ Exception -> 0x00d0 }
            r3.addToAsyncWorkingLoop(r4)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00d2
        L_0x00ce:
            return
        L_0x00d0:
            r0 = move-exception
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mms.voicesearch.commands.assistantresource.AssistantBaseResCommandImpl$handleData$1.execute():void");
    }
}
