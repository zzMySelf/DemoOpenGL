package com.baidu.searchbox.feed.payment.comment;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.base.FeedTemplate;
import com.baidu.searchbox.feed.base.TplViewCaster;
import com.baidu.searchbox.feed.list.requester.IRefreshRequester;
import com.baidu.searchbox.feed.list.widget.CommonFooterView;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.column.R;
import com.baidu.searchbox.feed.payment.column.facets.SpColumnContext;
import com.baidu.searchbox.feed.payment.model.CommentResultEvent;
import com.baidu.searchbox.feed.payment.model.PayStats1076;
import com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData;
import com.baidu.searchbox.feed.payment.model.SpColumnCommentListData;
import com.baidu.searchbox.feed.payment.widget.BasicState;
import com.baidu.searchbox.feed.payment.widget.BasicView;
import com.baidu.searchbox.feed.payment.widget.CommonLoadingState;
import com.baidu.searchbox.feed.payment.widget.ContentState;
import com.baidu.searchbox.feed.payment.widget.StarRatingBar;
import com.baidu.searchbox.feed.payment.widget.StateLayer;
import com.baidu.searchbox.feed.tab.interaction.IInnerScrollChanged;
import com.baidu.searchbox.feed.tab.view.SimplePagerView;
import com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002XYB\u0005¢\u0006\u0002\u0010\u0005J\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u000208H\u0016J\u0010\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<H\u0002J\u0006\u0010=\u001a\u00020\u0013J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\fH\u0002J.\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u000f2\b\u0010D\u001a\u0004\u0018\u00010\u000f2\b\u0010E\u001a\u0004\u0018\u00010<H\u0016J\u0014\u0010F\u001a\u0004\u0018\u00010G2\b\u0010\u0010\u001a\u0004\u0018\u00010BH\u0002J\u0018\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\f2\u0006\u0010J\u001a\u00020\u0013H\u0002J\b\u0010K\u001a\u00020\tH\u0002J\b\u0010L\u001a\u00020\tH\u0002J\b\u0010M\u001a\u00020\tH\u0016J\u0012\u0010N\u001a\u0002082\b\u0010O\u001a\u0004\u0018\u00010GH\u0016J\u001e\u0010P\u001a\u0004\u0018\u00010G2\b\u0010Q\u001a\u0004\u0018\u00010B2\b\u0010R\u001a\u0004\u0018\u00010<H\u0016J\u0010\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\tH\u0016J\b\u0010U\u001a\u000208H\u0016J\b\u0010V\u001a\u000208H\u0003J\u0010\u0010W\u001a\u0002082\b\u00105\u001a\u0004\u0018\u000106R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage;", "Lcom/baidu/searchbox/feed/tab/view/SimplePagerView;", "Lcom/baidu/searchbox/feed/list/requester/IRefreshRequester;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/searchbox/feed/tab/interaction/IInnerScrollChanged;", "()V", "adapter", "Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage$SpColumnCommentAdapter;", "canComment", "", "commentList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/feed/payment/model/SpColumnCommentItemData;", "Lkotlin/collections/ArrayList;", "commentToast", "", "context", "Landroid/content/Context;", "currentPageNum", "", "displayMode", "fastCommentBar", "Lcom/baidu/searchbox/feed/payment/comment/SpColumnFastCommentBar;", "footerView", "Lcom/baidu/searchbox/feed/list/widget/CommonFooterView;", "insertItem", "isFirstComment", "isForbidComment", "isLoading", "isOver", "isPay", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "listener", "Lcom/baidu/searchbox/feed/payment/widget/StarRatingBar$StarRatingBarListener;", "nid", "payStats", "Lcom/baidu/searchbox/feed/payment/model/PayStats1076;", "pullToRefreshView", "Lcom/baidu/searchbox/feed/widget/feedflow/NestedPullToRefreshView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rootReplyId", "stateEmpty", "Lcom/baidu/searchbox/feed/payment/widget/BasicState;", "stateError", "Lcom/baidu/searchbox/feed/payment/comment/NetworkErrorState;", "stateLayer", "Lcom/baidu/searchbox/feed/payment/widget/StateLayer;", "stateLoading", "Lcom/baidu/searchbox/feed/payment/widget/CommonLoadingState;", "step", "threadId", "transmitter", "Lcom/baidu/searchbox/feed/payment/comment/FeedCommentInputTransmitter;", "doLoadMore", "", "doPullData", "extractInfoFrom", "bundle", "Landroid/os/Bundle;", "getMode", "handleRefuseComment", "comment", "init", "activity", "Landroid/app/Activity;", "bundleId", "componentName", "extraInfo", "initView", "Landroid/view/View;", "insertData", "data", "position", "isHistoryPage", "isOnlyFastEnter", "isScrollToTop", "onClick", "v", "onCreateView", "ctx", "info", "onFeedNightModeChange", "isNightMode", "onViewDestroy", "requestData", "setTransmitter", "ScrollListener", "SpColumnCommentAdapter", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnCommentPage.kt */
public final class SpColumnCommentPage extends SimplePagerView implements IRefreshRequester, View.OnClickListener, IInnerScrollChanged {
    private SpColumnCommentAdapter adapter;
    /* access modifiers changed from: private */
    public boolean canComment = true;
    /* access modifiers changed from: private */
    public ArrayList<SpColumnCommentItemData> commentList = new ArrayList<>();
    /* access modifiers changed from: private */
    public String commentToast;
    /* access modifiers changed from: private */
    public Context context;
    private int currentPageNum;
    private String displayMode = "";
    private SpColumnFastCommentBar fastCommentBar;
    /* access modifiers changed from: private */
    public CommonFooterView footerView;
    /* access modifiers changed from: private */
    public SpColumnCommentItemData insertItem;
    /* access modifiers changed from: private */
    public boolean isFirstComment;
    private boolean isForbidComment;
    /* access modifiers changed from: private */
    public boolean isLoading;
    /* access modifiers changed from: private */
    public boolean isOver;
    private boolean isPay;
    /* access modifiers changed from: private */
    public RecyclerView.LayoutManager layoutManager;
    /* access modifiers changed from: private */
    public StarRatingBar.StarRatingBarListener listener = new SpColumnCommentPage$listener$1(this);
    /* access modifiers changed from: private */
    public String nid = "";
    /* access modifiers changed from: private */
    public PayStats1076 payStats;
    private NestedPullToRefreshView pullToRefreshView;
    private RecyclerView recyclerView;
    private String rootReplyId = "";
    private BasicState stateEmpty;
    private NetworkErrorState stateError = new NetworkErrorState(this);
    /* access modifiers changed from: private */
    public StateLayer stateLayer;
    private final CommonLoadingState stateLoading = new CommonLoadingState();
    private int step = 16;
    /* access modifiers changed from: private */
    public String threadId = "";
    /* access modifiers changed from: private */
    public FeedCommentInputTransmitter transmitter;

