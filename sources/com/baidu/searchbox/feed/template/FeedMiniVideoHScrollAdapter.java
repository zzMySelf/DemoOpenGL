package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.media.PreloadUIResUtil;
import com.baidu.searchbox.anim.AnimKt;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeImageViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.abtest.FeedAbtestManager;
import com.baidu.searchbox.feed.ad.AdRuntimeHolder;
import com.baidu.searchbox.feed.availability.image.FeedDraweeCallerContext;
import com.baidu.searchbox.feed.flow.util.AdjustableTextView;
import com.baidu.searchbox.feed.flow.util.FontAdjustment;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedItemMiniVideo;
import com.baidu.searchbox.feed.model.Jsonable;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.evolution.HScrollMoreView;
import com.baidu.searchbox.feed.template.tplinterface.OnScrollItemClickListener;
import com.baidu.searchbox.feed.template.utils.FeedOrderSenseUtil;
import com.baidu.searchbox.feed.template.utils.FeedTemplateImgCornersUtil;
import com.baidu.searchbox.feed.util.FeedUtil;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\b£\u0001¤\u0001¥\u0001¦\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010G\u001a\u00020\u00102\b\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u0010H\u0002J\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020LJ\u0010\u0010N\u001a\u0004\u0018\u00010\u00192\u0006\u0010O\u001a\u00020\u0010J\b\u0010P\u001a\u00020\u0010H\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010O\u001a\u00020\u0010H\u0016J\u0010\u0010S\u001a\u00020\u00102\u0006\u0010O\u001a\u00020\u0010H\u0016J\u0012\u0010T\u001a\u00020/2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J\u000e\u0010U\u001a\u00020/2\u0006\u0010O\u001a\u00020\u0010J\u0010\u0010V\u001a\u00020L2\u0006\u0010W\u001a\u00020XH\u0002J\u0006\u0010Y\u001a\u00020/J\u0010\u0010Z\u001a\u00020L2\u0006\u0010[\u001a\u00020\u001dH\u0016J\u0018\u0010\\\u001a\u00020L2\u0006\u0010]\u001a\u00020^2\u0006\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010_\u001a\u00020L2\u0006\u0010]\u001a\u00020`2\u0006\u0010O\u001a\u00020\u0010H\u0002J\u0018\u0010a\u001a\u00020L2\u0006\u0010]\u001a\u00020b2\u0006\u0010O\u001a\u00020\u0010H\u0002J\u0010\u0010c\u001a\u00020L2\u0006\u0010]\u001a\u00020)H\u0002J\u0018\u0010d\u001a\u00020L2\u0006\u0010]\u001a\u00020\u00022\u0006\u0010O\u001a\u00020\u0010H\u0016J\u0018\u0010e\u001a\u00020\u00022\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0010H\u0016J\u001c\u0010i\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010j\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J\u001c\u0010k\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J6\u0010l\u001a\u00020L2\u0006\u0010]\u001a\u00020`2\u0006\u0010m\u001a\u00020/2\b\u0010n\u001a\u0004\u0018\u00010I2\b\u0010o\u001a\u0004\u0018\u00010I2\b\u0010p\u001a\u0004\u0018\u00010IH\u0002J\u001a\u0010q\u001a\u00020/2\u0006\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010IH\u0002J\u0018\u0010u\u001a\u00020L2\u0006\u0010r\u001a\u00020v2\u0006\u0010w\u001a\u00020IH\u0002J8\u0010u\u001a\u00020L2\u0006\u0010r\u001a\u00020v2\u0006\u0010w\u001a\u00020I2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u00102\u0006\u0010z\u001a\u00020\u00102\u0006\u0010{\u001a\u00020\u0010H\u0002J\u0018\u0010|\u001a\u00020L2\u0006\u0010r\u001a\u00020X2\u0006\u0010O\u001a\u00020\u0010H\u0002J\u001c\u0010}\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J6\u0010~\u001a\u00020L2\u0006\u0010]\u001a\u00020^2\u0006\u0010m\u001a\u00020/2\b\u0010n\u001a\u0004\u0018\u00010I2\b\u0010o\u001a\u0004\u0018\u00010I2\b\u0010p\u001a\u0004\u0018\u00010IH\u0002J\u0011\u0010\u001a\u00020L2\u0007\u0010r\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010r\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010r\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010^2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J/\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020s2\t\u0010\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010\u0001\u001a\u00020\u00102\u0007\u0010\u0001\u001a\u00020\nH\u0002J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010r\u001a\u00020XH\u0002J\u001b\u0010\u0001\u001a\u00020L2\u0007\u0010\u0001\u001a\u00020X2\u0007\u0010\u0001\u001a\u00020XH\u0002J\u0011\u0010\u0001\u001a\u00020L2\u0006\u0010r\u001a\u00020XH\u0002J\u001d\u0010\u0001\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J8\u0010\u0001\u001a\u00020L2\u0006\u0010r\u001a\u00020v2\t\u0010\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010\u0001\u001a\u00020\n2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010\u0001J7\u0010\u0001\u001a\u00020L2\u0006\u0010]\u001a\u00020`2\u0006\u0010m\u001a\u00020/2\b\u0010n\u001a\u0004\u0018\u00010I2\b\u0010o\u001a\u0004\u0018\u00010I2\b\u0010p\u001a\u0004\u0018\u00010IH\u0002J\u0012\u0010\u0001\u001a\u00020L2\u0007\u0010r\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J\u001d\u0010\u0001\u001a\u00020L2\b\u0010]\u001a\u0004\u0018\u00010`2\b\u0010H\u001a\u0004\u0018\u00010\u0019H\u0002J'\u0010\u0001\u001a\u00020L2\u0006\u0010]\u001a\u00020^2\t\u0010\u0001\u001a\u0004\u0018\u00010I2\t\b\u0002\u0010\u0001\u001a\u00020/H\u0002J&\u0010\u0001\u001a\u00020L2\r\u0010\u0017\u001a\t\u0012\u0004\u0012\u00020\u00190\u00012\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010A\u001a\u00020BJ\u0017\u0010\u0001\u001a\u00020L2\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00190\u0001J\u000f\u0010\u0001\u001a\u00020L2\u0006\u0010O\u001a\u00020\u0010J\t\u0010 \u0001\u001a\u00020LH\u0002J\u0010\u0010¡\u0001\u001a\u00020L2\u0007\u0010¢\u0001\u001a\u00020/R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0012\"\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0016R\u001b\u0010(\u001a\u00020)8FX\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R\u001a\u0010.\u001a\u00020/X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006§\u0001"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "fullImageWidth", "", "getFullImageWidth", "()F", "heightRatio", "getHeightRatio", "itemSpace", "", "getItemSpace", "()I", "itemWidth", "getItemWidth", "setItemWidth", "(I)V", "list", "", "Lcom/baidu/searchbox/feed/model/FeedItemMiniVideo$ChildItem;", "getList", "()Ljava/util/List;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "marginDistance", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getModel", "()Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "setModel", "(Lcom/baidu/searchbox/feed/model/FeedBaseModel;)V", "moreHeight", "getMoreHeight", "setMoreHeight", "moreItemVH", "Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$MoreItemVH;", "getMoreItemVH", "()Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$MoreItemVH;", "moreItemVH$delegate", "Lkotlin/Lazy;", "moreViewEnabled", "", "getMoreViewEnabled", "()Z", "setMoreViewEnabled", "(Z)V", "onItemClickListener", "Lcom/baidu/searchbox/feed/template/tplinterface/OnScrollItemClickListener;", "getOnItemClickListener", "()Lcom/baidu/searchbox/feed/template/tplinterface/OnScrollItemClickListener;", "setOnItemClickListener", "(Lcom/baidu/searchbox/feed/template/tplinterface/OnScrollItemClickListener;)V", "padFullImageWidth", "scrollCardData", "Lcom/baidu/searchbox/feed/model/FeedItemMiniVideo;", "getScrollCardData", "()Lcom/baidu/searchbox/feed/model/FeedItemMiniVideo;", "setScrollCardData", "(Lcom/baidu/searchbox/feed/model/FeedItemMiniVideo;)V", "template", "Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;", "getTemplate", "()Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;", "setTemplate", "(Lcom/baidu/searchbox/feed/template/FeedTemplateImpl;)V", "colorOrDefault", "data", "", "colorResId", "disableMoreView", "", "enableMoreView", "getItem", "position", "getItemCount", "getItemId", "", "getItemViewType", "hasVideoInfo", "isNormalItemViewType", "loadingEffect", "imageView", "Landroid/widget/ImageView;", "matchFullScreenWidth", "onAttachedToRecyclerView", "recyclerView", "onBindItemVH", "holder", "Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemVH;", "onBindItemVH2", "Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemVH2;", "onBindLoadItemVH", "Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemLoadVH;", "onBindMoreViewVH", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAuthorInfo", "setBottomCenterRlt", "setBottomDynamicLabel", "setBottomLabelTextIconStyle", "hasIcon", "bgColor", "textColor", "iconUrl", "setCommentNum", "view", "Landroid/widget/TextView;", "commentNum", "setCoverImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "img", "topLeftRadius", "topRightRadius", "bottomLeftRadius", "bottomRightRadius", "setDislike", "setDynamicLabel", "setLabelTextIconStyle", "setLayoutParams", "Landroid/view/View;", "setLayoutWidth", "setLoadLayoutParams", "setNewLabel", "setNewLabelText", "textView", "content", "color", "size", "setPlayIcon", "setPlayIcons", "centerIcon", "rightIcon", "setPraiseIcon", "setTopDynamicLabel", "setTopLabel", "urlStr", "height", "ratio", "(Lcom/baidu/searchbox/feed/template/FeedDraweeView;Ljava/lang/String;FLjava/lang/Float;)V", "setTopLabelTextIconStyle", "setTopLayoutParams", "setVideoDesc", "setVideoInfo", "setVideoTitle", "title", "isShowNum", "updateDataSetChanged", "", "updateItemRangeInserted", "items", "updateItemRemoved", "updateItemWidth", "updateLoadItem", "isLoading", "ItemLoadVH", "ItemVH", "ItemVH2", "MoreItemVH", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedMiniVideoHScrollAdapter.kt */
public final class FeedMiniVideoHScrollAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private final float fullImageWidth;
    private final float heightRatio;
    private final int itemSpace;
    private int itemWidth;
    private final List<FeedItemMiniVideo.ChildItem> list = new ArrayList();
    private RecyclerView mRecyclerView;
    private int marginDistance = this.context.getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);
    private FeedBaseModel model;
    private int moreHeight;
    private final Lazy moreItemVH$delegate;
    private boolean moreViewEnabled;
    private OnScrollItemClickListener onItemClickListener;
    private final float padFullImageWidth;
    private FeedItemMiniVideo scrollCardData;
    private FeedTemplateImpl template;

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "<set-?>");
        this.context = context2;
    }

    public FeedMiniVideoHScrollAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.dimen.F_M_W_X062);
        this.itemSpace = dimensionPixelSize;
        this.itemWidth = ((FeedTemplateUtil.getCalculateWidth(this.context) - (this.marginDistance * 2)) - dimensionPixelSize) / 2;
        this.heightRatio = 0.75f;
        this.fullImageWidth = 1080.0f;
        this.moreItemVH$delegate = LazyKt.lazy(new FeedMiniVideoHScrollAdapter$moreItemVH$2(this));
        this.moreHeight = (int) (((float) this.itemWidth) / 0.75f);
        this.padFullImageWidth = 2000.0f;
        setHasStableIds(true);
    }

    public final List<FeedItemMiniVideo.ChildItem> getList() {
        return this.list;
    }

    public final FeedBaseModel getModel() {
        return this.model;
    }

    public final void setModel(FeedBaseModel feedBaseModel) {
        this.model = feedBaseModel;
    }

    public final FeedTemplateImpl getTemplate() {
        return this.template;
    }

    public final void setTemplate(FeedTemplateImpl feedTemplateImpl) {
        this.template = feedTemplateImpl;
    }

    public final FeedItemMiniVideo getScrollCardData() {
        return this.scrollCardData;
    }

    public final void setScrollCardData(FeedItemMiniVideo feedItemMiniVideo) {
        this.scrollCardData = feedItemMiniVideo;
    }

    public final int getItemSpace() {
        return this.itemSpace;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final void setItemWidth(int i2) {
        this.itemWidth = i2;
    }

    public final OnScrollItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(OnScrollItemClickListener onScrollItemClickListener) {
        this.onItemClickListener = onScrollItemClickListener;
    }

    public final boolean getMoreViewEnabled() {
        return this.moreViewEnabled;
    }

    public final void setMoreViewEnabled(boolean z) {
        this.moreViewEnabled = z;
    }

    public final float getHeightRatio() {
        return this.heightRatio;
    }

    public final float getFullImageWidth() {
        return this.fullImageWidth;
    }

    public final MoreItemVH getMoreItemVH() {
        return (MoreItemVH) this.moreItemVH$delegate.getValue();
    }

    public final int getMoreHeight() {
        return this.moreHeight;
    }

    public final void setMoreHeight(int i2) {
        this.moreHeight = i2;
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    public final FeedItemMiniVideo.ChildItem getItem(int position) {
        if (position < 0 || position >= this.list.size()) {
            return null;
        }
        return this.list.get(position);
    }

    public final boolean isNormalItemViewType(int position) {
        int viewType = getItemViewType(position);
        return viewType == 0 || viewType == 3 || viewType == 4 || viewType == 5;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getItemViewType(int position) {
        boolean z = true;
        if (position >= this.list.size() && this.moreViewEnabled) {
            return 1;
        }
        FeedItemMiniVideo.ChildItem item = getItem(position);
        String str = null;
        if (Intrinsics.areEqual((Object) "load", (Object) item != null ? item.type : null)) {
            return 2;
        }
        FeedItemMiniVideo.ChildItem item2 = getItem(position);
        if (item2 != null) {
            str = item2.mode;
        }
        if (TextUtils.equals(r0, str)) {
            return 4;
        }
        FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
        if (feedItemMiniVideo != null && feedItemMiniVideo.templateType == 2) {
            return 5;
        }
        FeedItemMiniVideo feedItemMiniVideo2 = this.scrollCardData;
        if (feedItemMiniVideo2 == null || !feedItemMiniVideo2.isChildTitleUp()) {
            z = false;
        }
        if (z) {
            return 3;
        }
        return 0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemLoadVH itemLoadVH;
        ItemVH2 itemVH2;
        ItemVH itemVH;
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case 1:
                return getMoreItemVH();
            case 2:
                if (FeedAbtestManager.isFluencyOptOpen()) {
                    View inflate = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_load_layout_fluency, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n …lse\n                    )");
                    itemLoadVH = new ItemLoadVH(inflate);
                } else {
                    View inflate2 = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_load_layout, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate2, "from(context).inflate(\n …lse\n                    )");
                    itemLoadVH = new ItemLoadVH(inflate2);
                }
                return itemLoadVH;
            case 3:
                return new ItemVH(FeedMiniVideoHScrollAdapterKt.createItemLayoutOfUp(this.context));
            case 4:
                return AdRuntimeHolder.getHScrollCardHelper().getAdItemVH(this.context, parent);
            case 5:
                if (FeedAbtestManager.isFluencyOptOpen()) {
                    View inflate3 = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_new_layout_fluency, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate3, "from(context).inflate(\n …lse\n                    )");
                    itemVH2 = new ItemVH2(inflate3);
                } else {
                    View inflate4 = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_new_layout, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate4, "from(context).inflate(\n …lse\n                    )");
                    itemVH2 = new ItemVH2(inflate4);
                }
                return itemVH2;
            default:
                if (FeedAbtestManager.isFluencyOptOpen()) {
                    View inflate5 = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_layout_fluency, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate5, "from(context).inflate(\n …lse\n                    )");
                    itemVH = new ItemVH(inflate5);
                } else {
                    View inflate6 = LayoutInflater.from(this.context).inflate(com.baidu.searchbox.feed.core.R.layout.feed_tpl_mini_video_hscroll_item_layout, parent, false);
                    Intrinsics.checkNotNullExpressionValue(inflate6, "from(context).inflate(\n …lse\n                    )");
                    itemVH = new ItemVH(inflate6);
                }
                return itemVH;
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (holder instanceof MoreItemVH) {
            onBindMoreViewVH((MoreItemVH) holder);
        } else if (holder instanceof ItemLoadVH) {
            onBindLoadItemVH((ItemLoadVH) holder, position);
        } else if (AdRuntimeHolder.getHScrollCardHelper().checkHolder(holder)) {
            AdRuntimeHolder.getHScrollCardHelper().onBindAdItemVH(holder, this, position);
        } else if (holder instanceof ItemVH) {
            onBindItemVH((ItemVH) holder, position);
        } else if (holder instanceof ItemVH2) {
            onBindItemVH2((ItemVH2) holder, position);
        }
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        FontAdjustment.fireFontSizeChanged(view2);
    }

    /* JADX WARNING: type inference failed for: r4v9, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onBindMoreViewVH(com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter.MoreItemVH r9) {
        /*
            r8 = this;
            r0 = r9
            r1 = 0
            android.widget.ImageView r2 = r0.getMoreArrow()
            android.content.Context r3 = r8.context
            int r4 = com.baidu.searchbox.feed.template.R.drawable.feed_evolution_detail_more_arrow
            android.graphics.drawable.Drawable r4 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r3 = 0
            r5 = 0
            r6 = 4
            r7 = 0
            com.baidu.searchbox.config.ext.FontSizeImageViewExtKt.setScaledImageDrawable$default(r2, r3, r4, r5, r6, r7)
            android.widget.TextView r2 = r0.getMoreBtn()
            r3 = 0
            android.content.Context r4 = com.baidu.searchbox.resources.util.CtxResEasyUtils.getAppContext()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X058
            float r4 = r4.getDimension(r5)
            r5 = 0
            r2.setTextSize(r5, r4)
            android.content.Context r4 = r2.getContext()
            int r5 = com.baidu.searchbox.feed.styles.R.color.FC15
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r2.setTextColor(r4)
            com.baidu.searchbox.feed.model.FeedBaseModel r2 = r8.model
            r3 = 0
            if (r2 == 0) goto L_0x0046
            com.baidu.searchbox.feed.model.FeedItemData r2 = r2.data
            goto L_0x0047
        L_0x0046:
            r2 = r3
        L_0x0047:
            boolean r4 = r2 instanceof com.baidu.searchbox.feed.model.FeedItemMiniVideo
            if (r4 == 0) goto L_0x004e
            com.baidu.searchbox.feed.model.FeedItemMiniVideo r2 = (com.baidu.searchbox.feed.model.FeedItemMiniVideo) r2
            goto L_0x004f
        L_0x004e:
            r2 = r3
        L_0x004f:
            if (r2 == 0) goto L_0x0096
            boolean r4 = r2.hasMoreDisplayed
            if (r4 != 0) goto L_0x0096
            com.baidu.searchbox.feed.model.FeedBaseModel r4 = r8.model
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            com.baidu.searchbox.feed.log.IFeedLogger r5 = com.baidu.searchbox.feed.log.OnLineLogs.miniVideoHScrollLogger()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "add predraw for more : "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = r4.id()
            java.lang.StringBuilder r6 = r6.append(r7)
            r7 = 59
            java.lang.StringBuilder r6 = r6.append(r7)
            int r7 = java.lang.System.identityHashCode(r2)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.i(r6)
            android.view.View r5 = r0.itemView
            android.view.ViewTreeObserver r5 = r5.getViewTreeObserver()
            com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter$onBindMoreViewVH$1$2 r6 = new com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter$onBindMoreViewVH$1$2
            r6.<init>(r2, r0, r4, r8)
            android.view.ViewTreeObserver$OnPreDrawListener r6 = (android.view.ViewTreeObserver.OnPreDrawListener) r6
            r5.addOnPreDrawListener(r6)
        L_0x0096:
            android.view.View r4 = r0.itemView
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            boolean r5 = r4 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r5 == 0) goto L_0x00a3
            r3 = r4
            android.view.ViewGroup$MarginLayoutParams r3 = (android.view.ViewGroup.MarginLayoutParams) r3
        L_0x00a3:
            if (r3 == 0) goto L_0x00b6
            r4 = 0
            int r5 = r8.moreHeight
            r3.height = r5
            r5 = 5
            r6 = 0
            float r7 = (float) r5
            float r5 = com.baidu.searchbox.resources.util.CtxResEasyUtils.dp2px((float) r7)
            int r5 = (int) r5
            r3.leftMargin = r5
        L_0x00b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter.onBindMoreViewVH(com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter$MoreItemVH):void");
    }

    private final void onBindLoadItemVH(ItemLoadVH holder, int position) {
        ItemLoadVH itemLoadVH = holder;
        int i2 = position;
        View view2 = itemLoadVH.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        setLoadLayoutParams(view2);
        holder.getImgLoad().setVisibility(8);
        holder.getTitle().setVisibility(8);
        holder.getReload().setVisibility(8);
        if (this.list.get(i2).isLoading) {
            loadingEffect(holder.getImgLoad());
            holder.getImgLoad().setVisibility(0);
        } else {
            holder.getTitle().setVisibility(0);
            holder.getReload().setVisibility(0);
            holder.getTitle().setTextColor(this.context.getResources().getColor(R.color.FC104));
            holder.getReload().setTextColor(this.context.getResources().getColor(R.color.FC104));
            holder.getReload().setBackground(ContextCompat.getDrawable(this.context, com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_h_scroll_item_reload_bg));
            if (FeedAbtestManager.isFluencyOptOpen() && !(holder.getTitle() instanceof AdjustableTextView) && !(holder.getReload() instanceof AdjustableTextView)) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(holder.getTitle(), 0, com.baidu.searchbox.feed.core.R.dimen.dimens_12dp, 0, 4, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(holder.getReload(), 0, com.baidu.searchbox.feed.core.R.dimen.dimens_12dp, 0, 4, (Object) null);
            }
            holder.getReload().setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda6(this, i2));
        }
        itemLoadVH.itemView.setBackground(ContextCompat.getDrawable(this.context, com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_h_scroll_item_bg));
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindLoadItemVH$lambda-4  reason: not valid java name */
    public static final void m19457onBindLoadItemVH$lambda4(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    private final void loadingEffect(ImageView imageView) {
        Drawable drawable = CtxResEasyUtils.asResDrawable(com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_loading);
        if (drawable != null) {
            imageView.setImageDrawable(AnimKt.animatedRotate$default(drawable, true, 0.5f, true, 0.5f, true, 0, 0, 192, (Object) null));
        }
    }

    private final void onBindItemVH(ItemVH holder, int position) {
        FeedItemMiniVideo.ChildItem itemData = this.list.get(position);
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        setLayoutParams(view2);
        FeedDraweeView coverImg = holder.getCoverImg();
        String str = itemData.image;
        Intrinsics.checkNotNullExpressionValue(str, "itemData.image");
        setCoverImg(coverImg, str);
        ExpandTouchAreaHelper.expandTouchArea(holder.itemView, holder.getDislikeView(), FeedMiniVideoHScrollAdapterKt.DISLIKE_EXPAND_SIZE);
        FeedOrderSenseUtil.setDislikePicture(holder.getDislikeView(), 2, this.model);
        holder.getDislikeView().setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda1(this, position));
        setPlayIcon(holder.getPlayIcon());
        setVideoTitle(holder, itemData.title, setCommentNum(holder.getCommentNum(), itemData.commentNum));
        setTopLabel(holder.getTopLabel(), itemData.labelUrl, DeviceUtils.ScreenInfo.dp2pxf(this.context, itemData.labelHeight), Float.valueOf(itemData.labelRatio));
        setDynamicLabel(holder, itemData);
        setNewLabel(holder, itemData);
        holder.itemView.setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda2(this, position));
        if (!itemData.hasDisplayed) {
            holder.itemView.getViewTreeObserver().addOnPreDrawListener(new FeedMiniVideoHScrollAdapter$onBindItemVH$3(holder, itemData, this, position));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindItemVH$lambda-5  reason: not valid java name */
    public static final void m19453onBindItemVH$lambda5(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindItemVH$lambda-6  reason: not valid java name */
    public static final void m19454onBindItemVH$lambda6(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    private final void onBindItemVH2(ItemVH2 holder, int position) {
        FeedItemMiniVideo.ChildItem itemData = this.list.get(position);
        View view2 = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
        setLayoutWidth(view2);
        setTopLayoutParams(holder.getTopRlt());
        FeedDraweeView coverImg = holder.getCoverImg();
        String str = itemData.image;
        Intrinsics.checkNotNullExpressionValue(str, "itemData.image");
        setCoverImg(coverImg, str, this.context.getResources().getDimensionPixelSize(R.dimen.F_J_X01), this.context.getResources().getDimensionPixelSize(R.dimen.F_J_X01), 0, 0);
        setTopLabel(holder.getTopLabel(), itemData.labelUrl, DeviceUtils.ScreenInfo.dp2pxf(this.context, itemData.labelHeight), Float.valueOf(itemData.labelRatio));
        setTopDynamicLabel(holder, itemData);
        setVideoInfo(holder, itemData);
        ExpandTouchAreaHelper.expandTouchArea(holder.itemView, holder.getDislikeView(), FeedMiniVideoHScrollAdapterKt.DISLIKE_EXPAND_SIZE);
        FeedOrderSenseUtil.setDislikePicture(holder.getDislikeView(), 2, this.model);
        holder.getDislikeView().setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda3(this, position));
        setPlayIcons(holder.getCenterPlayIcon(), holder.getRightPlayIcon());
        setBottomCenterRlt(holder, itemData);
        setBottomDynamicLabel(holder, itemData);
        setVideoDesc(holder, itemData);
        setAuthorInfo(holder, itemData);
        holder.itemView.setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda4(this, position));
        if (!itemData.hasDisplayed) {
            holder.itemView.getViewTreeObserver().addOnPreDrawListener(new FeedMiniVideoHScrollAdapter$onBindItemVH2$3(holder, itemData, this, position));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindItemVH2$lambda-7  reason: not valid java name */
    public static final void m19455onBindItemVH2$lambda7(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindItemVH2$lambda-8  reason: not valid java name */
    public static final void m19456onBindItemVH2$lambda8(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    private final void setLayoutParams(View view2) {
        Double ratio;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) layoutParams;
            FeedBaseModel feedBaseModel = this.model;
            FeedItemMiniVideo feedItemMiniVideo = null;
            Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
            if (jsonable instanceof FeedItemMiniVideo) {
                feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
            }
            FeedItemMiniVideo data = feedItemMiniVideo;
            params.rightMargin = this.itemSpace;
            float hRatio = this.heightRatio;
            if (data != null) {
                FeedItemMiniVideo it = data;
                if (FeedUtil.isTablet(this.context)) {
                    ratio = Double.valueOf(it.padWidthHeightRatio);
                } else {
                    ratio = it.widthHeightRatio;
                }
                if (!Intrinsics.areEqual(ratio, 0.0d)) {
                    hRatio = (float) ratio.doubleValue();
                }
            }
            updateItemWidth();
            params.width = this.itemWidth;
            params.height = (int) ((((float) params.width) * 1.0f) / hRatio);
            this.moreHeight = params.height;
            view2.setLayoutParams(params);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void setLoadLayoutParams(View view2) {
        Double ratio;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) layoutParams;
            FeedBaseModel feedBaseModel = this.model;
            FeedItemMiniVideo feedItemMiniVideo = null;
            Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
            if (jsonable instanceof FeedItemMiniVideo) {
                feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
            }
            FeedItemMiniVideo data = feedItemMiniVideo;
            params.rightMargin = this.itemSpace;
            float hRatio = this.heightRatio;
            if (data != null) {
                FeedItemMiniVideo it = data;
                if (FeedUtil.isTablet(this.context)) {
                    ratio = Double.valueOf(it.padWidthHeightRatio);
                } else {
                    ratio = it.widthHeightRatio;
                }
                if (!Intrinsics.areEqual(ratio, 0.0d)) {
                    hRatio = (float) ratio.doubleValue();
                }
            }
            updateItemWidth();
            params.width = this.itemWidth;
            FeedItemMiniVideo feedItemMiniVideo2 = this.scrollCardData;
            boolean z = true;
            if (feedItemMiniVideo2 == null || feedItemMiniVideo2.templateType != 1) {
                z = false;
            }
            if (z) {
                params.height = (int) ((((float) params.width) * 1.0f) / hRatio);
            } else {
                params.height = -1;
            }
            this.moreHeight = params.height;
            view2.setLayoutParams(params);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void setLayoutWidth(View view2) {
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) layoutParams;
            params.rightMargin = this.itemSpace;
            updateItemWidth();
            params.width = this.itemWidth;
            view2.setLayoutParams(params);
            view2.setBackground(this.context.getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_h_scroll_item_bg_new));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void updateItemWidth() {
        float sampleWidth;
        int width;
        FeedBaseModel feedBaseModel = this.model;
        FeedItemMiniVideo feedItemMiniVideo = null;
        Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
        if (jsonable instanceof FeedItemMiniVideo) {
            feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
        }
        FeedItemMiniVideo data = feedItemMiniVideo;
        if (data != null) {
            FeedItemMiniVideo it = data;
            if (!FeedUtil.isTablet(this.context) || it.padImageWidth <= 0 || it.minItemCount <= 2) {
                width = it.imageWidth;
                sampleWidth = this.fullImageWidth;
            } else {
                width = it.padImageWidth;
                sampleWidth = this.padFullImageWidth;
            }
            if (width > 1) {
                int contentWidth = FeedTemplateUtil.getCalculateWidth(this.context);
                if (FeedUtil.isPadHomeBasic(this.context)) {
                    contentWidth -= FeedTemplateUtil.getPadEdgeBlankWidth(this.context) * 2;
                }
                int w = (int) ((((float) width) / sampleWidth) * ((float) contentWidth));
                if (w > 1) {
                    this.itemWidth = w;
                }
            }
        }
    }

    static /* synthetic */ void setTopLabel$default(FeedMiniVideoHScrollAdapter feedMiniVideoHScrollAdapter, FeedDraweeView feedDraweeView, String str, float f2, Float f3, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            f3 = Float.valueOf(2.25f);
        }
        feedMiniVideoHScrollAdapter.setTopLabel(feedDraweeView, str, f2, f3);
    }

    private final void setTopLabel(FeedDraweeView view2, String urlStr, float height, Float ratio) {
        CharSequence charSequence = urlStr;
        if ((charSequence == null || charSequence.length() == 0) || height <= 0.0f) {
            view2.setVisibility(8);
            return;
        }
        view2.setVisibility(0);
        ViewGroup.LayoutParams lp = view2.getLayoutParams();
        if (lp != null) {
            lp.width = MathKt.roundToInt(FontSizeHelper.getScaledSize(0, height * (ratio != null ? ratio.floatValue() : 2.25f)));
            lp.height = MathKt.roundToInt(FontSizeHelper.getScaledSize(0, height));
        }
        setCoverImg(view2, urlStr);
    }

    private final void setDynamicLabel(ItemVH holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            holder.getDynamicLabel().setVisibility(8);
            holder.getDynamicLabelText().setVisibility(8);
            holder.getDynamicLabelIcon().setVisibility(8);
            if (data.isLabelInfoValid()) {
                holder.getDynamicLabelText().setText(data.labelInfoText);
                holder.getDynamicLabelText().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X017)));
                if (NightModeHelper.isNightMode()) {
                    setLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoNightBgColor, data.labelInfoNightTextColor, data.labelInfoNightIconUrl);
                } else {
                    setLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoDayBgColor, data.labelInfoDayTextColor, data.labelInfoDayIconUrl);
                }
                holder.getDynamicLabelText().setVisibility(0);
                holder.getDynamicLabel().setVisibility(0);
            }
        }
    }

    private final void setVideoInfo(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            holder.getDurationTxt().setVisibility(8);
            holder.getLikeCountTxt().setVisibility(8);
            holder.getPlayCountTxt().setVisibility(8);
            holder.getLikeIconImg().setVisibility(8);
            holder.getBgLayer().setVisibility(8);
            if (hasVideoInfo(data)) {
                holder.getBgLayer().setVisibility(0);
                if (!TextUtils.isEmpty(data.playDuration)) {
                    holder.getDurationTxt().setText(data.playDuration);
                    holder.getDurationTxt().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X056)));
                    holder.getDurationTxt().setTextColor(this.context.getResources().getColor(R.color.FC109));
                    holder.getDurationTxt().setVisibility(0);
                }
                if (!TextUtils.isEmpty(data.playCount)) {
                    String strFormat = this.context.getResources().getString(com.baidu.searchbox.feed.core.R.string.feed_mini_video_play_count_title);
                    Intrinsics.checkNotNullExpressionValue(strFormat, "context.resources.getStr…i_video_play_count_title)");
                    TextView playCountTxt = holder.getPlayCountTxt();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format(strFormat, Arrays.copyOf(new Object[]{data.playCount}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    playCountTxt.setText(format);
                    holder.getPlayCountTxt().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X056)));
                    holder.getPlayCountTxt().setTextColor(this.context.getResources().getColor(R.color.FC109));
                    holder.getPlayCountTxt().setVisibility(0);
                }
                if (!TextUtils.isEmpty(data.likeCount)) {
                    holder.getLikeCountTxt().setText(data.likeCount);
                    holder.getLikeCountTxt().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X056)));
                    setPraiseIcon(holder.getLikeIconImg());
                    holder.getLikeCountTxt().setTextColor(this.context.getResources().getColor(R.color.FC109));
                    holder.getLikeCountTxt().setVisibility(0);
                    holder.getLikeIconImg().setVisibility(0);
                }
            }
        }
    }

    private final boolean hasVideoInfo(FeedItemMiniVideo.ChildItem data) {
        if (data == null) {
            return false;
        }
        FeedItemMiniVideo.ChildItem childItem = data;
        if (TextUtils.isEmpty(data.likeCount) && TextUtils.isEmpty(data.playDuration) && TextUtils.isEmpty(data.playCount)) {
            return false;
        }
        return true;
    }

    private final void setTopDynamicLabel(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            holder.getDynamicLabel().setVisibility(8);
            holder.getDynamicLabelText().setVisibility(8);
            holder.getDynamicLabelIcon().setVisibility(8);
            if (data.isLabelInfoValid()) {
                FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
                boolean z = true;
                if (feedItemMiniVideo == null || feedItemMiniVideo.labelPos != 1) {
                    z = false;
                }
                if (z) {
                    holder.getDynamicLabelText().setText(data.labelInfoText);
                    holder.getDynamicLabelText().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X017)));
                    if (NightModeHelper.isNightMode()) {
                        setTopLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoNightBgColor, data.labelInfoNightTextColor, data.labelInfoNightIconUrl);
                    } else {
                        setTopLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoDayBgColor, data.labelInfoDayTextColor, data.labelInfoDayIconUrl);
                    }
                    holder.getDynamicLabelText().setVisibility(0);
                    holder.getDynamicLabel().setVisibility(0);
                }
            }
        }
    }

    private final void setBottomCenterRlt(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null) {
            ViewGroup.LayoutParams params = holder.getBottomCenterRlt().getLayoutParams();
            params.height = FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.dp2px(34.0f));
            holder.getBottomCenterRlt().setLayoutParams(params);
        }
    }

    private final void setBottomDynamicLabel(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            holder.getBottomLabel().setVisibility(8);
            holder.getBottomLabelText().setVisibility(8);
            holder.getBottomLabelIcon().setVisibility(8);
            if (data.isLabelInfoValid()) {
                FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
                if (feedItemMiniVideo != null && feedItemMiniVideo.labelPos == 2) {
                    holder.getBottomLabelText().setText(data.labelInfoText);
                    holder.getBottomLabelText().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X056)));
                    if (NightModeHelper.isNightMode()) {
                        setBottomLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoNightBgColor, data.labelInfoNightTextColor, data.labelInfoNightIconUrl);
                    } else {
                        setBottomLabelTextIconStyle(holder, data.hasLabelInfoIcon(), data.labelInfoDayBgColor, data.labelInfoDayTextColor, data.labelInfoDayIconUrl);
                    }
                    holder.getBottomLabelText().setVisibility(0);
                    holder.getBottomLabel().setVisibility(0);
                }
            }
        }
    }

    private final void setVideoDesc(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
            if ((feedItemMiniVideo != null && feedItemMiniVideo.labelPos == 1) || !data.isLabelInfoValid()) {
                holder.getVideoDescTxt().setMaxLines(2);
                holder.getVideoDescTxt().setGravity(48);
            } else {
                holder.getVideoDescTxt().setMaxLines(1);
                holder.getVideoDescTxt().setGravity(80);
            }
            holder.getVideoDescTxt().setText(data.title);
            holder.getVideoDescTxt().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X300)));
            holder.getVideoDescTxt().setTextColor(this.context.getResources().getColor(R.color.FC1));
        }
    }

    private final void setAuthorInfo(ItemVH2 holder, FeedItemMiniVideo.ChildItem data) {
        if (holder != null && data != null) {
            FeedDraweeView $this$setAuthorInfo_u24lambda_u2d14 = holder.getAuthorAvatarImg();
            float size = CtxResEasyUtils.dp2px(16.0f);
            ViewExtensionsKt.setSize($this$setAuthorInfo_u24lambda_u2d14, FontAdjustment.getScaledFrameworkSize(size), FontAdjustment.getScaledFrameworkSize(size));
            $this$setAuthorInfo_u24lambda_u2d14.loadImageWithoutModel(data.authorAvatarUrl);
            $this$setAuthorInfo_u24lambda_u2d14.setVisibility(0);
            TextView authorDisplayNameTxt = holder.getAuthorDisplayNameTxt();
            String str = data.authorDisplayName;
            if (str == null) {
                str = "";
            }
            authorDisplayNameTxt.setText(str);
            holder.getAuthorDisplayNameTxt().setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(CtxResEasyUtils.asResDimen(R.dimen.F_T_X033)));
            holder.getAuthorDisplayNameTxt().setTextColor(this.context.getResources().getColor(R.color.FC103));
        }
    }

    private final void setNewLabel(ItemVH holder, FeedItemMiniVideo.ChildItem data) {
        FeedItemMiniVideo.ChildItem childItem = data;
        if (holder != null && childItem != null) {
            holder.getNewDynamicLabel().setVisibility(8);
            holder.getBgDownLayer().setVisibility(8);
            if (!data.isNewLabelInfoValid()) {
                setNewLabelText(holder.getNewLabelTitle(), childItem.labelIconTitle, CtxResEasyUtils.asResColor(R.color.FC6), CtxResEasyUtils.asResDimen(R.dimen.F_T_X056));
                setNewLabelText(holder.getNewLabelSubTitle(), childItem.labelIconSubTitle, CtxResEasyUtils.asResColor(R.color.FC301), CtxResEasyUtils.asResDimen(R.dimen.F_T_X033));
                FeedDraweeView $this$setNewLabel_u24lambda_u2d15 = holder.getNewLabelIcon();
                float size = CtxResEasyUtils.dp2px(24.0f);
                ViewExtensionsKt.setSize($this$setNewLabel_u24lambda_u2d15, FontAdjustment.getScaledFrameworkSize(size), FontAdjustment.getScaledFrameworkSize(size));
                $this$setNewLabel_u24lambda_u2d15.loadImageWithoutModel(childItem.labelIconUrl);
                $this$setNewLabel_u24lambda_u2d15.setVisibility(0);
                FontSizeTextViewExtKt.setScaledSizeRes$default(holder.getNewLabelTitle(), 0, R.dimen.F_T_X056, 0, 4, (Object) null);
                FontSizeTextViewExtKt.setScaledSizeRes$default(holder.getNewLabelSubTitle(), 0, R.dimen.F_T_X033, 0, 4, (Object) null);
                holder.getNewDynamicLabel().setVisibility(0);
                holder.getBgDownLayer().setVisibility(0);
            }
        }
    }

    private final void setNewLabelText(TextView textView, String content, int color, float size) {
        textView.setText(content);
        textView.setTextColor(color);
        textView.setTextSize(0, (float) FontAdjustment.getScaledFrameworkSize(size));
    }

    private final void setLabelTextIconStyle(ItemVH holder, boolean hasIcon, String bgColor, String textColor, String iconUrl) {
        holder.getDynamicLabel().setBackground(FeedMiniVideoHScrollAdapterKt.bgLayer(colorOrDefault(bgColor, R.color.FC120)));
        holder.getDynamicLabelText().setTextColor(colorOrDefault(textColor, R.color.FC38));
        if (hasIcon) {
            FeedDraweeView $this$setLabelTextIconStyle_u24lambda_u2d16 = holder.getDynamicLabelIcon();
            float size = CtxResEasyUtils.dp2px(10.0f);
            ViewExtensionsKt.setSize($this$setLabelTextIconStyle_u24lambda_u2d16, FontAdjustment.getScaledFrameworkSize(size), FontAdjustment.getScaledFrameworkSize(size));
            $this$setLabelTextIconStyle_u24lambda_u2d16.loadImageWithoutModel(iconUrl);
            $this$setLabelTextIconStyle_u24lambda_u2d16.setVisibility(0);
        }
    }

    private final void setTopLabelTextIconStyle(ItemVH2 holder, boolean hasIcon, String bgColor, String textColor, String iconUrl) {
        holder.getDynamicLabel().setBackground(FeedMiniVideoHScrollAdapterKt.bgLayer(colorOrDefault(bgColor, R.color.FC120)));
        holder.getDynamicLabelText().setTextColor(colorOrDefault(textColor, R.color.FC38));
        if (hasIcon) {
            FeedDraweeView $this$setTopLabelTextIconStyle_u24lambda_u2d17 = holder.getDynamicLabelIcon();
            float size = CtxResEasyUtils.dp2px(10.0f);
            ViewExtensionsKt.setSize($this$setTopLabelTextIconStyle_u24lambda_u2d17, FontAdjustment.getScaledFrameworkSize(size), FontAdjustment.getScaledFrameworkSize(size));
            $this$setTopLabelTextIconStyle_u24lambda_u2d17.loadImageWithoutModel(iconUrl);
            $this$setTopLabelTextIconStyle_u24lambda_u2d17.setVisibility(0);
        }
    }

    private final void setBottomLabelTextIconStyle(ItemVH2 holder, boolean hasIcon, String bgColor, String textColor, String iconUrl) {
        holder.getBottomLabelText().setTextColor(colorOrDefault(textColor, R.color.FC38));
        if (hasIcon) {
            FeedDraweeView $this$setBottomLabelTextIconStyle_u24lambda_u2d18 = holder.getBottomLabelIcon();
            float size = CtxResEasyUtils.dp2px(12.0f);
            ViewExtensionsKt.setSize($this$setBottomLabelTextIconStyle_u24lambda_u2d18, FontAdjustment.getScaledFrameworkSize(size), FontAdjustment.getScaledFrameworkSize(size));
            $this$setBottomLabelTextIconStyle_u24lambda_u2d18.loadImageWithoutModel(iconUrl);
            $this$setBottomLabelTextIconStyle_u24lambda_u2d18.setVisibility(0);
        }
    }

    private final int colorOrDefault(String data, int colorResId) {
        CharSequence charSequence = data;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return CtxResEasyUtils.asResColor(colorResId);
        }
        try {
            String substring = data.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            List t = StringsKt.split$default((CharSequence) substring, new String[]{","}, false, 0, 6, (Object) null);
            if (t.size() != 2) {
                return CtxResEasyUtils.asResColor(colorResId);
            }
            return Integer.parseInt((String) t.get(0), CharsKt.checkRadix(16)) | (Integer.parseInt((String) t.get(1), CharsKt.checkRadix(16)) << 24);
        } catch (Exception e2) {
            return CtxResEasyUtils.asResColor(colorResId);
        }
    }

    private final void setCoverImg(FeedDraweeView view2, String img) {
        Drawable drawable;
        Object obj = FeedDraweeCallerContext.getTemplateCallerContext(this.model);
        if (FeedAbtestManager.isFluencyOptOpen()) {
            drawable = view2.getResources().getDrawable(R.drawable.feed_mini_video_hscroll_placeholder);
        } else {
            drawable = ContextCompat.getDrawable(this.context, R.drawable.feed_mini_video_hscroll_placeholder);
        }
        view2.setPlaceHolderWithCenterCrop(drawable);
        view2.loadImage(img, this.model, obj);
    }

    private final void setCoverImg(FeedDraweeView view2, String img, int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius) {
        setCoverImg(view2, img);
        FeedTemplateImgCornersUtil.processSingleImgRoundCorner(view2, topLeftRadius, topRightRadius, bottomLeftRadius, bottomRightRadius);
    }

    private final void setTopLayoutParams(View view2) {
        Double ratio;
        FeedBaseModel feedBaseModel = this.model;
        FeedItemMiniVideo feedItemMiniVideo = null;
        Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
        if (jsonable instanceof FeedItemMiniVideo) {
            feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
        }
        FeedItemMiniVideo data = feedItemMiniVideo;
        float hRatio = this.heightRatio;
        if (data != null) {
            FeedItemMiniVideo it = data;
            if (FeedUtil.isTablet(this.context)) {
                ratio = Double.valueOf(it.padWidthHeightRatio);
            } else {
                ratio = it.widthHeightRatio;
            }
            if (!Intrinsics.areEqual(ratio, 0.0d)) {
                hRatio = (float) ratio.doubleValue();
            }
        }
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) layoutParams;
            params.height = (int) ((((float) this.itemWidth) * 1.0f) / hRatio);
            view2.setLayoutParams(params);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    private final void setDislike(ImageView view2, int position) {
        Drawable drawable = PreloadUIResUtil.getPreloadedDrawable(com.baidu.searchbox.feed.core.R.drawable.feed_unlike_btn_icon_cu);
        if (drawable == null) {
            drawable = this.context.getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.feed_unlike_btn_icon_cu);
        }
        FontSizeImageViewExtKt.setScaledImageDrawable$default(view2, 0, drawable.mutate(), 0, 4, (Object) null);
        view2.setOnClickListener(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda5(this, position));
    }

    /* access modifiers changed from: private */
    /* renamed from: setDislike$lambda-20  reason: not valid java name */
    public static final void m19458setDislike$lambda20(FeedMiniVideoHScrollAdapter this$0, int $position, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        OnScrollItemClickListener onScrollItemClickListener = this$0.onItemClickListener;
        if (onScrollItemClickListener != null) {
            onScrollItemClickListener.onItemClick($position, v);
        }
    }

    private final void setPraiseIcon(ImageView view2) {
        int resId;
        FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
        boolean z = true;
        if (feedItemMiniVideo == null || feedItemMiniVideo.likeIconType != 1) {
            z = false;
        }
        if (z) {
            resId = com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_praise_hand;
        } else {
            resId = com.baidu.searchbox.feed.core.R.drawable.feed_mini_video_praise_heart;
        }
        Drawable drawable = PreloadUIResUtil.getPreloadedDrawable(resId);
        if (drawable == null) {
            drawable = this.context.getResources().getDrawable(resId);
        }
        FontSizeImageViewExtKt.setScaledImageDrawable$default(view2, 0, drawable.mutate(), 0, 4, (Object) null);
    }

    private final void setPlayIcon(ImageView view2) {
        int w;
        FeedBaseModel feedBaseModel = this.model;
        Integer width = null;
        FeedItemData feedItemData = feedBaseModel != null ? feedBaseModel.data : null;
        FeedItemMiniVideo feedItemMiniVideo = feedItemData instanceof FeedItemMiniVideo ? (FeedItemMiniVideo) feedItemData : null;
        if (Intrinsics.areEqual((Object) feedItemMiniVideo != null ? Boolean.valueOf(feedItemMiniVideo.needShowPlayIcon) : null, (Object) true)) {
            view2.setVisibility(0);
            if (NightModeHelper.isNightMode()) {
                view2.setImageDrawable(this.context.getResources().getDrawable(R.drawable.feed_mini_video_play_icon_night));
            } else {
                view2.setImageDrawable(this.context.getResources().getDrawable(R.drawable.feed_mini_video_play_icon));
            }
            FeedBaseModel feedBaseModel2 = this.model;
            FeedItemData feedItemData2 = feedBaseModel2 != null ? feedBaseModel2.data : null;
            FeedItemMiniVideo feedItemMiniVideo2 = feedItemData2 instanceof FeedItemMiniVideo ? (FeedItemMiniVideo) feedItemData2 : null;
            if (feedItemMiniVideo2 != null) {
                width = Integer.valueOf(feedItemMiniVideo2.playIconSize);
            }
            if (width != null && (w = Math.abs(width.intValue())) != 0) {
                ViewGroup.LayoutParams params = view2.getLayoutParams();
                params.width = DeviceUtils.ScreenInfo.dp2px(this.context, (float) w);
                params.height = DeviceUtils.ScreenInfo.dp2px(this.context, (float) w);
                return;
            }
            return;
        }
        view2.setVisibility(8);
    }

    private final void setPlayIcons(ImageView centerIcon, ImageView rightIcon) {
        centerIcon.setVisibility(8);
        rightIcon.setVisibility(8);
        FeedBaseModel feedBaseModel = this.model;
        FeedItemMiniVideo feedItemMiniVideo = null;
        Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
        if (jsonable instanceof FeedItemMiniVideo) {
            feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
        }
        if (feedItemMiniVideo != null) {
            switch (feedItemMiniVideo.playIconPos) {
                case 1:
                    Drawable drawable = PreloadUIResUtil.getPreloadedDrawable(com.baidu.searchbox.feed.core.R.drawable.mini_video_playicon_right_top);
                    if (drawable == null) {
                        drawable = this.context.getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.mini_video_playicon_right_top);
                    }
                    FontSizeImageViewExtKt.setScaledImageDrawable$default(rightIcon, 0, drawable.mutate(), 0, 4, (Object) null);
                    rightIcon.setVisibility(0);
                    return;
                case 2:
                    centerIcon.setImageResource(com.baidu.searchbox.feed.core.R.drawable.mini_video_playicon_center);
                    centerIcon.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void setVideoTitle$default(FeedMiniVideoHScrollAdapter feedMiniVideoHScrollAdapter, ItemVH itemVH, String str, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        feedMiniVideoHScrollAdapter.setVideoTitle(itemVH, str, z);
    }

    /* JADX WARNING: type inference failed for: r0v19, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setVideoTitle(com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter.ItemVH r12, java.lang.String r13, boolean r14) {
        /*
            r11 = this;
            android.widget.TextView r6 = r12.getTitle()
            r0 = r6
            android.view.View r0 = (android.view.View) r0
            r1 = 0
            r2 = 8
            r0.setVisibility(r2)
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 1
            r7 = 0
            if (r0 == 0) goto L_0x001e
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r0 = r7
            goto L_0x001f
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 == 0) goto L_0x002b
            android.view.View r0 = r12.getBgLayer()
            r1 = 0
            r0.setVisibility(r2)
            return
        L_0x002b:
            r0 = r6
            android.view.View r0 = (android.view.View) r0
            r2 = 0
            r0.setVisibility(r7)
            android.text.TextPaint r0 = r6.getPaint()
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL_AND_STROKE
            r0.setStyle(r2)
            android.text.TextPaint r0 = r6.getPaint()
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.setStrokeWidth(r2)
            r0 = r13
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6.setText(r0)
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = r11.model
            r8 = 0
            if (r0 == 0) goto L_0x0053
            com.baidu.searchbox.feed.model.FeedItemData r0 = r0.data
            goto L_0x0054
        L_0x0053:
            r0 = r8
        L_0x0054:
            boolean r2 = r0 instanceof com.baidu.searchbox.feed.model.FeedItemMiniVideo
            if (r2 == 0) goto L_0x005b
            com.baidu.searchbox.feed.model.FeedItemMiniVideo r0 = (com.baidu.searchbox.feed.model.FeedItemMiniVideo) r0
            goto L_0x005c
        L_0x005b:
            r0 = r8
        L_0x005c:
            r9 = r0
            r0 = 0
            if (r9 == 0) goto L_0x0067
            int r2 = r9.fontSize
            r3 = 0
            int r0 = r9.fontSize
        L_0x0067:
            r10 = r0
            if (r10 != 0) goto L_0x0075
            r1 = 0
            int r2 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X004
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r6
            com.baidu.searchbox.config.ext.FontSizeTextViewExtKt.setScaledSizeRes$default(r0, r1, r2, r3, r4, r5)
            goto L_0x007f
        L_0x0075:
            float r0 = (float) r10
            float r0 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r7, r0)
            r6.setTextSize(r1, r0)
        L_0x007f:
            if (r9 == 0) goto L_0x008f
            int r0 = r9.maxLines
            r1 = 0
            int r2 = r9.maxLines
            if (r2 == 0) goto L_0x008d
            int r2 = r9.maxLines
            r6.setMaxLines(r2)
        L_0x008d:
        L_0x008f:
            android.content.Context r0 = r11.context
            android.content.res.Resources r0 = r0.getResources()
            int r1 = com.baidu.searchbox.feed.styles.R.color.FC37
            int r0 = r0.getColor(r1)
            r6.setTextColor(r0)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            boolean r1 = r0 instanceof android.widget.RelativeLayout.LayoutParams
            if (r1 == 0) goto L_0x00a9
            r8 = r0
            android.widget.RelativeLayout$LayoutParams r8 = (android.widget.RelativeLayout.LayoutParams) r8
        L_0x00a9:
            r0 = r8
            r1 = 12
            if (r14 == 0) goto L_0x00cd
            if (r0 == 0) goto L_0x00b3
            r0.addRule(r1, r7)
        L_0x00b3:
            if (r0 == 0) goto L_0x00bb
            r1 = 2
            int r2 = com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_comment_num
            r0.addRule(r1, r2)
        L_0x00bb:
            if (r0 != 0) goto L_0x00be
            goto L_0x00e3
        L_0x00be:
            android.content.Context r1 = r11.context
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X082
            int r1 = r1.getDimensionPixelOffset(r2)
            r0.bottomMargin = r1
            goto L_0x00e3
        L_0x00cd:
            if (r0 == 0) goto L_0x00d2
            r0.addRule(r1)
        L_0x00d2:
            if (r0 != 0) goto L_0x00d5
            goto L_0x00e3
        L_0x00d5:
            android.content.Context r1 = r11.context
            android.content.res.Resources r1 = r1.getResources()
            int r2 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X011
            int r1 = r1.getDimensionPixelOffset(r2)
            r0.bottomMargin = r1
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter.setVideoTitle(com.baidu.searchbox.feed.template.FeedMiniVideoHScrollAdapter$ItemVH, java.lang.String, boolean):void");
    }

    private final boolean setCommentNum(TextView view2, String commentNum) {
        view2.setVisibility(8);
        if (!TextUtils.isEmpty(commentNum)) {
            FeedItemMiniVideo feedItemMiniVideo = this.scrollCardData;
            if (!(feedItemMiniVideo != null && feedItemMiniVideo.isChildTitleUp())) {
                view2.setVisibility(0);
                Resources resources = this.context.getResources();
                Drawable icon = resources != null ? resources.getDrawable(R.drawable.feed_mini_video_play_icon) : null;
                float w = FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.feed.core.R.dimen.dimens_10dp);
                if (icon != null) {
                    icon.setBounds(0, 0, (int) w, (int) w);
                }
                view2.setCompoundDrawables(icon, (Drawable) null, (Drawable) null, (Drawable) null);
                view2.setText(commentNum);
                view2.setTextColor(this.context.getResources().getColor(R.color.FC37));
                FontSizeTextViewExtKt.setScaledSizeRes$default(view2, 0, R.dimen.F_T_X033, 0, 4, (Object) null);
                return true;
            }
        }
        return false;
    }

    public int getItemCount() {
        return this.moreViewEnabled ? this.list.size() + 1 : this.list.size();
    }

    public final void enableMoreView() {
        if (!this.moreViewEnabled) {
            this.moreViewEnabled = true;
            notifyItemInserted(getItemCount() - 1);
        }
    }

    public final void disableMoreView() {
        if (this.moreViewEnabled) {
            this.moreViewEnabled = false;
            notifyDataSetChanged();
        }
    }

    public final boolean matchFullScreenWidth() {
        return (this.list.size() * (this.itemWidth + this.itemSpace)) + this.marginDistance >= FeedTemplateUtil.getCalculateWidth(this.context);
    }

    public final void updateDataSetChanged(List<? extends FeedItemMiniVideo.ChildItem> list2, FeedBaseModel model2, FeedTemplateImpl template2) {
        Intrinsics.checkNotNullParameter(list2, "list");
        Intrinsics.checkNotNullParameter(model2, "model");
        Intrinsics.checkNotNullParameter(template2, "template");
        this.model = model2;
        FeedItemData feedItemData = model2.data;
        this.scrollCardData = feedItemData instanceof FeedItemMiniVideo ? (FeedItemMiniVideo) feedItemData : null;
        this.template = template2;
        this.list.clear();
        if (!list2.isEmpty()) {
            this.list.addAll(list2);
        }
        updateItemWidth();
        notifyDataSetChanged();
    }

    public final void updateLoadItem(boolean isLoading) {
        int index = this.list.size();
        while (true) {
            index--;
            if (-1 >= index) {
                return;
            }
            if (Intrinsics.areEqual((Object) this.list.get(index).type, (Object) "load") && this.list.get(index).isLoading != isLoading) {
                this.list.get(index).isLoading = isLoading;
                notifyItemChanged(index);
            }
        }
    }

    public final void updateItemRangeInserted(List<? extends FeedItemMiniVideo.ChildItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        int index = this.list.size();
        while (true) {
            index--;
            if (-1 >= index) {
                int index2 = this.list.size();
                this.list.addAll(items);
                notifyItemRangeInserted(index2, items.size());
                return;
            } else if (Intrinsics.areEqual((Object) this.list.get(index).type, (Object) "load")) {
                this.list.remove(index);
                notifyItemRemoved(index);
            }
        }
    }

    public final void updateItemRemoved(int position) {
        List<FeedItemMiniVideo.ChildItem> list2;
        if (!this.list.isEmpty() && position >= 0 && position < this.list.size()) {
            this.list.remove(position);
            FeedBaseModel feedBaseModel = this.model;
            FeedItemMiniVideo feedItemMiniVideo = null;
            Jsonable jsonable = feedBaseModel != null ? feedBaseModel.data : null;
            if (jsonable instanceof FeedItemMiniVideo) {
                feedItemMiniVideo = (FeedItemMiniVideo) jsonable;
            }
            if (!(feedItemMiniVideo == null || (list2 = feedItemMiniVideo.list) == null)) {
                FeedItemMiniVideo.ChildItem remove = list2.remove(position);
            }
            notifyItemRemoved(position);
            UiThreadUtils.runOnUiThread(new FeedMiniVideoHScrollAdapter$$ExternalSyntheticLambda0(this), 500);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: updateItemRemoved$lambda-24  reason: not valid java name */
    public static final void m19459updateItemRemoved$lambda24(FeedMiniVideoHScrollAdapter this$0) {
        int lastPosition;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RecyclerView recyclerView2 = this$0.mRecyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView2 != null ? recyclerView2.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null) {
            lastPosition = linearLayoutManager.findLastVisibleItemPosition();
        } else {
            lastPosition = -1;
        }
        if (lastPosition >= this$0.list.size()) {
            int screenWidth = DeviceUtils.ScreenInfo.getDisplayWidth(this$0.context);
            int[] spaceLoc = new int[2];
            this$0.getMoreItemVH().getMoreItemView().getSpaceView().getLocationOnScreen(spaceLoc);
            int trans = (screenWidth - spaceLoc[0]) - CtxResEasyUtils.getAppContext().getResources().getDimensionPixelSize(R.dimen.F_M_W_X001);
            if (trans > 0 && (recyclerView = this$0.mRecyclerView) != null) {
                recyclerView.smoothScrollBy(-trans, 0, (Interpolator) null, 0);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010 \u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0011\u0010\"\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011R\u0011\u0010(\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\rR\u0011\u0010*\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgDownLayer", "getBgDownLayer", "()Landroid/view/View;", "bgLayer", "getBgLayer", "commentNum", "Landroid/widget/TextView;", "getCommentNum", "()Landroid/widget/TextView;", "coverImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "getCoverImg", "()Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "dislikeView", "Landroid/widget/ImageView;", "getDislikeView", "()Landroid/widget/ImageView;", "dynamicLabel", "Landroid/view/ViewGroup;", "getDynamicLabel", "()Landroid/view/ViewGroup;", "dynamicLabelIcon", "getDynamicLabelIcon", "dynamicLabelText", "getDynamicLabelText", "newDynamicLabel", "getNewDynamicLabel", "newLabelIcon", "getNewLabelIcon", "newLabelSubTitle", "getNewLabelSubTitle", "newLabelTitle", "getNewLabelTitle", "playIcon", "getPlayIcon", "title", "getTitle", "topLabel", "getTopLabel", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedMiniVideoHScrollAdapter.kt */
    private static final class ItemVH extends RecyclerView.ViewHolder {
        private final View bgDownLayer;
        private final View bgLayer;
        private final TextView commentNum;
        private final FeedDraweeView coverImg;
        private final ImageView dislikeView;
        private final ViewGroup dynamicLabel;
        private final FeedDraweeView dynamicLabelIcon;
        private final TextView dynamicLabelText;
        private final ViewGroup newDynamicLabel;
        private final FeedDraweeView newLabelIcon;
        private final TextView newLabelSubTitle;
        private final TextView newLabelTitle;
        private final FeedDraweeView playIcon;
        private final TextView title;
        private final FeedDraweeView topLabel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co…eed_tpl_mini_video_title)");
            this.title = (TextView) findViewById;
            View findViewById2 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_cover);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co…eed_tpl_mini_video_cover)");
            this.coverImg = (FeedDraweeView) findViewById2;
            View findViewById3 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_play_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(co…tpl_mini_video_play_icon)");
            this.playIcon = (FeedDraweeView) findViewById3;
            View findViewById4 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dislike);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(co…d_tpl_mini_video_dislike)");
            this.dislikeView = (ImageView) findViewById4;
            View findViewById5 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_comment_num);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(co…l_mini_video_comment_num)");
            this.commentNum = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_label);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(co…eed_tpl_mini_video_label)");
            this.topLabel = (FeedDraweeView) findViewById6;
            View findViewById7 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(co…mini_video_dynamic_label)");
            this.dynamicLabel = (ViewGroup) findViewById7;
            View findViewById8 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_text);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(\n …amic_label_text\n        )");
            this.dynamicLabelText = (TextView) findViewById8;
            View findViewById9 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(\n …amic_label_icon\n        )");
            this.dynamicLabelIcon = (FeedDraweeView) findViewById9;
            View findViewById10 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_mini_video_bg_layer);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(co…feed_mini_video_bg_layer)");
            this.bgLayer = findViewById10;
            View findViewById11 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_mini_video_bg_down_layer);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(co…mini_video_bg_down_layer)");
            this.bgDownLayer = findViewById11;
            View findViewById12 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_new);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(co…_video_dynamic_label_new)");
            this.newDynamicLabel = (ViewGroup) findViewById12;
            View findViewById13 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_new_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(co…o_dynamic_label_new_icon)");
            this.newLabelIcon = (FeedDraweeView) findViewById13;
            View findViewById14 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_new_title);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(co…_dynamic_label_new_title)");
            this.newLabelTitle = (TextView) findViewById14;
            View findViewById15 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_new_subtitle);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(co…namic_label_new_subtitle)");
            this.newLabelSubTitle = (TextView) findViewById15;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final FeedDraweeView getCoverImg() {
            return this.coverImg;
        }

        public final FeedDraweeView getPlayIcon() {
            return this.playIcon;
        }

        public final ImageView getDislikeView() {
            return this.dislikeView;
        }

        public final TextView getCommentNum() {
            return this.commentNum;
        }

        public final FeedDraweeView getTopLabel() {
            return this.topLabel;
        }

        public final ViewGroup getDynamicLabel() {
            return this.dynamicLabel;
        }

        public final TextView getDynamicLabelText() {
            return this.dynamicLabelText;
        }

        public final FeedDraweeView getDynamicLabelIcon() {
            return this.dynamicLabelIcon;
        }

        public final View getBgLayer() {
            return this.bgLayer;
        }

        public final View getBgDownLayer() {
            return this.bgDownLayer;
        }

        public final ViewGroup getNewDynamicLabel() {
            return this.newDynamicLabel;
        }

        public final FeedDraweeView getNewLabelIcon() {
            return this.newLabelIcon;
        }

        public final TextView getNewLabelTitle() {
            return this.newLabelTitle;
        }

        public final TextView getNewLabelSubTitle() {
            return this.newLabelSubTitle;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\bR\u0011\u0010\u001a\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\bR\u0011\u0010\"\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010$\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0011\u0010&\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0011\u0010(\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\bR\u0011\u0010*\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\fR\u0011\u0010,\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\fR\u0011\u0010.\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u00100\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\fR\u0011\u00102\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u00104\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\bR\u0011\u00106\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0013R\u0011\u00108\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\f¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemVH2;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "authorAvatarImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "getAuthorAvatarImg", "()Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "authorDisplayNameTxt", "Landroid/widget/TextView;", "getAuthorDisplayNameTxt", "()Landroid/widget/TextView;", "bgLayer", "getBgLayer", "()Landroid/view/View;", "bottomCenterRlt", "Landroid/widget/RelativeLayout;", "getBottomCenterRlt", "()Landroid/widget/RelativeLayout;", "bottomLabel", "Landroid/view/ViewGroup;", "getBottomLabel", "()Landroid/view/ViewGroup;", "bottomLabelIcon", "getBottomLabelIcon", "bottomLabelText", "getBottomLabelText", "centerPlayIcon", "Landroid/widget/ImageView;", "getCenterPlayIcon", "()Landroid/widget/ImageView;", "coverImg", "getCoverImg", "dislikeView", "getDislikeView", "durationTxt", "getDurationTxt", "dynamicLabel", "getDynamicLabel", "dynamicLabelIcon", "getDynamicLabelIcon", "dynamicLabelText", "getDynamicLabelText", "likeCountTxt", "getLikeCountTxt", "likeIconImg", "getLikeIconImg", "playCountTxt", "getPlayCountTxt", "rightPlayIcon", "getRightPlayIcon", "topLabel", "getTopLabel", "topRlt", "getTopRlt", "videoDescTxt", "getVideoDescTxt", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedMiniVideoHScrollAdapter.kt */
    private static final class ItemVH2 extends RecyclerView.ViewHolder {
        private final FeedDraweeView authorAvatarImg;
        private final TextView authorDisplayNameTxt;
        private final View bgLayer;
        private final RelativeLayout bottomCenterRlt;
        private final ViewGroup bottomLabel;
        private final FeedDraweeView bottomLabelIcon;
        private final TextView bottomLabelText;
        private final ImageView centerPlayIcon;
        private final FeedDraweeView coverImg;
        private final ImageView dislikeView;
        private final TextView durationTxt;
        private final ViewGroup dynamicLabel;
        private final FeedDraweeView dynamicLabelIcon;
        private final TextView dynamicLabelText;
        private final TextView likeCountTxt;
        private final ImageView likeIconImg;
        private final TextView playCountTxt;
        private final ImageView rightPlayIcon;
        private final FeedDraweeView topLabel;
        private final RelativeLayout topRlt;
        private final TextView videoDescTxt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemVH2(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_cover);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co…eed_tpl_mini_video_cover)");
            this.coverImg = (FeedDraweeView) findViewById;
            View findViewById2 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_top_rlt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co…d_tpl_mini_video_top_rlt)");
            this.topRlt = (RelativeLayout) findViewById2;
            View findViewById3 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_label);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(co…eed_tpl_mini_video_label)");
            this.topLabel = (FeedDraweeView) findViewById3;
            View findViewById4 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(co…mini_video_dynamic_label)");
            this.dynamicLabel = (ViewGroup) findViewById4;
            View findViewById5 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_text);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(\n …amic_label_text\n        )");
            this.dynamicLabelText = (TextView) findViewById5;
            View findViewById6 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dynamic_label_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(\n …amic_label_icon\n        )");
            this.dynamicLabelIcon = (FeedDraweeView) findViewById6;
            View findViewById7 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_play_icon_center);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(co…i_video_play_icon_center)");
            this.centerPlayIcon = (ImageView) findViewById7;
            View findViewById8 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_play_icon_right);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(co…ni_video_play_icon_right)");
            this.rightPlayIcon = (ImageView) findViewById8;
            View findViewById9 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_mini_video_bg_layer);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(co…feed_mini_video_bg_layer)");
            this.bgLayer = findViewById9;
            View findViewById10 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_mini_video_duration_label);
            Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(co…ini_video_duration_label)");
            this.durationTxt = (TextView) findViewById10;
            View findViewById11 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_like_img);
            Intrinsics.checkNotNullExpressionValue(findViewById11, "itemView.findViewById(co…_tpl_mini_video_like_img)");
            this.likeIconImg = (ImageView) findViewById11;
            View findViewById12 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_like_txt);
            Intrinsics.checkNotNullExpressionValue(findViewById12, "itemView.findViewById(co…_tpl_mini_video_like_txt)");
            this.likeCountTxt = (TextView) findViewById12;
            View findViewById13 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_play_count);
            Intrinsics.checkNotNullExpressionValue(findViewById13, "itemView.findViewById(co…pl_mini_video_play_count)");
            this.playCountTxt = (TextView) findViewById13;
            View findViewById14 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_center_info_rlt);
            Intrinsics.checkNotNullExpressionValue(findViewById14, "itemView.findViewById(co…tpl_mini_center_info_rlt)");
            this.bottomCenterRlt = (RelativeLayout) findViewById14;
            View findViewById15 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_bottom_label);
            Intrinsics.checkNotNullExpressionValue(findViewById15, "itemView.findViewById(co…_mini_video_bottom_label)");
            this.bottomLabel = (ViewGroup) findViewById15;
            View findViewById16 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_bottom_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById16, "itemView.findViewById(co…l_mini_video_bottom_icon)");
            this.bottomLabelIcon = (FeedDraweeView) findViewById16;
            View findViewById17 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_bottom_title);
            Intrinsics.checkNotNullExpressionValue(findViewById17, "itemView.findViewById(co…_mini_video_bottom_title)");
            this.bottomLabelText = (TextView) findViewById17;
            View findViewById18 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_desc_txt);
            Intrinsics.checkNotNullExpressionValue(findViewById18, "itemView.findViewById(co…_tpl_mini_video_desc_txt)");
            this.videoDescTxt = (TextView) findViewById18;
            View findViewById19 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_author_avatar);
            Intrinsics.checkNotNullExpressionValue(findViewById19, "itemView.findViewById(co…mini_video_author_avatar)");
            this.authorAvatarImg = (FeedDraweeView) findViewById19;
            View findViewById20 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_author_displayname);
            Intrinsics.checkNotNullExpressionValue(findViewById20, "itemView.findViewById(co…video_author_displayname)");
            this.authorDisplayNameTxt = (TextView) findViewById20;
            View findViewById21 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_dislike);
            Intrinsics.checkNotNullExpressionValue(findViewById21, "itemView.findViewById(co…d_tpl_mini_video_dislike)");
            this.dislikeView = (ImageView) findViewById21;
        }

        public final FeedDraweeView getCoverImg() {
            return this.coverImg;
        }

        public final RelativeLayout getTopRlt() {
            return this.topRlt;
        }

        public final FeedDraweeView getTopLabel() {
            return this.topLabel;
        }

        public final ViewGroup getDynamicLabel() {
            return this.dynamicLabel;
        }

        public final TextView getDynamicLabelText() {
            return this.dynamicLabelText;
        }

        public final FeedDraweeView getDynamicLabelIcon() {
            return this.dynamicLabelIcon;
        }

        public final ImageView getCenterPlayIcon() {
            return this.centerPlayIcon;
        }

        public final ImageView getRightPlayIcon() {
            return this.rightPlayIcon;
        }

        public final View getBgLayer() {
            return this.bgLayer;
        }

        public final TextView getDurationTxt() {
            return this.durationTxt;
        }

        public final ImageView getLikeIconImg() {
            return this.likeIconImg;
        }

        public final TextView getLikeCountTxt() {
            return this.likeCountTxt;
        }

        public final TextView getPlayCountTxt() {
            return this.playCountTxt;
        }

        public final RelativeLayout getBottomCenterRlt() {
            return this.bottomCenterRlt;
        }

        public final ViewGroup getBottomLabel() {
            return this.bottomLabel;
        }

        public final FeedDraweeView getBottomLabelIcon() {
            return this.bottomLabelIcon;
        }

        public final TextView getBottomLabelText() {
            return this.bottomLabelText;
        }

        public final TextView getVideoDescTxt() {
            return this.videoDescTxt;
        }

        public final FeedDraweeView getAuthorAvatarImg() {
            return this.authorAvatarImg;
        }

        public final TextView getAuthorDisplayNameTxt() {
            return this.authorDisplayNameTxt;
        }

        public final ImageView getDislikeView() {
            return this.dislikeView;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$MoreItemVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "cmd", "", "moreItemView", "Lcom/baidu/searchbox/feed/template/evolution/HScrollMoreView;", "(Landroid/content/Context;Ljava/lang/String;Lcom/baidu/searchbox/feed/template/evolution/HScrollMoreView;)V", "getCmd", "()Ljava/lang/String;", "moreArrow", "Landroid/widget/ImageView;", "getMoreArrow", "()Landroid/widget/ImageView;", "moreArrow$delegate", "Lkotlin/Lazy;", "moreBtn", "Landroid/widget/TextView;", "getMoreBtn", "()Landroid/widget/TextView;", "moreBtn$delegate", "getMoreItemView", "()Lcom/baidu/searchbox/feed/template/evolution/HScrollMoreView;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedMiniVideoHScrollAdapter.kt */
    public static final class MoreItemVH extends RecyclerView.ViewHolder {
        private final String cmd;
        private final Context context;
        private final Lazy moreArrow$delegate;
        private final Lazy moreBtn$delegate;
        private final HScrollMoreView moreItemView;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MoreItemVH(Context context2, String str, HScrollMoreView hScrollMoreView, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(context2, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? new HScrollMoreView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null) : hScrollMoreView);
        }

        public final String getCmd() {
            return this.cmd;
        }

        public final HScrollMoreView getMoreItemView() {
            return this.moreItemView;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MoreItemVH(Context context2, String cmd2, HScrollMoreView moreItemView2) {
            super(moreItemView2);
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(moreItemView2, "moreItemView");
            this.context = context2;
            this.cmd = cmd2;
            this.moreItemView = moreItemView2;
            this.moreArrow$delegate = LazyKt.lazy(new FeedMiniVideoHScrollAdapter$MoreItemVH$moreArrow$2(this));
            this.moreBtn$delegate = LazyKt.lazy(new FeedMiniVideoHScrollAdapter$MoreItemVH$moreBtn$2(this));
            getMoreBtn().setLineSpacing(DeviceUtils.ScreenInfo.dp2pxf(context2, 4.0f), 1.0f);
        }

        public final ImageView getMoreArrow() {
            Object value = this.moreArrow$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-moreArrow>(...)");
            return (ImageView) value;
        }

        public final TextView getMoreBtn() {
            Object value = this.moreBtn$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-moreBtn>(...)");
            return (TextView) value;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedMiniVideoHScrollAdapter$ItemLoadVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imgLoad", "Landroid/widget/ImageView;", "getImgLoad", "()Landroid/widget/ImageView;", "reload", "Landroid/widget/TextView;", "getReload", "()Landroid/widget/TextView;", "title", "getTitle", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FeedMiniVideoHScrollAdapter.kt */
    private static final class ItemLoadVH extends RecyclerView.ViewHolder {
        private final ImageView imgLoad;
        private final TextView reload;
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemLoadVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            View findViewById = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_load);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(co…feed_tpl_mini_video_load)");
            this.imgLoad = (ImageView) findViewById;
            View findViewById2 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_title);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(co…eed_tpl_mini_video_title)");
            this.title = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(com.baidu.searchbox.feed.core.R.id.feed_tpl_mini_video_reload);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(co…ed_tpl_mini_video_reload)");
            this.reload = (TextView) findViewById3;
        }

        public final ImageView getImgLoad() {
            return this.imgLoad;
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getReload() {
            return this.reload;
        }
    }
}
