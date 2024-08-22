package com.baidu.mms.voicesearch.commands.assistantresource;

import com.baidu.searchbox.launch.IdleLaunchTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/commands/assistantresource/AssistantOperateResCommandImp$handleData$1", "Lcom/baidu/searchbox/launch/IdleLaunchTask;", "execute", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantOperateResCommandImp.kt */
public final class AssistantOperateResCommandImp$handleData$1 extends IdleLaunchTask {
    final /* synthetic */ AssistantOperateResCommandImp this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssistantOperateResCommandImp$handleData$1(AssistantOperateResCommandImp $receiver, String $super_call_param$1) {
        super($super_call_param$1, 1);
        this.this$0 = $receiver;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute() {
        /*
            r11 = this;
            com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController$Companion r0 = com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.controller.VoiceAssistantController.Companion     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            int r0 = r0.getVoiceAssistantType()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController r1 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController.INSTANCE     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataModel r1 = r1.getLocalCloudData()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            java.util.ArrayList r2 = r1.getResArray()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r2 != 0) goto L_0x001d
            return
        L_0x001d:
            java.util.ArrayList r2 = r1.getResArray()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.Iterable r2 = (java.lang.Iterable) r2     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
        L_0x0027:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r4 = 0
            if (r3 == 0) goto L_0x0043
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r5 = r3
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem r5 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem) r5     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r6 = 0
            if (r5 == 0) goto L_0x003c
            java.lang.String r4 = r5.getId()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
        L_0x003c:
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r4 == 0) goto L_0x0027
            r4 = r3
        L_0x0043:
            r6 = r4
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem r6 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem) r6     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r6 != 0) goto L_0x0049
            return
        L_0x0049:
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r3 = "yyyy-MM-dd HH:mm:ss"
            r2.<init>(r3)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r5 = r6.getEndTime()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.util.Date r5 = r2.parse(r5)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r5 == 0) goto L_0x0065
            long r7 = r5.getTime()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            goto L_0x0067
        L_0x0065:
            r7 = -1
        L_0x0067:
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0074
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController r5 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController.INSTANCE     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController.tryDownloadAndUnzipRes$default(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
        L_0x0074:
            java.util.ArrayList r5 = r1.getResArray()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r7 = "localData.resArray.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
        L_0x0081:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r7 == 0) goto L_0x00ec
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem r7 = (com.baidu.mms.voicesearch.voice.bean.dao.NewAssistantOperateDataItem) r7     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r7 != 0) goto L_0x0090
            goto L_0x0081
        L_0x0090:
            java.lang.String r8 = r7.getEndTime()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.util.Date r8 = r2.parse(r8)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r8 == 0) goto L_0x009f
            long r8 = r8.getTime()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            goto L_0x00a4
        L_0x009f:
            r8 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
        L_0x00a4:
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 > 0) goto L_0x0081
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r9.<init>()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController r10 = com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResController.INSTANCE     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r10 = r10.getAbsolutePath()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r10 = r7.getId()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r10 = java.io.File.separator     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r10 = r7.getActivityTag()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            boolean r9 = r8.exists()     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            if (r9 == 0) goto L_0x00e6
            com.baidu.android.util.io.FileUtils.deleteFile((java.io.File) r8)     // Catch:{ Exception -> 0x00ea, Error -> 0x00e8 }
            goto L_0x0081
        L_0x00e6:
            goto L_0x0081
        L_0x00e8:
            r0 = move-exception
            goto L_0x00ec
        L_0x00ea:
            r0 = move-exception
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mms.voicesearch.commands.assistantresource.AssistantOperateResCommandImp$handleData$1.execute():void");
    }
}
