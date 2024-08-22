package com.baidu.searchbox.video.feedflow.detail.livetag;

import android.animation.Animator;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.GroupControlArea;
import com.baidu.searchbox.video.feedflow.detail.controlvisible.service.IGroupControlService;
import com.baidu.searchbox.video.feedflow.detail.livetag.LiveTagComponent$groupControlListener$2;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import com.baidu.searchbox.video.feedflow.utils.ShowAndHideAnimHelperKt;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0016J\u0010\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0018H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00188DX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livetag/LiveTagComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "groupControlAreas", "", "Lcom/baidu/searchbox/video/feedflow/detail/controlvisible/GroupControlArea;", "getGroupControlAreas", "()Ljava/util/List;", "groupControlAreas$delegate", "Lkotlin/Lazy;", "groupControlListener", "com/baidu/searchbox/video/feedflow/detail/livetag/LiveTagComponent$groupControlListener$2$1", "getGroupControlListener", "()Lcom/baidu/searchbox/video/feedflow/detail/livetag/LiveTagComponent$groupControlListener$2$1;", "groupControlListener$delegate", "liveTagHideAnimator", "Landroid/animation/Animator;", "getLiveTagHideAnimator", "()Landroid/animation/Animator;", "liveTagHideAnimator$delegate", "liveTagShowAnimator", "getLiveTagShowAnimator", "liveTagShowAnimator$delegate", "liveTagView", "Landroid/widget/TextView;", "getLiveTagView", "()Landroid/widget/TextView;", "liveTagView$delegate", "createView", "Landroid/view/View;", "initLiveTagView", "onAttachToManager", "", "onDestroy", "setFontAndPictureSize", "tv", "setTagText", "text", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveTagComponent.kt */
public class LiveTagComponent extends LiveDataComponent {
    private final Lazy groupControlAreas$delegate = BdPlayerUtils.lazyNone(LiveTagComponent$groupControlAreas$2.INSTANCE);
    private final Lazy groupControlListener$delegate = BdPlayerUtils.lazyNone(new LiveTagComponent$groupControlListener$2(this));
    private final Lazy liveTagHideAnimator$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LiveTagComponent$liveTagHideAnimator$2(this));
    private final Lazy liveTagShowAnimator$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LiveTagComponent$liveTagShowAnimator$2(this));
    private final Lazy liveTagView$delegate = LazyKt.lazy(new LiveTagComponent$liveTagView$2(this));

    /* access modifiers changed from: protected */
    public final TextView getLiveTagView() {
        return (TextView) this.liveTagView$delegate.getValue();
    }

    private final List<GroupControlArea> getGroupControlAreas() {
        return (List) this.groupControlAreas$delegate.getValue();
    }

    private final LiveTagComponent$groupControlListener$2.AnonymousClass1 getGroupControlListener() {
        return (LiveTagComponent$groupControlListener$2.AnonymousClass1) this.groupControlListener$delegate.getValue();
    }

    private final Animator getLiveTagShowAnimator() {
        return (Animator) this.liveTagShowAnimator$delegate.getValue();
    }

    private final Animator getLiveTagHideAnimator() {
        return (Animator) this.liveTagHideAnimator$delegate.getValue();
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        LiveTagState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.registerGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d3 = (LiveTagState) store.subscribe((Class<T>) LiveTagState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d3.getTagText().observe(this, new LiveTagComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d3.isVisible().observe(this, new LiveTagComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d3.isShowOrHideAnim().observe(this, new LiveTagComponent$$ExternalSyntheticLambda2(this));
        }
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && (fontSizeState = (FontSizeState) $this$subscribe$iv.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new LiveTagComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-0  reason: not valid java name */
    public static final void m11701onAttachToManager$lambda3$lambda0(LiveTagComponent this$0, String text) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(text, "text");
        this$0.setTagText(text);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-1  reason: not valid java name */
    public static final void m11702onAttachToManager$lambda3$lambda1(LiveTagComponent this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getLiveTagView().setAlpha(1.0f);
        TextView liveTagView = this$0.getLiveTagView();
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        liveTagView.setVisibility(isVisible.booleanValue() ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m11703onAttachToManager$lambda3$lambda2(LiveTagComponent this$0, Boolean isVisible) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Animator liveTagShowAnimator = this$0.getLiveTagShowAnimator();
        Animator liveTagHideAnimator = this$0.getLiveTagHideAnimator();
        Intrinsics.checkNotNullExpressionValue(isVisible, "isVisible");
        ShowAndHideAnimHelperKt.switchAlphaAnim$default(liveTagShowAnimator, liveTagHideAnimator, isVisible.booleanValue(), this$0.getLiveTagView(), 0.0f, 0.0f, 48, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-4  reason: not valid java name */
    public static final void m11704onAttachToManager$lambda4(LiveTagComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setFontAndPictureSize(this$0.getLiveTagView());
    }

    /* access modifiers changed from: private */
    public final TextView initLiveTagView() {
        TextView textView = new TextView(getContext());
        TextView $this$initLiveTagView_u24lambda_u2d6 = textView;
        ViewGroup.MarginLayoutParams $this$initLiveTagView_u24lambda_u2d6_u24lambda_u2d5 = new ViewGroup.MarginLayoutParams(-2, -2);
        $this$initLiveTagView_u24lambda_u2d6_u24lambda_u2d5.bottomMargin = $this$initLiveTagView_u24lambda_u2d6.getContext().getResources().getDimensionPixelOffset(R.dimen.video_flow_dimens_9dp);
        $this$initLiveTagView_u24lambda_u2d6.setLayoutParams($this$initLiveTagView_u24lambda_u2d6_u24lambda_u2d5);
        $this$initLiveTagView_u24lambda_u2d6.setIncludeFontPadding(false);
        $this$initLiveTagView_u24lambda_u2d6.setTextColor(ContextCompat.getColor($this$initLiveTagView_u24lambda_u2d6.getContext(), com.baidu.searchbox.feed.styles.R.color.FC410));
        $this$initLiveTagView_u24lambda_u2d6.setEllipsize(TextUtils.TruncateAt.END);
        $this$initLiveTagView_u24lambda_u2d6.setMaxLines(1);
        setFontAndPictureSize($this$initLiveTagView_u24lambda_u2d6);
        $this$initLiveTagView_u24lambda_u2d6.setVisibility(4);
        return textView;
    }

    private final void setFontAndPictureSize(TextView tv) {
        TextView textView = tv;
        float leftRightPadding = getContext().getResources().getDimension(R.dimen.video_flow_dimens_5dp);
        float topBottomPadding = getContext().getResources().getDimension(R.dimen.video_flow_dimens_3dp);
        FontSizeHelperKt.setVideoScaledPadding$default(textView, leftRightPadding, topBottomPadding, leftRightPadding, topBottomPadding, 0, 0, 48, (Object) null);
        FontSizeHelperKt.setVideoScaledSizeRes$default(tv, R.dimen.video_flow_dimens_11dp, 0, 0, 6, (Object) null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        GradientDrawable $this$setFontAndPictureSize_u24lambda_u2d7 = gradientDrawable;
        $this$setFontAndPictureSize_u24lambda_u2d7.setCornerRadius(FontSizeHelperKt.getVideoScaledSizeRes$default(R.dimen.video_flow_dimens_5dp, 0, 2, (Object) null));
        $this$setFontAndPictureSize_u24lambda_u2d7.setColor(ContextCompat.getColor(getContext(), R.color.video_flow_live_tag_bg_color));
        textView.setBackground(gradientDrawable);
    }

    public View createView() {
        return getLiveTagView();
    }

    private final void setTagText(String text) {
        getLiveTagView().setText(text);
    }

    public void onDestroy() {
        super.onDestroy();
        IGroupControlService iGroupControlService = (IGroupControlService) getManager().getService(IGroupControlService.class);
        if (iGroupControlService != null) {
            iGroupControlService.unregisterGroupsAndListener(getGroupControlAreas(), getGroupControlListener());
        }
        ShowAndHideAnimHelperKt.releaseAlphaAnim(getLiveTagShowAnimator(), getLiveTagHideAnimator());
    }
}
