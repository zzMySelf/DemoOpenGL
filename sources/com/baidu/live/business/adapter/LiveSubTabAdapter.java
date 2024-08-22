package com.baidu.live.business.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.Live16Ratio9ItemView;
import com.baidu.live.business.Live16Ratio9TopicView;
import com.baidu.live.business.Live1Ratio1ItemView;
import com.baidu.live.business.Live4Ratio5BannerItemView;
import com.baidu.live.business.Live4Ratio5ItemView;
import com.baidu.live.business.Live4Ratio5TopicView;
import com.baidu.live.business.LiveHorizontalBannerItemView;
import com.baidu.live.business.LiveLoadMoreView;
import com.baidu.live.business.LiveMarketItemBigView;
import com.baidu.live.business.LiveMarketView;
import com.baidu.live.business.LiveMoreRecTitleView;
import com.baidu.live.business.LivePreferRecommendView;
import com.baidu.live.business.LiveReserveHeaderView;
import com.baidu.live.business.base.LiveBaseItemView;
import com.baidu.live.business.base.LiveFeedBaseHolder;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.util.LiveFastClickHelper;
import com.baidu.live.feed.page.R;
import com.baidu.live.uimode.UIModeUtils;
import com.baidu.searchbox.favor.data.FavorModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f*\u0002\u000b\u001f\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002@AB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\"\u0010&\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006J\b\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u001cH\u0002J\u0010\u00100\u001a\u00020'2\u0006\u00101\u001a\u000202H\u0002J\u001a\u00103\u001a\u00020'2\u0006\u00101\u001a\u00020\u00022\b\b\u0001\u0010-\u001a\u00020+H\u0016J\u0018\u00104\u001a\u0002022\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020+H\u0016J\u0010\u00108\u001a\u00020'2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0010\u00109\u001a\u00020'2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0010\u0010:\u001a\u00020'2\u0006\u00101\u001a\u00020\u0002H\u0016J\u0010\u0010;\u001a\u00020'2\b\u0010<\u001a\u0004\u0018\u00010\u0017J\u000e\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0019J\u0016\u0010?\u001a\u00020'2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010)R\u0010\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0004\n\u0002\u0010 R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\"\"\u0004\b$\u0010%¨\u0006B"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "scene", "", "secondLevelTab", "thirdLevelTab", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bannerListener", "com/baidu/live/business/adapter/LiveSubTabAdapter$bannerListener$1", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$bannerListener$1;", "getContext", "()Landroid/content/Context;", "curRoomId", "itemViewListener", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "getItemViewListener", "()Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "setItemViewListener", "(Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;)V", "mFeedConfig", "Lcom/baidu/live/business/model/data/LiveFeedConfig;", "mHasMore", "", "mList", "Ljava/util/ArrayList;", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "Lkotlin/collections/ArrayList;", "onOperationItemListener", "com/baidu/live/business/adapter/LiveSubTabAdapter$onOperationItemListener$1", "Lcom/baidu/live/business/adapter/LiveSubTabAdapter$onOperationItemListener$1;", "getScene", "()Ljava/lang/String;", "getThirdLevelTab", "setThirdLevelTab", "(Ljava/lang/String;)V", "addNew", "", "list", "", "getItemCount", "", "getItemViewType", "position", "getTopicRoomType", "roomEntity", "handleHasMore", "holder", "Lcom/baidu/live/business/base/LiveFeedBaseHolder;", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "setFeedConfig", "feedConfig", "setHasMore", "hasMore", "updateData", "Companion", "ItemViewListener", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveSubTabAdapter.kt */
public final class LiveSubTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_BANNER = 4;
    public static final int TYPE_FOOTER = -1;
    public static final int TYPE_GAME_16_9 = 3;
    public static final int TYPE_HEADER_RESERVE = -2;
    public static final int TYPE_MORE_REC_TITLE = 300;
    public static final int TYPE_REC_COMMON = 7;
    public static final int TYPE_SHOPPING_4_5 = 1;
    public static final int TYPE_SHOW_4_5 = 2;
    public static final int TYPE_SUB_CHANEL_BANNER = 6;
    public static final int TYPE_TOPIC_16_9 = 101;
    public static final int TYPE_TOPIC_4_5 = 100;
    public static final int TYPE_ZONE_BANNER = 202;
    public static final int TYPE_ZONE_MARKET = 203;
    public static final int TYPE_ZONE_MARKET_LIST = 204;
    public static final int TYPE_ZONE_PREFER_RECOMMEND = 201;
    private LiveSubTabAdapter$bannerListener$1 bannerListener = new LiveSubTabAdapter$bannerListener$1(this);
    private final Context context;
    private String curRoomId;
    private ItemViewListener itemViewListener;
    private LiveFeedConfig mFeedConfig;
    private boolean mHasMore;
    /* access modifiers changed from: private */
    public ArrayList<LiveRoomEntity> mList = new ArrayList<>();
    private LiveSubTabAdapter$onOperationItemListener$1 onOperationItemListener = new LiveSubTabAdapter$onOperationItemListener$1(this);
    private final String scene;
    private final String secondLevelTab;
    private String thirdLevelTab;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\"\u0010\u0017\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH&¨\u0006\u0019"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter$ItemViewListener;", "", "onBannerItemClick", "", "bannerEntity", "Lcom/baidu/live/business/model/data/LiveBannerEntity;", "onBannerItemShow", "onHeaderReserveClick", "content", "", "onHeaderReserveShow", "onItemChangeData", "liveRoomEntity", "Lcom/baidu/live/business/model/data/LiveRoomEntity;", "position", "", "onItemLabelClickListener", "cmd", "pos", "roomEntity", "onItemViewClick", "onItemViewRecycled", "onItemViewShow", "onPreferCardShow", "batch", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSubTabAdapter.kt */
    public interface ItemViewListener {
        void onBannerItemClick(LiveBannerEntity liveBannerEntity);

        void onBannerItemShow(LiveBannerEntity liveBannerEntity);

        void onHeaderReserveClick(String str);

        void onHeaderReserveShow(String str);

        void onItemChangeData(LiveRoomEntity liveRoomEntity, int i2);

        void onItemLabelClickListener(String str, int i2, LiveRoomEntity liveRoomEntity);

        void onItemViewClick(LiveRoomEntity liveRoomEntity, int i2);

        void onItemViewRecycled(int i2);

        void onItemViewShow(LiveRoomEntity liveRoomEntity, int i2);

        void onPreferCardShow(LiveRoomEntity liveRoomEntity, int i2, int i3);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getThirdLevelTab() {
        return this.thirdLevelTab;
    }

    public final void setThirdLevelTab(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.thirdLevelTab = str;
    }

    public LiveSubTabAdapter(Context context2, String scene2, String secondLevelTab2, String thirdLevelTab2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(scene2, "scene");
        Intrinsics.checkNotNullParameter(secondLevelTab2, "secondLevelTab");
        Intrinsics.checkNotNullParameter(thirdLevelTab2, "thirdLevelTab");
        this.context = context2;
        this.scene = scene2;
        this.secondLevelTab = secondLevelTab2;
        this.thirdLevelTab = thirdLevelTab2;
    }

    public final ItemViewListener getItemViewListener() {
        return this.itemViewListener;
    }

    public final void setItemViewListener(ItemViewListener itemViewListener2) {
        this.itemViewListener = itemViewListener2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/live/business/adapter/LiveSubTabAdapter$Companion;", "", "()V", "TYPE_BANNER", "", "TYPE_FOOTER", "TYPE_GAME_16_9", "TYPE_HEADER_RESERVE", "TYPE_MORE_REC_TITLE", "TYPE_REC_COMMON", "TYPE_SHOPPING_4_5", "TYPE_SHOW_4_5", "TYPE_SUB_CHANEL_BANNER", "TYPE_TOPIC_16_9", "TYPE_TOPIC_4_5", "TYPE_ZONE_BANNER", "TYPE_ZONE_MARKET", "TYPE_ZONE_MARKET_LIST", "TYPE_ZONE_PREFER_RECOMMEND", "lib-live-feed-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LiveSubTabAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public LiveFeedBaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case -2:
                LiveReserveHeaderView liveReserveHeaderView = new LiveReserveHeaderView(this.context);
                LiveReserveHeaderView $this$onCreateViewHolder_u24lambda_u2d0 = liveReserveHeaderView;
                $this$onCreateViewHolder_u24lambda_u2d0.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d0.onDarkModeChange(UIModeUtils.getInstance().getUiMode());
                return new LiveFeedBaseHolder(liveReserveHeaderView);
            case -1:
                LiveLoadMoreView $this$onCreateViewHolder_u24lambda_u2d4 = new LiveLoadMoreView(this.context);
                $this$onCreateViewHolder_u24lambda_u2d4.setScene(this.scene);
                return new LiveFeedBaseHolder($this$onCreateViewHolder_u24lambda_u2d4);
            case 1:
                Live4Ratio5ItemView live4Ratio5ItemView = new Live4Ratio5ItemView(this.context);
                Live4Ratio5ItemView $this$onCreateViewHolder_u24lambda_u2d1 = live4Ratio5ItemView;
                $this$onCreateViewHolder_u24lambda_u2d1.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d1.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live4Ratio5ItemView);
            case 2:
                Live4Ratio5ItemView live4Ratio5ItemView2 = new Live4Ratio5ItemView(this.context);
                Live4Ratio5ItemView $this$onCreateViewHolder_u24lambda_u2d2 = live4Ratio5ItemView2;
                $this$onCreateViewHolder_u24lambda_u2d2.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d2.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live4Ratio5ItemView2);
            case 4:
                Live4Ratio5BannerItemView live4Ratio5BannerItemView = new Live4Ratio5BannerItemView(this.context);
                Live4Ratio5BannerItemView $this$onCreateViewHolder_u24lambda_u2d3 = live4Ratio5BannerItemView;
                $this$onCreateViewHolder_u24lambda_u2d3.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d3.setBannerClickListener(this.bannerListener);
                return new LiveFeedBaseHolder(live4Ratio5BannerItemView);
            case 6:
                LiveHorizontalBannerItemView liveHorizontalBannerItemView = new LiveHorizontalBannerItemView(this.context);
                LiveHorizontalBannerItemView $this$onCreateViewHolder_u24lambda_u2d8 = liveHorizontalBannerItemView;
                $this$onCreateViewHolder_u24lambda_u2d8.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d8.setBannerClickListener(this.bannerListener);
                $this$onCreateViewHolder_u24lambda_u2d8.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(liveHorizontalBannerItemView);
            case 7:
                Live1Ratio1ItemView live1Ratio1ItemView = new Live1Ratio1ItemView(this.context);
                Live1Ratio1ItemView $this$onCreateViewHolder_u24lambda_u2d7 = live1Ratio1ItemView;
                $this$onCreateViewHolder_u24lambda_u2d7.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d7.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live1Ratio1ItemView);
            case 100:
                Live4Ratio5TopicView live4Ratio5TopicView = new Live4Ratio5TopicView(this.context);
                Live4Ratio5TopicView $this$onCreateViewHolder_u24lambda_u2d5 = live4Ratio5TopicView;
                $this$onCreateViewHolder_u24lambda_u2d5.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d5.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live4Ratio5TopicView);
            case 101:
                Live16Ratio9TopicView live16Ratio9TopicView = new Live16Ratio9TopicView(this.context);
                Live16Ratio9TopicView $this$onCreateViewHolder_u24lambda_u2d6 = live16Ratio9TopicView;
                $this$onCreateViewHolder_u24lambda_u2d6.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d6.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live16Ratio9TopicView);
            case 201:
                LivePreferRecommendView livePreferRecommendView = new LivePreferRecommendView(this.context);
                LivePreferRecommendView $this$onCreateViewHolder_u24lambda_u2d9 = livePreferRecommendView;
                $this$onCreateViewHolder_u24lambda_u2d9.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d9.setOnZoneItemListener(this.onOperationItemListener);
                $this$onCreateViewHolder_u24lambda_u2d9.initUiScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d9.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(livePreferRecommendView);
            case 202:
                LiveHorizontalBannerItemView liveHorizontalBannerItemView2 = new LiveHorizontalBannerItemView(this.context);
                LiveHorizontalBannerItemView $this$onCreateViewHolder_u24lambda_u2d10 = liveHorizontalBannerItemView2;
                $this$onCreateViewHolder_u24lambda_u2d10.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d10.setBannerClickListener(this.bannerListener);
                $this$onCreateViewHolder_u24lambda_u2d10.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(liveHorizontalBannerItemView2);
            case 203:
                LiveMarketItemBigView liveMarketItemBigView = new LiveMarketItemBigView(this.context);
                LiveMarketItemBigView $this$onCreateViewHolder_u24lambda_u2d11 = liveMarketItemBigView;
                $this$onCreateViewHolder_u24lambda_u2d11.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d11.setBannerClickListener(this.bannerListener);
                $this$onCreateViewHolder_u24lambda_u2d11.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(liveMarketItemBigView);
            case 204:
                LiveMarketView liveMarketView = new LiveMarketView(this.context);
                LiveMarketView $this$onCreateViewHolder_u24lambda_u2d12 = liveMarketView;
                $this$onCreateViewHolder_u24lambda_u2d12.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d12.initUiScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d12.setBannerClickListener(this.bannerListener);
                $this$onCreateViewHolder_u24lambda_u2d12.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(liveMarketView);
            case 300:
                LiveMoreRecTitleView $this$onCreateViewHolder_u24lambda_u2d13 = new LiveMoreRecTitleView(this.context);
                $this$onCreateViewHolder_u24lambda_u2d13.setScene(this.scene);
                return new LiveFeedBaseHolder($this$onCreateViewHolder_u24lambda_u2d13);
            default:
                Live16Ratio9ItemView live16Ratio9ItemView = new Live16Ratio9ItemView(this.context);
                Live16Ratio9ItemView $this$onCreateViewHolder_u24lambda_u2d14 = live16Ratio9ItemView;
                $this$onCreateViewHolder_u24lambda_u2d14.setScene(this.scene);
                $this$onCreateViewHolder_u24lambda_u2d14.setFeedConfig(this.mFeedConfig);
                return new LiveFeedBaseHolder(live16Ratio9ItemView);
        }
    }

    public final void setHasMore(boolean hasMore) {
        this.mHasMore = hasMore;
    }

    public final void setFeedConfig(LiveFeedConfig feedConfig) {
        this.mFeedConfig = feedConfig;
    }

    public int getItemCount() {
        ArrayList<LiveRoomEntity> arrayList = this.mList;
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        return this.mList.size() + 1;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        LiveFeedBaseHolder liveFeedBaseHolder = (LiveFeedBaseHolder) holder;
        if (((LiveFeedBaseHolder) holder).getItemViewType() == -2) {
            if (((LiveFeedBaseHolder) holder).mRoot instanceof LiveReserveHeaderView) {
                LiveBaseItemView liveBaseItemView = ((LiveFeedBaseHolder) holder).mRoot;
                if (liveBaseItemView != null) {
                    ((LiveReserveHeaderView) liveBaseItemView).setData(this.mList.get(position).reserveHeaderInfo);
                    LiveBaseItemView liveBaseItemView2 = ((LiveFeedBaseHolder) holder).mRoot;
                    if (liveBaseItemView2 != null) {
                        ((LiveReserveHeaderView) liveBaseItemView2).onDarkModeChange(UIModeUtils.getInstance().getUiMode());
                        LiveBaseItemView liveBaseItemView3 = ((LiveFeedBaseHolder) holder).mRoot;
                        if (liveBaseItemView3 != null) {
                            ((LiveReserveHeaderView) liveBaseItemView3).setOnClickListener(new LiveSubTabAdapter$$ExternalSyntheticLambda0(this, position, holder));
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
            }
        } else if (position + 1 < getItemCount()) {
            LiveRoomEntity liveRoomEntity = this.mList.get(position);
            LiveRoomEntity $this$onBindViewHolder_u24lambda_u2d16 = liveRoomEntity;
            $this$onBindViewHolder_u24lambda_u2d16.belongSubTab = this.secondLevelTab;
            $this$onBindViewHolder_u24lambda_u2d16.belongThirdTab = this.thirdLevelTab;
            Intrinsics.checkNotNullExpressionValue(liveRoomEntity, "mList[position].apply {\n…irdLevelTab\n            }");
            LiveRoomEntity liveRoomEntity2 = liveRoomEntity;
            ((LiveFeedBaseHolder) holder).mRoot.setData(liveRoomEntity2, position);
            ((LiveFeedBaseHolder) holder).mRoot.setIsCurViewing(Intrinsics.areEqual((Object) this.curRoomId, (Object) liveRoomEntity2.roomId));
            ((LiveFeedBaseHolder) holder).mRoot.setCurRoomId(this.curRoomId);
            if (((LiveFeedBaseHolder) holder).getItemViewType() == 100 || ((LiveFeedBaseHolder) holder).getItemViewType() == 101) {
                ((LiveFeedBaseHolder) holder).mRoot.setOnTopicItemClickListener(new LiveSubTabAdapter$onBindViewHolder$2(liveRoomEntity2, this, position));
            } else if (((LiveFeedBaseHolder) holder).getItemViewType() == 201) {
                ((LiveFeedBaseHolder) holder).mRoot.setOnZoneItemListener(this.onOperationItemListener);
            } else {
                holder.itemView.setOnClickListener(new LiveSubTabAdapter$$ExternalSyntheticLambda1(this, liveRoomEntity2, position));
                ItemViewListener itemViewListener2 = this.itemViewListener;
                if (itemViewListener2 != null) {
                    itemViewListener2.onItemViewShow(liveRoomEntity2, position);
                }
            }
            ((LiveFeedBaseHolder) holder).mRoot.setOnLabelClickListener(new LiveSubTabAdapter$$ExternalSyntheticLambda2(this, position, liveRoomEntity2));
        } else if (position + 1 == getItemCount()) {
            handleHasMore((LiveFeedBaseHolder) holder);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-15  reason: not valid java name */
    public static final void m13886onBindViewHolder$lambda15(LiveSubTabAdapter this$0, int $position, RecyclerView.ViewHolder $holder, View it) {
        ItemViewListener itemViewListener2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        if (!LiveFastClickHelper.isFastClick() && this$0.mList.get($position).reserveHeaderInfo != null && (itemViewListener2 = this$0.itemViewListener) != null) {
            LiveBaseItemView liveBaseItemView = ((LiveFeedBaseHolder) $holder).mRoot;
            if (liveBaseItemView != null) {
                itemViewListener2.onHeaderReserveClick(((LiveReserveHeaderView) liveBaseItemView).getTip());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveReserveHeaderView");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-17  reason: not valid java name */
    public static final void m13887onBindViewHolder$lambda17(LiveSubTabAdapter this$0, LiveRoomEntity $liveRoomEntity, int $position, View it) {
        ItemViewListener itemViewListener2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($liveRoomEntity, "$liveRoomEntity");
        if (!LiveFastClickHelper.isFastClick() && (itemViewListener2 = this$0.itemViewListener) != null) {
            itemViewListener2.onItemViewClick($liveRoomEntity, $position);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-18  reason: not valid java name */
    public static final void m13888onBindViewHolder$lambda18(LiveSubTabAdapter this$0, int $position, LiveRoomEntity $liveRoomEntity, String it) {
        ItemViewListener itemViewListener2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($liveRoomEntity, "$liveRoomEntity");
        if (!LiveFastClickHelper.isFastClick() && (itemViewListener2 = this$0.itemViewListener) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            itemViewListener2.onItemLabelClickListener(it, $position, $liveRoomEntity);
        }
    }

    private final void handleHasMore(LiveFeedBaseHolder holder) {
        if (holder.mRoot != null) {
            if (Intrinsics.areEqual((Object) this.scene, (Object) "video_bar")) {
                LiveBaseItemView liveBaseItemView = holder.mRoot;
                if (liveBaseItemView != null) {
                    ((LiveLoadMoreView) liveBaseItemView).setVisibility(8);
                    LiveBaseItemView liveBaseItemView2 = holder.mRoot;
                    if (liveBaseItemView2 != null) {
                        ((LiveLoadMoreView) liveBaseItemView2).hideLoadMoreView();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
            } else if (holder.mRoot instanceof LiveLoadMoreView) {
                LiveBaseItemView liveBaseItemView3 = holder.mRoot;
                if (liveBaseItemView3 != null) {
                    ((LiveLoadMoreView) liveBaseItemView3).onSceneChange(this.scene);
                    if (this.mHasMore) {
                        LiveBaseItemView liveBaseItemView4 = holder.mRoot;
                        if (liveBaseItemView4 != null) {
                            ((LiveLoadMoreView) liveBaseItemView4).setLoadMoreLabel(R.string.live_feed_page_load_more_label);
                            LiveBaseItemView liveBaseItemView5 = holder.mRoot;
                            if (liveBaseItemView5 != null) {
                                ((LiveLoadMoreView) liveBaseItemView5).setAnimViewVisibility(0);
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                    }
                    if (Intrinsics.areEqual((Object) LiveFeedPageSdk.HOST_QUANMIN, (Object) LiveFeedPageSdk.getInstance().getHost())) {
                        LiveBaseItemView liveBaseItemView6 = holder.mRoot;
                        if (liveBaseItemView6 != null) {
                            ((LiveLoadMoreView) liveBaseItemView6).setLoadMoreLabel(R.string.live_feed_page_load_no_more_label_qm);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                        }
                    } else {
                        LiveBaseItemView liveBaseItemView7 = holder.mRoot;
                        if (liveBaseItemView7 != null) {
                            ((LiveLoadMoreView) liveBaseItemView7).setLoadMoreLabel(R.string.live_feed_page_load_no_more_label);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                        }
                    }
                    LiveBaseItemView liveBaseItemView8 = holder.mRoot;
                    if (liveBaseItemView8 != null) {
                        ((LiveLoadMoreView) liveBaseItemView8).setAnimViewVisibility(8);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.live.business.LiveLoadMoreView");
            }
        }
    }

    public int getItemViewType(int position) {
        if (position + 1 >= getItemCount()) {
            return -1;
        }
        LiveRoomEntity liveRoomEntity = this.mList.get(position);
        Intrinsics.checkNotNullExpressionValue(liveRoomEntity, "mList[position]");
        LiveRoomEntity roomEntity = liveRoomEntity;
        if (this.mList.get(position).reserveHeaderInfo != null) {
            return -2;
        }
        if (roomEntity.isTopicRoom()) {
            return getTopicRoomType(roomEntity);
        }
        if (roomEntity.showType == 1) {
            return 201;
        }
        if (roomEntity.showType == 2) {
            return 202;
        }
        if (roomEntity.showType != 3) {
            return roomEntity.showTpl;
        }
        if (roomEntity.bannerList == null || roomEntity.bannerList.size() != 1) {
            return 204;
        }
        return 203;
    }

    private final int getTopicRoomType(LiveRoomEntity roomEntity) {
        switch (roomEntity.getTopicItemShowTpl()) {
            case 1:
            case 2:
                return 100;
            default:
                return 101;
        }
    }

    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(layoutParams, "holder.itemView.layoutParams");
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            int position = holder.getLayoutPosition();
            if (getItemViewType(position) == -2 || getItemViewType(position) == -1 || getItemViewType(position) == 6 || getItemViewType(position) == 202 || getItemViewType(position) == 203 || getItemViewType(position) == 204 || getItemViewType(position) == 300 || getItemViewType(position) == 201) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
        }
        if ((holder instanceof LiveFeedBaseHolder) != 0) {
            ((LiveFeedBaseHolder) holder).onViewAttached();
        }
    }

    public static /* synthetic */ void addNew$default(LiveSubTabAdapter liveSubTabAdapter, List list, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        liveSubTabAdapter.addNew(list, str);
    }

    public final void addNew(List<? extends LiveRoomEntity> list, String curRoomId2) {
        updateData(list);
        if (!Intrinsics.areEqual((Object) this.curRoomId, (Object) curRoomId2)) {
            this.curRoomId = curRoomId2;
        }
        notifyDataSetChanged();
    }

    public final void updateData(List<? extends LiveRoomEntity> list) {
        if (list != null) {
            this.mList.clear();
            this.mList.addAll(list);
        }
    }

    public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof LiveFeedBaseHolder) {
            ((LiveFeedBaseHolder) holder).onViewDetached();
        }
    }

    public void onViewRecycled(RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewRecycled(holder);
        if (holder instanceof LiveFeedBaseHolder) {
            ((LiveFeedBaseHolder) holder).onViewRecycled();
        }
        ItemViewListener itemViewListener2 = this.itemViewListener;
        if (itemViewListener2 != null) {
            itemViewListener2.onItemViewRecycled(holder.getAdapterPosition());
        }
    }
}
