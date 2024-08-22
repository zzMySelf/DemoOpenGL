package com.baidu.searchbox.video.feedflow.flow.bottom.barrage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.player.utils.FontSizeHelperKt;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.rewardsystem.newtimer.constants.NewTimerConstants;
import com.baidu.searchbox.toolbar.CommentInputLayout;
import com.baidu.searchbox.toolbar.ICommentInputLayoutCallback;
import com.baidu.searchbox.ui.SelectorTextView;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarComponentKt;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarModel;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageInputModel;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 ¤\u00012\u00020\u0001:\u0002¤\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010b\u001a\u000201H\u0014J\u0012\u0010c\u001a\u0002012\b\u0010d\u001a\u0004\u0018\u00010eH\u0014J\b\u0010f\u001a\u000201H\u0016J\b\u0010g\u001a\u00020%H\u0014J\b\u0010h\u001a\u00020JH\u0002J\b\u0010i\u001a\u00020 H\u0014J\b\u0010j\u001a\u00020JH\u0002J\u001c\u0010k\u001a\u0002012\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u00020100H\u0002J\b\u0010n\u001a\u00020\u0006H\u0002J\u0006\u0010o\u001a\u00020\u0006J\n\u0010p\u001a\u0004\u0018\u00010JH\u0014J\b\u0010q\u001a\u00020XH\u0002J\b\u0010r\u001a\u00020=H\u0002J\u0006\u0010s\u001a\u00020=J\b\u0010t\u001a\u00020=H\u0002J\b\u0010u\u001a\u00020=H\u0002J\u0006\u0010v\u001a\u00020=J\u0006\u0010w\u001a\u000201J\u0010\u0010x\u001a\u0002012\u0006\u0010y\u001a\u00020=H\u0016J\b\u0010z\u001a\u000201H\u0014J\b\u0010{\u001a\u00020\u0006H\u0002J\b\u0010|\u001a\u000201H\u0016J\b\u0010}\u001a\u000201H\u0004J\b\u0010~\u001a\u000201H\u0002J\u001d\u0010\u001a\u0002012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\u0014H\u0016J&\u0010\u0001\u001a\u0002012\u001d\u0010\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0001j\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0001J\u0013\u0010\u0001\u001a\u0002012\b\u0010\u0001\u001a\u00030\u0001H\u0014J\u0012\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u00020\u0014H\u0002J\u0014\u0010\u0001\u001a\u0002012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0001\u001a\u0002012\u0007\u0010\u0001\u001a\u00020\u0014J\t\u0010\u0001\u001a\u000201H\u0002J\t\u0010\u0001\u001a\u000201H\u0004J\u0014\u0010\u0001\u001a\u0002012\t\b\u0002\u0010\u0001\u001a\u00020=H\u0016J\t\u0010\u0001\u001a\u000201H\u0002J\u0014\u0010\u0001\u001a\u00020=2\t\u0010\u0001\u001a\u0004\u0018\u00010eH\u0016J\u0014\u0010\u0001\u001a\u0002012\t\u0010\u0001\u001a\u0004\u0018\u00010JH\u0002J\t\u0010\u0001\u001a\u000201H\u0016J&\u0010\u0001\u001a\u00020+*\u00020m2\b\u0010\u0001\u001a\u00030\u00012\r\u0010\u0001\u001a\u00030\u0001\"\u00030\u0001H\u0002J\r\u0010\u0001\u001a\u00020+*\u00020mH\u0002J\u001c\u0010\u0001\u001a\u00020+*\u00020m2\r\u0010\u0001\u001a\u00030\u0001\"\u00030\u0001H\u0002J\u0019\u0010 \u0001\u001a\u00020X*\u00020m2\n\b\u0002\u0010¡\u0001\u001a\u00030\u0001H\u0002J.\u0010¢\u0001\u001a\u000201*\u00020e2\u0007\u0010£\u0001\u001a\u00020e2\u0016\b\u0002\u0010l\u001a\u0010\u0012\u0004\u0012\u00020m\u0012\u0004\u0012\u000201\u0018\u000100H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8TX\u0002¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8TX\u0002¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\b\"\u0004\b.\u0010\nR(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R(\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R(\u00109\u001a\u0010\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R(\u0010<\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u000201\u0018\u000100X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00103\"\u0004\b?\u00105R!\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00060*8DX\u0002¢\u0006\f\n\u0004\bC\u0010\u0018\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0002¢\u0006\f\n\u0004\bH\u0010\u0018\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8DX\u0002¢\u0006\f\n\u0004\bM\u0010\u0018\u001a\u0004\bK\u0010LR\u001a\u0010N\u001a\b\u0012\u0004\u0012\u00020J0OX\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u001b\u0010R\u001a\u00020S8BX\u0002¢\u0006\f\n\u0004\bV\u0010\u0018\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020X8BX\u0002¢\u0006\f\n\u0004\b[\u0010\u0018\u001a\u0004\bY\u0010ZR\u001b\u0010\\\u001a\u00020X8BX\u0002¢\u0006\f\n\u0004\b^\u0010\u0018\u001a\u0004\b]\u0010ZR\u001b\u0010_\u001a\u00020J8DX\u0002¢\u0006\f\n\u0004\ba\u0010\u0018\u001a\u0004\b`\u0010L¨\u0006¥\u0001"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/BottomCommentInteractManager;", "Lcom/baidu/searchbox/toolbar/ICommentInputLayoutCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "barrageTips", "", "getBarrageTips", "()Ljava/lang/String;", "setBarrageTips", "(Ljava/lang/String;)V", "commentInputDefaultText", "", "getCommentInputDefaultText", "()Ljava/lang/CharSequence;", "setCommentInputDefaultText", "(Ljava/lang/CharSequence;)V", "commentInputLayout", "Lcom/baidu/searchbox/toolbar/CommentInputLayout;", "commentInputViewOriginTextColor", "", "getCommentInputViewOriginTextColor", "()I", "commentInputViewOriginTextColor$delegate", "Lkotlin/Lazy;", "currentPresetTextIndex", "Lkotlin/Function0;", "getCurrentPresetTextIndex", "()Lkotlin/jvm/functions/Function0;", "setCurrentPresetTextIndex", "(Lkotlin/jvm/functions/Function0;)V", "emojiAndSendBtnContainer", "Landroid/widget/RelativeLayout;", "getEmojiAndSendBtnContainer", "()Landroid/widget/RelativeLayout;", "emojiAndSendBtnContainer$delegate", "emojiContainer", "Landroid/widget/LinearLayout;", "getEmojiContainer", "()Landroid/widget/LinearLayout;", "emojiContainer$delegate", "emojiListAnimator", "", "Landroid/animation/ObjectAnimator;", "hintTextWithEmoji", "getHintTextWithEmoji", "setHintTextWithEmoji", "onBarragePresetTextShow", "Lkotlin/Function1;", "", "getOnBarragePresetTextShow", "()Lkotlin/jvm/functions/Function1;", "setOnBarragePresetTextShow", "(Lkotlin/jvm/functions/Function1;)V", "onBarrageSend", "getOnBarrageSend", "setOnBarrageSend", "onBarrageSendButtonShow", "getOnBarrageSendButtonShow", "setOnBarrageSendButtonShow", "onPresetTextIndex", "", "getOnPresetTextIndex", "setOnPresetTextIndex", "presetTextList", "getPresetTextList", "()Ljava/util/List;", "presetTextList$delegate", "reverseInterpolator", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/ReverseInterpolator;", "getReverseInterpolator", "()Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/ReverseInterpolator;", "reverseInterpolator$delegate", "sendButton", "Landroid/widget/TextView;", "getSendButton", "()Landroid/widget/TextView;", "sendButton$delegate", "sendButtonDelegate", "Lkotlin/Lazy;", "getSendButtonDelegate", "()Lkotlin/Lazy;", "sendButtonStyle", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/BarrageSendButtonStyle;", "getSendButtonStyle", "()Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/BarrageSendButtonStyle;", "sendButtonStyle$delegate", "showAnimatorSet", "Landroid/animation/AnimatorSet;", "getShowAnimatorSet", "()Landroid/animation/AnimatorSet;", "showAnimatorSet$delegate", "translateInputTextAnimator", "getTranslateInputTextAnimator", "translateInputTextAnimator$delegate", "translateTextView", "getTranslateTextView", "translateTextView$delegate", "addSendButton", "addTranslateTextViewToParent", "viewGroup", "Landroid/view/ViewGroup;", "clearShowAnimator", "createEmojiContainer", "createInputTextView", "createInteractRootContainer", "createSendButton", "forEachEmojiView", "forChild", "Landroid/view/View;", "getCurrentInputText", "getInputResetText", "getInputView", "getTranslateTextAnimator", "isDefaultText", "isEmojiContainerShowing", "isInputTextUpAnimatorEnabled", "isNeedShowNextPresetText", "isSendButtonShowing", "onFontSizeChange", "onSetEnabled", "enabled", "onShowSendButtonAnimationEnd", "popPresetText", "resetCommentInputLayout", "resetCommentInputViewTextColor", "sendBarrage", "setBarrageInputInfo", "bottomBarModel", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/BottomBarModel;", "curPresetInputIndex", "setPresetTextList", "textList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "setSendButtonStyle", "styleType", "Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/ButtonStyleType;", "setSendButtonText", "text", "setSendButtonVisibility", "visibility", "showNextPresetText", "showOriginInputText", "showSendButton", "withAnimator", "switchPreset", "updateCommentInputLayout", "root", "updateCommentInputViewTextColor", "inputView", "updateInputResetText", "buildAlphaAnimator", "durationMills", "", "values", "", "", "buildEmojiAnimator", "buildMoveUpAnimator", "buildSendButtonAnimator", "alphaDuration", "transferChildrenToTargetContainer", "arrivalContainer", "Companion", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomCommentInteractManager.kt */
public class BottomCommentInteractManager implements ICommentInputLayoutCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float DP_22 = 22.0f;
    private static final float DP_29 = 29.0f;
    private static final float DP_54 = 54.0f;
    private static final float DP_59 = 59.0f;
    private static final float DP_75 = 75.0f;
    private static final long DURATION_160 = 160;
    private static final long DURATION_240 = 240;
    public static final long DURATION_400 = 400;
    private static final long DURATION_480 = 480;
    private String barrageTips;
    private CharSequence commentInputDefaultText;
    /* access modifiers changed from: private */
    public CommentInputLayout commentInputLayout;
    private final Lazy commentInputViewOriginTextColor$delegate = BdPlayerUtils.lazyNone(new BottomCommentInteractManager$commentInputViewOriginTextColor$2(this));
    /* access modifiers changed from: private */
    public final Context context;
    private Function0<Integer> currentPresetTextIndex;
    private final Lazy emojiAndSendBtnContainer$delegate = BdPlayerUtils.lazyNone(new BottomCommentInteractManager$emojiAndSendBtnContainer$2(this));
    private final Lazy emojiContainer$delegate = BdPlayerUtils.lazyNone(new BottomCommentInteractManager$emojiContainer$2(this));
    /* access modifiers changed from: private */
    public final List<ObjectAnimator> emojiListAnimator = new ArrayList();
    private String hintTextWithEmoji;
    private Function1<? super String, Unit> onBarragePresetTextShow;
    private Function1<? super String, Unit> onBarrageSend;
    private Function1<? super Unit, Unit> onBarrageSendButtonShow;
    private Function1<? super Boolean, Unit> onPresetTextIndex;
    private final Lazy presetTextList$delegate = BdPlayerUtils.lazyNone(BottomCommentInteractManager$presetTextList$2.INSTANCE);
    private final Lazy reverseInterpolator$delegate = BdPlayerUtils.lazyNone(BottomCommentInteractManager$reverseInterpolator$2.INSTANCE);
    private final Lazy sendButton$delegate;
    private final Lazy<TextView> sendButtonDelegate;
    private final Lazy sendButtonStyle$delegate = BdPlayerUtils.lazyNone(BottomCommentInteractManager$sendButtonStyle$2.INSTANCE);
    private final Lazy showAnimatorSet$delegate = BdPlayerUtils.lazyNone(BottomCommentInteractManager$showAnimatorSet$2.INSTANCE);
    private final Lazy translateInputTextAnimator$delegate = BdPlayerUtils.lazyNone(BottomCommentInteractManager$translateInputTextAnimator$2.INSTANCE);
    private final Lazy translateTextView$delegate = BdPlayerUtils.lazyNone(new BottomCommentInteractManager$translateTextView$2(this));

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BottomCommentInteractManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonStyleType.values().length];
            iArr[ButtonStyleType.FEED_DARK.ordinal()] = 1;
            iArr[ButtonStyleType.FEED_LIGHT.ordinal()] = 2;
            iArr[ButtonStyleType.LANDSCAPE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BottomCommentInteractManager(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Lazy<TextView> lazyNone = BdPlayerUtils.lazyNone(new BottomCommentInteractManager$sendButtonDelegate$1(this));
        this.sendButtonDelegate = lazyNone;
        this.sendButton$delegate = lazyNone;
    }

    /* access modifiers changed from: protected */
    public final Lazy<TextView> getSendButtonDelegate() {
        return this.sendButtonDelegate;
    }

    /* access modifiers changed from: protected */
    public final TextView getSendButton() {
        return (TextView) this.sendButton$delegate.getValue();
    }

    public final Function1<String, Unit> getOnBarrageSend() {
        return this.onBarrageSend;
    }

    public final void setOnBarrageSend(Function1<? super String, Unit> function1) {
        this.onBarrageSend = function1;
    }

    public final Function1<String, Unit> getOnBarragePresetTextShow() {
        return this.onBarragePresetTextShow;
    }

    public final void setOnBarragePresetTextShow(Function1<? super String, Unit> function1) {
        this.onBarragePresetTextShow = function1;
    }

    public final Function1<Unit, Unit> getOnBarrageSendButtonShow() {
        return this.onBarrageSendButtonShow;
    }

    public final void setOnBarrageSendButtonShow(Function1<? super Unit, Unit> function1) {
        this.onBarrageSendButtonShow = function1;
    }

    /* access modifiers changed from: protected */
    public final TextView getTranslateTextView() {
        return (TextView) this.translateTextView$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final List<String> getPresetTextList() {
        return (List) this.presetTextList$delegate.getValue();
    }

    public final Function1<Boolean, Unit> getOnPresetTextIndex() {
        return this.onPresetTextIndex;
    }

    public final void setOnPresetTextIndex(Function1<? super Boolean, Unit> function1) {
        this.onPresetTextIndex = function1;
    }

    public final Function0<Integer> getCurrentPresetTextIndex() {
        return this.currentPresetTextIndex;
    }

    public final void setCurrentPresetTextIndex(Function0<Integer> function0) {
        this.currentPresetTextIndex = function0;
    }

    /* access modifiers changed from: protected */
    public LinearLayout getEmojiContainer() {
        return (LinearLayout) this.emojiContainer$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public RelativeLayout getEmojiAndSendBtnContainer() {
        return (RelativeLayout) this.emojiAndSendBtnContainer$delegate.getValue();
    }

    private final BarrageSendButtonStyle getSendButtonStyle() {
        return (BarrageSendButtonStyle) this.sendButtonStyle$delegate.getValue();
    }

    private final AnimatorSet getShowAnimatorSet() {
        return (AnimatorSet) this.showAnimatorSet$delegate.getValue();
    }

    private final AnimatorSet getTranslateInputTextAnimator() {
        return (AnimatorSet) this.translateInputTextAnimator$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ReverseInterpolator getReverseInterpolator() {
        return (ReverseInterpolator) this.reverseInterpolator$delegate.getValue();
    }

    private final int getCommentInputViewOriginTextColor() {
        return ((Number) this.commentInputViewOriginTextColor$delegate.getValue()).intValue();
    }

    /* access modifiers changed from: protected */
    public final CharSequence getCommentInputDefaultText() {
        return this.commentInputDefaultText;
    }

    /* access modifiers changed from: protected */
    public final void setCommentInputDefaultText(CharSequence charSequence) {
        this.commentInputDefaultText = charSequence;
    }

    public final String getBarrageTips() {
        return this.barrageTips;
    }

    public final void setBarrageTips(String str) {
        this.barrageTips = str;
    }

    public final String getHintTextWithEmoji() {
        return this.hintTextWithEmoji;
    }

    public final void setHintTextWithEmoji(String str) {
        this.hintTextWithEmoji = str;
    }

    public void onSetEnabled(boolean enabled) {
        getSendButton().setEnabled(enabled);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/bottom/barrage/BottomCommentInteractManager$Companion;", "", "()V", "DP_22", "", "DP_29", "DP_54", "DP_59", "DP_75", "DURATION_160", "", "DURATION_240", "DURATION_400", "DURATION_480", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BottomCommentInteractManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final void sendBarrage() {
        Function1<? super String, Unit> function1 = this.onBarrageSend;
        if (function1 != null) {
            function1.invoke(getCurrentInputText());
        }
        if (DIFactory.INSTANCE.isLogin(false)) {
            switchPreset();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getCurrentInputText() {
        /*
            r1 = this;
            android.widget.TextView r0 = r1.getInputView()
            if (r0 == 0) goto L_0x0011
            java.lang.CharSequence r0 = r0.getText()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.toString()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = ""
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.bottom.barrage.BottomCommentInteractManager.getCurrentInputText():java.lang.String");
    }

    private final void switchPreset() {
        if (isNeedShowNextPresetText()) {
            showNextPresetText();
            return;
        }
        Function1<? super Boolean, Unit> function1 = this.onPresetTextIndex;
        if (function1 != null) {
            function1.invoke(false);
        }
        showOriginInputText();
    }

    private final boolean isNeedShowNextPresetText() {
        int size = getPresetTextList().size() - 1;
        Function0<Integer> function0 = this.currentPresetTextIndex;
        return size > BdPlayerUtils.orZero(function0 != null ? function0.invoke() : null);
    }

    public void setBarrageInputInfo(BottomBarModel bottomBarModel, int curPresetInputIndex) {
        BottomBarrageInputModel barrageInputModel = bottomBarModel != null ? bottomBarModel.getBarrageInputModel() : null;
        if (barrageInputModel != null) {
            setPresetTextList(barrageInputModel.getBarrageInputPreTextList());
            setSendButtonStyle(barrageInputModel.getBarrageButtonStyle());
            setSendButtonText(barrageInputModel.getBarrageButtonText());
        }
    }

    /* JADX WARNING: type inference failed for: r6v6, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean updateCommentInputLayout(android.view.ViewGroup r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.baidu.searchbox.toolbar.CommentInputLayout
            r1 = 0
            if (r0 == 0) goto L_0x0009
            r0 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r0 = (com.baidu.searchbox.toolbar.CommentInputLayout) r0
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            r2 = 0
            if (r0 == 0) goto L_0x0103
            r3 = 0
            r4 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r4 = (com.baidu.searchbox.toolbar.CommentInputLayout) r4
            r9.commentInputLayout = r4
            java.util.List r4 = r9.getPresetTextList()
            int r4 = r4.size()
            if (r4 > 0) goto L_0x001e
            return r2
        L_0x001e:
            android.widget.TextView r4 = r9.getInputView()
            if (r4 == 0) goto L_0x0029
            java.lang.CharSequence r4 = r4.getText()
            goto L_0x002a
        L_0x0029:
            r4 = r1
        L_0x002a:
            r9.commentInputDefaultText = r4
            r4 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r4 = (com.baidu.searchbox.toolbar.CommentInputLayout) r4
            com.baidu.searchbox.toolbar.SelectorImageView r4 = r4.getCommentEmojiIcon()
            int r4 = r4.getVisibility()
            if (r4 == 0) goto L_0x0054
            r4 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r4 = (com.baidu.searchbox.toolbar.CommentInputLayout) r4
            com.baidu.searchbox.toolbar.SelectorImageView r4 = r4.getCommentEmojiIcon1()
            int r4 = r4.getVisibility()
            if (r4 == 0) goto L_0x0054
            r4 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r4 = (com.baidu.searchbox.toolbar.CommentInputLayout) r4
            com.baidu.searchbox.toolbar.SelectorImageView r4 = r4.getCommentEmojiIcon2()
            int r4 = r4.getVisibility()
            if (r4 == 0) goto L_0x0054
            return r2
        L_0x0054:
            r2 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r2 = (com.baidu.searchbox.toolbar.CommentInputLayout) r2
            com.baidu.searchbox.toolbar.SelectorImageView r2 = r2.getCommentEmojiIcon()
            r4 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r4 = (com.baidu.searchbox.toolbar.CommentInputLayout) r4
            com.baidu.searchbox.toolbar.SelectorImageView r4 = r4.getCommentEmojiIcon1()
            r5 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r5 = (com.baidu.searchbox.toolbar.CommentInputLayout) r5
            com.baidu.searchbox.toolbar.SelectorImageView r5 = r5.getCommentEmojiIcon2()
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            r6.removeAllViews()
            int r6 = r5.getVisibility()
            if (r6 != 0) goto L_0x0086
            r6 = r5
            android.view.View r6 = (android.view.View) r6
            com.baidu.searchbox.player.utils.BdPlayerUtils.removeViewFromParent(r6)
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            r7 = r5
            android.view.View r7 = (android.view.View) r7
            r6.addView(r7)
        L_0x0086:
            int r6 = r4.getVisibility()
            if (r6 != 0) goto L_0x009c
            r6 = r4
            android.view.View r6 = (android.view.View) r6
            com.baidu.searchbox.player.utils.BdPlayerUtils.removeViewFromParent(r6)
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            r7 = r4
            android.view.View r7 = (android.view.View) r7
            r6.addView(r7)
        L_0x009c:
            int r6 = r2.getVisibility()
            if (r6 != 0) goto L_0x00b2
            r6 = r2
            android.view.View r6 = (android.view.View) r6
            com.baidu.searchbox.player.utils.BdPlayerUtils.removeViewFromParent(r6)
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            r7 = r2
            android.view.View r7 = (android.view.View) r7
            r6.addView(r7)
        L_0x00b2:
            android.widget.RelativeLayout r6 = r9.getEmojiAndSendBtnContainer()
            r6.removeAllViews()
            r9.addSendButton()
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            boolean r7 = r6 instanceof android.widget.RelativeLayout.LayoutParams
            if (r7 == 0) goto L_0x00cb
            r1 = r6
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1
        L_0x00cb:
            if (r1 == 0) goto L_0x00d6
            r6 = 0
            r7 = 15
            r8 = -1
            r1.addRule(r7, r8)
        L_0x00d6:
            android.widget.LinearLayout r1 = r9.getEmojiContainer()
            android.view.View r1 = (android.view.View) r1
            com.baidu.searchbox.player.utils.BdPlayerUtils.removeViewFromParent(r1)
            android.widget.RelativeLayout r1 = r9.getEmojiAndSendBtnContainer()
            android.widget.LinearLayout r6 = r9.getEmojiContainer()
            android.view.View r6 = (android.view.View) r6
            r1.addView(r6)
            android.widget.RelativeLayout r1 = r9.getEmojiAndSendBtnContainer()
            android.view.View r1 = (android.view.View) r1
            com.baidu.searchbox.player.utils.BdPlayerUtils.removeViewFromParent(r1)
            r1 = r10
            com.baidu.searchbox.toolbar.CommentInputLayout r1 = (com.baidu.searchbox.toolbar.CommentInputLayout) r1
            android.widget.RelativeLayout r6 = r9.getEmojiAndSendBtnContainer()
            android.view.View r6 = (android.view.View) r6
            r1.addView(r6)
            r1 = 1
            return r1
        L_0x0103:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.bottom.barrage.BottomCommentInteractManager.updateCommentInputLayout(android.view.ViewGroup):boolean");
    }

    /* access modifiers changed from: protected */
    public void addSendButton() {
        TextView $this$addSendButton_u24lambda_u2d3 = getSendButton();
        $this$addSendButton_u24lambda_u2d3.setBackgroundResource(getSendButtonStyle().getBackground());
        $this$addSendButton_u24lambda_u2d3.setTextColor(getSendButtonStyle().getTextColor());
        ViewGroup.LayoutParams layoutParams = $this$addSendButton_u24lambda_u2d3.getLayoutParams();
        RelativeLayout.LayoutParams $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if ($this$addSendButton_u24lambda_u2d3_u24lambda_u2d2 != null) {
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.width = getSendButtonStyle().getWidth();
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.height = getSendButtonStyle().getHeight();
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.rightMargin = getSendButtonStyle().getRightMargin();
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.topMargin = getSendButtonStyle().getVerticalMargin();
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.bottomMargin = getSendButtonStyle().getVerticalMargin();
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.addRule(7, R.id.video_flow_cmp_bottom_comment_emoji);
            $this$addSendButton_u24lambda_u2d3_u24lambda_u2d2.addRule(15, -1);
        }
        BdPlayerUtils.removeViewFromParent(getSendButton());
        getEmojiAndSendBtnContainer().addView(getSendButton());
    }

    public void resetCommentInputLayout() {
        TextView inputView;
        if (this.sendButtonDelegate.isInitialized()) {
            getSendButton().setVisibility(8);
            clearShowAnimator();
            resetCommentInputViewTextColor();
            getPresetTextList().clear();
            CharSequence charSequence = this.commentInputDefaultText;
            if (!(charSequence == null || StringsKt.isBlank(charSequence)) && (inputView = getInputView()) != null) {
                inputView.setText(this.commentInputDefaultText);
            }
            DIFactory.INSTANCE.post(new BottomCommentInteractManager$resetCommentInputLayout$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public final void resetCommentInputViewTextColor() {
        TextView inputView = getInputView();
        if (inputView != null) {
            inputView.setTextColor(getCommentInputViewOriginTextColor());
        }
    }

    private final void updateCommentInputViewTextColor(TextView inputView) {
        if (inputView != null) {
            inputView.setTextColor(ContextCompat.getColor(this.context, R.color.video_flow_barrage_input_pre_text_color));
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout createInteractRootContainer() {
        RelativeLayout relativeLayout = new RelativeLayout(this.context);
        RelativeLayout $this$createInteractRootContainer_u24lambda_u2d4 = relativeLayout;
        $this$createInteractRootContainer_u24lambda_u2d4.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        $this$createInteractRootContainer_u24lambda_u2d4.setId(R.id.video_flow_cmp_bottom_comment_barrage_send);
        return relativeLayout;
    }

    /* access modifiers changed from: protected */
    public LinearLayout createEmojiContainer() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        LinearLayout $this$createEmojiContainer_u24lambda_u2d5 = linearLayout;
        $this$createEmojiContainer_u24lambda_u2d5.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        $this$createEmojiContainer_u24lambda_u2d5.setId(R.id.video_flow_cmp_bottom_comment_emoji);
        $this$createEmojiContainer_u24lambda_u2d5.setOrientation(0);
        return linearLayout;
    }

    /* access modifiers changed from: private */
    public final TextView createSendButton() {
        SelectorTextView selectorTextView = new SelectorTextView(this.context);
        SelectorTextView $this$createSendButton_u24lambda_u2d6 = selectorTextView;
        $this$createSendButton_u24lambda_u2d6.setLayoutParams(new RelativeLayout.LayoutParams(BdPlayerUtils.dp2px($this$createSendButton_u24lambda_u2d6, DP_59), BdPlayerUtils.dp2px($this$createSendButton_u24lambda_u2d6, DP_29)));
        $this$createSendButton_u24lambda_u2d6.setId(R.id.video_flow_cmp_bottom_comment_send);
        $this$createSendButton_u24lambda_u2d6.setGravity(17);
        $this$createSendButton_u24lambda_u2d6.setText($this$createSendButton_u24lambda_u2d6.getContext().getResources().getString(R.string.video_flow_bottom_input_barrage_send));
        $this$createSendButton_u24lambda_u2d6.setTypeface(Typeface.DEFAULT_BOLD);
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$createSendButton_u24lambda_u2d6, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        $this$createSendButton_u24lambda_u2d6.setVisibility(8);
        return selectorTextView;
    }

    /* access modifiers changed from: private */
    public final TextView createInputTextView() {
        TextView textView = new TextView(this.context);
        TextView $this$createInputTextView_u24lambda_u2d7 = textView;
        $this$createInputTextView_u24lambda_u2d7.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        $this$createInputTextView_u24lambda_u2d7.setSingleLine(true);
        $this$createInputTextView_u24lambda_u2d7.setEllipsize(TextUtils.TruncateAt.END);
        $this$createInputTextView_u24lambda_u2d7.setGravity(16);
        FontSizeHelperKt.setVideoScaledSizeRes$default($this$createInputTextView_u24lambda_u2d7, R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
        $this$createInputTextView_u24lambda_u2d7.setTextColor(ContextCompat.getColor($this$createInputTextView_u24lambda_u2d7.getContext(), R.color.video_flow_barrage_input_pre_text_color));
        $this$createInputTextView_u24lambda_u2d7.setVisibility(8);
        return textView;
    }

    private final void setSendButtonText(String text) {
        getSendButton().setText(text != null ? text : this.context.getResources().getString(R.string.video_flow_bottom_input_barrage_send));
    }

    private final void setSendButtonStyle(int styleType) {
        switch (styleType) {
            case 1:
                setSendButtonStyle(ButtonStyleType.FEED_LIGHT);
                return;
            case 2:
                setSendButtonStyle(ButtonStyleType.FEED_DARK);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void setSendButtonStyle(ButtonStyleType styleType) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        switch (WhenMappings.$EnumSwitchMapping$0[styleType.ordinal()]) {
            case 1:
                BarrageSendButtonStyle $this$setSendButtonStyle_u24lambda_u2d8 = getSendButtonStyle();
                $this$setSendButtonStyle_u24lambda_u2d8.setWidth(ViewUtil.dp2px(DP_59));
                $this$setSendButtonStyle_u24lambda_u2d8.setHeight(-1);
                $this$setSendButtonStyle_u24lambda_u2d8.setTextColor(ContextCompat.getColor(this.context, R.color.video_flow_barrage_send_dark_text_color));
                $this$setSendButtonStyle_u24lambda_u2d8.setBackground(R.drawable.video_flow_bottom_barrage_send_dark_bg);
                $this$setSendButtonStyle_u24lambda_u2d8.setRightMargin(0);
                $this$setSendButtonStyle_u24lambda_u2d8.setVerticalMargin(0);
                return;
            case 2:
                BarrageSendButtonStyle $this$setSendButtonStyle_u24lambda_u2d9 = getSendButtonStyle();
                $this$setSendButtonStyle_u24lambda_u2d9.setWidth(ViewUtil.dp2px(DP_54));
                $this$setSendButtonStyle_u24lambda_u2d9.setHeight(-1);
                $this$setSendButtonStyle_u24lambda_u2d9.setTextColor(ContextCompat.getColor(this.context, R.color.video_flow_barrage_send_light_text_color));
                $this$setSendButtonStyle_u24lambda_u2d9.setBackground(R.drawable.video_flow_bottom_barrage_send_light_bg);
                $this$setSendButtonStyle_u24lambda_u2d9.setRightMargin(ViewUtil.dp2px(3.0f));
                $this$setSendButtonStyle_u24lambda_u2d9.setVerticalMargin(ViewUtil.dp2px(3.0f));
                return;
            case 3:
                BarrageSendButtonStyle $this$setSendButtonStyle_u24lambda_u2d10 = getSendButtonStyle();
                $this$setSendButtonStyle_u24lambda_u2d10.setWidth(ViewUtil.dp2px(DP_75));
                $this$setSendButtonStyle_u24lambda_u2d10.setHeight(-1);
                $this$setSendButtonStyle_u24lambda_u2d10.setTextColor(ContextCompat.getColor(this.context, R.color.video_flow_barrage_send_dark_text_color));
                $this$setSendButtonStyle_u24lambda_u2d10.setBackground(R.drawable.video_flow_bottom_barrage_landscape_send_bg);
                $this$setSendButtonStyle_u24lambda_u2d10.setRightMargin(0);
                $this$setSendButtonStyle_u24lambda_u2d10.setVerticalMargin(0);
                return;
            default:
                return;
        }
    }

    public static /* synthetic */ void showSendButton$default(BottomCommentInteractManager bottomCommentInteractManager, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = true;
            }
            bottomCommentInteractManager.showSendButton(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSendButton");
    }

    public void showSendButton(boolean withAnimator) {
        updateInputResetText();
        Function1<? super Boolean, Unit> function1 = this.onPresetTextIndex;
        if (function1 != null) {
            function1.invoke(true);
        }
        if (withAnimator) {
            clearShowAnimator();
            getSendButton().setVisibility(0);
            AnimatorSet sendBtnAnimator = buildSendButtonAnimator$default(this, getSendButton(), 0, 1, (Object) null);
            forEachEmojiView(new BottomCommentInteractManager$showSendButton$1(this));
            AnimatorSet showAnimatorSet = getShowAnimatorSet();
            AnimatorSet $this$showSendButton_u24lambda_u2d11 = showAnimatorSet;
            if (isInputTextUpAnimatorEnabled()) {
                SpreadBuilder spreadBuilder = new SpreadBuilder(3);
                spreadBuilder.add(sendBtnAnimator);
                Object[] array = this.emojiListAnimator.toArray(new ObjectAnimator[0]);
                if (array != null) {
                    spreadBuilder.addSpread(array);
                    spreadBuilder.add(getTranslateTextAnimator());
                    $this$showSendButton_u24lambda_u2d11.playTogether((Animator[]) spreadBuilder.toArray(new Animator[spreadBuilder.size()]));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            } else {
                SpreadBuilder spreadBuilder2 = new SpreadBuilder(2);
                spreadBuilder2.add(sendBtnAnimator);
                Object[] array2 = this.emojiListAnimator.toArray(new ObjectAnimator[0]);
                if (array2 != null) {
                    spreadBuilder2.addSpread(array2);
                    $this$showSendButton_u24lambda_u2d11.playTogether((Animator[]) spreadBuilder2.toArray(new Animator[spreadBuilder2.size()]));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            }
            $this$showSendButton_u24lambda_u2d11.addListener(new BottomCommentInteractManager$showSendButton$2$1(this));
            showAnimatorSet.start();
        } else {
            clearShowAnimator();
            getSendButton().setVisibility(0);
        }
        Function1<? super Unit, Unit> function12 = this.onBarrageSendButtonShow;
        if (function12 != null) {
            function12.invoke(Unit.INSTANCE);
        }
    }

    /* access modifiers changed from: protected */
    public void onShowSendButtonAnimationEnd() {
        TextView $this$onShowSendButtonAnimationEnd_u24lambda_u2d12;
        if (isInputTextUpAnimatorEnabled() && ($this$onShowSendButtonAnimationEnd_u24lambda_u2d12 = getInputView()) != null) {
            updateCommentInputViewTextColor($this$onShowSendButtonAnimationEnd_u24lambda_u2d12);
            $this$onShowSendButtonAnimationEnd_u24lambda_u2d12.setText(getTranslateTextView().getText());
            getTranslateTextView().setVisibility(8);
            $this$onShowSendButtonAnimationEnd_u24lambda_u2d12.setTranslationY(0.0f);
            $this$onShowSendButtonAnimationEnd_u24lambda_u2d12.setAlpha(1.0f);
        }
    }

    /* access modifiers changed from: protected */
    public TextView getInputView() {
        CommentInputLayout commentInputLayout2 = this.commentInputLayout;
        return commentInputLayout2 != null ? commentInputLayout2.getCommentInputView() : null;
    }

    private final void showNextPresetText() {
        TextView inputView = getInputView();
        if (inputView != null) {
            Function1<? super Boolean, Unit> function1 = this.onPresetTextIndex;
            if (function1 != null) {
                function1.invoke(false);
            }
            inputView.clearAnimation();
            ObjectAnimator $this$showNextPresetText_u24lambda_u2d14_u24lambda_u2d13 = buildAlphaAnimator(inputView, 160, 1.0f, 0.0f);
            $this$showNextPresetText_u24lambda_u2d14_u24lambda_u2d13.addListener(new BottomCommentInteractManager$showNextPresetText$1$1$1(this, inputView));
            $this$showNextPresetText_u24lambda_u2d14_u24lambda_u2d13.start();
        }
    }

    private final boolean isDefaultText() {
        String str;
        try {
            char[] chars = Character.toChars(128072);
            Intrinsics.checkNotNullExpressionValue(chars, "toChars(0X1F448)");
            str = new String(chars);
        } catch (Exception e2) {
            str = BottomBarComponentKt.HINT_TEXT_PREFIX;
        }
        String emoji = str;
        String barragePlaceholderTypeSwitcher = DIFactory.INSTANCE.getConfig().getBarragePlaceholderTypeSwitcher();
        if (Intrinsics.areEqual((Object) barragePlaceholderTypeSwitcher, (Object) "2")) {
            return Intrinsics.areEqual((Object) String.valueOf(this.commentInputDefaultText), (Object) BottomBarComponentKt.HINT_TEXT_PREFIX + this.hintTextWithEmoji);
        }
        if (Intrinsics.areEqual((Object) barragePlaceholderTypeSwitcher, (Object) "1")) {
            return Intrinsics.areEqual((Object) String.valueOf(this.commentInputDefaultText), (Object) emoji + ' ' + this.hintTextWithEmoji);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void showOriginInputText() {
        CharSequence charSequence = this.commentInputDefaultText;
        if (charSequence != null) {
            CharSequence charSequence2 = charSequence;
            if (!(!isDefaultText())) {
                charSequence = null;
            }
            if (charSequence == null) {
                charSequence = this.barrageTips;
            }
            this.commentInputDefaultText = charSequence;
            getTranslateTextView().setText(this.commentInputDefaultText);
            getTranslateTextView().setTextColor(getCommentInputViewOriginTextColor());
        }
        clearShowAnimator();
        AnimatorSet sendBtnAnimator = buildSendButtonAnimator(getSendButton(), 240);
        sendBtnAnimator.setInterpolator(getReverseInterpolator());
        forEachEmojiView(new BottomCommentInteractManager$showOriginInputText$2(this));
        AnimatorSet showAnimatorSet = getShowAnimatorSet();
        AnimatorSet $this$showOriginInputText_u24lambda_u2d17 = showAnimatorSet;
        SpreadBuilder spreadBuilder = new SpreadBuilder(3);
        spreadBuilder.add(sendBtnAnimator);
        Object[] array = this.emojiListAnimator.toArray(new ObjectAnimator[0]);
        if (array != null) {
            spreadBuilder.addSpread(array);
            spreadBuilder.add(getTranslateTextAnimator());
            $this$showOriginInputText_u24lambda_u2d17.playTogether((Animator[]) spreadBuilder.toArray(new Animator[spreadBuilder.size()]));
            $this$showOriginInputText_u24lambda_u2d17.addListener(new BottomCommentInteractManager$showOriginInputText$3$1(this));
            showAnimatorSet.start();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final void forEachEmojiView(Function1<? super View, Unit> forChild) {
        int childCount = getEmojiContainer().getChildCount();
        for (int index = 0; index < childCount; index++) {
            View childAt = getEmojiContainer().getChildAt(index);
            Intrinsics.checkNotNullExpressionValue(childAt, "emojiContainer.getChildAt(index)");
            forChild.invoke(childAt);
        }
    }

    public final void setSendButtonVisibility(int visibility) {
        if (this.sendButtonDelegate.isInitialized()) {
            getSendButton().setVisibility(visibility);
            clearShowAnimator();
        }
    }

    public final boolean isSendButtonShowing() {
        if (!this.sendButtonDelegate.isInitialized() || getSendButton().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public final boolean isEmojiContainerShowing() {
        return (getEmojiContainer().getVisibility() != 0 || getEmojiContainer().getParent() == null || getEmojiContainer().getChildCount() == 0) ? false : true;
    }

    public void clearShowAnimator() {
        getShowAnimatorSet().removeAllListeners();
        getShowAnimatorSet().cancel();
        TextView inputView = getInputView();
        if (inputView != null) {
            inputView.clearAnimation();
        }
    }

    public final void setPresetTextList(ArrayList<String> textList) {
        getPresetTextList().clear();
        if (textList != null && textList.size() > 0) {
            getPresetTextList().addAll(textList);
        }
    }

    public void updateInputResetText() {
        TextView inputView;
        Function0<Integer> function0 = this.currentPresetTextIndex;
        int curPresetIndex = VideoFlowUtilsKt.exclude(function0 != null ? function0.invoke() : null, (Number) -1, (Number) 0).intValue();
        if (curPresetIndex < getPresetTextList().size()) {
            String currentPresetText = getPresetTextList().get(curPresetIndex);
            getTranslateTextView().setText(currentPresetText);
            if (curPresetIndex > 0 && (inputView = getInputView()) != null) {
                inputView.setText(currentPresetText);
            }
            Function1<? super String, Unit> function1 = this.onBarragePresetTextShow;
            if (function1 != null) {
                function1.invoke(currentPresetText);
            }
        } else if (getSendButton().getVisibility() == 0) {
            showOriginInputText();
        }
    }

    public final String getInputResetText() {
        Function0<Integer> function0 = this.currentPresetTextIndex;
        int curPresetIndex = VideoFlowUtilsKt.exclude(function0 != null ? function0.invoke() : null, (Number) -1, (Number) 0).intValue();
        if (curPresetIndex < getPresetTextList().size()) {
            return getPresetTextList().get(curPresetIndex);
        }
        return "";
    }

    private final String popPresetText() {
        if (getPresetTextList().isEmpty()) {
            return "";
        }
        Function1<? super Boolean, Unit> function1 = this.onPresetTextIndex;
        if (function1 != null) {
            function1.invoke(false);
        }
        return (String) CollectionsKt.removeFirst(getPresetTextList());
    }

    private final boolean isInputTextUpAnimatorEnabled() {
        return true;
    }

    private final AnimatorSet getTranslateTextAnimator() {
        getTranslateInputTextAnimator().cancel();
        TextView inputTextView = getInputView();
        if (inputTextView == null) {
            return getTranslateInputTextAnimator();
        }
        float offsetY = (float) inputTextView.getMeasuredHeight();
        getTranslateTextView().setTranslationY(-offsetY);
        getTranslateTextView().setVisibility(0);
        ViewParent parent = inputTextView.getParent();
        addTranslateTextViewToParent(parent instanceof ViewGroup ? (ViewGroup) parent : null);
        ObjectAnimator scrollTextUpAnimator = buildMoveUpAnimator(getTranslateTextView(), offsetY, 0.0f);
        ObjectAnimator scrollTextAlphaAnimator = buildAlphaAnimator(getTranslateTextView(), 400, 0.0f, 1.0f);
        ObjectAnimator currentTextUpAnimator = buildMoveUpAnimator(inputTextView, 0.0f, -offsetY);
        ObjectAnimator currentTextAlphaAnimator = buildAlphaAnimator(inputTextView, 400, 1.0f, 0.0f);
        AnimatorSet $this$getTranslateTextAnimator_u24lambda_u2d19_u24lambda_u2d18 = getTranslateInputTextAnimator();
        $this$getTranslateTextAnimator_u24lambda_u2d19_u24lambda_u2d18.playTogether(new Animator[]{scrollTextUpAnimator, scrollTextAlphaAnimator, currentTextUpAnimator, currentTextAlphaAnimator});
        return $this$getTranslateTextAnimator_u24lambda_u2d19_u24lambda_u2d18;
    }

    /* access modifiers changed from: protected */
    public void addTranslateTextViewToParent(ViewGroup viewGroup) {
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup;
            ViewGroup $this$addTranslateTextViewToParent_u24lambda_u2d21 = getTranslateTextView().getParent() == null ? viewGroup : null;
            if ($this$addTranslateTextViewToParent_u24lambda_u2d21 != null) {
                BdPlayerUtils.removeViewFromParent(getTranslateTextView());
                $this$addTranslateTextViewToParent_u24lambda_u2d21.addView(getTranslateTextView());
            }
        }
    }

    static /* synthetic */ AnimatorSet buildSendButtonAnimator$default(BottomCommentInteractManager bottomCommentInteractManager, View view2, long j2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                j2 = 480;
            }
            return bottomCommentInteractManager.buildSendButtonAnimator(view2, j2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildSendButtonAnimator");
    }

    private final AnimatorSet buildSendButtonAnimator(View $this$buildSendButtonAnimator, long alphaDuration) {
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat($this$buildSendButtonAnimator, "scaleX", new float[]{0.5f, 1.0f});
        scaleXAnimator.setDuration(240);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat($this$buildSendButtonAnimator, "scaleY", new float[]{0.5f, 1.0f});
        scaleYAnimator.setDuration(240);
        ObjectAnimator alphaAnimator = buildAlphaAnimator($this$buildSendButtonAnimator, 480, 0.0f, 1.0f);
        AnimatorSet $this$buildSendButtonAnimator_u24lambda_u2d24 = new AnimatorSet();
        $this$buildSendButtonAnimator_u24lambda_u2d24.playTogether(new Animator[]{scaleXAnimator, scaleYAnimator, alphaAnimator});
        return $this$buildSendButtonAnimator_u24lambda_u2d24;
    }

    /* access modifiers changed from: private */
    public final ObjectAnimator buildEmojiAnimator(View $this$buildEmojiAnimator) {
        return buildAlphaAnimator($this$buildEmojiAnimator, 160, 1.0f, 0.0f);
    }

    private final ObjectAnimator buildMoveUpAnimator(View $this$buildMoveUpAnimator, float... values) {
        ObjectAnimator $this$buildMoveUpAnimator_u24lambda_u2d25 = ObjectAnimator.ofFloat($this$buildMoveUpAnimator, NewTimerConstants.NEWTIMER_ANIMATION_TRANSLATIONY, Arrays.copyOf(values, values.length));
        $this$buildMoveUpAnimator_u24lambda_u2d25.setDuration(400);
        Intrinsics.checkNotNullExpressionValue($this$buildMoveUpAnimator_u24lambda_u2d25, "ofFloat(this, \"translati… = DURATION_400\n        }");
        return $this$buildMoveUpAnimator_u24lambda_u2d25;
    }

    /* access modifiers changed from: private */
    public final ObjectAnimator buildAlphaAnimator(View $this$buildAlphaAnimator, long durationMills, float... values) {
        ObjectAnimator $this$buildAlphaAnimator_u24lambda_u2d26 = ObjectAnimator.ofFloat($this$buildAlphaAnimator, "alpha", Arrays.copyOf(values, values.length));
        $this$buildAlphaAnimator_u24lambda_u2d26.setDuration(durationMills);
        Intrinsics.checkNotNullExpressionValue($this$buildAlphaAnimator_u24lambda_u2d26, "ofFloat(this, \"alpha\", *…= durationMills\n        }");
        return $this$buildAlphaAnimator_u24lambda_u2d26;
    }

    public final void onFontSizeChange() {
        if (this.sendButtonDelegate.isInitialized()) {
            FontSizeHelperKt.setVideoScaledSizeRes$default(getSendButton(), R.dimen.video_flow_dimens_12dp, 0, 0, 6, (Object) null);
            getSendButton().setBackground(FontSizeHelperKt.getVideoScaledDrawableRes$default(getSendButtonStyle().getBackground(), 0, 0, 6, (Object) null));
        }
    }

    static /* synthetic */ void transferChildrenToTargetContainer$default(BottomCommentInteractManager bottomCommentInteractManager, ViewGroup viewGroup, ViewGroup viewGroup2, Function1 function1, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                function1 = null;
            }
            bottomCommentInteractManager.transferChildrenToTargetContainer(viewGroup, viewGroup2, function1);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transferChildrenToTargetContainer");
    }

    /* access modifiers changed from: private */
    public final void transferChildrenToTargetContainer(ViewGroup $this$transferChildrenToTargetContainer, ViewGroup arrivalContainer, Function1<? super View, Unit> forChild) {
        while ($this$transferChildrenToTargetContainer.getChildCount() > 0) {
            View child = $this$transferChildrenToTargetContainer.getChildAt(0);
            Intrinsics.checkNotNullExpressionValue(child, "getChildAt(0)");
            $this$transferChildrenToTargetContainer.removeViewAt(0);
            arrivalContainer.addView(child);
            if (forChild != null) {
                forChild.invoke(child);
            }
        }
    }
}
