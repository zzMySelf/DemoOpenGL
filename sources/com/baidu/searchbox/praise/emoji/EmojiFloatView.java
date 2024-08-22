package com.baidu.searchbox.praise.emoji;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.parise.R;
import com.baidu.searchbox.praise.emoji.data.EmojiInfo;
import com.baidu.searchbox.praise.emoji.data.LikeEmojiData;
import com.baidu.searchbox.praise.emoji.data.LikeEmojiDataKt;
import com.baidu.searchbox.praise.emoji.interfaces.IEmojiFloatView;
import com.baidu.searchbox.praise.emoji.tools.BlackBlurBg;
import com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView;
import com.baidu.searchbox.praise.emojiinterface.EmojiWidgetEvent;
import com.baidu.searchbox.praise.interpolator.BezierInterpolator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002*\u0002(+\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010A\u001a\u00020\u0014H\u0002J\b\u0010B\u001a\u00020\u0014H\u0016J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u0014H\u0002J\b\u0010F\u001a\u00020@H\u0002J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\u0014H\u0002J\b\u0010J\u001a\u00020\u0014H\u0002J\u0010\u0010K\u001a\u00020\u00142\u0006\u0010L\u001a\u00020MH\u0016J\u0010\u0010N\u001a\u00020\u00142\u0006\u0010O\u001a\u00020@H\u0016J\b\u0010P\u001a\u00020\u0014H\u0002J\u0018\u0010Q\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020SH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR9\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001cX.¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u0004¢\u0006\u0004\n\u0002\u0010,R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020:X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/baidu/searchbox/praise/emoji/EmojiFloatView;", "Lcom/baidu/searchbox/praise/emoji/interfaces/IEmojiFloatView;", "startPos", "", "endPos", "btnPos", "([I[I[I)V", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "emojiClickListener", "Lkotlin/Function1;", "Lcom/baidu/searchbox/praise/emoji/data/EmojiInfo;", "Lkotlin/ParameterName;", "name", "info", "", "getEmojiClickListener", "()Lkotlin/jvm/functions/Function1;", "setEmojiClickListener", "(Lkotlin/jvm/functions/Function1;)V", "emojiContent", "Landroid/widget/LinearLayout;", "emojiInfo", "", "emojiViewList", "Lcom/baidu/searchbox/praise/emoji/widget/AnimationEmojiView;", "floatViewDismissListener", "Lkotlin/Function0;", "getFloatViewDismissListener", "()Lkotlin/jvm/functions/Function0;", "setFloatViewDismissListener", "(Lkotlin/jvm/functions/Function0;)V", "mDecorView", "Landroid/view/ViewGroup;", "onEmojiClickListener", "com/baidu/searchbox/praise/emoji/EmojiFloatView$onEmojiClickListener$1", "Lcom/baidu/searchbox/praise/emoji/EmojiFloatView$onEmojiClickListener$1;", "onIEmojiAnimationEndListener", "com/baidu/searchbox/praise/emoji/EmojiFloatView$onIEmojiAnimationEndListener$1", "Lcom/baidu/searchbox/praise/emoji/EmojiFloatView$onIEmojiAnimationEndListener$1;", "popupBackground", "Landroid/widget/ImageView;", "getPopupBackground", "()Landroid/widget/ImageView;", "setPopupBackground", "(Landroid/widget/ImageView;)V", "popupContent", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getPopupContent", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setPopupContent", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "root", "Landroid/widget/FrameLayout;", "getRoot", "()Landroid/widget/FrameLayout;", "setRoot", "(Landroid/widget/FrameLayout;)V", "rootView", "Landroid/view/View;", "dismissAnimation", "dismissWidget", "getBezierInterpolator", "Lcom/baidu/searchbox/praise/interpolator/BezierInterpolator;", "inflateViewByData", "initView", "isShow", "", "onDismiss", "registerEvent", "setData", "emojiData", "Lcom/baidu/searchbox/praise/emoji/data/LikeEmojiData;", "showAtLocation", "view", "showPanelAnimation", "updateUi", "width", "", "height", "lib-praise-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EmojiFloatView.kt */
public final class EmojiFloatView implements IEmojiFloatView {
    private int[] btnPos;
    private final Lazy context$delegate = LazyKt.lazy(EmojiFloatView$context$2.INSTANCE);
    private Function1<? super EmojiInfo, Unit> emojiClickListener;
    private LinearLayout emojiContent;
    private List<EmojiInfo> emojiInfo;
    /* access modifiers changed from: private */
    public List<AnimationEmojiView> emojiViewList = new ArrayList();
    /* access modifiers changed from: private */
    public int[] endPos;
    private Function0<Unit> floatViewDismissListener;
    private ViewGroup mDecorView;
    private final EmojiFloatView$onEmojiClickListener$1 onEmojiClickListener = new EmojiFloatView$onEmojiClickListener$1(this);
    /* access modifiers changed from: private */
    public final EmojiFloatView$onIEmojiAnimationEndListener$1 onIEmojiAnimationEndListener = new EmojiFloatView$onIEmojiAnimationEndListener$1();
    public ImageView popupBackground;
    public ConstraintLayout popupContent;
    public FrameLayout root;
    private View rootView;
    /* access modifiers changed from: private */
    public int[] startPos;

    public EmojiFloatView(int[] startPos2, int[] endPos2, int[] btnPos2) {
        Intrinsics.checkNotNullParameter(startPos2, "startPos");
        Intrinsics.checkNotNullParameter(endPos2, "endPos");
        Intrinsics.checkNotNullParameter(btnPos2, "btnPos");
        this.startPos = startPos2;
        this.endPos = endPos2;
        this.btnPos = btnPos2;
    }

    public final ConstraintLayout getPopupContent() {
        ConstraintLayout constraintLayout = this.popupContent;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("popupContent");
        return null;
    }

    public final void setPopupContent(ConstraintLayout constraintLayout) {
        Intrinsics.checkNotNullParameter(constraintLayout, "<set-?>");
        this.popupContent = constraintLayout;
    }

    public final ImageView getPopupBackground() {
        ImageView imageView = this.popupBackground;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("popupBackground");
        return null;
    }

    public final void setPopupBackground(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.popupBackground = imageView;
    }

    public final FrameLayout getRoot() {
        FrameLayout frameLayout = this.root;
        if (frameLayout != null) {
            return frameLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    public final void setRoot(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.root = frameLayout;
    }

    public Function1<EmojiInfo, Unit> getEmojiClickListener() {
        return this.emojiClickListener;
    }

    public void setEmojiClickListener(Function1<? super EmojiInfo, Unit> function1) {
        this.emojiClickListener = function1;
    }

    public Function0<Unit> getFloatViewDismissListener() {
        return this.floatViewDismissListener;
    }

    public void setFloatViewDismissListener(Function0<Unit> function0) {
        this.floatViewDismissListener = function0;
    }

    private final Context getContext() {
        return (Context) this.context$delegate.getValue();
    }

    private final View initView() {
        setRoot(new FrameLayout(getContext()));
        getRoot().setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        getRoot().setOnClickListener(new EmojiFloatView$$ExternalSyntheticLambda0(this));
        View $this$initView_u24lambda_u2d1 = LayoutInflater.from(getContext()).inflate(R.layout.praise_emoji_float_window_layout, getRoot(), false);
        this.rootView = $this$initView_u24lambda_u2d1;
        Intrinsics.checkNotNull($this$initView_u24lambda_u2d1);
        LinearLayout linearLayout = (LinearLayout) $this$initView_u24lambda_u2d1.findViewById(R.id.popup_emoji_content);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "popup_emoji_content");
        this.emojiContent = linearLayout;
        ConstraintLayout constraintLayout = (ConstraintLayout) $this$initView_u24lambda_u2d1.findViewById(R.id.popup_root);
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "popup_root");
        setPopupContent(constraintLayout);
        ImageView imageView = (ImageView) $this$initView_u24lambda_u2d1.findViewById(R.id.popup_bg);
        Intrinsics.checkNotNullExpressionValue(imageView, "popup_bg");
        setPopupBackground(imageView);
        Ref.ObjectRef layoutParams = new Ref.ObjectRef();
        T layoutParams2 = getPopupContent().getLayoutParams();
        layoutParams.element = layoutParams2 instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams2 : null;
        if (layoutParams.element == null) {
            layoutParams.element = new FrameLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.like_emoji_popup_width), -2);
        }
        getPopupContent().getViewTreeObserver().addOnGlobalLayoutListener(new EmojiFloatView$initView$3(this, layoutParams));
        getRoot().addView(this.rootView);
        return getRoot();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m2482initView$lambda0(EmojiFloatView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAnimation();
    }

    private final void updateUi(int width, int height) {
        getPopupBackground().setImageDrawable(BlackBlurBg.getBlackBlurBg(width, height));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void inflateViewByData() {
        /*
            r10 = this;
            java.util.List<com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView> r0 = r10.emojiViewList
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x00a6
            android.widget.LinearLayout r0 = r10.emojiContent
            r1 = 0
            if (r0 == 0) goto L_0x0047
            java.lang.String r2 = "emojiContent"
            if (r0 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r1
        L_0x0019:
            r0.removeAllViews()
            java.util.List<com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView> r0 = r10.emojiViewList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r3 = 0
            java.util.Iterator r4 = r0.iterator()
        L_0x0025:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0047
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView r6 = (com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView) r6
            r7 = 0
            r8 = 0
            r6.setUseGlobalColorFilter(r8)
            android.widget.LinearLayout r8 = r10.emojiContent
            if (r8 != 0) goto L_0x003f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r8 = r1
        L_0x003f:
            r9 = r6
            android.view.View r9 = (android.view.View) r9
            r8.addView(r9)
            goto L_0x0025
        L_0x0047:
            androidx.constraintlayout.widget.ConstraintLayout r0 = r10.getPopupContent()
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            boolean r2 = r0 instanceof android.widget.FrameLayout.LayoutParams
            if (r2 == 0) goto L_0x0056
            r1 = r0
            android.widget.FrameLayout$LayoutParams r1 = (android.widget.FrameLayout.LayoutParams) r1
        L_0x0056:
            r0 = r1
            java.util.List<com.baidu.searchbox.praise.emoji.widget.AnimationEmojiView> r1 = r10.emojiViewList
            int r1 = r1.size()
            float r1 = (float) r1
            android.content.Context r2 = r10.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.baidu.searchbox.parise.R.dimen.emoji_view_width
            float r2 = r2.getDimension(r3)
            float r1 = r1 * r2
            android.content.Context r2 = r10.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.baidu.searchbox.parise.R.dimen.emoji_view_margin
            float r2 = r2.getDimension(r3)
            float r3 = r1 + r2
            if (r0 != 0) goto L_0x0087
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            int r5 = (int) r3
            r6 = -2
            r4.<init>(r5, r6)
            r0 = r4
        L_0x0087:
            int r4 = (int) r3
            r0.width = r4
            androidx.constraintlayout.widget.ConstraintLayout r4 = r10.getPopupContent()
            r5 = r0
            android.view.ViewGroup$LayoutParams r5 = (android.view.ViewGroup.LayoutParams) r5
            r4.setLayoutParams(r5)
            int r4 = (int) r1
            android.content.Context r5 = r10.getContext()
            android.content.res.Resources r5 = r5.getResources()
            int r6 = com.baidu.searchbox.parise.R.dimen.praise_emoji_widget_height
            int r5 = r5.getDimensionPixelOffset(r6)
            r10.updateUi(r4, r5)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.praise.emoji.EmojiFloatView.inflateViewByData():void");
    }

    private final void showPanelAnimation() {
        int count = DefaultSharedPrefsWrapper.getInstance().getInt("show_count", 0);
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        float moveLeft = getContext().getResources().getDimension(R.dimen.praise_emoji_float_widget_margin_left);
        PropertyValuesHolder transX = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{0.0f, -moveLeft});
        ObjectAnimator showAnim = ObjectAnimator.ofPropertyValuesHolder(this.rootView, new PropertyValuesHolder[]{alpha, transX});
        Intrinsics.checkNotNullExpressionValue(showAnim, "ofPropertyValuesHolder(rootView, alpha, transX)");
        showAnim.setDuration(240);
        showAnim.setStartDelay(50);
        showAnim.setInterpolator(getBezierInterpolator());
        showAnim.addListener(new EmojiFloatView$showPanelAnimation$1(this, count));
        showAnim.start();
        DefaultSharedPrefsWrapper.getInstance().putInt("show_count", count + 1);
    }

    /* access modifiers changed from: private */
    public final void dismissAnimation() {
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{1.0f, 0.0f});
        PropertyValuesHolder transX = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{0.0f, 50.0f});
        ObjectAnimator dismissAnim = ObjectAnimator.ofPropertyValuesHolder(this.rootView, new PropertyValuesHolder[]{alpha, transX});
        Intrinsics.checkNotNullExpressionValue(dismissAnim, "ofPropertyValuesHolder(rootView, alpha, transX)");
        dismissAnim.setDuration(240);
        dismissAnim.setInterpolator(getBezierInterpolator());
        dismissAnim.addListener(new EmojiFloatView$dismissAnimation$1(this));
        dismissAnim.start();
    }

    private final BezierInterpolator getBezierInterpolator() {
        return new BezierInterpolator(0.42f, 0.0f, 1.0f, 1.0f);
    }

    private final void registerEvent() {
        BdEventBus.Companion.getDefault().lazyRegister(this, EmojiWidgetEvent.class, 1, new EmojiFloatView$registerEvent$1(this));
    }

    /* access modifiers changed from: private */
    public final void onDismiss() {
        BdEventBus.Companion.getDefault().unregister(this);
        ViewGroup viewGroup = this.mDecorView;
        if (viewGroup != null) {
            viewGroup.removeView(getRoot());
        }
        Function0<Unit> floatViewDismissListener2 = getFloatViewDismissListener();
        if (floatViewDismissListener2 != null) {
            floatViewDismissListener2.invoke();
        }
    }

    public boolean isShow() {
        View view2 = this.rootView;
        return view2 != null && view2.getVisibility() == 0;
    }

    public void showAtLocation(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        if (view2 instanceof ViewGroup) {
            this.mDecorView = (ViewGroup) view2;
            initView();
            ViewGroup viewGroup = this.mDecorView;
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.removeView(getRoot());
            ViewGroup viewGroup2 = this.mDecorView;
            Intrinsics.checkNotNull(viewGroup2);
            viewGroup2.addView(getRoot());
            inflateViewByData();
            showPanelAnimation();
            registerEvent();
        }
    }

    public void dismissWidget() {
        if (isShow()) {
            onDismiss();
        }
    }

    public void setData(LikeEmojiData emojiData) {
        Intrinsics.checkNotNullParameter(emojiData, "emojiData");
        LikeEmojiData it = emojiData;
        this.emojiInfo = it.getEmojiInfo();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) getContext().getResources().getDimension(R.dimen.emoji_view_width), (int) getContext().getResources().getDimension(R.dimen.emoji_view_height));
        layoutParams.weight = 1.0f;
        long time = 0;
        List<EmojiInfo> $this$forEach$iv = this.emojiInfo;
        if ($this$forEach$iv == null) {
            Intrinsics.throwUninitializedPropertyAccessException(LikeEmojiDataKt.EMOJI_INFO);
            $this$forEach$iv = null;
        }
        for (EmojiInfo info : $this$forEach$iv) {
            LikeEmojiData it2 = it;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AnimationEmojiView emojiView = new AnimationEmojiView(context);
            emojiView.loadImage(info);
            emojiView.setDelayTime(time);
            time += 80;
            emojiView.setOnEmojiClickListener(this.onEmojiClickListener);
            emojiView.setLayoutParams(layoutParams);
            this.emojiViewList.add(emojiView);
            LikeEmojiData likeEmojiData = emojiData;
            it = it2;
        }
    }
}
