package com.baidu.searchbox.kmm.personalcenter.smart;

import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import com.baidu.searchbox.kmm.foundation.utils.PlatformUtils;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabClickInfo;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ConstantsKt;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.DataMgrConstantsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003¨\u0006\u0006"}, d2 = {"getHasShowCardList", "Lorg/json/JSONArray;", "Lcom/baidu/searchbox/kmm/foundation/kelson/KJsonArray;", "Lcom/baidu/searchbox/kmm/personalcenter/smart/PersonalCenterSmartDataMgr;", "updateContainLoadingRecommendCard", "", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SmartRecommendCardInfoProcessor.kt */
public final class SmartRecommendCardInfoProcessorKt {
    public static final JSONArray getHasShowCardList(PersonalCenterSmartDataMgr $this$getHasShowCardList) {
        Object element$iv;
        Intrinsics.checkNotNullParameter($this$getHasShowCardList, "<this>");
        JsonArray hasShowJsonArray = new JsonArray();
        for (PersonalCenterTabClickInfo reInfo : RecommendCardClickInfoProcessorKt.getCurrentRecommendCardInfoList()) {
            String id = reInfo.getId();
            boolean z = false;
            if (id != null && (StringsKt.isBlank(id) ^ true)) {
                String showTime = reInfo.getShowTime();
                if (showTime != null && (!StringsKt.isBlank(showTime))) {
                    z = true;
                }
                if (z) {
                    Iterator it = RecommendCardClickInfoProcessorKt.getHideCardInfoList().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            element$iv = null;
                            break;
                        }
                        element$iv = it.next();
                        if (Intrinsics.areEqual((Object) ((PersonalCenterTabClickInfo) element$iv).getId(), (Object) reInfo.getId())) {
                            break;
                        }
                        PersonalCenterSmartDataMgr personalCenterSmartDataMgr = $this$getHasShowCardList;
                    }
                    if (element$iv != null) {
                        if (PlatformUtils.isDebug()) {
                            KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, " 隐藏卡中包含该id " + reInfo.getId());
                        }
                        PersonalCenterSmartDataMgr personalCenterSmartDataMgr2 = $this$getHasShowCardList;
                    } else {
                        JsonObject jsonObject = new JsonObject();
                        JsonObject $this$getHasShowCardList_u24lambda_u2d2_u24lambda_u2d1 = jsonObject;
                        $this$getHasShowCardList_u24lambda_u2d2_u24lambda_u2d1.put("groupId", reInfo.getId());
                        $this$getHasShowCardList_u24lambda_u2d2_u24lambda_u2d1.put(ConstantsKt.SHOW_TIME, reInfo.getShowTime());
                        hasShowJsonArray.add(jsonObject);
                    }
                }
            }
            PersonalCenterSmartDataMgr personalCenterSmartDataMgr3 = $this$getHasShowCardList;
        }
        if (PlatformUtils.isDebug()) {
            KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, "getHasShowCardList hasShowJsonArray = " + hasShowJsonArray + "  , currentRecommendCardInfoList = " + RecommendCardClickInfoProcessorKt.getCurrentRecommendCardInfoList());
        }
        return hasShowJsonArray.getRawArray();
    }

    public static final void updateContainLoadingRecommendCard(PersonalCenterSmartDataMgr $this$updateContainLoadingRecommendCard) {
        PersonalCenterTabModel personalCenterTabModel;
        List<PersonalCenterTabModel> recommendGroupsData;
        List<PersonalCenterTabModel> recommendGroupsData2;
        List<PersonalCenterTabModel> list;
        List<PersonalCenterTabModel> recommendGroupsData3;
        List<PersonalCenterTabModel> recommendGroupsData4;
        List<PersonalCenterTabModel> $this$firstOrNull$iv;
        Object element$iv;
        PersonalCenterTabModel it;
        Intrinsics.checkNotNullParameter($this$updateContainLoadingRecommendCard, "<this>");
        PersonalCenterSmartDataWrapper smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter = $this$updateContainLoadingRecommendCard.getSmartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
        boolean z = true;
        if (!(smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter != null && !smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter.isValid$com_baidu_searchbox_kmm_business_personalcenter()) && $this$updateContainLoadingRecommendCard.getSmartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter() != null) {
            PersonalCenterSmartDataWrapper smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter = $this$updateContainLoadingRecommendCard.getSmartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
            Integer num = null;
            if (smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter == null || ($this$firstOrNull$iv = smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter.getRecommendGroupsData()) == null) {
                personalCenterTabModel = null;
            } else {
                Iterator it2 = $this$firstOrNull$iv.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        element$iv = null;
                        break;
                    }
                    element$iv = it2.next();
                    if (((PersonalCenterTabModel) element$iv).getTempCategory() == 9015) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        break;
                    }
                }
                personalCenterTabModel = (PersonalCenterTabModel) element$iv;
            }
            if (personalCenterTabModel == null) {
                z = false;
            }
            boolean isContainLoading = z;
            if (PlatformUtils.isDebug()) {
                StringBuilder append = new StringBuilder().append("updateContainLoadingRecommendCard before isContainLoading = ").append(isContainLoading).append(",本地list：");
                PersonalCenterSmartDataWrapper smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 = $this$updateContainLoadingRecommendCard.getSmartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                StringBuilder append2 = append.append((smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 == null || (recommendGroupsData4 = smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2.getRecommendGroupsData()) == null) ? null : Integer.valueOf(recommendGroupsData4.size())).append(" , 暴露给外部的list：");
                PersonalCenterSmartDataWrapper smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 = $this$updateContainLoadingRecommendCard.getSmartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, append2.append((smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 == null || (recommendGroupsData3 = smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2.getRecommendGroupsData()) == null) ? null : Integer.valueOf(recommendGroupsData3.size())).toString());
            }
            if (isContainLoading) {
                List tempRecommend = new ArrayList();
                List $this$updateContainLoadingRecommendCard_u24lambda_u2d4 = tempRecommend;
                PersonalCenterSmartDataWrapper smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3 = $this$updateContainLoadingRecommendCard.getSmartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                if (smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3 == null || (list = smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3.getRecommendGroupsData()) == null) {
                    list = CollectionsKt.emptyList();
                }
                $this$updateContainLoadingRecommendCard_u24lambda_u2d4.addAll(list);
                PersonalCenterSmartDataWrapper smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3 = $this$updateContainLoadingRecommendCard.getSmartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                if (smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3 != null) {
                    smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter3.setRecommendGroupsData(tempRecommend);
                }
            }
            if (PlatformUtils.isDebug()) {
                StringBuilder append3 = new StringBuilder().append("updateContainLoadingRecommendCard after 本地list：");
                PersonalCenterSmartDataWrapper smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4 = $this$updateContainLoadingRecommendCard.getSmartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                StringBuilder append4 = append3.append((smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4 == null || (recommendGroupsData2 = smartLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4.getRecommendGroupsData()) == null) ? null : Integer.valueOf(recommendGroupsData2.size())).append(" , 暴露给外部的list：");
                PersonalCenterSmartDataWrapper smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4 = $this$updateContainLoadingRecommendCard.getSmartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                if (!(smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4 == null || (recommendGroupsData = smartExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter4.getRecommendGroupsData()) == null)) {
                    num = Integer.valueOf(recommendGroupsData.size());
                }
                KmmLog.printLog(DataMgrConstantsKt.LOG_TAG, append4.append(num).toString());
            }
        }
    }
}
