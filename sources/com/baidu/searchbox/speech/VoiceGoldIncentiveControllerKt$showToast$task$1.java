package com.baidu.searchbox.speech;

import android.content.Context;
import com.baidu.android.ext.manage.PopItem;
import com.baidu.android.ext.widget.toast.ToastRightAreaStyle;
import com.baidu.android.ext.widget.toast.ToastTemplate;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J/\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/baidu/searchbox/speech/VoiceGoldIncentiveControllerKt$showToast$task$1", "Lcom/baidu/android/ext/manage/PopItem;", "mutexDismiss", "", "mutexShow", "", "p0", "", "p1", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Z", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceGoldIncentiveController.kt */
public final class VoiceGoldIncentiveControllerKt$showToast$task$1 implements PopItem {
    final /* synthetic */ Context $activity;
    final /* synthetic */ String $btnText;
    final /* synthetic */ String $closeText;
    final /* synthetic */ String $content;
    final /* synthetic */ int $duration;
    final /* synthetic */ String $scheme;

    VoiceGoldIncentiveControllerKt$showToast$task$1(Context $activity2, String $content2, String $btnText2, int $duration2, String $closeText2, String $scheme2) {
        this.$activity = $activity2;
        this.$content = $content2;
        this.$btnText = $btnText2;
        this.$duration = $duration2;
        this.$closeText = $closeText2;
        this.$scheme = $scheme2;
    }

    public boolean mutexShow(String p0, Object... p1) {
        Intrinsics.checkNotNullParameter(p1, "p1");
        VoiceGoldIncentiveControllerKt.ubc("2989", "show");
        UniversalToast.makeText(this.$activity).setTitleText(this.$content).setRightClickStyle(ToastRightAreaStyle.BUTTON).setRightText(this.$btnText).setDuration(this.$duration).setTemplate(ToastTemplate.T3).setCancelVisible(true).setToastCancelCallback(new VoiceGoldIncentiveControllerKt$showToast$task$1$$ExternalSyntheticLambda0(this.$activity, this.$closeText)).setToastCallback(new VoiceGoldIncentiveControllerKt$showToast$task$1$$ExternalSyntheticLambda1(this.$activity, this.$scheme)).show();
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: mutexShow$lambda-0  reason: not valid java name */
    public static final void m3341mutexShow$lambda0(Context $activity2, String $closeText2) {
        Intrinsics.checkNotNullParameter($activity2, "$activity");
        Intrinsics.checkNotNullParameter($closeText2, "$closeText");
        VoiceGoldIncentiveControllerKt.ubc("2989", "close");
        VoiceGoldIncentiveControllerKt.showDialog($activity2, $closeText2);
    }

    /* access modifiers changed from: private */
    /* renamed from: mutexShow$lambda-1  reason: not valid java name */
    public static final void m3342mutexShow$lambda1(Context $activity2, String $scheme2) {
        Intrinsics.checkNotNullParameter($activity2, "$activity");
        Intrinsics.checkNotNullParameter($scheme2, "$scheme");
        VoiceGoldIncentiveControllerKt.ubc("2989", "click");
        BaseRouter.invoke($activity2, $scheme2);
    }

    public void mutexDismiss() {
    }
}
