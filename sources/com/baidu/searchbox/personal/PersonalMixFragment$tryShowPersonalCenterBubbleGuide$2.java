package com.baidu.searchbox.personal;

import android.content.DialogInterface;
import android.view.View;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.exclusion.popup.ExclusionType;
import com.baidu.searchbox.exclusion.popup.PopupExclusionManagerMap;
import com.baidu.searchbox.exclusion.popup.ShowStatus;
import com.baidu.searchbox.exclusion.popup.ShowStatusCallback;
import com.baidu.searchbox.personal.bubble.BubbleGuideManager;
import com.baidu.searchbox.personalcenter.bubble.PersonalCenterBubbleModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/personal/PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2", "Lcom/baidu/searchbox/exclusion/popup/PopupExclusionManagerMap$Operation;", "onBreaked", "", "onShow", "callback", "Lcom/baidu/searchbox/exclusion/popup/ShowStatusCallback;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalMixFragment.kt */
public final class PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2 extends PopupExclusionManagerMap.Operation {
    final /* synthetic */ Ref.ObjectRef<View> $anchorView;
    final /* synthetic */ PersonalCenterBubbleModel $bubbleModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2(Ref.ObjectRef<View> $anchorView2, PersonalCenterBubbleModel $bubbleModel2, ExclusionType $super_call_param$1) {
        super($super_call_param$1, 2.0f, false, true);
        this.$anchorView = $anchorView2;
        this.$bubbleModel = $bubbleModel2;
    }

    public void onShow(ShowStatusCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UiThreadUtils.runOnUiThread(new PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2$$ExternalSyntheticLambda1(this.$anchorView, this.$bubbleModel, callback, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onShow$lambda-1  reason: not valid java name */
    public static final void m2000onShow$lambda1(Ref.ObjectRef $anchorView2, PersonalCenterBubbleModel $bubbleModel2, ShowStatusCallback $callback, PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2 this$0) {
        Intrinsics.checkNotNullParameter($anchorView2, "$anchorView");
        Intrinsics.checkNotNullParameter($bubbleModel2, "$bubbleModel");
        Intrinsics.checkNotNullParameter($callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (BubbleGuideManager.INSTANCE.realShowGuide((View) $anchorView2.element, $bubbleModel2, new PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2$$ExternalSyntheticLambda0(this$0))) {
            $callback.callback(ShowStatus.REAL_SHOW);
        } else {
            $callback.callback(ShowStatus.NOT_SHOW);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onShow$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2001onShow$lambda1$lambda0(PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2 this$0, DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isBreak()) {
            PopupExclusionManagerMap.getInstance().unDisplay(PopupExclusionManagerMap.SCENE_MY, ExclusionType.MY_SETTING_GUIDE);
        }
    }

    public void onBreaked() {
        UiThreadUtils.runOnUiThread(new PersonalMixFragment$tryShowPersonalCenterBubbleGuide$2$$ExternalSyntheticLambda2());
    }

    /* access modifiers changed from: private */
    /* renamed from: onBreaked$lambda-2  reason: not valid java name */
    public static final void m1999onBreaked$lambda2() {
        BubbleGuideManager.INSTANCE.dismissBubble();
    }
}
