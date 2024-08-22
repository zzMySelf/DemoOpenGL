package com.baidu.searchbox.download.center.ioc;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.baidu.android.common.IDataObserver;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.clean.DownloadedDataModel;
import com.baidu.searchbox.download.center.ui.PictureCategoryActivity;
import com.baidu.searchbox.download.center.ui.downloaded.DownloadedAdapter;
import com.baidu.searchbox.download.manager.DownloadManager;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.statistics.DownloadActionModel;
import com.baidu.searchbox.download.util.DocClassifyHelper;
import com.baidu.searchbox.story.data.OfflineBookInfo;
import com.baidu.searchbox.story.data.OnlineBookInfo;
import com.baidu.searchbox.unitedscheme.UnitedSchemeBaseDispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDownloadCenterApp {
    public static final IDownloadCenterApp EMPTY = new IDownloadCenterApp() {
        public ArrayList<CategoryInfoData> getDownloadedData(int category) {
            return null;
        }

        public ArrayList<CategoryInfoData> getDownloadedData(int category, int limit, int offset) {
            return null;
        }

        public int doNovelBusinessCleanJob(Context context, DownloadedDataModel downloadedDataModel) {
            return 0;
        }

        public int doVideoBusinessCleanJob(Context context, DownloadedDataModel downloadedDataModel) {
            return 0;
        }

        public void doPositiveBtnJob(long downloadId, boolean isPauseToStart, int downloadType) {
        }

        public void showCloseMsg(long downloadId, boolean isPauseToStart, int downloadType) {
        }

        public void setVPlayerOrientationChange(int downloadType, boolean enable) {
        }

        public void doPictureCategoryActivityOnResumeJob(IDataObserver iDataObserver, PictureCategoryActivity.IUpdateNews iUpdateNews) {
        }

        public void doPictureCategoryActivityOnPauseJob(IDataObserver iDataObserver) {
        }

        public void modifyIsRead(Context context, long... ret) {
        }

        public void launchPictureBrowser(Context context, int position, ArrayList<String> arrayList) {
        }

        public Uri getProguardUri(String url) {
            return null;
        }

        public String queryExtraInfoByDownloadID(String downloadId) {
            return null;
        }

        public ArrayList<CategoryInfoData> queryDownloadDataByDownloadID(long... downloadIds) {
            return null;
        }

        public void jumpVideoContinueActivity(Context context, long id, boolean isPauseToStart) {
        }

        public boolean reDownloadVideo(Context context, long downloadId, DownloadManager downloadManager) {
            return false;
        }

        public void startPluginPaperViewerActivity(Context context, Uri data, String type) {
        }

        public void startPluginPaperViewerActivity(Context context, Uri data, DownloadActionModel model) {
        }

        public void openNovel(Activity activity, CategoryInfoData info) {
        }

        public void openNovel(Activity activity, long downloadId, int downloadedType) {
        }

        public void loadUrl(Context context, String url, boolean fromHome, boolean openInNewWindow) {
        }

        public void startPlay(Context context, String path, String title) {
        }

        public ArrayList<CategoryInfoData> queryAllCategoryInfo() {
            return null;
        }

        public void getDownloadAppCount(Context context, DownloadedAdapter.DownloadInfoListener listener) {
        }

        public void getUnReadDownloadAppCount(Context context, DownloadedAdapter.DownloadInfoListener listener) {
        }

        public void delAllDownloadInfoByGid(Context context, boolean deleteFile, long gid) {
        }

        public void goMainActivity(Context context) {
        }

        public void addDownloadingObserver(IDataObserver iDataObserver) {
        }

        public void addUnreadObserver(IDataObserver iDataObserver) {
        }

        public void appsearchLayoutClick(Context context) {
        }

        public void setAppsearchNewNumber(DownloadedAdapter.DownloadInfoListener listener) {
        }

        public boolean isAppAssistantSwitchEnabled() {
            return false;
        }

        public boolean hasInstalledAppAssistant() {
            return false;
        }

        public void enterAppAssistantDownloadCenter() {
        }

        public Intent getGoDownloadedVideoActivityIntent(Context context) {
            return null;
        }

        public Intent getGoFileViewerActivityIntent(Context context) {
            return null;
        }

        public void deleteEpisodeData(Context context, long[] downloadIds, String... vids) {
        }

        public int getTotalDownloadedCount() {
            return 0;
        }

        public int getTotalDownloadedCount(boolean isShowAll) {
            return 0;
        }

        public void deleteUnreadObserver(IDataObserver iDataObserver) {
        }

        public void deleteDownloadingObserver(IDataObserver iDataObserver) {
        }

        public boolean isGoogleMarket(Context context) {
            return false;
        }

        public String getPublicExternalPath(String fileName) {
            return null;
        }

        public boolean ensureDirectoryExist(File dir) {
            return false;
        }

        public void beginDownload(ContentValues contentValues) {
        }

        public ArrayList<CategoryInfoData> queryByCategory(int category) {
            return null;
        }

        public ArrayList<CategoryInfoData> getDownloadedDocData(DocClassifyHelper.DocCategroy category, int limit, int offset) {
            return null;
        }

        public void registerDownloadScheme(HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> hashMap) {
        }

        public void processBaiduSafeGuardShortCut(Context context) {
        }

        public String getVideoFilePathFromUri(Context context, Uri uri) {
            return null;
        }

        public boolean isMainActivity(Activity activity) {
            return false;
        }

        public void deleteLocalVideoDir(Context context) {
        }

        public ArrayList<OnlineBookInfo> queryOnlineNovel() {
            return null;
        }

        public ArrayList<OfflineBookInfo> queryAllOfflineNovel() {
            return null;
        }
    };
    public static final String LOG_TAG = "sDownloadCenterApp";

    void addDownloadingObserver(IDataObserver iDataObserver);

    void addUnreadObserver(IDataObserver iDataObserver);

    void appsearchLayoutClick(Context context);

    void beginDownload(ContentValues contentValues);

    void delAllDownloadInfoByGid(Context context, boolean z, long j2);

    void deleteDownloadingObserver(IDataObserver iDataObserver);

    void deleteEpisodeData(Context context, long[] jArr, String... strArr);

    void deleteLocalVideoDir(Context context);

    void deleteUnreadObserver(IDataObserver iDataObserver);

    int doNovelBusinessCleanJob(Context context, DownloadedDataModel downloadedDataModel);

    void doPictureCategoryActivityOnPauseJob(IDataObserver iDataObserver);

    void doPictureCategoryActivityOnResumeJob(IDataObserver iDataObserver, PictureCategoryActivity.IUpdateNews iUpdateNews);

    void doPositiveBtnJob(long j2, boolean z, int i2);

    int doVideoBusinessCleanJob(Context context, DownloadedDataModel downloadedDataModel);

    boolean ensureDirectoryExist(File file);

    void enterAppAssistantDownloadCenter();

    void getDownloadAppCount(Context context, DownloadedAdapter.DownloadInfoListener downloadInfoListener);

    ArrayList<CategoryInfoData> getDownloadedData(int i2);

    ArrayList<CategoryInfoData> getDownloadedData(int i2, int i3, int i4);

    ArrayList<CategoryInfoData> getDownloadedDocData(DocClassifyHelper.DocCategroy docCategroy, int i2, int i3);

    Intent getGoDownloadedVideoActivityIntent(Context context);

    Intent getGoFileViewerActivityIntent(Context context);

    Uri getProguardUri(String str);

    String getPublicExternalPath(String str);

    int getTotalDownloadedCount();

    int getTotalDownloadedCount(boolean z);

    void getUnReadDownloadAppCount(Context context, DownloadedAdapter.DownloadInfoListener downloadInfoListener);

    String getVideoFilePathFromUri(Context context, Uri uri);

    void goMainActivity(Context context);

    boolean hasInstalledAppAssistant();

    boolean isAppAssistantSwitchEnabled();

    boolean isGoogleMarket(Context context);

    boolean isMainActivity(Activity activity);

    void jumpVideoContinueActivity(Context context, long j2, boolean z);

    void launchPictureBrowser(Context context, int i2, ArrayList<String> arrayList);

    void loadUrl(Context context, String str, boolean z, boolean z2);

    void modifyIsRead(Context context, long... jArr);

    void openNovel(Activity activity, long j2, int i2);

    void openNovel(Activity activity, CategoryInfoData categoryInfoData);

    void processBaiduSafeGuardShortCut(Context context);

    ArrayList<CategoryInfoData> queryAllCategoryInfo();

    ArrayList<OfflineBookInfo> queryAllOfflineNovel();

    ArrayList<CategoryInfoData> queryByCategory(int i2);

    ArrayList<CategoryInfoData> queryDownloadDataByDownloadID(long... jArr);

    String queryExtraInfoByDownloadID(String str);

    ArrayList<OnlineBookInfo> queryOnlineNovel();

    boolean reDownloadVideo(Context context, long j2, DownloadManager downloadManager);

    void registerDownloadScheme(HashMap<String, Class<? extends UnitedSchemeBaseDispatcher>> hashMap);

    void setAppsearchNewNumber(DownloadedAdapter.DownloadInfoListener downloadInfoListener);

    void setVPlayerOrientationChange(int i2, boolean z);

    void showCloseMsg(long j2, boolean z, int i2);

    void startPlay(Context context, String str, String str2);

    void startPluginPaperViewerActivity(Context context, Uri uri, DownloadActionModel downloadActionModel);

    void startPluginPaperViewerActivity(Context context, Uri uri, String str);

    public static final class Impl {
        private static IDownloadCenterApp sDownloadCenterApp = DownLoadCenterRuntime.getDownloadCenterApp();

        private Impl() {
        }

        public static IDownloadCenterApp get() {
            if (sDownloadCenterApp == null) {
                if (AppConfig.isDebug()) {
                    Log.w(IDownloadCenterApp.LOG_TAG, "Fetch sDownloadCenterApp implementation failed, sDownloadCenterApp.EMPTY applied");
                }
                sDownloadCenterApp = IDownloadCenterApp.EMPTY;
            }
            return sDownloadCenterApp;
        }
    }
}
