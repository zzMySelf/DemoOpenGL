package com.baidu.searchbox.feed.biserialdetail.view.floating;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.feed.biserialdetail.R;
import com.baidu.searchbox.feed.biserialdetail.model.BiSerialOpFloatingModel;
import com.baidu.searchbox.feed.biserialdetail.net.DynamicDetailRequestManager;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.feed.util.FeedRouter;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.kotlinx.ViewExtensionsKt;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010%\u001a\u00020&H\u0007J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020\rJ\u0006\u0010*\u001a\u00020&J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020&H\u0002J4\u0010-\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016J<\u0010-\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0012\u00100\u001a\u00020&2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0006\u00103\u001a\u00020&J\b\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u0014H\u0007J\u0006\u00107\u001a\u00020&J\b\u00108\u001a\u00020&H\u0002J\b\u00109\u001a\u00020&H\u0002J\b\u0010:\u001a\u00020&H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/view/floating/BiSerialOpFloatingView;", "Landroid/widget/RelativeLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "category", "", "closeImg", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "countDownTimer", "Landroid/os/CountDownTimer;", "direction", "durationMs", "", "floatingEventsCallback", "Lcom/baidu/searchbox/feed/biserialdetail/view/floating/BiSerialOpFloatingView$FloatingEventsCallback;", "floatingModel", "Lcom/baidu/searchbox/feed/biserialdetail/model/BiSerialOpFloatingModel;", "isCLickClose", "", "isFolding", "isResting", "lotteryDataChannelMgr", "Lcom/baidu/searchbox/feed/biserialdetail/view/floating/OpFloatingViewDataChannelMgr;", "nid", "opContainer", "opImg", "Lcom/baidu/searchbox/feed/template/FeedDraweeView;", "sourceFrom", "state", "beginFolding", "", "cancelCountDown", "destroy", "getFloatingViewState", "hideView", "initCountDownTimer", "initLotteryDataChannel", "initialize", "moveDirection", "countDownDurationMs", "onClick", "v", "Landroid/view/View;", "onNightModeChanged", "requestInfo", "resetFold", "duration", "startCountDown", "updateGifView", "updateImageView", "updateView", "FloatingEventsCallback", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialOpFloatingView.kt */
public final class BiSerialOpFloatingView extends RelativeLayout implements View.OnClickListener {
    /* access modifiers changed from: private */
    public String category;
    private BdBaseImageView closeImg;
    private CountDownTimer countDownTimer;
    private String direction;
    private long durationMs;
    /* access modifiers changed from: private */
    public FloatingEventsCallback floatingEventsCallback;
    /* access modifiers changed from: private */
    public BiSerialOpFloatingModel floatingModel;
    private boolean isCLickClose;
    /* access modifiers changed from: private */
    public boolean isFolding;
    /* access modifiers changed from: private */
    public boolean isResting;
    private OpFloatingViewDataChannelMgr lotteryDataChannelMgr;
    private String nid;
    private RelativeLayout opContainer;
    private FeedDraweeView opImg;
    /* access modifiers changed from: private */
    public String sourceFrom;
    private String state;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/feed/biserialdetail/view/floating/BiSerialOpFloatingView$FloatingEventsCallback;", "", "onClickWhileStateFold", "", "onInitialFail", "onInitialSuccess", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BiSerialOpFloatingView.kt */
    public interface FloatingEventsCallback {
        void onClickWhileStateFold();

        void onInitialFail();

