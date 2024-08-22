package com.baidu.searchbox.returnvisit;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.introduction.revisit.HomeRevisitData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReturnVisitDataUtils.kt */
final class ReturnVisitDataUtilsKt$cvtSpToReturnVisitData$action$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<HomeRevisitData, Unit> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReturnVisitDataUtilsKt$cvtSpToReturnVisitData$action$1(Function1<? super HomeRevisitData, Unit> function1) {
        super(0);
        this.$callback = function1;
    }

    public final void invoke() {
        UiThreadUtils.runOnUiThread(new ReturnVisitDataUtilsKt$cvtSpToReturnVisitData$action$1$$ExternalSyntheticLambda0(this.$callback, new HomeRevisitData(ReturnVisitCommandListener.Companion.getString("id"), ReturnVisitCommandListener.Companion.getString("title"), ReturnVisitCommandListener.Companion.getString("sub_title"), ReturnVisitCommandListener.Companion.getString("logo"), ReturnVisitCommandListener.Companion.getInt("logo_type"), ReturnVisitCommandListener.Companion.getInt(ReturnVisitCommandListener.KEY_TIME_CTL), ReturnVisitCommandListener.Companion.getString("schema"), ReturnVisitCommandListener.Companion.getString("source"), ReturnVisitCommandListener.Companion.getString(ReturnVisitCommandListener.KEY_BTN_TEXT), Long.valueOf(ReturnVisitCommandListener.Companion.getLong("end_time")))));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m2591invoke$lambda0(Function1 $callback2, HomeRevisitData $data) {
        Intrinsics.checkNotNullParameter($callback2, "$callback");
        Intrinsics.checkNotNullParameter($data, "$data");
        $callback2.invoke($data);
    }
}
