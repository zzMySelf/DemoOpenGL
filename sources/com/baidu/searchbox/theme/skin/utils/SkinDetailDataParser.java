package com.baidu.searchbox.theme.skin.utils;

import android.text.TextUtils;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.common.operation.CommonOperationModel;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.net.common.IResponseParser;
import com.baidu.searchbox.theme.skin.utils.SkinDetailData;
import com.baidu.swan.games.view.button.base.ApiButtonStyle;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SkinDetailDataParser implements IResponseParser<InputStream, SkinDetailData> {
    private static final boolean DEBUG = AppConfig.isDebug();
    public static final String KEY_ATTRS_CATEGORY_ID = "category_id";
    public static final String KEY_ATTRS_HOME_PAGE = "homepage";
    public static final String KEY_ATTRS_ID = "id";
    public static final String KEY_ATTRS_IS_DEFAULT = "is_default";
    public static final String KEY_ATTRS_IS_VIP = "is_vip";
    public static final String KEY_ATTRS_NEEDLOGIN = "needlogin";
    public static final String KEY_ATTRS_PROMPT = "skin_describe";
    public static final String KEY_ATTRS_RESOURCE = "resource";
    public static final String KEY_ATTRS_SKIN_DETAIL = "skindetail";
    public static final String KEY_ATTRS_SKIN_SOURCE = "skin_source";
    public static final String KEY_ATTRS_THUMBNAIL = "thumbnail";
    public static final String KEY_ATTRS_UIS = "uis";
    public static final String KEY_EFFECTIVE_DATE_END = "effective_date_end";
    public static final String KEY_HAS_NEW_BAR_SKIN = "has_new_bar_skin";
    public static final String KEY_IS_TASK_DONE = "is_task_done";
    public static final String KEY_IS_TASK_TYPE = "is_task_type";
    public static final String KEY_RECOMMEND_LIST = "recommend_list";
    public static final String KEY_SKIN_IMG_SOURCE = "skin_img_source";
    public static final String KEY_TASK_BUTTON = "task_button";
    public static final String KEY_TASK_SCHEME = "task_scheme";
    public static final String KEY_VIP_SCHEME = "vip_scheme";
    private static final String TAG = "SkinDetailDataParser";

    public SkinDetailData parseResponse(InputStream result) {
        if (result != null) {
            return parseJson(StreamUtils.streamToString(result));
        }
        return null;
    }

    public static SkinDetailData parseJson(String jsonStr) {
        BaseJsonData pageData = BaseJsonData.fromJson(jsonStr);
        if (pageData == null || pageData.getErrorCode() != 0) {
            return null;
        }
        try {
            SkinDetailData data = new SkinDetailData();
            JSONObject json = pageData.getData().optJSONObject(ApiButtonStyle.ATTR_FONT_WEIGHT_900);
            data.setId(json.optString("id"));
            data.setIsVip(json.optString("is_vip"));
            data.setVipScheme(json.optString("vip_scheme"));
            data.setNeedlogin(json.optString("needlogin"));
            data.setIsDefault(json.optString("is_default"));
            data.setSkinSource(json.optString("skin_source"));
            data.setSkinPrompt(json.optString("skin_describe"));
            data.setCategoryId(json.optString("category_id"));
            data.setThumbnail(json.optString("thumbnail"));
            JSONObject packageSkinDetail = json.optJSONObject(KEY_ATTRS_SKIN_DETAIL);
            if (packageSkinDetail != null) {
                SkinDetailData.PreviewDetailData previewDetailData = new SkinDetailData.PreviewDetailData();
                previewDetailData.parseJson(packageSkinDetail);
                data.setPreviewDetailData(previewDetailData);
            }
            data.setModelHomepage(generateThemeEntity(json.optJSONObject("homepage"), data.getId(), data.getIsVip(), data.getSkinSource()));
            data.setIsTaskType(json.optString(KEY_IS_TASK_TYPE));
            data.setIsTaskDone(json.optString(KEY_IS_TASK_DONE));
            data.setTaskButton(json.optString(KEY_TASK_BUTTON, "做任务获取皮肤"));
            data.setEffectiveDateEnd(json.optString(KEY_EFFECTIVE_DATE_END));
            data.setTaskScheme(json.optString(KEY_TASK_SCHEME));
            data.setSkinImgSource(json.optString(KEY_SKIN_IMG_SOURCE));
            JSONArray recommendArray = json.optJSONArray("recommend_list");
            if (recommendArray != null) {
                ArrayList<SkinDetailData.RecommendItem> recommendList = new ArrayList<>();
                int length = Math.min(recommendArray.length(), 20);
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject recommendItemJson = recommendArray.optJSONObject(i2);
                    if (recommendItemJson != null) {
                        SkinDetailData.RecommendItem recommendItem = new SkinDetailData.RecommendItem();
                        recommendItem.parseJson(recommendItemJson);
                        recommendList.add(recommendItem);
                    }
                }
                data.setRecommendList(recommendList);
            }
            return data;
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public static JSONObject generateThemeEntity(JSONObject packageSkin, String id, String isVip, String skinSource) {
        boolean hasNewBarSkin;
        if (packageSkin == null) {
            return null;
        }
        try {
            JSONObject resource = packageSkin.optJSONObject("resource");
            JSONArray uis = packageSkin.optJSONArray(KEY_ATTRS_UIS);
            if (!packageSkin.isNull(KEY_HAS_NEW_BAR_SKIN)) {
                hasNewBarSkin = TextUtils.equals(packageSkin.optString(KEY_HAS_NEW_BAR_SKIN), "1");
            } else {
                hasNewBarSkin = false;
            }
            for (int i2 = 0; i2 < uis.length(); i2++) {
                JSONObject jsonObject = uis.getJSONObject(i2);
                jsonObject.put("isVip", isVip);
                jsonObject.put("skin_source", skinSource);
                jsonObject.put(KEY_HAS_NEW_BAR_SKIN, hasNewBarSkin);
            }
            JSONObject config = new JSONObject();
            config.put("key", id);
            config.put("isVip", isVip);
            config.put("skin_source", skinSource);
            config.put(KEY_HAS_NEW_BAR_SKIN, hasNewBarSkin);
            JSONArray list = new JSONArray();
            list.put(CommonOperationModel.Item.generateJSONObject(id, (String) null, (String) null, isVip, resource, uis, config));
            return CommonOperationModel.generateJSONObject(list);
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return null;
        }
    }
}
