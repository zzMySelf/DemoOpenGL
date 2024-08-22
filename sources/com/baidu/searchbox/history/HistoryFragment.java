package com.baidu.searchbox.history;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.loader.app.LoaderManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.ext.widget.dialog.BdProgressDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.io.Closeables;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.event.AccountQuickLoginEvent;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinFace;
import com.baidu.searchbox.bookmark.BookmarkUBC;
import com.baidu.searchbox.bookmark.BookmarkUtil;
import com.baidu.searchbox.bookmark.HistoryUBC;
import com.baidu.searchbox.boxshare.BoxShareManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.history.adapter.HistoryAdapter;
import com.baidu.searchbox.history.api.IHistoryManager;
import com.baidu.searchbox.history.api.callback.HistoryDataCallback;
import com.baidu.searchbox.history.api.callback.OnDataChangeListener;
import com.baidu.searchbox.history.api.data.HistoryLoaderType;
import com.baidu.searchbox.history.api.data.HistoryModel;
import com.baidu.searchbox.history.api.data.LoaderParams;
import com.baidu.searchbox.history.api.util.HistoryList;
import com.baidu.searchbox.history.core.db.HistoryTable;
import com.baidu.searchbox.history.core.recyclebin.HistoryRecycleBinManager;
import com.baidu.searchbox.history.core.util.UriHelper;
import com.baidu.searchbox.history.debug.favorstatus.FavorStatusSwitcherManager;
import com.baidu.searchbox.history.debug.favorstatus.HistoryConvertFavorDebugUtilsKt;
import com.baidu.searchbox.history.good.HistoryGoodView;
import com.baidu.searchbox.history.ioc.HistoryUtils;
import com.baidu.searchbox.history.ioc.IHistoryApp;
import com.baidu.searchbox.history.webvideo.HistoryWebVideoUbcListener;
import com.baidu.searchbox.history.webvideo.HistoryWebVideoView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.statistic.RevisitStatisticUtil;
import com.baidu.searchbox.uar.FavorHisUARScrollListener;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.searchbox.userassetsaggr.container.AbsListFragment;
import com.baidu.searchbox.userassetsaggr.container.AbsListFragmentKt;
import com.baidu.searchbox.userassetsaggr.container.FavorHisAbTestManager;
import com.baidu.searchbox.userassetsaggr.container.ILoginController;
import com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer;
import com.baidu.searchbox.userassetsaggr.container.QuickLoginViewHelper;
import com.baidu.searchbox.userassetsaggr.container.R;
import com.baidu.searchbox.userassetsaggr.container.UserAssetRouteUtilKt;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyDataManager;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyViewPage;
import com.baidu.searchbox.userassetsaggr.container.data.FavorHisIncognitoManagerKt;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsCommandListenerKt;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsSharedPrefs;
import com.baidu.searchbox.userassetsaggr.container.decoration.HistorySimpleDateStickyItem;
import com.baidu.searchbox.userassetsaggr.container.decoration.IDateStickyItem;
import com.baidu.searchbox.userassetsaggr.container.decoration.IStickyItem;
import com.baidu.searchbox.userassetsaggr.container.decoration.StickyItemDecoration;
import com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration;
import com.baidu.searchbox.userassetsaggr.container.recyclebin.DeleteDialogWithRecycleBin;
import com.baidu.searchbox.userassetsaggr.container.recyclebin.IDeleteDialogWithRecycleCallback;
import com.baidu.searchbox.userassetsaggr.container.share.ShareModel;
import com.baidu.searchbox.userassetsaggr.container.share.ShareUtil;
import com.baidu.searchbox.userassetsaggr.container.template.ITemplate;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateCreatorKt;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateEnum;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateEnumKt;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateModel;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc;
import com.baidu.searchbox.userassetsaggr.container.ui.ClassifyView;
import com.baidu.searchbox.userassetsaggr.container.ui.FavorHisBottomFloatBar;
import com.baidu.searchbox.userassetsaggr.container.ui.FavorHisBottomMenu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class HistoryFragment extends AbsListFragment implements OnDataChangeListener, ILoginController, OnHistoryItemShowListener {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String HISTORY_ENTER_MILLIS_SP_KEY = "History_enter_millis_sp_key";
    private static final String HISTORY_ENTER_TIMES_SP_KEY = "History_enter_times_sp_key";
    private static final String TAG = "HistoryFragment";
    private static String ubcPageShowSource = "";
    private boolean backToTopShow = false;
    private FavorHisBottomFloatBar bottomFloatBar;
    private ViewStub bottomFloatBarStub;
    private ClassifyModel currentClassifyModel;
    private String defaultClassifyId;
    private String[] excludeTplArray = {"product", "search_web_video"};
    private IHistoryManager historyManager = ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE));
    private final boolean isHistoryLoginCancel = AbTestManager.getInstance().getSwitch("history_login_in_cancel", false);
    /* access modifiers changed from: private */
    public BdProgressDialog mBdProgressDialog = null;
    private HistoryAdapter.BottomFloatBarCallback mBottomFloatBarCallback;
    /* access modifiers changed from: private */
    public ClassifyView mClassifyView;
    private DividerDecoration mDividerDecoration;
    /* access modifiers changed from: private */
    public CommonEmptyView mEmpty;
    /* access modifiers changed from: private */
    public ITemplate mEmptyDivideTemplate;
    /* access modifiers changed from: private */
    public NestedScrollView mEmptyLayout;
    private int mEnterTimes = 0;
    private GridLayoutManager mGridLayoutManager;
    private boolean mHasDoHistoryCountUbc = false;
    private boolean mHasHistoryDataLoadFinished = false;
    private boolean mHasRecordHistoryEnterTimes = false;
    /* access modifiers changed from: private */
    public HistoryAdapter mHistoryAdapter;
    private HistoryDividerItem mHistoryDividerItem;
    /* access modifiers changed from: private */
    public HistoryGoodView mHistoryGoodsView = null;
    private PopupWindow mHistoryPopup;
    public HashSet<String> mHistoryUbcRecord = new HashSet<>();
    /* access modifiers changed from: private */
    public HistoryWebVideoView mHistoryWebVideoView = null;
    private boolean mIsEditable;
    private boolean mIsVisibleToUser = false;
    private LinearLayoutManager mLinearLayoutManager;
    private LoaderManager mLoaderManager;
    private LoaderParams mLoaderParams;
    private QuickLoginViewHelper mLoginViewHelper;
    private HistoryAdapter.OnItemClickListener mOnItemClickListener = new HistoryAdapter.OnItemClickListener() {
        public void onItemClick(int position, HistoryModel model) {
            if (model != null) {
                HistoryFragment.this.clickItem(position, model, model.getCmd(), model.getUrl());
                HistoryFragment.addVisitHisCount(model.getUkey());
            }
        }

        public void onItemLongClick(int position, HistoryModel model, TemplateModel templateModel, View v) {
            View bottomSheetAttachView;
            if (HistoryFragment.this.mHistoryAdapter != null && model != null && templateModel != null && v != null) {
                if (AppConfig.isDebug() && FavorStatusSwitcherManager.INSTANCE.isCanShowFavorStatusInHistory() && (bottomSheetAttachView = HistoryFragment.this.mRootView) != null) {
                    HistoryConvertFavorDebugUtilsKt.showHistoryConvertFavorBottomSheetInDebug(bottomSheetAttachView, model);
                } else if (HistoryFragment.this.getActivity() != null && !HistoryFragment.this.mHistoryAdapter.isEditMode()) {
                    HistoryFragment.this.mHistoryAdapter.clearSelectIds();
                    FavorHisBottomMenu menu = new FavorHisBottomMenu(HistoryFragment.this.getActivity(), v);
                    menu.setOnCommonMenuDisplayListener(new HistoryFragment$1$$ExternalSyntheticLambda0(menu, model));
                    menu.setOnItemClickListener(new HistoryFragment$1$$ExternalSyntheticLambda1(this, model, templateModel, position, menu));
                    TemplateEnum type = TemplateEnumKt.valueOf(HistoryFragment.this.mHistoryAdapter.getItemViewType(position));
                    if (type == TemplateEnum.COMMON_AD || type == TemplateEnum.FEED_AD) {
                        menu.showAdvertMenu(templateModel.getTitle(), false, false, templateModel.isShowFeedback(), templateModel.isShowServiceRate());
                        return;
                    }
                    String tplId = model.getTplId();
                    menu.showHisMenu(templateModel.getTitle(), templateModel.getBottomDialogShowSource(), tplId != null && ClassifyDataManager.INSTANCE.isNovelClassify(ClassifyViewPage.PAGE_HISTORY, tplId));
                }
            }
        }

        static /* synthetic */ void lambda$onItemLongClick$0(FavorHisBottomMenu menu, HistoryModel model, CommonMenu menu1, boolean isShown) {
            if (isShown) {
                menu.ubcShowEvent("tab_his", HistoryUBC.getMenuUbcExtStr(model));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onItemLongClick$1$com-baidu-searchbox-history-HistoryFragment$1  reason: not valid java name */
        public /* synthetic */ boolean m19972lambda$onItemLongClick$1$combaidusearchboxhistoryHistoryFragment$1(HistoryModel model, TemplateModel templateModel, int position, FavorHisBottomMenu menu, View v1, CommonMenuItem item) {
            HistoryFragment.this.handleMenuClick(item, model, templateModel, position);
            if (item != null) {
                menu.ubcClickEvent(item.getItemId(), "tab_his", HistoryUBC.getMenuUbcExtStr(model));
            }
            menu.dismiss(false);
            return false;
        }
    };
    private View mRecyclerNestedScrollView;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    /* access modifiers changed from: private */
    public ViewGroup mRootView;
    private BoxShareManager mShareManager;
    private IStickyItem mStickyItem;
    private StickyItemDecoration mStickyItemDecoration;

    /* access modifiers changed from: private */
    public void handleMenuClick(CommonMenuItem menuItem, HistoryModel model, TemplateModel templateModel, int position) {
        HistoryModel historyModel = model;
        if (this.mHistoryAdapter == null || menuItem == null || historyModel == null) {
            int i2 = position;
        } else if (templateModel == null) {
            int i3 = position;
        } else {
            boolean z = true;
            if (menuItem.getItemId() == 1) {
                FavorHisIncognitoManagerKt.openIncognitoMode(getContext(), true);
                clickItem(position, historyModel, model.getCmd(), model.getUrl());
                return;
            }
            int i4 = position;
            if (this.mHistoryAdapter.toggleCheck(historyModel)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        onDeletedClicked();
                        return;
                    case 4:
                        if (getMainContainer() != null) {
                            getMainContainer().enterEditMode();
                            this.mHistoryAdapter.toggleCheck(historyModel);
                            getMainContainer().updateAllSelectedBtnState(this.mHistoryAdapter.isAllSelected());
                            IUserAssetsContainer mainContainer = getMainContainer();
                            if (this.mHistoryAdapter.getSelectedIds().size() <= 0) {
                                z = false;
                            }
                            mainContainer.updateDeleteBtnState(z, this.mHistoryAdapter.getSelectedIds().size());
                            return;
                        }
                        return;
                    case 5:
                        UserAssetRouteUtilKt.adFeedbackJump(getActivity(), templateModel.getUkey());
                        return;
                    case 6:
                        UserAssetRouteUtilKt.adServiceRateJump(getActivity(), templateModel.getServiceRateUrl());
                        return;
                    case 7:
                        String source = "";
                        if (!ClassifyDataManager.INSTANCE.isCollectionClassify(model.getTplId()) && !ClassifyDataManager.INSTANCE.isPlayletClassify(model.getTplId())) {
                            source = templateModel.getSource();
                        } else if (model.getFeature() != null) {
                            source = model.getFeature().getUserName();
                        }
                        this.mShareManager = ShareUtil.shareUrl(getActivity(), new ShareModel(ClassifyViewPage.PAGE_HISTORY, model.getTplId(), model.getTitle(), source, model.getUrl(), model.getImg(), "tab_his", model.getUkey()));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public HistoryFragment() {
        AbsListFragmentKt.setLoginController(this, this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                try {
                    Activity activity = HistoryFragment.this.getActivity();
                    if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && HistoryFragment.this.isAdded()) {
                        HistoryFragment.this.setPageResources();
                    }
                } catch (Exception e2) {
                    if (AppConfig.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        this.mLoaderManager = getLoaderManager();
        this.mLoaderParams = LoaderParams.builder().delayMs(500).excludeTplArray(this.excludeTplArray).build();
        Activity currentActivity = getActivity();
        if (currentActivity != null) {
            this.mBdProgressDialog = new BdProgressDialog(currentActivity);
        }
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("source")) {
                String string = bundle.getString("source");
                ubcPageShowSource = string;
                BookmarkUBC.hisShowEvent(string);
                RevisitStatisticUtil.INSTANCE.historyShowEvent(ubcPageShowSource);
            }
            if (bundle.containsKey("classify_id")) {
                this.defaultClassifyId = bundle.getString("classify_id");
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.history_fragment_layout_new, container, false);
        this.mRootView = viewGroup;
        RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.recycler_view);
        this.mRecyclerView = recyclerView;
        recyclerView.addOnScrollListener(new FavorHisUARScrollListener());
        this.mRecyclerNestedScrollView = this.mRootView.findViewById(R.id.history_nested_scroll_layout);
        this.mHistoryGoodsView = (HistoryGoodView) this.mRootView.findViewById(R.id.history_good_view);
        HistoryWebVideoView historyWebVideoView = (HistoryWebVideoView) this.mRootView.findViewById(R.id.history_web_video_view);
        this.mHistoryWebVideoView = historyWebVideoView;
        historyWebVideoView.setWebVideoUbcListener(new HistoryWebVideoUbcListener() {
            public void onItemClickUbc(int position, HistoryModel model) {
                HistoryFragment.this.statHistoryClick(position, model);
            }
        });
        this.mClassifyView = (ClassifyView) this.mRootView.findViewById(R.id.history_classify_view);
        HistoryCustomLinearLayoutManager historyCustomLinearLayoutManager = new HistoryCustomLinearLayoutManager(getContext());
        this.mLinearLayoutManager = historyCustomLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(historyCustomLinearLayoutManager);
        this.mEmpty = (CommonEmptyView) this.mRootView.findViewById(R.id.empty);
        this.mEmptyLayout = (NestedScrollView) this.mRootView.findViewById(R.id.empty_layout);
        this.bottomFloatBarStub = (ViewStub) this.mRootView.findViewById(R.id.history_bottom_float_bar_stub);
        this.mEmpty.setBackground((Drawable) null);
        HistoryAdapter historyAdapter = new HistoryAdapter(getContext(), this.mOnItemClickListener);
        this.mHistoryAdapter = historyAdapter;
        historyAdapter.setHistoryItemShowedListener(this);
        initDividerDecoration();
        this.mRecyclerView.setAdapter(this.mHistoryAdapter);
        initClassifyView();
        setPageResources();
        return this.mRootView;
    }

    private void initClassifyView() {
        this.mClassifyView.setOnItemClickListener(new ClassifyView.OnItemClickListener() {
            public void onItemClick(ClassifyModel model) {
                HistoryFragment.this.changeCurrentViewStatusByType(model);
                if (FavorHisAbTestManager.INSTANCE.isHitWebVideoExperimental() && model != null && TextUtils.equals("search_web_video", model.getIdentify())) {
                    DefaultSharedPrefsWrapper.getInstance().putBoolean(UserAssetsCommandListenerKt.SHOWED_HISTORY_CLASSIFY_WEB_VIDEO_TIP_SP_KEY, true);
                }
            }
        });
        if (this.mClassifyView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mClassifyView.getLayoutParams();
            if (FavorHisAbTestManager.INSTANCE.getFavorHisBetterStyleSwitch()) {
                params.setMargins(0, 0, 0, DeviceUtils.ScreenInfo.dp2px(getContext(), 7.0f));
            } else {
                params.setMargins(DeviceUtils.ScreenInfo.dp2px(getContext(), 12.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 7.0f));
            }
            this.mClassifyView.setLayoutParams(params);
        }
        this.mClassifyView.getHistoryDataFromLocal(this.defaultClassifyId);
        ClassifyModel selectedModel = this.mClassifyView.getSelectedClassifyModel();
        if (selectedModel != null) {
            this.currentClassifyModel = selectedModel;
            if (FavorHisAbTestManager.INSTANCE.isHitWebVideoExperimental() && !DefaultSharedPrefsWrapper.getInstance().getBoolean(UserAssetsCommandListenerKt.SHOWED_HISTORY_CLASSIFY_WEB_VIDEO_TIP_SP_KEY, false)) {
                if (!TextUtils.equals(selectedModel.getIdentify(), "search_web_video")) {
                    setClassifyTips();
                } else {
                    DefaultSharedPrefsWrapper.getInstance().putBoolean(UserAssetsCommandListenerKt.SHOWED_HISTORY_CLASSIFY_WEB_VIDEO_TIP_SP_KEY, true);
                }
            }
        }
        setEmptyViewLayout();
    }

    private void setClassifyTips() {
        IHistoryManager iHistoryManager = this.historyManager;
        if (iHistoryManager != null) {
            iHistoryManager.queryHistoryCountByTplIdAsync("search_web_video", new HistoryDataCallback<Integer>() {
                public void onResult(Integer data) {
                    boolean shouldShow = data != null && data.intValue() > 0;
                    if (HistoryFragment.this.mClassifyView != null) {
                        HistoryFragment.this.mClassifyView.setTipsType("search_web_video", ClassifyView.TipsType.DOT);
                        HistoryFragment.this.mClassifyView.setShouldShowTips("search_web_video", shouldShow);
                    }
                }
            });
        }
    }

    private void inflateBottomFloatBar() {
        ViewStub viewStub = this.bottomFloatBarStub;
        if (viewStub != null && this.bottomFloatBar == null) {
            try {
                FavorHisBottomFloatBar favorHisBottomFloatBar = (FavorHisBottomFloatBar) viewStub.inflate();
                this.bottomFloatBar = favorHisBottomFloatBar;
                favorHisBottomFloatBar.initLayoutParams();
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void showOrHideBottomFloatBar(boolean show) {
        FavorHisBottomFloatBar favorHisBottomFloatBar = this.bottomFloatBar;
        if (favorHisBottomFloatBar != null) {
            if (show) {
                favorHisBottomFloatBar.setVisibility(0);
            } else {
                favorHisBottomFloatBar.setVisibility(8);
            }
            setEmptySubTitle();
        }
    }

    private void showIncognitoModeTipBar() {
        BoxAccountManager loginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        boolean show = true;
        if (!(loginManager != null && loginManager.isLogin(2)) || this.backToTopShow || this.mIsEditable || !FavorHisIncognitoManagerKt.isIncognitoMode()) {
            show = false;
        }
        if (show) {
            inflateBottomFloatBar();
            if (!(this.bottomFloatBar == null || getContext() == null)) {
                this.bottomFloatBar.setTipBtnText(getContext().getString(R.string.favor_his_incognito_mode_tip), getContext().getString(R.string.favor_his_close_incognito));
                this.bottomFloatBar.setListener(new HistoryFragment$$ExternalSyntheticLambda1(this));
            }
            initBottomFloatBarCallback();
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            if (historyAdapter != null) {
                historyAdapter.setBottomFloatBarCallback(this.mBottomFloatBarCallback);
            }
            HistoryGoodView historyGoodView = this.mHistoryGoodsView;
            if (!(historyGoodView == null || historyGoodView.getGoodAdapter() == null)) {
                this.mHistoryGoodsView.getGoodAdapter().setBottomFloatBarCallback(this.mBottomFloatBarCallback);
            }
            HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
            if (!(historyWebVideoView == null || historyWebVideoView.getWebVideoAdapter() == null)) {
                this.mHistoryWebVideoView.getWebVideoAdapter().setBottomFloatBarCallback(this.mBottomFloatBarCallback);
            }
            int ordinal = TemplateEnum.BOTTOM_FLOAT_BAR_HOLDER.ordinal();
            DividerDecoration dividerDecoration = this.mDividerDecoration;
            if (dividerDecoration != null) {
                dividerDecoration.setBottomHolderCallback(this.mHistoryAdapter);
            }
            HistoryGoodView historyGoodView2 = this.mHistoryGoodsView;
            if (!(historyGoodView2 == null || historyGoodView2.getDividerDecoration() == null)) {
                this.mHistoryGoodsView.getDividerDecoration().setBottomHolderCallback(this.mHistoryGoodsView.getGoodAdapter());
            }
            HistoryWebVideoView historyWebVideoView2 = this.mHistoryWebVideoView;
            if (!(historyWebVideoView2 == null || historyWebVideoView2.getDividerDecoration() == null)) {
                this.mHistoryWebVideoView.getDividerDecoration().setBottomHolderCallback(this.mHistoryWebVideoView.getWebVideoAdapter());
            }
            HistoryUBC.event("show", "", HistoryUBC.SOURCE_PRIVATE_BANNER, "tab_his");
        }
        showOrHideBottomFloatBar(show);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$showIncognitoModeTipBar$0$com-baidu-searchbox-history-HistoryFragment  reason: not valid java name */
    public /* synthetic */ void m19971lambda$showIncognitoModeTipBar$0$combaidusearchboxhistoryHistoryFragment() {
        FavorHisIncognitoManagerKt.closeIncognitoMode(getContext(), true);
        showOrHideBottomFloatBar(false);
        if (currentSelectedIsProductType()) {
            HistoryGoodView historyGoodView = this.mHistoryGoodsView;
            if (!(historyGoodView == null || historyGoodView.getGoodAdapter() == null)) {
                this.mHistoryGoodsView.getGoodAdapter().notifyDataSetChanged();
            }
        } else if (currentSelectedIsWebVideoType()) {
            HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
            if (!(historyWebVideoView == null || historyWebVideoView.getWebVideoAdapter() == null)) {
                this.mHistoryWebVideoView.getWebVideoAdapter().notifyDataSetChanged();
            }
        } else {
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            if (historyAdapter != null) {
                historyAdapter.notifyDataSetChanged();
            }
        }
        HistoryUBC.event("click", "", HistoryUBC.SOURCE_PRIVATE_BANNER, "tab_his");
    }

    private void initBottomFloatBarCallback() {
        if (this.mBottomFloatBarCallback == null) {
            this.mBottomFloatBarCallback = new HistoryFragment$$ExternalSyntheticLambda0(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initBottomFloatBarCallback$1$com-baidu-searchbox-history-HistoryFragment  reason: not valid java name */
    public /* synthetic */ boolean m19970lambda$initBottomFloatBarCallback$1$combaidusearchboxhistoryHistoryFragment() {
        FavorHisBottomFloatBar favorHisBottomFloatBar = this.bottomFloatBar;
        return favorHisBottomFloatBar != null && favorHisBottomFloatBar.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public void changeCurrentViewStatusByType(ClassifyModel model) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.stopScroll();
        }
        this.currentClassifyModel = model;
        if (model != null) {
            String identify = model.getIdentify();
            if (getMainContainer() != null && this.mHistoryAdapter.isEditMode()) {
                getMainContainer().endEditMode();
            }
            if (getMainContainer() != null) {
                HistoryGoodView historyGoodView = this.mHistoryGoodsView;
                if (historyGoodView != null && historyGoodView.getVisibility() == 0 && this.mHistoryGoodsView.getCurrentIsEditable()) {
                    getMainContainer().endEditMode();
                }
                HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
                if (historyWebVideoView != null && historyWebVideoView.getVisibility() == 0 && this.mHistoryWebVideoView.getCurrentIsEditable()) {
                    getMainContainer().endEditMode();
                }
            }
            String[] tplArray = this.currentClassifyModel.getTplArray();
            if ("product".equals(identify)) {
                if (getMainContainer() != null) {
                    this.mHistoryGoodsView.setMainContainer(getMainContainer());
                    this.mHistoryGoodsView.setMLoaderManager(this.mLoaderManager);
                }
                this.mHistoryGoodsView.setOnLoadFinish(new HistoryGoodView.OnDataLoadFinishListener() {
                    public void onLoadFinish() {
                        HistoryFragment.this.mRecyclerView.setVisibility(8);
                        HistoryFragment.this.mEmptyLayout.setVisibility(8);
                        HistoryFragment.this.mHistoryWebVideoView.setVisibility(8);
                        HistoryFragment.this.mHistoryGoodsView.setVisibility(0);
                    }
                });
                this.mHistoryGoodsView.firstFetchRequestData(true);
            } else if ("all".equals(identify)) {
                this.mLoaderParams = LoaderParams.builder().delayMs(500).requestType(identify).excludeTplArray(this.excludeTplArray).build();
                IHistoryManager iHistoryManager = this.historyManager;
                if (iHistoryManager != null) {
                    iHistoryManager.refreshData(this.mLoaderManager, HistoryLoaderType.ALL_HISTORY, this, this.mLoaderParams);
                }
            } else if ("search_web_video".equals(identify)) {
                if (getMainContainer() != null) {
                    this.mHistoryWebVideoView.setMainContainer(getMainContainer());
                }
                this.mRecyclerView.setVisibility(8);
                this.mEmptyLayout.setVisibility(8);
                this.mHistoryGoodsView.setVisibility(8);
                this.mHistoryWebVideoView.setVisibility(0);
                this.mHistoryWebVideoView.setClassifyModel(this.currentClassifyModel);
                this.mHistoryWebVideoView.getHistoryWebVideoData(-1, 20, false);
            } else if (tplArray != null && tplArray.length > 0) {
                this.mLoaderParams = LoaderParams.builder().tplArray(tplArray).excludeTplArray(this.excludeTplArray).requestType(identify).delayMs(500).build();
                IHistoryManager iHistoryManager2 = this.historyManager;
                if (iHistoryManager2 != null) {
                    iHistoryManager2.refreshData(this.mLoaderManager, HistoryLoaderType.ITEM_FUZZY_QUERY_TITLE_WITH_TPL, this, this.mLoaderParams);
                }
            }
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        ViewGroup viewGroup;
        super.onActivityCreated(savedInstanceState);
        if (!this.isHistoryLoginCancel || (viewGroup = this.mRootView) == null) {
            QuickLoginViewHelper build = QuickLoginViewHelper.Builder.builder(getContext()).setRootView(this.mRootView).setLoginMainTitle(getString(R.string.his_login_main_title)).setLoginSrc("personal_history_active").setUseCloudSwitch(true).setCloudSwitchKey(UserAssetsCommandListenerKt.KEY_HISTORY_LOGIN_SWITCH).setCallback(new QuickLoginViewHelper.LoginChangeCallback() {
                public void showLoginView() {
                    if (HistoryFragment.DEBUG) {
                        Log.d(HistoryFragment.TAG, "showLoginView: HistoryFragment");
                    }
                    HistoryFragment.this.tryShowContent();
                }
            }).setLoginViewReadyCallback(new QuickLoginViewHelper.LoginViewReadyCallback() {
                public void onLoginViewReady() {
                    Bundle bundle = HistoryFragment.this.getArguments();
                    if (bundle != null && bundle.containsKey("source")) {
                        HistoryFragment.this.onFragmentSeleted();
                    }
                }
            }).setFunctionIcon(getResources().getDrawable(R.drawable.account_history_function_icon)).addOtherView(this.mRecyclerNestedScrollView).build();
            this.mLoginViewHelper = build;
            build.onCreate();
            return;
        }
        HistoryUtils.hideInputMethod(viewGroup);
        tryShowContent();
    }

    public void onResume() {
        HistoryWebVideoView historyWebVideoView;
        ClassifyView classifyView;
        super.onResume();
        updateFontSize();
        if (this.mIsVisibleToUser && (classifyView = this.mClassifyView) != null) {
            classifyView.doTabShowUbc();
            classifyView.beginUbcFlow();
        }
        if (currentSelectedIsWebVideoType() && (historyWebVideoView = this.mHistoryWebVideoView) != null && historyWebVideoView.getVisibility() == 0) {
            this.mHistoryWebVideoView.onResume();
        }
        showIncognitoModeTipBar();
    }

    public void onDestroyView() {
        super.onDestroyView();
        super.onDestroyView();
    }

    private void updateFontSize() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView != null) {
            classifyView.updateFontSize();
        }
        if (this.mEmptyDivideTemplate != null) {
            TemplateModel templateModel = new TemplateModel();
            templateModel.setFromPage("tab_his");
            this.mEmptyDivideTemplate.update(templateModel);
        }
        FavorHisBottomFloatBar favorHisBottomFloatBar = this.bottomFloatBar;
        if (favorHisBottomFloatBar != null) {
            favorHisBottomFloatBar.onFontSizeChanged();
        }
    }

    /* access modifiers changed from: private */
    public void tryShowContent() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView == null) {
            ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).refreshData(this.mLoaderManager, HistoryLoaderType.ALL_HISTORY, this, this.mLoaderParams);
            showIncognitoModeTipBar();
        } else if (classifyView.getSelectedClassifyModel() != null) {
            changeCurrentViewStatusByType(this.mClassifyView.getSelectedClassifyModel());
        }
    }

    private void initDividerDecoration() {
        this.mStickyItem = new HistorySimpleDateStickyItem(getContext(), new IDateStickyItem() {
            public long getTimeByPosition(int position) {
                HistoryList list = HistoryFragment.this.mHistoryAdapter.getData();
                if (list == null || position >= list.size()) {
                    return 0;
                }
                long createTime = list.getCreateTimeByPosition(position);
                if (createTime <= 0) {
                    return 0;
                }
                return createTime;
            }
        }, FavorHisAbTestManager.INSTANCE.getFavorHisBetterStyleSwitch());
        StickyItemDecoration stickyItemDecoration = new StickyItemDecoration(this.mHistoryAdapter, this.mStickyItem);
        this.mStickyItemDecoration = stickyItemDecoration;
        this.mRecyclerView.addItemDecoration(stickyItemDecoration);
        this.mHistoryDividerItem = new HistoryDividerItem(getContext(), true);
        DividerDecoration dividerDecoration = new DividerDecoration(getContext(), this.mHistoryDividerItem);
        this.mDividerDecoration = dividerDecoration;
        dividerDecoration.setIsHideDivider(true);
        this.mDividerDecoration.needLoadEndDivider(true);
        this.mRecyclerView.addItemDecoration(this.mDividerDecoration);
    }

    /* access modifiers changed from: private */
    public void setPageResources() {
        HistoryWebVideoView historyWebVideoView;
        ViewGroup viewGroup = this.mRootView;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(getResources().getColor(R.color.white));
        }
        HistoryAdapter historyAdapter = this.mHistoryAdapter;
        if (historyAdapter != null) {
            historyAdapter.notifyDataSetChanged();
        }
        CommonEmptyView commonEmptyView = this.mEmpty;
        if (commonEmptyView != null) {
            commonEmptyView.setIcon(R.drawable.history_empty_icon);
        }
        if (this.mEmptyDivideTemplate != null) {
            TemplateModel templateModel = new TemplateModel();
            templateModel.setFromPage("tab_his");
            this.mEmptyDivideTemplate.update(templateModel);
        }
        FavorHisBottomFloatBar favorHisBottomFloatBar = this.bottomFloatBar;
        if (favorHisBottomFloatBar != null) {
            favorHisBottomFloatBar.onNightModeChanged();
        }
        if (currentSelectedIsWebVideoType() && (historyWebVideoView = this.mHistoryWebVideoView) != null) {
            historyWebVideoView.updateUI();
        }
    }

    /* access modifiers changed from: private */
    public void clickItem(int position, HistoryModel model, String cmd, String url) {
        if (model != null) {
            if (this.mHistoryAdapter.isEditMode()) {
                this.mHistoryAdapter.toggleCheck(model);
                if (getMainContainer() != null) {
                    getMainContainer().updateAllSelectedBtnState(this.mHistoryAdapter.isAllSelected());
                    getMainContainer().updateDeleteBtnState(this.mHistoryAdapter.getSelectedIds().size() > 0, this.mHistoryAdapter.getSelectedIds().size());
                }
            } else if (!HistoryUtils.isFastClick()) {
                BookmarkUtil.openItem(getActivity(), cmd, url, "history", model.getExtra(), "", "", "", "");
                statHistoryClick(position, model);
            }
        }
    }

    /* access modifiers changed from: private */
    public void statHistoryClick(int position, HistoryModel history) {
        statHistoryUbc(position, history, "click");
        HistoryUBC.historyItemRDCEvent(history, "click", "tab_his", String.valueOf(position + 1));
    }

    private void statHistoryShow(int position, HistoryModel history) {
        statHistoryUbc(position, history, "show");
    }

    private void statHistoryUbc(int position, HistoryModel history, String ubcType) {
        String extInfo;
        if (history != null) {
            String ubcJson = "";
            String extData = history.getExtra();
            if (!TextUtils.isEmpty(extData)) {
                try {
                    ubcJson = new JSONObject(extData).optString("ubcjson");
                } catch (Exception e2) {
                }
            }
            String source = null;
            String value = null;
            if (!TextUtils.isEmpty(ubcJson)) {
                try {
                    JSONObject ubcObject = new JSONObject(ubcJson);
                    source = ubcObject.optString("source");
                    value = ubcObject.optString("value");
                    extInfo = ubcObject.optString("ext_info");
                } catch (Exception e3) {
                    extInfo = null;
                }
            } else {
                extInfo = null;
            }
            HistoryUBC.event(ubcType, value, source, "tab_his", HistoryUBC.buildUbcExt(position, history, ubcType, this.mEnterTimes, extInfo, getCurClassifyName(), ubcPageShowSource));
        }
    }

    private String getCurClassifyName() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView == null || classifyView.getSelectedClassifyModel() == null) {
            return "";
        }
        return this.mClassifyView.getSelectedClassifyModel().getTitle();
    }

    private void dismissHistoryMenu() {
        PopupWindow popupWindow = this.mHistoryPopup;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.mHistoryPopup = null;
        }
    }

    public void onStop() {
        dismissHistoryMenu();
        super.onStop();
    }

    public void onDestroy() {
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).unregisterOnDataChangeListener(this.mLoaderManager, HistoryLoaderType.ALL_HISTORY);
        QuickLoginViewHelper quickLoginViewHelper = this.mLoginViewHelper;
        if (quickLoginViewHelper != null) {
            quickLoginViewHelper.onDestroy();
        }
        HistoryGoodView historyGoodView = this.mHistoryGoodsView;
        if (historyGoodView != null) {
            historyGoodView.onDestroy();
        }
        HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
        if (historyWebVideoView != null) {
            historyWebVideoView.onDestroy();
        }
        HashSet<String> hashSet = this.mHistoryUbcRecord;
        if (hashSet != null) {
            hashSet.clear();
        }
        BdEventBus.Companion.getDefault().unregister(this);
        BoxShareManager boxShareManager = this.mShareManager;
        if (boxShareManager != null) {
            boxShareManager.clean();
        }
        super.onDestroy();
    }

    public void onDataLoadFinish(HistoryList historyList) {
        if (DEBUG) {
            Log.d(TAG, "onDataLoadFinish: ");
        }
        setLayoutManager();
        this.mHasHistoryDataLoadFinished = true;
        considerDoHistoryCountUbc();
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || historyList == null || TextUtils.equals(classifyModel.getIdentify(), historyList.getRequestType())) {
            this.mRecyclerNestedScrollView.setVisibility(0);
            if (historyList == null || historyList.size() <= 0) {
                this.mHistoryGoodsView.setVisibility(8);
                this.mHistoryWebVideoView.setVisibility(8);
                this.mHistoryAdapter.setData((HistoryList) null);
                this.mRecyclerView.setVisibility(8);
                this.mEmptyLayout.setVisibility(0);
                setEmptyViewLayout();
                this.mEmpty.setTitle(getString(R.string.search_feed_his_empty_record));
                this.mEmpty.setIcon(R.drawable.history_empty_icon);
                setEmptySubTitle();
            } else {
                this.mHistoryGoodsView.setVisibility(8);
                this.mHistoryWebVideoView.setVisibility(8);
                this.mRecyclerView.setVisibility(0);
                this.mEmptyLayout.setVisibility(8);
                boolean isAddData = false;
                HistoryAdapter historyAdapter = this.mHistoryAdapter;
                if (historyAdapter != null && (historyAdapter.getData() == null || this.mHistoryAdapter.getData().size() < historyList.size())) {
                    isAddData = true;
                }
                boolean z = isAddData;
                HistoryAdapter historyAdapter2 = this.mHistoryAdapter;
                if (historyAdapter2 != null) {
                    historyAdapter2.setCurrentTabName(getCurClassifyName());
                    this.mHistoryAdapter.setIsInAllTab(isInAllTab());
                    this.mHistoryAdapter.setData(historyList);
                }
            }
            QuickLoginViewHelper quickLoginViewHelper = this.mLoginViewHelper;
            if (quickLoginViewHelper != null) {
                quickLoginViewHelper.setNotLoginViewVisibility(8);
            }
            if (getMainContainer() != null) {
                getMainContainer().updateEditBtnState();
            }
        }
    }

    private void setLayoutManager() {
        RecyclerView recyclerView;
        LinearLayoutManager linearLayoutManager;
        GridLayoutManager gridLayoutManager;
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !TextUtils.equals(classifyModel.getIdentify(), "video") || !"2".equals(FavorHisAbTestManager.INSTANCE.getVideoType())) {
            if (!(this.mLinearLayoutManager == null || (recyclerView = this.mRecyclerView) == null || recyclerView.getLayoutManager() == (linearLayoutManager = this.mLinearLayoutManager))) {
                this.mRecyclerView.setLayoutManager(linearLayoutManager);
            }
            StickyItemDecoration stickyItemDecoration = this.mStickyItemDecoration;
            if (stickyItemDecoration != null && stickyItemDecoration.getUseGridLayout()) {
                this.mStickyItemDecoration.setUseGridLayout(false);
            }
            IStickyItem iStickyItem = this.mStickyItem;
            if (iStickyItem != null && (iStickyItem instanceof HistorySimpleDateStickyItem) && ((HistorySimpleDateStickyItem) iStickyItem).getUseGridLayout()) {
                ((HistorySimpleDateStickyItem) this.mStickyItem).setUseGridLayout(false);
                return;
            }
            return;
        }
        if (this.mGridLayoutManager == null) {
            GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
            this.mGridLayoutManager = gridLayoutManager2;
            gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                public int getSpanSize(int position) {
                    LinkedHashSet<Integer> firstDataPositionSet;
                    if (!(HistoryFragment.this.mHistoryAdapter == null || HistoryFragment.this.mHistoryAdapter.getData() == null)) {
                        if (HistoryFragment.this.mHistoryAdapter.getData().size() == position && HistoryFragment.this.mHistoryAdapter.isBottomFloatBarShow()) {
                            return 3;
                        }
                        if (HistoryFragment.this.mHistoryAdapter.getData().size() > position + 1 && (firstDataPositionSet = HistoryFragment.this.mHistoryAdapter.mFirstDataPositionOfDaySet) != null && !firstDataPositionSet.isEmpty() && firstDataPositionSet.contains(Integer.valueOf(position + 1))) {
                            int firstPosOfThisDay = 0;
                            Iterator it = firstDataPositionSet.iterator();
                            while (it.hasNext()) {
                                Integer pos = (Integer) it.next();
                                if (pos.intValue() == position + 1) {
                                    break;
                                }
                                firstPosOfThisDay = pos.intValue();
                            }
                            int gridSpanIndex = ((position - firstPosOfThisDay) + 1) % 3;
                            if (gridSpanIndex == 1) {
                                return 3;
                            }
                            if (gridSpanIndex == 2) {
                                return 2;
                            }
                        }
                    }
                    return 1;
                }
            });
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (!(recyclerView2 == null || recyclerView2.getLayoutManager() == (gridLayoutManager = this.mGridLayoutManager))) {
            this.mRecyclerView.setLayoutManager(gridLayoutManager);
        }
        StickyItemDecoration stickyItemDecoration2 = this.mStickyItemDecoration;
        if (stickyItemDecoration2 != null && !stickyItemDecoration2.getUseGridLayout()) {
            this.mStickyItemDecoration.setUseGridLayout(true);
        }
        IStickyItem iStickyItem2 = this.mStickyItem;
        if (iStickyItem2 != null && (iStickyItem2 instanceof HistorySimpleDateStickyItem) && !((HistorySimpleDateStickyItem) iStickyItem2).getUseGridLayout()) {
            ((HistorySimpleDateStickyItem) this.mStickyItem).setUseGridLayout(true);
        }
    }

    public void setEditMode(boolean isEdit) {
        this.mIsEditable = isEdit;
        showIncognitoModeTipBar();
        if (currentSelectedIsProductType()) {
            HistoryGoodView historyGoodView = this.mHistoryGoodsView;
            if (historyGoodView != null && historyGoodView.getVisibility() == 0) {
                this.mHistoryGoodsView.setEditMode(isEdit);
            }
        } else if (currentSelectedIsWebVideoType()) {
            HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
            if (historyWebVideoView != null && historyWebVideoView.getVisibility() == 0) {
                this.mHistoryWebVideoView.setEditMode(isEdit);
            }
        } else {
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            if (historyAdapter != null) {
                historyAdapter.setEditMode(isEdit);
            }
            DividerDecoration dividerDecoration = this.mDividerDecoration;
            if (dividerDecoration != null) {
                dividerDecoration.needLoadEndDivider(!isEdit);
            }
        }
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView != null) {
            classifyView.setVisibility(isEdit ? 8 : 0);
        }
    }

    public void onSelectAll(boolean isSelectedAll) {
        if (currentSelectedIsProductType()) {
            HistoryGoodView historyGoodView = this.mHistoryGoodsView;
            if (historyGoodView != null && historyGoodView.getVisibility() == 0) {
                this.mHistoryGoodsView.onSelectAll(isSelectedAll);
            }
        } else if (currentSelectedIsWebVideoType()) {
            HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
            if (historyWebVideoView != null && historyWebVideoView.getVisibility() == 0) {
                this.mHistoryWebVideoView.onSelectAll(isSelectedAll);
            }
        } else if (this.mHistoryAdapter != null && getMainContainer() != null) {
            this.mHistoryAdapter.onSelectAll(isSelectedAll);
            boolean z = false;
            if (!isEditEnable()) {
                getMainContainer().updateDeleteBtnState(false, 0);
                return;
            }
            IUserAssetsContainer mainContainer = getMainContainer();
            if (this.mHistoryAdapter.getSelectedIds().size() > 0) {
                z = true;
            }
            mainContainer.updateDeleteBtnState(z, this.mHistoryAdapter.getSelectedIds().size());
        }
    }

    public void onMoveClicked() {
    }

    public void onRenameClicked() {
    }

    public void onDeletedClicked() {
        if (currentSelectedIsProductType()) {
            HistoryGoodView historyGoodView = this.mHistoryGoodsView;
            if (historyGoodView != null && historyGoodView.getVisibility() == 0) {
                this.mHistoryGoodsView.onDeletedClicked();
            }
        } else if (currentSelectedIsWebVideoType()) {
            HistoryWebVideoView historyWebVideoView = this.mHistoryWebVideoView;
            if (historyWebVideoView != null && historyWebVideoView.getVisibility() == 0) {
                this.mHistoryWebVideoView.onDeletedClicked();
            }
        } else {
            showSelectedDeleteDialog();
        }
    }

    private void showSelectedDeleteDialog() {
        HistoryAdapter historyAdapter = this.mHistoryAdapter;
        if (historyAdapter != null) {
            int count = historyAdapter.getSelectedIds().size();
            Activity activity = getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && isAdded()) {
                new DeleteDialogWithRecycleBin(activity).showDialog("tab_his", this.mHistoryAdapter.isEditMode(), getString(R.string.user_assets_history_delete_part_message, Integer.valueOf(count)), new IDeleteDialogWithRecycleCallback() {
                    public void onCancelClicked() {
                        HistoryUBC.event("click", "cancel", "delete_btn", "tab_his");
                    }

                    public void onDeleteClicked(boolean isSelectedRecycle) {
                        if (HistoryFragment.this.mBdProgressDialog != null && HistoryFragment.this.getActivity() != null && !HistoryFragment.this.getActivity().isFinishing() && !HistoryFragment.this.getActivity().isDestroyed()) {
                            HistoryFragment.this.mBdProgressDialog.show();
                        }
                        Set<String> uKeyList = HistoryFragment.this.mHistoryAdapter.getSelectedIds();
                        if (isSelectedRecycle) {
                            IRecycleBinFace recycleBinFace = (IRecycleBinFace) ServiceManager.getService(IRecycleBinFace.Companion.getSERVICE_REFERENCE());
                            if (recycleBinFace != null) {
                                recycleBinFace.recordHasAddedRecycleBin();
                            }
                            new HistoryRecycleBinManager().moveHistoriesToRecycleBin(new ArrayList(uKeyList), new HistoryDataCallback<Boolean>() {
                                public void onResult(Boolean data) {
                                    if (HistoryFragment.this.mBdProgressDialog != null && HistoryFragment.this.mBdProgressDialog.isShowing()) {
                                        HistoryFragment.this.mBdProgressDialog.dismiss();
                                    }
                                    if (HistoryFragment.this.getMainContainer() != null) {
                                        HistoryFragment.this.getMainContainer().endEditMode();
                                    }
                                    HistoryFragment.this.showDeleteResultToast(data);
                                }
                            });
                            if (HistoryFragment.this.getMainContainer() != null) {
                                HistoryFragment.this.getMainContainer().tryShowNewTips();
                            }
                        } else {
                            ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).deleteHistories((String[]) uKeyList.toArray(new String[0]), new HistoryDataCallback<Boolean>() {
                                public void onResult(Boolean data) {
                                    if (HistoryFragment.this.mBdProgressDialog != null && HistoryFragment.this.mBdProgressDialog.isShowing()) {
                                        HistoryFragment.this.mBdProgressDialog.dismiss();
                                    }
                                    if (HistoryFragment.this.getMainContainer() != null) {
                                        HistoryFragment.this.getMainContainer().endEditMode();
                                    }
                                    HistoryFragment.this.showDeleteResultToast(data);
                                }
                            });
                        }
                        HistoryUBC.event("click", "confirm", "delete_btn", "tab_his");
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void showDeleteResultToast(Boolean isDeleteSuccess) {
        String toastMessage;
        try {
            Activity activity = getActivity();
            if (activity != null && !ActivityUtils.isDestroyed(activity) && isAdded()) {
                if (isDeleteSuccess.booleanValue()) {
                    toastMessage = activity.getString(R.string.user_assets_history_delete_result_success);
                } else {
                    toastMessage = activity.getString(R.string.user_assets_history_delete_result_failed);
                }
                UniversalToast.makeText((Context) activity, (CharSequence) toastMessage).show();
            }
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    public int getCountExceptSection() {
        HistoryWebVideoView historyWebVideoView;
        HistoryGoodView historyGoodView;
        if (currentSelectedIsProductType() && (historyGoodView = this.mHistoryGoodsView) != null && historyGoodView.getVisibility() == 0) {
            return this.mHistoryGoodsView.getCountExceptSection();
        }
        if (currentSelectedIsWebVideoType() && (historyWebVideoView = this.mHistoryWebVideoView) != null && historyWebVideoView.getVisibility() == 0) {
            return this.mHistoryWebVideoView.getCountExceptSection();
        }
        HistoryAdapter historyAdapter = this.mHistoryAdapter;
        if (historyAdapter != null) {
            return historyAdapter.getItemCountWithoutBiSerial();
        }
        return 0;
    }

    public boolean checkMoveBtnEnableState() {
        return false;
    }

    public boolean checkRenameBtnEnableState() {
        return false;
    }

    public boolean invokeLoginOnCreate(Context context) {
        if (!UserAssetsSharedPrefs.INSTANCE.getBoolean(UserAssetsCommandListenerKt.KEY_HISTORY_LOGIN_SWITCH, false) || ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2)) {
            return false;
        }
        QuickLoginViewHelper.gotoBDLogin(context, "personal_history_enter", (ILoginResultListener) null);
        return true;
    }

    public void onFragmentSeleted() {
        ViewGroup viewGroup;
        if (this.isHistoryLoginCancel && (viewGroup = this.mRootView) != null) {
            HistoryUtils.hideInputMethod(viewGroup);
        }
        BoxAccountManager loginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (loginManager != null && !loginManager.isLogin(2)) {
            AccountQuickLoginEvent event = new AccountQuickLoginEvent();
            event.setEventType(1);
            event.putParam("source", "personal_history_active");
            BdEventBus.Companion.getDefault().post(event);
        }
    }

    public void onPause() {
        ClassifyView classifyView;
        super.onPause();
        UserAssetsAggrUbc.sHasReportUbcItem.clear();
        BookmarkUBC.sHasReportUbcFavorItem.clear();
        if (this.mIsVisibleToUser && (classifyView = this.mClassifyView) != null) {
            classifyView.endUbcFlow();
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mIsVisibleToUser = isVisibleToUser;
        if (isVisibleToUser) {
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            if (historyAdapter != null) {
                historyAdapter.notifyDataSetChanged();
            }
            recordHistoryEnterTimes();
            considerDoHistoryCountUbc();
            ClassifyView classifyView = this.mClassifyView;
            if (classifyView != null) {
                this.mClassifyView.doTabShowUbc();
                classifyView.beginUbcFlow();
            }
            showIncognitoModeTipBar();
            return;
        }
        ClassifyView classifyView2 = this.mClassifyView;
        if (classifyView2 != null) {
            classifyView2.endUbcFlow();
        }
    }

    public void onVPMoving(int state) {
    }

    private boolean currentSelectedIsProductType() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !"product".equals(classifyModel.getIdentify())) {
            return false;
        }
        return true;
    }

    private boolean currentSelectedIsWebVideoType() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !"search_web_video".equals(classifyModel.getIdentify())) {
            return false;
        }
        return true;
    }

    public void setEmptyViewLayout() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView != null) {
            classifyView.post(new Runnable() {
                public void run() {
                    ViewGroup.LayoutParams lp;
                    if (HistoryFragment.this.mRootView != null && HistoryFragment.this.mEmpty != null) {
                        if (HistoryFragment.this.getContext() != null && HistoryFragment.this.mEmptyDivideTemplate == null && HistoryFragment.this.mEmpty.mBottomLayout.getChildCount() == 0) {
                            ITemplate unused = HistoryFragment.this.mEmptyDivideTemplate = TemplateCreatorKt.createTemplate(TemplateEnum.BISERIAL_DIVIDE);
                            View emptyDivideView = HistoryFragment.this.mEmptyDivideTemplate.createView(HistoryFragment.this.mEmpty.mBottomLayout);
                            emptyDivideView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                            View emptyDivideRootView = emptyDivideView.findViewById(R.id.divide_root_view);
                            if (emptyDivideRootView != null) {
                                emptyDivideRootView.setPadding(emptyDivideRootView.getPaddingLeft(), emptyDivideRootView.getPaddingTop(), emptyDivideRootView.getPaddingRight(), 0);
                            }
                            HistoryFragment.this.mEmpty.mBottomLayout.addView(emptyDivideView);
                            ViewGroup.LayoutParams bottomLayoutParams = HistoryFragment.this.mEmpty.mBottomLayout.getLayoutParams();
                            if (bottomLayoutParams != null) {
                                bottomLayoutParams.width = -1;
                                HistoryFragment.this.mEmpty.mBottomLayout.setLayoutParams(bottomLayoutParams);
                            }
                            HistoryFragment.this.mEmpty.mBottomLayout.setClickable(false);
                        }
                        if (HistoryFragment.this.mRootView.findViewById(R.id.history_app_bar_layout) != null && (lp = HistoryFragment.this.mEmpty.getLayoutParams()) != null && (lp instanceof FrameLayout.LayoutParams) && HistoryFragment.this.isAdded()) {
                            try {
                                ((FrameLayout.LayoutParams) lp).topMargin = 0;
                                if (HistoryFragment.this.mEmptyDivideTemplate != null) {
                                    HistoryFragment.this.mEmpty.mBottomLayout.setVisibility(8);
                                }
                                HistoryFragment.this.mEmpty.setLayoutParams(lp);
                            } catch (Throwable e2) {
                                if (AppConfig.isDebug()) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    private void setEmptySubTitle() {
        if (this.mEmpty != null) {
            if (!IHistoryApp.Impl.get().getFeedHistory()) {
                this.mEmpty.setSubTitle(R.string.search_history_feed_empty_sub_title);
            } else {
                this.mEmpty.setSubTitle("");
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFavorHisFragment() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isEditEnable() {
        if (!currentSelectedIsProductType() && !currentSelectedIsWebVideoType()) {
            HistoryAdapter historyAdapter = this.mHistoryAdapter;
            return (historyAdapter == null || historyAdapter.getData() == null || this.mHistoryAdapter.getData().size() <= 0) ? false : true;
        } else if (getCountExceptSection() > 0) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean canShowBackToTop() {
        return isFloatBackBottomBar();
    }

    public void onHistoryItemShowed(int position, HistoryModel historyModel) {
        String ubcRecordId = "";
        if (historyModel != null) {
            ubcRecordId = historyModel.getUkey();
        }
        if (this.mIsVisibleToUser && this.mHistoryUbcRecord != null && !TextUtils.isEmpty(ubcRecordId) && !this.mHistoryUbcRecord.contains(ubcRecordId)) {
            this.mHistoryUbcRecord.add(ubcRecordId);
            statHistoryShow(position, historyModel);
        }
    }

    private void recordHistoryEnterTimes() {
        if (!this.mHasRecordHistoryEnterTimes) {
            this.mHasRecordHistoryEnterTimes = true;
            long currentMillis = System.currentTimeMillis();
            long lastEnterMillis = DefaultSharedPrefsWrapper.getInstance().getLong(HISTORY_ENTER_MILLIS_SP_KEY, currentMillis);
            this.mEnterTimes = DefaultSharedPrefsWrapper.getInstance().getInt(HISTORY_ENTER_TIMES_SP_KEY, 0);
            if (currentMillis - lastEnterMillis > HistoryUBC.DAY_MILLIS.longValue()) {
                this.mEnterTimes = 1;
            } else {
                this.mEnterTimes++;
            }
            DefaultSharedPrefsWrapper.getInstance().putInt(HISTORY_ENTER_TIMES_SP_KEY, this.mEnterTimes);
            DefaultSharedPrefsWrapper.getInstance().putLong(HISTORY_ENTER_MILLIS_SP_KEY, currentMillis);
        }
    }

    private void considerDoHistoryCountUbc() {
        if (!this.mHasDoHistoryCountUbc && this.mIsVisibleToUser && this.mHasHistoryDataLoadFinished) {
            this.mHasDoHistoryCountUbc = true;
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    long timeNow = System.currentTimeMillis();
                    int countTotal = HistoryFragment.this.queryHistoryCountByCreateTime((Long) null);
                    int countOutOfThirty = HistoryFragment.this.queryHistoryCountByCreateTime(Long.valueOf(timeNow - (HistoryUBC.DAY_MILLIS.longValue() * 30)));
                    int countOutOfSixty = HistoryFragment.this.queryHistoryCountByCreateTime(Long.valueOf(timeNow - (HistoryUBC.DAY_MILLIS.longValue() * 60)));
                    int countOutOfNinety = HistoryFragment.this.queryHistoryCountByCreateTime(Long.valueOf(timeNow - (HistoryUBC.DAY_MILLIS.longValue() * 90)));
                    JSONObject ubcExtJsonObject = new JSONObject();
                    try {
                        ubcExtJsonObject.putOpt(HistoryUBC.EXT_KEY_NUMBER_TOTAL, Integer.valueOf(countTotal));
                        ubcExtJsonObject.putOpt(HistoryUBC.EXT_KEY_NUMBER_THIRTY, Integer.valueOf(countOutOfThirty));
                        ubcExtJsonObject.putOpt(HistoryUBC.EXT_KEY_NUMBER_SIXTY, Integer.valueOf(countOutOfSixty));
                        ubcExtJsonObject.putOpt(HistoryUBC.EXT_KEY_NUMBER_NINETY, Integer.valueOf(countOutOfNinety));
                        String value = "0";
                        if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2)) {
                            value = "1";
                        }
                        HistoryUBC.event("number", value, (String) null, "tab_his", ubcExtJsonObject.toString());
                    } catch (JSONException e2) {
                        if (AppConfig.isDebug()) {
                            e2.printStackTrace();
                        }
                    }
                }
            }, "queryHistoryCountByCreateTime", 0);
        }
    }

    /* access modifiers changed from: private */
    public int queryHistoryCountByCreateTime(Long createTimeLimit) {
        String selection;
        Cursor cursor = null;
        try {
            Uri uriHistoryAll = UriHelper.getHistoryAll();
            ContentResolver resolver = AppRuntime.getAppContext().getContentResolver();
            if (createTimeLimit != null) {
                selection = HistoryTable.createtime.name() + " < " + String.valueOf(createTimeLimit);
            } else {
                selection = null;
            }
            String name = HistoryTable.createtime.name();
            cursor = resolver.query(uriHistoryAll, (String[]) null, selection, (String[]) null, (String) null);
            return cursor.getCount();
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return 0;
        } finally {
            Closeables.closeSafely(cursor);
        }
    }

    private boolean isInAllTab() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView == null || classifyView.getSelectedClassifyModel() == null) {
            return false;
        }
        String currentIdentify = this.mClassifyView.getSelectedClassifyModel().getIdentify();
        if (TextUtils.isEmpty(currentIdentify) || !TextUtils.equals(currentIdentify, "all")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void addVisitHisCount(String uKey) {
        if (!TextUtils.isEmpty(uKey)) {
            ((IHistoryManager) ServiceManager.getService(IHistoryManager.SERVICE_REFERENCE)).getHistoryUserAction().updateVisitCountAsync(uKey, (HistoryDataCallback<Boolean>) null);
        }
    }
}
