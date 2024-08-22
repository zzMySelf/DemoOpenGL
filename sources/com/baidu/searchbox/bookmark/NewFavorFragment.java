package com.baidu.searchbox.bookmark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.ILoginResultListener;
import com.baidu.searchbox.account.event.AccountQuickLoginEvent;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinFace;
import com.baidu.searchbox.bookmark.FavorsMoveToDirDialogFragment;
import com.baidu.searchbox.bookmark.adapter.NewFavorAdapter;
import com.baidu.searchbox.bookmark.adapter.OnFavorItemClickListener;
import com.baidu.searchbox.bookmark.favor.BookmarkDirEditActivity;
import com.baidu.searchbox.bookmark.favor.FavorController;
import com.baidu.searchbox.bookmark.favor.FavorInterface;
import com.baidu.searchbox.bookmark.favor.FavorsSelectDirsActivity;
import com.baidu.searchbox.bookmark.favor.TouchListener;
import com.baidu.searchbox.bookmark.favor.good.FavorGoodsView;
import com.baidu.searchbox.bookmark.favor.playlet.FavorPlayletUbcListener;
import com.baidu.searchbox.bookmark.favor.playlet.FavorPlayletView;
import com.baidu.searchbox.bookmark.favor.playlet.sp.FavorCenterPlayletHelper;
import com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoUbcListener;
import com.baidu.searchbox.bookmark.favor.webvideo.NewFavorWebVideoView;
import com.baidu.searchbox.bookmark.search.FavorDividerItem;
import com.baidu.searchbox.boxshare.BoxShareManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.favor.IFavorList;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.R;
import com.baidu.searchbox.favor.callback.FavorDataCallback;
import com.baidu.searchbox.favor.data.FavorListLoaderParams;
import com.baidu.searchbox.favor.data.FavorListLoaderType;
import com.baidu.searchbox.favor.data.FavorListResult;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favor.data.MoviesModel;
import com.baidu.searchbox.favor.data.QueryType;
import com.baidu.searchbox.favor.data.RefreshLoaderParams;
import com.baidu.searchbox.favor.i.IFavorUserAction;
import com.baidu.searchbox.favor.sync.business.favor.ubc.FavorSyncUBC;
import com.baidu.searchbox.favor.util.FavorList;
import com.baidu.searchbox.introduction.model.FavorIntroductionUtils;
import com.baidu.searchbox.search.pyramid.SearchH5TransInterface;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.statistic.FavorStatisticUtilsKt;
import com.baidu.searchbox.statistic.RevisitStatisticUtil;
import com.baidu.searchbox.uar.FavorHisUARScrollListener;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.searchbox.userassetsaggr.container.AbsListFragment;
import com.baidu.searchbox.userassetsaggr.container.AbsListFragmentKt;
import com.baidu.searchbox.userassetsaggr.container.FavorHisAbTestManager;
import com.baidu.searchbox.userassetsaggr.container.ILoginController;
import com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer;
import com.baidu.searchbox.userassetsaggr.container.QuickLoginViewHelper;
import com.baidu.searchbox.userassetsaggr.container.TitleTypeKt;
import com.baidu.searchbox.userassetsaggr.container.UserAssetRouteUtilKt;
import com.baidu.searchbox.userassetsaggr.container.UserAssetsAggrUtils;
import com.baidu.searchbox.userassetsaggr.container.UserAssetsRecyclerView;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyDataManager;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyViewPage;
import com.baidu.searchbox.userassetsaggr.container.data.FavorHisIncognitoManagerKt;
import com.baidu.searchbox.userassetsaggr.container.data.FavorSyncEvent;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsCommandListenerKt;
import com.baidu.searchbox.userassetsaggr.container.data.UserAssetsSharedPrefs;
import com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration;
import com.baidu.searchbox.userassetsaggr.container.film.FavorHisWebFilmInfoManager;
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
import com.baidu.searchbox.userassetsaggr.container.ui.FavorHisBottomMenu;
import com.baidu.searchbox.userassetsaggr.container.ui.LoginBarContainer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

