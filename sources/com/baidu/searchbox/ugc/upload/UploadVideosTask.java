package com.baidu.searchbox.ugc.upload;

import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.publisher.controller.IPublisherManagerInterface;
import com.baidu.searchbox.ugc.bridge.UgcRuntime;
import com.baidu.searchbox.ugc.upload.HttpRequestTokenModule;
import com.baidu.searchbox.ugc.utils.CompressImageUtil;
import com.baidu.searchbox.ugc.utils.FileHelper;
import com.baidu.searchbox.ugc.utils.FileUtils;
import com.baidu.searchbox.ugc.utils.LogUtil;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.searchbox.ugc.utils.UgcPerformanceUbcUtils;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.searchbox.ugc.utils.UgcUbcDataKeeper;
import com.baidu.searchbox.ugc.utils.UgcUriUtils;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidubce.services.bos.model.ObjectMetadata;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.codec.digest4util.MD5Utils;
import org.json.JSONException;
import org.json.JSONObject;

public class UploadVideosTask extends UploadFileTask {
    private static final String AUDIO_MIME = "audio/mp4a-latm";
    private static final String CONTENT_TYPE = "video/mp4";
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final int DEFAULT_PROGRESS_DURATION = 10000;
    private static final String EXTENSION = "mp4";
    private static final String HEVC_VIDEO_MIME = "video/hevc";
    public static final int HTTP_STATUS_CODE_OK = 200;
    private static final String PREVIEW_MODE = "preview";
    private static final String TAG = UploadVideosTask.class.getSimpleName();
    private static final String TRANSCODING_GROUP_NAME = "vod.inbuilt.notranscoding.mp4";
    private static final String TRANSCODING_MODE = "no_transcoding";
    private static final int VIDEO_MAX_EDGELEN = 1920;
    private static final String VIDEO_MIME = "video/avc";
    private static final int VOD_PRIORITY_DEFAULT = 5;
    private static String onlineTemplate = "online_template_shortvideo";
    private String originUrl = null;
    protected VideoModel videoModel = null;

    public VideoModel getVideoModel() {
        return this.videoModel;
    }

