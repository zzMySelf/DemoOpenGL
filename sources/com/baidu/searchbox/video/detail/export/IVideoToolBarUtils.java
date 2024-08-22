package com.baidu.searchbox.video.detail.export;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.searchbox.lightbrowser.model.PageReportData;
import com.baidu.searchbox.video.detail.dependency.impl.toolbar.VideoToolBarUtilsImpl_Factory;
import com.baidu.searchbox.video.detail.export.IVideoDependConstManager;
import org.json.JSONObject;

public interface IVideoToolBarUtils {
    public static final String CLICK_ID = IVideoDependConstManager.Impl.get().getStringConst("12");
    public static final IVideoToolBarUtils EMPTY = new IVideoToolBarUtils() {
        public void setCommonMenuItemTitle(CommonMenuItem item, boolean isNightMode) {
        }

        public void setCommonMenuItemTitleAndIcon(CommonMenuItem item, String ukey) {
        }

        public void setShortPlayMenuItemTitleAndIcon(CommonMenuItem item, String ukey) {
        }

        public void registerFavorSuccessListener(Object objTag) {
        }

        public void processReport(Context context, String entrance, PageReportData reportData) {
        }

        public void processReport(Context context, String entrance, ReportModelProxy reportData) {
        }

        public void backToHome(Context context) {
        }

        public void updateStarUI(Context context, String feedNid, String options, boolean exist, String linkUrl, String webUrl, String chH5Url, boolean isDemoteFavor, IVideoDemoteFavorListener listener) {
        }

        public void isFavorExistByUrlAsync(String linkUrl, String webUrl, String chH5Url, VideoFavorDataCallback<Boolean> videoFavorDataCallback) {
        }

        public void startSync() {
        }

        public void doDestroy() {
        }

        public void unRegisterFavorSuccessListener(Object objTag) {
        }

        public String getSessionId() {
            return null;
        }

        public String getClickId() {
            return null;
        }

        public void showCopyUrlNullToast(Context context) {
        }

        public void doFavor(Activity context, String feedNid, String favorData, String favorUrl, String slog, String toolBarSource, JSONObject extData, boolean needToast, IVideoDemoteFavorListener listener) {
        }
    };
    public static final String SESSION_ID = IVideoDependConstManager.Impl.get().getStringConst("11");
    public static final String TOOLBAR_INVALID_CONTEXT_ID = IVideoDependConstManager.Impl.get().getStringConst("10");

    public interface IVideoDemoteFavorListener {
        void onDemoteFavor();

        void updateStarUI(boolean z, boolean z2);
    }

    public static final class ReportModelProxy {
        public String channel;
        public String ext;
        public String nid;
        public String tabId;
        public String tpl;
    }

    void backToHome(Context context);

    void doDestroy();

    void doFavor(Activity activity, String str, String str2, String str3, String str4, String str5, JSONObject jSONObject, boolean z, IVideoDemoteFavorListener iVideoDemoteFavorListener);

    String getClickId();

    String getSessionId();

    void isFavorExistByUrlAsync(String str, String str2, String str3, VideoFavorDataCallback<Boolean> videoFavorDataCallback);

    void processReport(Context context, String str, PageReportData pageReportData);

    void processReport(Context context, String str, ReportModelProxy reportModelProxy);

    void registerFavorSuccessListener(Object obj);

    void setCommonMenuItemTitle(CommonMenuItem commonMenuItem, boolean z);

    void setCommonMenuItemTitleAndIcon(CommonMenuItem commonMenuItem, String str);

    void setShortPlayMenuItemTitleAndIcon(CommonMenuItem commonMenuItem, String str);

    void showCopyUrlNullToast(Context context);

    void startSync();

    void unRegisterFavorSuccessListener(Object obj);

    void updateStarUI(Context context, String str, String str2, boolean z, String str3, String str4, String str5, boolean z2, IVideoDemoteFavorListener iVideoDemoteFavorListener);

    public static abstract class VideoFavorDataCallback<T> {
        public abstract void onResult(T t);

        public boolean onUIBack() {
            return true;
        }
    }

    public static class Impl {
        public static IVideoToolBarUtils get() {
            return VideoToolBarUtilsImpl_Factory.get();
        }
    }
}
