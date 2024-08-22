package com.baidu.searchbox.player.helper;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.common.security.SchemeCheckerHelperImpl;
import com.baidu.searchbox.download.callback.IDownloadListener;
import com.baidu.searchbox.download.unified.DownloadParams;
import com.baidu.searchbox.download.unified.DownloadUnifiedManager;
import com.baidu.searchbox.download.unified.EventCallback;
import com.baidu.searchbox.download.unified.EventControlInfoForStart;
import com.baidu.searchbox.export.IPlayerQueryDownloadStatusDb;
import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.searchbox.player.model.BasicVideoSeries;
import com.baidu.searchbox.player.model.BasicVideoSeriesExt;
import com.baidu.searchbox.player.model.ClarityUrlList;
import com.baidu.searchbox.player.plugin.async.callback.IAsyncRequestCallback;
import com.baidu.searchbox.player.plugin.auth.constant.VideoOperationTypeKt;
import com.baidu.searchbox.player.plugin.auth.strategy.token.AuthTokenStrategy;
import com.baidu.searchbox.player.ubc.BaseVideoPlayerEventUbc;
import com.baidu.searchbox.player.urlparams.UrlParamsManagerKt;
import com.baidu.searchbox.player.utils.VideoPlayerParamsUtil;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideo;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.video.videoplayer.VideoPlayerRuntime;
import com.baidu.searchbox.videoplayer.business.R;
import com.baidu.webkit.sdk.MimeTypeMap;
import java.util.Iterator;
import org.json.JSONObject;

public class VideoDownloadHelper {
    public static final int DOWNLOAD_DISABLED_STATUS = -99;
    public static final int DOWNLOAD_ENABLED_STATUS = -1;
    public static final int DOWNLOAD_FAILED_STATUS = 195;
    public static final int DOWNLOAD_PAUSED_STATUS = 193;
    public static final int DOWNLOAD_RUNNING_STATUS = 192;
    public static final int DOWNLOAD_SUCCESS_STATUS = 200;
    public static final String UBC_DOWNLOAD_ENABLED_STATUS = "download";
    public static final String UBC_DOWNLOAD_RUNNING_STATUS = "downloading";
    public static final String UBC_DOWNLOAD_SUCCESS_STATUS = "downloaded";

    public interface IQueryDownloadStatusListener {
        void onQueryResult(int i2);
    }

    public static boolean checkVideoDownloadDisabled(BdVideoSeries videoSeries) {
        if (videoSeries == null || videoSeries.getSelectedVideo() == null) {
            return true;
        }
        BdVideo bdVideo = videoSeries.getSelectedVideo();
        String webUrl = bdVideo.getSourceUrl();
        String playUrl = bdVideo.getPlayUrl();
        ClarityUrlList clarityUrls = videoSeries.getClarityList();
        if (TextUtils.isEmpty(playUrl) || playUrl.contains(".m3u8")) {
            return true;
        }
        if (!TextUtils.isEmpty(webUrl) && (webUrl.contains("tv.sohu.com") || webUrl.contains(SchemeCheckerHelperImpl.QIYIHOST) || webUrl.contains("qiyi.com"))) {
            return true;
        }
        if (clarityUrls.getCurrentClarityUrl() == null || !clarityUrls.getCurrentClarityUrl().getHasRealDownloadUrl() || !TextUtils.isEmpty(clarityUrls.getCurrentClarityUrl().getRealDownloadUrl())) {
            return false;
        }
        return true;
    }

    public static void queryDownloadStatusFromDb(String uniqueKey, IQueryDownloadStatusListener listener) {
        IPlayerQueryDownloadStatusDb.Impl.get().queryDownloadStatusFromDb(uniqueKey, listener);
    }

    public static void dispatchDownloadTask(Context context, BdVideoSeries bdVideoSeries, int videoDownLoadStatus) {
        dispatchDownloadTask(context, bdVideoSeries, (String) null, videoDownLoadStatus);
    }

    public static void dispatchDownloadTask(Context context, BdVideoSeries bdVideoSeries, String extInfo, int videoDownLoadStatus) {
        dispatchDownloadTask(context, bdVideoSeries, extInfo, videoDownLoadStatus, (IDownloadListener) null);
    }

    public static void dispatchDownloadTask(Context context, BdVideoSeries bdVideoSeries, String extInfo, int videoDownLoadStatus, IDownloadListener downloadListener) {
        dispatchDownloadTask(context, bdVideoSeries, extInfo, videoDownLoadStatus, downloadListener, true);
    }

