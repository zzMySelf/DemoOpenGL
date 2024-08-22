package com.baidu.searchbox.theme.skin.utils;

import android.text.TextUtils;
import com.baidu.common.operation.CommonOperationModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SkinDetailData {
    public static final String DU_VIP_VALUE = "1";
    public static final String NEED_LOGIN_TRUE_VALUE = "1";
    public static final String NOT_VIP_VALUE = "0";
    public static final String SPOKESMAN_VIP_VALUE = "2";
    private String categoryId = null;
    private String effectiveDateEnd = null;
    private String id = null;
    private String isDefault = null;
    private String isTaskDone = null;
    private String isTaskType = null;
    private String isVip = null;
    private JSONObject modelHomepage = null;
    private String needlogin = null;
    private PreviewDetailData previewDetailData;
    private ArrayList<RecommendItem> recommendList = null;
    private String skinImgSource = null;
    private String skinPrompt = null;
    private String skinSource = null;
    private String taskButton = null;
    private String taskScheme = null;
    private String thumbnail = null;
    private String vipScheme = null;

    public String getSkinSource() {
        return this.skinSource;
    }

    public void setSkinSource(String skinSource2) {
        this.skinSource = skinSource2;
    }

    public String getId() {
        return !TextUtils.isEmpty(this.id) ? this.id : "";
    }

    public void setId(String skinId) {
        this.id = skinId;
    }

    public String getIsVip() {
        return this.isVip;
    }

    public void setIsVip(String isVip2) {
        this.isVip = isVip2;
    }

    public String getVipScheme() {
        return !TextUtils.isEmpty(this.vipScheme) ? this.vipScheme : "";
    }

    public void setVipScheme(String vipScheme2) {
        this.vipScheme = vipScheme2;
    }

    public String getNeedlogin() {
        return this.needlogin;
    }

    public void setNeedlogin(String needlogin2) {
        this.needlogin = needlogin2;
    }

    public boolean isNeedLogin() {
        return TextUtils.equals(this.needlogin, "1");
    }

    public void setSkinPrompt(String prompt) {
        this.skinPrompt = prompt;
    }

    public String getSkinPrompt() {
        return this.skinPrompt;
    }

    public void setCategoryId(String categoryId2) {
        this.categoryId = categoryId2;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public void setThumbnail(String thumbnail2) {
        this.thumbnail = thumbnail2;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public String getIsDefault() {
        return this.isDefault;
    }

    public void setIsDefault(String isDefault2) {
        this.isDefault = isDefault2;
    }

    public PreviewDetailData getPreviewDetailData() {
        return this.previewDetailData;
    }

    public void setPreviewDetailData(PreviewDetailData previewDetailData2) {
        this.previewDetailData = previewDetailData2;
    }

    public boolean isSpokesmanVipSkin() {
        return TextUtils.equals(this.isVip, "2");
    }

    public boolean isDuVipSkin() {
        return TextUtils.equals(this.isVip, "1");
    }

    public JSONObject getModelHomepage() {
        return this.modelHomepage;
    }

    public void setModelHomepage(JSONObject modelHomepage2) {
        this.modelHomepage = modelHomepage2;
    }

    public boolean getIsTaskType() {
        return TextUtils.equals(this.isTaskType, "1");
    }

    public void setIsTaskType(String isTaskType2) {
        this.isTaskType = isTaskType2;
    }

    public boolean getIsTaskDone() {
        return TextUtils.equals(this.isTaskDone, "1");
    }

    public void setIsTaskDone(String isTaskDone2) {
        this.isTaskDone = isTaskDone2;
    }

    public String getTaskButton() {
        return this.taskButton;
    }

    public void setTaskButton(String taskButton2) {
        this.taskButton = taskButton2;
    }

    public String getEffectiveDateEnd() {
        return !TextUtils.isEmpty(this.effectiveDateEnd) ? this.effectiveDateEnd : "";
    }

    public void setEffectiveDateEnd(String effectiveDateEnd2) {
        this.effectiveDateEnd = effectiveDateEnd2;
    }

    public String getTaskScheme() {
        return this.taskScheme;
    }

    public void setTaskScheme(String taskScheme2) {
        this.taskScheme = taskScheme2;
    }

    public String getSkinImgSource() {
        return !TextUtils.isEmpty(this.skinImgSource) ? this.skinImgSource : "";
    }

    public void setSkinImgSource(String skinImgSource2) {
        this.skinImgSource = skinImgSource2;
    }

    public void setRecommendList(ArrayList<RecommendItem> list) {
        this.recommendList = list;
    }

    public ArrayList<RecommendItem> getRecommendList() {
        return this.recommendList;
    }

    public static class PreviewDetailData {
        private CommonOperationModel.Resource mResource;
        private List<SkinPage> mSkinPages = new ArrayList();

        public CommonOperationModel.Resource getResource() {
            return this.mResource;
        }

        public void setResource(CommonOperationModel.Resource resource) {
            this.mResource = resource;
        }

        public List<SkinPage> getSkinPages() {
            return this.mSkinPages;
        }

        public void setSkinPages(List<SkinPage> skinPages) {
            this.mSkinPages.clear();
            this.mSkinPages.addAll(skinPages);
        }

        public void parseJson(JSONObject jsonObject) {
            if (jsonObject != null) {
                setResource(CommonOperationModel.Resource.parseJSONObject(jsonObject.optJSONObject("resource")));
                JSONArray skinListJsonArray = jsonObject.optJSONArray("skinlist");
                if (skinListJsonArray != null) {
                    List<SkinPage> skinPages = new ArrayList<>();
                    for (int i2 = 0; i2 < skinListJsonArray.length(); i2++) {
                        JSONObject skinItemJson = skinListJsonArray.optJSONObject(i2);
                        if (skinItemJson != null) {
                            SkinPage skinPage = new SkinPage();
                            skinPage.parseJson(skinItemJson);
                            skinPages.add(skinPage);
                        }
                    }
                    setSkinPages(skinPages);
                }
            }
        }

        public static class SkinPage {
            private String mTitle;
            private List<CommonOperationModel.UIModel> mUIs = new ArrayList();

            public List<CommonOperationModel.UIModel> getUIs() {
                return this.mUIs;
            }

            public void setUIs(List<CommonOperationModel.UIModel> mUIs2) {
                this.mUIs.clear();
                this.mUIs.addAll(mUIs2);
            }

            public String getTitle() {
                return this.mTitle;
            }

            public void setTitle(String title) {
                this.mTitle = title;
            }

            public void parseJson(JSONObject jsonObject) {
                if (jsonObject != null) {
                    setTitle(jsonObject.optString("title"));
                    JSONArray uisJsonArray = jsonObject.optJSONArray(SkinDetailDataParser.KEY_ATTRS_UIS);
                    if (uisJsonArray != null) {
                        List<CommonOperationModel.UIModel> uis = new ArrayList<>();
                        for (int i2 = 0; i2 < uisJsonArray.length(); i2++) {
                            JSONObject uiJson = uisJsonArray.optJSONObject(i2);
                            if (uiJson != null) {
                                uis.add(CommonOperationModel.UIModel.parseJSONObject(uiJson));
                            }
                        }
                        setUIs(uis);
                    }
                }
            }
        }
    }

    public static class RecommendItem {
        public String id = null;
        public boolean isApplied = false;
        public boolean isSelected = false;
        public String isVip = null;
        public String name = null;
        public String signUrl = null;
        public String thumbnail = null;
        public String thumbnailDn = null;

        public void parseJson(JSONObject jsonObject) {
            if (jsonObject != null) {
                this.id = jsonObject.optString("id");
                this.name = jsonObject.optString("name");
                this.isVip = jsonObject.optString("is_vip");
                this.thumbnail = jsonObject.optString("thumbnail");
                this.thumbnailDn = jsonObject.optString(SkinDataParser.KEY_ATTRS_THUMBNAIL_DN);
                this.signUrl = jsonObject.optString(SkinDataParser.KEY_ATTRS_SIGN_URL);
            }
        }
    }
}