        void onInitialSuccess();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BiSerialOpFloatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.state = BiSerialOpFloatingViewKt.STATUS_SHOWING;
        this.direction = "right";
        this.nid = "";
        this.sourceFrom = "";
        this.category = "";
        this.durationMs = 10000;
        View root = LayoutInflater.from(context).inflate(R.layout.biserial_dynamic_op_floating_view, this);
        RelativeLayout relativeLayout = null;
        this.opImg = root != null ? (FeedDraweeView) root.findViewById(R.id.op_img) : null;
        this.closeImg = root != null ? (BdBaseImageView) root.findViewById(R.id.close_img) : null;
        relativeLayout = root != null ? (RelativeLayout) root.findViewById(R.id.op_container) : relativeLayout;
        this.opContainer = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(this);
        }
        BdBaseImageView bdBaseImageView = this.closeImg;
        if (bdBaseImageView != null) {
            bdBaseImageView.setOnClickListener(this);
        }
        if (root != null) {
            ViewExtensionsKt.addPressedState(root, 0.7f);
        }
        setPadding(context.getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_10dp), 0, context.getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_10dp), 0);
        hideView();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BiSerialOpFloatingView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BiSerialOpFloatingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void initialize(String nid2, String sourceFrom2, String category2, String moveDirection, long countDownDurationMs, FloatingEventsCallback floatingEventsCallback2) {
        Intrinsics.checkNotNullParameter(moveDirection, "moveDirection");
        Intrinsics.checkNotNullParameter(floatingEventsCallback2, "floatingEventsCallback");
        this.durationMs = countDownDurationMs;
        initialize(nid2, sourceFrom2, category2, moveDirection, floatingEventsCallback2);
    }

    public final void initialize(String nid2, String sourceFrom2, String category2, String moveDirection, FloatingEventsCallback floatingEventsCallback2) {
        Intrinsics.checkNotNullParameter(moveDirection, "moveDirection");
        Intrinsics.checkNotNullParameter(floatingEventsCallback2, "floatingEventsCallback");
        CharSequence charSequence = nid2;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = sourceFrom2;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                CharSequence charSequence3 = category2;
                if (charSequence3 == null || charSequence3.length() == 0) {
                    z = true;
                }
                if (!z) {
                    this.nid = nid2;
                    this.sourceFrom = sourceFrom2;
                    this.category = category2;
                    this.direction = moveDirection;
                    this.floatingEventsCallback = floatingEventsCallback2;
                    requestInfo();
                    initCountDownTimer();
                    initLotteryDataChannel();
                }
            }
        }
    }

    private final void initLotteryDataChannel() {
        if (this.lotteryDataChannelMgr == null) {
            this.lotteryDataChannelMgr = new OpFloatingViewDataChannelMgr();
        }
        OpFloatingViewDataChannelMgr opFloatingViewDataChannelMgr = this.lotteryDataChannelMgr;
        if (opFloatingViewDataChannelMgr != null) {
            String biSerialOpFloatingView = toString();
            Intrinsics.checkNotNullExpressionValue(biSerialOpFloatingView, "this.toString()");
            opFloatingViewDataChannelMgr.registerLotteryNumChannel(biSerialOpFloatingView, new BiSerialOpFloatingView$initLotteryDataChannel$1(this));
        }
    }

    private final void requestInfo() {
        DynamicDetailRequestManager.INSTANCE.requestOpFloatingData(this.nid, this.sourceFrom, this.category, "", new BiSerialOpFloatingView$requestInfo$1(this));
    }

    private final void initCountDownTimer() {
        long j2 = this.durationMs;
        this.countDownTimer = new BiSerialOpFloatingView$initCountDownTimer$1(this, j2, j2);
    }

    public final void startCountDown() {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.start();
        }
    }

    public final void cancelCountDown() {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    public final void destroy() {
        CountDownTimer countDownTimer2 = this.countDownTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        this.countDownTimer = null;
        OpFloatingViewDataChannelMgr opFloatingViewDataChannelMgr = this.lotteryDataChannelMgr;
        if (opFloatingViewDataChannelMgr != null) {
            opFloatingViewDataChannelMgr.unregisterLotteryNumChannel();
        }
    }

    public final void hideView() {
        cancelCountDown();
        resetFold(10);
        setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updateView() {
        setVisibility(0);
        BiSerialOpFloatingModel it = this.floatingModel;
        if (it == null) {
            return;
        }
        if (it.isGif()) {
            updateGifView();
        } else {
            updateImageView();
        }
    }

    public final void onNightModeChanged() {
        if (getVisibility() == 0) {
            updateView();
        }
    }

    private final void updateGifView() {
        PipelineDraweeControllerBuilder newDraweeControllerBuilder = Fresco.newDraweeControllerBuilder();
        BiSerialOpFloatingModel biSerialOpFloatingModel = this.floatingModel;
        AbstractDraweeController draweeController = ((PipelineDraweeControllerBuilder) newDraweeControllerBuilder.setUri(biSerialOpFloatingModel != null ? biSerialOpFloatingModel.getIcon() : null).setAutoPlayAnimations(true)).build();
        FeedDraweeView feedDraweeView = this.opImg;
        if (feedDraweeView != null) {
            feedDraweeView.setController(draweeController);
        }
    }

    private final void updateImageView() {
        FeedDraweeView feedDraweeView = this.opImg;
        if (feedDraweeView != null) {
            BiSerialOpFloatingModel biSerialOpFloatingModel = this.floatingModel;
            feedDraweeView.setImageURI(biSerialOpFloatingModel != null ? biSerialOpFloatingModel.getIcon() : null);
        }
    }

    public void onClick(View v) {
        if (Intrinsics.areEqual((Object) v, (Object) this.opContainer)) {
            if (Intrinsics.areEqual((Object) this.state, (Object) "fold") && Intrinsics.areEqual((Object) this.sourceFrom, (Object) "merge_video_landing")) {
                FloatingEventsCallback floatingEventsCallback2 = this.floatingEventsCallback;
                if (floatingEventsCallback2 != null) {
                    floatingEventsCallback2.onClickWhileStateFold();
                }
                resetFold(300);
            } else if (!NetWorkUtils.isNetworkConnected()) {
                UniversalToast.makeText(getContext(), com.baidu.searchbox.feed.core.R.string.feed_update_toast_bad_net).show();
            } else {
                Context context = getContext();
                BiSerialOpFloatingModel biSerialOpFloatingModel = this.floatingModel;
                FeedRouter.invoke(context, biSerialOpFloatingModel != null ? biSerialOpFloatingModel.getCmd() : null, false);
                BiSerialOpFloatingViewStatics.INSTANCE.statistics(this.sourceFrom, BiSerialOpFloatingViewStaticsKt.UBC_FLOATING_VIEW_CLICK_TYPE, this.category);
            }
        } else if (Intrinsics.areEqual((Object) v, (Object) this.closeImg)) {
            this.isCLickClose = true;
            DynamicDetailRequestManager.INSTANCE.requestOpFloatingData(this.nid, this.sourceFrom, this.category, "close", (ResponseCallback<BiSerialOpFloatingModel>) null);
            hideView();
            BiSerialOpFloatingViewStatics.INSTANCE.statistics(this.sourceFrom, BiSerialOpFloatingViewStaticsKt.UBC_FLOATING_VIEW_CLOSE_TYPE, this.category);
        }
    }

    public final void beginFolding() {
        if (Intrinsics.areEqual((Object) this.state, (Object) BiSerialOpFloatingViewKt.STATUS_SHOWING) && getVisibility() == 0 && !this.isCLickClose) {
            if (!(this.direction.length() == 0) && !this.isFolding && !this.isResting) {
                float xDistance = (float) (getWidth() / 2);
                if (Intrinsics.areEqual((Object) this.direction, (Object) "left")) {
                    xDistance = -((float) (getWidth() / 2));
                }
                ObjectAnimator containerTransXAnim = ObjectAnimator.ofFloat(this, "translationX", new float[]{0.0f, xDistance});
                containerTransXAnim.setDuration(300);
                FeedDraweeView feedDraweeView = this.opImg;
                float[] fArr = new float[2];
                float f2 = 1.0f;
                fArr[0] = 1.0f;
                if (Intrinsics.areEqual((Object) this.sourceFrom, (Object) "dt_landing")) {
                    f2 = 0.7f;
                }
                fArr[1] = f2;
                ObjectAnimator imageAlphaAnim = ObjectAnimator.ofFloat(feedDraweeView, "alpha", fArr);
                imageAlphaAnim.setDuration(300);
                ObjectAnimator closeImgAlphaAnim = ObjectAnimator.ofFloat(this.closeImg, "alpha", new float[]{1.0f, 0.0f});
                closeImgAlphaAnim.setDuration(300);
                AnimatorSet imageAnimSet = new AnimatorSet();
                imageAnimSet.playTogether(new Animator[]{containerTransXAnim, imageAlphaAnim, closeImgAlphaAnim});
                imageAnimSet.start();
                this.state = "fold";
                imageAnimSet.addListener(new BiSerialOpFloatingView$beginFolding$1(this));
            }
        }
    }

    public final void resetFold(long duration) {
        if (Intrinsics.areEqual((Object) this.state, (Object) "fold") && ((int) getTranslationX()) != 0 && !this.isFolding && !this.isResting) {
            ObjectAnimator containerTransXAnim = ObjectAnimator.ofFloat(this, "translationX", new float[]{getTranslationX(), 0.0f});
            containerTransXAnim.setDuration(duration);
            FeedDraweeView feedDraweeView = this.opImg;
            float[] fArr = new float[2];
            fArr[0] = Intrinsics.areEqual((Object) this.sourceFrom, (Object) "dt_landing") ? 0.7f : 1.0f;
            fArr[1] = 1.0f;
            ObjectAnimator imageAlphaAnim = ObjectAnimator.ofFloat(feedDraweeView, "alpha", fArr);
            imageAlphaAnim.setDuration(duration);
            ObjectAnimator closeImgAlphaAnim = ObjectAnimator.ofFloat(this.closeImg, "alpha", new float[]{0.0f, 1.0f});
            closeImgAlphaAnim.setDuration(duration);
            AnimatorSet imageAnimSet = new AnimatorSet();
            imageAnimSet.playTogether(new Animator[]{containerTransXAnim, imageAlphaAnim, closeImgAlphaAnim});
            imageAnimSet.start();
            this.state = BiSerialOpFloatingViewKt.STATUS_SHOWING;
            imageAnimSet.addListener(new BiSerialOpFloatingView$resetFold$1(this));
        }
    }

    public final String getFloatingViewState() {
        return this.state;
    }
}
