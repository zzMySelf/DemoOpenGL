package com.baidu.searchbox.feed.payment.column.facets.diverse;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.payment.column.R;
import com.baidu.searchbox.feed.payment.model.IconicTag;
import com.baidu.searchbox.feed.payment.model.PayStats1076;
import com.baidu.searchbox.feed.payment.model.RankingTag;
import com.baidu.searchbox.feed.payment.model.SpColumnDetailData;
import com.baidu.searchbox.feed.payment.utils.PayUtilsKt;
import com.baidu.searchbox.feed.payment.utils.SimpleUiHelperKt;
import com.baidu.searchbox.feed.payment.widget.TextViewEx;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.ui.span.BdSpanTouchFixTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001;B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\tJ\u0012\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u001c\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u001c\u0010-\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010.\u001a\u00020\t2\b\b\u0001\u0010/\u001a\u00020\tH\u0002J\b\u00100\u001a\u00020\u0003H\u0002J\u0018\u00101\u001a\u00020%2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000204\u0018\u000103H\u0002J\u0018\u00105\u001a\u00020%2\u000e\u00102\u001a\n\u0012\u0004\u0012\u000206\u0018\u000103H\u0002J\u0012\u00107\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u000109H\u0002J\u0010\u0010:\u001a\u00020%2\b\u00108\u001a\u0004\u0018\u000109R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0010j\b\u0012\u0004\u0012\u00020\u0003`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/facets/diverse/SpTitleRankInfoStyle;", "", "parent", "Landroid/view/View;", "context", "Landroid/content/Context;", "statistics", "Lcom/baidu/searchbox/feed/payment/model/PayStats1076;", "marginTop", "", "(Landroid/view/View;Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/model/PayStats1076;I)V", "getContext", "()Landroid/content/Context;", "descArea", "Landroid/widget/RelativeLayout;", "dividers", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "iconicTagLayer", "Landroid/widget/LinearLayout;", "iconicTagLayerTopLine", "getMarginTop", "()I", "getParent", "()Landroid/view/View;", "rankInfoLeftImg", "Landroid/view/ViewGroup;", "rankInfoMiddleRanking", "rankInfoRightCategorize", "rankingInfoLayer", "rootLayer", "getStatistics", "()Lcom/baidu/searchbox/feed/payment/model/PayStats1076;", "titleTextView", "Lcom/baidu/searchbox/ui/span/BdSpanTouchFixTextView;", "topDesc", "changeTitleLines", "", "lines", "dealRankInfoLeftImg", "imageUrl", "", "dealRankInfoMiddleRanking", "text", "cmd", "dealRankInfoRightCategorize", "getColor", "resId", "makeIconicTagDivider", "setIconicTags", "tags", "", "Lcom/baidu/searchbox/feed/payment/model/IconicTag;", "setRankingInfoTags", "Lcom/baidu/searchbox/feed/payment/model/RankingTag;", "setTitle", "detailModel", "Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;", "updateUi", "IconicTagView", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpTitleRankInfoStyle.kt */
public final class SpTitleRankInfoStyle {
    private final Context context;
    private RelativeLayout descArea;
    private final ArrayList<View> dividers = new ArrayList<>();
    private LinearLayout iconicTagLayer;
    private View iconicTagLayerTopLine;
    private final int marginTop;
    private final View parent;
    private ViewGroup rankInfoLeftImg;
    private RelativeLayout rankInfoMiddleRanking;
    private RelativeLayout rankInfoRightCategorize;
    /* access modifiers changed from: private */
    public LinearLayout rankingInfoLayer;
    private ViewGroup rootLayer;
    private final PayStats1076 statistics;
    private BdSpanTouchFixTextView titleTextView;
    private LinearLayout topDesc;

    public SpTitleRankInfoStyle(View parent2, Context context2, PayStats1076 statistics2, int marginTop2) {
        Intrinsics.checkNotNullParameter(parent2, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(context2, "context");
        this.parent = parent2;
        this.context = context2;
        this.statistics = statistics2;
        this.marginTop = marginTop2;
        this.rootLayer = (ViewGroup) parent2.findViewById(R.id.feed_spcolumn_pane_content);
        this.titleTextView = (BdSpanTouchFixTextView) parent2.findViewById(R.id.feed_spcolumn_ranking_title);
        this.rankingInfoLayer = (LinearLayout) parent2.findViewById(R.id.feed_spcolumn_ranking_info);
        this.iconicTagLayerTopLine = parent2.findViewById(R.id.feed_spcolumn_iconic_tags_top_divider);
        this.iconicTagLayer = (LinearLayout) parent2.findViewById(R.id.feed_spcolumn_iconic_tags);
        this.rankInfoLeftImg = (ViewGroup) parent2.findViewById(R.id.feed_spcolumn_ranking_bar_tag_img_layer);
        this.rankInfoMiddleRanking = (RelativeLayout) parent2.findViewById(R.id.feed_spcolumn_ranking_bar_tag_rank_layer);
        this.rankInfoRightCategorize = (RelativeLayout) parent2.findViewById(R.id.feed_spcolumn_ranking_bar_tag_categorize_layer);
        this.descArea = (RelativeLayout) parent2.findViewById(R.id.feed_spcolumn_desc_area);
        this.topDesc = (LinearLayout) parent2.findViewById(R.id.feed_spcolumn_top_desc);
    }

    public final Context getContext() {
        return this.context;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    public final View getParent() {
        return this.parent;
    }

    public final PayStats1076 getStatistics() {
        return this.statistics;
    }

    public final void updateUi(SpColumnDetailData detailModel) {
        if (detailModel != null) {
            ViewGroup viewGroup = this.rootLayer;
            if (viewGroup != null) {
                viewGroup.setBackgroundColor(getColor(com.baidu.android.common.ui.style.R.color.GC10));
            }
            this.dividers.clear();
            View it = this.iconicTagLayerTopLine;
            if (it != null) {
                it.setBackgroundColor(getColor(com.baidu.searchbox.feed.styles.R.color.FC21));
                this.dividers.add(it);
            }
            if (this.marginTop > 0) {
                LinearLayout linearLayout = this.topDesc;
                LinearLayout.LayoutParams layoutParams = null;
                ViewGroup.LayoutParams layoutParams2 = linearLayout != null ? linearLayout.getLayoutParams() : null;
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                }
                LinearLayout.LayoutParams layoutParams3 = layoutParams;
                if (layoutParams3 != null) {
                    layoutParams3.topMargin = this.marginTop;
                }
            }
            setTitle(detailModel);
            setIconicTags(detailModel.iconicTags);
            setRankingInfoTags(detailModel.topCardTags);
        }
    }

    private final void setTitle(SpColumnDetailData detailModel) {
        BdSpanTouchFixTextView it = this.titleTextView;
        if (it != null) {
            it.setTextColor(getColor(com.baidu.searchbox.feed.payment.R.color.feed_pay_GC1));
            it.setTextWithUnifiedPadding(detailModel != null ? detailModel.title : null, TextView.BufferType.NORMAL);
            it.getViewTreeObserver().addOnPreDrawListener(new SpTitleRankInfoStyle$setTitle$1$1(it, detailModel, this));
        }
    }

    public final void changeTitleLines(int lines) {
        BdSpanTouchFixTextView bdSpanTouchFixTextView = this.titleTextView;
        if (bdSpanTouchFixTextView != null) {
            bdSpanTouchFixTextView.setMaxLines(lines);
        }
    }

    private final void setIconicTags(List<IconicTag> tags) {
        Collection collection = tags;
        if (collection == null || collection.isEmpty()) {
            LinearLayout linearLayout = this.iconicTagLayer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.iconicTagLayer;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LinearLayout linearLayout3 = this.iconicTagLayer;
        if (linearLayout3 != null) {
            linearLayout3.removeAllViews();
        }
        View divider = null;
        int size = tags.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (divider != null) {
                View it = divider;
                LinearLayout linearLayout4 = this.iconicTagLayer;
                if (linearLayout4 != null) {
                    linearLayout4.addView(it);
                }
            }
            divider = makeIconicTagDivider();
            IconicTagView tagView = new IconicTagView(this.context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            tagView.updateUi(tags.get(i2));
            LinearLayout linearLayout5 = this.iconicTagLayer;
            if (linearLayout5 != null) {
                linearLayout5.addView(tagView);
            }
        }
    }

    private final View makeIconicTagDivider() {
        LinearLayout.LayoutParams dividerLayoutPrams = new LinearLayout.LayoutParams(1, -1);
        View view2 = new View(this.context);
        View $this$makeIconicTagDivider_u24lambda_u2d6 = view2;
        this.dividers.add($this$makeIconicTagDivider_u24lambda_u2d6);
        $this$makeIconicTagDivider_u24lambda_u2d6.setLayoutParams(dividerLayoutPrams);
        $this$makeIconicTagDivider_u24lambda_u2d6.setBackgroundColor(getColor(com.baidu.searchbox.feed.styles.R.color.FC21));
        return view2;
    }

    private final void setRankingInfoTags(List<RankingTag> tags) {
        Collection collection = tags;
        if (collection == null || collection.isEmpty()) {
            LinearLayout linearLayout = this.rankingInfoLayer;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.rankingInfoLayer;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        for (RankingTag item : tags) {
            String str = item.type;
            if (str != null) {
                switch (str.hashCode()) {
                    case 3492908:
                        if (str.equals("rank")) {
                            dealRankInfoMiddleRanking(item.text, item.cmd);
                            break;
                        } else {
                            break;
                        }
                    case 50511102:
                        if (str.equals("category")) {
                            dealRankInfoRightCategorize(item.text, item.cmd);
                            break;
                        } else {
                            break;
                        }
                    case 100313435:
                        if (str.equals("image")) {
                            dealRankInfoLeftImg(item.img);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }

    private final void dealRankInfoLeftImg(String imageUrl) {
        FeedDraweeView asIcon;
        CharSequence charSequence = imageUrl;
        if (charSequence == null || charSequence.length() == 0) {
            ViewGroup viewGroup = this.rankInfoLeftImg;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                return;
            }
            return;
        }
        ViewGroup viewGroup2 = this.rankInfoLeftImg;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        ViewGroup viewGroup3 = this.rankInfoLeftImg;
        FeedDraweeView img = viewGroup3 != null ? (FeedDraweeView) viewGroup3.findViewById(R.id.feed_spcolumn_ranking_bar_tag_img) : null;
        if (img != null && (asIcon = img.asIcon()) != null) {
            asIcon.loadImageWithoutModel(imageUrl);
        }
    }

    private final void dealRankInfoMiddleRanking(String text, String cmd) {
        CharSequence charSequence = text;
        if (charSequence == null || charSequence.length() == 0) {
            RelativeLayout relativeLayout = this.rankInfoMiddleRanking;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.rankInfoMiddleRanking;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        PayStats1076 payStats1076 = this.statistics;
        if (payStats1076 != null) {
            payStats1076.recordRankInfoRankingShow();
        }
        RelativeLayout relativeLayout3 = this.rankInfoMiddleRanking;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new SpTitleRankInfoStyle$$ExternalSyntheticLambda2(this, cmd));
        }
        RelativeLayout relativeLayout4 = this.rankInfoMiddleRanking;
        ImageView tvArrow = null;
        ImageView icon = relativeLayout4 != null ? (ImageView) relativeLayout4.findViewById(R.id.feed_spcolumn_ranking_bar_rank_img) : null;
        if (icon != null) {
            icon.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.feed_spcolumn_rank_info_left_icon));
        }
        RelativeLayout relativeLayout5 = this.rankInfoMiddleRanking;
        RelativeLayout tvLayer = relativeLayout5 != null ? (RelativeLayout) relativeLayout5.findViewById(R.id.feed_spcolumn_ranking_tag_rank_tv_bg) : null;
        if (tvLayer != null) {
            tvLayer.setBackground(ContextCompat.getDrawable(this.context, R.drawable.feed_spcolumn_ranking_tag_rank_bg));
        }
        RelativeLayout relativeLayout6 = this.rankInfoMiddleRanking;
        TextViewEx tv = relativeLayout6 != null ? (TextViewEx) relativeLayout6.findViewById(R.id.feed_spcolumn_ranking_bar_tag_rank) : null;
        if (tv != null) {
            tv.setTextColor(ContextCompat.getColor(this.context, com.baidu.android.common.ui.style.R.color.GC62));
        }
        if (tv != null) {
            tv.setText(text);
        }
        RelativeLayout relativeLayout7 = this.rankInfoMiddleRanking;
        if (relativeLayout7 != null) {
            tvArrow = (ImageView) relativeLayout7.findViewById(R.id.feed_spcolumn_ranking_bar_tag_rank_arrow);
        }
        if (tvArrow != null) {
            tvArrow.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.feed_spcolumn_ranking_bar_tag_rank_arrow));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dealRankInfoMiddleRanking$lambda-7  reason: not valid java name */
    public static final void m19063dealRankInfoMiddleRanking$lambda7(SpTitleRankInfoStyle this$0, String $cmd, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Router.invoke(this$0.context, $cmd);
        PayStats1076 payStats1076 = this$0.statistics;
        if (payStats1076 != null) {
            payStats1076.recordRankInfoRankingClick();
        }
    }

    private final void dealRankInfoRightCategorize(String text, String cmd) {
        CharSequence charSequence = text;
        if (charSequence == null || charSequence.length() == 0) {
            RelativeLayout relativeLayout = this.rankInfoRightCategorize;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout2 = this.rankInfoRightCategorize;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        PayStats1076 payStats1076 = this.statistics;
        if (payStats1076 != null) {
            payStats1076.recordRankInfoCategoryShow();
        }
        RelativeLayout relativeLayout3 = this.rankInfoRightCategorize;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnClickListener(new SpTitleRankInfoStyle$$ExternalSyntheticLambda0(this, cmd));
        }
        RelativeLayout relativeLayout4 = this.rankInfoRightCategorize;
        ImageView tvArrow = null;
        RelativeLayout tvLayer = relativeLayout4 != null ? (RelativeLayout) relativeLayout4.findViewById(R.id.feed_spcolumn_ranking_bar_tag_categorize_layer) : null;
        if (tvLayer != null) {
            tvLayer.setBackground(ContextCompat.getDrawable(this.context, R.drawable.feed_spcolumn_ranking_tag_categorize_bg));
        }
        RelativeLayout relativeLayout5 = this.rankInfoRightCategorize;
        TextViewEx tv = relativeLayout5 != null ? (TextViewEx) relativeLayout5.findViewById(R.id.feed_spcolumn_ranking_bar_tag_categorize) : null;
        if (tv != null) {
            tv.setTextColor(ContextCompat.getColor(this.context, com.baidu.android.common.ui.style.R.color.GC106));
        }
        if (tv != null) {
            tv.setText(text);
        }
        RelativeLayout relativeLayout6 = this.rankInfoRightCategorize;
        if (relativeLayout6 != null) {
            tvArrow = (ImageView) relativeLayout6.findViewById(R.id.feed_spcolumn_ranking_bar_tag_categorize_arrow);
        }
        if (tvArrow != null) {
            tvArrow.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.feed_spcolumn_ranking_bar_tag_categorize_arrow));
        }
        RelativeLayout relativeLayout7 = this.rankInfoRightCategorize;
        if (relativeLayout7 != null) {
            relativeLayout7.post(new SpTitleRankInfoStyle$$ExternalSyntheticLambda1(tv, text, this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dealRankInfoRightCategorize$lambda-8  reason: not valid java name */
    public static final void m19064dealRankInfoRightCategorize$lambda8(SpTitleRankInfoStyle this$0, String $cmd, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Router.invoke(this$0.context, $cmd);
        PayStats1076 payStats1076 = this$0.statistics;
        if (payStats1076 != null) {
            payStats1076.recordRankInfoCategoryClick();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dealRankInfoRightCategorize$lambda-9  reason: not valid java name */
    public static final void m19065dealRankInfoRightCategorize$lambda9(TextViewEx $tv, String $text, SpTitleRankInfoStyle this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextPaint tvPaint = $tv != null ? $tv.getPaint() : null;
        int exceptW = (tvPaint != null ? (int) tvPaint.measureText($text) : 0) + DeviceUtils.ScreenInfo.dp2px(this$0.context, 28.0f);
        Rect realRect = new Rect();
        RelativeLayout relativeLayout = this$0.rankInfoRightCategorize;
        if (relativeLayout != null) {
            relativeLayout.getLocalVisibleRect(realRect);
        }
        if (realRect.width() < exceptW) {
            RelativeLayout relativeLayout2 = this$0.rankInfoRightCategorize;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                return;
            }
            return;
        }
        RelativeLayout relativeLayout3 = this$0.rankInfoRightCategorize;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(0);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/facets/diverse/SpTitleRankInfoStyle$IconicTagView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconicText", "Landroid/widget/TextView;", "iconicTextUnit", "introduction", "updateUi", "", "info", "Lcom/baidu/searchbox/feed/payment/model/IconicTag;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpTitleRankInfoStyle.kt */
    private static final class IconicTagView extends RelativeLayout {
        private TextView iconicText;
        private TextView iconicTextUnit;
        private TextView introduction;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public IconicTagView(Context context) {
            this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public IconicTagView(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(context, "context");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ IconicTagView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IconicTagView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            Intrinsics.checkNotNullParameter(context, "context");
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
            RelativeLayout.LayoutParams layoutParams2 = layoutParams;
            setGravity(17);
            setLayoutParams(layoutParams);
            setMinimumWidth(context.getResources().getDimensionPixelSize(R.dimen.feed_spcolumn_iconic_tag_w));
            View root = LayoutInflater.from(context).inflate(R.layout.feed_spcolumn_iconic_tag_item, this);
            this.iconicText = (TextView) root.findViewById(R.id.feed_spcolumn_iconic_tag_text);
            this.iconicTextUnit = (TextView) root.findViewById(R.id.feed_spcolumn_iconic_tag_text_unit);
            this.introduction = (TextView) root.findViewById(R.id.feed_spcolumn_iconic_tag_intro);
        }

        public final void updateUi(IconicTag info) {
            Intrinsics.checkNotNullParameter(info, "info");
            TextView $this$updateUi_u24lambda_u2d1 = this.iconicText;
            if ($this$updateUi_u24lambda_u2d1 != null) {
                $this$updateUi_u24lambda_u2d1.setText(info.text);
                $this$updateUi_u24lambda_u2d1.setTextColor(ContextCompat.getColor($this$updateUi_u24lambda_u2d1.getContext(), com.baidu.android.common.ui.style.R.color.GC1));
            }
            TextView $this$updateUi_u24lambda_u2d2 = this.iconicTextUnit;
            if ($this$updateUi_u24lambda_u2d2 != null) {
                $this$updateUi_u24lambda_u2d2.setText(info.unit);
                $this$updateUi_u24lambda_u2d2.setTextColor(ContextCompat.getColor($this$updateUi_u24lambda_u2d2.getContext(), com.baidu.android.common.ui.style.R.color.GC1));
            }
            TextView $this$updateUi_u24lambda_u2d3 = this.introduction;
            if ($this$updateUi_u24lambda_u2d3 != null) {
                $this$updateUi_u24lambda_u2d3.setText(info.introduction);
                $this$updateUi_u24lambda_u2d3.setTextColor(ContextCompat.getColor($this$updateUi_u24lambda_u2d3.getContext(), com.baidu.android.common.ui.style.R.color.GC106));
                CharSequence text = $this$updateUi_u24lambda_u2d3.getText();
                $this$updateUi_u24lambda_u2d3.setVisibility(text == null || text.length() == 0 ? 8 : 0);
            }
            if (!PayUtilsKt.isNumber(info.text)) {
                TextView textView = this.iconicText;
                if (textView != null) {
                    textView.setTextSize(0, FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X206)));
                }
                TextView textView2 = this.iconicText;
                if (textView2 != null) {
                    SimpleUiHelperKt.addBoldStyle(textView2, 1.0f);
                }
                TextView textView3 = this.introduction;
                RelativeLayout.LayoutParams it = null;
                ViewGroup.LayoutParams layoutParams = textView3 != null ? textView3.getLayoutParams() : null;
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    it = (RelativeLayout.LayoutParams) layoutParams;
                }
                if (it != null) {
                    it.topMargin = getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X069);
                }
            }
        }
    }

    private final int getColor(int resId) {
        return ContextCompat.getColor(this.context, resId);
    }
}
