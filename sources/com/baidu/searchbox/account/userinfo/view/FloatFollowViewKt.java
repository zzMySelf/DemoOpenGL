package com.baidu.searchbox.account.userinfo.view;

import android.animation.ValueAnimator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"ALPHA_ANIM_DURATION", "", "VANISH_ANIM_DELAY", "release", "", "Landroid/animation/ValueAnimator;", "lib-userinfo_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatFollowView.kt */
public final class FloatFollowViewKt {
    private static final long ALPHA_ANIM_DURATION = 200;
    private static final long VANISH_ANIM_DELAY = 1000;

    /* access modifiers changed from: private */
    public static final void release(ValueAnimator $this$release) {
        $this$release.cancel();
        $this$release.removeAllListeners();
        $this$release.removeAllUpdateListeners();
    }
}
