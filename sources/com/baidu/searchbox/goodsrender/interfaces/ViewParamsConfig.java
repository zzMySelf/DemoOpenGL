package com.baidu.searchbox.goodsrender.interfaces;

import android.content.Context;
import org.json.JSONObject;

public class ViewParamsConfig {
    public static final String KEY_BUSINESS_ID = "businessId";
    public static final String KEY_IS_CORE = "is_core";
    public static final String KEY_NEW_CACHE = "new_cache";
    public static final String KEY_RENDER_ID = "render_id";
    public static final String KEY_WRAP_SIZE = "wrap_size";
    private String businessId;
    private String defaultTemplateId;
    private JSONObject mBusinessJson;
    private Context mContext;
    private IViewEventListener mListener;
    private IBaseListener mUpgradeListener;
    private String scene;

    public ViewParamsConfig(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context mContext2) {
        this.mContext = mContext2;
    }

    public IViewEventListener getListener() {
        return this.mListener;
    }

    public void setListener(IViewEventListener listener) {
        this.mListener = listener;
    }

    public void setUpgradeListener(IBaseListener listener) {
        this.mUpgradeListener = listener;
    }

    public IBaseListener getEventListener() {
        IViewEventListener iViewEventListener = this.mListener;
        if (iViewEventListener != null) {
            return iViewEventListener;
        }
        return this.mUpgradeListener;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String scene2) {
        this.scene = scene2;
    }

    public String getDefaultTemplateId() {
        return this.defaultTemplateId;
    }

    public void setDefaultTemplateId(String defaultTemplateId2) {
        this.defaultTemplateId = defaultTemplateId2;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String businessId2) {
        this.businessId = businessId2;
    }

    public JSONObject getBusinessJson() {
        return this.mBusinessJson;
    }

    public void setBusinessJson(JSONObject json) {
        this.mBusinessJson = json;
    }
}