    public View onCreateView(Activity ctx, Bundle info) {
        BasicState basicState;
        int i2;
        Activity activity = ctx;
        this.context = activity;
        Intrinsics.checkNotNull(ctx);
        StateLayer rootView = new StateLayer(activity);
        rootView.bindState(this.stateLoading);
        if (!this.isForbidComment) {
            int i3 = R.drawable.feed_spcolumn_comment_empty;
            if (this.isPay) {
                i2 = com.baidu.searchbox.feed.payment.R.string.feed_spcolumn_state_layer_comment_empty;
            } else {
                i2 = com.baidu.searchbox.feed.payment.R.string.feed_spcolumn_state_layer_comment_empty_not_pay;
            }
            basicState = new BasicState(i3, i2, com.baidu.searchbox.feed.payment.R.color.grey_666, (Drawable) null, (CharSequence) null, (ColorStateList) null, false, 120, (DefaultConstructorMarker) null);
        } else {
            basicState = new BasicState(R.drawable.feed_spcolumn_comment_empty, com.baidu.searchbox.feed.payment.R.string.feed_comment_forbid_empty_tip, com.baidu.searchbox.feed.payment.R.color.grey_666, (Drawable) null, (CharSequence) null, (ColorStateList) null, false, 120, (DefaultConstructorMarker) null);
        }
        this.stateEmpty = basicState;
        Intrinsics.checkNotNull(basicState);
        rootView.bindState(basicState);
        rootView.bindState(this.stateError);
        BasicView basicView = BasicView.init$default(new BasicView(activity), (ImageView) null, (LinearLayout.LayoutParams) null, (TextView) null, (LinearLayout.LayoutParams) null, ctx.getResources().getDimensionPixelSize(com.baidu.searchbox.feed.payment.R.dimen.spcolumn_state_layer_gap), 15, (Object) null);
        int fakeBarHeight = ctx.getResources().getDimensionPixelSize(com.baidu.searchbox.feed.payment.R.dimen.feed_fake_fast_comment_bar_height);
        rootView.addViewWithCenterInParent(basicView);
        SpColumnFastCommentBar spColumnFastCommentBar = new SpColumnFastCommentBar(activity, this.listener);
        this.fastCommentBar = spColumnFastCommentBar;
        spColumnFastCommentBar.setFastBarVisible(8);
        SpColumnFastCommentBar spColumnFastCommentBar2 = this.fastCommentBar;
        rootView.addView(spColumnFastCommentBar2 != null ? spColumnFastCommentBar2.getContentView() : null, new FrameLayout.LayoutParams(-1, fakeBarHeight));
        rootView.setGetCenterBasedOnSize(new SpColumnCommentPage$onCreateView$1(activity));
        rootView.setContentView(initView(ctx));
        this.stateLayer = rootView;
        if (!this.isForbidComment) {
            requestData();
        } else {
            BasicState basicState2 = this.stateEmpty;
            Intrinsics.checkNotNull(basicState2);
            rootView.turnStateTo(basicState2);
        }
        BdEventBus.Companion.getDefault().register(this, CommentResultEvent.class, 1, new SpColumnCommentPage$onCreateView$2(this));
        return rootView;
    }

