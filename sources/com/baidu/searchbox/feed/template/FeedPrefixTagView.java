package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.baidu.searchbox.afx.AlphaVideo;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedPrefixTagData;
import com.baidu.searchbox.feed.model.FeedPrefixTagDataKt;
import com.baidu.searchbox.feed.model.FeedQuoteDtModel;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.tab.navigation.utils.ColorUtils;
import com.baidu.searchbox.feed.util.FeedCacheFileUtils;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import java.io.File;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010%\u001a\u00020&2\b\b\u0001\u0010'\u001a\u00020\bH\u0002J\u0016\u0010(\u001a\u00020)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0+H\u0002J\b\u0010,\u001a\u00020)H\u0002J\u0018\u0010-\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0018\u00101\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u00102\u001a\u00020\u0012H\u0002J\u0018\u00103\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\b\u00108\u001a\u00020)H\u0014J\b\u00109\u001a\u00020)H\u0007J\b\u0010:\u001a\u00020)H\u0014J\u0006\u0010;\u001a\u00020)J\u0012\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\rH\u0002J\u000e\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020AJ\u0010\u0010B\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\b\u0010C\u001a\u00020)H\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010E\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010F\u001a\u00020)2\b\u0010G\u001a\u0004\u0018\u00010HJ\u0010\u0010I\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u0010J\u001a\u00020)2\u0006\u0010/\u001a\u000200H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lcom/baidu/searchbox/feed/template/FeedPrefixTagView;", "Landroid/widget/FrameLayout;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "afxView", "Lcom/baidu/searchbox/afx/AlphaVideo;", "bubbleTagContainer", "Landroid/view/View;", "contentText", "Landroid/widget/TextView;", "dynamicTagContainer", "iconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "mainScope$delegate", "Lkotlin/Lazy;", "readNum", "tagContainer", "Landroid/view/ViewGroup;", "getAfxFile", "Ljava/io/File;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAutoPlayGifDraweeController", "Lcom/facebook/drawee/interfaces/DraweeController;", "getRoundRectDrawableByColor", "Landroid/graphics/drawable/Drawable;", "colorValue", "hideAllView", "", "viewList", "", "inflateDynamicTagContainer", "initAfxView", "initDynamicTag", "tagData", "Lcom/baidu/searchbox/feed/model/FeedPrefixTagData;", "initImgView", "imgView", "initLottieView", "lottieView", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "initNormalPrefix", "initViewByType", "onAttachedToWindow", "onDestroy", "onDetachedFromWindow", "onFontSizeChanged", "onlyShowView", "", "view", "update", "feedBaseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "updateContent", "updateContentTextLayoutParams", "updateExtTag", "updateIconState", "updateQuoteView", "quoteModel", "Lcom/baidu/searchbox/feed/model/FeedQuoteDtModel;", "updateTagContainer", "updateUiColor", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPrefixTagView.kt */
public final class FeedPrefixTagView extends FrameLayout implements LifecycleObserver {
    private AlphaVideo afxView;
    private View bubbleTagContainer;
    private TextView contentText;
    private View dynamicTagContainer;
    private SimpleDraweeView iconView;
    private final LifecycleOwner lifecycleOwner;
    private final Lazy mainScope$delegate;
    private TextView readNum;
    private ViewGroup tagContainer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedPrefixTagView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedPrefixTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedPrefixTagView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedPrefixTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Lifecycle lifecycle;
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainScope$delegate = LazyKt.lazy(FeedPrefixTagView$mainScope$2.INSTANCE);
        LifecycleOwner lifecycleOwner2 = context instanceof LifecycleOwner ? (LifecycleOwner) context : null;
        this.lifecycleOwner = lifecycleOwner2;
        View.inflate(context, R.layout.feed_prefix_tag_view, this);
        if (lifecycleOwner2 != null && (lifecycle = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    private final CoroutineScope getMainScope() {
        return (CoroutineScope) this.mainScope$delegate.getValue();
    }

    public final void update(FeedBaseModel feedBaseModel) {
        Intrinsics.checkNotNullParameter(feedBaseModel, "feedBaseModel");
        if (FeedTemplateImpl.isNeedShowPrefixTagView(feedBaseModel)) {
            setVisibility(0);
            FeedPrefixTagData it = feedBaseModel.data.feedPrefixTagData;
            if (it != null) {
                initViewByType(it);
                return;
            }
            return;
        }
        setVisibility(8);
    }

    public final void updateQuoteView(FeedQuoteDtModel quoteModel) {
        FeedPrefixTagData it;
        if (quoteModel != null && (it = quoteModel.feedPrefixTagData) != null) {
            initViewByType(it);
        }
    }

    private final void updateTagContainer(FeedPrefixTagData tagData) {
        updateIconState(tagData);
        updateContent(tagData);
        SimpleDraweeView simpleDraweeView = this.iconView;
        boolean z = true;
        if (!(simpleDraweeView != null && simpleDraweeView.getVisibility() == 0)) {
            TextView textView = this.contentText;
            if (textView == null || textView.getVisibility() != 0) {
                z = false;
            }
            if (!z) {
                ViewGroup viewGroup = this.tagContainer;
                if (viewGroup != null) {
                    viewGroup.setVisibility(8);
                }
                updateContentTextLayoutParams();
                updateUiColor(tagData);
            }
        }
        ViewGroup viewGroup2 = this.tagContainer;
        if (viewGroup2 != null) {
            viewGroup2.setVisibility(0);
        }
        updateContentTextLayoutParams();
        updateUiColor(tagData);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateContentTextLayoutParams() {
        /*
            r4 = this;
            android.widget.TextView r0 = r4.contentText
            r1 = 0
            if (r0 == 0) goto L_0x000a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            boolean r2 = r0 instanceof android.widget.LinearLayout.LayoutParams
            if (r2 == 0) goto L_0x0012
            r1 = r0
            android.widget.LinearLayout$LayoutParams r1 = (android.widget.LinearLayout.LayoutParams) r1
        L_0x0012:
            if (r1 != 0) goto L_0x0015
            return
        L_0x0015:
            r0 = r1
            android.widget.TextView r1 = r4.contentText
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0024
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0024
            r1 = r2
            goto L_0x0025
        L_0x0024:
            r1 = r3
        L_0x0025:
            if (r1 == 0) goto L_0x0042
            com.facebook.drawee.view.SimpleDraweeView r1 = r4.iconView
            if (r1 == 0) goto L_0x0032
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r2 = r3
        L_0x0033:
            if (r2 != 0) goto L_0x0042
            r1 = r4
            android.view.View r1 = (android.view.View) r1
            int r2 = com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X030
            int r1 = com.baidu.searchbox.kotlinx.ViewExtensionsKt.getDimensionPixelSize(r1, r2)
            r0.rightMargin = r1
            goto L_0x0044
        L_0x0042:
            r0.rightMargin = r3
        L_0x0044:
            android.widget.TextView r1 = r4.contentText
            if (r1 != 0) goto L_0x0049
            goto L_0x004f
        L_0x0049:
            r2 = r0
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r1.setLayoutParams(r2)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedPrefixTagView.updateContentTextLayoutParams():void");
    }

    private final void updateIconState(FeedPrefixTagData tagData) {
        if (tagData.isIconValid()) {
            SimpleDraweeView simpleDraweeView = this.iconView;
            if (simpleDraweeView != null) {
                simpleDraweeView.setVisibility(0);
            }
            String iconUrl = NightModeHelper.isNightMode() ? tagData.getIconUrlNight() : tagData.getIconUrl();
            SimpleDraweeView simpleDraweeView2 = this.iconView;
            if (simpleDraweeView2 != null) {
                simpleDraweeView2.setController(getAutoPlayGifDraweeController(iconUrl));
                return;
            }
            return;
        }
        SimpleDraweeView simpleDraweeView3 = this.iconView;
        if (simpleDraweeView3 != null) {
            simpleDraweeView3.setVisibility(8);
        }
    }

    private final void updateContent(FeedPrefixTagData tagData) {
        if (tagData.isContentValid()) {
            TextView textView = this.contentText;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.contentText;
            if (textView2 != null) {
                textView2.setText(tagData.getContent());
                return;
            }
            return;
        }
        TextView textView3 = this.contentText;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    private final boolean onlyShowView(View view2) {
        View otherHideView = Intrinsics.areEqual((Object) view2, (Object) this.iconView) ? this.contentText : this.iconView;
        if (view2 != null && view2.getVisibility() == 0) {
            if (otherHideView != null && otherHideView.getVisibility() == 8) {
                return true;
            }
        }
        return false;
    }

    private final void updateExtTag(FeedPrefixTagData tagData) {
        if (tagData.isReadNumValid()) {
            TextView textView = this.readNum;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.readNum;
            if (textView2 != null) {
                textView2.setText(tagData.getReadNum());
            }
            TextView textView3 = this.readNum;
            if (textView3 != null) {
                ViewExtensionsKt.setTextColorRes(textView3, R.color.FC46);
                return;
            }
            return;
        }
        TextView textView4 = this.readNum;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
    }

    private final void updateUiColor(FeedPrefixTagData tagData) {
        if (NightModeHelper.isNightMode()) {
            int bgColor = ColorUtils.toggleColorSafe(tagData.getBgColorNight(), R.color.FC47);
            ViewGroup viewGroup = this.tagContainer;
            if (viewGroup != null) {
                viewGroup.setBackground(getRoundRectDrawableByColor(bgColor));
            }
            TextView textView = this.contentText;
            if (textView != null) {
                textView.setTextColor(ColorUtils.toggleColorSafe(tagData.getFontColorNight(), R.color.FC46));
            }
        } else {
            int bgColor2 = ColorUtils.toggleColorSafe(tagData.getBgColor(), R.color.FC47);
            ViewGroup viewGroup2 = this.tagContainer;
            if (viewGroup2 != null) {
                viewGroup2.setBackground(getRoundRectDrawableByColor(bgColor2));
            }
            TextView textView2 = this.contentText;
            if (textView2 != null) {
                textView2.setTextColor(ColorUtils.toggleColorSafe(tagData.getFontColor(), R.color.FC46));
            }
        }
        if (tagData.isReadNumValid() != 0) {
            View view2 = this.bubbleTagContainer;
            if (view2 != null) {
                view2.setBackground(getRoundRectDrawableByColor(getResources().getColor(R.color.FC120)));
                return;
            }
            return;
        }
        View view3 = this.bubbleTagContainer;
        if (view3 != null) {
            view3.setBackground(getRoundRectDrawableByColor(getResources().getColor(R.color.FC100)));
        }
    }

    private final Drawable getRoundRectDrawableByColor(int colorValue) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$getRoundRectDrawableByColor_u24lambda_u2d2 = gradientDrawable;
        $this$getRoundRectDrawableByColor_u24lambda_u2d2.setShape(0);
        $this$getRoundRectDrawableByColor_u24lambda_u2d2.setCornerRadius((float) ViewExtensionsKt.getDimensionPixelSize(this, R.dimen.feed_tag_view_corner_radius));
        $this$getRoundRectDrawableByColor_u24lambda_u2d2.setColor(colorValue);
        return gradientDrawable;
    }

    private final void initViewByType(FeedPrefixTagData tagData) {
        if (Intrinsics.areEqual((Object) "0", (Object) tagData.getTagType())) {
            initNormalPrefix(tagData);
        } else {
            initDynamicTag(tagData);
        }
    }

    private final void initNormalPrefix(FeedPrefixTagData tagData) {
        View view2 = this.dynamicTagContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        if (this.bubbleTagContainer == null) {
            ViewStub bubbleContainerStub = (ViewStub) findViewById(R.id.prefix_bubble_tag_container);
            this.bubbleTagContainer = bubbleContainerStub != null ? bubbleContainerStub.inflate() : null;
        }
        View it = this.bubbleTagContainer;
        if (it != null) {
            it.setVisibility(0);
            this.tagContainer = (ViewGroup) it.findViewById(R.id.tag_container);
            this.iconView = (SimpleDraweeView) it.findViewById(R.id.icon);
            this.contentText = (TextView) it.findViewById(R.id.content_text);
            this.readNum = (TextView) it.findViewById(R.id.read_num);
            updateTagContainer(tagData);
            updateExtTag(tagData);
            onFontSizeChanged();
        }
    }

    private final void initDynamicTag(FeedPrefixTagData tagData) {
        inflateDynamicTagContainer();
        ViewExtensionsKt.setBackgroundColorRes(this, com.baidu.android.common.ui.style.R.color.transparent);
        View view2 = this.bubbleTagContainer;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View it = this.dynamicTagContainer;
        if (it != null) {
            BdBaseLottieView lottieView = (BdBaseLottieView) it.findViewById(R.id.prefix_lottie_view);
            SimpleDraweeView imgView = (SimpleDraweeView) it.findViewById(R.id.prefix_img_view);
            AlphaVideo afxView2 = (AlphaVideo) it.findViewById(R.id.prefix_afx_view);
            this.afxView = afxView2;
            hideAllView(CollectionsKt.arrayListOf(lottieView, imgView, afxView2));
            String tagType = tagData.getTagType();
            switch (tagType.hashCode()) {
                case 49:
                    if (tagType.equals("1")) {
                        String iconUrl = tagData.getIconUrl();
                        Intrinsics.checkNotNullExpressionValue(imgView, "imgView");
                        initImgView(iconUrl, imgView);
                        return;
                    }
                    return;
                case 50:
                    if (tagType.equals("2")) {
                        String iconUrl2 = tagData.getIconUrl();
                        Intrinsics.checkNotNullExpressionValue(lottieView, "lottieView");
                        initLottieView(iconUrl2, lottieView);
                        return;
                    }
                    return;
                case 51:
                    if (tagType.equals("3")) {
                        String iconUrl3 = tagData.getIconUrl();
                        Intrinsics.checkNotNullExpressionValue(afxView2, "afxView");
                        initAfxView(iconUrl3, afxView2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void hideAllView(List<? extends View> viewList) {
        for (View view2 : viewList) {
            view2.setVisibility(8);
        }
    }

    private final void initLottieView(String url, BdBaseLottieView lottieView) {
        lottieView.setAnimationFromUrl(url);
        lottieView.setVisibility(0);
    }

    private final void initImgView(String url, SimpleDraweeView imgView) {
        imgView.setController(getAutoPlayGifDraweeController(url));
        imgView.setVisibility(0);
    }

    private final void initAfxView(String url, AlphaVideo afxView2) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(getMainScope(), Dispatchers.getMain(), (CoroutineStart) null, new FeedPrefixTagView$initAfxView$1(this, url, afxView2, (Continuation<? super FeedPrefixTagView$initAfxView$1>) null), 2, (Object) null);
    }

    private final void inflateDynamicTagContainer() {
        if (this.dynamicTagContainer == null) {
            this.dynamicTagContainer = ((ViewStub) findViewById(R.id.dynamic_tag_container)).inflate();
        }
    }

    private final DraweeController getAutoPlayGifDraweeController(String url) {
        AbstractDraweeController build = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(url).setAutoPlayAnimations(true)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newDraweeControllerBuild…rue)\n            .build()");
        return build;
    }

    /* access modifiers changed from: private */
    public final Object getAfxFile(String url, Continuation<? super File> $completion) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FeedPrefixTagView$getAfxFile$2(FeedCacheFileUtils.getLocalCache(url, FeedPrefixTagDataKt.DIR_DYNAMIC_AFX_TAG), url, (Continuation<? super FeedPrefixTagView$getAfxFile$2>) null), $completion);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlphaVideo alphaVideo = this.afxView;
        if (alphaVideo != null) {
            alphaVideo.play();
        }
        AlphaVideo alphaVideo2 = this.afxView;
        if (alphaVideo2 != null) {
            alphaVideo2.setLooping(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AlphaVideo alphaVideo = this.afxView;
        if (alphaVideo != null) {
            alphaVideo.play();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (!(lifecycleOwner2 == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null)) {
            lifecycle.removeObserver(this);
        }
        CoroutineScopeKt.cancel$default(getMainScope(), (CancellationException) null, 1, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFontSizeChanged() {
        /*
            r8 = this;
            android.view.View r0 = r8.bubbleTagContainer
            if (r0 == 0) goto L_0x00b9
            r1 = 0
            android.content.res.Resources r2 = r8.getResources()
            int r3 = com.baidu.searchbox.feed.styles.R.dimen.F_H_X15
            int r2 = r2.getDimensionPixelOffset(r3)
            int r2 = com.baidu.searchbox.feed.flow.util.FontAdjustment.getScaledFrameworkSize((int) r2)
            android.view.ViewGroup r3 = r8.tagContainer
            java.lang.String r4 = "layoutParams"
            if (r3 == 0) goto L_0x0035
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            if (r3 == 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r5 = 0
            r3.height = r2
            com.facebook.drawee.view.SimpleDraweeView r6 = r8.iconView
            android.view.View r6 = (android.view.View) r6
            boolean r6 = r8.onlyShowView(r6)
            if (r6 == 0) goto L_0x0031
            r6 = r2
            goto L_0x0032
        L_0x0031:
            r6 = -2
        L_0x0032:
            r3.width = r6
        L_0x0035:
            android.widget.TextView r3 = r8.readNum
            r5 = 0
            if (r3 == 0) goto L_0x0040
            android.view.ViewGroup$LayoutParams r3 = r3.getLayoutParams()
            goto L_0x0041
        L_0x0040:
            r3 = r5
        L_0x0041:
            if (r3 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r3.height = r2
        L_0x0046:
            float r3 = (float) r2
            r6 = 1073741824(0x40000000, float:2.0)
            float r3 = r3 / r6
            android.view.ViewGroup r6 = r8.tagContainer
            if (r6 == 0) goto L_0x0053
            android.graphics.drawable.Drawable r6 = r6.getBackground()
            goto L_0x0054
        L_0x0053:
            r6 = r5
        L_0x0054:
            boolean r7 = r6 instanceof android.graphics.drawable.GradientDrawable
            if (r7 == 0) goto L_0x005b
            android.graphics.drawable.GradientDrawable r6 = (android.graphics.drawable.GradientDrawable) r6
            goto L_0x005c
        L_0x005b:
            r6 = r5
        L_0x005c:
            if (r6 != 0) goto L_0x005f
            goto L_0x0062
        L_0x005f:
            r6.setCornerRadius(r3)
        L_0x0062:
            android.graphics.drawable.Drawable r6 = r0.getBackground()
            boolean r7 = r6 instanceof android.graphics.drawable.GradientDrawable
            if (r7 == 0) goto L_0x006d
            r5 = r6
            android.graphics.drawable.GradientDrawable r5 = (android.graphics.drawable.GradientDrawable) r5
        L_0x006d:
            if (r5 != 0) goto L_0x0070
            goto L_0x0073
        L_0x0070:
            r5.setCornerRadius(r3)
        L_0x0073:
            android.content.res.Resources r5 = r8.getResources()
            int r6 = com.baidu.searchbox.feed.styles.R.dimen.F_T_X017
            int r5 = r5.getDimensionPixelOffset(r6)
            int r5 = com.baidu.searchbox.feed.flow.util.FontAdjustment.getScaledFrameworkSize((int) r5)
            float r5 = (float) r5
            android.widget.TextView r6 = r8.contentText
            r7 = 0
            if (r6 == 0) goto L_0x008a
            r6.setTextSize(r7, r5)
        L_0x008a:
            android.widget.TextView r6 = r8.readNum
            if (r6 == 0) goto L_0x0091
            r6.setTextSize(r7, r5)
        L_0x0091:
            android.content.res.Resources r6 = r8.getResources()
            int r7 = com.baidu.searchbox.feed.template.R.dimen.feed_tag_view_icon_size
            int r6 = r6.getDimensionPixelOffset(r7)
            int r6 = com.baidu.searchbox.feed.flow.util.FontAdjustment.getScaledFrameworkSize((int) r6)
            com.facebook.drawee.view.SimpleDraweeView r7 = r8.iconView
            if (r7 == 0) goto L_0x00b3
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            if (r7 == 0) goto L_0x00b3
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r4 = r7
            r7 = 0
            r4.width = r6
            r4.height = r6
        L_0x00b3:
            r0.requestLayout()
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.template.FeedPrefixTagView.onFontSizeChanged():void");
    }
}
