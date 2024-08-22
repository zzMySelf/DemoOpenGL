package com.baidu.searchbox.feed.template.biserial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.base.IFeedFontAdjustable;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.model.FeedProbingCardModel;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedRelativeLayout;
import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J(\u0010!\u001a\u00020\u001c2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'\u0018\u00010%H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002J\u001a\u0010+\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0002R\u000e\u0010\n\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/baidu/searchbox/feed/template/biserial/FeedProbingCardView;", "Lcom/baidu/searchbox/feed/template/FeedRelativeLayout;", "Lcom/baidu/searchbox/feed/base/IFeedFontAdjustable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LONG_CLICK_DURATION", "", "bgImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "itemWidth", "", "getItemWidth", "()F", "setItemWidth", "(F)V", "root", "Landroid/view/View;", "selectContainView", "Landroid/widget/LinearLayout;", "subTitle", "Landroid/widget/TextView;", "title", "bgImgOnLayout", "", "onFeedNightModeChanged", "isNightMode", "", "onFontSizeChanged", "update", "feedModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "options", "", "", "", "updateBgImg", "itemData", "Lcom/baidu/searchbox/feed/model/FeedProbingCardModel;", "updateSelectContainer", "updateTitle", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedProbingCardView.kt */
public final class FeedProbingCardView extends FeedRelativeLayout implements IFeedFontAdjustable {
    /* access modifiers changed from: private */
    public final long LONG_CLICK_DURATION;
    private FeedDraweeView bgImg;
    private float itemWidth;
    private View root;
    private LinearLayout selectContainView;
    private TextView subTitle;
    private TextView title;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedProbingCardView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedProbingCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.LONG_CLICK_DURATION = 500;
        View inflate = LayoutInflater.from(context).inflate(R.layout.feed_biserial_probing_card_layout, this);
        this.root = inflate;
        if (inflate != null) {
            inflate.setBackground(FeedBiserialScreenUtil.INSTANCE.getEPStyleItemBg(context));
        }
        this.bgImg = (FeedDraweeView) findViewById(R.id.biserial_probing_card_bg);
        this.title = (TextView) findViewById(R.id.biserial_probing_card_title);
        this.subTitle = (TextView) findViewById(R.id.biserial_probing_subtitle);
        this.selectContainView = (LinearLayout) findViewById(R.id.biserial_probing_card_select_container);
    }

    /* access modifiers changed from: protected */
    public final float getItemWidth() {
        return this.itemWidth;
    }

    /* access modifiers changed from: protected */
    public final void setItemWidth(float f2) {
        this.itemWidth = f2;
    }

    public void update(FeedBaseModel feedModel, Map<String, Object> options) {
        super.update(feedModel, options);
        if ((feedModel != null ? feedModel.data : null) instanceof FeedProbingCardModel) {
            FeedItemData feedItemData = feedModel.data;
            if (feedItemData != null) {
                FeedProbingCardModel itemData = (FeedProbingCardModel) feedItemData;
                updateTitle(itemData);
                updateSelectContainer(itemData, feedModel);
                updateBgImg(itemData);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedProbingCardModel");
        }
    }

    private final void updateBgImg(FeedProbingCardModel itemData) {
        String bgUrl = NightModeHelper.isNightMode() ? itemData.getBgImgNight() : itemData.getBgImgLight();
        CharSequence charSequence = bgUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            FeedDraweeView feedDraweeView = this.bgImg;
            if (feedDraweeView != null) {
                feedDraweeView.loadImage(bgUrl, (FeedBaseModel) null);
            }
            bgImgOnLayout();
        }
    }

    private final void bgImgOnLayout() {
        post(new FeedProbingCardView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: bgImgOnLayout$lambda-1  reason: not valid java name */
    public static final void m19545bgImgOnLayout$lambda1(FeedProbingCardView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedDraweeView feedDraweeView = this$0.bgImg;
        Integer num = null;
        ViewGroup.LayoutParams params = feedDraweeView != null ? feedDraweeView.getLayoutParams() : null;
        if (params != null) {
            FeedBiserialScreenUtil feedBiserialScreenUtil = FeedBiserialScreenUtil.INSTANCE;
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            params.width = (int) feedBiserialScreenUtil.getTemplateWidth(context);
        }
        if (params != null) {
            View view2 = this$0.root;
            if (view2 != null) {
                num = Integer.valueOf(view2.getHeight());
            }
            params.height = num.intValue();
        }
        FeedDraweeView feedDraweeView2 = this$0.bgImg;
        if (feedDraweeView2 != null) {
            feedDraweeView2.setLayoutParams(params);
        }
        FeedDraweeView it = this$0.bgImg;
        if (it != null) {
            FeedBiserialScreenUtil feedBiserialScreenUtil2 = FeedBiserialScreenUtil.INSTANCE;
            Context context2 = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            feedBiserialScreenUtil2.changeEPStyleImageBgWithAllCorner(it, context2);
        }
    }

    private final void updateTitle(FeedProbingCardModel itemData) {
        TextView textView = this.title;
        if (textView != null) {
            textView.setText(itemData.title);
        }
        TextView textView2 = this.subTitle;
        if (textView2 != null) {
            textView2.setText(itemData.getSubtitle());
        }
        TextView textView3 = this.title;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC1));
        }
        TextView textView4 = this.subTitle;
        if (textView4 != null) {
            textView4.setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC7));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0181 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSelectContainer(com.baidu.searchbox.feed.model.FeedProbingCardModel r17, com.baidu.searchbox.feed.model.FeedBaseModel r18) {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList r1 = r17.getSelectList()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0188
            android.widget.LinearLayout r1 = r0.selectContainView
            if (r1 == 0) goto L_0x0013
            r1.removeAllViews()
        L_0x0013:
            r1 = 0
            java.util.ArrayList r2 = r17.getSelectList()
            int r2 = r2.size()
        L_0x001c:
            if (r1 >= r2) goto L_0x0185
            android.content.Context r3 = r16.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            int r4 = com.baidu.searchbox.feed.template.R.layout.feed_biserial_probing_select
            android.widget.LinearLayout r5 = r0.selectContainView
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r6 = 0
            android.view.View r3 = r3.inflate(r4, r5, r6)
            int r4 = com.baidu.searchbox.feed.template.R.id.feed_biserial_probing_select_tv
            android.view.View r4 = r3.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r5 = com.baidu.searchbox.feed.template.R.id.biserial_probing_card_bg
            android.view.View r5 = r3.findViewById(r5)
            com.baidu.searchbox.feed.template.FeedDraweeView r5 = (com.baidu.searchbox.feed.template.FeedDraweeView) r5
            int r7 = com.baidu.searchbox.feed.template.R.id.feed_biserial_probing_select_shadow
            android.view.View r7 = r3.findViewById(r7)
            android.view.ViewGroup$LayoutParams r8 = r3.getLayoutParams()
            boolean r9 = r8 instanceof android.widget.LinearLayout.LayoutParams
            r10 = 0
            if (r9 == 0) goto L_0x0053
            android.widget.LinearLayout$LayoutParams r8 = (android.widget.LinearLayout.LayoutParams) r8
            goto L_0x0054
        L_0x0053:
            r8 = r10
        L_0x0054:
            r9 = 1
            if (r1 == 0) goto L_0x0086
            if (r8 != 0) goto L_0x005a
            goto L_0x0066
        L_0x005a:
            android.content.res.Resources r11 = r16.getResources()
            int r12 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X081
            int r11 = r11.getDimensionPixelSize(r12)
            r8.topMargin = r11
        L_0x0066:
            java.util.ArrayList r11 = r17.getSelectList()
            int r11 = r11.size()
            int r11 = r11 - r9
            if (r1 != r11) goto L_0x0080
            if (r8 != 0) goto L_0x0074
            goto L_0x0080
        L_0x0074:
            android.content.res.Resources r11 = r16.getResources()
            int r12 = com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X067
            int r11 = r11.getDimensionPixelSize(r12)
            r8.bottomMargin = r11
        L_0x0080:
            r11 = r8
            android.view.ViewGroup$LayoutParams r11 = (android.view.ViewGroup.LayoutParams) r11
            r3.setLayoutParams(r11)
        L_0x0086:
            android.widget.LinearLayout r11 = r0.selectContainView
            if (r11 == 0) goto L_0x008d
            r11.addView(r3)
        L_0x008d:
            android.content.res.Resources r11 = r16.getResources()
            int r12 = com.baidu.searchbox.feed.styles.R.color.FC1
            int r11 = r11.getColor(r12)
            r4.setTextColor(r11)
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef
            r11.<init>()
            java.util.ArrayList r12 = r17.getSelectList()
            java.lang.Object r12 = r12.get(r1)
            r11.element = r12
            T r12 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r12 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r12
            if (r12 == 0) goto L_0x00c4
            java.lang.String r12 = r12.getBgImg()
            if (r12 == 0) goto L_0x00c4
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 <= 0) goto L_0x00bf
            r12 = r9
            goto L_0x00c0
        L_0x00bf:
            r12 = r6
        L_0x00c0:
            if (r12 != r9) goto L_0x00c4
            r12 = r9
            goto L_0x00c5
        L_0x00c4:
            r12 = r6
        L_0x00c5:
            if (r12 == 0) goto L_0x00fa
            T r12 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r12 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r12
            if (r12 == 0) goto L_0x00d2
            java.lang.String r12 = r12.getBgImg()
            goto L_0x00d3
        L_0x00d2:
            r12 = r10
        L_0x00d3:
            r5.loadImage(r12, r10)
            r7.setVisibility(r6)
            if (r4 == 0) goto L_0x00e8
            android.content.res.Resources r12 = r16.getResources()
            int r13 = com.baidu.searchbox.feed.styles.R.color.FC6
            int r12 = r12.getColor(r13)
            r4.setTextColor(r12)
        L_0x00e8:
            if (r5 == 0) goto L_0x00fa
            r12 = r5
            r13 = 0
            com.baidu.searchbox.feed.template.biserial.FeedBiserialScreenUtil r14 = com.baidu.searchbox.feed.template.biserial.FeedBiserialScreenUtil.INSTANCE
            android.content.Context r15 = r16.getContext()
            java.lang.String r10 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r10)
            r14.changeEPStyleImageBgWithAllCorner(r12, r15)
        L_0x00fa:
            T r10 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r10 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r10
            if (r10 == 0) goto L_0x0105
            java.lang.String r10 = r10.getTitle()
            goto L_0x0106
        L_0x0105:
            r10 = 0
        L_0x0106:
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4.setText(r10)
            r10 = r0
            android.view.View r10 = (android.view.View) r10
            int r12 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X300
            float r10 = com.baidu.searchbox.kotlinx.ViewExtensionsKt.getDimension(r10, r12)
            float r10 = com.baidu.searchbox.config.FontSizeHelper.getScaledSize(r9, r10)
            r4.setTextSize(r6, r10)
            android.content.res.Resources r6 = r16.getResources()
            int r10 = com.baidu.searchbox.feed.template.R.drawable.feed_biserial_probing_select_bg
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r10)
            r3.setBackground(r6)
            if (r3 == 0) goto L_0x0138
            com.baidu.searchbox.feed.template.biserial.FeedProbingCardView$updateSelectContainer$2 r6 = new com.baidu.searchbox.feed.template.biserial.FeedProbingCardView$updateSelectContainer$2
            r10 = r18
            r6.<init>(r10, r11, r1)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r3.setOnClickListener(r6)
            goto L_0x013a
        L_0x0138:
            r10 = r18
        L_0x013a:
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            kotlin.jvm.internal.Ref$LongRef r12 = new kotlin.jvm.internal.Ref$LongRef
            r12.<init>()
            if (r3 == 0) goto L_0x0150
            com.baidu.searchbox.feed.template.biserial.FeedProbingCardView$updateSelectContainer$3 r13 = new com.baidu.searchbox.feed.template.biserial.FeedProbingCardView$updateSelectContainer$3
            r13.<init>(r6, r12, r0)
            android.view.View$OnTouchListener r13 = (android.view.View.OnTouchListener) r13
            r3.setOnTouchListener(r13)
        L_0x0150:
            T r13 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r13 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r13
            if (r13 == 0) goto L_0x015f
            boolean r13 = r13.getHasDisplay()
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            goto L_0x0160
        L_0x015f:
            r13 = 0
        L_0x0160:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0181
            T r13 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r13 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r13
            if (r13 == 0) goto L_0x0174
            java.lang.String r13 = r13.getTitle()
            goto L_0x0175
        L_0x0174:
            r13 = 0
        L_0x0175:
            java.lang.String r14 = "display"
            com.baidu.searchbox.feed.biserial.BiSerialStatisticUtilsKt.probingCardStatistics(r14, r13, r1)
            T r13 = r11.element
            com.baidu.searchbox.feed.model.FeedProbingCardModel$FeedProbingItemModel r13 = (com.baidu.searchbox.feed.model.FeedProbingCardModel.FeedProbingItemModel) r13
            r13.setHasDisplay(r9)
        L_0x0181:
            int r1 = r1 + 1
            goto L_0x001c
        L_0x0185:
            r10 = r18
            goto L_0x018a
        L_0x0188:
            r10 = r18
        L_0x018a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.biserial.FeedProbingCardView.updateSelectContainer(com.baidu.searchbox.feed.model.FeedProbingCardModel, com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    public void onFeedNightModeChanged(boolean isNightMode) {
        View view2 = this.root;
        if (view2 != null) {
            FeedBiserialScreenUtil feedBiserialScreenUtil = FeedBiserialScreenUtil.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            view2.setBackground(feedBiserialScreenUtil.getEPStyleItemBg(context));
        }
        FeedBaseModel feedModel = getFeedModel();
        if ((feedModel != null ? feedModel.data : null) instanceof FeedProbingCardModel) {
            FeedItemData feedItemData = getFeedModel().data;
            if (feedItemData != null) {
                FeedProbingCardModel itemData = (FeedProbingCardModel) feedItemData;
                updateTitle(itemData);
                updateSelectContainer(itemData, getFeedModel());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedProbingCardModel");
        }
    }

    public void onFontSizeChanged() {
        TextView textView = this.title;
        if (textView != null) {
            textView.setTextSize(0, FontSizeHelper.getScaledSize(1, ViewExtensionsKt.getDimension(this, com.baidu.searchbox.feed.styles.R.dimen.F_T_X002)));
        }
        TextView textView2 = this.subTitle;
        if (textView2 != null) {
            textView2.setTextSize(0, FontSizeHelper.getScaledSize(1, ViewExtensionsKt.getDimension(this, com.baidu.searchbox.feed.styles.R.dimen.F_T_X301)));
        }
        FeedBaseModel feedModel = getFeedModel();
        if ((feedModel != null ? feedModel.data : null) instanceof FeedProbingCardModel) {
            FeedItemData feedItemData = getFeedModel().data;
            if (feedItemData != null) {
                updateSelectContainer((FeedProbingCardModel) feedItemData, getFeedModel());
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.feed.model.FeedProbingCardModel");
        }
    }
}
