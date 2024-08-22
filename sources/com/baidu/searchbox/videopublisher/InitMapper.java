package com.baidu.searchbox.videopublisher;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/videopublisher/InitMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/ugc/webjs/UgcSchemeModel;", "Lcom/baidu/searchbox/videopublisher/InitModel;", "()V", "map", "input", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitModel.kt */
public final class InitMapper implements Mapper<UgcSchemeModel, InitModel> {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.baidu.searchbox.ugc.model.CampaignModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: com.baidu.searchbox.ugc.model.CampaignModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: com.baidu.searchbox.ugc.model.CampaignModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.searchbox.videopublisher.InitModel map(com.baidu.searchbox.ugc.webjs.UgcSchemeModel r33) {
        /*
            r32 = this;
            r1 = r33
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r3 = r1.sourceFrom
            java.lang.String r4 = r1.centerInfoJsonStr
            java.lang.String r15 = r1.multiFacePlay
            java.lang.String r5 = r1.path
            java.lang.String r6 = r1.videoCover
            java.lang.String r7 = r1.videoParams
            java.lang.String r0 = r1.topicSelectSchema
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x0022
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%220%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dsearch"
            goto L_0x002a
        L_0x0028:
            java.lang.String r0 = r1.topicSelectSchema
        L_0x002a:
            r8 = r0
            java.lang.String r9 = r1.ugcCallback
            java.lang.String r10 = r1.displayScene
            java.lang.String r11 = r1.publishType
            int r12 = r1.asyncUpload
            java.lang.String r13 = r1.longitude
            java.lang.String r14 = r1.latitude
            java.lang.String r0 = r1.topic
            com.baidu.searchbox.ugc.model.TopicItem r16 = com.baidu.searchbox.ugc.model.TopicItem.parse(r0)
            java.lang.String r2 = r1.ext
            java.lang.String r0 = r1.target
            com.baidu.searchbox.ugc.model.UGCTarget r18 = com.baidu.searchbox.ugc.model.UGCTarget.parse(r0)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0066 }
            r0 = r32
            com.baidu.searchbox.videopublisher.InitMapper r0 = (com.baidu.searchbox.videopublisher.InitMapper) r0     // Catch:{ all -> 0x0066 }
            r19 = 0
            r20 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0066 }
            r28 = r2
            java.lang.String r2 = r1.target     // Catch:{ all -> 0x0064 }
            r0.<init>(r2)     // Catch:{ all -> 0x0064 }
            java.lang.String r2 = "ugcgroup"
            java.lang.String r0 = r0.optString(r2)     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x0064 }
            goto L_0x0073
        L_0x0064:
            r0 = move-exception
            goto L_0x0069
        L_0x0066:
            r0 = move-exception
            r28 = r2
        L_0x0069:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x0073:
            boolean r2 = kotlin.Result.m8977isFailureimpl(r0)
            r19 = 0
            if (r2 == 0) goto L_0x007d
            r0 = r19
        L_0x007d:
            r29 = r0
            java.lang.String r29 = (java.lang.String) r29
            java.lang.String r0 = r1.activity
            if (r0 == 0) goto L_0x012f
            r2 = r0
            r20 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0112 }
            r0 = r2
            r21 = 0
            com.baidu.searchbox.ugc.model.CampaignModel r22 = new com.baidu.searchbox.ugc.model.CampaignModel     // Catch:{ all -> 0x0112 }
            r22.<init>()     // Catch:{ all -> 0x0112 }
            r23 = r22
            r24 = 0
            r25 = r0
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ all -> 0x0112 }
            r26 = r2
            java.lang.String r2 = r1.activity     // Catch:{ all -> 0x010c }
            r0.<init>(r2)     // Catch:{ all -> 0x010c }
            r2 = 0
            r27 = r2
            java.lang.String r2 = "id"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x010c }
            r30 = r15
            r15 = r23
            r15.id = r2     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = "name"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0108 }
            r15.name = r2     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = "video_type"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0108 }
            r15.videoType = r2     // Catch:{ all -> 0x0108 }
            java.lang.String r2 = "isNeed"
            r31 = r14
            r14 = 0
            int r2 = r0.optInt(r2, r14)     // Catch:{ all -> 0x0106 }
            r15.isNeed = r2     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "topicList"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.baidu.searchbox.ugc.model.TopicItem> r14 = com.baidu.searchbox.ugc.model.TopicItem.class
            java.util.List r2 = com.baidu.searchbox.ugc.utils.GsonExtKt.listOf(r2, r14)     // Catch:{ all -> 0x0106 }
            r15.topicList = r2     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "mount_list"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0106 }
            java.lang.Class<com.baidu.searchbox.ugc.model.MountModel> r14 = com.baidu.searchbox.ugc.model.MountModel.class
            java.util.List r2 = com.baidu.searchbox.ugc.utils.GsonExtKt.listOf(r2, r14)     // Catch:{ all -> 0x0106 }
            r15.mountList = r2     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "task_origin"
            java.lang.String r2 = r0.optString(r2)     // Catch:{ all -> 0x0106 }
            r15.taskOrigin = r2     // Catch:{ all -> 0x0106 }
            java.lang.String r2 = "mount_has_more"
            boolean r2 = r0.optBoolean(r2)     // Catch:{ all -> 0x0106 }
            r15.mountHasMore = r2     // Catch:{ all -> 0x0106 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r22)     // Catch:{ all -> 0x0106 }
            goto L_0x0123
        L_0x0106:
            r0 = move-exception
            goto L_0x0119
        L_0x0108:
            r0 = move-exception
            r31 = r14
            goto L_0x0119
        L_0x010c:
            r0 = move-exception
            r31 = r14
            r30 = r15
            goto L_0x0119
        L_0x0112:
            r0 = move-exception
            r26 = r2
            r31 = r14
            r30 = r15
        L_0x0119:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x0123:
            boolean r2 = kotlin.Result.m8977isFailureimpl(r0)
            if (r2 == 0) goto L_0x012a
            goto L_0x012c
        L_0x012a:
            r19 = r0
        L_0x012c:
            com.baidu.searchbox.ugc.model.CampaignModel r19 = (com.baidu.searchbox.ugc.model.CampaignModel) r19
            goto L_0x0133
        L_0x012f:
            r31 = r14
            r30 = r15
        L_0x0133:
            boolean r0 = r1.secondEdit
            r20 = r0
            java.lang.String r0 = r1.videoTitle
            r21 = r0
            java.lang.String r0 = r1.videoId
            r22 = r0
            java.lang.String r0 = r1.positionLatLng
            r23 = r0
            com.baidu.searchbox.ugc.model.TiaoZhanInfo r0 = r1.tiaozhanInfo
            r24 = r0
            java.lang.String r0 = r1.hideFunction
            r25 = r0
            java.lang.String r0 = r1.aiStyleId
            r26 = r0
            java.lang.String r0 = r1.businessId
            r27 = r0
            com.baidu.searchbox.videopublisher.InitModel r0 = new com.baidu.searchbox.videopublisher.InitModel
            r17 = r28
            r2 = r0
            java.lang.String r14 = "sourceFrom"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r14)
            java.lang.String r14 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r14)
            java.lang.String r14 = "videoParams"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r14)
            java.lang.String r14 = "if (input.topicSelectSch…e input.topicSelectSchema"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r14)
            java.lang.String r14 = "ugcCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)
            java.lang.String r14 = "displayScene"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r14)
            java.lang.String r14 = "publishType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r14)
            r14 = r31
            r28 = r30
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r29
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.videopublisher.InitMapper.map(com.baidu.searchbox.ugc.webjs.UgcSchemeModel):com.baidu.searchbox.videopublisher.InitModel");
    }
}