    public void setVideoModel(VideoModel model) {
        this.videoModel = model;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public void setOriginUrl(String originUrl2) {
        this.originUrl = originUrl2;
    }

    public UploadVideosTask(VideoModel model) {
        setFileName(model.getVideoPath());
        setFileLocalPath(model.getVideoPath());
        setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".mp4", model.getVideoPath()));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("video/mp4");
        setObjectMetadata(objectMetadata);
    }

    public UploadVideosTask(String fileName) {
        setFileName(fileName);
        setFileLocalPath(fileName);
        setCompressFileName(FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".mp4", fileName));
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentType("video/mp4");
        setObjectMetadata(objectMetadata);
    }

    public boolean handleCompress() {
        if (this.mCallback != null) {
            this.mCallback.onStart(this);
        }
        if (isCompressSuccess()) {
            return true;
        }
        int duration = getVideoDuration();
        if (duration > 0) {
            int duration2 = duration / 2;
        }
        String str = TAG;
        LogUtil.d(str, "handleCompress isNotNeedCompress():" + isNotNeedCompress());
        String path = UgcUriUtils.getFilePathByUri(AppRuntime.getAppContext(), Uri.parse(getFileName()));
        LogUtil.d(str, "handleNotNeedCompress path " + path);
        setCompressFileName(path);
        setCompressSuccess(true);
        setNotNeedCompressFlag(true);
        UgcPerformanceUbcUtils.ugcVideoCompressStatistics(-1, false, 0, 0, 0);
        return true;
    }

    private boolean executeLocalTranscoder() {
        return false;
    }

    private boolean executeTranscoderPlugin() {
        LogUtil.d(TAG, "executeTranscoderPlugin!");
        return false;
    }

    private void copyVideo() {
        String originVideo = getFileName();
        if (!TextUtils.isEmpty(originVideo) && UgcUriUtils.isLocalContentUri(UgcUriUtils.getUri(originVideo))) {
            String targetFilePath = FileUtils.createTempFileName(FileUtils.getUploadCacheDir(), ".mp4", getFileName());
            if (!this.isCanceled && CompressImageUtil.copyFile(originVideo, targetFilePath)) {
                setFileName(targetFilePath);
            }
        }
    }

    private boolean isNotNeedCompress() {
        boolean videoSizeOk = false;
        MediaMetadataRetriever m = FileUtils.getMediaMetadataRetriever(getFileName());
        if (m == null) {
            return false;
        }
        String strWidth = m.extractMetadata(18);
        String strHeight = m.extractMetadata(19);
        try {
            int width = Integer.parseInt(strWidth);
            int height = Integer.parseInt(strHeight);
            if (width <= 1920 && height <= 1920) {
                videoSizeOk = true;
            }
            try {
                m.release();
            } catch (Throwable th2) {
                LogUtil.e(th2);
            }
        } catch (Throwable th3) {
            LogUtil.e(th3);
        }
        boolean videoMimeOk = false;
        boolean audioMimeOk = false;
        MediaExtractor mediaExtractor = FileUtils.getMediaExtractor(getFileName());
        if (mediaExtractor != null) {
            int count = mediaExtractor.getTrackCount();
            for (int i2 = 0; i2 < count; i2++) {
                String mime = mediaExtractor.getTrackFormat(i2).getString("mime");
                UgcUbcDataKeeper.setVideoFormat(mime);
                if (!TextUtils.isEmpty(mime)) {
                    if (mime.equals("video/avc") || mime.equals("video/hevc")) {
                        videoMimeOk = true;
                    } else if (mime.equals(AUDIO_MIME)) {
                        audioMimeOk = true;
                    }
                }
            }
            mediaExtractor.release();
        }
        if (!videoSizeOk || !videoMimeOk || !audioMimeOk) {
            return false;
        }
        return true;
    }

    private int getVideoDuration() {
        int ret = -1;
        MediaMetadataRetriever mmr = FileUtils.getMediaMetadataRetriever(getFileName());
        if (mmr == null) {
            return -1;
        }
        try {
            ret = Integer.parseInt(mmr.extractMetadata(9));
            try {
                mmr.release();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            if (DEBUG) {
                e3.printStackTrace();
            }
            mmr.release();
        } catch (Throwable th2) {
            try {
                mmr.release();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            throw th2;
        }
        return ret;
    }

    public void run() {
        setStatus(2);
        if (this.mSTSInfo == null) {
            this.mErrorMsg = "mSTSInfo = null";
            this.mErrorCode = 7;
            uploadFail();
            return;
        }
        try {
            IPublisherManagerInterface publisherInterfaceManager = (IPublisherManagerInterface) ServiceManager.getService(IPublisherManagerInterface.SERVICE_REFERENCE);
            if (publisherInterfaceManager != null) {
                publisherInterfaceManager.setVideoUploadInfo(getCompressFileName());
                if (uploadFile(FileHelper.exists(getCompressFileName()) ? getCompressFileName() : getFileName())) {
                    finishPlayProgress();
                    this.mStatus = 4;
                    notifySuccessOrFailed(true);
                    return;
                }
                if (this.mErrorCode == 11) {
                    this.mStatus = 4;
                    notifySuccessOrFailed(true);
                } else {
                    uploadFail();
                }
                uploadFail();
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
            this.mErrorMsg = "UploadVideosTask e : " + Log.getStackTraceString(e2);
            this.mErrorCode = 8;
        }
    }

    public String requestUploadVideoCallback(HttpRequestTokenModule.STSInfo stsInfo) {
        String callbackUrl;
        ResponseBody body;
        if (stsInfo == null || TextUtils.isEmpty(stsInfo.mediaId) || TextUtils.isEmpty(stsInfo.sourceKey) || TextUtils.isEmpty(stsInfo.sourceBucket) || TextUtils.isEmpty(stsInfo.host) || TextUtils.isEmpty(stsInfo.region)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        try {
            JSONObject videoApplyJsonObject = new JSONObject();
            videoApplyJsonObject.put("mediaId", stsInfo.mediaId);
            videoApplyJsonObject.put("sourceKey", stsInfo.sourceKey);
            videoApplyJsonObject.put("sourceBucket", stsInfo.sourceBucket);
            videoApplyJsonObject.put("host", stsInfo.host);
            videoApplyJsonObject.put("region", stsInfo.region);
            params.put("videoApply", videoApplyJsonObject.toString());
            try {
                JSONObject videoTransJsonObject = new JSONObject();
                videoTransJsonObject.put("priority", 5);
                videoTransJsonObject.put("title", getVodTitle(getCompressFileName()));
                videoTransJsonObject.put("sourceExtension", "mp4");
                videoTransJsonObject.put("description", getVodDescription(getCompressFileName()));
                videoTransJsonObject.put("transcodingPresetGroupName", onlineTemplate);
                params.put("videoTrans", videoTransJsonObject.toString());
                if (TextUtils.isEmpty(this.uploadCallbackUrl)) {
                    callbackUrl = UgcServerApiUtils.getDynamicUploadVideoCallback();
                } else {
                    callbackUrl = this.uploadCallbackUrl;
                }
                try {
                    HttpRequestBuilder requestBuilder = ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(UgcServerApiUtils.processCommonParams(callbackUrl))).addParams(params)).cookieManager((CookieManager) UgcRuntime.getUgcInterface().newCookieManagerInstance(false, false))).requestFrom(20)).requestSubFrom(8)).enableStat(true);
                    String userAgent = UgcServerApiUtils.getPublisherUserAgent();
                    if (!TextUtils.isEmpty(userAgent)) {
                        requestBuilder.addHeader("User-Agent", userAgent);
                    }
                    String refer = UgcServerApiUtils.getReferer();
                    if (!TextUtils.isEmpty(refer)) {
                        requestBuilder.addHeader("Referer", refer);
                    }
                    requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
                    Response httpResponse = requestBuilder.build().executeSync();
                    if (httpResponse == null || httpResponse.code() != 200 || (body = httpResponse.body()) == null) {
                        return null;
                    }
                    String resultStr = body.string();
                    if (DEBUG) {
                        Log.e(TAG, "requestUploadVideoCallback response: " + resultStr);
                    }
                    if (TextUtils.isEmpty(resultStr)) {
                        return null;
                    }
                    return resultStr;
                } catch (Exception e2) {
                    if (DEBUG) {
                        e2.printStackTrace();
                    }
                    return null;
                }
            } catch (JSONException e3) {
                e3.printStackTrace();
                return null;
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private void uploadFail() {
        stopPlayProgress();
        if (getStatus() != 3) {
            this.mStatus = 5;
        }
        notifySuccessOrFailed(false);
    }

    private String getVodTitle(String filePath) {
        return "sbugc_" + BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).getIpInfo() + "_" + "mp4" + "_" + MD5Utils.toMd5(new File(filePath), false);
    }

    private String getVodDescription(String filePath) {
        JSONObject desJson = new JSONObject();
        BoxAccountManager accountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (!accountManager.isLogin()) {
            return "";
        }
        String userName = accountManager.getSession("user_login_nickname_key");
        String uk = UgcLoginUtils.getUK();
        try {
            desJson.put("media_name", filePath);
            desJson.put("author_id", uk);
            desJson.put("author_name", userName);
            desJson.put(UgcPerformanceUbcUtils.UGC_PERFORMANCE_PRDUCER, "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return desJson.toString();
    }

    public void stop() {
        super.stop();
        releaseTranscoder();
        stopPlayProgress();
    }

    public void releaseTranscoder() {
    }
}
