package com.baidu.searchbox.bookmark.favor.webvideo;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.dialog.BdProgressDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.bookmark.BookmarkUBC;
import com.baidu.searchbox.bookmark.adapter.FavorWebVideoAdapter;
import com.baidu.searchbox.bookmark.favor.FavorController;
import com.baidu.searchbox.boxshare.BoxShareManager;
import com.baidu.searchbox.boxshare.listener.OnBoxShareListenerAdapter;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.favor.IFavorList;
import com.baidu.searchbox.favor.IFavorManager;
import com.baidu.searchbox.favor.callback.FavorDataCallback;
import com.baidu.searchbox.favor.callback.SyncCallback;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favor.data.QueryType;
import com.baidu.searchbox.favor.data.SyncType;
import com.baidu.searchbox.favor.i.IFavorUserAction;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskStatusEnum;
import com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel;
import com.baidu.searchbox.ui.BdShimmerView;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.searchbox.ui.pullrefresh.LoadingLayout;
import com.baidu.searchbox.userassetsaggr.container.FavorHisChildViewInterface;
import com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer;
import com.baidu.searchbox.userassetsaggr.container.WebVideoPlayActivity;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel;
import com.baidu.searchbox.userassetsaggr.container.classify.ClassifyViewPage;
import com.baidu.searchbox.userassetsaggr.container.data.FavorHisIncognitoManagerKt;
import com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration;
import com.baidu.searchbox.userassetsaggr.container.recyclebin.DeleteDialogWithRecycleBin;
import com.baidu.searchbox.userassetsaggr.container.share.ShareModel;
import com.baidu.searchbox.userassetsaggr.container.share.ShareUtil;
import com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView;
import com.baidu.searchbox.userassetsaggr.container.webvideo.FavorHisWebVideoNetDiskManager;
import com.baidu.searchbox.userassetsaggr.container.webvideo.RecycleCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Metadata(d1 = {"\u0000ç\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0011*\u0001(\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0006\u0010A\u001a\u00020$J\u0006\u0010B\u001a\u00020$J\u0018\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020$2\b\u0010E\u001a\u0004\u0018\u000106J+\u0010F\u001a\u00020>2!\u0010G\u001a\u001d\u0012\u0013\u0012\u001104¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0004\u0012\u00020$0HH\u0002J\u0012\u0010L\u001a\u00020>2\b\u0010K\u001a\u0004\u0018\u000104H\u0002J\u0006\u0010M\u001a\u00020\u000bJ\u0006\u0010N\u001a\u00020$J\u001e\u0010O\u001a\u00020>2\u0006\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020$J\n\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010U\u001a\u00020\u000bH\u0002J\u001a\u0010V\u001a\u00020>2\u0006\u0010W\u001a\u00020\u000b2\b\u0010X\u001a\u0004\u0018\u000104H\u0002J$\u0010Y\u001a\u00020>2\u0006\u0010W\u001a\u00020\u000b2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010K\u001a\u0004\u0018\u000104H\u0002J\b\u0010\\\u001a\u00020>H\u0002J\u0006\u0010]\u001a\u00020>J\u0006\u0010^\u001a\u00020>J(\u0010_\u001a\u00020>2\u0006\u0010P\u001a\u00020@2\u0006\u0010R\u001a\u00020$2\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010aH\u0002J\u0006\u0010c\u001a\u00020>J\u0006\u0010d\u001a\u00020>J\u000e\u0010e\u001a\u00020>2\u0006\u0010f\u001a\u00020$J\u0010\u0010g\u001a\u00020>2\u0006\u0010K\u001a\u00020bH\u0002J\u0016\u0010h\u001a\u00020>2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020j0aH\u0017J\u0016\u0010k\u001a\u00020>2\f\u0010l\u001a\b\u0012\u0004\u0012\u00020@0mH\u0002J\u000e\u0010n\u001a\u00020>2\u0006\u0010o\u001a\u00020\u0014J\u000e\u0010p\u001a\u00020>2\u0006\u0010q\u001a\u00020$J\u0016\u0010r\u001a\u00020>2\u0006\u0010s\u001a\u00020\u000b2\u0006\u0010t\u001a\u00020\u000bJ\u000e\u0010u\u001a\u00020>2\u0006\u0010v\u001a\u00020\u0017J\u000e\u0010w\u001a\u00020>2\u0006\u0010x\u001a\u00020<J\u0010\u0010y\u001a\u00020>2\u0006\u0010z\u001a\u00020$H\u0002J\b\u0010{\u001a\u00020>H\u0002J\b\u0010|\u001a\u00020>H\u0002J\u0006\u0010}\u001a\u00020>R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020403X\u0004¢\u0006\u0002\n\u0000R\u001c\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/userassetsaggr/container/FavorHisChildViewInterface;", "Lcom/baidu/searchbox/userassetsaggr/container/webvideo/RecycleCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "favorWebVideoDividerItem", "Lcom/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoDividerItem;", "mAdapter", "Lcom/baidu/searchbox/bookmark/adapter/FavorWebVideoAdapter;", "mBdProgressDialog", "Lcom/baidu/android/ext/widget/dialog/BdProgressDialog;", "mClassifyModel", "Lcom/baidu/searchbox/userassetsaggr/container/classify/ClassifyModel;", "mContext", "mController", "Lcom/baidu/searchbox/bookmark/favor/FavorController;", "mEmptyView", "Lcom/baidu/searchbox/ui/CommonEmptyView;", "mFooterLoadingLayout", "Lcom/baidu/searchbox/ui/pullrefresh/LoadingLayout;", "mIFavorManager", "Lcom/baidu/searchbox/favor/IFavorManager;", "kotlin.jvm.PlatformType", "getMIFavorManager", "()Lcom/baidu/searchbox/favor/IFavorManager;", "mIFavorManager$delegate", "Lkotlin/Lazy;", "mIsFirstGetData", "", "mItemDecoration", "Lcom/baidu/searchbox/userassetsaggr/container/decoration/divider/DividerDecoration;", "mItemListener", "com/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoView$mItemListener$1", "Lcom/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoView$mItemListener$1;", "mLoadingIcon", "Lcom/baidu/searchbox/ui/BdShimmerView;", "mPullToRefresh", "Lcom/baidu/searchbox/userassetsaggr/container/ui/PullToRefreshRecyclerView;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mShareManager", "Lcom/baidu/searchbox/boxshare/BoxShareManager;", "mWebVideoDataList", "", "Lcom/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoModel;", "mainContainer", "Lcom/baidu/searchbox/userassetsaggr/container/IUserAssetsContainer;", "getMainContainer", "()Lcom/baidu/searchbox/userassetsaggr/container/IUserAssetsContainer;", "setMainContainer", "(Lcom/baidu/searchbox/userassetsaggr/container/IUserAssetsContainer;)V", "onWebVideoUbcListener", "Lcom/baidu/searchbox/bookmark/favor/webvideo/FavorWebVideoUbcListener;", "addVisitFavorCount", "", "uKey", "", "checkMoveBtnEnableState", "checkRenameBtnEnableState", "deleteBookMarksAsync", "isMoveToRecycleBin", "listener", "deleteDataSafe", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "model", "doFavorNetDiskViewClickUbc", "getCountExceptSection", "getCurrentIsEditable", "getFavorWebVideoData", "lastUkey", "pageSize", "isRefreshStockData", "getRecyclerView", "Landroid/view/View;", "getSelectCount", "handleClickListener", "position", "clickedItem", "handleMenuClick", "menuItem", "Lcom/baidu/android/common/menu/CommonMenuItem;", "initView", "onDeletedClicked", "onDestroy", "onQueryStatusCallback", "data", "", "Lcom/baidu/searchbox/favor/data/FavorModel;", "onRenameClicked", "onResume", "onSelectAll", "isSelectedAll", "onShareClicked", "refreshList", "snifferNetDiskTaskModelList", "Lcom/baidu/searchbox/sniffer/model/SnifferNetDiskTaskModel;", "removeItem", "selectedIds", "", "setClassifyModel", "classifyModel", "setEditMode", "isEdit", "setEmptyViewHeight", "height", "topMargin", "setFavorDataController", "controller", "setWebVideoUbcListener", "ubcListener", "showDeleteResultToast", "isDeleteSuccess", "showSelectedDeleteDialog", "triggerFavorSync", "updateUI", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorWebVideoView.kt */
public final class FavorWebVideoView extends FrameLayout implements FavorHisChildViewInterface, RecycleCallback {
    public Map<Integer, View> _$_findViewCache;
    private FavorWebVideoDividerItem favorWebVideoDividerItem;
    /* access modifiers changed from: private */
    public FavorWebVideoAdapter mAdapter;
    /* access modifiers changed from: private */
    public BdProgressDialog mBdProgressDialog;
    private ClassifyModel mClassifyModel;
    private final Context mContext;
    private FavorController mController;
    private CommonEmptyView mEmptyView;
    private LoadingLayout mFooterLoadingLayout;
    private final Lazy mIFavorManager$delegate;
    private volatile boolean mIsFirstGetData;
    private DividerDecoration mItemDecoration;
    private final FavorWebVideoView$mItemListener$1 mItemListener;
    private BdShimmerView mLoadingIcon;
    private PullToRefreshRecyclerView mPullToRefresh;
    /* access modifiers changed from: private */
    public RecyclerView mRecyclerView;
    private BoxShareManager mShareManager;
    /* access modifiers changed from: private */
    public final List<FavorWebVideoModel> mWebVideoDataList;
    private IUserAssetsContainer mainContainer;
    private FavorWebVideoUbcListener onWebVideoUbcListener;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FavorWebVideoView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SnifferNetDiskStatusEnum.values().length];
            iArr[SnifferNetDiskStatusEnum.TRANSLOAD_COMPLETED.ordinal()] = 1;
            iArr[SnifferNetDiskStatusEnum.TRANSLOAD_NORMAL.ordinal()] = 2;
            iArr[SnifferNetDiskStatusEnum.TRANSLOADING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final IUserAssetsContainer getMainContainer() {
        return this.mainContainer;
    }

    public final void setMainContainer(IUserAssetsContainer iUserAssetsContainer) {
        this.mainContainer = iUserAssetsContainer;
    }

    private final IFavorManager getMIFavorManager() {
        return (IFavorManager) this.mIFavorManager$delegate.getValue();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FavorWebVideoView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FavorWebVideoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FavorWebVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.mWebVideoDataList = new ArrayList();
        this.mIsFirstGetData = true;
        this.mIFavorManager$delegate = LazyKt.lazy(FavorWebVideoView$mIFavorManager$2.INSTANCE);
        this.mItemListener = new FavorWebVideoView$mItemListener$1(this);
        this.mContext = context;
        initView();
        FavorHisWebVideoNetDiskManager.INSTANCE.addRecycleCallback(this);
    }

    /* JADX WARNING: type inference failed for: r1v20, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView() {
        /*
            r10 = this;
            android.content.Context r0 = r10.mContext
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.baidu.searchbox.favor.R.layout.favor_web_video_view_layout
            r2 = r10
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r0 = r0.inflate(r1, r2)
            int r1 = com.baidu.searchbox.favor.R.id.shimmerView
            android.view.View r1 = r0.findViewById(r1)
            com.baidu.searchbox.ui.BdShimmerView r1 = (com.baidu.searchbox.ui.BdShimmerView) r1
            r10.mLoadingIcon = r1
            int r1 = com.baidu.searchbox.favor.R.id.pullToRefresh
            android.view.View r1 = r0.findViewById(r1)
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = (com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView) r1
            r10.mPullToRefresh = r1
            int r1 = com.baidu.searchbox.favor.R.id.webVideoEmptyView
            android.view.View r1 = r0.findViewById(r1)
            com.baidu.searchbox.ui.CommonEmptyView r1 = (com.baidu.searchbox.ui.CommonEmptyView) r1
            r10.mEmptyView = r1
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = r10.mPullToRefresh
            r2 = 0
            if (r1 == 0) goto L_0x0037
            com.baidu.searchbox.ui.pullrefresh.LoadingLayout r1 = r1.getFooterLoadingLayout()
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            r10.mFooterLoadingLayout = r1
            com.baidu.searchbox.ui.CommonEmptyView r1 = r10.mEmptyView
            if (r1 == 0) goto L_0x004b
            android.content.res.Resources r3 = r10.getResources()
            int r4 = com.baidu.searchbox.favor.R.string.bookmark_empty_text
            java.lang.String r3 = r3.getString(r4)
            r1.setTitle((java.lang.String) r3)
        L_0x004b:
            com.baidu.searchbox.ui.CommonEmptyView r1 = r10.mEmptyView
            if (r1 == 0) goto L_0x0054
            int r3 = com.baidu.searchbox.favor.R.drawable.favor_empty_icon
            r1.setIcon((int) r3)
        L_0x0054:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = r10.mPullToRefresh
            r3 = 0
            if (r1 != 0) goto L_0x005a
            goto L_0x005d
        L_0x005a:
            r1.setPullRefreshEnabled(r3)
        L_0x005d:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = r10.mPullToRefresh
            r4 = 1
            if (r1 != 0) goto L_0x0063
            goto L_0x0066
        L_0x0063:
            r1.setPullLoadEnabled(r4)
        L_0x0066:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = r10.mPullToRefresh
            if (r1 == 0) goto L_0x0077
            android.content.Context r5 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            r6 = 1116471296(0x428c0000, float:70.0)
            int r5 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r5, r6)
            r1.setMaxPullOffset(r5)
        L_0x0077:
            com.baidu.searchbox.ui.pullrefresh.LoadingLayout r1 = r10.mFooterLoadingLayout
            if (r1 == 0) goto L_0x007e
            r1.setHeaderBackgroundColor(r3)
        L_0x007e:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r1 = r10.mPullToRefresh
            if (r1 == 0) goto L_0x0089
            android.view.View r1 = r1.getRefreshableView()
            r2 = r1
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
        L_0x0089:
            r10.mRecyclerView = r2
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r10.mContext
            r1.<init>(r2)
            androidx.recyclerview.widget.RecyclerView r2 = r10.mRecyclerView
            if (r2 != 0) goto L_0x0097
            goto L_0x009d
        L_0x0097:
            r5 = r1
            androidx.recyclerview.widget.RecyclerView$LayoutManager r5 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r5
            r2.setLayoutManager(r5)
        L_0x009d:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r2 = r10.mPullToRefresh
            if (r2 == 0) goto L_0x00a4
            r2.setLayoutManager(r1)
        L_0x00a4:
            com.baidu.searchbox.userassetsaggr.container.ui.PullToRefreshRecyclerView r2 = r10.mPullToRefresh
            if (r2 == 0) goto L_0x00b2
            com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView$initView$1 r5 = new com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView$initView$1
            r5.<init>(r10)
            com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew$OnRefreshListener r5 = (com.baidu.searchbox.ui.pullrefresh.PullToRefreshBaseNew.OnRefreshListener) r5
            r2.setOnRefreshListener(r5)
        L_0x00b2:
            android.content.Context r2 = r10.getContext()
            if (r2 == 0) goto L_0x00e8
            r5 = 0
            com.baidu.android.ext.widget.dialog.BdProgressDialog r6 = new com.baidu.android.ext.widget.dialog.BdProgressDialog
            r6.<init>(r2)
            r10.mBdProgressDialog = r6
            com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoDividerItem r6 = new com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoDividerItem
            r6.<init>(r2)
            r10.favorWebVideoDividerItem = r6
            r6.onNightModeChange(r2)
            com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration r6 = new com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration
            com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoDividerItem r7 = r10.favorWebVideoDividerItem
            com.baidu.searchbox.userassetsaggr.container.decoration.divider.IDividerItem r7 = (com.baidu.searchbox.userassetsaggr.container.decoration.divider.IDividerItem) r7
            r6.<init>(r2, r7)
            r10.mItemDecoration = r6
            r6.setIsHideDivider(r4)
            com.baidu.searchbox.userassetsaggr.container.decoration.divider.DividerDecoration r6 = r10.mItemDecoration
            if (r6 == 0) goto L_0x00e7
            r7 = 0
            androidx.recyclerview.widget.RecyclerView r8 = r10.mRecyclerView
            if (r8 == 0) goto L_0x00e7
            r9 = r6
            androidx.recyclerview.widget.RecyclerView$ItemDecoration r9 = (androidx.recyclerview.widget.RecyclerView.ItemDecoration) r9
            r8.addItemDecoration(r9)
        L_0x00e7:
        L_0x00e8:
            com.baidu.searchbox.bookmark.adapter.FavorWebVideoAdapter r2 = new com.baidu.searchbox.bookmark.adapter.FavorWebVideoAdapter
            r2.<init>()
            r10.mAdapter = r2
            androidx.recyclerview.widget.RecyclerView r5 = r10.mRecyclerView
            if (r5 != 0) goto L_0x00f5
            goto L_0x00fa
        L_0x00f5:
            androidx.recyclerview.widget.RecyclerView$Adapter r2 = (androidx.recyclerview.widget.RecyclerView.Adapter) r2
            r5.setAdapter(r2)
        L_0x00fa:
            com.baidu.searchbox.bookmark.adapter.FavorWebVideoAdapter r2 = r10.mAdapter
            if (r2 == 0) goto L_0x0105
            com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView$mItemListener$1 r5 = r10.mItemListener
            com.baidu.searchbox.bookmark.favor.webvideo.OnFavorWebVideoItemClickListener r5 = (com.baidu.searchbox.bookmark.favor.webvideo.OnFavorWebVideoItemClickListener) r5
            r2.setItemClick(r5)
        L_0x0105:
            com.baidu.searchbox.ui.BdShimmerView r2 = r10.mLoadingIcon
            if (r2 != 0) goto L_0x010a
            goto L_0x010d
        L_0x010a:
            r2.setVisibility(r3)
        L_0x010d:
            boolean r2 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r2 == 0) goto L_0x011b
            com.baidu.searchbox.ui.BdShimmerView r2 = r10.mLoadingIcon
            if (r2 == 0) goto L_0x0122
            r2.setType(r3)
            goto L_0x0122
        L_0x011b:
            com.baidu.searchbox.ui.BdShimmerView r2 = r10.mLoadingIcon
            if (r2 == 0) goto L_0x0122
            r2.setType(r4)
        L_0x0122:
            com.baidu.searchbox.ui.BdShimmerView r2 = r10.mLoadingIcon
            if (r2 == 0) goto L_0x0129
            r2.startShimmerAnimation()
        L_0x0129:
            r10.updateUI()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView.initView():void");
    }

    public final void onResume() {
        if (!this.mIsFirstGetData) {
            String lastUkey = "";
            int pageSize = 20;
            boolean isRefreshStockData = false;
            if (!this.mWebVideoDataList.isEmpty()) {
                String str = this.mWebVideoDataList.get(this.mWebVideoDataList.size() - 1).getFavor().uKey;
                Intrinsics.checkNotNullExpressionValue(str, "mWebVideoDataList[size - 1].favor.uKey");
                lastUkey = str;
                pageSize = 0;
                isRefreshStockData = true;
            }
            getFavorWebVideoData(lastUkey, pageSize, isRefreshStockData);
        }
    }

    public final void onDestroy() {
        BoxShareManager boxShareManager = this.mShareManager;
        if (boxShareManager != null) {
            boxShareManager.clean();
        }
        FavorHisWebVideoNetDiskManager.INSTANCE.removeRecycleCallback(this);
    }

    public final void updateUI() {
        FavorWebVideoDividerItem favorWebVideoDividerItem2 = this.favorWebVideoDividerItem;
        if (favorWebVideoDividerItem2 != null) {
            favorWebVideoDividerItem2.onNightModeChange(this.mContext);
        }
        LoadingLayout loadingLayout = this.mFooterLoadingLayout;
        if (loadingLayout != null) {
            loadingLayout.setBackgroundColor(getResources().getColor(R.color.GC9));
        }
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            favorWebVideoAdapter.notifyDataSetChanged();
        }
    }

    public final void getFavorWebVideoData(String lastUkey, int pageSize, boolean isRefreshStockData) {
        Intrinsics.checkNotNullParameter(lastUkey, "lastUkey");
        FavorWebVideoView$getFavorWebVideoData$callback$1 callback = new FavorWebVideoView$getFavorWebVideoData$callback$1(this, lastUkey, isRefreshStockData);
        if (!isRefreshStockData) {
            getMIFavorManager().queryAndUpdateFavorPartData(QueryType.LOCAL, "search_web_video", lastUkey, pageSize, callback);
        } else {
            getMIFavorManager().updateListDataIfChange("search_web_video", lastUkey, callback);
        }
        if (this.mIsFirstGetData) {
            this.mIsFirstGetData = false;
        }
    }

    /* access modifiers changed from: private */
    public final void onQueryStatusCallback(String lastUkey, boolean isRefreshStockData, List<? extends FavorModel> data) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        BdShimmerView bdShimmerView = this.mLoadingIcon;
        boolean z = true;
        if (bdShimmerView != null && bdShimmerView.getVisibility() == 0) {
            BdShimmerView bdShimmerView2 = this.mLoadingIcon;
            if (bdShimmerView2 != null) {
                bdShimmerView2.stopShimmerAnimation();
            }
            BdShimmerView bdShimmerView3 = this.mLoadingIcon;
            if (bdShimmerView3 != null) {
                bdShimmerView3.setVisibility(8);
            }
        }
        if ((lastUkey.length() == 0) || isRefreshStockData) {
            PullToRefreshRecyclerView pullToRefreshRecyclerView2 = this.mPullToRefresh;
            if (pullToRefreshRecyclerView2 != null) {
                pullToRefreshRecyclerView2.onPullDownRefreshComplete(false);
            }
        } else {
            PullToRefreshRecyclerView pullToRefreshRecyclerView3 = this.mPullToRefresh;
            if (pullToRefreshRecyclerView3 != null) {
                pullToRefreshRecyclerView3.onPullUpRefreshComplete();
            }
        }
        if (this.mWebVideoDataList.isEmpty()) {
            PullToRefreshRecyclerView pullToRefreshRecyclerView4 = this.mPullToRefresh;
            if (pullToRefreshRecyclerView4 != null) {
                pullToRefreshRecyclerView4.setVisibility(8);
            }
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            CommonEmptyView commonEmptyView = this.mEmptyView;
            if (commonEmptyView != null) {
                commonEmptyView.setVisibility(0);
            }
        } else {
            PullToRefreshRecyclerView pullToRefreshRecyclerView5 = this.mPullToRefresh;
            if (pullToRefreshRecyclerView5 != null) {
                pullToRefreshRecyclerView5.setVisibility(0);
            }
            RecyclerView recyclerView2 = this.mRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setVisibility(0);
            }
            CommonEmptyView commonEmptyView2 = this.mEmptyView;
            if (commonEmptyView2 != null) {
                commonEmptyView2.setVisibility(8);
            }
            FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
            if (favorWebVideoAdapter != null) {
                favorWebVideoAdapter.setData(this.mWebVideoDataList);
            }
        }
        if (!isRefreshStockData && (pullToRefreshRecyclerView = this.mPullToRefresh) != null) {
            Collection collection = data;
            pullToRefreshRecyclerView.setPullLoadEnabled(!(collection == null || collection.isEmpty()) && data.size() % 20 == 0);
        }
        DividerDecoration dividerDecoration = this.mItemDecoration;
        if (dividerDecoration != null) {
            Collection collection2 = data;
            if (!(collection2 == null || collection2.isEmpty()) && data.size() % 20 == 0) {
                z = false;
            }
            dividerDecoration.needLoadEndDivider(z);
        }
        IUserAssetsContainer iUserAssetsContainer = this.mainContainer;
        if (iUserAssetsContainer != null) {
            iUserAssetsContainer.updateEditBtnState();
        }
    }

    public final void setEditMode(boolean isEdit) {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            favorWebVideoAdapter.setEditMode(isEdit);
        }
    }

    public final void setEmptyViewHeight(int height, int topMargin) {
        CommonEmptyView commonEmptyView = this.mEmptyView;
        FrameLayout.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = commonEmptyView != null ? commonEmptyView.getLayoutParams() : null;
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        }
        if (layoutParams != null) {
            FrameLayout.LayoutParams lp = layoutParams;
            lp.topMargin = -topMargin;
            lp.height = height;
            CommonEmptyView commonEmptyView2 = this.mEmptyView;
            if (commonEmptyView2 != null) {
                commonEmptyView2.setLayoutParams(lp);
            }
        }
    }

    public View getRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r10.getNetDiskModel();
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078 A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009a A[Catch:{ Exception -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009f A[Catch:{ Exception -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void doFavorNetDiskViewClickUbc(com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoModel r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x000e
            com.baidu.searchbox.sniffer.model.SnifferNetDiskTaskModel r1 = r10.getNetDiskModel()
            if (r1 == 0) goto L_0x000e
            com.baidu.searchbox.sniffer.model.SnifferNetDiskStatusEnum r1 = r1.getStatus()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            if (r1 != 0) goto L_0x0013
            r1 = -1
            goto L_0x001b
        L_0x0013:
            int[] r2 = com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r2[r1]
        L_0x001b:
            switch(r1) {
                case 1: goto L_0x002a;
                case 2: goto L_0x0026;
                case 3: goto L_0x0022;
                default: goto L_0x001e;
            }
        L_0x001e:
            java.lang.String r1 = "wangpan_fail"
            goto L_0x002d
        L_0x0022:
            java.lang.String r1 = "wangpan_start"
            goto L_0x002d
        L_0x0026:
            java.lang.String r1 = "wangpan_todo"
            goto L_0x002d
        L_0x002a:
            java.lang.String r1 = "wangpan_done"
        L_0x002d:
            java.lang.String r2 = ""
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c7 }
            r3.<init>()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "title"
            if (r10 == 0) goto L_0x0044
            com.baidu.searchbox.favor.data.FavorModel r5 = r10.getFavor()     // Catch:{ Exception -> 0x00c7 }
            if (r5 == 0) goto L_0x0044
            java.lang.String r5 = r5.title     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0045
        L_0x0044:
            r5 = r0
        L_0x0045:
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r4 = "tplid"
            if (r10 == 0) goto L_0x0056
            com.baidu.searchbox.favor.data.FavorModel r5 = r10.getFavor()     // Catch:{ Exception -> 0x00c7 }
            if (r5 == 0) goto L_0x0056
            java.lang.String r5 = r5.tplId     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0057
        L_0x0056:
            r5 = r0
        L_0x0057:
            r3.put(r4, r5)     // Catch:{ Exception -> 0x00c7 }
            if (r10 == 0) goto L_0x0065
            com.baidu.searchbox.favor.data.FavorModel r4 = r10.getFavor()     // Catch:{ Exception -> 0x00c7 }
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = r4.url     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0066
        L_0x0065:
            r4 = r0
        L_0x0066:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00c7 }
            r6 = 0
            if (r5 == 0) goto L_0x0075
            int r5 = r5.length()     // Catch:{ Exception -> 0x00c7 }
            if (r5 != 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r5 = r6
            goto L_0x0076
        L_0x0075:
            r5 = 1
        L_0x0076:
            if (r5 != 0) goto L_0x0094
            int r5 = r4.length()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r7 = "url"
            r8 = 100
            if (r5 <= r8) goto L_0x0091
            java.lang.String r5 = r4.substring(r6, r8)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r6 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x00c7 }
            r3.put(r7, r5)     // Catch:{ Exception -> 0x00c7 }
            goto L_0x0094
        L_0x0091:
            r3.put(r7, r4)     // Catch:{ Exception -> 0x00c7 }
        L_0x0094:
            java.lang.String r5 = "classify_type"
            com.baidu.searchbox.userassetsaggr.container.classify.ClassifyModel r6 = r9.mClassifyModel     // Catch:{ Exception -> 0x00c7 }
            if (r6 == 0) goto L_0x009f
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x00c7 }
            goto L_0x00a0
        L_0x009f:
            r6 = r0
        L_0x00a0:
            r3.put(r5, r6)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r5 = "ukey"
            if (r10 == 0) goto L_0x00b0
            com.baidu.searchbox.favor.data.FavorModel r6 = r10.getFavor()     // Catch:{ Exception -> 0x00c7 }
            if (r6 == 0) goto L_0x00b0
            java.lang.String r0 = r6.uKey     // Catch:{ Exception -> 0x00c7 }
        L_0x00b0:
            r3.put(r5, r0)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = "page_type"
            java.lang.String r5 = "home"
            r3.put(r0, r5)     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x00c7 }
            java.lang.String r5 = "extJson.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)     // Catch:{ Exception -> 0x00c7 }
            r2 = r0
            goto L_0x00d1
        L_0x00c7:
            r0 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x00d1
            r0.printStackTrace()
        L_0x00d1:
            java.lang.String r0 = "click"
            java.lang.String r3 = "tab_fav"
            java.lang.String r4 = "liuchangbo"
            com.baidu.searchbox.bookmark.BookmarkUBC.event(r0, r3, r4, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView.doFavorNetDiskViewClickUbc(com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoModel):void");
    }

    /* access modifiers changed from: private */
    public final void handleClickListener(int position, FavorWebVideoModel clickedItem) {
        if (clickedItem != null) {
            FavorWebVideoModel currentModel = clickedItem;
            FavorWebVideoAdapter webVideoAdapter = this.mAdapter;
            if (webVideoAdapter == null) {
                return;
            }
            if (webVideoAdapter.isEditable()) {
                boolean checked = webVideoAdapter.toggleCheck(currentModel);
                IUserAssetsContainer it = this.mainContainer;
                if (it != null) {
                    boolean z = true;
                    it.updateAllSelectedBtnState(checked && webVideoAdapter.isAllSelected());
                    if (getSelectCount() <= 0) {
                        z = false;
                    }
                    it.updateDeleteBtnState(z, getSelectCount());
                    it.updateRenameBtnState(checkRenameBtnEnableState());
                    return;
                }
                return;
            }
            Context it2 = getContext();
            String str = null;
            if (it2 != null) {
                Intrinsics.checkNotNullExpressionValue(it2, "context");
                WebVideoPlayActivity.Companion companion = WebVideoPlayActivity.Companion;
                SnifferNetDiskTaskModel netDiskModel = currentModel.getNetDiskModel();
                companion.startWebVideoPlayActivity(it2, netDiskModel != null ? netDiskModel.getUrl() : null, currentModel.getFavor().url, currentModel.getFavor().title);
            }
            FavorModel favor = currentModel.getFavor();
            if (favor != null) {
                str = favor.uKey;
            }
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "currentModel?.favor?.uKey ?: \"\"");
            }
            addVisitFavorCount(str);
            FavorWebVideoUbcListener favorWebVideoUbcListener = this.onWebVideoUbcListener;
            if (favorWebVideoUbcListener != null) {
                favorWebVideoUbcListener.onUbcClick(position, currentModel.getFavor());
            }
        }
    }

    private final void addVisitFavorCount(String uKey) {
        IFavorUserAction userAction;
        if (!TextUtils.isEmpty(uKey) && (userAction = getMIFavorManager().getFavorUserAction()) != null) {
            userAction.visitFavor(uKey, (FavorDataCallback<Boolean>) null);
        }
    }

    public final void setWebVideoUbcListener(FavorWebVideoUbcListener ubcListener) {
        Intrinsics.checkNotNullParameter(ubcListener, "ubcListener");
        this.onWebVideoUbcListener = ubcListener;
    }

    public final boolean getCurrentIsEditable() {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            return favorWebVideoAdapter.isEditable();
        }
        return false;
    }

    public final void setClassifyModel(ClassifyModel classifyModel) {
        Intrinsics.checkNotNullParameter(classifyModel, "classifyModel");
        this.mClassifyModel = classifyModel;
    }

    public final void setFavorDataController(FavorController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.mController = controller;
    }

    public final void onDeletedClicked() {
        showSelectedDeleteDialog();
    }

    private final void onShareClicked(FavorModel model) {
        Activity activity = BdBoxActivityManager.getRealTopActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            FavorModel.Feature feature = model.feature;
            this.mShareManager = ShareUtil.shareUrl$default(activity, new ShareModel(ClassifyViewPage.PAGE_HISTORY, model.tplId, model.title, feature != null ? feature.source : null, model.url, model.img, "tab_fav", model.uKey), (OnBoxShareListenerAdapter) null, 4, (Object) null);
        }
    }

    private final void showSelectedDeleteDialog() {
        FavorWebVideoAdapter webVideoAdapter = this.mAdapter;
        if (webVideoAdapter != null) {
            int count = webVideoAdapter.getSelectedCount();
            Context ctx = getContext();
            if (ctx != null && (ctx instanceof Activity) && !((Activity) ctx).isFinishing() && !((Activity) ctx).isDestroyed()) {
                DeleteDialogWithRecycleBin deleteDialogWithRecycleBin = new DeleteDialogWithRecycleBin((Activity) ctx);
                boolean isEditable = webVideoAdapter.isEditable();
                String string = ctx.getString(com.baidu.searchbox.favor.R.string.user_assets_favor_delete_part_message, new Object[]{Integer.valueOf(count)});
                Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(R.string.u…lete_part_message, count)");
                deleteDialogWithRecycleBin.showDialog("tab_his", isEditable, string, new FavorWebVideoView$showSelectedDeleteDialog$1$1(this, ctx, count));
            }
        }
    }

    public final void deleteBookMarksAsync(boolean isMoveToRecycleBin, IUserAssetsContainer listener) {
        Context context;
        BdProgressDialog bdProgressDialog;
        BdProgressDialog bdProgressDialog2 = this.mBdProgressDialog;
        if (!(bdProgressDialog2 == null || (context = this.mContext) == null)) {
            if (bdProgressDialog2 != null) {
                bdProgressDialog2.setMessage(context.getString(R.string.deleting));
            }
            if (this.mContext instanceof FragmentActivity) {
                Context currentActivity = this.mContext;
                if (!((FragmentActivity) currentActivity).isFinishing() && !((FragmentActivity) currentActivity).isDestroyed() && (bdProgressDialog = this.mBdProgressDialog) != null) {
                    bdProgressDialog.show();
                }
            }
        }
        Observable.just("").subscribeOn(Schedulers.io()).map(new FavorWebVideoView$$ExternalSyntheticLambda0(this, isMoveToRecycleBin)).observeOn(AndroidSchedulers.mainThread()).subscribe(new FavorWebVideoView$$ExternalSyntheticLambda1(this, listener, isMoveToRecycleBin), (Action1<Throwable>) new FavorWebVideoView$$ExternalSyntheticLambda2());
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteBookMarksAsync$lambda-7  reason: not valid java name */
    public static final Boolean m16650deleteBookMarksAsync$lambda7(FavorWebVideoView this$0, boolean $isMoveToRecycleBin, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IFavorList favorListManager = ((IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE)).getFavorList();
        FavorWebVideoAdapter favorWebVideoAdapter = this$0.mAdapter;
        LinkedHashMap clonedUkeys = new LinkedHashMap(favorWebVideoAdapter != null ? favorWebVideoAdapter.getSelectedIds() : null);
        boolean deleted = true;
        if (clonedUkeys.size() > 0 && favorListManager != null) {
            for (FavorModel currentItem : clonedUkeys.values()) {
                if (currentItem != null) {
                    deleted = deleted && favorListManager.deleteFavor($isMoveToRecycleBin, currentItem);
                }
            }
        }
        if (!deleted && AppConfig.isDebug()) {
            Log.e("FavorWebVideo", "deleteBookMarksAsync ---> delete failed!!!");
        }
        return Boolean.valueOf(deleted);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r0.getSelectedIds();
     */
    /* renamed from: deleteBookMarksAsync$lambda-8  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m16651deleteBookMarksAsync$lambda8(com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView r3, com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer r4, boolean r5, java.lang.Boolean r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.baidu.android.ext.widget.dialog.BdProgressDialog r0 = r3.mBdProgressDialog
            if (r0 == 0) goto L_0x001f
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0015
            boolean r0 = r0.isShowing()
            if (r0 != r1) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            if (r1 == 0) goto L_0x001f
            com.baidu.android.ext.widget.dialog.BdProgressDialog r0 = r3.mBdProgressDialog
            if (r0 == 0) goto L_0x001f
            r0.dismiss()
        L_0x001f:
            java.lang.String r0 = "isSuccess"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            boolean r0 = r6.booleanValue()
            if (r0 == 0) goto L_0x0044
            com.baidu.searchbox.bookmark.adapter.FavorWebVideoAdapter r0 = r3.mAdapter
            if (r0 == 0) goto L_0x003a
            java.util.LinkedHashMap r0 = r0.getSelectedIds()
            if (r0 == 0) goto L_0x003a
            java.util.Set r0 = r0.keySet()
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x0041
            java.util.Set r0 = kotlin.collections.SetsKt.emptySet()
        L_0x0041:
            r3.removeItem(r0)
        L_0x0044:
            if (r4 == 0) goto L_0x0049
            r4.endEditMode()
        L_0x0049:
            boolean r0 = r6.booleanValue()
            r3.showDeleteResultToast(r0)
            if (r5 == 0) goto L_0x0055
            r3.triggerFavorSync()
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView.m16651deleteBookMarksAsync$lambda8(com.baidu.searchbox.bookmark.favor.webvideo.FavorWebVideoView, com.baidu.searchbox.userassetsaggr.container.IUserAssetsContainer, boolean, java.lang.Boolean):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: deleteBookMarksAsync$lambda-9  reason: not valid java name */
    public static final void m16652deleteBookMarksAsync$lambda9(Throwable throwable) {
        if (AppConfig.isDebug() && throwable != null) {
            throwable.printStackTrace();
        }
    }

    private final void triggerFavorSync() {
        IFavorManager favorManager = (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
        if (favorManager != null) {
            favorManager.doFavorSyncRequest(SyncType.SYNC, (SyncCallback) null);
        }
    }

    private final void showDeleteResultToast(boolean isDeleteSuccess) {
        String toastMessage;
        try {
            Context ctx = getContext();
            if (ctx != null && (ctx instanceof Activity) && !ActivityUtils.isDestroyed((Activity) ctx)) {
                if (isDeleteSuccess) {
                    toastMessage = ctx.getString(com.baidu.searchbox.favor.R.string.user_assets_favor_delete_result_success);
                    Intrinsics.checkNotNullExpressionValue(toastMessage, "{\n                    ct…uccess)\n                }");
                } else {
                    toastMessage = ctx.getString(com.baidu.searchbox.favor.R.string.user_assets_favor_delete_result_failed);
                    Intrinsics.checkNotNullExpressionValue(toastMessage, "{\n                    ct…failed)\n                }");
                }
                UniversalToast.makeText(ctx, (CharSequence) toastMessage).show();
            }
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    private final void removeItem(Set<String> selectedIds) {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        boolean z = false;
        if (favorWebVideoAdapter != null && favorWebVideoAdapter.isAllSelected()) {
            z = true;
        }
        if (z) {
            this.mWebVideoDataList.clear();
        } else if (!this.mWebVideoDataList.isEmpty()) {
            for (String key : selectedIds) {
                deleteDataSafe(new FavorWebVideoView$removeItem$1$1(key));
            }
        }
        FavorWebVideoAdapter favorWebVideoAdapter2 = this.mAdapter;
        if (favorWebVideoAdapter2 != null) {
            favorWebVideoAdapter2.setData(this.mWebVideoDataList);
        }
    }

    private final void deleteDataSafe(Function1<? super FavorWebVideoModel, Boolean> result) {
        Iterator iterator = this.mWebVideoDataList.iterator();
        while (iterator.hasNext()) {
            if (result.invoke(iterator.next()).booleanValue()) {
                iterator.remove();
                return;
            }
        }
    }

    public final void onSelectAll(boolean isSelectedAll) {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            favorWebVideoAdapter.handleSelectAll(isSelectedAll);
        }
        boolean z = true;
        if (!isSelectedAll) {
            FavorWebVideoAdapter favorWebVideoAdapter2 = this.mAdapter;
            if (favorWebVideoAdapter2 != null && favorWebVideoAdapter2.getItemCount() == 0) {
                CommonEmptyView commonEmptyView = this.mEmptyView;
                if (commonEmptyView != null) {
                    commonEmptyView.setVisibility(0);
                }
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.setVisibility(8);
                }
            } else {
                CommonEmptyView commonEmptyView2 = this.mEmptyView;
                if (commonEmptyView2 != null) {
                    commonEmptyView2.setVisibility(8);
                }
                RecyclerView recyclerView2 = this.mRecyclerView;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
            }
        }
        IUserAssetsContainer iUserAssetsContainer = this.mainContainer;
        if (iUserAssetsContainer != null) {
            iUserAssetsContainer.updateDeleteBtnState(isSelectedAll, isSelectedAll ? getCountExceptSection() : 0);
        }
        IUserAssetsContainer iUserAssetsContainer2 = this.mainContainer;
        if (iUserAssetsContainer2 != null) {
            if (!isSelectedAll || getCountExceptSection() != 1) {
                z = false;
            }
            iUserAssetsContainer2.updateRenameBtnState(z);
        }
    }

    public final void onRenameClicked() {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        LinkedHashMap selectItems = favorWebVideoAdapter != null ? favorWebVideoAdapter.getSelectedIds() : null;
        if (selectItems != null && selectItems.size() != 0 && selectItems.size() <= 1) {
            Collection dataList = selectItems.values();
            Intrinsics.checkNotNullExpressionValue(dataList, "selectItems.values");
            if (dataList.size() != 0) {
                FavorModel currentData = dataList.iterator().next();
                FavorController favorController = this.mController;
                if (favorController != null) {
                    favorController.editFavor(currentData, this.mContext, false);
                }
            }
        } else if (AppConfig.isDebug()) {
            Log.d("FavorWebVideo", "——> onRenameClicked: error occurred, item count error");
        }
    }

    public final int getCountExceptSection() {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            return favorWebVideoAdapter.getItemCount();
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public final void handleMenuClick(int position, CommonMenuItem menuItem, FavorWebVideoModel model) {
        if (this.mAdapter != null && menuItem != null && model != null) {
            boolean check = false;
            if (menuItem.getItemId() == 1) {
                FavorHisIncognitoManagerKt.openIncognitoMode$default(getContext(), false, 2, (Object) null);
                handleClickListener(position, model);
                return;
            }
            FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
            if (favorWebVideoAdapter != null) {
                check = favorWebVideoAdapter.toggleCheck(model);
            }
            if (check) {
                switch (menuItem.getItemId()) {
                    case 0:
                        onDeletedClicked();
                        return;
                    case 2:
                        BookmarkUBC.favorEditBarClickEvent(BookmarkUBC.SOURCE_EDIT_FAVOR);
                        onRenameClicked();
                        return;
                    case 4:
                        IUserAssetsContainer iUserAssetsContainer = this.mainContainer;
                        if (iUserAssetsContainer != null) {
                            if (iUserAssetsContainer != null) {
                                iUserAssetsContainer.enterEditMode();
                            }
                            handleClickListener(position, model);
                            return;
                        }
                        return;
                    case 7:
                        onShareClicked(model.getFavor());
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private final int getSelectCount() {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            return favorWebVideoAdapter.getSelectedCount();
        }
        return -1;
    }

    public final boolean checkMoveBtnEnableState() {
        return false;
    }

    public final boolean checkRenameBtnEnableState() {
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        return (favorWebVideoAdapter != null ? favorWebVideoAdapter.getSelectedCount() : 0) == 1;
    }

    public void refreshList(List<SnifferNetDiskTaskModel> snifferNetDiskTaskModelList) {
        Intrinsics.checkNotNullParameter(snifferNetDiskTaskModelList, "snifferNetDiskTaskModelList");
        FavorWebVideoAdapter favorWebVideoAdapter = this.mAdapter;
        if (favorWebVideoAdapter != null) {
            favorWebVideoAdapter.notifyDataSetChanged();
        }
    }
}
