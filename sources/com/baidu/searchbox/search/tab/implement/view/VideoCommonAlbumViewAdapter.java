package com.baidu.searchbox.search.tab.implement.view;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.model.CString;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedTemplateImpl;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.baidu.searchbox.search.tab.core.manager.IComponentManager;
import com.baidu.searchbox.search.tab.implement.player.helper.IListPlayerContext;
import com.baidu.searchbox.search.tab.implement.service.ISkipToastService;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoExtLog;
import com.baidu.searchbox.search.tab.implement.tplview.VideoCommonAlbumMainChainStrongView;
import com.baidu.searchbox.search.tab.utils.FastClickUtils;
import com.baidu.searchbox.search.tab.utils.SearchVideoTcUtils;
import com.baidu.searchbox.search.tab.utils.VideoLoftCmdUtils;
import com.baidu.searchbox.search.video.business.R;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003GHIB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00104\u001a\u00020\u0013H\u0016J\u0010\u00105\u001a\u00020\u00132\u0006\u00106\u001a\u00020\u0013H\u0016J\f\u00107\u001a\b\u0018\u00010!R\u00020\u0000J\u000e\u00108\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100J\u0010\u00109\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010$J\u0018\u0010;\u001a\u00020(2\u0006\u0010<\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0013H\u0016J\u0018\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0013H\u0016J\u0012\u0010A\u001a\u00020(2\b\u0010B\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010C\u001a\u00020(2\b\u0010D\u001a\u0004\u0018\u00010.J\u0010\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020\u0013H\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0018\u00010\u0019R\u00020\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0018\u00010!R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R9\u0010\"\u001a!\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020(\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "feedTemplateImplBase", "Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;", "slideView", "Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonAlbumMainChainStrongView;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonAlbumMainChainStrongView;)V", "albumModel", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel;", "getContext", "()Landroid/content/Context;", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getFeedTemplateImplBase", "()Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;", "itemWidth", "", "getItemWidth", "()I", "setItemWidth", "(I)V", "mMoreItemClick", "Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreItemClick;", "getMMoreItemClick", "()Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreItemClick;", "setMMoreItemClick", "(Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreItemClick;)V", "moreCmd", "", "moreViewHolder", "Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreViewHolder;", "onMoreItemClickReportTc", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnMoreItemClickReportTc", "()Lkotlin/jvm/functions/Function1;", "setOnMoreItemClickReportTc", "(Lkotlin/jvm/functions/Function1;)V", "playerHelper", "Lcom/baidu/searchbox/search/tab/implement/player/helper/IListPlayerContext;", "slideCardArray", "", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel$SlideCardEntity;", "getSlideView", "()Lcom/baidu/searchbox/search/tab/implement/tplview/VideoCommonAlbumMainChainStrongView;", "getItemCount", "getItemViewType", "position", "getMoreViewHolder", "getSlideCardList", "moreItemClick", "v", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "feedBaseModel", "setListPlayerHelper", "listPlayerContext", "updateLottie", "pos", "DataViewHolder", "MoreItemClick", "MoreViewHolder", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonAlbumViewAdapter.kt */
public final class VideoCommonAlbumViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private VideoCommonAlbumMainChainStrongModel albumModel;
    private final Context context;
    /* access modifiers changed from: private */
    public FeedBaseModel feedModel;
    private final FeedTemplateImpl feedTemplateImplBase;
    private int itemWidth = -1;
    private MoreItemClick mMoreItemClick;
    private String moreCmd = "";
    private MoreViewHolder moreViewHolder;
    private Function1<? super View, Unit> onMoreItemClickReportTc;
    /* access modifiers changed from: private */
    public IListPlayerContext playerHelper;
    /* access modifiers changed from: private */
    public List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> slideCardArray;
    private final VideoCommonAlbumMainChainStrongView slideView;

    public final Context getContext() {
        return this.context;
    }

    public final FeedTemplateImpl getFeedTemplateImplBase() {
        return this.feedTemplateImplBase;
    }

    public VideoCommonAlbumViewAdapter(Context context2, FeedTemplateImpl feedTemplateImplBase2, VideoCommonAlbumMainChainStrongView slideView2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(feedTemplateImplBase2, "feedTemplateImplBase");
        Intrinsics.checkNotNullParameter(slideView2, "slideView");
        this.context = context2;
        this.feedTemplateImplBase = feedTemplateImplBase2;
        this.slideView = slideView2;
    }

    public final VideoCommonAlbumMainChainStrongView getSlideView() {
        return this.slideView;
    }

    public final MoreItemClick getMMoreItemClick() {
        return this.mMoreItemClick;
    }

    public final void setMMoreItemClick(MoreItemClick moreItemClick) {
        this.mMoreItemClick = moreItemClick;
    }

    public final Function1<View, Unit> getOnMoreItemClickReportTc() {
        return this.onMoreItemClickReportTc;
    }

    public final void setOnMoreItemClickReportTc(Function1<? super View, Unit> function1) {
        this.onMoreItemClickReportTc = function1;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final void setItemWidth(int i2) {
        this.itemWidth = i2;
    }

    public final void setData(FeedBaseModel feedBaseModel) {
        CString cString;
        this.feedModel = feedBaseModel;
        List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> list = null;
        if ((feedBaseModel != null ? feedBaseModel.data : null) instanceof VideoCommonAlbumMainChainStrongModel) {
            FeedItemData feedItemData = feedBaseModel.data;
            if (feedItemData != null) {
                VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = (VideoCommonAlbumMainChainStrongModel) feedItemData;
                this.albumModel = videoCommonAlbumMainChainStrongModel;
                this.moreCmd = (videoCommonAlbumMainChainStrongModel == null || (cString = videoCommonAlbumMainChainStrongModel.cmd) == null) ? null : cString.get();
                VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel2 = this.albumModel;
                if (videoCommonAlbumMainChainStrongModel2 != null) {
                    list = videoCommonAlbumMainChainStrongModel2.getSlideCardMainList();
                }
                this.slideCardArray = list;
                notifyDataSetChanged();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel");
        }
    }

    public final void updateLottie(int pos) {
        List it = this.slideCardArray;
        if (it != null) {
            if (!(!it.isEmpty())) {
                it = null;
            }
            if (it != null) {
                int index = 0;
                int size = it.size();
                while (index < size) {
                    List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> list = this.slideCardArray;
                    VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity = list != null ? list.get(index) : null;
                    if (slideCardEntity != null) {
                        slideCardEntity.setSelected(index == pos);
                    }
                    index++;
                }
                notifyDataSetChanged();
            }
        }
    }

    public final List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> getSlideCardList() {
        return this.slideCardArray;
    }

    public final MoreViewHolder getMoreViewHolder() {
        return this.moreViewHolder;
    }

    public final void setListPlayerHelper(IListPlayerContext listPlayerContext) {
        this.playerHelper = listPlayerContext;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        if (viewType == 2) {
            View view2 = LayoutInflater.from(this.context).inflate(R.layout.feed_tpl_search_video_album_more, parent, false);
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            MoreViewHolder moreViewHolder2 = new MoreViewHolder(this, view2);
            this.moreViewHolder = moreViewHolder2;
            return moreViewHolder2;
        }
        View view3 = LayoutInflater.from(this.context).inflate(R.layout.video_common_main_chain_item, parent, false);
        if (this.itemWidth > 0) {
            ViewGroup.LayoutParams layoutParams = null;
            ViewGroup.LayoutParams layoutParams2 = view3 != null ? view3.getLayoutParams() : null;
            if (layoutParams2 != null) {
                layoutParams2.width = this.itemWidth;
            }
            if (view3 != null) {
                layoutParams = view3.getLayoutParams();
            }
            if (layoutParams != null) {
                layoutParams.height = (this.itemWidth * 2) / 3;
            }
        }
        Intrinsics.checkNotNullExpressionValue(view3, "view");
        return new DataViewHolder(this, view3);
    }

    public int getItemCount() {
        List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> list = this.slideCardArray;
        int num = list != null ? list.size() : 0;
        if (num >= 6) {
            return num + 1;
        }
        return num;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        switch (getItemViewType(position)) {
            case 1:
                DataViewHolder dataViewHolder = (DataViewHolder) holder;
                List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> list = this.slideCardArray;
                dataViewHolder.update(list != null ? list.get(position) : null, position);
                return;
            case 2:
                ((MoreViewHolder) holder).update();
                return;
            default:
                return;
        }
    }

    public int getItemViewType(int position) {
        if (getItemCount() < 6 || position != getItemCount() - 1) {
            return 1;
        }
        return 2;
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u001a\u0010\u001c\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u001bH\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$DataViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;Landroid/view/View;)V", "container", "Landroid/view/ViewGroup;", "getContainer", "()Landroid/view/ViewGroup;", "lottieView", "Lcom/airbnb/lottie/LottieAnimationView;", "mask", "Landroid/widget/ImageView;", "poster", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "getPoster", "()Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "poster$delegate", "Lkotlin/Lazy;", "tvOrder", "Landroid/widget/TextView;", "itemClick", "", "v", "slideCardEntity", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel$SlideCardEntity;", "pos", "", "update", "position", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoCommonAlbumViewAdapter.kt */
    public final class DataViewHolder extends RecyclerView.ViewHolder {
        private final ViewGroup container;
        private final LottieAnimationView lottieView;
        private final ImageView mask;
        private final Lazy poster$delegate;
        final /* synthetic */ VideoCommonAlbumViewAdapter this$0;
        private final TextView tvOrder;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(VideoCommonAlbumViewAdapter this$02, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$02;
            View findViewById = itemView.findViewById(R.id.video_slide_card_container);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…deo_slide_card_container)");
            this.container = (ViewGroup) findViewById;
            View findViewById2 = itemView.findViewById(R.id.video_slide_card_order);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.video_slide_card_order)");
            this.tvOrder = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.video_slide_card_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.video_slide_card_icon)");
            this.lottieView = (LottieAnimationView) findViewById3;
            View findViewById4 = itemView.findViewById(R.id.video_slide_card_mask);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.video_slide_card_mask)");
            this.mask = (ImageView) findViewById4;
            this.poster$delegate = LazyKt.lazy(new VideoCommonAlbumViewAdapter$DataViewHolder$poster$2(itemView));
            getPoster().setTemplateFlag(14);
            FeedTemplateImgCornersUtil.processSingleImgRoundCorner(getPoster(), VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS, VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS, VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS, VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS);
        }

        public final ViewGroup getContainer() {
            return this.container;
        }

        private final FeedDraweeView getPoster() {
            return (FeedDraweeView) this.poster$delegate.getValue();
        }

        /* access modifiers changed from: private */
        /* renamed from: update$lambda-0  reason: not valid java name */
        public static final void m2848update$lambda0(DataViewHolder this$02, VideoCommonAlbumMainChainStrongModel.SlideCardEntity $slideCardEntity, int $position, View v) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            Intrinsics.checkNotNullExpressionValue(v, "v");
            this$02.itemClick(v, $slideCardEntity, $position);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0049, code lost:
            r1 = r6.getVideoInfo();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void update(com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel.SlideCardEntity r6, int r7) {
            /*
                r5 = this;
                android.view.ViewGroup r0 = r5.container
                com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter$DataViewHolder$$ExternalSyntheticLambda0 r1 = new com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter$DataViewHolder$$ExternalSyntheticLambda0
                r1.<init>(r5, r6, r7)
                r0.setOnClickListener(r1)
                android.widget.TextView r0 = r5.tvOrder
                int r1 = r7 + 1
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                android.widget.TextView r0 = r5.tvOrder
                com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter r1 = r5.this$0
                android.content.Context r1 = r1.getContext()
                int r2 = com.baidu.searchbox.search.video.business.R.drawable.bg_search_video_album_order
                android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r2)
                r0.setBackground(r1)
                android.widget.TextView r0 = r5.tvOrder
                if (r0 == 0) goto L_0x003f
                com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter r1 = r5.this$0
                android.content.Context r1 = r1.getContext()
                android.content.res.Resources r1 = r1.getResources()
                int r2 = com.baidu.searchbox.search.style.res.R.color.SC10
                int r1 = r1.getColor(r2)
                r0.setTextColor(r1)
            L_0x003f:
                com.baidu.searchbox.feed.template.FeedDraweeView r0 = r5.getPoster()
                com.baidu.searchbox.feed.template.FeedDraweeView r0 = r0.setPlaceHolderWithSelfFlag()
                if (r6 == 0) goto L_0x0054
                com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity$SlideVideoInfo r1 = r6.getVideoInfo()
                if (r1 == 0) goto L_0x0054
                java.lang.String r1 = r1.getPosterImage()
                goto L_0x0055
            L_0x0054:
                r1 = 0
            L_0x0055:
                com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter r2 = r5.this$0
                com.baidu.searchbox.feed.model.FeedBaseModel r2 = r2.feedModel
                r0.loadImage(r1, r2)
                com.baidu.searchbox.feed.template.FeedDraweeView r0 = r5.getPoster()
                int r1 = com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS
                int r2 = com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS
                int r3 = com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS
                int r4 = com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapterKt.ROUND_CORNER_RADIUS
                com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil.processSingleImgRoundCorner(r0, r1, r2, r3, r4)
                r0 = 1
                r1 = 0
                if (r6 == 0) goto L_0x0080
                boolean r2 = r6.getSelected()
                if (r2 != r0) goto L_0x0080
                goto L_0x0081
            L_0x0080:
                r0 = r1
            L_0x0081:
                if (r0 == 0) goto L_0x00b0
                boolean r0 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
                if (r0 != 0) goto L_0x0092
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                java.lang.String r2 = "search_tab_album.json"
                r0.setAnimation((java.lang.String) r2)
                goto L_0x009a
            L_0x0092:
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                java.lang.String r2 = "search_tab_album_night.json"
                r0.setAnimation((java.lang.String) r2)
            L_0x009a:
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                r2 = -1
                r0.setRepeatCount(r2)
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                r0.setVisibility(r1)
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                r0.playAnimation()
                android.widget.ImageView r0 = r5.mask
                r0.setVisibility(r1)
                goto L_0x00c9
            L_0x00b0:
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                boolean r0 = r0.isAnimating()
                if (r0 == 0) goto L_0x00bd
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                r0.cancelAnimation()
            L_0x00bd:
                com.airbnb.lottie.LottieAnimationView r0 = r5.lottieView
                r1 = 8
                r0.setVisibility(r1)
                android.widget.ImageView r0 = r5.mask
                r0.setVisibility(r1)
            L_0x00c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.implement.view.VideoCommonAlbumViewAdapter.DataViewHolder.update(com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonAlbumMainChainStrongModel$SlideCardEntity, int):void");
        }

        private final void itemClick(View v, VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity, int pos) {
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity2;
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo;
            CharSequence vid;
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo2;
            String $this$itemClick_u24lambda_u2d2;
            ISkipToastService iSkipToastService;
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo3;
            if (!FastClickUtils.Companion.getInstance().fastClick()) {
                List access$getSlideCardArray$p = this.this$0.slideCardArray;
                boolean z = false;
                int length = access$getSlideCardArray$p != null ? access$getSlideCardArray$p.size() : 0;
                int index = 0;
                while (true) {
                    boolean z2 = true;
                    slideCardEntity2 = null;
                    if (index >= length) {
                        break;
                    }
                    List access$getSlideCardArray$p2 = this.this$0.slideCardArray;
                    if (access$getSlideCardArray$p2 != null) {
                        slideCardEntity2 = (VideoCommonAlbumMainChainStrongModel.SlideCardEntity) access$getSlideCardArray$p2.get(index);
                    }
                    if (slideCardEntity2 != null) {
                        if (index != pos) {
                            z2 = false;
                        }
                        slideCardEntity2.setSelected(z2);
                    }
                    index++;
                }
                v.setTag(com.baidu.searchbox.feed.core.R.id.tag_1, slideCardEntity);
                if (!TextUtils.isEmpty(slideCardEntity != null ? slideCardEntity.getCmd() : null)) {
                    View playerHolder = this.this$0.getSlideView().getAttachedContainer();
                    v.setTag(R.id.search_tab_view_id, this.this$0.getSlideView().getViewId());
                    String newCmd = VideoLoftCmdUtils.updateCmd(new UnitedSchemeEntity(Uri.parse((slideCardEntity == null || (videoInfo3 = slideCardEntity.getVideoInfo()) == null) ? null : videoInfo3.getCmd())), playerHolder, v);
                    String cmd = slideCardEntity != null ? slideCardEntity.getCmd() : null;
                    if (!TextUtils.isEmpty(newCmd)) {
                        cmd = newCmd;
                    }
                    if (!(slideCardEntity == null || (videoInfo2 = slideCardEntity.getVideoInfo()) == null || ($this$itemClick_u24lambda_u2d2 = videoInfo2.getVid()) == null)) {
                        if (!($this$itemClick_u24lambda_u2d2.length() > 0)) {
                            $this$itemClick_u24lambda_u2d2 = null;
                        }
                        if ($this$itemClick_u24lambda_u2d2 != null) {
                            VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter = this.this$0;
                            IListPlayerContext access$getPlayerHelper$p = videoCommonAlbumViewAdapter.playerHelper;
                            if (access$getPlayerHelper$p != null) {
                                access$getPlayerHelper$p.setKLayerCache($this$itemClick_u24lambda_u2d2, 1);
                            }
                            IComponentManager manager = videoCommonAlbumViewAdapter.getSlideView().getManager();
                            if (!(manager == null || (iSkipToastService = (ISkipToastService) manager.getService(ISkipToastService.class)) == null)) {
                                iSkipToastService.addVidRecord($this$itemClick_u24lambda_u2d2);
                            }
                        }
                    }
                    if (!(slideCardEntity == null || (videoInfo = slideCardEntity.getVideoInfo()) == null || (vid = videoInfo.getVid()) == null)) {
                        if (vid.length() > 0) {
                            z = true;
                        }
                        if (z) {
                            slideCardEntity2 = vid;
                        }
                        if (slideCardEntity2 != null) {
                            VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity3 = slideCardEntity2;
                        }
                    }
                    Router.invoke(this.this$0.getContext(), cmd);
                    this.this$0.getFeedTemplateImplBase().onClick(v);
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;Landroid/view/View;)V", "container", "iconMore", "Landroid/widget/ImageView;", "update", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoCommonAlbumViewAdapter.kt */
    public final class MoreViewHolder extends RecyclerView.ViewHolder {
        private final View container;
        private final ImageView iconMore;
        final /* synthetic */ VideoCommonAlbumViewAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MoreViewHolder(VideoCommonAlbumViewAdapter this$02, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$02;
            View findViewById = itemView.findViewById(R.id.video_slide_card_more);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.video_slide_card_more)");
            this.container = findViewById;
            View findViewById2 = itemView.findViewById(R.id.video_slide_card_more_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…deo_slide_card_more_icon)");
            this.iconMore = (ImageView) findViewById2;
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = InvokerUtils.di2pi(52.0f);
            }
            findViewById.setOnClickListener(new VideoCommonAlbumViewAdapter$MoreViewHolder$$ExternalSyntheticLambda0(this$02));
        }

        /* access modifiers changed from: private */
        /* renamed from: _init_$lambda-0  reason: not valid java name */
        public static final void m2849_init_$lambda0(VideoCommonAlbumViewAdapter this$02, View v) {
            Intrinsics.checkNotNullParameter(this$02, "this$0");
            this$02.moreItemClick(v);
        }

        public final void update() {
            this.iconMore.setImageDrawable(ContextCompat.getDrawable(this.this$0.getContext(), R.drawable.search_video_album_more));
        }
    }

    public final void moreItemClick(View v) {
        MoreItemClick $this$moreItemClick_u24lambda_u2d2 = this.mMoreItemClick;
        if ($this$moreItemClick_u24lambda_u2d2 != null) {
            $this$moreItemClick_u24lambda_u2d2.moreItemClick(v);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter$MoreItemClick;", "", "data", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel;", "context", "Landroid/content/Context;", "(Lcom/baidu/searchbox/search/tab/implement/view/VideoCommonAlbumViewAdapter;Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonAlbumMainChainStrongModel;", "moreItemClick", "", "v", "Landroid/view/View;", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoCommonAlbumViewAdapter.kt */
    public final class MoreItemClick {
        private final Context context;
        private final VideoCommonAlbumMainChainStrongModel data;

        public MoreItemClick(VideoCommonAlbumMainChainStrongModel data2, Context context2) {
            this.data = data2;
            this.context = context2;
        }

        public final Context getContext() {
            return this.context;
        }

        public final VideoCommonAlbumMainChainStrongModel getData() {
            return this.data;
        }

        public final void moreItemClick(View v) {
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo;
            VideoExtLog $this$moreItemClick_u24lambda_u2d3_u24lambda_u2d2;
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity.SlideVideoInfo videoInfo2;
            String it;
            ISkipToastService iSkipToastService;
            VideoCommonAlbumMainChainStrongModel videoCommonAlbumMainChainStrongModel = this.data;
            if (videoCommonAlbumMainChainStrongModel == null || videoCommonAlbumMainChainStrongModel.getSlideCardMainList() == null) {
                View view2 = v;
                return;
            }
            VideoCommonAlbumViewAdapter videoCommonAlbumViewAdapter = VideoCommonAlbumViewAdapter.this;
            boolean z = true;
            if (!(!this.data.getSlideCardMainList().isEmpty()) || this.context == null) {
                View view3 = v;
                return;
            }
            List<VideoCommonAlbumMainChainStrongModel.SlideCardEntity> slideCardMainList = this.data.getSlideCardMainList();
            VideoCommonAlbumMainChainStrongView slideView = videoCommonAlbumViewAdapter.getSlideView();
            String str = null;
            VideoCommonAlbumMainChainStrongModel.SlideCardEntity slideCardEntity = slideCardMainList.get((slideView != null ? Integer.valueOf(slideView.getCurrentPlayPosition()) : null).intValue());
            String cmd = slideCardEntity != null ? slideCardEntity.getCmd() : null;
            UnitedSchemeEntity unitedSchemeEntity = new UnitedSchemeEntity(Uri.parse(cmd));
            VideoCommonAlbumMainChainStrongView slideView2 = videoCommonAlbumViewAdapter.getSlideView();
            String newCmd = VideoLoftCmdUtils.updateCmd(unitedSchemeEntity, slideView2 != null ? slideView2.getAttachedContainer() : null, v, (Integer) null, (Integer) null, (String) null);
            if (newCmd != null && (StringsKt.isBlank(newCmd) ^ true)) {
                cmd = newCmd;
            }
            if (!(slideCardEntity == null || (videoInfo2 = slideCardEntity.getVideoInfo()) == null || (it = videoInfo2.getVid()) == null)) {
                if (it.length() <= 0) {
                    z = false;
                }
                if (z) {
                    str = it;
                }
                if (str != null) {
                    String $this$moreItemClick_u24lambda_u2d3_u24lambda_u2d1 = str;
                    IComponentManager manager = videoCommonAlbumViewAdapter.getSlideView().getManager();
                    if (!(manager == null || (iSkipToastService = (ISkipToastService) manager.getService(ISkipToastService.class)) == null)) {
                        iSkipToastService.addVidRecord($this$moreItemClick_u24lambda_u2d3_u24lambda_u2d1);
                    }
                }
            }
            Router.invoke(this.context, cmd);
            if (videoCommonAlbumViewAdapter.getOnMoreItemClickReportTc() != null) {
                Function1<View, Unit> onMoreItemClickReportTc = videoCommonAlbumViewAdapter.getOnMoreItemClickReportTc();
                if (onMoreItemClickReportTc != null) {
                    onMoreItemClickReportTc.invoke(v);
                } else {
                    View view4 = v;
                }
            } else {
                View view5 = v;
                if (slideCardEntity != null && (videoInfo = slideCardEntity.getVideoInfo()) != null && ($this$moreItemClick_u24lambda_u2d3_u24lambda_u2d2 = videoInfo.getExtLog()) != null) {
                    SearchVideoTcUtils.clickTc($this$moreItemClick_u24lambda_u2d3_u24lambda_u2d2.getExtLogString(), false, (String) null, "more_clk", "0", (String) null, (String) null);
                }
            }
        }
    }
}
