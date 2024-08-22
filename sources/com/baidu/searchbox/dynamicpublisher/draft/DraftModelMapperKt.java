package com.baidu.searchbox.dynamicpublisher.draft;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ugc.category.model.CategoryLabelValue;
import com.baidu.searchbox.ugc.category.model.CategoryModelKt;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.model.CampaignModel;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.TiaoZhanInfo;
import com.baidu.searchbox.ugc.model.UGCTarget;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.UgcPublishData;
import com.baidu.searchbox.ugc.view.EditImageTextView;
import com.baidu.ugc.position.model.PoiModel;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\u0006"}, d2 = {"convertDraftDataToDraftModel", "Lcom/baidu/searchbox/dynamicpublisher/draft/DraftModel;", "draftData", "Lcom/baidu/searchbox/ugc/draft/DraftData;", "convertDraftModelToDraftData", "draftModel", "lib-ugc-core_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DraftModelMapper.kt */
public final class DraftModelMapperKt {
    public static final DraftData convertDraftModelToDraftData(DraftModel draftModel) {
        String str;
        Intrinsics.checkNotNullParameter(draftModel, "draftModel");
        DraftData draftData = new DraftData();
        DraftData $this$convertDraftModelToDraftData_u24lambda_u2d7 = draftData;
        int i2 = 0;
        $this$convertDraftModelToDraftData_u24lambda_u2d7.draftKey = draftModel.getDraftKey();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.publishTitle = draftModel.getDynamicTitle();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.content = draftModel.getContent();
        PoiModel it = draftModel.getPoiModel();
        if (it != null) {
            $this$convertDraftModelToDraftData_u24lambda_u2d7.poiInfo = new Gson().toJson((Object) it);
        }
        if (!draftModel.getImages().isEmpty()) {
            int $i$f$forEachIndexed = false;
            int index$iv = 0;
            for (Object item$iv : draftModel.getImages()) {
                int index$iv2 = index$iv + 1;
                if (index$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ImageStruct image = (ImageStruct) item$iv;
                String str2 = image.uriStr;
                boolean z = false;
                if (draftModel.getNewImageTags().contains(image)) {
                    if (image.isGif()) {
                        str = FileUtils.saveGifDraft(AppRuntime.getAppContext(), image.uriStr);
                    } else {
                        CharSequence charSequence = image.uriStr;
                        if (charSequence == null || charSequence.length() == 0) {
                            str = "";
                        } else {
                            str = FileUtils.saveImageDraft(AppRuntime.getAppContext(), image.uriStr);
                        }
                    }
                    str2 = str;
                }
                String imageKey = str2;
                CharSequence charSequence2 = imageKey;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    z = true;
                }
                if (z) {
                    image.createTag();
                    String newKey = index$iv + image.tag;
                    imageKey = newKey;
                    image.updateTag(newKey);
                }
                $this$convertDraftModelToDraftData_u24lambda_u2d7.images.add(imageKey);
                Map<String, DraftData.ImageDraftData> map = $this$convertDraftModelToDraftData_u24lambda_u2d7.imageDraftDataMap;
                Intrinsics.checkNotNullExpressionValue(map, "this.imageDraftDataMap");
                DraftData.ImageDraftData $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d1 = new DraftData.ImageDraftData();
                int i3 = i2;
                DraftData.ImageDraftData $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12 = $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d1;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.tag = image.tag;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.uriStr = str2;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imageWidth = image.width;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imageHeight = image.height;
                int i4 = index$iv;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imageSize = image.size;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imageScore = image.qualityScore;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imageFuzzy = image.isFuzzy;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.isOriginal = image.isOriginal;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.status = image.status;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.text = image.text;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.textColor = image.textColor;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.bgColor = image.bgColor;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.latitude = image.latitude;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.longitude = image.longitude;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.draftPath = image.draftPath;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.originalPath = image.originalPath;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.aiAnchorPointId = image.aiAnchorPointId;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.taskId = image.taskId;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.aiCreativeImageResult = image.aiCreativeImageResult;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.aiGenimageResult = image.aiGenimageResult;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.imgType = image.imgType;
                $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d12.httpUrl = image.httpUrl;
                map.put(imageKey, $this$convertDraftModelToDraftData_u24lambda_u2d7_u24lambda_u2d2_u24lambda_u2d1);
                $i$f$forEachIndexed = $i$f$forEachIndexed;
                index$iv = index$iv2;
                i2 = i3;
                DraftModel draftModel2 = draftModel;
            }
            int i5 = i2;
            int i6 = $i$f$forEachIndexed;
        }
        $this$convertDraftModelToDraftData_u24lambda_u2d7.video = draftModel.getVideoPath();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.videoCover = draftModel.getVideoCover();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.mediaId = draftModel.getMediaId();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.questionText = EditImageTextView.replaceLocalUrl(draftModel.getQuestionText(), $this$convertDraftModelToDraftData_u24lambda_u2d7.images);
        for (ImageStruct image2 : draftModel.getDelImageTags()) {
            FileUtils.deleteFile(image2.uriStr);
        }
        UGCTarget it2 = draftModel.getNewTarget();
        if (it2 != null) {
            $this$convertDraftModelToDraftData_u24lambda_u2d7.target = UGCTarget.toJson(it2);
        }
        $this$convertDraftModelToDraftData_u24lambda_u2d7.timestamp = System.currentTimeMillis();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.categoryLabel = CategoryModelKt.toJson(draftModel.getCategoryLabelValue());
        $this$convertDraftModelToDraftData_u24lambda_u2d7.group = draftModel.getGroup();
        CampaignModel it3 = draftModel.getCampaignModel();
        if (it3 != null) {
            $this$convertDraftModelToDraftData_u24lambda_u2d7.campaign = new Gson().toJson((Object) it3);
        }
        $this$convertDraftModelToDraftData_u24lambda_u2d7.aiAssistant = UgcPublishData.aiAssistant;
        $this$convertDraftModelToDraftData_u24lambda_u2d7.aiStatement = draftModel.getAiStatement();
        TiaoZhanInfo it4 = draftModel.getTiaoZhanInfo();
        if (it4 != null) {
            $this$convertDraftModelToDraftData_u24lambda_u2d7.tiaozhanInfo = new Gson().toJson((Object) it4);
        }
        $this$convertDraftModelToDraftData_u24lambda_u2d7.createTime = draftModel.getCreateTime();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.updateTime = draftModel.getUpdateTime();
        $this$convertDraftModelToDraftData_u24lambda_u2d7.ext = draftModel.getExt();
        return draftData;
    }

