package com.baidu.searchbox.ugc.request;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.category.model.LabelValue;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.model.PublishRequestModel;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.LogUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PublishParamsHelper {
    public static Map<String, String> getPublishParams(PublishRequestModel info) {
        PublishRequestModel publishRequestModel = info;
        if (publishRequestModel == null) {
            return null;
        }
        if (publishRequestModel.campaign != null) {
            try {
                publishRequestModel.data.put("activity_bjh", publishRequestModel.campaign);
                if (!TextUtils.isEmpty(publishRequestModel.taskOrigin)) {
                    publishRequestModel.data.put("task_origin", publishRequestModel.taskOrigin);
                }
            } catch (JSONException e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
        if (publishRequestModel.shop != null) {
            try {
                publishRequestModel.data.put("ugc_dynamic_shop", publishRequestModel.shop);
            } catch (JSONException e3) {
                if (AppConfig.isDebug()) {
                    e3.printStackTrace();
                }
            }
        }
        if (publishRequestModel.categoryLabelValue != null) {
            JSONObject cateJO = new JSONObject();
            try {
                cateJO.put("cate", publishRequestModel.categoryLabelValue.getMainCateName());
                cateJO.put("subCate", publishRequestModel.categoryLabelValue.getSecondCateName());
                JSONArray tagJA = new JSONArray();
                Map<Pair<String, String>, JSONArray> tagMap = new HashMap<>();
                Iterator<LabelValue> it = publishRequestModel.categoryLabelValue.getLabelGroups().iterator();
                while (it.hasNext()) {
                    LabelValue labelValue = it.next();
                    Pair<String, String> cateKey = new Pair<>(labelValue.getLabelGroupName(), labelValue.getLabelGroupType());
                    if (tagMap.containsKey(cateKey)) {
                        tagMap.get(cateKey).put(labelValue.getLabelItemName());
                    } else {
                        JSONArray jsonArray = new JSONArray();
                        jsonArray.put(labelValue.getLabelItemName());
                        tagMap.put(cateKey, jsonArray);
                    }
                }
                for (Pair<String, String> p : tagMap.keySet()) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("name", p.first);
                    jsonObject.put("type", p.second);
                    jsonObject.put("list", tagMap.get(p));
                    tagJA.put(jsonObject);
                }
                cateJO.put("tags", tagJA);
                publishRequestModel.data.put("category", cateJO);
            } catch (Exception e4) {
                LogUtil.d(Log.getStackTraceString(e4));
            }
        }
        try {
            publishRequestModel.data.put(UgcConstant.UGC_IS_USE_TEXT_TPL, publishRequestModel.isUgcTextTemplate);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
        return HttpRequestPublishModule.generateRequestPublishParams(publishRequestModel.data, publishRequestModel.serverTopicsRule, publishRequestModel.title, publishRequestModel.publishTitle, publishRequestModel.inputStr, publishRequestModel.imageUrlList, publishRequestModel.videoInfo, publishRequestModel.sourceFrom, publishRequestModel.sourceid, publishRequestModel.sourceType, publishRequestModel.publishType, publishRequestModel.sourceKey, publishRequestModel.topic, publishRequestModel.locationObject, publishRequestModel.extObject, publishRequestModel.questionReply, publishRequestModel.swanObject, publishRequestModel.questionAsk, publishRequestModel.poiObject, publishRequestModel.topicCreate, publishRequestModel.topicCheck, publishRequestModel.isAsync, publishRequestModel.coverBeauty, publishRequestModel.nid, publishRequestModel.ymgToken, publishRequestModel.centerInfo, publishRequestModel.aiCreation);
    }
}