public class NewFavorFragment extends AbsListFragment implements FavorInterface.View<FavorController>, TouchListener, FavorsMoveToDirDialogFragment.FavorsChooseDirCallBack, ILoginController {
    public static final int BOOKMARKS_SAVE = 1;
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "FavorFragment";
    public static final String UBC_DELETE = "delete";
    public static final String UBC_EDIT = "edit";
    public static final String UBC_FAVORITECLK = "favoriteClk";
    private static String ubcPageShowSource = "from_other";
    /* access modifiers changed from: private */
    public ClassifyModel currentClassifyModel;
    private String defaultClassifyId;
    private boolean isFirstFetchDataCallBack = true;
    /* access modifiers changed from: private */
    public ViewGroup mBookmarkView = null;
    /* access modifiers changed from: private */
    public ClassifyView mClassifyView;
    private View mContentView = null;
    /* access modifiers changed from: private */
    public FavorController mController;
    private FavorModel mCurrentFavorData;
    private DividerDecoration mDividerDecoration;
    private FavorDividerItem mDividerItem;
    /* access modifiers changed from: private */
    public ITemplate mEmptyDivideTemplate;
    /* access modifiers changed from: private */
    public NestedScrollView mEmptyLayout;
    /* access modifiers changed from: private */
    public CommonEmptyView mEmptyView;
    /* access modifiers changed from: private */
    public NewFavorAdapter mFavorAdapter;
    /* access modifiers changed from: private */
    public FavorGoodsView mFavorGoodsView = null;
    /* access modifiers changed from: private */
    public FavorPlayletView mFavorPlayletView = null;
    /* access modifiers changed from: private */
    public NewFavorWebVideoView mFavorWebVideoView = null;
    private GridLayoutManager mGridLayoutManager = null;
    private boolean mIsEditable;
    private boolean mIsFirstOnResume = true;
    /* access modifiers changed from: private */
    public boolean mIsLoading = false;
    private OnFavorItemClickListener mItemClickListener = new OnFavorItemClickListener() {
        public void onItemClick(int position, FavorModel model) {
            if (NewFavorFragment.this.mFavorAdapter != null && model != null) {
                int realPosition = position;
                if (NewFavorFragment.this.mFavorAdapter != null) {
                    realPosition -= NewFavorFragment.this.mFavorAdapter.getDirCount();
                }
                NewFavorFragment.this.openFavor(realPosition, model);
            }
        }

        public void onDynamicHeadClick(FavorModel model) {
            if (model != null) {
                if (model.feature == null) {
                    BookmarkUtil.openItem(NewFavorFragment.this.getActivity(), model.cmd, model.url, "favourate", model.getExtData(), "", "", "", "");
                    return;
                }
                String query = "";
                MoviesModel moviesModel = model.feature.moviesModel;
                if (moviesModel != null && !TextUtils.isEmpty(moviesModel.getPreQueryWord())) {
                    query = moviesModel.getPreQueryWord();
                }
                BookmarkUtil.openItem(NewFavorFragment.this.getActivity(), model.feature.usercmd, model.url, "favourate", model.getExtData(), query, model.title, UserAssetsAggrUbc.WEB_FILM_SA_VALUE, TitleTypeKt.getTitleTypeForFavorModel(model));
            }
        }

        public void onItemLongClick(FavorModel model, TemplateModel templateModel, View v, int position) {
            if (NewFavorFragment.this.mFavorAdapter != null && model != null && templateModel != null && v != null && NewFavorFragment.this.getActivity() != null && !NewFavorFragment.this.mFavorAdapter.isEditable()) {
                NewFavorFragment.this.mFavorAdapter.clearSelectIds();
                FavorHisBottomMenu menu = new FavorHisBottomMenu(NewFavorFragment.this.getActivity(), v);
                menu.setOnCommonMenuDisplayListener(new NewFavorFragment$1$$ExternalSyntheticLambda0(menu, model));
                menu.setOnItemClickListener(new NewFavorFragment$1$$ExternalSyntheticLambda1(this, model, templateModel, position, menu));
                TemplateEnum type = TemplateEnumKt.valueOf(NewFavorFragment.this.mFavorAdapter.getItemViewType(position));
                if (type == TemplateEnum.DEFAULT_FOLDER) {
                    menu.showFavorDirMenu(templateModel.getTitle());
                } else if (type == TemplateEnum.COMMON_AD || type == TemplateEnum.FEED_AD) {
                    menu.showAdvertMenu(templateModel.getTitle(), true, NewFavorFragment.this.classifySelectAll(), templateModel.isShowFeedback(), templateModel.isShowServiceRate());
                } else {
                    String source = templateModel.getBottomDialogShowSource();
                    if ((type == TemplateEnum.WEB_FILM || type == TemplateEnum.SEARCH_TEXT || type == TemplateEnum.COMMON_WEB) && FavorHisAbTestManager.INSTANCE.getMoviesAb()) {
                        if (templateModel.getFavorMoviesModel() != null) {
                            String website = templateModel.getFavorMoviesModel().getWebsite();
                            if (TextUtils.isEmpty(website)) {
                                website = UserAssetsAggrUtils.getHttpHostUrl(templateModel.getUrl());
                            }
                            source = website;
                        }
                        if (TextUtils.isEmpty(source)) {
                            source = templateModel.getBottomDialogShowSource();
                        }
                    }
                    menu.showFavorMenu(templateModel.getTitle(), source, NewFavorFragment.this.classifySelectAll());
                }
            }
        }

        static /* synthetic */ void lambda$onItemLongClick$0(FavorHisBottomMenu menu, FavorModel model, CommonMenu menu1, boolean isShown) {
            if (isShown) {
                menu.ubcShowEvent("tab_fav", BookmarkUBC.getMenuUbcExtStr(model));
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onItemLongClick$1$com-baidu-searchbox-bookmark-NewFavorFragment$1  reason: not valid java name */
        public /* synthetic */ boolean m16615lambda$onItemLongClick$1$combaidusearchboxbookmarkNewFavorFragment$1(FavorModel model, TemplateModel templateModel, int position, FavorHisBottomMenu menu, View v1, CommonMenuItem item) {
            NewFavorFragment.this.handleMenuClick(item, model, templateModel, position);
            if (item != null) {
                menu.ubcClickEvent(item.getItemId(), "tab_fav", BookmarkUBC.getMenuUbcExtStr(model));
            }
            menu.dismiss(false);
            return false;
        }
    };
    private LinearLayoutManager mLayoutManager = null;
    private LoginBarContainer mLoginContainer;
    private QuickLoginViewHelper mLoginViewHelper;
    /* access modifiers changed from: private */
    public UserAssetsRecyclerView mRecyclerView = null;
    private BoxShareManager mShareManager;
    /* access modifiers changed from: private */
    public View mShimmerLayout = null;
    /* access modifiers changed from: private */
    public BdShimmerView mShimmerView = null;
    private int mTopPadding = AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.basicfun_favor_login_container_height);
    private boolean mVisibleToUser;
    private boolean resumeFromSelectDirPage = false;

    /* access modifiers changed from: private */
    public void handleMenuClick(CommonMenuItem menuItem, FavorModel model, TemplateModel templateModel, int position) {
        FavorModel favorModel = model;
        if (this.mFavorAdapter != null && menuItem != null && favorModel != null && templateModel != null) {
            if (menuItem.getItemId() == 1) {
                FavorHisIncognitoManagerKt.openIncognitoMode(getContext(), true);
                openFavor(getUbcIndex(position - this.mFavorAdapter.getDirCount()), favorModel);
            } else if (this.mFavorAdapter.toggleCheck(favorModel)) {
                switch (menuItem.getItemId()) {
                    case 0:
                        onDeletedClicked();
                        return;
                    case 2:
                        onRenameClicked();
                        return;
                    case 3:
                        onMoveClicked();
                        return;
                    case 4:
                        if (getMainContainer() != null) {
                            getMainContainer().enterEditMode();
                            openFavor(-1, favorModel);
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
                        if (!ClassifyDataManager.INSTANCE.isCollectionClassify(favorModel.tplId) && !ClassifyDataManager.INSTANCE.isPlayletClassify(favorModel.tplId)) {
                            source = templateModel.getSource();
                        } else if (favorModel.feature != null) {
                            source = favorModel.feature.username;
                        }
                        this.mShareManager = ShareUtil.shareUrl(getActivity(), new ShareModel(ClassifyViewPage.PAGE_FAVOR, favorModel.tplId, favorModel.title, source, favorModel.url, favorModel.img, "tab_fav", favorModel.uKey));
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public NewFavorFragment() {
        AbsListFragmentKt.setLoginController(this, this);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((SearchH5TransInterface) ServiceManager.getService(SearchH5TransInterface.Companion.getReference())).initVideoTransWriteList();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                if (NewFavorFragment.this.getContext() != null) {
                    NewFavorFragment.this.setPageResources();
                }
            }
        });
        if (DEBUG) {
            Log.d(TAG, "——> onCreate: ");
        }
        this.mController = new FavorController(this, getLoaderManager());
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey("source")) {
                ubcPageShowSource = bundle.getString("source");
            }
            if (bundle.containsKey("classify_id")) {
                this.defaultClassifyId = bundle.getString("classify_id");
            }
        }
        registerEventBus();
    }

    private void registerEventBus() {
        BdEventBus.Companion.getDefault().lazyRegister(this, FavorModel.class, 1, new Action<FavorModel>() {
            public void call(FavorModel favorModel) {
                NewFavorFragment.this.updateItemSelectedStatus(favorModel);
                if (NewFavorFragment.this.getMainContainer() != null) {
                    NewFavorFragment.this.getMainContainer().endEditMode();
                }
            }
        });
        BdEventBus.Companion.getDefault().lazyRegister(this, FavorSyncEvent.class, 1, new Action<FavorSyncEvent>() {
            public void call(FavorSyncEvent favorModel) {
                ClassifyModel selectedClassifyModel = NewFavorFragment.this.mClassifyView.getSelectedClassifyModel();
                if (selectedClassifyModel != null) {
                    NewFavorFragment.this.changeCurrentViewStatusByType(selectedClassifyModel, false);
                } else if (NewFavorFragment.this.mController != null) {
                    NewFavorFragment.this.mController.restartLoader();
                }
            }
        });
    }

    private void unRegisterEventBus() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void updateItemSelectedStatus(FavorModel favorModel) {
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null) {
            newFavorAdapter.updateEditItemState(favorModel);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.new_favor_fragment_layout_new, container, false);
        this.mBookmarkView = viewGroup;
        this.mContentView = viewGroup.findViewById(R.id.favor_content_view);
        View findViewById = this.mBookmarkView.findViewById(R.id.shimmerLayout);
        this.mShimmerLayout = findViewById;
        findViewById.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
        this.mShimmerView = (BdShimmerView) this.mBookmarkView.findViewById(R.id.shimmerView);
        if (NightModeHelper.isNightMode()) {
            this.mShimmerView.setType(0);
        } else {
            this.mShimmerView.setType(1);
        }
        this.mShimmerView.startShimmerAnimation();
        UserAssetsRecyclerView userAssetsRecyclerView = (UserAssetsRecyclerView) this.mBookmarkView.findViewById(R.id.recycler_view);
        this.mRecyclerView = userAssetsRecyclerView;
        userAssetsRecyclerView.addOnScrollListener(new FavorHisUARScrollListener());
        this.mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == 0) {
                    if (AppConfig.isDebug()) {
                        Log.d("FavorloadData", "tryLoadNextPage start");
                    }
                    NewFavorFragment.this.tryLoadNextPage(recyclerView);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        this.mFavorGoodsView = (FavorGoodsView) this.mBookmarkView.findViewById(R.id.favor_goods_view);
        this.mFavorWebVideoView = (NewFavorWebVideoView) this.mBookmarkView.findViewById(R.id.favor_web_video_view);
        this.mFavorPlayletView = (FavorPlayletView) this.mBookmarkView.findViewById(R.id.favor_playlet_view);
        this.mFavorWebVideoView.setWebVideoUbcListener(new FavorWebVideoUbcListener() {
            public void onUbcClick(int position, FavorModel model) {
                NewFavorFragment.this.statFavorClick(position, model);
            }
        });
        this.mFavorPlayletView.setFavorPlayletUbcListener(new FavorPlayletUbcListener() {
            public void onUbcClick(int position, FavorModel favor) {
                NewFavorFragment.this.statFavorClick(position, favor);
            }
        });
        this.mClassifyView = (ClassifyView) this.mBookmarkView.findViewById(R.id.favor_classify_view);
        FavorCustomLinearLayoutManager favorCustomLinearLayoutManager = new FavorCustomLinearLayoutManager(getContext());
        this.mLayoutManager = favorCustomLinearLayoutManager;
        this.mRecyclerView.setLayoutManager(favorCustomLinearLayoutManager);
        NewFavorAdapter newFavorAdapter = new NewFavorAdapter(getActivity(), this, this.mItemClickListener, false);
        this.mFavorAdapter = newFavorAdapter;
        this.mRecyclerView.setAdapter(newFavorAdapter);
        this.mDividerItem = new FavorDividerItem(getContext(), true);
        DividerDecoration dividerDecoration = new DividerDecoration(getContext(), this.mDividerItem);
        this.mDividerDecoration = dividerDecoration;
        dividerDecoration.setIsHideDivider(true);
        this.mDividerDecoration.needLoadEndDivider(true);
        this.mRecyclerView.addItemDecoration(this.mDividerDecoration);
        if (getMainContainer() != null) {
            getMainContainer().updateEditBtnState();
        }
        this.mEmptyLayout = (NestedScrollView) this.mBookmarkView.findViewById(R.id.bookmark_empty_layout);
        this.mEmptyView = (CommonEmptyView) this.mBookmarkView.findViewById(R.id.bookmark_empty_view);
        this.mLoginContainer = (LoginBarContainer) this.mBookmarkView.findViewById(R.id.favor_login_view);
        setLoginBarTips();
        this.mLoginContainer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                QuickLoginViewHelper.gotoBDLogin(NewFavorFragment.this.getContext(), BookmarkUBC.FAVOR_SOURCE_CLICK_NOT_LOGIN, (ILoginResultListener) null);
                BookmarkUBC.favorLoginEvent("tab_fav", "tips");
            }
        });
        if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2)) {
            this.mController.asyncGetFavorData();
        }
        setPageResources();
        initClassifyView();
        return this.mBookmarkView;
    }

    /* access modifiers changed from: private */
    public void tryLoadNextPage(final RecyclerView recyclerView) {
        UiThreadUtils.getMainHandler().post(new Runnable() {
            public void run() {
                if (NewFavorFragment.this.currentSelectedTabIsRecyclerView()) {
                    LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (layoutManager == null) {
                        if (NewFavorFragment.this.mShimmerLayout.getVisibility() == 0) {
                            NewFavorFragment.this.mShimmerView.stopShimmerAnimation();
                            NewFavorFragment.this.mShimmerLayout.setVisibility(8);
                            NewFavorFragment.this.mShimmerView.setVisibility(8);
                        }
                    } else if (layoutManager.findLastVisibleItemPosition() == layoutManager.getItemCount() - 1 && NewFavorFragment.this.mRecyclerView.getHasNextPage() && !NewFavorFragment.this.mIsLoading) {
                        if (AppConfig.isDebug()) {
                            Log.d(NewFavorFragment.TAG, "onPullUpToRefresh: perform");
                        }
                        int size = NewFavorFragment.this.mFavorAdapter.getData().size();
                        boolean isClearAllData = false;
                        String lastUkey = "";
                        if (size > 0) {
                            try {
                                FavorModel favorModel = NewFavorFragment.this.mFavorAdapter.getData().get(size - 1);
                                if (favorModel.isDir()) {
                                    isClearAllData = true;
                                } else {
                                    lastUkey = favorModel.uKey;
                                }
                            } catch (Exception e2) {
                                if (AppConfig.isDebug()) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (NewFavorFragment.this.currentClassifyModel != null) {
                            if (AppConfig.isDebug()) {
                                Log.d("FavorloadData", "updateListDataIfChange start");
                            }
                            NewFavorFragment newFavorFragment = NewFavorFragment.this;
                            newFavorFragment.updateListDataIfChange(lastUkey, newFavorFragment.currentClassifyModel.getTplArray(), NewFavorFragment.this.currentClassifyModel.getIdentify(), isClearAllData);
                        }
                    } else if (NewFavorFragment.this.mFavorAdapter.getData().size() == 0) {
                        NewFavorFragment newFavorFragment2 = NewFavorFragment.this;
                        newFavorFragment2.showFavorList(newFavorFragment2.mFavorAdapter.getData(), true, false, NewFavorFragment.this.currentClassifyModel.getIdentify());
                    }
                } else if (NewFavorFragment.this.mShimmerLayout.getVisibility() == 0) {
                    NewFavorFragment.this.mShimmerView.stopShimmerAnimation();
                    NewFavorFragment.this.mShimmerLayout.setVisibility(8);
                    NewFavorFragment.this.mShimmerView.setVisibility(8);
                }
            }
        });
    }

    private void updateCurrentData(String[] tplArray, String lastUkey, final String requestType) {
        RefreshLoaderParams loaderParams;
        FavorListLoaderType loaderType;
        IFavorManager manager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
        if (TextUtils.equals(requestType, "all")) {
            loaderType = FavorListLoaderType.ALL_TAB;
            loaderParams = RefreshLoaderParams.builder().lastUkey(lastUkey).excludeTplArray(tplArray).build();
        } else {
            loaderType = FavorListLoaderType.CLASSIFY_TAB;
            loaderParams = RefreshLoaderParams.builder().lastUkey(lastUkey).tplArray(tplArray).build();
        }
        IFavorList favorList = manager.getFavorList();
        if (favorList != null) {
            favorList.refreshFavorListData(loaderType, loaderParams, new FavorDataCallback<List<FavorModel>>() {
                public void onResult(List<FavorModel> data) {
                    if (NewFavorFragment.this.currentClassifyModel != null && TextUtils.equals(NewFavorFragment.this.currentClassifyModel.getIdentify(), requestType)) {
                        List<FavorModel> allData = NewFavorFragment.this.mFavorAdapter.getData();
                        if (allData == null) {
                            allData = new ArrayList<>();
                        }
                        if (data != null) {
                            allData.clear();
                            allData.addAll(data);
                        }
                        NewFavorFragment.this.showFavorList(allData, false, false, requestType);
                        NewFavorFragment newFavorFragment = NewFavorFragment.this;
                        newFavorFragment.tryLoadNextPage(newFavorFragment.mRecyclerView);
                    } else if (NewFavorFragment.this.mShimmerLayout.getVisibility() == 0) {
                        NewFavorFragment.this.mShimmerView.stopShimmerAnimation();
                        NewFavorFragment.this.mShimmerLayout.setVisibility(8);
                        NewFavorFragment.this.mShimmerView.setVisibility(8);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateListDataIfChange(String lastUkey, String[] tplArray, final String requestType, final boolean isClearAllData) {
        FavorListLoaderParams params;
        FavorListLoaderType loaderType;
        if (!this.mIsLoading) {
            this.mIsLoading = true;
            final IFavorList favorList = ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).getFavorList();
            if (favorList == null) {
                this.mIsLoading = false;
                return;
            }
            if (TextUtils.equals(requestType, "all")) {
                loaderType = FavorListLoaderType.ALL_TAB;
                params = FavorListLoaderParams.builder().lastUkey(lastUkey).pageSize(20).excludeTplArray(tplArray).build();
            } else {
                loaderType = FavorListLoaderType.CLASSIFY_TAB;
                params = FavorListLoaderParams.builder().lastUkey(lastUkey).queryType(QueryType.LOCAL).pageSize(20).tplArray(tplArray).build();
            }
            favorList.queryFavorListData(loaderType, params, new FavorDataCallback<FavorListResult>() {
                /* JADX WARNING: type inference failed for: r2v5, types: [java.util.List<com.baidu.searchbox.favor.data.FavorModel>] */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResult(com.baidu.searchbox.favor.data.FavorListResult r11) {
                    /*
                        r10 = this;
                        r0 = 0
                        if (r11 == 0) goto L_0x0051
                        com.baidu.searchbox.bookmark.NewFavorFragment r1 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel r1 = r1.currentClassifyModel
                        java.lang.String r1 = r1.getIdentify()
                        java.lang.String r2 = r9
                        boolean r1 = android.text.TextUtils.equals(r1, r2)
                        if (r1 != 0) goto L_0x0016
                        goto L_0x0051
                    L_0x0016:
                        boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
                        if (r1 == 0) goto L_0x0024
                        java.lang.String r1 = "FavorloadData"
                        java.lang.String r2 = "queryFavorListData end"
                        com.baidu.android.common.logging.Log.d(r1, r2)
                    L_0x0024:
                        int r1 = r11.favorSize
                        if (r1 == 0) goto L_0x002d
                        int r2 = r1 % 20
                        if (r2 != 0) goto L_0x002d
                        r0 = 1
                    L_0x002d:
                        r6 = r0
                        java.util.ArrayList r0 = new java.util.ArrayList
                        r0.<init>()
                        java.util.List<com.baidu.searchbox.favor.data.FavorModel> r2 = r11.list
                        boolean r2 = r2 instanceof java.util.ArrayList
                        if (r2 == 0) goto L_0x003e
                        java.util.List<com.baidu.searchbox.favor.data.FavorModel> r2 = r11.list
                        r0 = r2
                        java.util.ArrayList r0 = (java.util.ArrayList) r0
                    L_0x003e:
                        com.baidu.searchbox.userassetsaggr.container.film.FavorHisWebFilmInfoManager r8 = com.baidu.searchbox.userassetsaggr.container.film.FavorHisWebFilmInfoManager.INSTANCE
                        java.lang.String r4 = r9
                        boolean r5 = r10
                        com.baidu.searchbox.favor.IFavorList r7 = r1
                        com.baidu.searchbox.bookmark.NewFavorFragment$11$$ExternalSyntheticLambda0 r9 = new com.baidu.searchbox.bookmark.NewFavorFragment$11$$ExternalSyntheticLambda0
                        r2 = r9
                        r3 = r10
                        r2.<init>(r3, r4, r5, r6, r7)
                        r8.getFavorFilmInfo(r0, r9)
                        return
                    L_0x0051:
                        com.baidu.searchbox.bookmark.NewFavorFragment r1 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel r1 = r1.currentClassifyModel
                        if (r1 == 0) goto L_0x0074
                        com.baidu.searchbox.bookmark.NewFavorFragment r1 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel r1 = r1.currentClassifyModel
                        java.lang.String r1 = r1.getIdentify()
                        java.lang.String r2 = r9
                        boolean r1 = android.text.TextUtils.equals(r1, r2)
                        if (r1 == 0) goto L_0x0074
                        com.baidu.searchbox.bookmark.NewFavorFragment r1 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.userassetsaggr.container.UserAssetsRecyclerView r1 = r1.mRecyclerView
                        r1.setVisibility(r0)
                    L_0x0074:
                        com.baidu.searchbox.bookmark.NewFavorFragment r1 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        boolean unused = r1.mIsLoading = r0
                        com.baidu.searchbox.bookmark.NewFavorFragment r0 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        android.view.View r0 = r0.mShimmerLayout
                        int r0 = r0.getVisibility()
                        if (r0 != 0) goto L_0x00a2
                        com.baidu.searchbox.bookmark.NewFavorFragment r0 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.ui.BdShimmerView r0 = r0.mShimmerView
                        r0.stopShimmerAnimation()
                        com.baidu.searchbox.bookmark.NewFavorFragment r0 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        android.view.View r0 = r0.mShimmerLayout
                        r1 = 8
                        r0.setVisibility(r1)
                        com.baidu.searchbox.bookmark.NewFavorFragment r0 = com.baidu.searchbox.bookmark.NewFavorFragment.this
                        com.baidu.searchbox.ui.BdShimmerView r0 = r0.mShimmerView
                        r0.setVisibility(r1)
                    L_0x00a2:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.NewFavorFragment.AnonymousClass11.onResult(com.baidu.searchbox.favor.data.FavorListResult):void");
                }

                /* access modifiers changed from: package-private */
                /* renamed from: lambda$onResult$0$com-baidu-searchbox-bookmark-NewFavorFragment$11  reason: not valid java name */
                public /* synthetic */ Unit m16616lambda$onResult$0$combaidusearchboxbookmarkNewFavorFragment$11(String requestType, boolean isClearAllData, boolean hasNextPage, final IFavorList favorList, ArrayList resultData, final ArrayList listToUpdate) {
                    if (AppConfig.isDebug()) {
                        Log.d("FavorloadData", "getFavorFilmInfo end");
                    }
                    if (!TextUtils.equals(NewFavorFragment.this.currentClassifyModel.getIdentify(), requestType)) {
                        boolean unused = NewFavorFragment.this.mIsLoading = false;
                        if (NewFavorFragment.this.mShimmerLayout.getVisibility() == 0) {
                            NewFavorFragment.this.mShimmerView.stopShimmerAnimation();
                            NewFavorFragment.this.mShimmerLayout.setVisibility(8);
                            NewFavorFragment.this.mShimmerView.setVisibility(8);
                        }
                        return null;
                    }
                    List<FavorModel> allData = NewFavorFragment.this.mFavorAdapter.getData();
                    if (allData == null) {
                        allData = new ArrayList<>();
                    }
                    if (resultData != null) {
                        if (isClearAllData) {
                            allData.clear();
                        }
                        allData.addAll(resultData);
                    }
                    NewFavorFragment.this.showFavorList(allData, true, hasNextPage, requestType);
                    if (listToUpdate != null && listToUpdate.size() > 0) {
                        ExecutorUtilsExt.postOnElastic(new Runnable() {
                            public void run() {
                                favorList.updateFavorsList(listToUpdate);
                            }
                        }, "updateFavorsList", 0);
                    }
                    return null;
                }
            });
        }
    }

    private void initClassifyView() {
        this.mClassifyView.setOnItemClickListener(new ClassifyView.OnItemClickListener() {
            public void onItemClick(ClassifyModel model) {
                NewFavorFragment.this.changeCurrentViewStatusByType(model, true);
                if (model != null && TextUtils.equals("search_web_video", model.getIdentify()) && model.isShowingUpdateTip()) {
                    DefaultSharedPrefsWrapper.getInstance().putLong(UserAssetsCommandListenerKt.FAVOR_CLASSIFY_WEB_VIDEO_UPDATE_TIP_LAST_SHOW_TIME_SP_KEY, System.currentTimeMillis());
                }
                if (model == null || !TextUtils.equals("feed_playlet", model.getIdentify()) || !model.isShowingDotTips()) {
                    FavorCenterPlayletHelper.INSTANCE.emitPlayletTabSelectEvent(true);
                } else {
                    FavorCenterPlayletHelper.INSTANCE.markFavorPlayletTabDot(false);
                    FavorCenterPlayletHelper.INSTANCE.emitPlayletTabSelectEvent(true);
                    NewFavorFragment.this.mClassifyView.setShouldShowTips("feed_playlet", false);
                }
                String ubcValue = null;
                if (NewFavorFragment.this.currentClassifyModel != null) {
                    ubcValue = NewFavorFragment.this.currentClassifyModel.getUbcSource();
                }
                BookmarkUBC.favorShowEvent("from_click", ubcValue);
            }
        });
        if (this.mClassifyView.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) this.mClassifyView.getLayoutParams();
            if (FavorHisAbTestManager.INSTANCE.getFavorHisBetterStyleSwitch()) {
                params.setMargins(0, 0, 0, DeviceUtils.ScreenInfo.dp2px(getContext(), 3.0f));
            } else {
                params.setMargins(DeviceUtils.ScreenInfo.dp2px(getContext(), 12.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 13.0f), DeviceUtils.ScreenInfo.dp2px(getContext(), 3.0f));
            }
            this.mClassifyView.setLayoutParams(params);
        }
        this.mClassifyView.getFavorDataFromLocal(this.defaultClassifyId);
        ClassifyModel selectedClassifyModel = this.mClassifyView.getSelectedClassifyModel();
        this.currentClassifyModel = selectedClassifyModel;
        if (!TextUtils.isEmpty(this.defaultClassifyId) && selectedClassifyModel != null) {
            changeCurrentViewStatusByType(selectedClassifyModel, false);
        }
        if (FavorHisWebFilmInfoManager.INSTANCE.canShowWebVideoUpdateTips() && selectedClassifyModel != null && !TextUtils.equals(selectedClassifyModel.getIdentify(), "search_web_video")) {
            setWebVideoClassifyTips();
        }
        if (!TextUtils.equals(selectedClassifyModel.getIdentify(), "feed_playlet")) {
            FavorCenterPlayletHelper.INSTANCE.emitPlayletTabSelectEvent(false);
            if (FavorCenterPlayletHelper.INSTANCE.getFavorPlayletTabDot()) {
                this.mClassifyView.setTipsType("feed_playlet", ClassifyView.TipsType.DOT);
                this.mClassifyView.setShouldShowTips("feed_playlet", true);
            }
        } else {
            FavorCenterPlayletHelper.INSTANCE.emitPlayletTabSelectEvent(true);
        }
        setEmptyViewLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0015, code lost:
        r2 = r1.getFavorList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setWebVideoClassifyTips() {
        /*
            r6 = this;
            java.lang.String r0 = "search_web_video"
            java.lang.String r1 = "search_web_film"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.searchbox.favor.IFavorManager.SERVICE_REFERENCE
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)
            com.baidu.searchbox.favor.IFavorManager r1 = (com.baidu.searchbox.favor.IFavorManager) r1
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            com.baidu.searchbox.favor.IFavorList r2 = r1.getFavorList()
            if (r2 != 0) goto L_0x001c
            return
        L_0x001c:
            com.baidu.searchbox.favor.data.FavorListLoaderParams$Builder r3 = com.baidu.searchbox.favor.data.FavorListLoaderParams.builder()
            java.lang.String r4 = ""
            com.baidu.searchbox.favor.data.FavorListLoaderParams$Builder r3 = r3.lastUkey(r4)
            com.baidu.searchbox.favor.data.QueryType r4 = com.baidu.searchbox.favor.data.QueryType.LOCAL
            com.baidu.searchbox.favor.data.FavorListLoaderParams$Builder r3 = r3.queryType(r4)
            r4 = 20
            com.baidu.searchbox.favor.data.FavorListLoaderParams$Builder r3 = r3.pageSize(r4)
            com.baidu.searchbox.favor.data.FavorListLoaderParams$Builder r3 = r3.tplArray(r0)
            com.baidu.searchbox.favor.data.FavorListLoaderParams r3 = r3.build()
            com.baidu.searchbox.favor.data.FavorListLoaderType r4 = com.baidu.searchbox.favor.data.FavorListLoaderType.CLASSIFY_TAB
            com.baidu.searchbox.bookmark.NewFavorFragment$13 r5 = new com.baidu.searchbox.bookmark.NewFavorFragment$13
            r5.<init>(r2)
            r2.queryFavorListData(r4, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.NewFavorFragment.setWebVideoClassifyTips():void");
    }

    /* access modifiers changed from: private */
    public void changeCurrentViewStatusByType(ClassifyModel model, boolean isFromCLick) {
        UserAssetsRecyclerView userAssetsRecyclerView = this.mRecyclerView;
        if (userAssetsRecyclerView != null) {
            userAssetsRecyclerView.stopScroll();
        }
        this.currentClassifyModel = model;
        if (model != null) {
            String identify = model.getIdentify();
            if (getMainContainer() != null && this.mFavorAdapter.isEditable()) {
                getMainContainer().endEditMode();
            }
            if (getMainContainer() != null) {
                FavorGoodsView favorGoodsView = this.mFavorGoodsView;
                if (favorGoodsView != null && favorGoodsView.getVisibility() == 0 && this.mFavorGoodsView.getCurrentIsEditable()) {
                    getMainContainer().endEditMode();
                }
                NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
                if (newFavorWebVideoView != null && newFavorWebVideoView.getVisibility() == 0 && this.mFavorWebVideoView.getCurrentIsEditable()) {
                    getMainContainer().endEditMode();
                }
                FavorPlayletView favorPlayletView = this.mFavorPlayletView;
                if (favorPlayletView != null && favorPlayletView.getVisibility() == 0 && this.mFavorPlayletView.getCurrentIsEditable()) {
                    getMainContainer().endEditMode();
                }
            }
            if (getMainContainer() != null) {
                getMainContainer().setEditToolBarView();
            }
            String[] tplArray = this.currentClassifyModel.getTplArray();
            if ("product".equals(identify)) {
                if (getMainContainer() != null) {
                    this.mFavorGoodsView.setMainContainer(getMainContainer());
                }
                this.mFavorGoodsView.fetchFavorGoodData("", false, new Function0<Unit>() {
                    public Unit invoke() {
                        if (!NewFavorFragment.this.currentSelectedIsProductType()) {
                            return null;
                        }
                        NewFavorFragment.this.mRecyclerView.setVisibility(8);
                        NewFavorFragment.this.mEmptyLayout.setVisibility(8);
                        NewFavorFragment.this.mShimmerLayout.setVisibility(8);
                        NewFavorFragment.this.mShimmerView.setVisibility(8);
                        NewFavorFragment.this.mShimmerView.stopShimmerAnimation();
                        NewFavorFragment.this.mFavorWebVideoView.setVisibility(8);
                        NewFavorFragment.this.mFavorPlayletView.setVisibility(8);
                        NewFavorFragment.this.mFavorGoodsView.setVisibility(0);
                        return null;
                    }
                });
                this.mFavorGoodsView.onUBcEventWhenPageShow();
            } else if ("all".equals(identify)) {
                List<FavorModel> data = this.mFavorAdapter.getData();
                if (data != null) {
                    data.clear();
                }
                if (AppConfig.isDebug()) {
                    Log.d("FavorloadData", "changeCurrentViewStatusByType start");
                }
                this.mEmptyLayout.setVisibility(8);
                this.mFavorGoodsView.setVisibility(8);
                this.mFavorPlayletView.setVisibility(8);
                this.mFavorWebVideoView.setVisibility(8);
                this.mShimmerLayout.setVisibility(0);
                this.mShimmerView.setVisibility(0);
                this.mShimmerView.startShimmerAnimation();
                updateListDataIfChange("", tplArray, identify, false);
            } else if ("search_web_video".equals(identify)) {
                if (getMainContainer() != null) {
                    this.mFavorWebVideoView.setMainContainer(getMainContainer());
                }
                FavorController favorController = this.mController;
                if (favorController != null) {
                    this.mFavorWebVideoView.setFavorDataController(favorController);
                }
                this.mRecyclerView.setVisibility(8);
                this.mShimmerLayout.setVisibility(8);
                this.mShimmerView.setVisibility(8);
                this.mShimmerView.stopShimmerAnimation();
                this.mEmptyLayout.setVisibility(8);
                this.mFavorGoodsView.setVisibility(8);
                this.mFavorPlayletView.setVisibility(8);
                this.mFavorWebVideoView.setVisibility(0);
                this.mFavorWebVideoView.setClassifyModel(this.currentClassifyModel);
                onWebVideoShowUbc(isFromCLick);
                if (tplArray != null) {
                    this.mFavorWebVideoView.getFavorWebVideoData(tplArray, "", 20, false);
                }
            } else if ("feed_playlet".equals(identify)) {
                if (getMainContainer() != null) {
                    this.mFavorPlayletView.setMainContainer(getMainContainer());
                }
                FavorController favorController2 = this.mController;
                if (favorController2 != null) {
                    this.mFavorPlayletView.setFavorDataController(favorController2);
                }
                this.mRecyclerView.setVisibility(8);
                this.mShimmerLayout.setVisibility(8);
                this.mShimmerView.setVisibility(8);
                this.mShimmerView.stopShimmerAnimation();
                this.mEmptyLayout.setVisibility(8);
                this.mFavorGoodsView.setVisibility(8);
                this.mFavorWebVideoView.setVisibility(8);
                this.mFavorPlayletView.setVisibility(0);
                this.mFavorPlayletView.setClassifyModel(this.currentClassifyModel);
                if (!isFromCLick) {
                    BookmarkUBC.event("show", "tab_fav", "from_toast", this.currentClassifyModel.getUbcSource());
                }
                if (tplArray != null) {
                    this.mFavorPlayletView.getFavorPlayletData("", 20, false);
                }
            } else {
                List<FavorModel> data2 = this.mFavorAdapter.getData();
                if (data2 != null) {
                    data2.clear();
                }
                if (AppConfig.isDebug()) {
                    Log.d("FavorloadData", "changeCurrentViewStatusByType start");
                }
                this.mEmptyLayout.setVisibility(8);
                this.mFavorGoodsView.setVisibility(8);
                this.mFavorWebVideoView.setVisibility(8);
                this.mFavorPlayletView.setVisibility(8);
                this.mRecyclerView.setVisibility(8);
                this.mShimmerLayout.setVisibility(0);
                this.mShimmerView.setVisibility(0);
                this.mShimmerView.startShimmerAnimation();
                updateListDataIfChange("", tplArray, identify, false);
            }
            updateBottomBarVisibility(false);
        }
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        QuickLoginViewHelper build = QuickLoginViewHelper.Builder.builder(getContext()).setRootView(this.mBookmarkView).setLoginMainTitle(getString(R.string.favor_login_mai_title)).setLoginSrc(BookmarkUBC.FAVOR_SOURCE_CLICK_NOT_LOGIN).setUseCloudSwitch(true).setCloudSwitchKey(UserAssetsCommandListenerKt.KEY_FAVOR_LOGIN_SWITCH).setFunctionIcon(getResources().getDrawable(R.drawable.account_favor_function_icon)).setCallback(new QuickLoginViewHelper.LoginChangeCallback() {
            public void showLoginView() {
                if (NewFavorFragment.DEBUG) {
                    Log.d(NewFavorFragment.TAG, "——> showLoginView: ");
                }
                if (NewFavorFragment.this.currentClassifyModel != null && NewFavorFragment.this.currentSelectedTabIsRecyclerView()) {
                    if (AppConfig.isDebug()) {
                        Log.d("FavorloadData", "showLoginView start");
                    }
                    NewFavorFragment.this.mShimmerLayout.setVisibility(0);
                    NewFavorFragment.this.mShimmerView.setVisibility(0);
                    NewFavorFragment newFavorFragment = NewFavorFragment.this;
                    newFavorFragment.updateListDataIfChange("", newFavorFragment.currentClassifyModel.getTplArray(), NewFavorFragment.this.currentClassifyModel.getIdentify(), false);
                }
            }
        }).setLoginViewReadyCallback(new QuickLoginViewHelper.LoginViewReadyCallback() {
            public void onLoginViewReady() {
                Bundle bundle = NewFavorFragment.this.getArguments();
                if (bundle != null && bundle.containsKey("source")) {
                    NewFavorFragment.this.onFragmentSeleted();
                }
            }
        }).addOtherView(this.mContentView).build();
        this.mLoginViewHelper = build;
        build.onCreate();
        if (DEBUG) {
            Log.d(TAG, "——> onActivityCreated: ");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 101) {
            this.resumeFromSelectDirPage = true;
            if (data != null) {
                String moveSelectDir = data.getStringExtra(FavorsSelectDirsActivity.KEY_MOVE_SELECT_DIR);
                if (!TextUtils.isEmpty(moveSelectDir)) {
                    doMove(moveSelectDir);
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (DEBUG) {
            Log.d(TAG, "onResume: mVisibleToUser " + this.mVisibleToUser);
        }
        if (this.mVisibleToUser) {
            this.mController.setLock(false);
            FavorIntroductionUtils.showFavorHome();
        }
        if (currentSelectedIsProductType()) {
            FavorGoodsView favorGoodsView = this.mFavorGoodsView;
            if (favorGoodsView != null && favorGoodsView.getVisibility() == 0) {
                this.mFavorGoodsView.onResume();
            }
        } else if (currentSelectedIsWebVideoType()) {
            NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
            if (newFavorWebVideoView != null && newFavorWebVideoView.getVisibility() == 0) {
                this.mFavorWebVideoView.onResume();
            }
        } else if (currentSelectedIsPlayletType()) {
            FavorPlayletView favorPlayletView = this.mFavorPlayletView;
            if (favorPlayletView != null && favorPlayletView.getVisibility() == 0) {
                this.mFavorPlayletView.onResume();
            }
        } else {
            refreshRecycleTabData();
        }
        if (this.mIsFirstOnResume) {
            this.mIsFirstOnResume = false;
        }
        if (this.resumeFromSelectDirPage) {
            this.resumeFromSelectDirPage = false;
        }
        updateFontSize();
    }

    private void refreshRecycleTabData() {
        boolean isCompleteLogin = ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2);
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null && !this.mIsFirstOnResume && isCompleteLogin && !this.resumeFromSelectDirPage) {
            List<FavorModel> data = newFavorAdapter.getData();
            if (data != null && data.size() > 0) {
                FavorModel favorModel = data.get(data.size() - 1);
                if (favorModel != null) {
                    String lastUkey = favorModel.uKey;
                    if (currentSelectedTabIsRecyclerView()) {
                        updateCurrentData(this.currentClassifyModel.getTplArray(), lastUkey, this.currentClassifyModel.getIdentify());
                    }
                }
            } else if (this.currentClassifyModel != null && currentSelectedTabIsRecyclerView() && !this.mIsLoading) {
                if (AppConfig.isDebug()) {
                    Log.d("FavorloadData", "showLoginView start");
                }
                NestedScrollView nestedScrollView = this.mEmptyLayout;
                if (nestedScrollView != null) {
                    nestedScrollView.setVisibility(8);
                }
                this.mShimmerLayout.setVisibility(0);
                this.mShimmerView.setVisibility(0);
                updateListDataIfChange("", this.currentClassifyModel.getTplArray(), this.currentClassifyModel.getIdentify(), false);
            }
        }
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.mVisibleToUser = isVisibleToUser;
        if (DEBUG) {
            Log.d(TAG, "setUserVisibleHint " + this.mVisibleToUser);
        }
    }

    public void onStop() {
        super.onStop();
    }

    public void onPause() {
        super.onPause();
        UserAssetsAggrUbc.sHasReportUbcItem.clear();
        BookmarkUBC.sHasReportUbcFavorItem.clear();
        FavorController favorController = this.mController;
        if (favorController != null) {
            favorController.doFavorSync();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onDestroy() {
        unRegisterEventBus();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
        this.mController.destroyLoader();
        this.mLoginViewHelper.onDestroy();
        FavorSyncUBC.uploadFavorNumber();
        FavorGoodsView favorGoodsView = this.mFavorGoodsView;
        if (favorGoodsView != null) {
            favorGoodsView.onDestroy();
        }
        NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
        if (newFavorWebVideoView != null) {
            newFavorWebVideoView.onDestroy();
        }
        FavorPlayletView favorPlayletView = this.mFavorPlayletView;
        if (favorPlayletView != null) {
            favorPlayletView.onDestroy();
        }
        BoxShareManager boxShareManager = this.mShareManager;
        if (boxShareManager != null) {
            boxShareManager.clean();
        }
        FavorHisWebFilmInfoManager.INSTANCE.onDestroy();
        if (AppConfig.isDebug()) {
            SharedPreferences.Editor e2 = PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext().getApplicationContext()).edit();
            e2.putBoolean(FavorHisWebFilmInfoManager.WEB_FILM_UPDATE_DEBUG_KEY, false);
            e2.apply();
        }
        super.onDestroy();
    }

    public void setController(FavorController controller) {
        this.mController = controller;
    }

    public void showToast(int rId) {
        UniversalToast.makeText((Context) getActivity(), (CharSequence) getResources().getString(rId)).showToast();
    }

    public void showFavorList(FavorList data) {
    }

    public void showFavorList(List<FavorModel> data, boolean isNeedUpdateNextPage, boolean hasNextPage, String requestType) {
        if (DEBUG) {
            Log.d(TAG, "——> showFavorList: " + data);
        }
        this.mIsLoading = false;
        Context context = getContext();
        if (context != null && (!(context instanceof Activity) || !ActivityUtils.isDestroyed((Activity) context))) {
            setLayoutManager();
            ClassifyModel classifyModel = this.currentClassifyModel;
            if (classifyModel == null || data == null || TextUtils.equals(classifyModel.getIdentify(), requestType)) {
                this.mRecyclerView.setVisibility(0);
                setLoginBarTips();
                boolean isAddData = false;
                if (this.mFavorAdapter != null && data != null && data.size() > 0 && (this.mFavorAdapter.getData() == null || this.mFavorAdapter.getData().size() < data.size())) {
                    isAddData = true;
                }
                boolean z = isAddData;
                NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
                if (newFavorAdapter != null) {
                    newFavorAdapter.setCurrentTab(getCurClassifyIdentify(), getCurClassifyName());
                    if (this.mIsEditable && this.mFavorAdapter.isSelectedAll()) {
                        this.mFavorAdapter.addAllItemsToSelectedSet(data);
                    }
                    this.mFavorAdapter.setData(data);
                    if (this.mShimmerLayout.getVisibility() == 0) {
                        this.mShimmerView.stopShimmerAnimation();
                        this.mShimmerLayout.setVisibility(8);
                        this.mShimmerView.setVisibility(8);
                    }
                    if (this.mIsEditable && this.mFavorAdapter.isSelectedAll()) {
                        onSelectAll(true);
                    }
                }
                this.mContentView.setVisibility(0);
                this.mFavorGoodsView.setVisibility(8);
                this.mFavorWebVideoView.setVisibility(8);
                this.mFavorPlayletView.setVisibility(8);
                QuickLoginViewHelper quickLoginViewHelper = this.mLoginViewHelper;
                if (quickLoginViewHelper != null) {
                    quickLoginViewHelper.setNotLoginViewVisibility(8);
                }
                updateBottomBarVisibility(false);
                if (data == null || data.size() <= 0) {
                    this.mEmptyLayout.setVisibility(0);
                    this.mRecyclerView.setVisibility(8);
                    this.mEmptyView.setIcon(getResources().getDrawable(R.drawable.favor_empty_icon));
                    this.mEmptyView.setTitle(getString(R.string.bookmark_empty_text));
                    setEmptyViewLayout();
                } else {
                    this.mEmptyLayout.setVisibility(8);
                    this.mRecyclerView.setVisibility(0);
                }
                if (!(this.mFavorAdapter == null || data == null)) {
                    BookmarkUBC.ubcModelMemory(data.size(), 0, "all");
                }
                if (this.isFirstFetchDataCallBack) {
                    if (data == null || data.size() <= 0) {
                        FavorStatisticUtilsKt.favorListDataUbcEvent(true);
                    } else {
                        FavorStatisticUtilsKt.favorListDataUbcEvent(false);
                    }
                }
                if (this.isFirstFetchDataCallBack) {
                    this.isFirstFetchDataCallBack = false;
                }
                onFavorDataChanged();
                if (isNeedUpdateNextPage) {
                    this.mDividerDecoration.needLoadEndDivider(!hasNextPage);
                    NewFavorAdapter newFavorAdapter2 = this.mFavorAdapter;
                    if (newFavorAdapter2 != null) {
                        newFavorAdapter2.setHasNextData(hasNextPage);
                    }
                    this.mRecyclerView.setHasNextPage(hasNextPage);
                }
            } else if (this.mShimmerLayout.getVisibility() == 0) {
                this.mShimmerView.stopShimmerAnimation();
                this.mShimmerLayout.setVisibility(8);
                this.mShimmerView.setVisibility(8);
            }
        } else if (this.mShimmerLayout.getVisibility() == 0) {
            this.mShimmerView.stopShimmerAnimation();
            this.mShimmerLayout.setVisibility(8);
            this.mShimmerView.setVisibility(8);
        }
    }

    private void setLayoutManager() {
        UserAssetsRecyclerView userAssetsRecyclerView;
        LinearLayoutManager linearLayoutManager;
        GridLayoutManager gridLayoutManager;
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel != null && TextUtils.equals(classifyModel.getIdentify(), "video") && "2".equals(FavorHisAbTestManager.INSTANCE.getVideoType())) {
            if (this.mGridLayoutManager == null) {
                GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getContext(), 3);
                this.mGridLayoutManager = gridLayoutManager2;
                gridLayoutManager2.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                    public int getSpanSize(int position) {
                        if (NewFavorFragment.this.mFavorAdapter.getItemViewType(position) == TemplateEnum.LOADING_VIEW.ordinal()) {
                            return 3;
                        }
                        return 1;
                    }
                });
            }
            UserAssetsRecyclerView userAssetsRecyclerView2 = this.mRecyclerView;
            if (userAssetsRecyclerView2 != null && userAssetsRecyclerView2.getLayoutManager() != (gridLayoutManager = this.mGridLayoutManager)) {
                this.mRecyclerView.setLayoutManager(gridLayoutManager);
            }
        } else if (this.mLayoutManager != null && (userAssetsRecyclerView = this.mRecyclerView) != null && userAssetsRecyclerView.getLayoutManager() != (linearLayoutManager = this.mLayoutManager)) {
            this.mRecyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    private void updateBottomBarVisibility(boolean ignoreVisibleToUser) {
        if (getMainContainer() != null && ((this.mVisibleToUser || ignoreVisibleToUser) && this.mIsEditable)) {
            getMainContainer().setBottomBarVisible(false);
        }
        updateFontSize();
    }

    public void swapDataSource() {
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null) {
            newFavorAdapter.setData((List<FavorModel>) null);
        }
        onFavorDataChanged();
    }

    public Context getFragmentContext() {
        return getActivity();
    }

    /*  JADX ERROR: NullPointerException in pass: CodeShrinkVisitor
        java.lang.NullPointerException
        */
    public void openFavor(int r22, com.baidu.searchbox.favor.data.FavorModel r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r23
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            com.baidu.searchbox.bookmark.adapter.NewFavorAdapter r2 = r0.mFavorAdapter
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x005e
            boolean r2 = r2.isEditable()
            if (r2 == 0) goto L_0x005e
            com.baidu.searchbox.bookmark.adapter.NewFavorAdapter r2 = r0.mFavorAdapter
            boolean r2 = r2.toggleCheck(r1)
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r5 = r21.getMainContainer()
            if (r5 != 0) goto L_0x0020
            return
        L_0x0020:
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r5 = r21.getMainContainer()
            if (r2 == 0) goto L_0x0030
            com.baidu.searchbox.bookmark.adapter.NewFavorAdapter r6 = r0.mFavorAdapter
            boolean r6 = r6.isAllSelected()
            if (r6 == 0) goto L_0x0030
            r6 = r3
            goto L_0x0031
        L_0x0030:
            r6 = r4
        L_0x0031:
            r5.updateAllSelectedBtnState(r6)
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r5 = r21.getMainContainer()
            int r6 = r21.getSelectedCount()
            if (r6 <= 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r3 = r4
        L_0x0040:
            int r4 = r21.getSelectedCount()
            r5.updateDeleteBtnState(r3, r4)
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r3 = r21.getMainContainer()
            boolean r4 = r21.checkMoveBtnEnableState()
            r3.updateMoveBtnState(r4)
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r3 = r21.getMainContainer()
            boolean r4 = r21.checkRenameBtnEnableState()
            r3.updateRenameBtnState(r4)
            return
        L_0x005e:
            r0.mCurrentFavorData = r1
            java.lang.String r2 = r1.dataType
            java.lang.String r5 = "1"
            boolean r2 = android.text.TextUtils.equals(r2, r5)
            if (r2 == 0) goto L_0x01cf
            com.baidu.searchbox.bookmark.favor.FavorController r2 = r0.mController
            if (r2 != 0) goto L_0x006f
            return
        L_0x006f:
            java.lang.String r2 = r1.title
            java.lang.String r15 = r1.url
            java.lang.String r14 = r1.tplId
            java.lang.String r6 = "search_web_film"
            boolean r6 = android.text.TextUtils.equals(r14, r6)
            if (r6 == 0) goto L_0x00a6
            com.baidu.searchbox.favor.data.FavorModel$Feature r6 = r1.feature
            if (r6 == 0) goto L_0x00a6
            com.baidu.searchbox.favor.data.FavorModel$Feature r6 = r1.feature
            com.baidu.searchbox.favor.data.MoviesModel r6 = r6.moviesModel
            if (r6 == 0) goto L_0x00a6
            com.baidu.searchbox.favor.data.FavorModel$Feature r6 = r1.feature
            com.baidu.searchbox.favor.data.MoviesModel r6 = r6.moviesModel
            java.lang.String r7 = r6.getNeedShowBadge()
            boolean r5 = android.text.TextUtils.equals(r7, r5)
            if (r5 == 0) goto L_0x00a6
            java.lang.String r5 = "0"
            r6.setNeedShowBadge(r5)
            com.baidu.searchbox.bookmark.NewFavorFragment$18 r5 = new com.baidu.searchbox.bookmark.NewFavorFragment$18
            r5.<init>(r1)
            java.lang.String r7 = "updateFavorBadge"
            com.baidu.searchbox.elasticthread.ExecutorUtilsExt.postOnElastic(r5, r7, r4)
        L_0x00a6:
            java.lang.String r4 = r1.cmd
            java.lang.String r5 = r1.openType
            java.lang.String r16 = r23.getExtData()
            java.lang.String r13 = com.baidu.searchbox.bookmark.BookmarkUtil.getRootSource(r16)
            java.lang.String r12 = com.baidu.searchbox.bookmark.BookmarkUtil.getReporterExtraInfo(r16)
            java.lang.String r6 = ""
            com.baidu.searchbox.favor.data.FavorModel$Feature r7 = r1.feature
            if (r7 == 0) goto L_0x00d6
            com.baidu.searchbox.favor.data.FavorModel$Feature r7 = r1.feature
            com.baidu.searchbox.favor.data.MoviesModel r7 = r7.moviesModel
            if (r7 == 0) goto L_0x00d6
            com.baidu.searchbox.favor.data.FavorModel$Feature r7 = r1.feature
            com.baidu.searchbox.favor.data.MoviesModel r7 = r7.moviesModel
            java.lang.String r8 = r7.getPreQueryWord()
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x00d6
            java.lang.String r6 = r7.getPreQueryWord()
            r11 = r6
            goto L_0x00d7
        L_0x00d6:
            r11 = r6
        L_0x00d7:
            com.baidu.searchbox.bookmark.favor.FavorController r6 = r0.mController
            boolean r6 = r6.isLock()
            if (r6 != 0) goto L_0x01be
            com.baidu.searchbox.bookmark.favor.FavorController r6 = r0.mController
            r6.setLock(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r4)
            if (r3 != 0) goto L_0x016a
            com.baidu.searchbox.unitedscheme.UnitedSchemeEntity r3 = com.baidu.searchbox.bookmark.BookmarkUtil.parseScheme(r4)
            if (r3 == 0) goto L_0x0153
            boolean r6 = android.text.TextUtils.isEmpty(r13)
            if (r6 == 0) goto L_0x00fc
            boolean r6 = android.text.TextUtils.isEmpty(r12)
            if (r6 != 0) goto L_0x0153
        L_0x00fc:
            boolean r6 = android.text.TextUtils.isEmpty(r13)
            if (r6 != 0) goto L_0x0108
            java.lang.String r6 = "rootSource"
            r3.putParams(r6, r13)
        L_0x0108:
            boolean r6 = android.text.TextUtils.isEmpty(r12)
            if (r6 != 0) goto L_0x0114
            java.lang.String r6 = "reporterExtraInfo"
            r3.putParams(r6, r12)
        L_0x0114:
            java.lang.String r6 = "无标题网页"
            boolean r6 = android.text.TextUtils.equals(r2, r6)
            if (r6 == 0) goto L_0x011e
            r2 = r15
        L_0x011e:
            boolean r6 = android.text.TextUtils.isEmpty(r11)
            if (r6 != 0) goto L_0x0129
            java.lang.String r6 = "fav_his_query"
            r3.putParams(r6, r11)
        L_0x0129:
            boolean r6 = android.text.TextUtils.isEmpty(r2)
            if (r6 != 0) goto L_0x0134
            java.lang.String r6 = "fav_his_title"
            r3.putParams(r6, r2)
        L_0x0134:
            java.lang.String r6 = com.baidu.searchbox.userassetsaggr.container.TitleTypeKt.getTitleTypeForFavorModel(r23)
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0143
            java.lang.String r7 = "fav_his_title_type"
            r3.putParams(r7, r6)
        L_0x0143:
            java.lang.String r7 = "fav_his_sa"
            java.lang.String r8 = "ouh_deadlink_huisou"
            r3.putParams(r7, r8)
            android.content.Context r7 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            com.baidu.searchbox.unitedscheme.BaseRouter.invoke((android.content.Context) r7, (com.baidu.searchbox.unitedscheme.UnitedSchemeEntity) r3)
            goto L_0x0161
        L_0x0153:
            com.baidu.searchbox.favor.ioc.IFavorApp r6 = com.baidu.searchbox.favor.ioc.IFavorApp.Impl.get()
            androidx.fragment.app.FragmentActivity r7 = r21.getActivity()
            java.lang.String r8 = "inside"
            r6.invokeSchemeOrCmd(r7, r4, r8)
        L_0x0161:
            r18 = r11
            r19 = r12
            r20 = r13
            r17 = r14
            goto L_0x01a9
        L_0x016a:
            java.lang.String r3 = "101"
            boolean r3 = android.text.TextUtils.equals(r5, r3)
            if (r3 == 0) goto L_0x018a
            com.baidu.pyramid.runtime.service.ServiceReference r3 = com.baidu.searchbox.browser.ILightBrowser.SERVICE_REFERENCE
            java.lang.Object r3 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r3)
            com.baidu.searchbox.browser.ILightBrowser r3 = (com.baidu.searchbox.browser.ILightBrowser) r3
            androidx.fragment.app.FragmentActivity r6 = r21.getActivity()
            r3.open(r6, r15)
            r18 = r11
            r19 = r12
            r20 = r13
            r17 = r14
            goto L_0x01a9
        L_0x018a:
            com.baidu.searchbox.bookmark.favor.FavorController r6 = r0.mController
            androidx.fragment.app.FragmentActivity r7 = r21.getActivity()
            java.lang.String r3 = com.baidu.searchbox.userassetsaggr.container.TitleTypeKt.getTitleTypeForFavorModel(r23)
            java.lang.String r17 = "ouh_deadlink_huisou"
            r8 = r15
            r9 = r13
            r10 = r12
            r18 = r11
            r19 = r12
            r12 = r2
            r20 = r13
            r13 = r17
            r17 = r14
            r14 = r3
            r6.loadUrl(r7, r8, r9, r10, r11, r12, r13, r14)
        L_0x01a9:
            android.view.View r3 = r21.getView()
            if (r3 == 0) goto L_0x01c6
            android.view.View r3 = r21.getView()
            com.baidu.searchbox.bookmark.NewFavorFragment$19 r6 = new com.baidu.searchbox.bookmark.NewFavorFragment$19
            r6.<init>()
            r7 = 500(0x1f4, double:2.47E-321)
            r3.postDelayed(r6, r7)
            goto L_0x01c6
        L_0x01be:
            r18 = r11
            r19 = r12
            r20 = r13
            r17 = r14
        L_0x01c6:
            r21.statFavorClick(r22, r23)
            java.lang.String r3 = r1.uKey
            r0.addVisitFavorCount(r3)
            goto L_0x01fe
        L_0x01cf:
            java.lang.String r2 = r1.dataType
            java.lang.String r3 = "2"
            boolean r2 = android.text.TextUtils.equals(r2, r3)
            if (r2 == 0) goto L_0x01fe
            com.baidu.searchbox.bookmark.favor.FavorController r2 = r0.mController
            if (r2 == 0) goto L_0x01e4
            androidx.fragment.app.FragmentActivity r3 = r21.getActivity()
            r2.openFavorDir(r1, r3)
        L_0x01e4:
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r2 = r21.getMainContainer()
            if (r2 == 0) goto L_0x01f1
            com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r2 = r21.getMainContainer()
            r2.setPendingAnimation()
        L_0x01f1:
            r2 = 0
            java.lang.String r3 = "click"
            java.lang.String r4 = "tab_fav"
            java.lang.String r5 = "read_folder"
            com.baidu.searchbox.bookmark.BookmarkUBC.event(r3, r4, r5, r2)
            goto L_0x01ff
        L_0x01fe:
        L_0x01ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.NewFavorFragment.openFavor(int, com.baidu.searchbox.favor.data.FavorModel):void");
    }

    private void addVisitFavorCount(String uKey) {
        IFavorUserAction userAction;
        if (!TextUtils.isEmpty(uKey) && (userAction = ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).getFavorUserAction()) != null) {
            userAction.visitFavor(uKey, (FavorDataCallback<Boolean>) null);
        }
    }

    public boolean checkMoveBtnEnableState() {
        FavorPlayletView favorPlayletView;
        NewFavorWebVideoView newFavorWebVideoView;
        FavorGoodsView favorGoodsView;
        if (currentSelectedIsProductType() && (favorGoodsView = this.mFavorGoodsView) != null && favorGoodsView.getVisibility() == 0) {
            return this.mFavorGoodsView.checkMoveBtnEnableState();
        }
        if (currentSelectedIsWebVideoType() && (newFavorWebVideoView = this.mFavorWebVideoView) != null && newFavorWebVideoView.getVisibility() == 0) {
            return this.mFavorWebVideoView.checkMoveBtnEnableState();
        }
        if (currentSelectedIsPlayletType() && (favorPlayletView = this.mFavorPlayletView) != null && favorPlayletView.getVisibility() == 0) {
            return this.mFavorPlayletView.checkMoveBtnEnableState();
        }
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter == null || newFavorAdapter.getSelectedCount() <= 0 || !this.mFavorAdapter.hasDir() || this.mFavorAdapter.hasDirSelected()) {
            return false;
        }
        if (DEBUG) {
            Log.d(TAG, "——> checkMoveBtnEnableState: hasDir " + this.mFavorAdapter.hasDir());
            Log.d(TAG, "——> checkMoveBtnEnableState: no dir has selected  " + (!this.mFavorAdapter.hasDirSelected()));
        }
        return true;
    }

    public boolean checkRenameBtnEnableState() {
        FavorPlayletView favorPlayletView;
        NewFavorWebVideoView newFavorWebVideoView;
        FavorGoodsView favorGoodsView;
        if (currentSelectedIsProductType() && (favorGoodsView = this.mFavorGoodsView) != null && favorGoodsView.getVisibility() == 0) {
            return this.mFavorGoodsView.checkRenameBtnEnableState();
        }
        if (currentSelectedIsWebVideoType() && (newFavorWebVideoView = this.mFavorWebVideoView) != null && newFavorWebVideoView.getVisibility() == 0) {
            return this.mFavorWebVideoView.checkRenameBtnEnableState();
        }
        if (currentSelectedIsPlayletType() && (favorPlayletView = this.mFavorPlayletView) != null && favorPlayletView.getVisibility() == 0) {
            return this.mFavorPlayletView.checkRenameBtnEnableState();
        }
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter == null || newFavorAdapter.getSelectedCount() <= 0 || this.mFavorAdapter.getSelectedCount() > 1) {
            return false;
        }
        return true;
    }

    public void doMove(String moveToDir) {
        if (!TextUtils.isEmpty(moveToDir) || getContext() == null) {
            NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
            if (newFavorAdapter != null) {
                newFavorAdapter.updateSelectedFavorsDirAsync(moveToDir, this);
                return;
            }
            return;
        }
        UniversalToast.makeText(getContext(), com.baidu.android.common.ui.style.R.string.dir_name_empty).showToast();
    }

    public void onMoved(boolean moved) {
        if (getContext() != null) {
            if (moved) {
                UniversalToast.makeText(getContext(), com.baidu.android.common.ui.style.R.string.move_success).showToast();
                if (getMainContainer() != null) {
                    getMainContainer().endEditMode();
                }
                refreshRecycleTabData();
                return;
            }
            UniversalToast.makeText(getContext(), com.baidu.android.common.ui.style.R.string.move_failed).showToast();
        }
    }

    private void onWebVideoShowUbc(boolean isFromClick) {
        String source;
        if (isFromClick) {
            source = "from_click";
        } else {
            source = "from_toast";
        }
        BookmarkUBC.event("show", "tab_fav", source, BookmarkUBC.VALUE_WEB_VIDEO_FAVOR);
    }

    /* access modifiers changed from: private */
    public void statFavorClick(int position, FavorModel clickedItem) {
        if (clickedItem != null) {
            String extString = "";
            String extData = clickedItem.getExtData();
            if (position > 0) {
                try {
                    JSONObject extJson = new JSONObject();
                    extJson.put("number", position);
                    extJson.put("page_type", "home");
                    extJson.put("classify_type", getCurClassifyName());
                    extJson.put("tplid", clickedItem.tplId);
                    extJson.put("title", clickedItem.title);
                    extJson.put("ukey", clickedItem.uKey);
                    extJson.put("from", ubcPageShowSource);
                    if (TextUtils.isEmpty(clickedItem.img)) {
                        extJson.put("is_cover", 0);
                    } else {
                        extJson.put("is_cover", 1);
                    }
                    FavorModel.Feature feature = clickedItem.feature;
                    if (feature != null) {
                        if (TextUtils.equals(feature.isDeadLink, "1")) {
                            extJson.put("is_valid", 0);
                        } else {
                            extJson.put("is_valid", 1);
                        }
                        MoviesModel moviesModel = feature.moviesModel;
                        if (moviesModel != null) {
                            String isUpdate = "0";
                            if (TextUtils.equals(moviesModel.getNeedShowBadge(), "1")) {
                                isUpdate = "1";
                            }
                            extJson.put("is_update", isUpdate);
                            extJson.put("progress", (double) getProgress(clickedItem));
                        }
                    }
                    String url = clickedItem.url;
                    if (!TextUtils.isEmpty(url)) {
                        if (url.length() > 100) {
                            extJson.put("url", url.substring(0, 100));
                        } else {
                            extJson.put("url", url);
                        }
                    }
                    extJson.putOpt("time_click", Long.valueOf(System.currentTimeMillis()));
                    try {
                        extJson.putOpt("time_enter", Long.valueOf(clickedItem.createTime));
                    } catch (Exception e2) {
                        if (AppConfig.isDebug()) {
                            e2.printStackTrace();
                        }
                        extJson.putOpt("time_enter", -1);
                    }
                    extString = extJson.toString();
                    if (!TextUtils.isEmpty(extData) && TextUtils.equals(clickedItem.tplId, "search_web_film")) {
                        JSONObject extDataJson = new JSONObject(extData);
                        String ubcJsonString = extDataJson.optString("ubcjson");
                        if (!TextUtils.isEmpty(ubcJsonString)) {
                            JSONObject ubcJson = new JSONObject(ubcJsonString);
                            String value = UserAssetsAggrUbc.VALUE_FILM;
                            if (currentSelectedIsWebVideoType()) {
                                value = UserAssetsAggrUbc.VALUE_WEB_VIDEO;
                            } else if (currentSelectedIsPlayletType()) {
                                value = "short_play";
                            }
                            ubcJson.putOpt("value", value);
                            extDataJson.putOpt("ubcjson", ubcJson.toString());
                        }
                        extData = extDataJson.toString();
                    }
                } catch (Exception e3) {
                    if (AppConfig.isDebug()) {
                        e3.printStackTrace();
                    }
                }
            }
            BookmarkUBC.itemEvent(extData, "click", "tab_fav", extString);
            BookmarkUBC.favorItemRDCEvent(clickedItem, "click", "tab_fav", String.valueOf(position));
        }
    }

    private static float getProgress(FavorModel model) {
        if (model == null || model.feature == null || model.feature.moviesModel == null) {
            return -1.0f;
        }
        FavorModel.Feature feature = model.feature;
        String playProgress = feature.moviesModel.getPlayProgress();
        if (playProgress == null) {
            return -1.0f;
        }
        try {
            return ((float) Integer.parseInt(playProgress)) / ((float) Integer.parseInt(feature.duration));
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return -1.0f;
        }
    }

    private int getUbcIndex(int realPosition) {
        return realPosition + 1;
    }

    private String getCurClassifyName() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView == null || classifyView.getSelectedClassifyModel() == null) {
            return "";
        }
        return this.mClassifyView.getSelectedClassifyModel().getTitle();
    }

    private String getCurClassifyIdentify() {
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView == null || classifyView.getSelectedClassifyModel() == null) {
            return "";
        }
        return this.mClassifyView.getSelectedClassifyModel().getIdentify();
    }

    public void onFavorEditClicked(FavorModel item) {
        this.mCurrentFavorData = item;
        if (TextUtils.equals(item.dataType, "2")) {
            this.mController.openEditDirActivity(this.mCurrentFavorData, getActivity());
        } else {
            this.mController.editFavor(this.mCurrentFavorData, getActivity(), true);
        }
    }

    public boolean isLock() {
        return this.mController.isLock();
    }

    public void setLock(boolean value) {
        this.mController.setLock(value);
    }

    public int getSelectedCount() {
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null) {
            return newFavorAdapter.getSelectedCount();
        }
        return -1;
    }

    private void asyncLoginBarViewState(boolean isEditable) {
        QuickLoginViewHelper quickLoginViewHelper;
        LoginBarContainer loginBarContainer = this.mLoginContainer;
        if (loginBarContainer != null && (quickLoginViewHelper = this.mLoginViewHelper) != null) {
            loginBarContainer.asyncVisibilityState(isEditable, quickLoginViewHelper.hasLogin());
        }
    }

    public void setPageResources() {
        FavorPlayletView favorPlayletView;
        NewFavorWebVideoView newFavorWebVideoView;
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null) {
            newFavorAdapter.notifyDataSetChanged();
        }
        CommonEmptyView commonEmptyView = this.mEmptyView;
        if (commonEmptyView != null) {
            commonEmptyView.setIcon(getResources().getDrawable(R.drawable.favor_empty_icon));
            this.mEmptyView.post(new Runnable() {
                public void run() {
                    NewFavorFragment.this.mEmptyView.setBackground((Drawable) null);
                }
            });
        }
        LoginBarContainer loginBarContainer = this.mLoginContainer;
        if (loginBarContainer != null) {
            loginBarContainer.onNightModeChange();
        }
        if (this.mEmptyDivideTemplate != null) {
            TemplateModel templateModel = new TemplateModel();
            templateModel.setFromPage("tab_fav");
            this.mEmptyDivideTemplate.update(templateModel);
        }
        if (currentSelectedIsWebVideoType() && (newFavorWebVideoView = this.mFavorWebVideoView) != null) {
            newFavorWebVideoView.updateUI();
        }
        if (currentSelectedIsPlayletType() && (favorPlayletView = this.mFavorPlayletView) != null) {
            favorPlayletView.updateUI();
        }
        View view2 = this.mShimmerLayout;
        if (view2 != null) {
            view2.setBackgroundColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.white));
        }
    }

    private void setLoginBarTips() {
        if (this.mLoginContainer != null) {
            BoxAccountManager manager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
            if (!manager.isLogin(2)) {
                this.mLoginContainer.setVisibility(0);
                if (manager.isLogin(0)) {
                    this.mLoginContainer.setLoginTips(R.string.favor_visit_login_tips_text);
                } else {
                    this.mLoginContainer.setLoginTips(R.string.favor_not_login_tips_text);
                }
            } else {
                this.mLoginContainer.setVisibility(8);
            }
            updateRecycleViewPadding();
        }
    }

    public void setEditMode(boolean isEdit) {
        this.mIsEditable = isEdit;
        if (currentSelectedIsProductType()) {
            FavorGoodsView favorGoodsView = this.mFavorGoodsView;
            if (favorGoodsView != null && favorGoodsView.getVisibility() == 0) {
                this.mFavorGoodsView.setEditMode(isEdit);
            }
        } else if (currentSelectedIsWebVideoType()) {
            NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
            if (newFavorWebVideoView != null && newFavorWebVideoView.getVisibility() == 0) {
                this.mFavorWebVideoView.setEditMode(isEdit);
            }
        } else if (currentSelectedIsPlayletType()) {
            FavorPlayletView favorPlayletView = this.mFavorPlayletView;
            if (favorPlayletView != null && favorPlayletView.getVisibility() == 0) {
                this.mFavorPlayletView.setEditMode(isEdit);
            }
        } else {
            NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
            if (newFavorAdapter != null) {
                newFavorAdapter.setEditMode(isEdit);
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
        asyncLoginBarViewState(isEdit);
        updateRecycleViewPadding();
    }

    private void updateRecycleViewPadding() {
        UserAssetsRecyclerView userAssetsRecyclerView = this.mRecyclerView;
        if (userAssetsRecyclerView != null && userAssetsRecyclerView.getVisibility() == 0) {
            UserAssetsRecyclerView userAssetsRecyclerView2 = this.mRecyclerView;
            int paddingLeft = userAssetsRecyclerView2.getPaddingLeft();
            LoginBarContainer loginBarContainer = this.mLoginContainer;
            userAssetsRecyclerView2.setPadding(paddingLeft, (loginBarContainer == null || loginBarContainer.getVisibility() != 0) ? 0 : this.mTopPadding, this.mRecyclerView.getPaddingRight(), 0);
        }
    }

    public void onSelectAll(boolean isSelectedAll) {
        if (currentSelectedIsProductType()) {
            FavorGoodsView favorGoodsView = this.mFavorGoodsView;
            if (favorGoodsView != null && favorGoodsView.getVisibility() == 0) {
                this.mFavorGoodsView.onSelectAll(isSelectedAll);
            }
        } else if (currentSelectedIsWebVideoType()) {
            NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
            if (newFavorWebVideoView != null && newFavorWebVideoView.getVisibility() == 0) {
                this.mFavorWebVideoView.onSelectAll(isSelectedAll);
            }
        } else if (currentSelectedIsPlayletType()) {
            FavorPlayletView favorPlayletView = this.mFavorPlayletView;
            if (favorPlayletView != null && favorPlayletView.getVisibility() == 0) {
                this.mFavorPlayletView.onSelectAll(isSelectedAll);
            }
        } else {
            NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
            if (newFavorAdapter != null) {
                newFavorAdapter.onSelectAll(isSelectedAll);
            }
            if (getMainContainer() != null) {
                int i2 = 0;
                getMainContainer().updateMoveBtnState(false);
                IUserAssetsContainer mainContainer = getMainContainer();
                boolean z = true;
                if (!isSelectedAll || getCountExceptSection() != 1) {
                    z = false;
                }
                mainContainer.updateRenameBtnState(z);
                if (!isEditEnable()) {
                    getMainContainer().updateDeleteBtnState(false, 0);
                    return;
                }
                IUserAssetsContainer mainContainer2 = getMainContainer();
                if (isSelectedAll) {
                    i2 = getCountExceptSection();
                }
                mainContainer2.updateDeleteBtnState(isSelectedAll, i2);
            }
        }
    }

    public void onMoveClicked() {
        BookmarkUBC.favorEditBarClickEvent(BookmarkUBC.SOURCE_MOVE_FAVOR);
        String curDir = getCurrentDir();
        if (curDir == null) {
            curDir = getString(R.string.favor_root_dir);
        }
        final String dir = curDir;
        ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).queryAllDirsNameAsync(new FavorDataCallback<List<String>>() {
            public void onResult(List<String> data) {
                if (NewFavorFragment.this.isAdded()) {
                    if (data == null) {
                        data = new ArrayList<>();
                    }
                    data.add(0, NewFavorFragment.this.getResources().getString(R.string.favor_root_dir));
                    NewFavorFragment.this.startDirSelectActivity((ArrayList) data, dir, 1);
                }
            }
        });
    }

    public void startDirSelectActivity(ArrayList<String> data, String dir, int requestCode) {
        if (getContext() != null) {
            Intent intent = new Intent(getContext(), FavorsSelectDirsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("dirs", data);
            bundle.putString("currentDir", dir);
            bundle.putInt("requestCode", requestCode);
            intent.putExtras(bundle);
            startActivityForResult(intent, requestCode);
        }
    }

    public String getCurrentDir() {
        return null;
    }

    public void onRenameClicked() {
        FavorPlayletView favorPlayletView;
        NewFavorWebVideoView newFavorWebVideoView;
        BookmarkUBC.favorEditBarClickEvent(BookmarkUBC.SOURCE_EDIT_FAVOR);
        if (currentSelectedIsWebVideoType() && (newFavorWebVideoView = this.mFavorWebVideoView) != null && newFavorWebVideoView.getVisibility() == 0) {
            this.mFavorWebVideoView.onRenameClicked();
        } else if (!currentSelectedIsPlayletType() || (favorPlayletView = this.mFavorPlayletView) == null || favorPlayletView.getVisibility() != 0) {
            LinkedHashMap<String, FavorModel> selectItems = this.mFavorAdapter.getSelectedIds();
            if (selectItems != null && selectItems.size() != 0 && selectItems.size() <= 1) {
                Collection<FavorModel> dataList = selectItems.values();
                if (dataList != null && dataList.size() != 0) {
                    FavorModel next = dataList.iterator().next();
                    this.mCurrentFavorData = next;
                    if (TextUtils.equals(next.dataType, "2")) {
                        this.mController.openEditDirActivity(this.mCurrentFavorData, getActivity());
                    } else {
                        this.mController.editFavor(this.mCurrentFavorData, getActivity(), true);
                    }
                }
            } else if (DEBUG) {
                Log.d(TAG, "——> onRenameClicked: error occurred, item count error");
            }
        } else {
            this.mFavorPlayletView.onRenameClicked();
        }
    }

    public int getCountExceptSection() {
        FavorPlayletView favorPlayletView;
        NewFavorWebVideoView newFavorWebVideoView;
        FavorGoodsView favorGoodsView;
        if (currentSelectedIsProductType() && (favorGoodsView = this.mFavorGoodsView) != null && favorGoodsView.getVisibility() == 0) {
            return this.mFavorGoodsView.getCountExceptSection();
        }
        if (currentSelectedIsWebVideoType() && (newFavorWebVideoView = this.mFavorWebVideoView) != null && newFavorWebVideoView.getVisibility() == 0) {
            return this.mFavorWebVideoView.getCountExceptSection();
        }
        if (currentSelectedIsPlayletType() && (favorPlayletView = this.mFavorPlayletView) != null && favorPlayletView.getVisibility() == 0) {
            return this.mFavorPlayletView.getCountExceptSection();
        }
        NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
        if (newFavorAdapter != null) {
            return newFavorAdapter.getItemCountWithFavorGoodFolder();
        }
        return 0;
    }

    public void onDeletedClicked() {
        if (currentSelectedIsProductType()) {
            FavorGoodsView favorGoodsView = this.mFavorGoodsView;
            if (favorGoodsView != null && favorGoodsView.getVisibility() == 0) {
                this.mFavorGoodsView.onDeletedClicked();
            }
        } else if (currentSelectedIsWebVideoType()) {
            NewFavorWebVideoView newFavorWebVideoView = this.mFavorWebVideoView;
            if (newFavorWebVideoView != null && newFavorWebVideoView.getVisibility() == 0) {
                this.mFavorWebVideoView.onDeletedClicked();
            }
        } else if (currentSelectedIsPlayletType()) {
            FavorPlayletView favorPlayletView = this.mFavorPlayletView;
            if (favorPlayletView != null && favorPlayletView.getVisibility() == 0) {
                this.mFavorPlayletView.onDeletedClicked();
            }
        } else {
            showSelectedDeleteDialog();
        }
    }

    private void showSelectedDeleteDialog() {
        NewFavorAdapter newFavorAdapter;
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && isAdded() && (newFavorAdapter = this.mFavorAdapter) != null) {
            int deleteCount = newFavorAdapter.getSelectedCount();
            new DeleteDialogWithRecycleBin(activity).showDialog("tab_fav", this.mFavorAdapter.isEditable(), getString(R.string.user_assets_favor_delete_part_message, Integer.valueOf(deleteCount)), new IDeleteDialogWithRecycleCallback() {
                public void onCancelClicked() {
                    BookmarkUBC.favorDeleteEvent("cancel");
                }

                public void onDeleteClicked(boolean isSelectedRecycle) {
                    if (NewFavorFragment.this.mFavorAdapter != null) {
                        if (isSelectedRecycle) {
                            IRecycleBinFace recycleBinFace = (IRecycleBinFace) ServiceManager.getService(IRecycleBinFace.Companion.getSERVICE_REFERENCE());
                            if (recycleBinFace != null) {
                                recycleBinFace.recordHasAddedRecycleBin();
                            }
                            if (NewFavorFragment.this.getMainContainer() != null) {
                                NewFavorFragment.this.getMainContainer().tryShowNewTips();
                            }
                        }
                        int deleteCount = NewFavorFragment.this.mFavorAdapter.getSelectedCount();
                        NewFavorFragment.this.mFavorAdapter.deleteBookMarksAsync(Boolean.valueOf(isSelectedRecycle), NewFavorFragment.this.getMainContainer(), new NewFavorAdapter.ITryLoadNextPage() {
                            public void onTryLoadNextPage() {
                                NewFavorFragment.this.tryLoadNextPage(NewFavorFragment.this.mRecyclerView);
                            }
                        });
                        FavorSyncUBC.uploadUserDeleteFavorCount(NewFavorFragment.TAG, deleteCount);
                    }
                    BookmarkUBC.favorDeleteEvent("confirm");
                }
            });
        }
    }

    public void onFavorDataChanged() {
        NewFavorAdapter newFavorAdapter;
        if (getMainContainer() != null && (newFavorAdapter = this.mFavorAdapter) != null) {
            newFavorAdapter.notifyDataSetChanged();
            getMainContainer().updateEditBtnState();
        }
    }

    public boolean invokeLoginOnCreate(Context context) {
        if (!UserAssetsSharedPrefs.INSTANCE.getBoolean(UserAssetsCommandListenerKt.KEY_FAVOR_LOGIN_SWITCH, false) || ((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin(2)) {
            return false;
        }
        QuickLoginViewHelper.gotoBDLogin(context, BookmarkUBC.FAVOR_SOURCE_ENTER_NOT_LOGIN, (ILoginResultListener) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean canMoveItem() {
        return !currentSelectedIsProductType() && !currentSelectedIsWebVideoType() && !currentSelectedIsPlayletType();
    }

    /* access modifiers changed from: protected */
    public boolean canRenameItem() {
        return !currentSelectedIsProductType();
    }

    public void onFragmentSeleted() {
        ClassifyModel selectedClassifyModel;
        BoxAccountManager loginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (loginManager != null && !loginManager.isLogin(2)) {
            AccountQuickLoginEvent event = new AccountQuickLoginEvent();
            event.setEventType(1);
            event.putParam("source", BookmarkUBC.FAVOR_SOURCE_CLICK_NOT_LOGIN);
            BdEventBus.Companion.getDefault().post(event);
        }
        BookmarkUBC.favorShowEvent(ubcPageShowSource);
        RevisitStatisticUtil.INSTANCE.favorShowEvent(ubcPageShowSource);
        updateBottomBarVisibility(true);
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView != null && (selectedClassifyModel = classifyView.getSelectedClassifyModel()) != null) {
            BookmarkUBC.favorShowEvent(ubcPageShowSource, selectedClassifyModel.getUbcSource());
        }
    }

    private void updateFontSize() {
        if (AppConfig.isDebug()) {
            Log.d(TAG, "刷新字号");
        }
        ClassifyView classifyView = this.mClassifyView;
        if (classifyView != null) {
            classifyView.updateFontSize();
        }
        if (this.mEmptyDivideTemplate != null) {
            TemplateModel templateModel = new TemplateModel();
            templateModel.setFromPage("tab_fav");
            this.mEmptyDivideTemplate.update(templateModel);
        }
    }

    /* access modifiers changed from: private */
    public boolean currentSelectedIsProductType() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !"product".equals(classifyModel.getIdentify())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean currentSelectedIsWebVideoType() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !"search_web_video".equals(classifyModel.getIdentify())) {
            return false;
        }
        return true;
    }

    private boolean currentSelectedIsPlayletType() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || !"feed_playlet".equals(classifyModel.getIdentify())) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean currentSelectedTabIsRecyclerView() {
        ClassifyModel classifyModel = this.currentClassifyModel;
        if (classifyModel == null || "search_web_video".equals(classifyModel.getIdentify()) || "product".equals(this.currentClassifyModel.getIdentify())) {
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
                    if (NewFavorFragment.this.mBookmarkView != null && NewFavorFragment.this.mEmptyView != null) {
                        if (NewFavorFragment.this.getContext() != null && NewFavorFragment.this.mEmptyDivideTemplate == null && NewFavorFragment.this.mEmptyView.mBottomLayout.getChildCount() == 0) {
                            ITemplate unused = NewFavorFragment.this.mEmptyDivideTemplate = TemplateCreatorKt.createTemplate(TemplateEnum.BISERIAL_DIVIDE);
                            View emptyDivideView = NewFavorFragment.this.mEmptyDivideTemplate.createView(NewFavorFragment.this.mEmptyView.mBottomLayout);
                            emptyDivideView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                            NewFavorFragment.this.mEmptyView.mBottomLayout.addView(emptyDivideView);
                            ViewGroup.LayoutParams bottomLayoutParams = NewFavorFragment.this.mEmptyView.mBottomLayout.getLayoutParams();
                            if (bottomLayoutParams != null) {
                                bottomLayoutParams.width = -1;
                                NewFavorFragment.this.mEmptyView.mBottomLayout.setLayoutParams(bottomLayoutParams);
                            }
                            NewFavorFragment.this.mEmptyView.mBottomLayout.setClickable(false);
                        }
                        if (NewFavorFragment.this.mBookmarkView.findViewById(R.id.favor_app_bar_layout) != null && (lp = NewFavorFragment.this.mEmptyView.getLayoutParams()) != null && (lp instanceof FrameLayout.LayoutParams) && NewFavorFragment.this.isAdded()) {
                            try {
                                ((FrameLayout.LayoutParams) lp).topMargin = 0;
                                if (NewFavorFragment.this.mEmptyDivideTemplate != null) {
                                    NewFavorFragment.this.mEmptyView.mBottomLayout.setVisibility(8);
                                }
                                NewFavorFragment.this.mEmptyView.setLayoutParams(lp);
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

    private boolean isFragmentVisible() {
        if (getMainContainer() != null) {
            return getMainContainer().isCurrentFragmentVisible(this);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isFavorHisFragment() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isFavorFragment() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean classifySelectAll() {
        return TextUtils.equals(getCurClassifyIdentify(), "all");
    }

    /* access modifiers changed from: protected */
    public void openNewBuildPage() {
        ActivityUtils.startActivitySafely(getContext(), new Intent(getContext(), BookmarkDirEditActivity.class));
    }

    /* access modifiers changed from: protected */
    public boolean isEditEnable() {
        if (!currentSelectedIsProductType() && !currentSelectedIsWebVideoType() && !currentSelectedIsPlayletType()) {
            NewFavorAdapter newFavorAdapter = this.mFavorAdapter;
            return (newFavorAdapter == null || newFavorAdapter.getData() == null || this.mFavorAdapter.getData().size() <= 0) ? false : true;
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

    public static String getNewFavorUbcSource() {
        return ubcPageShowSource;
    }
}
