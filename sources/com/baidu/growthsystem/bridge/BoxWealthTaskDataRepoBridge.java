package com.baidu.growthsystem.bridge;

import com.baidu.growthsystem.wealth.config.repo.WealthTaskDataRepo;
import com.baidu.searchbox.rewardsystem.newtimer.net.BoxWealthTaskDataRepo;
import com.baidu.swan.api.SwanAppConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JY\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00040\n2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/growthsystem/bridge/BoxWealthTaskDataRepoBridge;", "Lcom/baidu/growthsystem/wealth/config/repo/WealthTaskDataRepo;", "()V", "activeTask", "", "source", "", "tasks", "", "successCallback", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "result", "failureCallback", "Lkotlin/Function0;", "requestPaymentTask", "impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxWealthTaskDataRepoBridge.kt */
public final class BoxWealthTaskDataRepoBridge extends WealthTaskDataRepo {
    public void requestPaymentTask(Function0<Unit> failureCallback) {
        BoxWealthTaskDataRepo.requestPaymentTask$default(BoxWealthTaskDataRepo.INSTANCE, (String) null, failureCallback, 1, (Object) null);
    }

    public void activeTask(String source, Map<String, String> tasks, Function1<? super JSONObject, Unit> successCallback, Function0<Unit> failureCallback) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(tasks, "tasks");
        Intrinsics.checkNotNullParameter(successCallback, SwanAppConstants.Deprecation.SUCCESS_CALLBACK);
        BoxWealthTaskDataRepo.INSTANCE.activeTask(source, tasks, successCallback, failureCallback);
    }
}