    /* access modifiers changed from: private */
    public final void handleRefuseComment(SpColumnCommentItemData comment) {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : this.commentList) {
            if (((SpColumnCommentItemData) element$iv$iv).isAuthor) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        this.commentList.removeAll((Collection) ((List) destination$iv$iv));
        SpColumnCommentAdapter spColumnCommentAdapter = this.adapter;
        if (spColumnCommentAdapter != null) {
            spColumnCommentAdapter.setData(this.commentList);
        }
    }

    public boolean init(Activity activity, String bundleId, String componentName, Bundle extraInfo) {
        Bundle bundle;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual((Object) componentName, (Object) SpColumnCommentPageKt.PAGE_CONTEXT_COMPONENT_TAB_FRAGMENT)) {
            if (activity instanceof SpColumnContext) {
                bundle = ((SpColumnContext) activity).getDetailViewModel().makeCommentFragmentArgs();
            } else if (extraInfo == null) {
                return false;
            } else {
                bundle = extraInfo;
            }
            extractInfoFrom(bundle);
        } else if (Intrinsics.areEqual((Object) componentName, (Object) SpColumnCommentPageKt.PAGE_CONTEXT_COMPONENT_DETAIL_DIALOG) && extraInfo != null) {
            extractInfoFrom(extraInfo);
        }
        return false;
    }

    private final void extractInfoFrom(Bundle bundle) {
        this.nid = bundle.getString("nid");
        this.threadId = bundle.getString("thread_id");
        this.isForbidComment = Intrinsics.areEqual((Object) bundle.getString("comment_status"), (Object) "2");
        boolean z = false;
        this.isPay = bundle.getBoolean(SpColumnCommentPageKt.BUNDLE_PAY_STATE, false);
        if (Intrinsics.areEqual((Object) bundle.getString("comment_status"), (Object) "0") && this.isPay) {
            z = true;
        }
        this.isFirstComment = z;
        this.displayMode = bundle.getString(SpColumnCommentPageKt.BUNDLE_MODE);
        this.rootReplyId = bundle.getString("reply_id");
        this.canComment = bundle.getBoolean(SpColumnCommentPageKt.BUNDLE_CAN_COMMENT);
        this.commentToast = bundle.getString(SpColumnCommentPageKt.BUNDLE_COMMENT_TOAST);
    }

    /* JADX WARNING: type inference failed for: r0v21, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.View initView(android.app.Activity r6) {
        /*
            r5 = this;
            r0 = r6
            android.content.Context r0 = (android.content.Context) r0
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2130903984(0x7f0303b0, float:1.7414801E38)
            r2 = 0
            r3 = 0
            android.view.View r0 = r0.inflate(r1, r2, r3)
            boolean r1 = r0 instanceof com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView
            if (r1 == 0) goto L_0x0017
            com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView r0 = (com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView) r0
            goto L_0x0018
        L_0x0017:
            r0 = r2
        L_0x0018:
            r5.pullToRefreshView = r0
            if (r0 == 0) goto L_0x0026
            r1 = 2131765129(0x7f102789, float:1.916141E38)
            android.view.View r0 = r0.findViewById(r1)
            r2 = r0
            androidx.recyclerview.widget.RecyclerView r2 = (androidx.recyclerview.widget.RecyclerView) r2
        L_0x0026:
            r5.recyclerView = r2
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r5.layoutManager
            if (r0 != 0) goto L_0x003e
            androidx.recyclerview.widget.LinearLayoutManager r0 = new androidx.recyclerview.widget.LinearLayoutManager
            r1 = r6
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r0
            r5.layoutManager = r0
            androidx.recyclerview.widget.LinearLayoutManager r0 = (androidx.recyclerview.widget.LinearLayoutManager) r0
            r1 = 1
            r0.setOrientation(r1)
        L_0x003e:
            androidx.recyclerview.widget.RecyclerView r0 = r5.recyclerView
            if (r0 != 0) goto L_0x0043
            goto L_0x0048
        L_0x0043:
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r5.layoutManager
            r0.setLayoutManager(r1)
        L_0x0048:
            androidx.recyclerview.widget.RecyclerView r0 = r5.recyclerView
            if (r0 == 0) goto L_0x0056
            com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$ScrollListener r1 = new com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$ScrollListener
            r1.<init>()
            androidx.recyclerview.widget.RecyclerView$OnScrollListener r1 = (androidx.recyclerview.widget.RecyclerView.OnScrollListener) r1
            r0.addOnScrollListener(r1)
        L_0x0056:
            com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView r0 = r5.pullToRefreshView
            if (r0 == 0) goto L_0x005d
            r0.setIsRefreshEnable(r3)
        L_0x005d:
            com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$SpColumnCommentAdapter r0 = new com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$SpColumnCommentAdapter
            r1 = r6
            android.content.Context r1 = (android.content.Context) r1
            r0.<init>(r1)
            r5.adapter = r0
            androidx.recyclerview.widget.RecyclerView r1 = r5.recyclerView
            if (r1 != 0) goto L_0x006c
            goto L_0x0071
        L_0x006c:
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = (androidx.recyclerview.widget.RecyclerView.Adapter) r0
            r1.setAdapter(r0)
        L_0x0071:
            boolean r0 = r5.isFirstComment
            if (r0 == 0) goto L_0x0094
            java.util.ArrayList<com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData> r0 = r5.commentList
            com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData r1 = new com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData
            r1.<init>()
            r2 = r1
            r4 = 0
            r2.layout = r3
            java.lang.String r3 = "special"
            r2.replyId = r3
            r0.add(r1)
            com.baidu.searchbox.feed.payment.model.PayStats1076 r0 = r5.payStats
            if (r0 == 0) goto L_0x0094
            java.lang.String r1 = r5.nid
            java.lang.String r2 = "fastcomment_show"
            r0.recordFastEnterShowOrClick(r1, r2)
        L_0x0094:
            com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$SpColumnCommentAdapter r0 = r5.adapter
            if (r0 == 0) goto L_0x009f
            java.util.ArrayList<com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData> r1 = r5.commentList
            java.util.List r1 = (java.util.List) r1
            r0.setData(r1)
        L_0x009f:
            com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$SpColumnCommentAdapter r0 = r5.adapter
            if (r0 == 0) goto L_0x00a9
            r1 = r5
            com.baidu.searchbox.feed.list.requester.IRefreshRequester r1 = (com.baidu.searchbox.feed.list.requester.IRefreshRequester) r1
            r0.setRefreshRequester(r1)
        L_0x00a9:
            com.baidu.searchbox.feed.widget.feedflow.NestedPullToRefreshView r0 = r5.pullToRefreshView
            android.view.View r0 = (android.view.View) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage.initView(android.app.Activity):android.view.View");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0083, code lost:
        r3 = kotlin.text.StringsKt.toIntOrNull(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void requestData() {
        /*
            r13 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = r13.threadId
            java.lang.String r3 = ""
            if (r2 != 0) goto L_0x000f
            r2 = r3
        L_0x000f:
            java.lang.String r4 = "thread_id"
            r1.put(r4, r2)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            int r2 = r13.currentPageNum
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "start"
            r1.put(r4, r2)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            int r2 = r13.step
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "num"
            r1.put(r4, r2)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = r13.nid
            if (r2 != 0) goto L_0x003b
            r2 = r3
        L_0x003b:
            java.lang.String r4 = "nid"
            r1.put(r4, r2)
            boolean r1 = r13.isHistoryPage()
            r2 = 1
            r4 = 0
            r5 = 13
            if (r1 == 0) goto L_0x0099
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r6 = "order"
            r1.put(r6, r5)
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r5 = r13.rootReplyId
            if (r5 != 0) goto L_0x0060
            goto L_0x0061
        L_0x0060:
            r3 = r5
        L_0x0061:
            java.lang.String r5 = "reply_id"
            r1.put(r5, r3)
            java.util.ArrayList<com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData> r1 = r13.commentList
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00a5
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.util.ArrayList<com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData> r3 = r13.commentList
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r3 = kotlin.collections.CollectionsKt.first(r3)
            com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData r3 = (com.baidu.searchbox.feed.payment.model.SpColumnCommentItemData) r3
            java.lang.String r3 = r3.isAnonymous
            if (r3 == 0) goto L_0x008e
            java.lang.Integer r3 = kotlin.text.StringsKt.toIntOrNull(r3)
            if (r3 == 0) goto L_0x008e
            int r3 = r3.intValue()
            goto L_0x008f
        L_0x008e:
            r3 = r4
        L_0x008f:
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = "is_anonymous"
            r1.put(r5, r3)
            goto L_0x00a5
        L_0x0099:
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            java.lang.String r5 = "inner_order"
            r1.put(r5, r3)
        L_0x00a5:
            com.baidu.searchbox.feed.list.widget.CommonFooterView r1 = r13.footerView
            if (r1 == 0) goto L_0x00ac
            r1.setForceVisibility(r4)
        L_0x00ac:
            com.baidu.searchbox.feed.list.widget.CommonFooterView r1 = r13.footerView
            if (r1 != 0) goto L_0x00b1
            goto L_0x00b5
        L_0x00b1:
            r3 = 3
            r1.setState(r3)
        L_0x00b5:
            r13.isLoading = r2
            com.baidu.searchbox.feed.payment.utils.PayRequester r4 = com.baidu.searchbox.feed.payment.utils.PayRequester.INSTANCE
            java.lang.Class<com.baidu.searchbox.feed.payment.model.SpColumnCommentListData> r6 = com.baidu.searchbox.feed.payment.model.SpColumnCommentListData.class
            r7 = 0
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            r9 = 0
            com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$$ExternalSyntheticLambda0 r10 = new com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage$$ExternalSyntheticLambda0
            r10.<init>(r13)
            r11 = 20
            r12 = 0
            java.lang.String r5 = "281"
            com.baidu.searchbox.feed.payment.utils.PayRequester.sendRequestAsync$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.comment.SpColumnCommentPage.requestData():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-5  reason: not valid java name */
    public static final void m19109requestData$lambda5(SpColumnCommentPage this$0, boolean success, SpColumnCommentListData result, Exception exception) {
        SpColumnFastCommentBar spColumnFastCommentBar;
        SpColumnCommentItemData it;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isLoading = false;
        StateLayer stateLayer2 = this$0.stateLayer;
        if (stateLayer2 != null) {
            stateLayer2.turnStateTo(ContentState.INSTANCE);
        }
        if (success && result != null) {
            if (!this$0.isHistoryPage() && (it = this$0.insertItem) != null) {
                List<SpColumnCommentItemData> list = result.list;
                if (list != null) {
                    list.remove(it);
                }
                this$0.insertItem = null;
            }
            List<SpColumnCommentItemData> list2 = result.list;
            boolean z = true;
            if (list2 == null || !(!list2.isEmpty())) {
                z = false;
            }
            if (z) {
                ArrayList<SpColumnCommentItemData> arrayList = this$0.commentList;
                List<SpColumnCommentItemData> list3 = result.list;
                Intrinsics.checkNotNull(list3);
                arrayList.addAll(list3);
                SpColumnCommentAdapter spColumnCommentAdapter = this$0.adapter;
                if (spColumnCommentAdapter != null) {
                    spColumnCommentAdapter.setData(this$0.commentList);
                }
                this$0.currentPageNum += this$0.step;
            } else if (this$0.commentList.size() == 0 || this$0.isOnlyFastEnter()) {
                StateLayer stateLayer3 = this$0.stateLayer;
                if (stateLayer3 != null) {
                    BasicState basicState = this$0.stateEmpty;
                    Intrinsics.checkNotNull(basicState);
                    stateLayer3.turnStateTo(basicState);
                }
                if (this$0.isOnlyFastEnter() && (spColumnFastCommentBar = this$0.fastCommentBar) != null) {
                    spColumnFastCommentBar.setFastBarVisible(0);
                }
            }
            if (result.isOver) {
                CommonFooterView commonFooterView = this$0.footerView;
                if (commonFooterView != null) {
                    commonFooterView.setState(802);
                }
            } else {
                CommonFooterView commonFooterView2 = this$0.footerView;
                if (commonFooterView2 != null) {
                    commonFooterView2.setState(0);
                }
            }
            this$0.isOver = result.isOver;
        } else if (this$0.commentList.size() == 0 || this$0.isOnlyFastEnter()) {
            StateLayer stateLayer4 = this$0.stateLayer;
            if (stateLayer4 != null) {
                stateLayer4.turnStateTo(this$0.stateError);
            }
        } else {
            Context it2 = this$0.context;
            if (it2 != null) {
                UniversalToast.makeText(FeedpayKt.appContext(), it2.getText(com.baidu.searchbox.feed.payment.R.string.feed_coupon_be_common_net_error)).showToast();
            }
            CommonFooterView commonFooterView3 = this$0.footerView;
            if (commonFooterView3 != null) {
                commonFooterView3.setState(803);
            }
        }
        if (this$0.commentList.size() < 8) {
            CommonFooterView commonFooterView4 = this$0.footerView;
            if (commonFooterView4 != null) {
                commonFooterView4.setForceVisibility(8);
                return;
            }
            return;
        }
        CommonFooterView commonFooterView5 = this$0.footerView;
        if (commonFooterView5 != null) {
            commonFooterView5.setForceVisibility(0);
        }
    }

    private final boolean isOnlyFastEnter() {
        return this.commentList.size() == 1 && this.commentList.get(0).layout == 0;
    }

    public void doPullData() {
    }

    public void doLoadMore() {
        requestData();
    }

    public void onViewDestroy() {
        super.onViewDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public void onFeedNightModeChange(boolean isNightMode) {
        RecyclerView.Adapter adapter2;
        super.onFeedNightModeChange(isNightMode);
        RecyclerView recyclerView2 = this.recyclerView;
        if (!(recyclerView2 == null || (adapter2 = recyclerView2.getAdapter()) == null)) {
            adapter2.notifyDataSetChanged();
        }
        SpColumnFastCommentBar spColumnFastCommentBar = this.fastCommentBar;
        if (spColumnFastCommentBar != null) {
            spColumnFastCommentBar.onNightModeChange();
        }
    }

    /* access modifiers changed from: private */
    public final void insertData(SpColumnCommentItemData data, int position) {
        if (position >= 0 && position <= this.commentList.size()) {
            if (this.isFirstComment) {
                this.commentList.remove(0);
                SpColumnFastCommentBar spColumnFastCommentBar = this.fastCommentBar;
                if (spColumnFastCommentBar != null) {
                    spColumnFastCommentBar.setFastBarVisible(8);
                }
                this.isFirstComment = false;
            }
            this.commentList.remove(data);
            this.commentList.add(position, data);
            SpColumnCommentAdapter spColumnCommentAdapter = this.adapter;
            if (spColumnCommentAdapter != null) {
                spColumnCommentAdapter.setData(this.commentList);
            }
        }
    }

    public void onClick(View v) {
        StateLayer stateLayer2 = this.stateLayer;
        if (stateLayer2 != null) {
            stateLayer2.turnStateTo(this.stateLoading);
        }
        requestData();
    }

    public boolean isScrollToTop() {
        NestedPullToRefreshView nestedPullToRefreshView = this.pullToRefreshView;
        return nestedPullToRefreshView != null && !nestedPullToRefreshView.canChildScrollUp();
    }

    public final int getMode() {
        Integer intOrNull;
        String str = this.displayMode;
        if (str == null || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
            return 0;
        }
        return intOrNull.intValue();
    }

    /* access modifiers changed from: private */
    public final boolean isHistoryPage() {
        return getMode() == 1;
    }

    public final void setTransmitter(FeedCommentInputTransmitter transmitter2) {
        this.payStats = transmitter2 != null ? transmitter2.getPayStats() : null;
        this.transmitter = transmitter2;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage$ScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Lcom/baidu/searchbox/NoProGuard;", "(Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage;)V", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpColumnCommentPage.kt */
    public final class ScrollListener extends RecyclerView.OnScrollListener implements NoProGuard {
        public ScrollListener() {
        }

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (SpColumnCommentPage.this.commentList.size() > 0) {
                RecyclerView.LayoutManager access$getLayoutManager$p = SpColumnCommentPage.this.layoutManager;
                View view2 = null;
                LinearLayoutManager linearLayoutManager = access$getLayoutManager$p instanceof LinearLayoutManager ? (LinearLayoutManager) access$getLayoutManager$p : null;
                Integer lastVisiblePos = linearLayoutManager != null ? Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()) : null;
                RecyclerView.LayoutManager access$getLayoutManager$p2 = SpColumnCommentPage.this.layoutManager;
                if (access$getLayoutManager$p2 != null) {
                    view2 = access$getLayoutManager$p2.findViewByPosition(lastVisiblePos != null ? lastVisiblePos.intValue() : -1);
                }
                View lastView = view2;
                View testable = TplViewCaster.castToView(SpColumnCommentPage.this.footerView);
                if (testable != null && !SpColumnCommentPage.this.isLoading && Intrinsics.areEqual((Object) lastView, (Object) testable) && dy > 0 && !SpColumnCommentPage.this.isOver) {
                    SpColumnCommentPage.this.doLoadMore();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0010H\u0017J\u0018\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u0016\u0010\u001a\u001a\u00020\u00142\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0010\u0010\u001c\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage$SpColumnCommentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/baidu/searchbox/NoProGuard;", "context", "Landroid/content/Context;", "(Lcom/baidu/searchbox/feed/payment/comment/SpColumnCommentPage;Landroid/content/Context;)V", "commentList", "", "Lcom/baidu/searchbox/feed/payment/model/SpColumnCommentItemData;", "getContext", "()Landroid/content/Context;", "requester", "Lcom/baidu/searchbox/feed/list/requester/IRefreshRequester;", "createFooterView", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "list", "setRefreshRequester", "r", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpColumnCommentPage.kt */
    public final class SpColumnCommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements NoProGuard {
        private List<SpColumnCommentItemData> commentList = new ArrayList();
        private final Context context;
        private IRefreshRequester requester;

        public SpColumnCommentAdapter(Context context2) {
            this.context = context2;
        }

        public final Context getContext() {
            return this.context;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
            switch (viewType) {
                case 0:
                    View inflate = LayoutInflater.from(this.context).inflate(R.layout.feed_comment_empty_view, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…mpty_view, parent, false)");
                    return new SpecialTipViewHolder(inflate, SpColumnCommentPage.this.listener);
                case 2:
                    return createFooterView();
                default:
                    Context context2 = this.context;
                    Intrinsics.checkNotNull(context2);
                    return new CommentViewHolder(new SpColumnCommentTpl(context2, SpColumnCommentPage.this.nid, SpColumnCommentPage.this.threadId, new SpColumnCommentPage$SpColumnCommentAdapter$$ExternalSyntheticLambda0(SpColumnCommentPage.this)));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onCreateViewHolder$lambda-0  reason: not valid java name */
        public static final void m19112onCreateViewHolder$lambda0(SpColumnCommentPage this$02, View it) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            PayStats1076 access$getPayStats$p = this$02.payStats;
            if (access$getPayStats$p != null) {
                access$getPayStats$p.recordClickHistoryButton(this$02.nid);
            }
        }

        private final RecyclerView.ViewHolder createFooterView() {
            CommonFooterView view2 = new CommonFooterView(this.context);
            view2.setForceVisibility(8);
            View rootView = view2.getRootView();
            if (rootView != null) {
                rootView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            View rightCircleIconView = view2.getRightCircleIconView();
            if (rightCircleIconView != null) {
                rightCircleIconView.setVisibility(8);
            }
            view2.setCommonBackgroundColor(com.baidu.android.common.ui.style.R.color.white);
            view2.getStyleMap().put(1996555042, com.baidu.searchbox.feed.payment.R.string.spcolumn_list_no_more_data);
            view2.getStyleMap().put(1996686114, com.baidu.searchbox.feed.payment.R.color.grey_999);
            view2.getStyleMap().put(1996685315, com.baidu.searchbox.feed.payment.R.color.grey_999);
            view2.getStyleMap().put(1996685312, com.baidu.searchbox.feed.payment.R.color.grey_999);
            view2.updateTheme();
            view2.setOnStateChangedListener(new SpColumnCommentPage$SpColumnCommentAdapter$$ExternalSyntheticLambda1(view2));
            SpColumnCommentPage.this.footerView = view2;
            View rootView2 = view2.getRootView();
            Intrinsics.checkNotNull(rootView2);
            return new FooterViewHolder(rootView2, this.requester);
        }

        /* access modifiers changed from: private */
        /* renamed from: createFooterView$lambda-1  reason: not valid java name */
        public static final void m19111createFooterView$lambda1(CommonFooterView $view, int it) {
            Intrinsics.checkNotNullParameter($view, "$view");
            boolean x = it != 802;
            View rootView = $view.getRootView();
            if (rootView != null) {
                rootView.setClickable(x);
            }
            View rootView2 = $view.getRootView();
            if (rootView2 != null) {
                rootView2.setEnabled(x);
            }
        }

        public final void setRefreshRequester(IRefreshRequester r) {
            this.requester = r;
        }

        public int getItemCount() {
            return this.commentList.size() + 1;
        }

        public int getItemViewType(int position) {
            if (position >= this.commentList.size()) {
                return 2;
            }
            if (position < 0) {
                return -1;
            }
            return this.commentList.get(position).layout;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            int i2 = 0;
            if (position >= 0 && position < this.commentList.size()) {
                SpColumnCommentItemData data = this.commentList.get(position);
                if (holder instanceof CommentViewHolder) {
                    ((CommentViewHolder) holder).getTpl().update(data, position, SpColumnCommentPage.this.getMode());
                } else if (holder instanceof SpecialTipViewHolder) {
                    ((SpecialTipViewHolder) holder).onNightModeChange();
                }
            }
            if (getItemViewType(position) == 2) {
                FeedTemplate castToTemplate = TplViewCaster.castToTemplate(holder.itemView);
                CommonFooterView view2 = castToTemplate instanceof CommonFooterView ? (CommonFooterView) castToTemplate : null;
                if (view2 != null) {
                    if (SpColumnCommentPage.this.isOver) {
                        i2 = 802;
                    }
                    view2.setState(i2);
                }
                if (view2 != null) {
                    view2.applyFeedNightMode();
                }
                CommonFooterView access$getFooterView$p = SpColumnCommentPage.this.footerView;
                if (access$getFooterView$p != null) {
                    access$getFooterView$p.updateTheme();
                }
            }
        }

        public final void setData(List<SpColumnCommentItemData> list) {
            if (list != null && (!list.isEmpty())) {
                this.commentList = list;
                notifyDataSetChanged();
            }
        }
    }
}
