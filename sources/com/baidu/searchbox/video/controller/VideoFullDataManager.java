package com.baidu.searchbox.video.controller;

import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.searchbox.feed.FeedApi;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.event.VideoDestroyEvent;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.model.FeedPolicyModel;
import com.baidu.searchbox.feed.model.IFeedFlowModel;
import com.baidu.searchbox.feed.parser.IFeedDataParser;
import com.baidu.searchbox.feed.video.ILandscapeFetchListenerExt;
import com.baidu.searchbox.feed.video.model.VideoFullProtocol;
import com.baidu.searchbox.home.feed.video.ui.controler.ImmersiveVideoDataManager;
import com.baidu.searchbox.home.feed.videodetail.model.IVideoDetailProtocol;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.video.detail.DefaultParamsUtil;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.net.VideoRequester;
import com.baidu.searchbox.video.runtime.VideoRuntime;
import com.baidu.searchbox.video.util.TagConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoFullDataManager {
    private static final boolean DEBUG = VideoRuntime.DEBUG;
    private static final int HISTORY_SIZE = 20;
    private static final int MAX_VIDEO_LIST_SIZE = 100;
    public static final int PAGE_FIRST_REQUEST = 0;
    public static final int PAGE_NEXT = 1;
    public static final int PAGE_PREVIOUS = -1;
    private static final String TAG = "VideoFullDataManager";
    private static final String VID_PREFIX = "sv_";
    protected boolean isFetchingData = false;
    protected ArrayList<FeedBaseModel> mCachedVideoLists = new ArrayList<>(100);
    protected JSONObject mExtRequest;
    protected int mLevelLoadMore = 3;
    /* access modifiers changed from: private */
    public ILandscapeFetchListenerExt mOnVideoFullFirstLoadListener;
    /* access modifiers changed from: private */
    public ILandscapeFetchListenerExt mOnVideoFullLoadMoreListener;
    private String mOriginId;
    protected int mPageNum;
    protected String mPd;
    protected int mPlayAvailableTime;
    private ImmersiveVideoDataManager.LimitList<VideoDestroyEvent> mRecentWatchList = new ImmersiveVideoDataManager.LimitList<>(20);

    @Retention(RetentionPolicy.SOURCE)
    public @interface PageDirection {
    }

    public void setOriginId(String originId) {
        this.mOriginId = originId;
    }

    public void setFirstLoadDataListener(ILandscapeFetchListenerExt onVideoFullFirstLoadListener) {
        this.mOnVideoFullFirstLoadListener = onVideoFullFirstLoadListener;
    }

    public void setLoadMoreDataListener(ILandscapeFetchListenerExt onVideoFullLoadMoreListener) {
        this.mOnVideoFullLoadMoreListener = onVideoFullLoadMoreListener;
    }

    public void setExtRequest(JSONObject extRequest) {
        this.mExtRequest = extRequest;
    }

    public void setPd(String pd) {
        this.mPd = pd;
    }

    public void fetchFirstVideoFullLists(String sourceId, String insertIds) {
        fetchVideoFlowAsync(sourceId, this.mOriginId, insertIds, 0);
    }

    public void fetchMoreVideoFullLists(String sourceId, int pageDirection) {
        fetchVideoFlowAsync(sourceId, this.mOriginId, (String) null, pageDirection);
    }

    /* access modifiers changed from: protected */
    public void fetchVideoFlowAsync(String sourceId, String id, String insertIds, int pageDirection) {
        this.isFetchingData = true;
        Map<String, String> getParams = new HashMap<>();
        if (WebpUtils.isNAUseWebp()) {
            getParams.put("imgtype", WebpUtils.TYPE_IMG_WEBP);
        }
        VideoRequester.getVideoFullList(getParams, obtainPostParams(sourceId, id, insertIds, pageDirection, false), new VideoFlowResponseCallback(pageDirection));
    }

    /* access modifiers changed from: protected */
    public void handleResponsePage(boolean isFirst, FeedFlowModel response) {
        this.mPageNum++;
    }

    /* access modifiers changed from: protected */
    public int getRequestPage(int pageDirection) {
        return this.mPageNum;
    }

    public class VideoFlowResponseCallback extends ResponseCallback<FeedFlowModel> {
        private boolean firstRequest;
        private int pageDirection;

        public VideoFlowResponseCallback(int pageDirection2) {
            this.firstRequest = pageDirection2 == 0;
            this.pageDirection = pageDirection2;
        }

        public FeedFlowModel parseResponse(Response response, int statusCode) throws Exception {
            try {
                if (!response.isSuccessful()) {
                    return null;
                }
                IFeedDataParser<IFeedFlowModel, String> parser = FeedApi.DataParsers.defaultFlowModelConfig().business("video").cmd(new VideoFullProtocol().obtainCmdFlow()).isRestful(VideoFullDataManager.this.isRestfulProtocol()).build();
                ResponseBody responseBody = response.body();
                String responseString = null;
                if (responseBody != null) {
                    responseString = response.body() == null ? "" : responseBody.string();
                }
                return (FeedFlowModel) parser.parse(responseString);
            } catch (Exception e2) {
                return null;
            }
        }

        public void onSuccess(FeedFlowModel response, int statusCode) {
            VideoFullDataManager.this.isFetchingData = false;
            if (response != null) {
                FeedPolicyModel policyModel = response.feedPolicyModel;
                if (policyModel != null) {
                    if (policyModel.feedListPreLoadPosition > 0) {
                        VideoFullDataManager.this.mLevelLoadMore = policyModel.feedListPreLoadPosition;
                    }
                    VideoFullDataManager.this.mPlayAvailableTime = policyModel.playAvailableTime;
                }
                ArrayList<FeedBaseModel> list = response.feedBaseModelList;
                VideoFullDataManager.this.handleResponsePage(this.firstRequest, response);
                if (list != null && list.size() > 0) {
                    if (!this.firstRequest) {
                        ArrayList<FeedBaseModel> list2 = VideoFullDataManager.this.removeDuplicateInVideos(list);
                    }
                    if (this.firstRequest) {
                        if (VideoFullDataManager.this.mOnVideoFullFirstLoadListener != null) {
                            VideoFullDataManager.this.mOnVideoFullFirstLoadListener.onFetchVideoModel(response, this.pageDirection);
                        }
                    } else if (VideoFullDataManager.this.mOnVideoFullLoadMoreListener != null) {
                        VideoFullDataManager.this.mOnVideoFullLoadMoreListener.onFetchVideoModel(response, this.pageDirection);
                    }
                }
            }
        }

        public void onFail(Exception e2) {
            VideoFullDataManager.this.isFetchingData = false;
            if (VideoRuntime.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, String> obtainPostParams(String sourceId, String originVid, String insertIds, int pageDirection, boolean recommendRequest) {
        Map<String, String> postParams = new HashMap<>();
        JSONObject json = new JSONObject();
        try {
            JSONObject dataJson = new JSONObject();
            dataJson.put("origin_vid", originVid);
            if (!TextUtils.isEmpty(insertIds)) {
                dataJson.put(IVideoDetailProtocol.INSERT_IDS, insertIds);
                if (VideoRuntime.DEBUG) {
                    Log.d(TagConstants.INSERT_ID_TAG, "obtainPostParams : " + insertIds);
                }
            }
            int i2 = 0;
            dataJson.put("recommend_request", 0);
            dataJson.put("first_request", pageDirection == 0 ? 1 : 0);
            if (recommendRequest) {
                i2 = 1;
            }
            dataJson.put("recommend_request", i2);
            dataJson.put("recent_watched_list", getUploadProgressList(this.mRecentWatchList.getList()));
            DefaultParamsUtil.setVideoScoreParams(dataJson);
            dataJson.put("act_type", getPageDirectionString(pageDirection));
            dataJson.put("source_id", sourceId);
            dataJson.put(IntentData.Protocol.KEY_EXT_REQUEST, this.mExtRequest);
            dataJson.put("source", this.mPd);
            json.put("data", dataJson);
            if (FeedAbtestManager.isRestfulProtocol()) {
                postParams.put("data", dataJson.toString());
            } else {
                postParams.put("data", json.toString());
            }
        } catch (JSONException e2) {
            postParams.put("data", "");
        }
        return postParams;
    }

    private String getPageDirectionString(int pageDirection) {
        switch (pageDirection) {
            case -1:
                return "down";
            case 0:
            case 1:
                return "up";
            default:
                return "";
        }
    }

    public void removeLoadDataListener() {
        if (this.mOnVideoFullFirstLoadListener != null) {
            this.mOnVideoFullFirstLoadListener = null;
        }
        if (this.mOnVideoFullLoadMoreListener != null) {
            this.mOnVideoFullLoadMoreListener = null;
        }
    }

    public boolean isNeedLoadMoreData(int position) {
        return this.mCachedVideoLists.size() > this.mLevelLoadMore && position >= this.mCachedVideoLists.size() - this.mLevelLoadMore;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r2.mCachedVideoLists.size();
        r1 = r2.mLevelLoadMore;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isNeedLoadPrevPage(int r3) {
        /*
            r2 = this;
            boolean r0 = r2.canLoadPrePage()
            if (r0 == 0) goto L_0x0014
            java.util.ArrayList<com.baidu.searchbox.feed.model.FeedBaseModel> r0 = r2.mCachedVideoLists
            int r0 = r0.size()
            int r1 = r2.mLevelLoadMore
            if (r0 <= r1) goto L_0x0014
            if (r3 > r1) goto L_0x0014
            r0 = 1
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.controller.VideoFullDataManager.isNeedLoadPrevPage(int):boolean");
    }

    public boolean canLoadPrePage() {
        JSONObject jSONObject = this.mExtRequest;
        return jSONObject != null && "1".equals(jSONObject.optString("full_screen_action_down"));
    }

    public boolean hasNextData(int position) {
        return position < this.mCachedVideoLists.size() - 1 && position >= 0;
    }

    public void saveToCachedVideoLists(ArrayList<FeedBaseModel> cachedVideos) {
        this.mCachedVideoLists.addAll(cachedVideos);
    }

    public void addToWatchList(VideoDestroyEvent endEvent) {
        this.mRecentWatchList.add(endEvent);
    }

    private JSONArray getUploadProgressList(List<VideoDestroyEvent> recentWatchList) {
        if (recentWatchList == null) {
            return null;
        }
        JSONArray uploads = new JSONArray();
        try {
            for (VideoDestroyEvent event : recentWatchList) {
                JSONObject json = new JSONObject();
                String vid = event.vid;
                if (vid != null && vid.startsWith("sv_")) {
                    vid = vid.substring("sv_".length());
                }
                json.put("vid", vid);
                json.put("completed", event.completed);
                uploads.put(json);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (DEBUG) {
            android.util.Log.d(TAG, "upload data -->" + uploads.toString());
        }
        return uploads;
    }

    public ArrayList<FeedBaseModel> getCachedVideoLists() {
        return this.mCachedVideoLists;
    }

    public void clearCachedFeeds() {
        this.mCachedVideoLists.clear();
    }

    /* access modifiers changed from: private */
    public ArrayList<FeedBaseModel> removeDuplicateInVideos(ArrayList<FeedBaseModel> newVideos) {
        ArrayList<FeedBaseModel> arrayList;
        if (newVideos == null || newVideos.size() == 0 || (arrayList = this.mCachedVideoLists) == null || arrayList.size() == 0) {
            return newVideos;
        }
        return processDuplicate(newVideos, this.mCachedVideoLists);
    }

    private ArrayList<FeedBaseModel> processDuplicate(ArrayList<FeedBaseModel> newOriginVideos, ArrayList<FeedBaseModel> oldCacheVideos) {
        if (newOriginVideos == null || oldCacheVideos == null || newOriginVideos.size() <= 0 || oldCacheVideos.size() <= 0) {
            return newOriginVideos;
        }
        HashMap<String, FeedBaseModel> newFeedsMapNid = new HashMap<>(newOriginVideos.size());
        ArrayList<FeedBaseModel> newDuplicateFeeds = new ArrayList<>(5);
        Iterator<FeedBaseModel> it = newOriginVideos.iterator();
        while (it.hasNext()) {
            FeedBaseModel entity = it.next();
            newFeedsMapNid.put(entity.id, entity);
        }
        int i2 = oldCacheVideos.size();
        while (true) {
            i2--;
            if (i2 < 0) {
                break;
            }
            FeedBaseModel oldEntity = oldCacheVideos.get(i2);
            if (oldEntity != null) {
                if (DEBUG) {
                    Log.d(TAG, "entity.id --> " + oldEntity.id);
                }
                FeedBaseModel newVideoEntity = newFeedsMapNid.get(oldEntity.id);
                if (newVideoEntity != null) {
                    newDuplicateFeeds.add(newVideoEntity);
                }
            }
        }
        if (newDuplicateFeeds.size() > 0) {
            if (DEBUG) {
                Log.d(TAG, "newDuplicateFeeds --> " + newOriginVideos.size());
            }
            newOriginVideos.removeAll(newDuplicateFeeds);
        }
        return newOriginVideos;
    }

    public int getPlayAvailableTime() {
        return this.mPlayAvailableTime;
    }

    /* access modifiers changed from: protected */
    public boolean isRestfulProtocol() {
        return false;
    }

    public boolean isFetchingData() {
        return this.isFetchingData;
    }
}
