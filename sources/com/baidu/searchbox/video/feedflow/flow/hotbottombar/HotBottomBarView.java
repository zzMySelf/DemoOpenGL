package com.baidu.searchbox.video.feedflow.flow.hotbottombar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.searchbox.fluency.utils.CommonUtilsKt;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.detail.utils.ReClickUtilKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.flow.bottom.utils.TopBackUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.PanelButtonModel;
import com.baidu.searchbox.video.widget.textswitcher.TextSwitchModel;
import com.baidu.searchbox.video.widget.textswitcher.TextSwitchView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f*\u0001$\u0018\u00002\u00020\u00012\u00020\u0002:\u00013B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010'\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u000fJ\u0010\u0010)\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\u0015H\u0016J\b\u0010,\u001a\u00020(H\u0002J\u0006\u0010-\u001a\u00020(J\u0006\u0010.\u001a\u00020(J\u000e\u0010/\u001a\u00020(2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u00100\u001a\u00020(H\u0002J\b\u00101\u001a\u00020(H\u0002J\u0010\u00102\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0004¢\u0006\u0004\n\u0002\u0010%R\u000e\u0010&\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "backContainer", "Landroid/widget/FrameLayout;", "backView", "Landroid/widget/ImageView;", "buttonModel", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/PanelButtonModel;", "carouselTitleView", "Lcom/baidu/searchbox/video/widget/textswitcher/TextSwitchView;", "hotChallengeButtonContainer", "hotChallengeButtonText", "hotChallengeLine", "Landroid/view/View;", "hotChallengeNextContainer", "hotChallengeNextIcon", "hotInfoContainer", "hotListCategory", "Lcom/facebook/drawee/view/SimpleDraweeView;", "listener", "Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarView$HotBottomBarListener;", "model", "Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarModel;", "nextHotContainer", "nextHotIcon", "titleCarouselHandler", "Landroid/os/Handler;", "titleCarouselRunnable", "com/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarView$titleCarouselRunnable$1", "Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarView$titleCarouselRunnable$1;", "upArrow", "bindButtonData", "", "bindData", "onClick", "v", "onHotChallengeButtonClick", "release", "setFontAndPictureSize", "setHotBottomBarListener", "startCarouselTitle", "stopCarouselTitle", "updateHotBottomLayout", "HotBottomBarListener", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotBottomBarView.kt */
public final class HotBottomBarView extends LinearLayout implements View.OnClickListener {
    private final FrameLayout backContainer;
    private final ImageView backView;
    private PanelButtonModel buttonModel;
    /* access modifiers changed from: private */
    public TextSwitchView carouselTitleView;
    private FrameLayout hotChallengeButtonContainer;
    private TextSwitchView hotChallengeButtonText;
    private final View hotChallengeLine;
    private final LinearLayout hotChallengeNextContainer;
    private final ImageView hotChallengeNextIcon;
    private final LinearLayout hotInfoContainer;
    private final SimpleDraweeView hotListCategory;
    /* access modifiers changed from: private */
    public HotBottomBarListener listener;
    /* access modifiers changed from: private */
    public HotBottomBarModel model;
    private final LinearLayout nextHotContainer;
    private final ImageView nextHotIcon;
    /* access modifiers changed from: private */
    public final Handler titleCarouselHandler;
    private final HotBottomBarView$titleCarouselRunnable$1 titleCarouselRunnable;
    private final ImageView upArrow;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarView$HotBottomBarListener;", "", "onBackClick", "", "onChallengeButtonClick", "model", "Lcom/baidu/searchbox/video/feedflow/flow/hotbottombar/HotBottomBarModel;", "buttonModel", "Lcom/baidu/searchbox/video/feedflow/flow/comonlistpanel/PanelButtonModel;", "onChallengeButtonShow", "onHotInfoClick", "onNextHotClick", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HotBottomBarView.kt */
    public interface HotBottomBarListener {
        void onBackClick();

        void onChallengeButtonClick(HotBottomBarModel hotBottomBarModel, PanelButtonModel panelButtonModel);

        void onChallengeButtonShow(HotBottomBarModel hotBottomBarModel);

        void onHotInfoClick(HotBottomBarModel hotBottomBarModel);

