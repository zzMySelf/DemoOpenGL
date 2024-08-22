package com.baidu.swan.game.ad.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.TypedValue;
import android.webkit.DownloadListener;
import android.widget.RelativeLayout;
import com.baidu.swan.game.ad.R;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadCallback;
import com.baidu.swan.game.ad.downloader.interfaces.IDownloadView;
import com.baidu.swan.game.ad.downloader.model.DownloadParams;
import com.baidu.swan.game.ad.downloader.model.DownloadState;
import com.baidu.swan.game.ad.downloader.view.SwanAdDownloadView;
import com.baidu.swan.game.ad.entity.AdElementInfo;
import com.baidu.swan.game.ad.ioc.SwanAdRuntime;
import com.baidu.swan.game.ad.request.AdNetRequest;
import com.baidu.swan.game.ad.statistics.AdStatisticsManager;
import com.baidu.swan.game.ad.statistics.AlsSender;
import com.baidu.swan.game.ad.utils.ApkUtils;
import org.json.JSONObject;

public class InteractiveEndFrameView extends RelativeLayout {
    public static final String SWAN_GAME_STORAGE = "swan_game_video_ad_storage";
    /* access modifiers changed from: private */
    public AdElementInfo mAdInstanceInfo;
    /* access modifiers changed from: private */
    public RelativeLayout.LayoutParams mBtnLayoutParams;
    /* access modifiers changed from: private */
    public IDownloadCallback mDownloadCallback;
    /* access modifiers changed from: private */
    public DownloadParams mDownloadParams;
    /* access modifiers changed from: private */
    public DownloadState mDownloadState = DownloadState.NOT_START;
    /* access modifiers changed from: private */
    public String mDownloadUrl;
    /* access modifiers changed from: private */
    public IDownloadView mDownloadView;
    private JSONObject mMons;
    /* access modifiers changed from: private */
    public String mPackageName = "";
    /* access modifiers changed from: private */
    public RelativeLayout mParentView;
    /* access modifiers changed from: private */
    public AdNetRequest mRequest;
    /* access modifiers changed from: private */
    public AlsSender mSender;
    private RewardWebView mWebView;

    public InteractiveEndFrameView(Context context) {
        super(context);
        this.mRequest = new AdNetRequest(context);
    }

    public void addWebView(AdElementInfo adInstanceInfo, RelativeLayout parentView) {
        this.mAdInstanceInfo = adInstanceInfo;
        this.mParentView = parentView;
        String url = adInstanceInfo.getEndFrameUrl();
        RewardWebView rewardWebView = new RewardWebView(getContext());
        this.mWebView = rewardWebView;
        rewardWebView.setBackgroundColor(-1);
        this.mWebView.loadUrl(url);
        addView(this.mWebView, new RelativeLayout.LayoutParams(-1, -1));
        this.mMons = adInstanceInfo.getAdMonitors();
        this.mSender = new AlsSender(getContext(), this.mMons);
        initDownload();
        setDownloadListener();
    }

