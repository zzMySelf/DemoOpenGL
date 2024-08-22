package com.baidu.searchbox.video;

import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.net.ConnectManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.net.common.HttpRequestInfo;
import com.baidu.searchbox.net.common.HttpRequester;
import com.baidu.searchbox.net.common.IResponseHandler;
import com.baidu.searchbox.net.common.IResponseParser;
import com.baidu.searchbox.net.common.ParamPair;
import com.baidu.searchbox.net.common.ResponseHandler;
import com.baidu.searchbox.video.detail.export.IVideoIdentityManager;
import com.baidu.searchbox.video.favorite.FavoriteList;
import com.baidu.searchbox.video.favorite.VideoFavoriteItemInfo;
import com.baidu.searchbox.video.favorite.VideoFavoriteParseCallBack;
import com.baidu.searchbox.video.favorite.VideoFavoriteUpdateManager;
import com.baidu.searchbox.video.util.VideoDBControlUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class VideoFavoriteUpdateTask {
    /* access modifiers changed from: private */
    public final String mAction;
    private final List<VideoFavoriteItemInfo> mList;
    /* access modifiers changed from: private */
    public final String mType;
    private final String mUrl = getVideoFavoriteUpdateUrl();
    private final VideoFavoriteParseCallBack mVideoFavoriteParseCallBack;

    public VideoFavoriteUpdateTask(String action, String type, List<VideoFavoriteItemInfo> list, VideoFavoriteParseCallBack videoFavoriteParseCallBack) {
        this.mAction = action;
        this.mType = type;
        this.mList = list;
        this.mVideoFavoriteParseCallBack = videoFavoriteParseCallBack;
    }

    public boolean executeSync() {
        if (!ConnectManager.isNetworkConnected(FeedRuntime.getAppContext())) {
            return false;
        }
        run();
        return true;
    }

    public void run() {
        Process.setThreadPriority(10);
        if (UrlUtil.isUrl(this.mUrl) && !UrlUtil.isUrlAuxiliary(this.mUrl)) {
            List<ParamPair<?>> list = VideoDBControlUtils.getInstance().getParamList(this.mList);
            IResponseParser<InputStream, FavoriteList> parser = new ResponseParser();
            if (list != null) {
                HttpRequestInfo requestInfo = new HttpRequestInfo(IVideoIdentityManager.Impl.get().processUrl(this.mUrl), (byte) 2);
                new HttpRequester<>(AppRuntime.getAppContext()).requestSync(requestInfo, list, parser, new ResponseHandler(requestInfo, (IResponseHandler.ResponseCallback) null));
            }
        }
    }

    private class ResponseParser implements IResponseParser<InputStream, FavoriteList> {
        private ResponseParser() {
        }

        public FavoriteList parseResponse(InputStream result) {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(StringUtil.getStringFromInput(result));
            } catch (Exception var7) {
                if (AppConfig.isDebug()) {
                    var7.printStackTrace();
                }
            }
            VideoFavoriteUpdateTask videoFavoriteUpdateTask = VideoFavoriteUpdateTask.this;
            ActionJsonData actionData = videoFavoriteUpdateTask.getAction(jsonObject, videoFavoriteUpdateTask.mAction, VideoFavoriteUpdateTask.this.mType);
            if (actionData != null) {
                return VideoFavoriteUpdateTask.this.parseData(actionData);
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public ActionJsonData getAction(JSONObject object, String actionName, String actionType) {
        JSONObject action;
        if (object == null || TextUtils.isEmpty(actionName) || !object.has(actionName) || object.isNull(actionName) || (action = object.optJSONObject(actionName)) == null) {
            return null;
        }
        if (TextUtils.isEmpty(actionType)) {
            return ActionJsonData.fromJson(action);
        }
        return ActionJsonData.fromJson(action.optJSONObject(actionType));
    }

    /* access modifiers changed from: private */
    public FavoriteList parseData(ActionJsonData actionData) {
        List<VideoFavoriteItemInfo> result = new ArrayList<>();
        List<JSONObject> dataset = actionData.getDataset();
        if (dataset != null && dataset.size() > 0) {
            for (int i2 = 0; i2 < dataset.size(); i2++) {
                result.add(VideoFavoriteUpdateManager.dealVideoFavoriteInfo(dataset.get(i2).toString()));
            }
        }
        FavoriteList temp = new FavoriteList();
        temp.setFavoriteList(result);
        VideoFavoriteParseCallBack videoFavoriteParseCallBack = this.mVideoFavoriteParseCallBack;
        if (videoFavoriteParseCallBack != null) {
            videoFavoriteParseCallBack.parseFinish(result);
        }
        return temp;
    }

    private String getVideoFavoriteUpdateUrl() {
        return String.format("%s/platapi/boxapp/collect_update", new Object[]{HostConfig.getVideoHost()});
    }
}
