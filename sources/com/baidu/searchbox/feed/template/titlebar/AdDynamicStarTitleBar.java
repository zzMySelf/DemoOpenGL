package com.baidu.searchbox.feed.template.titlebar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.feed.ad.Als;
import com.baidu.searchbox.feed.ad.model.AdExt;
import com.baidu.searchbox.feed.ad.model.AdModuleData;
import com.baidu.searchbox.feed.ad.util.FeedAdUtil;
import com.baidu.searchbox.feed.availability.image.FeedDraweeCallerContext;
import com.baidu.searchbox.feed.controller.FeedDataReportUtils;
import com.baidu.searchbox.feed.flow.util.AdjustableImageView;
import com.baidu.searchbox.feed.flow.util.AdjustableTextView;
import com.baidu.searchbox.feed.flow.util.FontAdjustment;
import com.baidu.searchbox.feed.model.FeedAdData;
import com.baidu.searchbox.feed.model.FeedAdSponsorInfo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemData;
import com.baidu.searchbox.feed.net.ADRequester;
import com.baidu.searchbox.feed.net.ParallelCharge;
import com.baidu.searchbox.feed.parser.FeedFilter;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.template.FeedFollowButtonView;
import com.baidu.searchbox.feed.template.FeedRelativeLayout;
import com.baidu.searchbox.feed.template.FeedStarFollowButtonView;
import com.baidu.searchbox.feed.template.R;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.resources.util.CtxResEasyUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.UnifyTextView;
import com.baidu.searchbox.widget.toucharea.ExpandTouchAreaHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0012H\u0002J\b\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0016J\u0018\u0010=\u001a\u0002092\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0002J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020+H\u0016J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\u0012\u0010G\u001a\u0002092\b\u0010H\u001a\u0004\u0018\u00010+H\u0016J \u0010I\u001a\u0002092\u0006\u0010B\u001a\u00020C2\u0006\u0010@\u001a\u00020?2\u0006\u0010J\u001a\u00020?H\u0002J\b\u0010K\u001a\u000209H\u0002J\u0012\u0010L\u001a\u0002092\b\u0010M\u001a\u0004\u0018\u000103H\u0016J\u0012\u0010N\u001a\u0002092\b\u0010M\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010O\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010P\u001a\u000209H\u0002J\u0012\u0010Q\u001a\u0002092\b\u0010B\u001a\u0004\u0018\u00010CH\u0002R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0010\u001a\u0004\b\"\u0010#R\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0010\u001a\u0004\b'\u0010(R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\u0010\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b1\u0010\u0010\u001a\u0004\b0\u0010\u0019R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b6\u0010\u0010\u001a\u0004\b5\u0010-R\u0010\u00107\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/baidu/searchbox/feed/template/titlebar/AdDynamicStarTitleBar;", "Lcom/baidu/searchbox/feed/template/FeedRelativeLayout;", "Lcom/baidu/searchbox/feed/template/titlebar/IAdStarTitleBar;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adTag", "Lcom/baidu/searchbox/ui/UnifyTextView;", "getAdTag", "()Lcom/baidu/searchbox/ui/UnifyTextView;", "adTag$delegate", "Lkotlin/Lazy;", "btnCommand", "Landroid/widget/TextView;", "getBtnCommand", "()Landroid/widget/TextView;", "btnCommand$delegate", "dislikeView", "Lcom/baidu/searchbox/feed/flow/util/AdjustableImageView;", "getDislikeView", "()Lcom/baidu/searchbox/feed/flow/util/AdjustableImageView;", "dislikeView$delegate", "feedStarFollowContainer", "Lcom/baidu/searchbox/feed/template/FeedFollowButtonView;", "getFeedStarFollowContainer", "()Lcom/baidu/searchbox/feed/template/FeedFollowButtonView;", "feedStarFollowContainer$delegate", "feedStarNameTxtView", "Lcom/baidu/searchbox/feed/flow/util/AdjustableTextView;", "getFeedStarNameTxtView", "()Lcom/baidu/searchbox/feed/flow/util/AdjustableTextView;", "feedStarNameTxtView$delegate", "feedStarProfileImgView", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "getFeedStarProfileImgView", "()Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "feedStarProfileImgView$delegate", "feedStarProfileView", "Landroid/view/View;", "getFeedStarProfileView", "()Landroid/view/View;", "feedStarProfileView$delegate", "feedStarVType", "getFeedStarVType", "feedStarVType$delegate", "followClickListener", "Lcom/baidu/searchbox/feed/template/FeedStarFollowButtonView$OnViewClickListener;", "mainView", "getMainView", "mainView$delegate", "tplListener", "adjustButtonRadius", "", "button", "applyCommandBtnFontSize", "applyFontSize", "clickAdSponsorEvent", "cmd", "", "area", "followAlsLog", "model", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "getView", "init", "initFollowListener", "onClick", "v", "sendAlsLog", "daPage", "setFollowButtonVisibility", "setFollowClickListener", "listener", "setTplClickListener", "update", "updateAvatar", "updateCommandBtn", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AdDynamicStarTitleBar.kt */
public final class AdDynamicStarTitleBar extends FeedRelativeLayout implements IAdStarTitleBar, View.OnClickListener {
    private final Lazy adTag$delegate;
    private final Lazy btnCommand$delegate;
    private final Lazy dislikeView$delegate;
    private final Lazy feedStarFollowContainer$delegate;
    private final Lazy feedStarNameTxtView$delegate;
    private final Lazy feedStarProfileImgView$delegate;
    private final Lazy feedStarProfileView$delegate;
    private final Lazy feedStarVType$delegate;
    private FeedStarFollowButtonView.OnViewClickListener followClickListener;
    private final Lazy mainView$delegate;
    private View.OnClickListener tplListener;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdDynamicStarTitleBar(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AdDynamicStarTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdDynamicStarTitleBar(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdDynamicStarTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainView$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$mainView$2(context, this));
        this.feedStarProfileImgView$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$feedStarProfileImgView$2(this));
        this.feedStarFollowContainer$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$feedStarFollowContainer$2(this));
        this.feedStarNameTxtView$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$feedStarNameTxtView$2(this));
        this.feedStarVType$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$feedStarVType$2(this));
        this.dislikeView$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$dislikeView$2(this));
        this.adTag$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$adTag$2(this));
        this.feedStarProfileView$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$feedStarProfileView$2(this));
        this.btnCommand$delegate = LazyKt.lazy(new AdDynamicStarTitleBar$btnCommand$2(this));
        init();
    }

    /* access modifiers changed from: private */
    public final View getMainView() {
        Object value = this.mainView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mainView>(...)");
        return (View) value;
    }

    private final FeedDraweeView getFeedStarProfileImgView() {
        Object value = this.feedStarProfileImgView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedStarProfileImgView>(...)");
        return (FeedDraweeView) value;
    }

    /* access modifiers changed from: private */
    public final FeedFollowButtonView getFeedStarFollowContainer() {
        Object value = this.feedStarFollowContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedStarFollowContainer>(...)");
        return (FeedFollowButtonView) value;
    }

    private final AdjustableTextView getFeedStarNameTxtView() {
        Object value = this.feedStarNameTxtView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedStarNameTxtView>(...)");
        return (AdjustableTextView) value;
    }

    private final AdjustableImageView getFeedStarVType() {
        Object value = this.feedStarVType$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedStarVType>(...)");
        return (AdjustableImageView) value;
    }

    private final AdjustableImageView getDislikeView() {
        Object value = this.dislikeView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dislikeView>(...)");
        return (AdjustableImageView) value;
    }

    private final UnifyTextView getAdTag() {
        Object value = this.adTag$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-adTag>(...)");
        return (UnifyTextView) value;
    }

    private final View getFeedStarProfileView() {
        Object value = this.feedStarProfileView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-feedStarProfileView>(...)");
        return (View) value;
    }

    private final TextView getBtnCommand() {
        Object value = this.btnCommand$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-btnCommand>(...)");
        return (TextView) value;
    }

    private final void init() {
        getFeedStarNameTxtView().getPaint().setFakeBoldText(true);
        ExpandTouchAreaHelper.expandTouchArea(getFeedStarProfileView(), getDislikeView(), (int) CtxResEasyUtils.dp2px((float) 11), (int) CtxResEasyUtils.dp2px((float) 5), 0, (int) CtxResEasyUtils.dp2px((float) 5));
        initFollowListener();
        getFeedStarProfileImgView().setOnClickListener(this);
        getFeedStarNameTxtView().setOnClickListener(this);
        getDislikeView().setOnClickListener(new AdDynamicStarTitleBar$$ExternalSyntheticLambda0(this));
        ViewExtensionsKt.addPressedState$default(getDislikeView(), 0.0f, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-0  reason: not valid java name */
    public static final void m19591init$lambda0(AdDynamicStarTitleBar this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.tplListener;
        if (onClickListener != null) {
            onClickListener.onClick(it);
        }
    }

    private final void initFollowListener() {
        getFeedStarFollowContainer().setFollowButtonClickCallback(new AdDynamicStarTitleBar$initFollowListener$1(this));
    }

    public void setFollowClickListener(FeedStarFollowButtonView.OnViewClickListener listener) {
        this.followClickListener = listener;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = r9.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(com.baidu.searchbox.feed.model.FeedBaseModel r9) {
        /*
            r8 = this;
            boolean r0 = com.baidu.searchbox.feed.ad.util.FeedAdUtil.checkFeedAdDataValid(r9)
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            if (r9 == 0) goto L_0x0011
            com.baidu.searchbox.feed.model.FeedItemData r1 = r9.data
            if (r1 == 0) goto L_0x0011
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0012
        L_0x0011:
            r1 = r0
        L_0x0012:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            if (r1 == 0) goto L_0x001c
            com.baidu.searchbox.feed.model.FeedAdData r0 = r1.feed
        L_0x001c:
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            android.view.View r1 = r8.getMainView()
            r1.setTag(r9)
            android.view.View r1 = r8.getFeedStarProfileView()
            com.baidu.searchbox.feed.model.FeedAdSponsorInfo$FeedAdSponsorTitleProfile r2 = r0.userArea
            r1.setTag(r2)
            com.baidu.searchbox.feed.template.FeedFollowButtonView r1 = r8.getFeedStarFollowContainer()
            com.baidu.searchbox.feed.model.FeedItemData$AdditionalInfo r2 = r0.followInfo
            r1.setTag(r2)
            r8.updateAvatar()
            r8.setFollowButtonVisibility()
            com.baidu.searchbox.feed.flow.util.AdjustableImageView r1 = r8.getDislikeView()
            r2 = r1
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r3 = 0
            r1 = r8
            android.view.View r1 = (android.view.View) r1
            int r4 = com.baidu.searchbox.feed.template.R.drawable.feed_dynamic_unlike_btn_icon
            android.graphics.drawable.Drawable r1 = com.baidu.searchbox.kotlinx.ViewExtensionsKt.getDrawable(r1, r4)
            android.graphics.drawable.Drawable r4 = r1.mutate()
            r5 = 0
            r6 = 4
            r7 = 0
            com.baidu.searchbox.config.ext.FontSizeImageViewExtKt.setScaledImageDrawable$default(r2, r3, r4, r5, r6, r7)
            com.baidu.searchbox.ui.UnifyTextView r1 = r8.getAdTag()
            android.content.Context r2 = r8.getContext()
            int r3 = com.baidu.searchbox.feed.styles.R.color.FC125
            int r2 = androidx.core.content.ContextCompat.getColor(r2, r3)
            r1.setTextColor(r2)
            com.baidu.searchbox.ui.UnifyTextView r1 = r8.getAdTag()
            boolean r2 = com.baidu.searchbox.feed.ad.util.FeedAdUtil.hitBarBtnMoveUp(r9)
            if (r2 == 0) goto L_0x0077
            r2 = 8
            goto L_0x0078
        L_0x0077:
            r2 = 0
        L_0x0078:
            r1.setVisibility(r2)
            r8.updateCommandBtn(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.titlebar.AdDynamicStarTitleBar.update(com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = r8.data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateCommandBtn(com.baidu.searchbox.feed.model.FeedBaseModel r8) {
        /*
            r7 = this;
            android.widget.TextView r0 = r7.getBtnCommand()
            r1 = 8
            r0.setVisibility(r1)
            r0 = 0
            if (r8 == 0) goto L_0x0013
            com.baidu.searchbox.feed.model.FeedItemData r1 = r8.data
            if (r1 == 0) goto L_0x0013
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0014
        L_0x0013:
            r1 = r0
        L_0x0014:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r1 = r0
        L_0x001a:
            if (r1 == 0) goto L_0x001f
            com.baidu.searchbox.feed.model.FeedAdData r1 = r1.feed
            goto L_0x0020
        L_0x001f:
            r1 = r0
        L_0x0020:
            if (r1 != 0) goto L_0x0023
            return
        L_0x0023:
            com.baidu.searchbox.feed.model.FeedItemData r2 = r8.data
            if (r2 == 0) goto L_0x002a
            com.baidu.searchbox.feed.ad.model.AdModuleData r2 = r2.ad
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r3 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r2 = r0
        L_0x0031:
            if (r2 == 0) goto L_0x0035
            com.baidu.searchbox.ad.model.FeedAdOperate r0 = r2.operate
        L_0x0035:
            if (r0 != 0) goto L_0x0038
            return
        L_0x0038:
            com.baidu.searchbox.ad.model.FeedAdOperate$Button r2 = r0.button
            java.lang.String r3 = "operate.button"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.baidu.searchbox.ad.model.FeedAdOperate$Button r3 = r0.button
            if (r3 == 0) goto L_0x00bc
            com.baidu.searchbox.ad.model.FeedAdOperate$Button r3 = r0.button
            java.lang.String r3 = r3.text
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0051
            goto L_0x00bc
        L_0x0051:
            boolean r3 = com.baidu.searchbox.feed.ad.util.FeedAdUtil.checkUgcMoveUpBtnShow(r8)
            if (r3 != 0) goto L_0x0058
            return
        L_0x0058:
            android.widget.TextView r3 = r7.getBtnCommand()
            android.content.Context r4 = r7.getContext()
            int r5 = com.baidu.android.common.ui.style.R.color.GC68
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            r3.setTextColor(r4)
            android.widget.TextView r3 = r7.getBtnCommand()
            android.view.View r3 = (android.view.View) r3
            int r4 = com.baidu.searchbox.feed.core.R.drawable.feed_ad_progress_button_bg
            com.baidu.searchbox.kotlinx.ViewExtensionsKt.setBackgroundRes(r3, r4)
            android.widget.TextView r3 = r7.getBtnCommand()
            java.lang.String r4 = r2.text
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            com.baidu.searchbox.ad.model.FeedAdOperate$Button r3 = r0.button
            java.lang.String r3 = r3.cmd
            java.lang.String r4 = "operate.button.cmd"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00bb
            android.widget.TextView r4 = r7.getBtnCommand()
            r5 = 0
            r4.setVisibility(r5)
            com.baidu.searchbox.feed.ad.Als$Area r4 = com.baidu.searchbox.feed.ad.Als.Area.UGC_MOVE_UP_BUTTON
            java.lang.String r4 = r4.value
            java.lang.String r5 = "UGC_MOVE_UP_BUTTON.value"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.baidu.searchbox.feed.ad.Als$LogType r5 = com.baidu.searchbox.feed.ad.Als.LogType.FREE_SHOW
            java.lang.String r5 = r5.type
            java.lang.String r6 = "FREE_SHOW.type"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r7.sendAlsLog(r8, r4, r5)
            android.widget.TextView r4 = r7.getBtnCommand()
            com.baidu.searchbox.feed.template.titlebar.AdDynamicStarTitleBar$$ExternalSyntheticLambda1 r5 = new com.baidu.searchbox.feed.template.titlebar.AdDynamicStarTitleBar$$ExternalSyntheticLambda1
            r5.<init>(r1, r7, r8, r3)
            r4.setOnClickListener(r5)
        L_0x00bb:
            return
        L_0x00bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.titlebar.AdDynamicStarTitleBar.updateCommandBtn(com.baidu.searchbox.feed.model.FeedBaseModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: updateCommandBtn$lambda-1  reason: not valid java name */
    public static final void m19592updateCommandBtn$lambda1(FeedAdData $feed, AdDynamicStarTitleBar this$0, FeedBaseModel $model, String $cmd, View it) {
        Intrinsics.checkNotNullParameter($feed, "$feed");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($cmd, "$cmd");
        ParallelCharge.chargeSub($feed);
        ADRequester.adThirdPartyMonitor($feed.mExtData, Als.ADActionType.CLICK);
        String str = Als.Area.UGC_MOVE_UP_BUTTON.value;
        Intrinsics.checkNotNullExpressionValue(str, "UGC_MOVE_UP_BUTTON.value");
        String str2 = Als.LogType.CLICK.type;
        Intrinsics.checkNotNullExpressionValue(str2, "CLICK.type");
        this$0.sendAlsLog($model, str, str2);
        FeedDataReportUtils.reportAdClick($model);
        FeedAdUtil.feedAdInvokeCommand($model, this$0.getContext(), $cmd);
    }

    private final void updateAvatar() {
        RoundingParams roundingParams;
        Object tag = getFeedStarProfileView().getTag();
        String str = null;
        FeedAdSponsorInfo.FeedAdSponsorTitleProfile userAreaInfo = tag instanceof FeedAdSponsorInfo.FeedAdSponsorTitleProfile ? (FeedAdSponsorInfo.FeedAdSponsorTitleProfile) tag : null;
        if (userAreaInfo != null) {
            boolean z = false;
            getFeedStarProfileImgView().setVisibility(0);
            Object tag2 = getMainView().getTag();
            Object obj = FeedDraweeCallerContext.getTemplateAuthorCallerContext(tag2 instanceof FeedBaseModel ? (FeedBaseModel) tag2 : null);
            FeedDraweeView asHeadCircle = getFeedStarProfileImgView().asHeadCircle();
            String str2 = userAreaInfo.photo;
            Object tag3 = getMainView().getTag();
            asHeadCircle.loadImage(str2, tag3 instanceof FeedBaseModel ? (FeedBaseModel) tag3 : null, obj);
            int width = FontAdjustment.getScaledFrameworkSize(ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.feed_dynamic_star_bar_img_size));
            ViewExtensionsKt.setSize(getFeedStarProfileImgView(), width, width);
            if (NightModeHelper.isNightMode() && (roundingParams = ((GenericDraweeHierarchy) getFeedStarProfileImgView().getHierarchy()).getRoundingParams()) != null) {
                roundingParams.setBorder(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC56), 1.0f);
            }
            if (userAreaInfo.vUrl.length() > 0) {
                getFeedStarVType().setVisibility(0);
                getFeedStarVType().setImageURI(userAreaInfo.vUrl);
            } else {
                getFeedStarVType().setVisibility(8);
            }
            FeedAdSponsorInfo.FeedAdSponsorUserName feedAdSponsorUserName = userAreaInfo.userName;
            if (feedAdSponsorUserName != null && feedAdSponsorUserName.checkUserNameVaild()) {
                z = true;
            }
            if (z) {
                AdjustableTextView feedStarNameTxtView = getFeedStarNameTxtView();
                FeedAdSponsorInfo.FeedAdSponsorUserName feedAdSponsorUserName2 = userAreaInfo.userName;
                if (feedAdSponsorUserName2 != null) {
                    str = feedAdSponsorUserName2.text;
                }
                feedStarNameTxtView.setTextWithUnifiedPadding(str, TextView.BufferType.NORMAL);
                getFeedStarNameTxtView().setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
                return;
            }
            getFeedStarNameTxtView().setTextWithUnifiedPadding("", TextView.BufferType.NORMAL);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.baidu.searchbox.feed.model.FeedAdSponsorInfo$FeedAdSponsorTitleProfile} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.getMainView()
            java.lang.Object r0 = r0.getTag()
            boolean r1 = r0 instanceof com.baidu.searchbox.feed.model.FeedBaseModel
            r2 = 0
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedBaseModel r0 = (com.baidu.searchbox.feed.model.FeedBaseModel) r0
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            android.view.View r1 = r5.getFeedStarProfileView()
            java.lang.Object r1 = r1.getTag()
            boolean r3 = r1 instanceof com.baidu.searchbox.feed.model.FeedAdSponsorInfo.FeedAdSponsorTitleProfile
            if (r3 == 0) goto L_0x0023
            r2 = r1
            com.baidu.searchbox.feed.model.FeedAdSponsorInfo$FeedAdSponsorTitleProfile r2 = (com.baidu.searchbox.feed.model.FeedAdSponsorInfo.FeedAdSponsorTitleProfile) r2
        L_0x0023:
            if (r2 != 0) goto L_0x0026
            return
        L_0x0026:
            r1 = r2
            com.baidu.searchbox.feed.model.FeedItemData r2 = r0.data
            if (r2 == 0) goto L_0x003b
            java.lang.String r2 = r1.cmd
            java.lang.String r2 = com.baidu.searchbox.feed.ad.util.AdDataReduceUtils.replaceVideoCmd(r0, r2)
            java.lang.String r3 = "avatar"
            java.lang.String r4 = "cmd"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r5.clickAdSponsorEvent(r2, r3)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.titlebar.AdDynamicStarTitleBar.onClick(android.view.View):void");
    }

    private final void clickAdSponsorEvent(String cmd, String area) {
        Object tag = getMainView().getTag();
        FeedAdData feedAdData = null;
        FeedBaseModel model = tag instanceof FeedBaseModel ? (FeedBaseModel) tag : null;
        if (model != null && FeedAdUtil.checkFeedAdDataValid(model)) {
            FeedItemData feedItemData = model.data;
            AdModuleData adModuleData = feedItemData != null ? feedItemData.ad : null;
            if (!(adModuleData instanceof AdModuleData)) {
                adModuleData = null;
            }
            if (adModuleData != null) {
                feedAdData = adModuleData.feed;
            }
            if (feedAdData != null) {
                FeedAdData feed = feedAdData;
                String str = Als.LogType.CLICK.type;
                Intrinsics.checkNotNullExpressionValue(str, "CLICK.type");
                sendAlsLog(model, area, str);
                ParallelCharge.chargeSub(feed);
                if (feed.mExtData != null) {
                    ADRequester.adThirdPartyMonitor(feed.mExtData, Als.ADActionType.CLICK);
                }
                FeedAdUtil.feedAdInvokeCommand(model, getContext(), cmd);
            }
        }
    }

    private final void sendAlsLog(FeedBaseModel model, String area, String daPage) {
        if (FeedFilter.checkAdFeed(model)) {
            Als.Builder builder = new Als.Builder();
            builder.setType(daPage);
            if (FeedAdUtil.checkModelDataExtValid(model)) {
                AdModuleData adModuleData = model.data.ad;
                AdExt adExt = null;
                if (!(adModuleData instanceof AdModuleData)) {
                    adModuleData = null;
                }
                if (adModuleData != null) {
                    adExt = adModuleData.ext;
                }
                builder.setSboxExtraParam(adExt);
            }
            builder.setArea(area);
            builder.setPage(Als.Page.PAGE_SEARCHBOX);
            Als.postADRealTimeLog(builder);
        }
    }

    /* access modifiers changed from: private */
    public final void followAlsLog(FeedBaseModel model) {
        if (FeedFilter.checkAdFeed(model)) {
            Als.Builder builder = new Als.Builder();
            builder.setType(Als.LogType.INTERACTION_FOLLOW);
            AdModuleData adModuleData = model.data.ad;
            String str = null;
            if (!(adModuleData instanceof AdModuleData)) {
                adModuleData = null;
            }
            builder.setSboxExtraParam(adModuleData != null ? adModuleData.ext : null);
            builder.setArea(Als.Area.FOLLOW_BUTTON);
            builder.setPage(Als.Page.PAGE_SEARCHBOX);
            Object tag = getFeedStarFollowContainer().getTag();
            FeedItemData.AdditionalInfo additionalInfo = tag instanceof FeedItemData.AdditionalInfo ? (FeedItemData.AdditionalInfo) tag : null;
            if (additionalInfo != null) {
                str = additionalInfo.type;
            }
            builder.setExt1(str);
            Als.postADRealTimeLog(builder);
        }
    }

    private final void setFollowButtonVisibility() {
        if (getFeedStarFollowContainer() != null) {
            Object tag = getMainView().getTag();
            FeedItemData.AdditionalInfo.FollowButton followButton = null;
            FeedBaseModel model = tag instanceof FeedBaseModel ? (FeedBaseModel) tag : null;
            if (model != null) {
                Object tag2 = getFeedStarFollowContainer().getTag();
                FeedItemData.AdditionalInfo followInfo = tag2 instanceof FeedItemData.AdditionalInfo ? (FeedItemData.AdditionalInfo) tag2 : null;
                if (followInfo != null) {
                    followButton = followInfo.button;
                }
                if (followButton == null) {
                    getFeedStarFollowContainer().setVisibility(8);
                    return;
                }
                getFeedStarFollowContainer().setVisibility(0);
                getFeedStarFollowContainer().bringToFront();
                getFeedStarFollowContainer().update(model, getContext(), followInfo);
            }
        }
    }

    public void applyFontSize() {
        FontSizeTextViewExtKt.setScaledSizeRes$default(getAdTag(), 0, com.baidu.searchbox.feed.styles.R.dimen.F_T_X033, 0, 4, (Object) null);
        applyCommandBtnFontSize();
    }

    private final void applyCommandBtnFontSize() {
        getBtnCommand().setTextSize(0, (float) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X041), 2));
        ViewGroup.LayoutParams params = getBtnCommand().getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(params, "btnCommand.layoutParams");
        params.height = (int) FontSizeHelper.getScaledSizeRes(0, com.baidu.searchbox.feed.styles.R.dimen.F_H_X07);
        getBtnCommand().setLayoutParams(params);
        adjustButtonRadius(getBtnCommand());
    }

    private final void adjustButtonRadius(TextView button) {
        if (button.getBackground() instanceof GradientDrawable) {
            float radius = FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_J_X06));
            Drawable background = button.getBackground();
            if (background != null) {
                ((GradientDrawable) background).setCornerRadius(radius);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public void setTplClickListener(View.OnClickListener listener) {
        this.tplListener = listener;
    }

    public View getView() {
        return getMainView();
    }
}
