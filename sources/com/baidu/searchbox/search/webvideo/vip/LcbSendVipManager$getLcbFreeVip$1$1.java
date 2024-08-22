package com.baidu.searchbox.search.webvideo.vip;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.search.basic.utils.SpUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.search.videodetail.R;
import com.baidu.searchbox.search.webvideo.utils.SearchH5VideoUbcUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "canApply", "", "errCode", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LcbSendVipManager.kt */
final class LcbSendVipManager$getLcbFreeVip$1$1 extends Lambda implements Function2<Boolean, String, Unit> {
    final /* synthetic */ boolean $isShowToast;
    final /* synthetic */ Function1<Boolean, Unit> $vipCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LcbSendVipManager$getLcbFreeVip$1$1(boolean z, Function1<? super Boolean, Unit> function1) {
        super(2);
        this.$isShowToast = z;
        this.$vipCallback = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (String) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean canApply, String errCode) {
        if (!canApply || !Intrinsics.areEqual((Object) "0", (Object) errCode)) {
            UiThreadUtils.runOnUiThread(new LcbSendVipManager$getLcbFreeVip$1$1$$ExternalSyntheticLambda0(this.$vipCallback, this.$isShowToast));
            return;
        }
        SearchH5VideoUbcUtils.lcpFreeVipUbc("apply", SearchH5VideoUbcUtils.SOURCE_FREE_VIP);
        LcbSendVipManager lcbSendVipManager = LcbSendVipManager.INSTANCE;
        final boolean z = this.$isShowToast;
        final Function1<Boolean, Unit> function1 = this.$vipCallback;
        lcbSendVipManager.getLcpFreeVip("lcb_free", new Function2<Integer, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                invoke(((Number) p1).intValue(), (String) p2);
                return Unit.INSTANCE;
            }

            public final void invoke(int result, String errcode) {
                UiThreadUtils.runOnUiThread(new LcbSendVipManager$getLcbFreeVip$1$1$1$$ExternalSyntheticLambda0(result, z, function1));
            }

            /* access modifiers changed from: private */
            /* renamed from: invoke$lambda-0  reason: not valid java name */
            public static final void m3082invoke$lambda0(int $result, boolean $isShowToast2, Function1 $vipCallback2) {
                Intrinsics.checkNotNullParameter($vipCallback2, "$vipCallback");
                if ($result == 0) {
                    LcbSendVipManager.INSTANCE.setAlreadyRequestGetFreeVip(true);
                    if ($isShowToast2) {
                        UniversalToast.makeText(AppRuntime.getAppContext(), R.string.lcp_user_get_free_success_tips).showToast();
                    }
                    LcbSendVipManager.INSTANCE.dismissGetFreeVipLoading();
                    LcbSendVipManager.INSTANCE.setGetFreeVipSuccess(true);
                    $vipCallback2.invoke(true);
                    SpUtils.Companion.getInstance().putBoolean(LcbSendVipManagerKt.KEY_IS_GET_SUCCESS_FREE_VIP, true);
                    SearchH5VideoUbcUtils.lcpFreeVipUbc("success", SearchH5VideoUbcUtils.SOURCE_FREE_VIP);
                    return;
                }
                LcbSendVipManager.INSTANCE.dismissGetFreeVipLoading();
                LcbSendVipManager.INSTANCE.setAlreadyRequestGetFreeVip(true);
                LcbSendVipManager.INSTANCE.setGetFreeVipFail(true);
                $vipCallback2.invoke(false);
                SearchH5VideoUbcUtils.lcpFreeVipUbc("fail", SearchH5VideoUbcUtils.SOURCE_FREE_VIP);
                LcbSendVipManager.INSTANCE.showGetVipErrorToastWithReason($isShowToast2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m3081invoke$lambda0(Function1 $vipCallback2, boolean $isShowToast2) {
        Intrinsics.checkNotNullParameter($vipCallback2, "$vipCallback");
        LcbSendVipManager.INSTANCE.dismissGetFreeVipLoading();
        LcbSendVipManager.INSTANCE.setAlreadyRequestGetFreeVip(true);
        LcbSendVipManager.INSTANCE.setApplyFreeVipFail(true);
        $vipCallback2.invoke(false);
        LcbSendVipManager.INSTANCE.showApplyErrorToastWithReason($isShowToast2);
    }
}