    public static void dispatchDownloadTask(final Context context, final BdVideoSeries bdVideoSeries, final String extInfo, int videoDownLoadStatus, final IDownloadListener downloadListener, boolean isFullScreen) {
        if (videoDownLoadStatus == 200) {
            UniversalToast.makeText(context, (CharSequence) context.getString(R.string.bd_video_download_success_tip)).setButtonText(context.getString(R.string.bd_video_full_landscape_download_btn)).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() {
                public void onToastClick() {
                    if (context instanceof Activity) {
                        VideoPlayerRuntime.getVideoPlayerContext().startDownloadCenterActivity((Activity) context);
                        BaseVideoPlayerEventUbc.downloadToast("click", "video_downloaded");
                    }
                }
            }).showClickableToast(false, isFullScreen);
            BaseVideoPlayerEventUbc.downloadToast("show", "video_downloaded");
        } else if (videoDownLoadStatus == 193 || videoDownLoadStatus == 195) {
            showReadyTipToast(context, isFullScreen);
        } else if (videoDownLoadStatus == 192) {
            UniversalToast.makeText(context, (CharSequence) context.getString(R.string.bd_video_download_running_tip)).setButtonText(context.getString(R.string.bd_video_full_landscape_download_btn)).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() {
                public void onToastClick() {
                    if (context instanceof Activity) {
                        VideoPlayerRuntime.getVideoPlayerContext().startDownloadCenterActivity((Activity) context);
                        BaseVideoPlayerEventUbc.downloadToast("click", "video_loading");
                    }
                }
            }).showClickableToast(false, isFullScreen);
            BaseVideoPlayerEventUbc.downloadToast("show", "video_loading");
        } else {
            showReadyTipToast(context, isFullScreen);
            ClarityUrlList clarityUrls = bdVideoSeries.getClarityList();
            if (clarityUrls == null || clarityUrls.getCurrentClarityUrl() == null || !AuthTokenStrategy.isClarityUrlExpire(clarityUrls.getCurrentClarityUrl())) {
                onStartDownloadVideo(context, bdVideoSeries, extInfo, downloadListener);
            } else {
                AuthTokenStrategy.sendAsyncRequest(bdVideoSeries, VideoOperationTypeKt.DOWNLOAD, new IAsyncRequestCallback() {
                    public void invoke(BasicVideoSeries resultSeries, int mpdStrategyType) {
                        VideoDownloadHelper.onStartDownloadVideo(context, bdVideoSeries, extInfo, downloadListener);
                    }
                });
            }
        }
    }

    private static void showReadyTipToast(final Context context, boolean isFullScreen) {
        UniversalToast.makeText(context, (CharSequence) context.getString(R.string.bd_video_download_ready_tip)).setButtonText(context.getString(R.string.bd_video_full_landscape_download_btn)).setDuration(3).setToastCallback(new UniversalToast.ToastCallback() {
            public void onToastClick() {
                if (context instanceof Activity) {
                    VideoPlayerRuntime.getVideoPlayerContext().startDownloadCenterActivity((Activity) context);
                }
            }
        }).showClickableToast(false, isFullScreen);
    }

    public static void onStartDownloadVideo(Context context, BdVideoSeries bdVideoSeries) {
        onStartDownloadVideo(context, bdVideoSeries, (String) null);
    }

    public static void onStartDownloadVideo(Context context, BdVideoSeries bdVideoSeries, String extInfo) {
        onStartDownloadVideo(context, bdVideoSeries, (String) null, (IDownloadListener) null);
    }

    public static void onStartDownloadVideo(Context context, BdVideoSeries bdVideoSeries, String extInfo, IDownloadListener downloadListener) {
        String scene;
        String str = extInfo;
        BdVideo video = bdVideoSeries.getSelectedVideo();
        String srcUrl = video.getPlayUrl();
        String downloadUrl = "";
        ClarityUrlList clarityUrls = bdVideoSeries.getClarityList();
        if (clarityUrls.getCurrentClarityUrl() != null) {
            downloadUrl = clarityUrls.getCurrentClarityUrl().getDownloadUrl();
        }
        String downloadUrl2 = TextUtils.isEmpty(downloadUrl) ? srcUrl : downloadUrl;
        if (!TextUtils.isEmpty(downloadUrl2)) {
            if (!downloadUrl2.contains(UrlParamsManagerKt.URL_QUERY_KEY_PDX)) {
                scene = NetUtils.appendCDNStatParams(downloadUrl2, 2, VideoPlayerParamsUtil.getDeviceScore(), BasicVideoSeriesExt.getVideoScene(bdVideoSeries));
            } else {
                scene = downloadUrl2;
            }
            String ext = "";
            try {
                JSONObject extJSONObject = new JSONObject();
                BdVideo bdVideo = bdVideoSeries.getSelectedVideo();
                if (!TextUtils.isEmpty(bdVideoSeries.getVid())) {
                    extJSONObject.put("vid", bdVideoSeries.getVid());
                } else if (bdVideo != null) {
                    extJSONObject.put("vid", bdVideo.getPlayUrl());
                }
                if (bdVideo != null) {
                    extJSONObject.put("duration", bdVideo.getTotalLength());
                }
                if (str != null && !extInfo.isEmpty()) {
                    JSONObject jsonExtInfo = new JSONObject(str);
                    Iterator<String> keys = jsonExtInfo.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        extJSONObject.put(key, jsonExtInfo.opt(key));
                    }
                }
                ext = extJSONObject.toString();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(scene));
            if (TextUtils.isEmpty(mimeType)) {
                mimeType = "video/mp4";
            }
            String title = video.getTitle();
            DownloadParams params = new DownloadParams();
            params.setUrl(scene);
            params.setTitle(title);
            params.setMimeType(mimeType);
            params.setExtraInfo(ext);
            params.setVisibleInDownloadsUI(true);
            params.setVisibleInNotification(1);
            params.setShowStartDownloadToast(true);
            DownloadUnifiedManager.getInstance().startDownload(context, mapToDownloadScene(bdVideoSeries, "video_haokan"), params, downloadListener, (EventControlInfoForStart) null, (EventCallback) null);
        }
    }

    private static String mapToDownloadScene(BdVideoSeries series, String defaultValue) {
        String scene = BasicVideoSeriesExt.getVideoScene(series);
        return TextUtils.isEmpty(scene) ? defaultValue : IFeedTTSContext.CATEGORY_TTSVIDEO_PREFIX + scene;
    }

    public static String getUbcDownloadStatus(int downloadStatus) {
        switch (downloadStatus) {
            case -1:
                return "download";
            case 192:
                return "downloading";
            case 200:
                return "downloaded";
            default:
                return "";
        }
    }
}
