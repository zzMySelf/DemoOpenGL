package com.baidu.searchbox.kmm.personalcenter.smart;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonElement;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt;
import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import com.baidu.searchbox.kmm.foundation.utils.PlatformUtils;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ConstantsKt;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.DataMgrConstantsKt;
import com.baidu.searchbox.lockscreen.config.BubbleConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002\u001a\u0012\u0010\u0012\u001a\u00020\u000b*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0012\u0010\u0015\u001a\u00020\u000b*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038@X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0018"}, d2 = {"SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO", "", "commonFunInfoList", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabClickInfo;", "getCommonFunInfoList", "()Ljava/util/List;", "commonFunInfoList$delegate", "Lkotlin/Lazy;", "readCachedPersonalCommonFunClickInfo", "savePersonalCommonClickInfoFromServer", "", "groupsList", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "savePersonalCommonFunClickInfoFromServer", "clicksInfoJsonArray", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonArray;", "commonFunItemClick", "Lcom/baidu/searchbox/kmm/personalcenter/smart/PersonalCenterSmartDataMgr;", "id", "commonFunItemShow", "tabModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommonFunClickInfoProcessor.kt */
public final class CommonFunClickInfoProcessorKt {
    private static final String SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO = "personalCenterCommonFunShowInfo";
    private static final Lazy commonFunInfoList$delegate = LazyKt.lazy(CommonFunClickInfoProcessorKt$commonFunInfoList$2.INSTANCE);

