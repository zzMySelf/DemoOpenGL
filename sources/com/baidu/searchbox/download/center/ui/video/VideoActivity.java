package com.baidu.searchbox.download.center.ui.video;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.app.ActivityCompat;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.dialog.BdDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.download.DownloadStatisticsUBC;
import com.baidu.netdisk.model.AccountInfo;
import com.baidu.netdisk.model.AccountInfoKt;
import com.baidu.netdisk.transfer.base.IUploadCallback;
import com.baidu.netdisk.transfer.io.model.UploadResponseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.appframework.EditableActivity;
import com.baidu.searchbox.appframework.ext.ActionBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.boxdownload.ICyberInvoker;
import com.baidu.searchbox.boxdownload.model.DownloadDbItem;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.developer.DebugException;
import com.baidu.searchbox.diskupload.BdDiskUpload;
import com.baidu.searchbox.diskupload.BdDiskUtil;
import com.baidu.searchbox.download.business.util.DownloadCenterUtils;
import com.baidu.searchbox.download.center.ioc.IDownloadCenterApp;
import com.baidu.searchbox.download.center.statistic.DownloadCenterDurationUbc;
import com.baidu.searchbox.download.center.statistic.DownloadCenterTopBackUbcConstants;
import com.baidu.searchbox.download.center.statistic.DownloadCenterUnifiedBackUBCKt;
import com.baidu.searchbox.download.center.ui.AutoBackupPopupWindowHelper;
import com.baidu.searchbox.download.center.ui.DownloadBackUpFloatBottomBar;
import com.baidu.searchbox.download.center.ui.DownloadBottomMenu;
import com.baidu.searchbox.download.center.ui.DownloadFloatBackButtonUtilsKt;
import com.baidu.searchbox.download.center.ui.DownloadRenameActivity;
import com.baidu.searchbox.download.center.ui.DownloadUnifiedTopBackUtilsKt;
import com.baidu.searchbox.download.center.ui.DownloadedDocActivity;
import com.baidu.searchbox.download.center.ui.LoginUtilsKt;
import com.baidu.searchbox.download.center.ui.NetDiskOpenViewUtil;
import com.baidu.searchbox.download.center.ui.PictureCategoryHelper;
import com.baidu.searchbox.download.center.ui.ShareUtil;
import com.baidu.searchbox.download.center.ui.UnifiedToolBarCustomAreaLayoutParams;
import com.baidu.searchbox.download.center.ui.UploadNetworkHelper;
import com.baidu.searchbox.download.center.ui.autobackup.AutoBackupEntryView;
import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import com.baidu.searchbox.download.center.ui.autobackup.statistic.AutoBackupStatistic;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.ITranscodeCallback;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeFileDeleteUtils;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeLogUtil;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeManager;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeResult;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeSuccessEvent;
import com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeTriggerSource;
import com.baidu.searchbox.download.center.ui.dispatcher.DownloadedFileRenameDispatcher;
import com.baidu.searchbox.download.center.ui.dispatcher.FileOperationResult;
import com.baidu.searchbox.download.center.ui.fusion.data.DataChangedEvent;
import com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic;
import com.baidu.searchbox.download.center.ui.fusion.util.FileManagerRecentDataControlUtil;
import com.baidu.searchbox.download.center.ui.menu.DownloadActionBarMenu;
import com.baidu.searchbox.download.center.ui.video.ext.CategoryInfoDataExtKt;
import com.baidu.searchbox.download.center.ui.video.fusion.FusionVideoLoader;
import com.baidu.searchbox.download.center.ui.video.fusion.VideoLoadHelper;
import com.baidu.searchbox.download.center.ui.video.fusion.VideoLoadResult;
import com.baidu.searchbox.download.center.ui.video.fusion.adapter.IVideoManagerItemClickListener;
import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoBdDownloadModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoCommonDownloadSiteEntryModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoLocalModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoNetDiskEntryModel;
import com.baidu.searchbox.download.center.ui.video.fusion.site.VideoCommonDownloadSiteActivity;
import com.baidu.searchbox.download.center.ui.video.fusion.ubc.VideoManagerUbcHelper;
import com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer;
import com.baidu.searchbox.download.center.utils.DownloadCenterAbTestMgr;
import com.baidu.searchbox.download.center.utils.PanRouterUtil;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.download.dialog.DownloadSharedPrefsUtils;
import com.baidu.searchbox.download.manager.DownloadManagerExt;
import com.baidu.searchbox.download.model.CategoryInfoData;
import com.baidu.searchbox.download.util.DownloadHelper;
import com.baidu.searchbox.download.util.DownloadMediaHelper;
import com.baidu.searchbox.downloadcenter.service.DownloadCenterFunConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.socialshare.bean.MediaType;
import com.baidu.searchbox.socialshare.statistics.SharePageEnum;
import com.baidu.searchbox.ui.BdActionBar;
import com.baidu.searchbox.ui.viewpager.BdPagerTab;
import com.baidu.searchbox.ui.viewpager.BdPagerTabHost;
import com.baidu.searchbox.ui.viewpager.PagerAdapterImpl;
import com.baidu.searchbox.unifiedtoolbar.base.BarElementClickContext;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.option.BottomBarOptionFloatingBack;
import com.baidu.searchbox.unifiedtoolbar.option.UnifiedBottomBarOption;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarExpMgr;
import com.baidu.searchbox.video.plugin.videoplayer.model.BdVideoSeries;
import com.baidu.searchbox.vip.IVipUserInfoManager;
import com.baidu.searchbox.widget.ImmersionHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public class VideoActivity extends EditableActivity implements LoaderManager.LoaderCallbacks<VideoLoadResult>, ActivityCompat.OnRequestPermissionsResultCallback, DownloadActionBarMenu.OnMenuClickListener, DownloadedFileRenameDispatcher.FileRenameListener, IVideoManagerItemClickListener, ITranscodeCallback {
    public static final float INDICATOR_PRECENT = 0.3f;
    public static final int REQUEST_CODE_RENAME = 101;
    private static final String SCHEME_NET_DISK_VIDEO = "baiduboxapp://swan/OyIvf6LYVhKkbIHS1USP7xnSKYxc36SH/pages/home/index?source=spnative&from=1026061q_1026061r&current_type=home_video&category=1&_baiduboxapp=%7B%22from%22%3A%221201001310003000%22%2C%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
    private static final String TAG = "VideoActivity";
    private static final int VIDEO_UPLOAD_PURCHASE_TYPE = 0;
    /* access modifiers changed from: private */
    public static AbsVideoTemplateModel sFloatBackPlayData = null;
    private boolean isUbcShowAutoBackupEntry;
    private BdPagerTab mAlbumVideoTab;
    /* access modifiers changed from: private */
    public BdActionBar mBdActionBar;
    /* access modifiers changed from: private */
    public FrameLayout mContainer;
    /* access modifiers changed from: private */
    public BaseEditVideoLayout mCurrentConvertView;
    /* access modifiers changed from: private */
    public List<Long> mDeleteIdList = new ArrayList();
    /* access modifiers changed from: private */
    public DownloadBottomMenu mDownloadBottomMenu;
    private BdPagerTab mDownloadVideoTab;
    private final DownloadCenterDurationUbc mDurationUbc = new DownloadCenterDurationUbc();
    private DownloadedFileRenameDispatcher.FileRenameListener mFileRenameListener;
    /* access modifiers changed from: private */
    public DownloadBackUpFloatBottomBar mFloatBottomBar;
    private IUploadCallback mIUploadCallback;
    /* access modifiers changed from: private */
    public boolean mIsEditMode;
    private boolean mIsEditPanMode;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayout;
    /* access modifiers changed from: private */
    public ArrayList<BaseEditVideoLayout> mLists;
    /* access modifiers changed from: private */
    public DownloadVulcanVideoPlayer mLocalVideoPlayer;
    private NetDiskOpenViewUtil mNetDiskOpenViewUtil;
    private AbsVideoTemplateModel mRenamedVideoModel;
    private int mTabHeight;
    private BdPagerTabHost mTabHostView;
    /* access modifiers changed from: private */
    public VideoDownloadView mVideoDownloadView;
    private VideoLocalView mVideoLocalView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        UnifiedBottomBarExtKt.setUseUnifiedBottomBar(this, true);
        super.onCreate(savedInstanceState);
        setPendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left, R.anim.slide_in_from_left, R.anim.slide_out_to_right);
        setEnableSliding(true);
        FeedUtil.fixTarget26Crash(this);
        DownloadSharedPrefsUtils.getInstance().putBoolean(AutoBackupEntryView.SP_KEY_AUTO_BACKUP_ENTRY_NEED_SHOW, !NetDiskOptionWrapper.INSTANCE.getSwitchStateOptionVideo());
        initViews();
        restartLoaderIfNeeded();
        this.mFileRenameListener = new DownloadedFileRenameDispatcher.WeakFileRenameListener(this);
        DownloadedFileRenameDispatcher.getInstance().addEventListener(String.valueOf(-2), this.mFileRenameListener);
        TranscodeManager.get().registerTranscodeCallback(this);
        BdEventBus.Companion.getDefault().register(this, TranscodeSuccessEvent.class, 1, new Action<TranscodeSuccessEvent>() {
            public void call(final TranscodeSuccessEvent event) {
                if (BdDiskUtil.checkActivity(VideoActivity.this)) {
                    UiThreadUtils.runOnUiThread(new Runnable() {
                        public void run() {
                            TranscodeLogUtil.INSTANCE.logInDebug("尝试刷新百度下载视频列表");
                            TranscodeSuccessEvent transcodeSuccessEvent = event;
                            if (transcodeSuccessEvent != null) {
                                String m3u8FilePath = transcodeSuccessEvent.getM3u8FilePath();
                                String transcodeResultFilePath = event.getTranscodeResultFilePath();
                                if (!TextUtils.isEmpty(m3u8FilePath) && !TextUtils.isEmpty(transcodeResultFilePath) && VideoActivity.this.mVideoDownloadView != null && !VideoActivity.this.isDestroyed()) {
                                    VideoActivity.this.mVideoDownloadView.updateM3u8InfoAfterTranscode(m3u8FilePath, transcodeResultFilePath);
                                }
                            }
                        }
                    });
                }
            }
        });
        processFloatBack(getIntent());
    }

    /* access modifiers changed from: protected */
    public void processFloatBack(Intent intent) {
        AbsVideoTemplateModel absVideoTemplateModel;
        if (intent != null && getIntent().getBooleanExtra(DownloadCenterFunConstants.LOCAL_PLAYER_FLOAT_CLICK_BACK, false) && (absVideoTemplateModel = sFloatBackPlayData) != null) {
            String ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_DOWNLOAD_VIDEO;
            if (absVideoTemplateModel instanceof VideoBdDownloadModel) {
                ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_DOWNLOAD_VIDEO;
            } else if (absVideoTemplateModel instanceof VideoLocalModel) {
                ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_ALBUM_VIDEO;
            }
            doPlayVideo(absVideoTemplateModel, ubcPage);
            sFloatBackPlayData = null;
        }
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        setContentView(com.baidu.searchbox.download.center.R.layout.video_activity);
        DownloadBackUpFloatBottomBar downloadBackUpFloatBottomBar = (DownloadBackUpFloatBottomBar) findViewById(com.baidu.searchbox.download.center.R.id.float_bottom_bar);
        this.mFloatBottomBar = downloadBackUpFloatBottomBar;
        downloadBackUpFloatBottomBar.setTitle(getString(com.baidu.searchbox.download.center.R.string.video_bottom_pan_title));
        this.mFloatBottomBar.setBottomOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new PanRouterUtil().gotoNetdiskHomePage(VideoActivity.this, "1", true, PanRouterUtil.PAN_VIDEO_PAGE_SCHEME);
                DownloadCenterStatistic.INSTANCE.bottomPanStatistic("video", true);
            }
        });
        DownloadCenterStatistic.INSTANCE.bottomPanStatistic("video", false);
        updateFloatBottomViewLayoutParams();
        initDownloadBottomMenu();
        initTitleBar();
        initPagerView();
    }

    private void initTitleBar() {
        BdActionBar bdActionBar = ActionBarExtKt.getBdActionBar(this);
        this.mBdActionBar = bdActionBar;
        if (bdActionBar != null) {
            bdActionBar.setTitle(com.baidu.searchbox.download.center.R.string.type_video);
            this.mBdActionBar.setLeftFirstViewVisibility(true);
            updateTitleFooterBar(true);
            ActionBarExtKt.showActionBarShadow(this, false);
            setEditButtonVisible(false);
            FrameLayout leftCustomLayout = this.mBdActionBar.getLeftCustomLayout();
            NetDiskOpenViewUtil netDiskOpenViewUtil = new NetDiskOpenViewUtil(this, "video");
            this.mNetDiskOpenViewUtil = netDiskOpenViewUtil;
            View view2 = netDiskOpenViewUtil.getView();
            if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
                DownloadUnifiedTopBackUtilsKt.addNetDiskViewToRight(this, view2, this.mBdActionBar, com.baidu.android.common.ui.R.id.titlebar_right_zones);
                UnifiedTopBarButton topBackButton = getUnifiedTopBackButton();
                if (topBackButton != null) {
                    HashMap<String, String> extMap = new HashMap<>();
                    extMap.put(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, DownloadCenterTopBackUbcConstants.UBC_EXT_SEC_PAGE_PHONE_VIDEO);
                    topBackButton.ubcBackButtonShow("base", "file", extMap);
                    return;
                }
                return;
            }
            DownloadCenterUnifiedBackUBCKt.bottomBarShowStat(this, DownloadCenterTopBackUbcConstants.UBC_EXT_SEC_PAGE_PHONE_VIDEO);
            leftCustomLayout.addView(view2);
        }
    }

    /* access modifiers changed from: protected */
    public void initPagerView() {
        this.mDownloadVideoTab = new BdPagerTab().setTitle(getString(com.baidu.searchbox.download.center.R.string.download_video_tab_baidu));
        this.mAlbumVideoTab = new BdPagerTab().setTitle(getString(com.baidu.searchbox.download.center.R.string.download_video_tab_album));
        BdPagerTabHost bdPagerTabHost = new BdPagerTabHost((Context) this, false);
        this.mTabHostView = bdPagerTabHost;
        bdPagerTabHost.setNoScroll(false);
        this.mContainer = (FrameLayout) findViewById(com.baidu.searchbox.download.center.R.id.fl_video_holder);
        RelativeLayout ll = (RelativeLayout) findViewById(com.baidu.searchbox.download.center.R.id.video_root);
        if (ll != null) {
            ll.addView(this.mTabHostView);
        }
        this.mTabHostView.addTab(this.mDownloadVideoTab);
        this.mTabHostView.addTab(this.mAlbumVideoTab);
        this.mTabHostView.setTabTextSize(getResources().getDimensionPixelSize(com.baidu.searchbox.download.center.R.dimen.dimens_14dp));
        setPageTabColor();
        VideoLocalView videoLocalView = new VideoLocalView(this);
        this.mVideoLocalView = videoLocalView;
        videoLocalView.setIVideoManagerItemClickListener(this);
        VideoDownloadView videoDownloadView = new VideoDownloadView(this);
        this.mVideoDownloadView = videoDownloadView;
        videoDownloadView.setIVideoManagerItemClickListener(this);
        ArrayList<BaseEditVideoLayout> arrayList = new ArrayList<>();
        this.mLists = arrayList;
        arrayList.add(this.mVideoDownloadView);
        this.mLists.add(this.mVideoLocalView);
        this.mTabHostView.setPagerAdapter(new PagerAdapterImpl() {
            public int getCount() {
                return VideoActivity.this.mLists.size();
            }

            /* access modifiers changed from: protected */
            public View onInstantiateItem(ViewGroup container, int position) {
                return (View) VideoActivity.this.mLists.get(position);
            }

            /* access modifiers changed from: protected */
            public void onConfigItem(View convertView, int position) {
            }
        }, 0);
        this.mTabHostView.setTabChangeListener(new BdPagerTabHost.OnTabHostChangeListener() {
            public void onPageSelected(int i2) {
                VideoActivity videoActivity = VideoActivity.this;
                BaseEditVideoLayout unused = videoActivity.mCurrentConvertView = (BaseEditVideoLayout) videoActivity.mLists.get(i2);
                DownloadActionBarMenu.setEditButtonEnabled(VideoActivity.this.mBdActionBar, VideoActivity.this.mCurrentConvertView.isEditable());
                if (i2 == 0) {
                    VideoManagerUbcHelper.INSTANCE.doVideoManagerStatistic("tool", "recent_download", "file", "video", "", VideoManagerUbcHelper.INSTANCE.getCommonFromExtObj().toString());
                } else if (i2 == 1) {
                    VideoManagerUbcHelper.INSTANCE.doVideoManagerStatistic("tool", "photo", "file", "video", "", VideoManagerUbcHelper.INSTANCE.getCommonFromExtObj().toString());
                }
                VideoActivity.this.ubcShowVideoAutoBackupEntry();
            }

            public void onPageScrollStateChanged(int i2) {
            }
        });
        this.mCurrentConvertView = this.mLists.get(this.mTabHostView.getCurrentItem());
        View deleteRootView = getLayoutInflater().inflate(com.baidu.searchbox.download.center.R.layout.download_delete_layout, (ViewGroup) null, false);
        RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(-1, -1);
        rl.addRule(14, -1);
        rl.addRule(15, -1);
        if (ll != null) {
            ll.addView(deleteRootView, rl);
        }
        VideoManagerUbcHelper.INSTANCE.doVideoManagerStatistic("tool", "page_show", "file", "video", "", VideoManagerUbcHelper.INSTANCE.getCommonFromExtObj().toString());
        DownloadActionBarMenu.showAutoBackMenuButton(this.mBdActionBar, 0, "video", this);
    }

    private void initDownloadBottomMenu() {
        LinearLayout linearLayout = (LinearLayout) findViewById(com.baidu.searchbox.userassetsaggr.container.R.id.editable_delete_layout);
        this.mLinearLayout = linearLayout;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        DownloadBottomMenu downloadBottomMenu = new DownloadBottomMenu(this);
        this.mDownloadBottomMenu = downloadBottomMenu;
        downloadBottomMenu.setMenuListener(new DownloadBottomMenu.DownloadBottomMenuListener() {
            public void onShareClick() {
                VideoActivity.this.shareClick();
            }

            public void onRenameClick() {
                VideoActivity.this.renameClick();
            }

            public void onPanClick() {
                VideoActivity.this.panClick();
            }

            public void onDeleteClick() {
                VideoActivity.this.deleteClick();
            }
        });
        this.mDownloadBottomMenu.setHiddenAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                VideoActivity.this.mLinearLayout.setVisibility(8);
                if (DownloadCenterAbTestMgr.INSTANCE.isShieldedNetDiskAbility()) {
                    VideoActivity.this.mFloatBottomBar.setVisibility(8);
                } else {
                    VideoActivity.this.mFloatBottomBar.setVisibility(0);
                }
                UnifiedBottomBarExtKt.showBottomBar(VideoActivity.this);
            }

            public void onAnimationRepeat(Animation animation) {
            }
        });
        LinearLayout linearLayout2 = this.mLinearLayout;
        if (linearLayout2 != null) {
            linearLayout2.addView(this.mDownloadBottomMenu);
        }
    }

    /* access modifiers changed from: private */
    public void panClick() {
        List<String> selectedIds = this.mCurrentConvertView.getSelectedIds();
        if (selectedIds.isEmpty()) {
            endEdit();
        } else {
            checkVipWhenUploadFiles(selectedIds, new UploadNetworkHelper.IEditCloseListener() {
                public void callback() {
                    VideoActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            VideoActivity.this.endEdit();
                        }
                    });
                }
            });
        }
    }

    private void checkVipWhenUploadFiles(final List<String> selectedIds, final UploadNetworkHelper.IEditCloseListener edit) {
        LoginUtilsKt.checkLoginAndRun(this, getResources().getString(com.baidu.searchbox.download.center.R.string.download_upload_netdisk_login_title), new Runnable() {
            public void run() {
                VideoActivity.this.mDownloadBottomMenu.setPanEnabled(false);
                VideoActivity.this.mDownloadBottomMenu.setPanText(com.baidu.searchbox.download.center.R.string.download_bottom_menu_upload_loading);
                BdDiskUpload.get().fetchAccountInfoForVip(VideoActivity.this.createAccountInfoCallback(selectedIds, edit));
            }
        });
    }

    /* access modifiers changed from: private */
    public IUploadCallback createAccountInfoCallback(final List<String> selectedIds, final UploadNetworkHelper.IEditCloseListener edit) {
        AnonymousClass9 r0 = new IUploadCallback() {
            Function0<Unit> successCallback = new Function0<Unit>() {
                public Unit invoke() {
                    VideoActivity.this.applyUploadFiles(selectedIds, edit);
                    return null;
                }
            };

            public void onResult(UploadResponseModel uploadResponseModel) {
                if (VideoActivity.this.mIsEditMode && uploadResponseModel != null) {
                    VideoActivity.this.mDownloadBottomMenu.setPanEnabled(true);
                    VideoActivity.this.mDownloadBottomMenu.setPanText(com.baidu.searchbox.download.center.R.string.download_bottom_menu_upload_netdisk);
                    if (uploadResponseModel.isSuccess()) {
                        AccountInfo asyncInfo = (AccountInfo) uploadResponseModel.getData();
                        if (AccountInfoKt.isVip(asyncInfo) || AccountInfoKt.isNewVip(asyncInfo)) {
                            VideoActivity.this.applyUploadFiles(selectedIds, edit);
                            return;
                        }
                        ((IVipUserInfoManager) ServiceManager.getService(IVipUserInfoManager.Companion.getSERVICE_REFERENCE())).requestBDPanVipVideoCase(VideoActivity.this, 0, this.successCallback, (Function0<Unit>) null, "file");
                        return;
                    }
                    UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) "获取账号信息失败").showToast();
                }
            }
        };
        this.mIUploadCallback = r0;
        return r0;
    }

    /* access modifiers changed from: private */
    public void applyUploadFiles(final List<String> selectedIds, final UploadNetworkHelper.IEditCloseListener edit) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                UploadNetworkHelper.batchCheckAndUploadFiles(VideoActivity.this, DownloadManagerExt.getInstance().queryContentUriByIds(selectedIds), edit, 0, true);
            }
        }, "DownloadActivityUploadNetdisk", 1);
    }

    /* access modifiers changed from: private */
    public void shareClick() {
        HashMap<Long, AbsVideoTemplateModel> selectedData = this.mCurrentConvertView.getSelectedData();
        List<String> selectedFilePaths = new ArrayList<>();
        if (selectedData != null && selectedData.size() > 0) {
            int count = 0;
            for (Long id : selectedData.keySet()) {
                AbsVideoTemplateModel absVideoTemplateModel = selectedData.get(id);
                if (absVideoTemplateModel != null) {
                    String downloadPath = absVideoTemplateModel.getDownloadPath();
                    if (!TextUtils.isEmpty(downloadPath)) {
                        selectedFilePaths.add(downloadPath);
                        count++;
                    }
                    if (count > 9) {
                        break;
                    }
                }
            }
        }
        try {
            if (!ShareUtil.isSharedCountValid((long) selectedFilePaths.size())) {
                UniversalToast.makeText(AppRuntime.getAppContext(), com.baidu.searchbox.download.center.R.string.share_count_remind).setTextSize(16).setDuration(3).showToast();
                return;
            }
            if (ShareUtil.isSharedImagesValid(selectedFilePaths)) {
                if (selectedFilePaths.size() > 0) {
                    if (!(!isContainKernelDownloadItem(selectedData))) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), com.baidu.searchbox.download.center.R.string.download_file_cannot_share).setTextSize(16).setDuration(3).showToast();
                        return;
                    }
                    BDShare.getInstance().share(this, (View) null, new BaiduShareContent.Builder().setShareType(10).setMediaType(MediaType.OTHER).setFileShareList(selectedFilePaths).setSource("download").setSourcePage(SharePageEnum.LIGHT).create());
                    DownloadStatisticsUBC.doDownloadCenterChildPageUBC(0, "share");
                    return;
                }
            }
            UniversalToast.makeText(AppRuntime.getAppContext(), com.baidu.searchbox.download.center.R.string.share_file_deleted_remind).setTextSize(16).setDuration(3).showToast();
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                throw new DebugException("onShareClick() : selectedFilePaths = " + DownloadHelper.getDisplayString(selectedFilePaths), exception);
            }
        }
    }

    public static boolean isContainKernelDownloadItem(HashMap<Long, AbsVideoTemplateModel> downloadedDataMap) {
        if (downloadedDataMap == null) {
            return false;
        }
        try {
            for (AbsVideoTemplateModel categoryInfoData : downloadedDataMap.values()) {
                if ((categoryInfoData instanceof VideoBdDownloadModel) && ((VideoBdDownloadModel) categoryInfoData).getBusinessType() == 1) {
                    return true;
                }
            }
            return false;
        } catch (Exception exception) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            exception.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void deleteClick() {
        if (this.mCurrentConvertView.getSelectedCount() > 0) {
            showDeleteDialog();
        }
        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(0, "delete");
    }

    private void setPageTabColor() {
        if (this.mTabHostView != null) {
            Resources resource = getResources();
            this.mTabHostView.setIndicatorColor(resource.getColor(com.baidu.searchbox.download.base.R.color.download_color_blue), 0.3f, resource.getDimension(R.dimen.bookmark_tab_indicator_height));
            this.mTabHostView.setTabTextColor(AppCompatResources.getColorStateList(this, R.color.common_tab_item_textcolor));
            this.mTabHostView.setBoldWhenSelect(true);
            this.mTabHostView.setDividerBackground(resource.getColor(R.color.bookmark_history_group_pressed));
            this.mTabHostView.showOrHideDivider(true);
            this.mTabHostView.setBackgroundColor(resource.getColor(R.color.bookmark_tabhost_bg));
            this.mTabHostView.setTabBarBackgroundColor(resource.getColor(R.color.white));
            this.mTabHostView.layoutTabs(true);
            this.mTabHostView.getPagerTabBarContainer().setLayoutParams(new RelativeLayout.LayoutParams(-1, resource.getDimensionPixelOffset(com.baidu.searchbox.download.center.R.dimen.download_pager_tab_height)));
        }
    }

    public void updateTitleAndToolbar() {
        int num;
        updateTitleBarText();
        List<String> selectData = this.mCurrentConvertView.getSelectedIds();
        if (selectData != null) {
            if (selectData.size() > 0) {
                this.mDownloadBottomMenu.setMenuEnabled(true);
                if (selectData.size() == 1) {
                    this.mDownloadBottomMenu.setDeleteEnabled(true);
                } else if (DownloadMediaHelper.isNotSupportDeleteMoreItem()) {
                    this.mDownloadBottomMenu.setDeleteEnabled(false);
                }
                if (selectData.size() <= 0 || selectData.size() > 9) {
                    this.mDownloadBottomMenu.setShareEnabled(false);
                } else {
                    this.mDownloadBottomMenu.setShareEnabled(true);
                }
                if (selectData.size() == 1) {
                    this.mDownloadBottomMenu.setRenameEnabled(true);
                } else {
                    this.mDownloadBottomMenu.setRenameEnabled(false);
                }
                if (!this.mCurrentConvertView.isSelectAll()) {
                    if (selectData.size() == this.mCurrentConvertView.getAdapter().getItemCount()) {
                        setSelectedAllBtnState(true);
                    } else {
                        setSelectedAllBtnState(false);
                    }
                }
            } else {
                this.mDownloadBottomMenu.setMenuEnabled(false);
            }
            if (this.mCurrentConvertView.isSelectAll()) {
                num = this.mCurrentConvertView.getSelectedCount();
            } else {
                num = selectData.size();
            }
            this.mDownloadBottomMenu.setDeleteCount(num);
        }
    }

    private void updateTitleFooterBar(boolean isInit) {
        if (!this.mIsEditMode) {
            if (this.mDownloadBottomMenu != null) {
                if (!isInit) {
                    this.mLinearLayout.setVisibility(0);
                }
                this.mDownloadBottomMenu.setVisibility(8);
            }
            this.mBdActionBar.setTitle(com.baidu.searchbox.download.center.R.string.type_video);
            return;
        }
        UnifiedBottomBarExtKt.dismissBottomBar(this);
        if (this.mDownloadBottomMenu != null) {
            this.mLinearLayout.setVisibility(0);
            this.mDownloadBottomMenu.setVisibility(0);
            this.mDownloadBottomMenu.showShare();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        DownloadCenterDurationUbc downloadCenterDurationUbc = this.mDurationUbc;
        if (downloadCenterDurationUbc != null) {
            downloadCenterDurationUbc.beginFlow();
        }
        NetDiskOpenViewUtil netDiskOpenViewUtil = this.mNetDiskOpenViewUtil;
        if (netDiskOpenViewUtil != null) {
            netDiskOpenViewUtil.updateTaskInfo();
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            downloadVulcanVideoPlayer.resumePlayer(false);
            this.mLocalVideoPlayer.goBackOrForeground(true);
        }
        ubcShowVideoAutoBackupEntry();
    }

    public void onNightModeChanged(boolean isNightMode) {
        super.onNightModeChanged(isNightMode);
        DownloadBackUpFloatBottomBar downloadBackUpFloatBottomBar = this.mFloatBottomBar;
        if (downloadBackUpFloatBottomBar != null) {
            downloadBackUpFloatBottomBar.onNightModeChanged();
        }
    }

    public void onFontSizeChange() {
        super.onFontSizeChange();
        DownloadBackUpFloatBottomBar downloadBackUpFloatBottomBar = this.mFloatBottomBar;
        if (downloadBackUpFloatBottomBar != null) {
            downloadBackUpFloatBottomBar.onFontSizeChanged();
            updateFloatBottomViewLayoutParams();
        }
    }

    private void updateFloatBottomViewLayoutParams() {
        UnifiedToolBarCustomAreaLayoutParams unifiedParams = DownloadFloatBackButtonUtilsKt.getUnifiedToolBarCustomAreaLayoutParams(this);
        RelativeLayout.LayoutParams floatBottomBarLayoutParams = (RelativeLayout.LayoutParams) this.mFloatBottomBar.getLayoutParams();
        floatBottomBarLayoutParams.height = unifiedParams.getHeightOfViewport();
        floatBottomBarLayoutParams.bottomMargin = unifiedParams.getMarginBottom();
        int floatButtonMarginLeft = unifiedParams.getMarginLeft();
        if (UnifiedTopBarExpMgr.INSTANCE.isHitTopBackExperiment()) {
            floatButtonMarginLeft = 0;
        }
        int marginStartOfScreen = getResources().getDimensionPixelSize(com.baidu.searchbox.download.center.R.dimen.back_up_float_bottom_bar_margin_left) + floatButtonMarginLeft;
        if (Build.VERSION.SDK_INT >= 17) {
            floatBottomBarLayoutParams.setMarginStart(marginStartOfScreen);
        }
        floatBottomBarLayoutParams.leftMargin = marginStartOfScreen;
        this.mFloatBottomBar.setLayoutParams(floatBottomBarLayoutParams);
        if (DownloadCenterAbTestMgr.INSTANCE.isShieldedNetDiskAbility()) {
            this.mFloatBottomBar.setVisibility(8);
        } else {
            this.mFloatBottomBar.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void restartLoaderIfNeeded() {
        if (getSupportLoaderManager().getLoader(0) == null) {
            getSupportLoaderManager().initLoader(0, (Bundle) null, this);
        } else {
            getSupportLoaderManager().restartLoader(0, (Bundle) null, this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        DownloadCenterDurationUbc downloadCenterDurationUbc = this.mDurationUbc;
        if (downloadCenterDurationUbc != null) {
            downloadCenterDurationUbc.endFlow();
        }
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null) {
            int duration = downloadVulcanVideoPlayer.getDuration();
            double progress = 0.0d;
            if (duration != 0) {
                progress = ((double) this.mLocalVideoPlayer.getPosition()) / ((double) duration);
            }
            BdVideoSeries videoSeries = this.mLocalVideoPlayer.getVideoSeries();
            if (videoSeries != null) {
                FileManagerRecentDataControlUtil.INSTANCE.updateVideoPlayProgress(videoSeries.getPlayUrl(), progress);
            }
            this.mLocalVideoPlayer.goBackOrForeground(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processFloatBack(intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer != null && !downloadVulcanVideoPlayer.isFloatingMode()) {
            this.mLocalVideoPlayer.release();
        }
        NetDiskOpenViewUtil netDiskOpenViewUtil = this.mNetDiskOpenViewUtil;
        if (netDiskOpenViewUtil != null) {
            netDiskOpenViewUtil.release();
        }
        VideoDownloadView videoDownloadView = this.mVideoDownloadView;
        if (videoDownloadView != null) {
            videoDownloadView.release();
            this.mVideoDownloadView = null;
        }
        BdEventBus.Companion.getDefault().unregister(this);
        IDownloadCenterApp.Impl.get().modifyIsRead(this, this.mCurrentConvertView.getAllUnreadItemId());
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 29) {
            IDownloadCenterApp.Impl.get().deleteLocalVideoDir(this);
        }
        TranscodeManager.get().unregister(this);
        this.isUbcShowAutoBackupEntry = false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (immersionEnabled() && this.mImmersionHelper != null && newConfig.orientation == 1) {
            getWindow().clearFlags(1024);
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    VideoActivity.this.mImmersionHelper.resetWithCurImmersion();
                }
            }, 200);
        }
    }

    public Loader<VideoLoadResult> onCreateLoader(int arg0, Bundle arg1) {
        return new FusionVideoLoader(this);
    }

    public void onLoadFinished(Loader<VideoLoadResult> loader, VideoLoadResult videoLoadResult) {
        if (!this.mIsEditMode && videoLoadResult != null) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "onLoadFinished");
            }
            List<AbsVideoTemplateModel> downloadVideos = videoLoadResult.getDownloadVideoModels();
            List<AbsVideoTemplateModel> localVideos = VideoLoadHelper.INSTANCE.insertVideoDateModel(videoLoadResult.getLocalVideoModels());
            this.mVideoDownloadView.setData(downloadVideos);
            this.mVideoLocalView.setData(localVideos);
            ubcShowVideoAutoBackupEntry();
            DownloadActionBarMenu.setEditButtonEnabled(this.mBdActionBar, this.mCurrentConvertView.isEditable());
        }
    }

    /* access modifiers changed from: private */
    public void ubcShowVideoAutoBackupEntry() {
        if (!this.isUbcShowAutoBackupEntry) {
            int currentItem = this.mTabHostView.getCurrentItem();
            if ((currentItem == 0 && this.mVideoDownloadView.hasAutoBackupEntry()) || (currentItem == 1 && this.mVideoLocalView.hasAutoBackupEntry())) {
                this.isUbcShowAutoBackupEntry = true;
                AutoBackupStatistic.INSTANCE.bottomTipStatistic("show", "video", "guide_toast");
            }
        }
    }

    public void onLoaderReset(Loader<VideoLoadResult> loader) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doPlayVideo(com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel r22, java.lang.String r23) {
        /*
            r21 = this;
            r7 = r21
            r8 = r22
            java.lang.String r0 = r22.getDownloadPath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0127
            java.lang.String r0 = r22.getDownloadPath()     // Catch:{ Exception -> 0x011d }
            java.lang.String r1 = "utf-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r0, r1)     // Catch:{ Exception -> 0x011d }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x011d }
            if (r1 == 0) goto L_0x0020
            return
        L_0x0020:
            android.net.Uri r1 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x011d }
            r9 = r1
            java.lang.String r1 = r9.getEncodedPath()     // Catch:{ Exception -> 0x011d }
            r10 = r1
            boolean r1 = com.baidu.android.util.io.FileUtils.isExistFile(r10)     // Catch:{ Exception -> 0x011d }
            if (r1 == 0) goto L_0x011c
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            if (r1 == 0) goto L_0x0038
            r1.stop()     // Catch:{ Exception -> 0x011d }
            goto L_0x0044
        L_0x0038:
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = new com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer     // Catch:{ Exception -> 0x011d }
            r1.<init>(r7)     // Catch:{ Exception -> 0x011d }
            r7.mLocalVideoPlayer = r1     // Catch:{ Exception -> 0x011d }
            android.widget.FrameLayout r2 = r7.mContainer     // Catch:{ Exception -> 0x011d }
            r1.attachToContainer(r2)     // Catch:{ Exception -> 0x011d }
        L_0x0044:
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            long r2 = r22.getLongId()     // Catch:{ Exception -> 0x011d }
            r11 = 1
            r1.initCloudBackup(r2, r11)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.DownloadSwitchHelper r2 = new com.baidu.searchbox.download.center.ui.DownloadSwitchHelper     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r3 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r2.<init>(r3)     // Catch:{ Exception -> 0x011d }
            r1.setStyleSwitchHelper(r2)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r1.switchToPortrait(r11, r11)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r2 = 1065353216(0x3f800000, float:1.0)
            r1.setSpeed(r2)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.player.callback.BaseVideoPlayerCallbackManager r1 = r1.getPlayerCallbackManager()     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.VideoActivity$12 r2 = new com.baidu.searchbox.download.center.ui.video.VideoActivity$12     // Catch:{ Exception -> 0x011d }
            r2.<init>(r8, r0)     // Catch:{ Exception -> 0x011d }
            r1.setControlLayerCallback(r2)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.player.callback.BaseVideoPlayerCallbackManager r1 = r1.getPlayerCallbackManager()     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.VideoActivity$13 r2 = new com.baidu.searchbox.download.center.ui.video.VideoActivity$13     // Catch:{ Exception -> 0x011d }
            r2.<init>(r0)     // Catch:{ Exception -> 0x011d }
            r1.setVideoPlayerCallback(r2)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r1.setPlayerListener()     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r1.goBackOrForeground(r11)     // Catch:{ Exception -> 0x011d }
            r1 = 0
            boolean r2 = r8 instanceof com.baidu.searchbox.download.center.ui.video.fusion.model.VideoBdDownloadModel     // Catch:{ Exception -> 0x011d }
            if (r2 == 0) goto L_0x009d
            r2 = r8
            com.baidu.searchbox.download.center.ui.video.fusion.model.VideoBdDownloadModel r2 = (com.baidu.searchbox.download.center.ui.video.fusion.model.VideoBdDownloadModel) r2     // Catch:{ Exception -> 0x011d }
            int r3 = r2.getBusinessType()     // Catch:{ Exception -> 0x011d }
            if (r3 != r11) goto L_0x009d
            r1 = 1
            r12 = r1
            goto L_0x009e
        L_0x009d:
            r12 = r1
        L_0x009e:
            r1 = 0
            com.baidu.searchbox.download.model.CategoryInfoData r2 = r22.getCategoryInfoData()     // Catch:{ Exception -> 0x011d }
            r13 = r2
            if (r13 == 0) goto L_0x00b0
            com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic r2 = com.baidu.searchbox.download.center.ui.fusion.statistic.DownloadCenterStatistic.INSTANCE     // Catch:{ Exception -> 0x011d }
            org.json.JSONObject r2 = r2.buildRecentExtJson((com.baidu.searchbox.download.model.CategoryInfoData) r13)     // Catch:{ Exception -> 0x011d }
            r1 = r2
            r20 = r1
            goto L_0x00b2
        L_0x00b0:
            r20 = r1
        L_0x00b2:
            boolean r1 = com.baidu.searchbox.download.util.DownloadMediaHelper.noNeedMediaFileProcessor(r0)     // Catch:{ Exception -> 0x011d }
            if (r1 == 0) goto L_0x00e4
            com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeFileDeleteUtils r1 = com.baidu.searchbox.download.center.ui.autobackup.transcode.TranscodeFileDeleteUtils.INSTANCE     // Catch:{ Exception -> 0x00e0 }
            r1.setVideoFilePathPlaying(r0)     // Catch:{ Exception -> 0x00e0 }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x00e0 }
            java.lang.String r2 = r22.getTitle()     // Catch:{ Exception -> 0x00e0 }
            r4 = r23
            r1.setVideoInfo(r0, r2, r4, r12)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.vulcan.DownloadVulcanVideoPlayer r1 = r7.mLocalVideoPlayer     // Catch:{ Exception -> 0x011d }
            r1.start()     // Catch:{ Exception -> 0x011d }
            java.lang.String r14 = "file"
            java.lang.String r15 = "open_file"
            java.lang.String r17 = "page_click"
            java.lang.String r18 = "video"
            r16 = r23
            r19 = r20
            com.baidu.download.DownloadStatisticsUBC.openFileStatisticUbc(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x011d }
            goto L_0x00fe
        L_0x00e0:
            r0 = move-exception
            r4 = r23
            goto L_0x011e
        L_0x00e4:
            r4 = r23
            java.lang.String r3 = r22.getTitle()     // Catch:{ Exception -> 0x011d }
            r5 = r12
            r6 = r20
            android.net.Uri r14 = android.net.Uri.parse(r0)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.video.VideoActivity$14 r15 = new com.baidu.searchbox.download.center.ui.video.VideoActivity$14     // Catch:{ Exception -> 0x011d }
            r1 = r15
            r2 = r21
            r4 = r23
            r1.<init>(r3, r4, r5, r6)     // Catch:{ Exception -> 0x011d }
            com.android.support.appcompat.storage.util.UriUtils.convertFileUri(r7, r14, r15)     // Catch:{ Exception -> 0x011d }
        L_0x00fe:
            r1 = 8
            r7.setTabHostViewVisibility(r1)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ioc.IDownloadCenterApp r1 = com.baidu.searchbox.download.center.ioc.IDownloadCenterApp.Impl.get()     // Catch:{ Exception -> 0x011d }
            long[] r2 = new long[r11]     // Catch:{ Exception -> 0x011d }
            r3 = 0
            long r4 = r22.getLongId()     // Catch:{ Exception -> 0x011d }
            r2[r3] = r4     // Catch:{ Exception -> 0x011d }
            r1.modifyIsRead(r7, r2)     // Catch:{ Exception -> 0x011d }
            com.baidu.searchbox.download.center.ui.fusion.util.FileManagerRecentDataControlUtil r1 = com.baidu.searchbox.download.center.ui.fusion.util.FileManagerRecentDataControlUtil.INSTANCE     // Catch:{ Exception -> 0x011d }
            long r2 = r22.getLongId()     // Catch:{ Exception -> 0x011d }
            r1.updateOpenTimeForId(r2)     // Catch:{ Exception -> 0x011d }
        L_0x011c:
            goto L_0x0127
        L_0x011d:
            r0 = move-exception
        L_0x011e:
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0127
            r0.printStackTrace()
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.download.center.ui.video.VideoActivity.doPlayVideo(com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void useImmersion(boolean light, boolean isShowStatusBar) {
        boolean lightStatusBar = !NightModeHelper.isNightMode() && light;
        setEnableImmersion(true);
        if (immersionEnabled()) {
            if (this.mImmersionHelper == null) {
                this.mImmersionHelper = new ImmersionHelper(this);
            }
            this.mImmersionHelper.getConfig().setIsShowStatusBar(isShowStatusBar);
            this.mImmersionHelper.getConfig().setUseLightStatusBar(lightStatusBar);
            this.mImmersionHelper.setImmersion();
            setImmersionHelper(this.mImmersionHelper);
        }
    }

    public void resetWithCurImmersion() {
        if (immersionEnabled() && this.mImmersionHelper != null && getRequestedOrientation() == 1) {
            getWindow().clearFlags(1024);
            this.mImmersionHelper.resetWithCurImmersion();
        }
    }

    public void deleteSelectedItems() {
        List<String> selectData = this.mCurrentConvertView.getSelectedIds();
        final long[] downloadIds = new long[selectData.size()];
        for (int i2 = 0; i2 < selectData.size(); i2++) {
            try {
                downloadIds[i2] = Long.parseLong(selectData.get(i2));
            } catch (Exception e2) {
            }
        }
        long[] toDeletedIds = DownloadCenterUtils.filterCyberDownloadOperate(new ICyberInvoker() {
            public void invoke(DownloadDbItem model) {
                DownloadManagerExt.getInstance().deleteDownloadFile(true, model.getId());
            }
        }, downloadIds);
        if (toDeletedIds != null && toDeletedIds.length > 0) {
            DownloadManagerExt.getInstance().deleteDownloadFile((DownloadMediaHelper.CallBack<ArrayList<Long>>) new DownloadMediaHelper.CallBack<ArrayList<Long>>() {
                public void callback(ArrayList<Long> strings) {
                    if (VideoActivity.this.mDeleteIdList != null) {
                        VideoActivity.this.mDeleteIdList.clear();
                    } else {
                        List unused = VideoActivity.this.mDeleteIdList = new ArrayList();
                    }
                    VideoActivity.this.mDeleteIdList.addAll(strings);
                }
            }, toDeletedIds);
        }
        UiThreadUtils.runOnUiThread(new Runnable() {
            public void run() {
                DownloadActionBarMenu.setEditButtonEnabled(VideoActivity.this.mBdActionBar, VideoActivity.this.mCurrentConvertView.isEditable());
                VideoActivity.this.endEdit();
                VideoActivity.this.sendDeleteMessage(downloadIds);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        AbsVideoTemplateModel absVideoTemplateModel;
        List<Long> list;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1010 || (list = this.mDeleteIdList) == null) {
            if (requestCode == 101 && resultCode == 1 && data != null) {
                String newName = data.getStringExtra(DownloadRenameActivity.MODIFIED_NAME);
                String newFilePath = data.getStringExtra(DownloadRenameActivity.MODIFIED_FILE_PATH);
                if (!TextUtils.isEmpty(newName) && !TextUtils.isEmpty(newFilePath) && (absVideoTemplateModel = this.mRenamedVideoModel) != null) {
                    absVideoTemplateModel.setTitle(newName);
                    this.mRenamedVideoModel.setDownloadPath(newFilePath);
                    this.mVideoDownloadView.updateDataItem(this.mRenamedVideoModel);
                }
            }
        } else if (resultCode == -1 && !list.isEmpty()) {
            DownloadManagerExt.getInstance().deleteDatabaseId(this.mDeleteIdList);
            restartLoaderIfNeeded();
        }
    }

    /* access modifiers changed from: private */
    public void sendDeleteMessage(long[] downloadIds) {
        DataChangedEvent dataChangedEvent = new DataChangedEvent(2);
        for (long id : downloadIds) {
            dataChangedEvent.getItemIds().add(Long.valueOf(id));
        }
        BdEventBus.Companion.getDefault().post(dataChangedEvent);
    }

    /* access modifiers changed from: protected */
    public void showDeleteDialog() {
        SpannableString message = new SpannableString(getString(com.baidu.searchbox.download.center.R.string.download_video_message));
        message.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.searchbox.download.center.R.color.BC51)), 21, 25, 33);
        new BdDialog.Builder().setTitle(com.baidu.searchbox.download.center.R.string.dialog_delete_tips).setMessage((CharSequence) message).setButton(new BdDialog.BottomItem((CharSequence) getString(R.string.dialog_negative_title_cancel), com.baidu.searchbox.download.center.R.color.BC51, (BdDialog.OnItemClickListener) new BdDialog.OnItemClickListener() {
            public void onItemClick(View view2) {
                DownloadStatisticsUBC.dialogDeleteUBC(0, DownloadStatisticConstants.UBC_VALUE_DELETE_OUT);
            }
        })).setButton(new BdDialog.BottomItem(getString(com.baidu.searchbox.download.center.R.string.download_delete_confirm), new BdDialog.OnItemClickListener() {
            public void onItemClick(View view2) {
                ExecutorUtilsExt.postOnElastic(new Runnable() {
                    public void run() {
                        VideoActivity.this.deleteSelectedItems();
                        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(0, "tanchuang_delete");
                    }
                }, "deleteSelectedItems", 1);
            }
        })).show();
        DownloadStatisticsUBC.dialogDeleteUBC(0, DownloadStatisticConstants.UBC_VALUE_DELETE_SHOW);
    }

    public void onSelectedAllClicked(boolean selectedAll) {
        super.onSelectedAllClicked(selectedAll);
        this.mCurrentConvertView.setSelectAll(selectedAll);
        this.mCurrentConvertView.getAdapter().notifyDataSetChanged();
        updateTitleAndToolbar();
        updateShareEnable();
    }

    public void onEditableChanged(boolean isEditable) {
        super.onEditableChanged(isEditable);
        this.mDownloadBottomMenu.showRename();
        this.mDownloadBottomMenu.showDelete();
        this.mDownloadBottomMenu.hiddenPan();
        this.mIsEditMode = isEditable;
        this.mTabHostView.setNoScroll(isEditable);
        this.mCurrentConvertView.setEditMode(isEditable);
        updateTitleAndToolbar();
        updateTitleFooterBar(false);
        if (!UploadNetworkHelper.isNetDiskUploadClose()) {
            if (this.mIsEditMode) {
                if (this.mDownloadBottomMenu.isShareHidden()) {
                    if (this.mIsEditPanMode) {
                        this.mDownloadBottomMenu.hiddenPan();
                    }
                    this.mDownloadBottomMenu.showDelete();
                } else if (this.mIsEditPanMode) {
                    this.mDownloadBottomMenu.showPan(true);
                    this.mDownloadBottomMenu.hiddenDelete();
                } else {
                    this.mDownloadBottomMenu.showDelete();
                }
                AutoBackupPopupWindowHelper.INSTANCE.setCanShowPopupWindow(false);
            } else if (this.mIsEditPanMode) {
                this.mIsEditPanMode = false;
                this.mDownloadBottomMenu.hiddenPan();
            }
        }
        if (!UploadNetworkHelper.isNetDiskUploadClose() && this.mIsEditPanMode && !isEditable) {
            this.mIsEditPanMode = false;
            this.mDownloadBottomMenu.hiddenPan();
        }
        View view2 = this.mTabHostView.findViewById(com.baidu.android.common.ui.R.id.pager_tab_bar_container);
        if (view2 != null) {
            if (this.mTabHeight == 0) {
                this.mTabHeight = view2.getHeight();
            }
            if (isEditable) {
                PictureCategoryHelper.performToolbarAnim(view2, false, this.mTabHeight);
            } else {
                PictureCategoryHelper.performToolbarAnim(view2, true, this.mTabHeight);
            }
        }
        if (isEditable) {
            this.mFloatBottomBar.setVisibility(4);
        } else if (DownloadCenterAbTestMgr.INSTANCE.isShieldedNetDiskAbility()) {
            this.mFloatBottomBar.setVisibility(8);
        } else {
            this.mFloatBottomBar.setVisibility(0);
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4 || !shouldReleasePlayer()) {
            return super.onKeyDown(keyCode, event);
        }
        useImmersion(true, true);
        setTabHostViewVisibility(0);
        TranscodeFileDeleteUtils.INSTANCE.setVideoFilePathPlaying((String) null);
        return true;
    }

    /* access modifiers changed from: private */
    public void setTabHostViewVisibility(int visible) {
        BdPagerTabHost bdPagerTabHost = this.mTabHostView;
        if (bdPagerTabHost != null) {
            bdPagerTabHost.setVisibility(visible);
        }
    }

    private boolean shouldReleasePlayer() {
        DownloadVulcanVideoPlayer downloadVulcanVideoPlayer = this.mLocalVideoPlayer;
        if (downloadVulcanVideoPlayer == null) {
            return false;
        }
        int duration = downloadVulcanVideoPlayer.getDuration();
        double progress = 0.0d;
        if (duration != 0) {
            progress = ((double) this.mLocalVideoPlayer.getPosition()) / ((double) duration);
        }
        BdVideoSeries videoSeries = this.mLocalVideoPlayer.getVideoSeries();
        if (videoSeries != null) {
            FileManagerRecentDataControlUtil.INSTANCE.updateVideoPlayProgress(videoSeries.getPlayUrl(), progress);
        }
        this.mLocalVideoPlayer.switchToHalf(3);
        this.mLocalVideoPlayer.stop();
        this.mLocalVideoPlayer.release();
        this.mLocalVideoPlayer = null;
        return true;
    }

    public void beginEdit() {
        super.beginEdit();
        beginEditUBC();
    }

    public void endEdit() {
        super.endEdit();
        restartLoaderIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void beginEditUBC() {
        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(0, DownloadStatisticConstants.UBC_VALUE_ADMIN);
    }

    /* access modifiers changed from: protected */
    public void endEditUBC() {
        DownloadStatisticsUBC.doDownloadCenterChildPageUBC(0, "cancel");
    }

    private void updateTitleBarText() {
        String actionBarTitle;
        if (isEditable()) {
            int num = this.mCurrentConvertView.getSelectedCount();
            HashMap<Long, AbsVideoTemplateModel> map = this.mCurrentConvertView.getSelectedData();
            long totalBytes = 0;
            for (Long id : map.keySet()) {
                AbsVideoTemplateModel absVideoTemplateModel = map.get(id);
                if (absVideoTemplateModel instanceof VideoBdDownloadModel) {
                    totalBytes += ((VideoBdDownloadModel) absVideoTemplateModel).getTotalBytes();
                }
                if (absVideoTemplateModel instanceof VideoLocalModel) {
                    totalBytes += ((VideoLocalModel) absVideoTemplateModel).getTotalBytes();
                }
            }
            String total = DownloadVideoUtils.convertByte((double) totalBytes);
            String title = getResources().getString(com.baidu.searchbox.download.center.R.string.download_edit_title_format_text, new Object[]{String.valueOf(num)});
            if (num > 0) {
                actionBarTitle = title + getResources().getString(com.baidu.searchbox.download.center.R.string.download_editable_title_memory, new Object[]{total});
            } else {
                actionBarTitle = "";
            }
            if (this.mDownloadBottomMenu.isPanHidden()) {
                DownloadedDocActivity.setActionBarTitle(getEditBdActionBar(), actionBarTitle);
                return;
            }
            this.mDownloadBottomMenu.setSelectedCountText(title);
            this.mDownloadBottomMenu.setSelectedMemoryText(total);
            DownloadedDocActivity.setActionBarTitle(getEditBdActionBar(), "");
            return;
        }
        DownloadedDocActivity.setActionBarTitle(getEditBdActionBar(), getString(com.baidu.searchbox.download.center.R.string.type_video));
    }

    /* access modifiers changed from: private */
    public void renameClick() {
        AbsVideoTemplateModel absVideoTemplateModel;
        List<String> selectData = this.mCurrentConvertView.getSelectedIds();
        if (selectData.size() == 1 && (absVideoTemplateModel = this.mCurrentConvertView.getSelectedModelWithId(selectData.get(0))) != null) {
            this.mRenamedVideoModel = absVideoTemplateModel;
            gotoRenameActivity(this, absVideoTemplateModel.getTitle(), absVideoTemplateModel.getDownloadPath(), absVideoTemplateModel.getLongId());
        }
    }

    private void gotoRenameActivity(Context context, String filename, String filePath, long id) {
        CategoryInfoData categoryInfoData = new CategoryInfoData();
        categoryInfoData.mFileName = filename;
        categoryInfoData.mId = id;
        categoryInfoData.mDownloadPath = filePath;
        Intent intent = new Intent(context, DownloadRenameActivity.class);
        intent.putExtra("categoryInfoData", categoryInfoData);
        ActivityUtils.startActivityForResultSafely(context, intent, 101);
    }

    public void onEditButtonClick(DownloadActionBarMenu.MenuClickType arg) {
        if (!isEditable()) {
            beginEdit(true);
            if (arg == DownloadActionBarMenu.MenuClickType.ONLY_UPLOAD_NETDISK) {
                this.mDownloadBottomMenu.hiddenRename();
                this.mDownloadBottomMenu.hiddenDelete();
                this.mDownloadBottomMenu.showPan(true);
            } else {
                this.mDownloadBottomMenu.showRename();
                this.mDownloadBottomMenu.showDelete();
                this.mDownloadBottomMenu.hiddenPan();
            }
            updateTitleBarText();
        }
    }

    public void onFileRename(DownloadedFileRenameDispatcher.FileRenameResult fileRenameResult) {
        endEdit();
    }

    public void onResult(FileOperationResult fileOperationResult) {
    }

    public void onResult(TranscodeResult result) {
        if (BdDiskUtil.checkActivity(this)) {
            boolean isManualTranscode = false;
            boolean transcodeSuccess = 1 == result.state;
            if (TranscodeTriggerSource.MANUAL_BACKUP == result.triggerSource) {
                isManualTranscode = true;
            }
            if (transcodeSuccess && isManualTranscode) {
                UploadNetworkHelper.showNetdiskUploadListSwanApp(this);
                BdEventBus.Companion.getDefault().post(result);
            }
        }
    }

    public void onBackPressed() {
        if (isEditable()) {
            endEditUBC();
        }
        super.onBackPressed();
    }

    public void onItemLongClickCallback(int position, AbsVideoTemplateModel videoTemplateModel) {
        if (!isEditable()) {
            beginEdit();
            updateTitleAndToolbar();
        }
    }

    public void onItemClickCallback(int position, AbsVideoTemplateModel videoModel) {
        if (videoModel instanceof VideoCommonDownloadSiteEntryModel) {
            startActivity(new Intent(this, VideoCommonDownloadSiteActivity.class));
            VideoManagerUbcHelper.INSTANCE.doVideoManagerStatistic("tool", "recent_web", "file", "video", "", VideoManagerUbcHelper.INSTANCE.getCommonFromExtObj().toString());
        } else if (videoModel instanceof VideoNetDiskEntryModel) {
            LoginUtilsKt.checkLoginAndRun(this, getResources().getString(com.baidu.searchbox.download.center.R.string.download_auto_backup_login_title_video_entry), new Runnable() {
                public void run() {
                    Router.invoke(VideoActivity.this, VideoActivity.SCHEME_NET_DISK_VIDEO);
                }
            });
        } else {
            String ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_DOWNLOAD_VIDEO;
            if (videoModel instanceof VideoBdDownloadModel) {
                ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_DOWNLOAD_VIDEO;
                if (CategoryInfoDataExtKt.goToVideoImmersive(videoModel.getCategoryInfoData(), this)) {
                    return;
                }
            } else if (videoModel instanceof VideoLocalModel) {
                ubcPage = DownloadStatisticConstants.UBC_PAGE_LOCAL_ALBUM_VIDEO;
            }
            doPlayVideo(videoModel, ubcPage);
        }
    }

    public void onItemSelectStateChangeCallback(int position, AbsVideoTemplateModel videoTemplateModel, boolean selected) {
        if (!this.mCurrentConvertView.toggleCheck(videoTemplateModel, false)) {
            setAllSelectedBtnState(false);
        } else if (this.mCurrentConvertView.isSelectAll()) {
            setAllSelectedBtnState(true);
        }
        updateTitleAndToolbar();
        updateShareEnable();
    }

    private void updateShareEnable() {
        if (this.mDownloadBottomMenu != null) {
            HashMap<Long, AbsVideoTemplateModel> selectedData = this.mCurrentConvertView.getSelectedData();
            if (selectedData == null || selectedData.isEmpty()) {
                this.mDownloadBottomMenu.setShareEnabled(false);
                return;
            }
            this.mDownloadBottomMenu.setShareEnabled(!isContainKernelDownloadItem(selectedData));
        }
    }

    public UnifiedBottomBarOption getBottomBarOption() {
        BottomBarOptionFloatingBack barOption = new BottomBarOptionFloatingBack();
        barOption.setHideBackWithTopBackExperiment(true);
        return barOption;
    }

    /* renamed from: com.baidu.searchbox.download.center.ui.video.VideoActivity$22  reason: invalid class name */
    static /* synthetic */ class AnonymousClass22 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID;

        static {
            int[] iArr = new int[BottomBarElementID.values().length];
            $SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID = iArr;
            try {
                iArr[BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public boolean onBottomBarElementClickEvent(BarElementClickContext context) {
        switch (AnonymousClass22.$SwitchMap$com$baidu$searchbox$unifiedtoolbar$base$BottomBarElementID[context.getElementId().ordinal()]) {
            case 1:
                AutoBackupStatistic.INSTANCE.netDiskEntryStatistic("click", "video");
                LoginUtilsKt.checkLoginAndRun(this, getResources().getString(com.baidu.searchbox.download.center.R.string.download_auto_backup_login_title_video_entry), new Runnable() {
                    public void run() {
                        Router.invoke(VideoActivity.this, VideoActivity.SCHEME_NET_DISK_VIDEO);
                    }
                });
                return true;
            default:
                return super.onBottomBarElementClickEvent(context);
        }
    }
}
