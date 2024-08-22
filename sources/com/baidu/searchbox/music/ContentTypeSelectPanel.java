package com.baidu.searchbox.music;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.tts.R;
import com.baidu.searchbox.feed.tts.TTSVideoSwitchShowUpdateListener;
import com.baidu.searchbox.feed.tts.ui.FeedTTSDispatcher;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0015\u0010\tR\u001b\u0010\u0017\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u0018\u0010\tR\u001b\u0010\u001a\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/music/ContentTypeSelectPanel;", "Lcom/baidu/android/ext/widget/PopupWindow;", "context", "Landroid/content/Context;", "anchorView", "Landroid/view/View;", "(Landroid/content/Context;Landroid/view/View;)V", "bgView", "getBgView", "()Landroid/view/View;", "bgView$delegate", "Lkotlin/Lazy;", "isAnimating", "", "isPanelShow", "musicCheckBox", "Landroid/widget/ImageView;", "getMusicCheckBox", "()Landroid/widget/ImageView;", "musicCheckBox$delegate", "panelView", "getPanelView", "panelView$delegate", "rootView", "getRootView", "rootView$delegate", "videoCheckBox", "getVideoCheckBox", "videoCheckBox$delegate", "hide", "", "show", "updateMusicCheckBox", "updateVideoCheckBox", "lib-feed-tts_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ContentTypeSelectPanel.kt */
public final class ContentTypeSelectPanel extends PopupWindow {
    private final View anchorView;
    private final Lazy bgView$delegate = BdPlayerUtils.lazyNone(new ContentTypeSelectPanel$bgView$2(this));
    /* access modifiers changed from: private */
    public final Context context;
    private boolean isAnimating;
    private boolean isPanelShow;
    private final Lazy musicCheckBox$delegate = BdPlayerUtils.lazyNone(new ContentTypeSelectPanel$musicCheckBox$2(this));
    private final Lazy panelView$delegate = BdPlayerUtils.lazyNone(new ContentTypeSelectPanel$panelView$2(this));
    private final Lazy rootView$delegate = BdPlayerUtils.lazyNone(new ContentTypeSelectPanel$rootView$2(this));
    private final Lazy videoCheckBox$delegate = BdPlayerUtils.lazyNone(new ContentTypeSelectPanel$videoCheckBox$2(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentTypeSelectPanel(Context context2, View anchorView2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(anchorView2, "anchorView");
        this.context = context2;
        this.anchorView = anchorView2;
        setContentView(getRootView());
        setWidth(-1);
        setHeight(DeviceUtils.ScreenInfo.getDisplayHeight(context2) + DeviceUtils.ScreenInfo.getStatusBarHeight());
        int i2 = 0;
        setClippingEnabled(false);
        setLayoutInScreenEnabled(true);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(context2.getResources().getColor(R.color.music_empty_view_trans_bg)));
        update();
        setOnDismissListener(new ContentTypeSelectPanel$$ExternalSyntheticLambda0(this));
        View $this$_init__u24lambda_u2d2 = getBgView();
        $this$_init__u24lambda_u2d2.setBackground($this$_init__u24lambda_u2d2.getContext().getResources().getDrawable(com.baidu.android.common.ui.style.R.color.GC11));
        $this$_init__u24lambda_u2d2.setOnClickListener(new ContentTypeSelectPanel$$ExternalSyntheticLambda1(this));
        getPanelView().setBackground(context2.getResources().getDrawable(com.baidu.searchbox.bdmedia.interfaces.R.drawable.mini_setting_corner_bg));
        int titleColor = context2.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1);
        int subtitleColor = context2.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4);
        Drawable dividerColorDrawable = context2.getResources().getDrawable(com.baidu.android.common.ui.style.R.color.GC35);
        View $this$_init__u24lambda_u2d9 = getRootView();
        ((TextView) $this$_init__u24lambda_u2d9.findViewById(R.id.tv_title)).setTextColor(titleColor);
        ((TextView) $this$_init__u24lambda_u2d9.findViewById(R.id.tv_subtitle)).setTextColor(subtitleColor);
        ((TextView) $this$_init__u24lambda_u2d9.findViewById(R.id.tv_tts_pic_text)).setTextColor(titleColor);
        ((TextView) $this$_init__u24lambda_u2d9.findViewById(R.id.tv_tts_pic_text_select)).setTextColor(subtitleColor);
        View $this$lambda_u2d9_u24lambda_u2d4 = $this$_init__u24lambda_u2d9.findViewById(R.id.tts_video_line);
        if (FeedPreferenceUtils.getBoolean(TTSVideoSwitchShowUpdateListener.KEY_TTS_VIDEO_SWITCH_SHOW, false)) {
            ((TextView) $this$lambda_u2d9_u24lambda_u2d4.findViewById(R.id.tv_tts_video)).setTextColor(titleColor);
            updateVideoCheckBox();
            $this$lambda_u2d9_u24lambda_u2d4.setOnClickListener(new ContentTypeSelectPanel$$ExternalSyntheticLambda2(this));
        } else {
            i2 = 8;
        }
        $this$lambda_u2d9_u24lambda_u2d4.setVisibility(i2);
        View $this$lambda_u2d9_u24lambda_u2d6 = $this$_init__u24lambda_u2d9.findViewById(R.id.tts_music_line);
        ((TextView) $this$lambda_u2d9_u24lambda_u2d6.findViewById(R.id.tv_tts_music)).setTextColor(titleColor);
        updateMusicCheckBox();
        $this$lambda_u2d9_u24lambda_u2d6.setOnClickListener(new ContentTypeSelectPanel$$ExternalSyntheticLambda3(this));
        TextView $this$lambda_u2d9_u24lambda_u2d8 = (TextView) $this$_init__u24lambda_u2d9.findViewById(R.id.btn_close);
        $this$lambda_u2d9_u24lambda_u2d8.setTextColor(titleColor);
        $this$lambda_u2d9_u24lambda_u2d8.setOnClickListener(new ContentTypeSelectPanel$$ExternalSyntheticLambda4(this));
        $this$_init__u24lambda_u2d9.findViewById(R.id.divider1).setBackground(dividerColorDrawable);
        $this$_init__u24lambda_u2d9.findViewById(R.id.divider2).setBackground(dividerColorDrawable);
        $this$_init__u24lambda_u2d9.findViewById(R.id.divider3).setBackground(dividerColorDrawable);
        $this$_init__u24lambda_u2d9.findViewById(R.id.divider4).setBackground(dividerColorDrawable);
    }

    /* access modifiers changed from: private */
    public final View getRootView() {
        Object value = this.rootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rootView>(...)");
        return (View) value;
    }

    private final View getBgView() {
        Object value = this.bgView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bgView>(...)");
        return (View) value;
    }

    private final View getPanelView() {
        Object value = this.panelView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-panelView>(...)");
        return (View) value;
    }

    private final ImageView getVideoCheckBox() {
        Object value = this.videoCheckBox$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-videoCheckBox>(...)");
        return (ImageView) value;
    }

    private final ImageView getMusicCheckBox() {
        Object value = this.musicCheckBox$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-musicCheckBox>(...)");
        return (ImageView) value;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m446_init_$lambda0(ContentTypeSelectPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isPanelShow = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-2$lambda-1  reason: not valid java name */
    public static final void m448lambda2$lambda1(ContentTypeSelectPanel this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-9$lambda-4$lambda-3  reason: not valid java name */
    public static final void m449lambda9$lambda4$lambda3(ContentTypeSelectPanel this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedTTSDispatcher.getInstance().getTtsSettings().toggleAutoPlayVideo();
        this$0.updateVideoCheckBox();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-9$lambda-6$lambda-5  reason: not valid java name */
    public static final void m450lambda9$lambda6$lambda5(ContentTypeSelectPanel this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FeedTTSDispatcher.getInstance().getTtsSettings().toggleAutoPlayMusic();
        this$0.updateMusicCheckBox();
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda-9$lambda-8$lambda-7  reason: not valid java name */
    public static final void m451lambda9$lambda8$lambda7(ContentTypeSelectPanel this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hide();
    }

    public final void show() {
        if (!this.isPanelShow) {
            this.isPanelShow = true;
            this.isAnimating = true;
            getBgView().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.tts_setting_anim_bg_show));
            Animation panelShowAnim = AnimationUtils.loadAnimation(this.context, R.anim.tts_setting_anim_show);
            getPanelView().startAnimation(panelShowAnim);
            getPanelView().postDelayed(new ContentTypeSelectPanel$$ExternalSyntheticLambda5(this), panelShowAnim.getDuration());
            showAtLocation(this.anchorView, 80, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-10  reason: not valid java name */
    public static final void m452show$lambda10(ContentTypeSelectPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isAnimating = false;
    }

    public final void hide() {
        if (this.isPanelShow) {
            this.isAnimating = true;
            getBgView().startAnimation(AnimationUtils.loadAnimation(this.context, R.anim.tts_setting_anim_bg_hide));
            Animation panelHideAnim = AnimationUtils.loadAnimation(this.context, R.anim.tts_setting_anim_hide);
            getPanelView().startAnimation(panelHideAnim);
            getPanelView().postDelayed(new ContentTypeSelectPanel$$ExternalSyntheticLambda6(this), panelHideAnim.getDuration());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hide$lambda-11  reason: not valid java name */
    public static final void m447hide$lambda11(ContentTypeSelectPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isAnimating = false;
        this$0.dismiss();
    }

    private final void updateVideoCheckBox() {
        if (FeedTTSDispatcher.getInstance().getTtsSettings().isAutoPlayVideo()) {
            getVideoCheckBox().setImageDrawable(this.context.getResources().getDrawable(R.drawable.tts_setting_check_box_checked));
        } else {
            getVideoCheckBox().setImageDrawable(this.context.getResources().getDrawable(R.drawable.tts_setting_check_box_unchecked));
        }
    }

    private final void updateMusicCheckBox() {
        if (FeedTTSDispatcher.getInstance().getTtsSettings().isAutoPlayMusic()) {
            getMusicCheckBox().setImageDrawable(this.context.getResources().getDrawable(R.drawable.tts_setting_check_box_checked));
        } else {
            getMusicCheckBox().setImageDrawable(this.context.getResources().getDrawable(R.drawable.tts_setting_check_box_unchecked));
        }
    }
}
