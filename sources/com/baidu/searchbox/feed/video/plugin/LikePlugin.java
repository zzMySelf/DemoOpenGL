package com.baidu.searchbox.feed.video.plugin;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.searchbox.feed.video.plugin.service.LikeStateService;
import com.baidu.searchbox.video.detail.core.plugin.PluginAdapter;
import com.baidu.searchbox.video.detail.export.IVideoBaiduIdentityManager;
import com.baidu.searchbox.video.detail.export.IVideoRouter;
import com.baidu.searchbox.video.detail.export.IVideoUploadLikeDataToServer;
import com.baidu.searchbox.video.detail.message.MessageUtils;
import com.baidu.searchbox.video.detail.service.ILikeStateService;
import com.baidu.searchbox.video.detail.utils.VideoUrlConfig;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LikePlugin extends PluginAdapter {
    protected String mReportCmd;

    public void injectService() {
        this.mComponentManager.registerServices(ILikeStateService.class, new LikeStateService(this));
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what != 36608) {
            return;
        }
        if (message.arg1 == 36610) {
            setReportInfoData();
        } else if (MessageUtils.needResetData(message)) {
            this.mReportCmd = null;
        }
    }

    private void setReportInfoData() {
        if (this.mComponentManager.currentModel.commonModel != null && !TextUtils.isEmpty(this.mComponentManager.currentModel.commonModel.reportCmd)) {
            this.mReportCmd = this.mComponentManager.currentModel.commonModel.reportCmd;
        }
    }

    public void processReport() {
        if (!TextUtils.isEmpty(this.mReportCmd)) {
            IVideoRouter.Impl.get().invoke(this.mContext, this.mReportCmd);
        }
    }

    public void processLike(Map<String, Object> paramsMap) {
        String url = IVideoBaiduIdentityManager.Impl.get().processUrl(VideoUrlConfig.getLikeUrl());
        JSONObject json = new JSONObject();
        try {
            json.put("nid", paramsMap.get("nid"));
            json.put("type", paramsMap.get("type"));
            json.put("ext", paramsMap.get("ext"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        processData(url, json.toString());
    }

    private void processData(String url, String params) {
        Map<String, String> postParams = new HashMap<>();
        postParams.put("data", params);
        IVideoUploadLikeDataToServer.Impl.get().uploadLikeDataToServer(url, postParams);
    }
}
