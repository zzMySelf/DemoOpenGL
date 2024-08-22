package com.baidu.searchbox.video.feedflow.detail.attitude;

import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.searchbox.comment.BDCommentConstants;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.flowvideo.detail.repos.AttitudeModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.comment.CommonCommentAction;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.utils.VideoLoginUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/attitude/AttitudeAnimationComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "getAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "animationView$delegate", "Lkotlin/Lazy;", "createView", "Landroid/view/View;", "initAnimationView", "onAttachToManager", "", "onDestroy", "release", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AttitudeAnimationComponent.kt */
public final class AttitudeAnimationComponent extends LiveDataComponent {
    private final Lazy animationView$delegate = BdPlayerUtils.lazyNone(new AttitudeAnimationComponent$animationView$2(this));

    private final LottieAnimationView getAnimationView() {
        return (LottieAnimationView) this.animationView$delegate.getValue();
    }

    public View createView() {
        return getAnimationView();
    }

    public void onAttachToManager() {
        AttitudeState $this$onAttachToManager_u24lambda_u2d5;
        CoreState coreState;
        MutableLiveData<NestedAction> nestedAction;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || (coreState = (CoreState) $this$subscribe$iv.subscribe(CoreState.class)) == null || (nestedAction = coreState.getNestedAction()) == null)) {
            nestedAction.observe(this, new AttitudeAnimationComponent$$ExternalSyntheticLambda0(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if ($this$subscribe$iv2 != null && ($this$onAttachToManager_u24lambda_u2d5 = (AttitudeState) $this$subscribe$iv2.subscribe(AttitudeState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d5.getLoadAttitudeData().observe(this, new AttitudeAnimationComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d5.getAttitudeItemClick().observe(this, new AttitudeAnimationComponent$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-0  reason: not valid java name */
    public static final void m10590onAttachToManager$lambda0(AttitudeAnimationComponent this$0, NestedAction action) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (action instanceof NestedAction.OnDetachFromScreen) {
            if (this$0.getAnimationView().getVisibility() != 8) {
                this$0.getAnimationView().setVisibility(8);
            }
            this$0.release();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-2  reason: not valid java name */
    public static final void m10591onAttachToManager$lambda5$lambda2(AttitudeAnimationComponent this$0, List dataList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(dataList, "dataList");
        Iterator it = dataList.iterator();
        while (it.hasNext()) {
            this$0.getAnimationView().setAnimationFromUrl(((AttitudeModel) it.next()).getEmojiEffect());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-5$lambda-4  reason: not valid java name */
    public static final void m10592onAttachToManager$lambda5$lambda4(AttitudeAnimationComponent this$0, AttitudeModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.getAnimationView().isAnimating()) {
            this$0.getAnimationView().cancelAnimation();
        }
        if (!StringsKt.isBlank(model.getEmojiEffect())) {
            this$0.getAnimationView().setAnimationFromUrl(model.getEmojiEffect());
            this$0.getAnimationView().setVisibility(0);
            this$0.getAnimationView().playAnimation();
        }
        JSONObject ext = new JSONObject();
        ext.put(BDCommentConstants.KEY_CMT_WAY, 5);
        if (!VideoLoginUtils.isLogin() || System.currentTimeMillis() - model.getLastSendTime() > 60000) {
            String danmakuText = StringsKt.isBlank(model.getShowText()) ^ true ? model.getShowText() : model.getContent();
            if (!StringsKt.isBlank(danmakuText)) {
                Store<AbsState> store = this$0.getStore();
                if (store != null) {
                    store.dispatch(new CommonCommentAction.OnBarrageResult(danmakuText, (Map<String, String>) null, ext));
                }
                model.setLastSendTime(System.currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: private */
    public final LottieAnimationView initAnimationView() {
        LottieAnimationView lottieView = new LottieAnimationView(getContext());
        int screenWidth = Math.min(DIFactory.INSTANCE.getDisplayWidth(), DIFactory.INSTANCE.getDisplayHeight());
        lottieView.setLayoutParams(new FrameLayout.LayoutParams(screenWidth, screenWidth));
        lottieView.setVisibility(8);
        return lottieView;
    }

    public void onDestroy() {
        super.onDestroy();
        release();
    }

    private final void release() {
        if (getAnimationView().isAnimating()) {
            getAnimationView().cancelAnimation();
        }
    }
}