        void onNextHotClick(HotBottomBarModel hotBottomBarModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HotBottomBarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HotBottomBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HotBottomBarView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotBottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleCarouselHandler = new Handler(Looper.getMainLooper());
        this.titleCarouselRunnable = new HotBottomBarView$titleCarouselRunnable$1(this);
        View.inflate(context, R.layout.video_flow_hot_bottom_bar_layout, this);
        setOrientation(0);
        setGravity(16);
        View findViewById = findViewById(R.id.back_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.back_container)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        this.backContainer = frameLayout;
        View findViewById2 = findViewById(R.id.back_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.back_icon)");
        this.backView = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.hot_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hot_info_container)");
        LinearLayout linearLayout = (LinearLayout) findViewById3;
        this.hotInfoContainer = linearLayout;
        View findViewById4 = findViewById(R.id.hot_list_category);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hot_list_category)");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById4;
        this.hotListCategory = simpleDraweeView;
        View findViewById5 = findViewById(R.id.up_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.up_arrow)");
        this.upArrow = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.next_hot_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.next_hot_icon)");
        this.nextHotIcon = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.text_switch_view);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.text_switch_view)");
        this.carouselTitleView = (TextSwitchView) findViewById7;
        View findViewById8 = findViewById(R.id.next_hot_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.next_hot_container)");
        LinearLayout linearLayout2 = (LinearLayout) findViewById8;
        this.nextHotContainer = linearLayout2;
        View findViewById9 = findViewById(R.id.hot_challenge_next_container);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.hot_challenge_next_container)");
        LinearLayout linearLayout3 = (LinearLayout) findViewById9;
        this.hotChallengeNextContainer = linearLayout3;
        View findViewById10 = findViewById(R.id.hot_challenge_line);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.hot_challenge_line)");
        this.hotChallengeLine = findViewById10;
        View findViewById11 = findViewById(R.id.img_hot_challenge_next_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.img_hot_challenge_next_icon)");
        this.hotChallengeNextIcon = (ImageView) findViewById11;
        View findViewById12 = findViewById(R.id.challenge_button_container);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.challenge_button_container)");
        this.hotChallengeButtonContainer = (FrameLayout) findViewById12;
        View findViewById13 = findViewById(R.id.tv_challenge_button);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.tv_challenge_button)");
        this.hotChallengeButtonText = (TextSwitchView) findViewById13;
        linearLayout3.setVisibility(8);
        frameLayout.setVisibility(8);
        linearLayout.setVisibility(8);
        this.hotChallengeButtonContainer.setVisibility(8);
        linearLayout2.setVisibility(8);
        GenericDraweeHierarchy $this$_init__u24lambda_u2d0 = (GenericDraweeHierarchy) simpleDraweeView.getHierarchy();
        if ($this$_init__u24lambda_u2d0 != null) {
            $this$_init__u24lambda_u2d0.setUseGlobalColorFilter(false);
        }
        frameLayout.setOnClickListener(this);
        linearLayout.setOnClickListener(this);
        ReClickUtilKt.clickWithCheck$default(linearLayout2, 0, new Function1<LinearLayout, Unit>(this) {
            final /* synthetic */ HotBottomBarView this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((LinearLayout) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(LinearLayout it) {
                Intrinsics.checkNotNullParameter(it, "it");
                HotBottomBarListener access$getListener$p = this.this$0.listener;
                if (access$getListener$p != null) {
                    access$getListener$p.onNextHotClick(this.this$0.model);
                }
            }
        }, 1, (Object) null);
        this.hotChallengeButtonContainer.setOnClickListener(this);
        ReClickUtilKt.clickWithCheck$default(linearLayout3, 0, new Function1<LinearLayout, Unit>(this) {
            final /* synthetic */ HotBottomBarView this$0;

            {
                this.this$0 = r2;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((LinearLayout) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(LinearLayout it) {
                Intrinsics.checkNotNullParameter(it, "it");
                HotBottomBarListener access$getListener$p = this.this$0.listener;
                if (access$getListener$p != null) {
                    access$getListener$p.onNextHotClick(this.this$0.model);
                }
            }
        }, 1, (Object) null);
        setFontAndPictureSize();
    }

    public final void setFontAndPictureSize() {
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.backView, R.dimen.video_flow_dimens_19dp, R.dimen.video_flow_dimens_19dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.hotListCategory, R.dimen.video_flow_dimens_57dp, R.dimen.video_flow_dimens_15dp, 0, 0, 12, (Object) null);
        TextSwitchView textSwitchView = this.carouselTitleView;
        if (textSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
            textSwitchView = null;
        }
        textSwitchView.setTextSize(FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_12dp, 0, 2, (Object) null));
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.upArrow, R.dimen.video_flow_dimens_12dp, R.dimen.video_flow_dimens_12dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.nextHotIcon, R.dimen.video_flow_dimens_16dp, R.dimen.video_flow_dimens_16dp, 0, 0, 12, (Object) null);
        this.hotChallengeButtonText.setTextSize(FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_12dp, 0, 2, (Object) null));
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.hotChallengeNextIcon, R.dimen.video_flow_dimens_16dp, R.dimen.video_flow_dimens_16dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.hotChallengeLine, R.dimen.video_flow_dimens_1dp, R.dimen.video_flow_dimens_15dp, 0, 0, 12, (Object) null);
    }

    public final void bindData(HotBottomBarModel model2) {
        GenericDraweeHierarchy genericDraweeHierarchy;
        if (model2 == null) {
            this.hotListCategory.setVisibility(8);
            return;
        }
        HotBottomBarModel hotBottomBarModel = this.model;
        TextSwitchView textSwitchView = null;
        boolean isUpdateFirst = !Intrinsics.areEqual((Object) hotBottomBarModel != null ? hotBottomBarModel.getTabId() : null, (Object) model2.getTabId());
        this.model = model2;
        if (!StringsKt.isBlank(model2.getHotListCategoryUrl())) {
            this.hotListCategory.setVisibility(0);
            if (model2.isHotRankTab()) {
                GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) this.hotListCategory.getHierarchy();
                if (genericDraweeHierarchy2 != null) {
                    genericDraweeHierarchy2.setPlaceholderImage(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_hot_bottom_bar_icon_place_holder));
                }
            } else if (model2.isHotCommentTab() && (genericDraweeHierarchy = (GenericDraweeHierarchy) this.hotListCategory.getHierarchy()) != null) {
                genericDraweeHierarchy.setPlaceholderImage(ResourceUtils.getDrawable(getContext(), R.drawable.video_flow_hot_bottom_bar_comment_place_holder));
            }
            this.hotListCategory.setImageURI(model2.getHotListCategoryUrl());
        } else {
            this.hotListCategory.setVisibility(8);
        }
        updateHotBottomLayout(model2);
        stopCarouselTitle();
        if (isUpdateFirst) {
            TextSwitchView textSwitchView2 = this.carouselTitleView;
            if (textSwitchView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
            } else {
                textSwitchView = textSwitchView2;
            }
            textSwitchView.updateText(new TextSwitchModel(model2.getFirstTitle(), false));
        }
        startCarouselTitle();
    }

    private final void updateHotBottomLayout(HotBottomBarModel model2) {
        this.hotInfoContainer.setVisibility(0);
        if (model2.isHotChallengeTab()) {
            HotBottomBarListener hotBottomBarListener = this.listener;
            if (hotBottomBarListener != null) {
                hotBottomBarListener.onChallengeButtonShow(model2);
            }
            this.hotInfoContainer.setPadding(getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_10dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_6dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_0dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_6dp));
            this.upArrow.setVisibility(8);
            this.nextHotContainer.setVisibility(8);
            this.backContainer.setVisibility(0);
            this.hotChallengeButtonContainer.setVisibility(0);
            this.hotChallengeNextContainer.setVisibility(0);
            return;
        }
        this.hotInfoContainer.setPadding(getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_10dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_6dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_11dp), getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_6dp));
        this.hotChallengeNextContainer.setVisibility(8);
        this.hotChallengeButtonContainer.setVisibility(8);
        this.upArrow.setVisibility(0);
        this.nextHotContainer.setVisibility(0);
        if (TopBackUtilsKt.isTopBackSwitch()) {
            this.backContainer.setVisibility(8);
        } else {
            this.backContainer.setVisibility(0);
        }
    }

    public final void setHotBottomBarListener(HotBottomBarListener listener2) {
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.listener = listener2;
    }

    private final void startCarouselTitle() {
        HotBottomBarModel $this$startCarouselTitle_u24lambda_u2d1 = this.model;
        if ($this$startCarouselTitle_u24lambda_u2d1 != null) {
            this.titleCarouselHandler.postDelayed(this.titleCarouselRunnable, ((long) (CommonUtilsKt.toIntSafely($this$startCarouselTitle_u24lambda_u2d1.getHotTitleCarouselDuration()) > 0 ? CommonUtilsKt.toIntSafely($this$startCarouselTitle_u24lambda_u2d1.getHotTitleCarouselDuration()) : 3)) * 1000);
        }
    }

    private final void stopCarouselTitle() {
        this.titleCarouselHandler.removeCallbacks(this.titleCarouselRunnable);
    }

    public void onClick(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (Intrinsics.areEqual((Object) v, (Object) this.backContainer)) {
            HotBottomBarListener hotBottomBarListener = this.listener;
            if (hotBottomBarListener != null) {
                hotBottomBarListener.onBackClick();
            }
        } else if (Intrinsics.areEqual((Object) v, (Object) this.hotInfoContainer)) {
            HotBottomBarListener hotBottomBarListener2 = this.listener;
            if (hotBottomBarListener2 != null) {
                hotBottomBarListener2.onHotInfoClick(this.model);
            }
        } else if (Intrinsics.areEqual((Object) v, (Object) this.hotChallengeButtonContainer)) {
            onHotChallengeButtonClick();
        }
    }

    public final void bindButtonData(PanelButtonModel model2) {
        Intrinsics.checkNotNullParameter(model2, "model");
        this.buttonModel = model2;
        TextSwitchView textSwitchView = this.hotChallengeButtonText;
        CharSequence text = model2.getText();
        if (text.length() == 0) {
            text = HotBottomBarModelKt.DEFAULT_BUTTON_TEXT;
        }
        textSwitchView.updateText(new TextSwitchModel((String) text, false));
    }

    private final void onHotChallengeButtonClick() {
        HotBottomBarListener hotBottomBarListener;
        HotBottomBarModel curModel = this.model;
        PanelButtonModel curButtonModel = this.buttonModel;
        if (curModel != null && curButtonModel != null && (hotBottomBarListener = this.listener) != null) {
            hotBottomBarListener.onChallengeButtonClick(curModel, curButtonModel);
        }
    }

    public final void release() {
        this.listener = null;
        stopCarouselTitle();
    }
}
