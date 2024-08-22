package com.baidu.searchbox.video.feedflow.detail.banner.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.nadcore.utils.ColorUtils;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.banner.model.BannerCarouselTextModel;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModel;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModelKt;
import com.baidu.searchbox.video.feedflow.detail.banner.view.VideoBaseBannerView;
import com.baidu.searchbox.video.feedflow.view.FlowVideoAlphaTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00100\u001a\u000201H\u0002J\u001a\u00102\u001a\u0002012\b\u00103\u001a\u0004\u0018\u00010\n2\u0006\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000201H\u0002J\b\u00107\u001a\u000201H\u0003J\b\u00108\u001a\u000201H\u0002J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u000201H\u0002J\b\u0010;\u001a\u000201H\u0002J\u0010\u0010<\u001a\u0002052\u0006\u0010=\u001a\u00020>H\u0002J\u0018\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u0007H\u0016J\b\u0010B\u001a\u000201H\u0002J\b\u0010C\u001a\u000201H\u0016J\u001c\u0010D\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010>2\b\b\u0002\u0010E\u001a\u000205H\u0002J\u0010\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020\u0007H\u0002J\u0012\u0010H\u001a\u0002012\b\u0010I\u001a\u0004\u0018\u00010>H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0013\u0010\u000fR\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b\u001f\u0010\u001cR\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010.¨\u0006J"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/banner/view/FlowVideoSingleLineBannerView;", "Lcom/baidu/searchbox/video/feedflow/detail/banner/view/VideoBaseBannerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bannerModel", "Lcom/baidu/searchbox/video/feedflow/detail/banner/model/FlowDetailBannerModel;", "curTitlePosition", "imgBannerIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImgBannerIcon", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "imgBannerIcon$delegate", "Lkotlin/Lazy;", "imgBannerRightArrow", "getImgBannerRightArrow", "imgBannerRightArrow$delegate", "rootImagePaddingLeft", "rootNoImagePaddingLeft", "titleEndTime", "titleStartTime", "tvBannerRightTitle", "Landroid/widget/TextView;", "getTvBannerRightTitle", "()Landroid/widget/TextView;", "tvBannerRightTitle$delegate", "tvBannerSubTitle", "getTvBannerSubTitle", "tvBannerSubTitle$delegate", "tvBannerTitle", "Lcom/baidu/searchbox/video/feedflow/view/FlowVideoAlphaTextView;", "getTvBannerTitle", "()Lcom/baidu/searchbox/video/feedflow/view/FlowVideoAlphaTextView;", "tvBannerTitle$delegate", "viewBannerDivide", "Landroid/view/View;", "getViewBannerDivide", "()Landroid/view/View;", "viewBannerDivide$delegate", "viewRoot", "Lcom/baidu/searchbox/video/feedflow/detail/banner/view/LinearLayoutWithMaxWidth;", "getViewRoot", "()Lcom/baidu/searchbox/video/feedflow/detail/banner/view/LinearLayoutWithMaxWidth;", "viewRoot$delegate", "bindButtonArrowData", "", "bindData", "model", "isLandscape", "", "bindIconData", "bindRightTitleData", "bindSubTitleData", "bindTitleData", "initTvBannerTitleLayoutParams", "initView", "limitTvBannerTitleWidth", "title", "", "onUpdateProgress", "progress", "duration", "resetData", "setFontAndPictureSize", "setTitle", "isAnimator", "upDateRootLayoutPaddingLeft", "paddingLeft", "updateUiStyle", "jumpType", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoSingleLineBannerView.kt */
public final class FlowVideoSingleLineBannerView extends VideoBaseBannerView {
    private FlowDetailBannerModel bannerModel;
    private int curTitlePosition;
    private final Lazy imgBannerIcon$delegate;
    private final Lazy imgBannerRightArrow$delegate;
    private int rootImagePaddingLeft;
    private int rootNoImagePaddingLeft;
    private int titleEndTime;
    private int titleStartTime;
    private final Lazy tvBannerRightTitle$delegate;
    private final Lazy tvBannerSubTitle$delegate;
    private final Lazy tvBannerTitle$delegate;
    private final Lazy viewBannerDivide$delegate;
    private final Lazy viewRoot$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlowVideoSingleLineBannerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlowVideoSingleLineBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowVideoSingleLineBannerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewRoot$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$viewRoot$2(this));
        this.imgBannerIcon$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$imgBannerIcon$2(this));
        this.imgBannerRightArrow$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$imgBannerRightArrow$2(this));
        this.tvBannerTitle$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$tvBannerTitle$2(this));
        this.tvBannerSubTitle$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$tvBannerSubTitle$2(this));
        this.viewBannerDivide$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$viewBannerDivide$2(this));
        this.tvBannerRightTitle$delegate = LazyKt.lazy(new FlowVideoSingleLineBannerView$tvBannerRightTitle$2(this));
        this.titleStartTime = -1;
        this.titleEndTime = -1;
        this.rootImagePaddingLeft = BdPlayerUtils.dp2px(this, 5.0f);
        this.rootNoImagePaddingLeft = BdPlayerUtils.dp2px(this, 7.0f);
        initView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlowVideoSingleLineBannerView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final LinearLayoutWithMaxWidth getViewRoot() {
        Object value = this.viewRoot$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewRoot>(...)");
        return (LinearLayoutWithMaxWidth) value;
    }

    private final SimpleDraweeView getImgBannerIcon() {
        Object value = this.imgBannerIcon$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imgBannerIcon>(...)");
        return (SimpleDraweeView) value;
    }

    private final SimpleDraweeView getImgBannerRightArrow() {
        Object value = this.imgBannerRightArrow$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-imgBannerRightArrow>(...)");
        return (SimpleDraweeView) value;
    }

    private final FlowVideoAlphaTextView getTvBannerTitle() {
        Object value = this.tvBannerTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvBannerTitle>(...)");
        return (FlowVideoAlphaTextView) value;
    }

    private final TextView getTvBannerSubTitle() {
        Object value = this.tvBannerSubTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvBannerSubTitle>(...)");
        return (TextView) value;
    }

    private final View getViewBannerDivide() {
        Object value = this.viewBannerDivide$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewBannerDivide>(...)");
        return (View) value;
    }

    private final TextView getTvBannerRightTitle() {
        Object value = this.tvBannerRightTitle$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tvBannerRightTitle>(...)");
        return (TextView) value;
    }

    private final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.video_flow_banner_goods, this);
    }

    public void setFontAndPictureSize() {
        initTvBannerTitleLayoutParams();
        FontSizeHelperKt.setVideoScaledSizeRes$default(getImgBannerIcon(), R.dimen.video_flow_dimens_17dp, R.dimen.video_flow_dimens_17dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(getTvBannerSubTitle(), R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(getViewBannerDivide(), R.dimen.video_flow_dimens_1dp, R.dimen.video_flow_dimens_9dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(getTvBannerTitle(), R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(getImgBannerRightArrow(), R.dimen.video_flow_dimens_13dp, R.dimen.video_flow_dimens_13dp, 0, 0, 12, (Object) null);
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        if (Intrinsics.areEqual((Object) flowDetailBannerModel != null ? flowDetailBannerModel.getExtendTitleWithoutDot() : null, (Object) "1")) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(getTvBannerRightTitle(), R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
        } else {
            FontSizeHelperKt.setVideoScaledSizeRes$default(getTvBannerRightTitle(), R.dimen.video_flow_dimens_10dp, 0, 0, 6, (Object) null);
        }
        CharSequence text = getTvBannerTitle().getText();
        if (text != null) {
            getTvBannerTitle().setTextNoAnimate(text.toString());
        }
        BannerUtilsKt.processingBannerViewWidth(getViewRoot(), CollectionsKt.mutableListOf(getTvBannerRightTitle(), getTvBannerSubTitle(), getTvBannerTitle()));
    }

    public void bindData(FlowDetailBannerModel model, boolean isLandscape) {
        this.bannerModel = model;
        resetData();
        FlowDetailBannerModel $this$bindData_u24lambda_u2d1 = this.bannerModel;
        if ($this$bindData_u24lambda_u2d1 != null) {
            bindIconData();
            bindSubTitleData();
            bindButtonArrowData();
            bindRightTitleData();
            bindTitleData();
            setFontAndPictureSize();
            updateUiStyle($this$bindData_u24lambda_u2d1.getJumpType());
        }
    }

    private final void updateUiStyle(String jumpType) {
        if (FlowDetailBannerModelKt.isCaiShenType(jumpType)) {
            getTvBannerTitle().setTextColor(getResources().getColor(R.color.video_flow_color_FF1E1F24));
            getViewRoot().setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_banner_translucent_bg));
            return;
        }
        getTvBannerTitle().setTextColor(getResources().getColor(com.baidu.searchbox.feed.styles.R.color.FC410));
        getViewRoot().setBackground(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_banner_bg));
    }

    private final void resetData() {
        int i2;
        if (this.bannerModel == null) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        setVisibility(i2);
        this.titleStartTime = -1;
        this.titleEndTime = -1;
        this.curTitlePosition = 0;
    }

    private final void bindTitleData() {
        String title;
        List<BannerCarouselTextModel> carouselTextList;
        BannerCarouselTextModel bannerCarouselTextModel;
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        if (flowDetailBannerModel == null || (carouselTextList = flowDetailBannerModel.getCarouselTextList()) == null || (bannerCarouselTextModel = (BannerCarouselTextModel) CollectionsKt.firstOrNull(carouselTextList)) == null || (title = bannerCarouselTextModel.getText()) == null) {
            FlowDetailBannerModel flowDetailBannerModel2 = this.bannerModel;
            title = flowDetailBannerModel2 != null ? flowDetailBannerModel2.getTitle() : null;
        }
        boolean z = true;
        if (title == null || !(!StringsKt.isBlank(title))) {
            z = false;
        }
        if (z) {
            setTitle$default(this, title, false, 2, (Object) null);
            getTvBannerTitle().setVisibility(0);
            return;
        }
        getTvBannerTitle().setVisibility(8);
    }

    private final void initTvBannerTitleLayoutParams() {
        ViewGroup.LayoutParams layoutParams = getTvBannerTitle().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = -2;
        }
        if (layoutParams != null) {
            layoutParams.height = -2;
        }
        getTvBannerTitle().setLayoutParams(layoutParams);
        getTvBannerTitle().setMaxTextWidth(Integer.MAX_VALUE);
    }

    private final void bindSubTitleData() {
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        String subTitle = flowDetailBannerModel != null ? flowDetailBannerModel.getSubTitle() : null;
        boolean z = true;
        if (subTitle == null || !(!StringsKt.isBlank(subTitle))) {
            z = false;
        }
        if (z) {
            getTvBannerSubTitle().setText(subTitle);
            getTvBannerSubTitle().setVisibility(0);
            getViewBannerDivide().setVisibility(0);
            return;
        }
        getTvBannerSubTitle().setVisibility(8);
        getViewBannerDivide().setVisibility(8);
    }

    private final void bindRightTitleData() {
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        String str = null;
        String extendTitle = flowDetailBannerModel != null ? flowDetailBannerModel.getExtendTitle() : null;
        if (extendTitle != null && (StringsKt.isBlank(extendTitle) ^ true)) {
            ViewGroup.LayoutParams layoutParams = getTvBannerRightTitle().getLayoutParams();
            ViewGroup.MarginLayoutParams rightTitleParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            FlowDetailBannerModel flowDetailBannerModel2 = this.bannerModel;
            if (Intrinsics.areEqual((Object) flowDetailBannerModel2 != null ? flowDetailBannerModel2.getExtendTitleWithoutDot() : null, (Object) "1")) {
                getTvBannerRightTitle().setText(String.valueOf(extendTitle));
                getTvBannerRightTitle().setTextSize(11.0f);
                if (rightTitleParams != null) {
                    rightTitleParams.leftMargin = BdPlayerUtils.dp2px(this, 5.0f);
                }
            } else {
                getTvBannerRightTitle().setText(" · " + extendTitle);
                if (rightTitleParams != null) {
                    rightTitleParams.leftMargin = BdPlayerUtils.dp2px(this, 0.0f);
                }
            }
            getTvBannerRightTitle().setLayoutParams(rightTitleParams);
            FlowDetailBannerModel flowDetailBannerModel3 = this.bannerModel;
            CharSequence extendTitleTextColor = flowDetailBannerModel3 != null ? flowDetailBannerModel3.getExtendTitleTextColor() : null;
            if (BdPlayerUtils.orFalse(Boolean.valueOf(true ^ (extendTitleTextColor == null || extendTitleTextColor.length() == 0)))) {
                TextView tvBannerRightTitle = getTvBannerRightTitle();
                FlowDetailBannerModel flowDetailBannerModel4 = this.bannerModel;
                if (flowDetailBannerModel4 != null) {
                    str = flowDetailBannerModel4.getExtendTitleTextColor();
                }
                tvBannerRightTitle.setTextColor(ColorUtils.parseColorSafe(str, R.color.video_flow_color_FED8A9));
            }
            getTvBannerRightTitle().setVisibility(0);
            return;
        }
        getTvBannerRightTitle().setVisibility(8);
    }

    private final void bindButtonArrowData() {
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        String str = null;
        CharSequence icon = flowDetailBannerModel != null ? flowDetailBannerModel.getIcon() : null;
        if (icon == null || StringsKt.isBlank(icon)) {
            SimpleDraweeView imgBannerRightArrow = getImgBannerRightArrow();
            FlowDetailBannerModel flowDetailBannerModel2 = this.bannerModel;
            if (flowDetailBannerModel2 != null) {
                str = flowDetailBannerModel2.getButtonIcon();
            }
            BannerUtilsKt.setBannerImageView(imgBannerRightArrow, str);
            return;
        }
        getImgBannerRightArrow().setVisibility(8);
    }

    private final void bindIconData() {
        SimpleDraweeView imgBannerIcon = getImgBannerIcon();
        FlowDetailBannerModel flowDetailBannerModel = this.bannerModel;
        String str = null;
        String icon = flowDetailBannerModel != null ? flowDetailBannerModel.getIcon() : null;
        FlowDetailBannerModel flowDetailBannerModel2 = this.bannerModel;
        boolean z = true;
        BannerUtilsKt.setBannerImageViewWithShape(imgBannerIcon, icon, flowDetailBannerModel2 != null && flowDetailBannerModel2.isIconCircle());
        FlowDetailBannerModel flowDetailBannerModel3 = this.bannerModel;
        if (flowDetailBannerModel3 != null) {
            str = flowDetailBannerModel3.getIcon();
        }
        CharSequence charSequence = str;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            z = false;
        }
        if (z) {
            upDateRootLayoutPaddingLeft(this.rootNoImagePaddingLeft);
        } else {
            upDateRootLayoutPaddingLeft(this.rootImagePaddingLeft);
        }
    }

    private final void upDateRootLayoutPaddingLeft(int paddingLeft) {
        getViewRoot().setLayoutParams(getLayoutParams());
        getViewRoot().setPadding(paddingLeft, getViewRoot().getPaddingTop(), getViewRoot().getPaddingRight(), getViewRoot().getPaddingBottom());
    }

    public void onUpdateProgress(int progress, int duration) {
        FlowDetailBannerModel flowDetailBannerModel;
        FlowDetailBannerModel flowDetailBannerModel2;
        List $this$onUpdateProgress_u24lambda_u2d2;
        int curEndTime;
        if (!(progress <= this.titleEndTime && this.titleStartTime <= progress) && (flowDetailBannerModel = this.bannerModel) != null && flowDetailBannerModel.getCarouselTextList() != null && (flowDetailBannerModel2 = this.bannerModel) != null && ($this$onUpdateProgress_u24lambda_u2d2 = flowDetailBannerModel2.getCarouselTextList()) != null) {
            int index = 0;
            int size = $this$onUpdateProgress_u24lambda_u2d2.size();
            while (index < size) {
                BannerCarouselTextModel carouselTextModel = $this$onUpdateProgress_u24lambda_u2d2.get(index);
                int curStartTime = index == 0 ? 0 : carouselTextModel.getStartTime();
                if (index < $this$onUpdateProgress_u24lambda_u2d2.size() - 1) {
                    curEndTime = $this$onUpdateProgress_u24lambda_u2d2.get(index + 1).getStartTime() - 1;
                } else {
                    curEndTime = Integer.MAX_VALUE;
                }
                if (!(curStartTime <= progress && progress <= curEndTime) || !setTitle(carouselTextModel.getText(), true)) {
                    index++;
                } else {
                    this.titleStartTime = curStartTime;
                    this.titleEndTime = curEndTime;
                    this.curTitlePosition = index;
                    return;
                }
            }
        }
    }

    static /* synthetic */ boolean setTitle$default(FlowVideoSingleLineBannerView flowVideoSingleLineBannerView, String str, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return flowVideoSingleLineBannerView.setTitle(str, z);
    }

    private final boolean setTitle(String title, boolean isAnimator) {
        CharSequence oldTitle = getTvBannerTitle().getText();
        if (TextUtils.equals(title, oldTitle)) {
            return true;
        }
        String str = null;
        String str2 = "";
        if (isAnimator) {
            String obj = oldTitle != null ? oldTitle.toString() : null;
            if (obj == null) {
                obj = str2;
            }
            if (!limitTvBannerTitleWidth(obj)) {
                return false;
            }
        }
        if (isAnimator) {
            FlowVideoAlphaTextView tvBannerTitle = getTvBannerTitle();
            if (title != null) {
                str2 = title;
            }
            tvBannerTitle.setTextWithAnimate(str2);
        } else {
            FlowVideoAlphaTextView tvBannerTitle2 = getTvBannerTitle();
            if (title != null) {
                str2 = title;
            }
            tvBannerTitle2.setTextNoAnimate(str2);
        }
        VideoBaseBannerView.OnTitleChangedBannerListener onTitleChangedBannerListener = getOnTitleChangedBannerListener();
        if (onTitleChangedBannerListener != null) {
            int i2 = this.curTitlePosition;
            if (oldTitle != null) {
                str = oldTitle.toString();
            }
            onTitleChangedBannerListener.onTitleChanged(i2, title, str);
        }
        return true;
    }

    private final boolean limitTvBannerTitleWidth(String title) {
        int maxTextViewWidth;
        getTvBannerTitle().setMaxTextWidth(Integer.MAX_VALUE);
        boolean result = true;
        if (getTvBannerTitle().getWidth() > 0) {
            BannerUtilsKt.viewUnspecifiedMeasure(getViewRoot());
            if (getViewRoot().getAllowedMaxWidth() < getViewRoot().getMeasuredWidth()) {
                result = false;
            } else {
                int textEllipsisStart = getTvBannerTitle().getLayout().getEllipsisStart(0);
                if (textEllipsisStart <= 0 || textEllipsisStart >= getTvBannerTitle().getText().length()) {
                    maxTextViewWidth = getViewRoot().getAllowedMaxWidth() - (getViewRoot().getWidth() - getTvBannerTitle().getWidth());
                } else {
                    maxTextViewWidth = getTvBannerTitle().getWidth();
                }
                getTvBannerTitle().setMaxTextWidth(maxTextViewWidth);
            }
            return result;
        }
        if (title.length() != 0) {
            result = false;
        }
        if (result) {
            return true;
        }
        return false;
    }
}