    public static final List<PersonalCenterTabClickInfo> getCommonFunInfoList() {
        return (List) commonFunInfoList$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final List<PersonalCenterTabClickInfo> readCachedPersonalCommonFunClickInfo() {
        JsonArray cachedJson = JsonUtilKt.toJsonArray(QuickConfigKt.getQuickConfigString(SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO, BubbleConfig.BUBBLE_EMPTY_DATA_STR));
        if (cachedJson == null) {
            return new ArrayList<>();
        }
        if (PlatformUtils.isDebug()) {
            System.out.println("readCachedPersonalCommonFunClickInfo: " + cachedJson);
        }
        List personalCommonFunClickInfo = new ArrayList();
        int jsonSize = cachedJson.getSize();
        for (int index = 0; index < jsonSize; index++) {
            JsonObject jsonItem = JsonUtilKt.getJsonObject((JsonElement) cachedJson, index);
            if (jsonItem != null) {
                String jsonItemId = JsonUtilKt.getString(jsonItem, "id", "");
                String showTime = JsonUtilKt.getString(jsonItem, ConstantsKt.SHOW_TIME, "");
                String clickTimes = JsonUtilKt.getString(jsonItem, "clickTimes", "");
                String dataType = JsonUtilKt.getString(jsonItem, "dataType", "");
                if ((!StringsKt.isBlank(jsonItemId)) && (!StringsKt.isBlank(showTime))) {
                    PersonalCenterTabClickInfo personalCenterTabClickInfo = new PersonalCenterTabClickInfo();
                    personalCenterTabClickInfo.setId(jsonItemId);
                    personalCenterTabClickInfo.setShowTime(showTime);
                    personalCenterTabClickInfo.setClickTimes(clickTimes);
                    personalCenterTabClickInfo.setDataType(dataType);
                    personalCommonFunClickInfo.add(personalCenterTabClickInfo);
                }
            }
        }
        return personalCommonFunClickInfo;
    }

    public static final void savePersonalCommonClickInfoFromServer(List<? extends PersonalCenterGroupModel> groupsList) {
        Intrinsics.checkNotNullParameter(groupsList, "groupsList");
        BackgroundTaskUtilsKt.mainWork(new CommonFunClickInfoProcessorKt$savePersonalCommonClickInfoFromServer$1(groupsList));
    }

    /* access modifiers changed from: private */
    public static final void savePersonalCommonFunClickInfoFromServer(JsonArray clicksInfoJsonArray) {
        String clicksInfoJsonArrayStr = clicksInfoJsonArray != null ? clicksInfoJsonArray.toString() : null;
        CharSequence charSequence = clicksInfoJsonArrayStr;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            QuickConfigKt.removeQuickConfig(SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO);
        } else {
            QuickConfigKt.setQuickConfigString(SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO, clicksInfoJsonArrayStr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b8, code lost:
        r5 = kotlin.text.StringsKt.toIntOrNull(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void commonFunItemShow(com.baidu.searchbox.kmm.personalcenter.smart.PersonalCenterSmartDataMgr r19, com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r20) {
        /*
            java.lang.String r0 = "<this>"
            r1 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "tabModel"
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "personalCenterCommonFunShowInfo"
            java.lang.String r3 = "[]"
            java.lang.String r3 = com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.getQuickConfigString(r0, r3)
            com.baidu.searchbox.kmm.foundation.kelson.JsonArray r3 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.toJsonArray(r3)
            if (r3 != 0) goto L_0x0021
            return
        L_0x0021:
            java.util.List r4 = r20.getBody()
            r5 = 0
            java.util.List r6 = getCommonFunInfoList()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            java.util.Iterator r8 = r6.iterator()
        L_0x0031:
            boolean r9 = r8.hasNext()
            java.lang.String r10 = "kmm_personal_center"
            if (r9 == 0) goto L_0x00d4
            java.lang.Object r9 = r8.next()
            r11 = r9
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r11 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r11
            r12 = 0
            r13 = r4
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            r14 = 0
            java.util.Iterator r15 = r13.iterator()
        L_0x004a:
            boolean r16 = r15.hasNext()
            if (r16 == 0) goto L_0x006e
            java.lang.Object r16 = r15.next()
            r17 = r16
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel r17 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r17
            r18 = 0
            java.lang.String r1 = r17.getKeyId()
            java.lang.String r2 = r11.getId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0069
            goto L_0x0070
        L_0x0069:
            r1 = r19
            r2 = r20
            goto L_0x004a
        L_0x006e:
            r16 = 0
        L_0x0070:
            r1 = r16
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel r1 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r1
            boolean r2 = com.baidu.searchbox.kmm.foundation.utils.PlatformUtils.isDebug()
            if (r2 == 0) goto L_0x00af
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r13 = "commonFunItemShow id = "
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.String r13 = r11.getId()
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.String r13 = ", "
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r13 = " , size = "
            java.lang.StringBuilder r2 = r2.append(r13)
            int r13 = r4.size()
            java.lang.StringBuilder r2 = r2.append(r13)
            java.lang.String r2 = r2.toString()
            com.baidu.searchbox.kmm.foundation.utils.KmmLog.printLog(r10, r2)
        L_0x00af:
            if (r1 == 0) goto L_0x00ce
            r2 = 1
            java.lang.String r5 = r11.getShowTime()
            if (r5 == 0) goto L_0x00c3
            java.lang.Integer r5 = kotlin.text.StringsKt.toIntOrNull(r5)
            if (r5 == 0) goto L_0x00c3
            int r5 = r5.intValue()
            goto L_0x00c4
        L_0x00c3:
            r5 = 0
        L_0x00c4:
            int r5 = r5 + 1
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r11.setShowTime(r5)
            r5 = r2
        L_0x00ce:
            r1 = r19
            r2 = r20
            goto L_0x0031
        L_0x00d4:
            if (r5 == 0) goto L_0x0140
            com.baidu.searchbox.kmm.foundation.kelson.JsonArray r1 = new com.baidu.searchbox.kmm.foundation.kelson.JsonArray
            r1.<init>()
            java.util.List r2 = getCommonFunInfoList()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            r6 = 0
            java.util.Iterator r7 = r2.iterator()
        L_0x00e7:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x011c
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo r9 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo) r9
            r11 = 0
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r12 = new com.baidu.searchbox.kmm.foundation.kelson.JsonObject
            r12.<init>()
            java.lang.String r13 = r9.getId()
            java.lang.String r14 = "id"
            r12.put(r14, r13)
            java.lang.String r13 = r9.getShowTime()
            java.lang.String r14 = "showTime"
            r12.put(r14, r13)
            java.lang.String r13 = r9.getClickTimes()
            java.lang.String r14 = "clickTimes"
            r12.put(r14, r13)
            r1.add(r12)
            goto L_0x00e7
        L_0x011c:
            boolean r2 = com.baidu.searchbox.kmm.foundation.utils.PlatformUtils.isDebug()
            if (r2 == 0) goto L_0x0139
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "commonFunItemShow jsonArrayToCache = "
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.StringBuilder r2 = r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.baidu.searchbox.kmm.foundation.utils.KmmLog.printLog(r10, r2)
        L_0x0139:
            java.lang.String r2 = r1.toString()
            com.baidu.searchbox.kmm.foundation.storage.QuickConfigKt.setQuickConfigString(r0, r2)
        L_0x0140:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.kmm.personalcenter.smart.CommonFunClickInfoProcessorKt.commonFunItemShow(com.baidu.searchbox.kmm.personalcenter.smart.PersonalCenterSmartDataMgr, com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel):void");
    }

    public static final void commonFunItemClick(PersonalCenterSmartDataMgr $this$commonFunItemClick, String id) {
        String str = id;
        Intrinsics.checkNotNullParameter($this$commonFunItemClick, "<this>");
        Intrinsics.checkNotNullParameter(str, "id");
        if (JsonUtilKt.toJsonArray(QuickConfigKt.getQuickConfigString(SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO, BubbleConfig.BUBBLE_EMPTY_DATA_STR)) != null) {
            if (!(str.length() == 0)) {
                boolean needUpdateCache = false;
                for (PersonalCenterTabClickInfo personalisedTabClickInfo : getCommonFunInfoList()) {
                    if (Intrinsics.areEqual((Object) str, (Object) personalisedTabClickInfo.getId())) {
                        needUpdateCache = true;
                        personalisedTabClickInfo.setShowTime("0");
                        if (PlatformUtils.isDebug()) {
                            KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, "commonFunItemClick id =  " + str + "  , clickTimes: before " + personalisedTabClickInfo.getClickTimes());
                        }
                        Integer intOrNull = StringsKt.toIntOrNull(personalisedTabClickInfo.getClickTimes());
                        personalisedTabClickInfo.setClickTimes(String.valueOf((intOrNull != null ? intOrNull.intValue() : 0) + 1));
                        if (PlatformUtils.isDebug()) {
                            KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, "commonFunItemClick id =  " + str + "  , clickTimes: after " + personalisedTabClickInfo.getClickTimes());
                        }
                    }
                }
                if (needUpdateCache) {
                    JsonArray jsonArrayToCache = new JsonArray();
                    for (PersonalCenterTabClickInfo personalisedTabClickInfo2 : getCommonFunInfoList()) {
                        JsonObject personalCenterTabClickInfoJsonObject = new JsonObject();
                        personalCenterTabClickInfoJsonObject.put("id", personalisedTabClickInfo2.getId());
                        personalCenterTabClickInfoJsonObject.put(ConstantsKt.SHOW_TIME, personalisedTabClickInfo2.getShowTime());
                        personalCenterTabClickInfoJsonObject.put("clickTimes", personalisedTabClickInfo2.getClickTimes());
                        jsonArrayToCache.add(personalCenterTabClickInfoJsonObject);
                    }
                    QuickConfigKt.setQuickConfigString(SP_KEY_PERSONAL_COMMON_FUN_SHOW_INFO, jsonArrayToCache.toString());
                }
            }
        }
    }
}