    private void initDownloadBtnLayoutParams() {
        float withRatio = getFloatValue(getContext(), R.dimen.end_frame_download_btn_width);
        float heightRatio = getFloatValue(getContext(), R.dimen.end_frame_download_btn_height);
        int bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.end_frame_download_btn_bottom_margin);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) ((double) (((float) getContext().getResources().getDisplayMetrics().widthPixels) * withRatio)), (int) ((double) (((float) getContext().getResources().getDisplayMetrics().heightPixels) * heightRatio)));
        layoutParams.addRule(12);
        layoutParams.bottomMargin = bottomMargin;
        layoutParams.addRule(14);
        this.mBtnLayoutParams = layoutParams;
    }

    public void initDownload() {
        initDownloadBtnLayoutParams();
        this.mDownloadCallback = new IDownloadCallback() {
            public void onShowButton(boolean isShow) {
                if (InteractiveEndFrameView.this.mParentView != null) {
                    if (isShow) {
                        InteractiveEndFrameView.this.mParentView.removeView(InteractiveEndFrameView.this.mDownloadView.getRealView());
                        InteractiveEndFrameView.this.mParentView.addView(InteractiveEndFrameView.this.mDownloadView.getRealView(), InteractiveEndFrameView.this.mBtnLayoutParams);
                        return;
                    }
                    InteractiveEndFrameView.this.mParentView.removeView(InteractiveEndFrameView.this.mDownloadView.getRealView());
                }
            }

            public void onPackageNameChange(String pkgName) {
                InteractiveEndFrameView.this.putPackageName(pkgName);
            }

            public void onStateChange(DownloadState state, int percent) {
                InteractiveEndFrameView.this.mDownloadView.updateState(state);
                if (InteractiveEndFrameView.this.mDownloadState != state) {
                    if (InteractiveEndFrameView.this.mDownloadState == DownloadState.NOT_START && state == DownloadState.DOWNLOADING) {
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_DL_BEGIN);
                    } else if (state == DownloadState.DOWNLOAD_PAUSED) {
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_DL_PAUSE);
                    } else if (InteractiveEndFrameView.this.mDownloadState == DownloadState.DOWNLOAD_PAUSED && state == DownloadState.DOWNLOADING) {
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_DL_RESUME);
                    } else if (state == DownloadState.DOWNLOADED) {
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_DL_END);
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_INSTALL_BEGIN);
                    } else if (state == DownloadState.INSTALLED) {
                        InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_INSTALL_END);
                    }
                    DownloadState unused = InteractiveEndFrameView.this.mDownloadState = state;
                }
            }

            public void onProgressChange(int percent) {
                InteractiveEndFrameView.this.mDownloadView.updateProgress(percent);
            }

            public void onInstall() {
                InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_INSTALL_BEGIN);
            }

            public String onAppOpen() {
                InteractiveEndFrameView.this.mSender.sendAls(AlsSender.KEY_DL_OPEN);
                InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
                return interactiveEndFrameView.getPackageName(interactiveEndFrameView.mDownloadUrl);
            }
        };
    }

    public void setDownloadListener() {
        this.mWebView.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {
                AdStatisticsManager.sendEndFrameClickLog(InteractiveEndFrameView.this.mAdInstanceInfo, InteractiveEndFrameView.this.mRequest);
                String unused = InteractiveEndFrameView.this.mDownloadUrl = url;
                String pkgName = InteractiveEndFrameView.this.getPackageName(url);
                if (!TextUtils.isEmpty(pkgName)) {
                    String unused2 = InteractiveEndFrameView.this.mPackageName = pkgName;
                }
                DownloadParams unused3 = InteractiveEndFrameView.this.mDownloadParams = new DownloadParams(InteractiveEndFrameView.this.mDownloadUrl, InteractiveEndFrameView.this.mPackageName);
                IDownloadView unused4 = InteractiveEndFrameView.this.mDownloadView = new SwanAdDownloadView();
                InteractiveEndFrameView interactiveEndFrameView = InteractiveEndFrameView.this;
                IDownloadView unused5 = interactiveEndFrameView.mDownloadView = interactiveEndFrameView.mDownloadView.create(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.mDownloadParams, InteractiveEndFrameView.this.mDownloadCallback);
                InteractiveEndFrameView.this.mDownloadView.setViewTag(InteractiveEndFrameView.this.mDownloadParams);
                InteractiveEndFrameView.this.mDownloadView.updateLayout();
                if (!ApkUtils.hasInstalled(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.mDownloadParams.name) || InteractiveEndFrameView.this.mParentView == null) {
                    SwanAdRuntime.getSwanGameAd().handleAdDownload(InteractiveEndFrameView.this.getContext(), InteractiveEndFrameView.this.mDownloadParams.parseToJson(), DownloadParams.SwanAppDownloadType.TYPE_START_DOWNLOAD, InteractiveEndFrameView.this.mDownloadCallback);
                    return;
                }
                InteractiveEndFrameView.this.mParentView.removeView(InteractiveEndFrameView.this.mDownloadView.getRealView());
                InteractiveEndFrameView.this.mParentView.addView(InteractiveEndFrameView.this.mDownloadView.getRealView(), InteractiveEndFrameView.this.mBtnLayoutParams);
                InteractiveEndFrameView.this.mDownloadView.updateState(DownloadState.INSTALLED);
            }
        });
    }

    public void destroy() {
        RewardWebView rewardWebView = this.mWebView;
        if (rewardWebView != null) {
            rewardWebView.destroy();
        }
        if (DownloadState.DOWNLOADING == this.mDownloadState) {
            this.mDownloadCallback = null;
            SwanAdRuntime.getSwanGameAd().handleAdDownload(getContext(), this.mDownloadParams.parseToJson(), DownloadParams.SwanAppDownloadType.TYPE_PAUSE_DOWNLOAD, this.mDownloadCallback);
        }
    }

    private float getFloatValue(Context context, int id) {
        TypedValue outValue = new TypedValue();
        context.getResources().getValue(id, outValue, true);
        return outValue.getFloat();
    }

    /* access modifiers changed from: private */
    public void putPackageName(String pkgName) {
        if (!TextUtils.isEmpty(pkgName)) {
            Context context = getContext();
            getContext();
            SharedPreferences.Editor editor = context.getSharedPreferences(SWAN_GAME_STORAGE, 0).edit();
            editor.putString(this.mDownloadUrl, pkgName);
            editor.apply();
        }
    }

    /* access modifiers changed from: private */
    public String getPackageName(String url) {
        Context context = getContext();
        getContext();
        return context.getSharedPreferences(SWAN_GAME_STORAGE, 0).getString(url, "");
    }
}