    public static final DraftModel convertDraftDataToDraftModel(DraftData draftData) {
        Object obj;
        Object obj2;
        Object obj3;
        DraftData draftData2 = draftData;
        Intrinsics.checkNotNullParameter(draftData2, "draftData");
        String str = draftData2.draftKey;
        String str2 = draftData2.publishTitle;
        String str3 = draftData2.content;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m8971constructorimpl((PoiModel) new Gson().fromJson(draftData2.poiInfo, PoiModel.class));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m8977isFailureimpl(obj)) {
            obj = null;
        }
        PoiModel poiModel = (PoiModel) obj;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        CopyOnWriteArrayList $this$convertDraftDataToDraftModel_u24lambda_u2d11 = copyOnWriteArrayList;
        int i2 = 0;
        Map<String, DraftData.ImageDraftData> map = draftData2.imageDraftDataMap;
        if (!(map == null || map.isEmpty())) {
            Map $this$forEach$iv = draftData2.imageDraftDataMap;
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "draftData.imageDraftDataMap");
            int $i$f$forEach = false;
            for (Map.Entry<String, DraftData.ImageDraftData> element$iv : $this$forEach$iv.entrySet()) {
                DraftData.ImageDraftData imageDraftModel = (DraftData.ImageDraftData) element$iv.getValue();
                ImageStruct imageStruct = new ImageStruct(imageDraftModel.uriStr);
                ImageStruct $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9 = imageStruct;
                int i3 = i2;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.tag = imageDraftModel.tag;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.width = imageDraftModel.imageWidth;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.height = imageDraftModel.imageHeight;
                Map $this$forEach$iv2 = $this$forEach$iv;
                int $i$f$forEach2 = $i$f$forEach;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.size = imageDraftModel.imageSize;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.qualityScore = imageDraftModel.imageScore;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.isFuzzy = imageDraftModel.imageFuzzy;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.isOriginal = imageDraftModel.isOriginal;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.status = imageDraftModel.status;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.text = imageDraftModel.text;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.textColor = imageDraftModel.textColor;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.bgColor = imageDraftModel.bgColor;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.latitude = imageDraftModel.latitude;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.longitude = imageDraftModel.longitude;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.draftPath = imageDraftModel.draftPath;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.originalPath = imageDraftModel.originalPath;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.aiAnchorPointId = imageDraftModel.aiAnchorPointId;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.taskId = imageDraftModel.taskId;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.aiCreativeImageResult = imageDraftModel.aiCreativeImageResult;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.aiGenimageResult = imageDraftModel.aiGenimageResult;
                if (imageDraftModel.imgType == -1) {
                    imageDraftModel.imgType = 2;
                }
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.imgType = imageDraftModel.imgType;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9.httpUrl = imageDraftModel.httpUrl;
                $this$convertDraftDataToDraftModel_u24lambda_u2d11.add(imageStruct);
                $this$forEach$iv = $this$forEach$iv2;
                i2 = i3;
                $i$f$forEach = $i$f$forEach2;
            }
            int i4 = i2;
            Map map2 = $this$forEach$iv;
            int i5 = $i$f$forEach;
        }
        String str4 = draftData2.video;
        String str5 = draftData2.videoCover;
        String str6 = draftData2.mediaId;
        UGCTarget parse = UGCTarget.parse(draftData2.target);
        CategoryLabelValue categoryLabelValue = CategoryModelKt.toCategoryLabelValue(draftData2.categoryLabel);
        String str7 = draftData2.questionText;
        String str8 = draftData2.group;
        try {
            Result.Companion companion3 = Result.Companion;
            obj2 = Result.m8971constructorimpl((CampaignModel) new Gson().fromJson(draftData2.campaign, CampaignModel.class));
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.m8971constructorimpl(ResultKt.createFailure(th3));
        }
        if (Result.m8977isFailureimpl(obj2)) {
            obj2 = null;
        }
        CampaignModel campaignModel = (CampaignModel) obj2;
        String str9 = draftData2.aiStatement;
        try {
            Result.Companion companion5 = Result.Companion;
            obj3 = Result.m8971constructorimpl((TiaoZhanInfo) new Gson().fromJson(draftData2.tiaozhanInfo, TiaoZhanInfo.class));
        } catch (Throwable th4) {
            Result.Companion companion6 = Result.Companion;
            obj3 = Result.m8971constructorimpl(ResultKt.createFailure(th4));
        }
        String str10 = str5;
        DraftModel $this$convertDraftDataToDraftModel_u24lambda_u2d15 = new DraftModel(str, (String) null, (String) null, (String) null, (UGCTarget) null, 0, (String) null, (String) null, str2, str3, copyOnWriteArrayList, str4, str10, str6, parse, poiModel, campaignModel, categoryLabelValue, str7, (String) null, str8, str9, (TiaoZhanInfo) (Result.m8977isFailureimpl(obj3) ? null : obj3), 524542, (DefaultConstructorMarker) null);
        $this$convertDraftDataToDraftModel_u24lambda_u2d15.setCreateTime(draftData2.createTime);
        $this$convertDraftDataToDraftModel_u24lambda_u2d15.setUpdateTime(draftData2.updateTime);
        String it = draftData2.aiAssistant;
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "aiAssistant");
            $this$convertDraftDataToDraftModel_u24lambda_u2d15.setAiAssistant(it);
        }
        $this$convertDraftDataToDraftModel_u24lambda_u2d15.setExt(draftData2.ext);
        return $this$convertDraftDataToDraftModel_u24lambda_u2d15;
    }
}
