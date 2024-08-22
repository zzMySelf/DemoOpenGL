package com.baidu.searchbox.gamecore.person;

import android.content.Context;
import com.baidu.searchbox.base.utils.UiThreadUtil;
import com.baidu.searchbox.gamecore.person.model.PunchInApiResult;
import com.baidu.searchbox.gamecore.person.model.PunchInRewardPopData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/gamecore/person/model/PunchInApiResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: GamePunchInWorkManager.kt */
final class GamePunchInWorkManager$punchInActual$1 extends Lambda implements Function1<PunchInApiResult, Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function1<PunchInApiResult, Unit> $onPunchInSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GamePunchInWorkManager$punchInActual$1(Function1<? super PunchInApiResult, Unit> function1, Context context) {
        super(1);
        this.$onPunchInSuccess = function1;
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((PunchInApiResult) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(PunchInApiResult it) {
        UiThreadUtil.runOnUiThread(new GamePunchInWorkManager$punchInActual$1$$ExternalSyntheticLambda0(it, this.$onPunchInSuccess, this.$context));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m19856invoke$lambda1(PunchInApiResult $it, Function1 $onPunchInSuccess2, Context $context2) {
        PunchInRewardPopData $this$invoke_u24lambda_u2d1_u24lambda_u2d0;
        Intrinsics.checkNotNullParameter($onPunchInSuccess2, "$onPunchInSuccess");
        Intrinsics.checkNotNullParameter($context2, "$context");
        if (!($it == null || ($this$invoke_u24lambda_u2d1_u24lambda_u2d0 = $it.getRewardPopData()) == null)) {
            GamePunchInWorkManager.INSTANCE.showRewardDialog($context2, $this$invoke_u24lambda_u2d1_u24lambda_u2d0);
        }
        $onPunchInSuccess2.invoke($it);
    }
}
