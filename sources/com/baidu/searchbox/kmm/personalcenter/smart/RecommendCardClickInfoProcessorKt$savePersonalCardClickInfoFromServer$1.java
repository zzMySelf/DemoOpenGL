package com.baidu.searchbox.kmm.personalcenter.smart;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecommendCardClickInfoProcessor.kt */
final class RecommendCardClickInfoProcessorKt$savePersonalCardClickInfoFromServer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<PersonalCenterTabModel> $recommendGroupsData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecommendCardClickInfoProcessorKt$savePersonalCardClickInfoFromServer$1(List<PersonalCenterTabModel> list) {
        super(0);
        this.$recommendGroupsData = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v4, resolved type: com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r24 = this;
            r0 = r24
            boolean r1 = com.baidu.searchbox.kmm.foundation.utils.PlatformUtils.isDebug()
            java.lang.String r2 = "kmm_personal_center"
            if (r1 == 0) goto L_0x0028
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "savePersonalCardClickInfoFromServer start recommendGroupsData.size = "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.util.List<com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel> r3 = r0.$recommendGroupsData
            int r3 = r3.size()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.baidu.searchbox.kmm.foundation.utils.KmmLog.printLog(r2, r1)
        L_0x0028:
            java.util.List r1 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            r3 = 0
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r1, r5)
            r4.<init>(r5)
            java.util.Collection r4 = (java.util.Collection) r4
            r5 = r1
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x0042:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0061
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r9 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r9
            r10 = 0
            kotlin.Triple r11 = new kotlin.Triple
            java.lang.String r12 = r9.getId()
            java.lang.String r13 = r9.getDataType()
            r11.<init>(r12, r13, r9)
            r4.add(r11)
            goto L_0x0042
        L_0x0061:
            java.util.List r4 = (java.util.List) r4
            r1 = r4
            java.util.List r3 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getCurrentRecommendCardInfoList()
            r3.clear()
            java.util.List r3 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r3.iterator()
        L_0x0083:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x009f
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r9 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r9
            r10 = 0
            java.lang.String r9 = r9.getId()
            boolean r10 = r5.add(r9)
            if (r10 == 0) goto L_0x0083
            r6.add(r8)
            goto L_0x0083
        L_0x009f:
            r3 = r6
            java.util.List r3 = (java.util.List) r3
            java.util.List r4 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            r4.clear()
            java.util.List r4 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            r5 = r3
            java.util.Collection r5 = (java.util.Collection) r5
            r4.addAll(r5)
            com.baidu.searchbox.kmm.foundation.kelson.JsonArray r4 = new com.baidu.searchbox.kmm.foundation.kelson.JsonArray
            r4.<init>()
            java.util.List<com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel> r5 = r0.$recommendGroupsData
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            r6 = 0
            java.util.Iterator r7 = r5.iterator()
        L_0x00c2:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0205
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r9 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r9
            r10 = 0
            java.lang.String r11 = r9.getGroupId()
            r12 = r11
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x00e2
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)
            if (r12 == 0) goto L_0x00e0
            goto L_0x00e2
        L_0x00e0:
            r12 = 0
            goto L_0x00e3
        L_0x00e2:
            r12 = 1
        L_0x00e3:
            if (r12 == 0) goto L_0x00e6
            goto L_0x00c2
        L_0x00e6:
            boolean r12 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.isSmartRecommendCard(r9)
            java.lang.String r15 = "mergeServiceCard"
            if (r12 == 0) goto L_0x00f1
            r12 = r15
            goto L_0x00f4
        L_0x00f1:
            java.lang.String r12 = "singleServiceCard"
        L_0x00f4:
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r15)
            if (r15 == 0) goto L_0x0113
            java.lang.String r13 = r9.getGroupId()
            if (r13 != 0) goto L_0x0104
            java.lang.String r13 = ""
        L_0x0104:
            java.util.List r14 = r9.getBody()
            com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.dealSmartMergeCard(r12, r13, r14, r4, r1)
            r16 = r1
            r17 = r3
            goto L_0x01fd
        L_0x0113:
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r15 = new com.baidu.searchbox.kmm.foundation.kelson.JsonObject
            r15.<init>()
            java.lang.String r13 = "id"
            r15.put(r13, r11)
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r13 = new com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo
            r13.<init>()
            r13.setId(r11)
            r17 = r1
            java.lang.Iterable r17 = (java.lang.Iterable) r17
            r18 = 0
            java.util.Iterator r19 = r17.iterator()
        L_0x0131:
            boolean r20 = r19.hasNext()
            r21 = 0
            if (r20 == 0) goto L_0x015d
            java.lang.Object r20 = r19.next()
            r22 = r20
            kotlin.Triple r22 = (kotlin.Triple) r22
            r23 = 0
            java.lang.Object r14 = r22.getFirst()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r11)
            if (r14 == 0) goto L_0x0159
            java.lang.Object r14 = r22.getSecond()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r12)
            if (r14 == 0) goto L_0x0159
            r14 = 1
            goto L_0x015a
        L_0x0159:
            r14 = 0
        L_0x015a:
            if (r14 == 0) goto L_0x0131
            goto L_0x015f
        L_0x015d:
            r20 = r21
        L_0x015f:
            kotlin.Triple r20 = (kotlin.Triple) r20
            if (r20 == 0) goto L_0x016b
            java.lang.Object r14 = r20.getThird()
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r14 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r14
            goto L_0x016d
        L_0x016b:
            r14 = r21
        L_0x016d:
            java.lang.String r0 = "dataType"
            r16 = r1
            java.lang.String r1 = "showTime"
            if (r14 != 0) goto L_0x0188
            r17 = r3
            java.lang.String r3 = "0"
            r15.put(r1, r3)
            r15.put(r0, r12)
            r13.setShowTime(r3)
            r13.setDataType(r12)
            goto L_0x01ae
        L_0x0188:
            r17 = r3
            java.lang.String r3 = r14.getShowTime()
            r15.put(r1, r3)
            java.lang.String r1 = r14.getClickTimes()
            java.lang.String r3 = "clickTimes"
            r15.put(r3, r1)
            r15.put(r0, r12)
            java.lang.String r0 = r14.getShowTime()
            r13.setShowTime(r0)
            java.lang.String r0 = r14.getClickTimes()
            r13.setClickTimes(r0)
            r13.setDataType(r12)
        L_0x01ae:
            java.util.List r0 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x01b8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01df
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r3 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r3
            r18 = 0
            r19 = r0
            java.lang.String r0 = r3.getId()
            r20 = r1
            java.lang.String r1 = r13.getId()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x01dc
            r21 = r20
            goto L_0x01df
        L_0x01dc:
            r0 = r19
            goto L_0x01b8
        L_0x01df:
            r0 = r21
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r0 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r0
            if (r0 == 0) goto L_0x01ec
            java.util.List r1 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            r1.remove(r0)
        L_0x01ec:
            java.util.List r1 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            r1.add(r13)
            java.util.List r1 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getCurrentRecommendCardInfoList()
            r1.add(r13)
            r4.add(r15)
        L_0x01fd:
            r0 = r24
            r1 = r16
            r3 = r17
            goto L_0x00c2
        L_0x0205:
            r16 = r1
            r17 = r3
            com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.savePersonalCardClickInfoFromServer((com.baidu.searchbox.kmm.foundation.kelson.JsonArray) r4)
            boolean r0 = com.baidu.searchbox.kmm.foundation.utils.PlatformUtils.isDebug()
            if (r0 == 0) goto L_0x023b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "savePersonalCardClickInfoFromServer end "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r1 = " , recommendCardInfoList.size = "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.util.List r1 = com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt.getRecommendCardInfoListContainHistory()
            int r1 = r1.size()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.searchbox.kmm.foundation.utils.KmmLog.printLog(r2, r0)
        L_0x023b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.kmm.personalcenter.smart.RecommendCardClickInfoProcessorKt$savePersonalCardClickInfoFromServer$1.invoke():void");
    }
}
