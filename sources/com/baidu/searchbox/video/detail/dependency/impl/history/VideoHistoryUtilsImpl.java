package com.baidu.searchbox.video.detail.dependency.impl.history;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.history.api.IHistoryManager;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.data.HistoryFeature;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.history.api.data.VideoModel;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoHistoryUtils;
import org.json.JSONObject;

public class VideoHistoryUtilsImpl implements IVideoHistoryUtils {
    public void isInHistory(String uKey, final IVideoHistoryUtils.HistoryDataCallback<Boolean> callback) {
        ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).isInHistory(uKey, new HistoryDataCallback<Boolean>() {
            public void onResult(Boolean aBoolean) {
                IVideoHistoryUtils.HistoryDataCallback historyDataCallback = callback;
                if (historyDataCallback != null) {
                    historyDataCallback.onResult(aBoolean);
                }
            }
        });
    }

    public void addHistory(String options, JSONObject ubcJson) {
        try {
            if (!TextUtils.isEmpty(options)) {
                JSONObject favoriteJo = new JSONObject(options);
                String ukey = favoriteJo.optString("ukey");
                String tplid = favoriteJo.optString("tplid");
                String title = favoriteJo.optString("title");
                String img = favoriteJo.optString("img");
                String url = favoriteJo.optString("url");
                String cmd = favoriteJo.optString("cmd");
                HistoryModel historyModel = new HistoryModel();
                historyModel.setUkey(ukey);
                historyModel.setTplId(tplid);
                historyModel.setTitle(title);
                historyModel.setImg(img);
                historyModel.setUrl(url);
                historyModel.setCmd(cmd);
                historyModel.setCreateTime(System.currentTimeMillis());
                HistoryFeature feature = new HistoryFeature();
                feature.setSource(favoriteJo.optString("source"));
                feature.setUserName(favoriteJo.optString("username"));
                feature.setUserCmd(favoriteJo.optString("usercmd"));
                feature.setUserDesc(favoriteJo.optString("userdesc"));
                feature.setPortrait(favoriteJo.optString("portrait"));
                String duration = favoriteJo.optString("duration");
                if (!TextUtils.isEmpty(duration)) {
                    try {
                        feature.setDuration(Long.parseLong(duration));
                    } catch (NumberFormatException e2) {
                        if (IVideoAppConfig.Impl.get().isDebug()) {
                            e2.printStackTrace();
                        }
                    }
                }
                String authorName = favoriteJo.optString(IntentData.AUTHOR_NAME);
                String publishTime = favoriteJo.optString("publishTime");
                String str = ukey;
                int viewCount = favoriteJo.optInt("view");
                String str2 = tplid;
                String portraitImage = favoriteJo.optString("image_3_4");
                String str3 = title;
                String horizontalImage = favoriteJo.optString("image_4_3");
                JSONObject jSONObject = favoriteJo;
                VideoModel videoModel = new VideoModel();
                videoModel.setVideoAuthorName(authorName);
                videoModel.setVideoPublishTime(publishTime);
                videoModel.setVideoPlayCount(viewCount);
                videoModel.setVideoCoverThreeRatioFour(portraitImage);
                videoModel.setVideoCoverFourRatioThree(horizontalImage);
                feature.setVideoModel(videoModel);
                historyModel.setFeature(feature);
                String str4 = authorName;
                String str5 = publishTime;
                JSONObject jSONObject2 = new JSONObject();
                VideoModel videoModel2 = videoModel;
                JSONObject extra = jSONObject2;
                extra.putOpt("ubcjson", ubcJson);
                historyModel.setExtra(extra.toString());
                ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).addHistory(historyModel, (HistoryDataCallback<Boolean>) null);
            }
        } catch (Exception e3) {
            if (IVideoAppConfig.Impl.get().isDebug()) {
                e3.printStackTrace();
            }
        }
    }
}
