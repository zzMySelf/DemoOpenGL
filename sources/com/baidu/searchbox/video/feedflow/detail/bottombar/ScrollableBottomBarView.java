package com.baidu.searchbox.video.feedflow.detail.bottombar;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.detail.utils.NumberUtilsKt;
import com.baidu.searchbox.video.detail.utils.ReClickUtilKt;
import com.baidu.searchbox.video.detail.utils.ResourceUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.bottom.ScrollableBottomBarModel;
import com.baidu.searchbox.video.feedflow.view.RoundFrameLayout;
import com.baidu.searchbox.video.widget.textswitcher.TextSwitchModel;
import com.baidu.searchbox.video.widget.textswitcher.TextSwitchView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b*\u0001\u001f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\"\u001a\u00020#2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010'\u001a\u00020(H\u0002J\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010*\u001a\u00020\u0001J\u0006\u0010+\u001a\u00020\fJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007H\u0002J\u0006\u0010/\u001a\u00020\nJ\u0006\u00100\u001a\u00020#J\u0010\u00101\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%J\u0010\u00102\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u00103\u001a\u00020#H\u0002J\b\u00104\u001a\u00020#H\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u000e\u0010!\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/bottombar/ScrollableBottomBarView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "carouselTitleView", "Lcom/baidu/searchbox/video/widget/textswitcher/TextSwitchView;", "closeBtn", "Lcom/facebook/drawee/view/SimpleDraweeView;", "iScrollableBottomBarClickListener", "Lcom/baidu/searchbox/video/feedflow/detail/bottombar/IScrollableBottomBarClickListener;", "getIScrollableBottomBarClickListener", "()Lcom/baidu/searchbox/video/feedflow/detail/bottombar/IScrollableBottomBarClickListener;", "setIScrollableBottomBarClickListener", "(Lcom/baidu/searchbox/video/feedflow/detail/bottombar/IScrollableBottomBarClickListener;)V", "iconWidth", "model", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/ScrollableBottomBarModel;", "rFContainer", "Lcom/baidu/searchbox/video/feedflow/view/RoundFrameLayout;", "rSInfoContainer", "rSListCategory", "scrollAblePrefixTitle", "Landroid/widget/TextView;", "titleCarouselHandler", "Landroid/os/Handler;", "titleCarouselRunnable", "com/baidu/searchbox/video/feedflow/detail/bottombar/ScrollableBottomBarView$titleCarouselRunnable$1", "Lcom/baidu/searchbox/video/feedflow/detail/bottombar/ScrollableBottomBarView$titleCarouselRunnable$1;", "upArrow", "bindData", "", "curStyle", "Lcom/baidu/searchbox/video/feedflow/detail/bottombar/ScrollableBottomBarStyle;", "dealTruncationOfTextView", "isShowCloseBtn", "", "getBindDataPosition", "getContainerView", "getIconView", "getShowTitle", "", "index", "getTextSwitchView", "release", "setFontAndPictureSize", "setViewLayout", "startCarouselTitle", "stopCarouselTitle", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ScrollableBottomBarView.kt */
public final class ScrollableBottomBarView extends LinearLayout {
    /* access modifiers changed from: private */
    public TextSwitchView carouselTitleView;
    private final SimpleDraweeView closeBtn;
    private IScrollableBottomBarClickListener iScrollableBottomBarClickListener;
    private int iconWidth;
    /* access modifiers changed from: private */
    public ScrollableBottomBarModel model;
    private final RoundFrameLayout rFContainer;
    private final LinearLayout rSInfoContainer;
    private final SimpleDraweeView rSListCategory;
    private final TextView scrollAblePrefixTitle;
    /* access modifiers changed from: private */
    public Handler titleCarouselHandler;
    private final ScrollableBottomBarView$titleCarouselRunnable$1 titleCarouselRunnable;
    private final SimpleDraweeView upArrow;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollableBottomBarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollableBottomBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollableBottomBarView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableBottomBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleCarouselRunnable = new ScrollableBottomBarView$titleCarouselRunnable$1(this);
        View.inflate(context, R.layout.video_flow_feed_related_search_bottom_bar_layout, this);
        View findViewById = findViewById(R.id.bottom_bar_related_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bottom…r_related_info_container)");
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById;
        this.rFContainer = roundFrameLayout;
        roundFrameLayout.setRadius((float) DIFactory.INSTANCE.dp2px(30.0f));
        View findViewById2 = findViewById(R.id.related_info_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.related_info_container)");
        this.rSInfoContainer = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.related_list_category);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.related_list_category)");
        this.rSListCategory = (SimpleDraweeView) findViewById3;
        View findViewById4 = findViewById(R.id.text_switch_view);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.text_switch_view)");
        this.carouselTitleView = (TextSwitchView) findViewById4;
        View findViewById5 = findViewById(R.id.up_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.up_arrow)");
        this.upArrow = (SimpleDraweeView) findViewById5;
        View findViewById6 = findViewById(R.id.close_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.close_btn)");
        this.closeBtn = (SimpleDraweeView) findViewById6;
        View findViewById7 = findViewById(R.id.tv_scrllable_prefix);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.tv_scrllable_prefix)");
        this.scrollAblePrefixTitle = (TextView) findViewById7;
        setFontAndPictureSize$default(this, (ScrollableBottomBarStyle) null, 1, (Object) null);
        this.titleCarouselHandler = new Handler(Looper.getMainLooper());
    }

    public final IScrollableBottomBarClickListener getIScrollableBottomBarClickListener() {
        return this.iScrollableBottomBarClickListener;
    }

    public final void setIScrollableBottomBarClickListener(IScrollableBottomBarClickListener iScrollableBottomBarClickListener2) {
        this.iScrollableBottomBarClickListener = iScrollableBottomBarClickListener2;
    }

    public static /* synthetic */ void setFontAndPictureSize$default(ScrollableBottomBarView scrollableBottomBarView, ScrollableBottomBarStyle scrollableBottomBarStyle, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            scrollableBottomBarStyle = ScrollableBottomBarStyle.BLACK_STYLE;
        }
        scrollableBottomBarView.setFontAndPictureSize(scrollableBottomBarStyle);
    }

    public final void setFontAndPictureSize(ScrollableBottomBarStyle curStyle) {
        float f2;
        Intrinsics.checkNotNullParameter(curStyle, "curStyle");
        if (curStyle == ScrollableBottomBarStyle.BLACK_STYLE) {
            View view2 = this.rSListCategory;
            int i2 = this.iconWidth;
            if (((float) i2) > 0.0f) {
                f2 = (float) i2;
            } else {
                f2 = (float) getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_18dp);
            }
            FontSizeHelperKt.setVideoScaledSize$default(view2, f2, (float) getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_18dp), 0, 0, 12, (Object) null);
        } else {
            FontSizeHelperKt.setVideoScaledSize$default((View) this.rSListCategory, (float) getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_17dp), (float) getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_17dp), 0, 0, 12, (Object) null);
        }
        this.scrollAblePrefixTitle.setTextSize(0, FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_12dp, 0, 2, (Object) null));
        TextSwitchView textSwitchView = this.carouselTitleView;
        if (textSwitchView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
            textSwitchView = null;
        }
        textSwitchView.setTextSize(FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_12dp, 0, 2, (Object) null));
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.upArrow, R.dimen.video_flow_dimens_15dp, R.dimen.video_flow_dimens_15dp, 0, 0, 12, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(this.closeBtn, R.dimen.video_flow_dimens_16dp, R.dimen.video_flow_dimens_16dp, 0, 0, 12, (Object) null);
    }

    private final void startCarouselTitle() {
        ScrollableBottomBarModel $this$startCarouselTitle_u24lambda_u2d0 = this.model;
        if ($this$startCarouselTitle_u24lambda_u2d0 != null) {
            int duration = NumberUtilsKt.toIntSafely($this$startCarouselTitle_u24lambda_u2d0.getTitleCarouselDuration()) > 0 ? NumberUtilsKt.toIntSafely($this$startCarouselTitle_u24lambda_u2d0.getTitleCarouselDuration()) : 3;
            Handler handler = this.titleCarouselHandler;
            if (handler != null) {
                handler.postDelayed(this.titleCarouselRunnable, ((long) duration) * 1000);
            }
        }
    }

    private final void stopCarouselTitle() {
        Handler handler = this.titleCarouselHandler;
        if (handler != null) {
            handler.removeCallbacks(this.titleCarouselRunnable);
        }
    }

    public static /* synthetic */ void bindData$default(ScrollableBottomBarView scrollableBottomBarView, ScrollableBottomBarModel scrollableBottomBarModel, ScrollableBottomBarStyle scrollableBottomBarStyle, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            scrollableBottomBarStyle = ScrollableBottomBarStyle.BLACK_STYLE;
        }
        scrollableBottomBarView.bindData(scrollableBottomBarModel, scrollableBottomBarStyle);
    }

    public final void bindData(ScrollableBottomBarModel model2, ScrollableBottomBarStyle curStyle) {
        int color;
        int i2;
        Intrinsics.checkNotNullParameter(curStyle, "curStyle");
        if (model2 != null) {
            setViewLayout(curStyle);
            this.model = model2;
            if (!(!StringsKt.isBlank(model2.getIconUrl())) || curStyle != ScrollableBottomBarStyle.BLACK_STYLE) {
                this.rSListCategory.setVisibility(8);
            } else {
                this.rSListCategory.setVisibility(0);
                ((GenericDraweeHierarchy) this.rSListCategory.getHierarchy()).setUseGlobalColorFilter(false);
                this.rSListCategory.setImageURI(model2.getIconUrl());
            }
            if (model2.getIconHeight() > 0) {
                this.iconWidth = (int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.video_flow_dimens_18dp)) * (((float) model2.getIconWidth()) / ((float) model2.getIconHeight())));
            }
            ViewGroup.LayoutParams $this$bindData_u24lambda_u2d1 = this.rSListCategory.getLayoutParams();
            if ($this$bindData_u24lambda_u2d1 != null && (i2 = this.iconWidth) > 0) {
                $this$bindData_u24lambda_u2d1.width = i2;
            }
            TextSwitchView textSwitchView = null;
            if (curStyle == ScrollableBottomBarStyle.WHITE_STYLE) {
                this.scrollAblePrefixTitle.setVisibility(0);
                this.scrollAblePrefixTitle.setText(DIFactory.INSTANCE.getAppContext().getString(R.string.video_flow_recommend_show_next_title_of_bottom_bar));
                this.rSListCategory.setVisibility(0);
                ((GenericDraweeHierarchy) this.rSListCategory.getHierarchy()).setUseGlobalColorFilter(false);
                this.rSListCategory.setActualImageResource(R.drawable.video_flow_scrollable_bottom_bar_up);
                ViewGroup.LayoutParams param = this.rSListCategory.getLayoutParams();
                if (param != null) {
                    ViewGroup.LayoutParams $this$bindData_u24lambda_u2d2 = param;
                    $this$bindData_u24lambda_u2d2.width = getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_17dp);
                    $this$bindData_u24lambda_u2d2.height = getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_17dp);
                } else {
                    param = null;
                }
                if (param != null) {
                    this.rSListCategory.setLayoutParams(param);
                }
            } else {
                this.scrollAblePrefixTitle.setVisibility(8);
            }
            if (!model2.isShowCloseBtn() || curStyle != ScrollableBottomBarStyle.WHITE_STYLE) {
                this.closeBtn.setVisibility(8);
            } else {
                this.closeBtn.setVisibility(0);
                ReClickUtilKt.clickWithCheck$default(this.closeBtn, 0, new ScrollableBottomBarView$bindData$2(this), 1, (Object) null);
            }
            if (!StringsKt.isBlank(model2.getTipIconUrl())) {
                this.upArrow.setVisibility(0);
                this.upArrow.setImageURI(model2.getTipIconUrl());
                ((GenericDraweeHierarchy) this.upArrow.getHierarchy()).setUseGlobalColorFilter(false);
            } else if (model2.getEntryType() == 2) {
                this.upArrow.setVisibility(0);
            } else {
                this.upArrow.setVisibility(8);
            }
            try {
                if (!StringsKt.isBlank(model2.getTitleColor())) {
                    color = Color.parseColor(model2.getTitleColor());
                } else {
                    color = ResourceUtils.getColor(getContext(), com.baidu.searchbox.feed.styles.R.color.FC409);
                }
            } catch (Exception e2) {
                color = ResourceUtils.getColor(getContext(), com.baidu.searchbox.feed.styles.R.color.FC409);
            }
            TextSwitchView textSwitchView2 = this.carouselTitleView;
            if (textSwitchView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
                textSwitchView2 = null;
            }
            textSwitchView2.setTextColor(color);
            if (curStyle == ScrollableBottomBarStyle.WHITE_STYLE) {
                TextSwitchView textSwitchView3 = this.carouselTitleView;
                if (textSwitchView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
                    textSwitchView3 = null;
                }
                textSwitchView3.setTextColor(getContext().getResources().getColor(R.color.video_flow_color_black));
            }
            stopCarouselTitle();
            TextSwitchView textSwitchView4 = this.carouselTitleView;
            if (textSwitchView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
            } else {
                textSwitchView = textSwitchView4;
            }
            textSwitchView.updateText(new TextSwitchModel(getShowTitle(0), false));
            dealTruncationOfTextView(curStyle, model2.isShowCloseBtn());
            if ((!model2.getTitleList().isEmpty()) && model2.getTitleList().size() > 1) {
                startCarouselTitle();
            }
            setFontAndPictureSize(curStyle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r2 = r2.getTitleList();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getShowTitle(int r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            r1 = 0
            if (r4 <= 0) goto L_0x0034
            com.baidu.searchbox.video.feedflow.flow.bottom.ScrollableBottomBarModel r2 = r3.model
            if (r2 == 0) goto L_0x0018
            java.util.List r2 = r2.getTitleList()
            if (r2 == 0) goto L_0x0018
            int r2 = r2.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            int r2 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r2)
            if (r4 >= r2) goto L_0x0034
            com.baidu.searchbox.video.feedflow.flow.bottom.ScrollableBottomBarModel r2 = r3.model
            if (r2 == 0) goto L_0x002f
            java.util.List r2 = r2.getTitleList()
            if (r2 == 0) goto L_0x002f
            java.lang.Object r1 = r2.get(r4)
            java.lang.String r1 = (java.lang.String) r1
        L_0x002f:
            if (r1 != 0) goto L_0x0032
            goto L_0x0040
        L_0x0032:
            r0 = r1
            goto L_0x0040
        L_0x0034:
            com.baidu.searchbox.video.feedflow.flow.bottom.ScrollableBottomBarModel r2 = r3.model
            if (r2 == 0) goto L_0x003c
            java.lang.String r1 = r2.getFirstTitle()
        L_0x003c:
            if (r1 != 0) goto L_0x003f
            goto L_0x0040
        L_0x003f:
            r0 = r1
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarView.getShowTitle(int):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dealTruncationOfTextView(com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarStyle r5, boolean r6) {
        /*
            r4 = this;
            com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarStyle r0 = com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarStyle.WHITE_STYLE
            if (r5 != r0) goto L_0x0041
            com.baidu.searchbox.video.widget.textswitcher.TextSwitchView r0 = r4.carouselTitleView
            java.lang.String r1 = "carouselTitleView"
            r2 = 0
            if (r0 != 0) goto L_0x000f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000f:
            int r0 = r0.getChildCount()
            r3 = 1
            if (r0 < r3) goto L_0x0041
            if (r6 != 0) goto L_0x0019
            goto L_0x0041
        L_0x0019:
            com.baidu.searchbox.video.widget.textswitcher.TextSwitchView r0 = r4.carouselTitleView
            if (r0 != 0) goto L_0x0021
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x0021:
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            boolean r1 = r0 instanceof android.widget.TextView
            if (r1 == 0) goto L_0x002d
            r2 = r0
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x002d:
            r0 = r2
            if (r0 == 0) goto L_0x0040
            android.view.ViewTreeObserver r1 = r0.getViewTreeObserver()
            if (r1 == 0) goto L_0x0040
            com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarView$dealTruncationOfTextView$1 r2 = new com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarView$dealTruncationOfTextView$1
            r2.<init>(r0, r4)
            android.view.ViewTreeObserver$OnGlobalLayoutListener r2 = (android.view.ViewTreeObserver.OnGlobalLayoutListener) r2
            r1.addOnGlobalLayoutListener(r2)
        L_0x0040:
            return
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarView.dealTruncationOfTextView(com.baidu.searchbox.video.feedflow.detail.bottombar.ScrollableBottomBarStyle, boolean):void");
    }

    public final int getBindDataPosition() {
        ScrollableBottomBarModel scrollableBottomBarModel = this.model;
        if (scrollableBottomBarModel != null) {
            return scrollableBottomBarModel.getPosition();
        }
        return -1;
    }

    private final void setViewLayout(ScrollableBottomBarStyle curStyle) {
        if (curStyle == ScrollableBottomBarStyle.BLACK_STYLE) {
            this.rFContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_flow_scrollable_bottom_bar_bg));
            int bottomTopPadding = getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_6dp);
            int leftRightPadding = getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_10dp);
            this.rSInfoContainer.setPadding(leftRightPadding, bottomTopPadding, leftRightPadding, bottomTopPadding);
            return;
        }
        this.rFContainer.setBackground(getContext().getResources().getDrawable(R.drawable.video_flow_scrollable_bottom_bar_whilte_bg));
        int bottomTopPadding2 = getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_7dp);
        this.rSInfoContainer.setPadding(getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_10dp), bottomTopPadding2, getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_3dp), bottomTopPadding2);
    }

    public final void release() {
        stopCarouselTitle();
        this.titleCarouselHandler = null;
    }

    public final SimpleDraweeView getIconView() {
        return this.rSListCategory;
    }

    public final TextSwitchView getTextSwitchView() {
        TextSwitchView textSwitchView = this.carouselTitleView;
        if (textSwitchView != null) {
            return textSwitchView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("carouselTitleView");
        return null;
    }

    public final LinearLayout getContainerView() {
        return this.rSInfoContainer;
    }
}
