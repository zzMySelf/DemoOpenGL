package com.baidu.searchbox.kmm.home.lv1tab;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.utils.KmmLog;
import com.baidu.searchbox.kmm.foundation.utils.PlatformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "isSucceed", "", "ubcDict", "", "", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLv1TabOperationDataMgr.kt */
final class HomeLv1TabOperationDataMgr$doNotifyOperation$1 extends Lambda implements Function2<Boolean, Map<String, ? extends Object>, Unit> {
    final /* synthetic */ Function0<Unit> $completionCallback;
    final /* synthetic */ HomeLv1TabOperationModel $operationInfo;
    final /* synthetic */ String $tabId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeLv1TabOperationDataMgr$doNotifyOperation$1(String str, HomeLv1TabOperationModel homeLv1TabOperationModel, Function0<Unit> function0) {
        super(2);
        this.$tabId = str;
        this.$operationInfo = homeLv1TabOperationModel;
        this.$completionCallback = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke(((Boolean) p1).booleanValue(), (Map<String, ? extends Object>) (Map) p2);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean isSucceed, Map<String, ? extends Object> ubcDict) {
        if (isSucceed) {
            HomeLv1TabOperationDataMgr.currentShowingOperations.put(this.$tabId, this.$operationInfo);
        } else {
            final HomeLv1TabOperationModel homeLv1TabOperationModel = this.$operationInfo;
            BackgroundTaskUtilsKt.bgConcurrentWork(new Function0<Unit>() {
                public final void invoke() {
                    HomeLv1TabUBCUtilsKt.onTabOperationStatusChanged(HomeLv1TabUBCUtilsKt.UBC_TYPE_OPERATION_STATUS_TYPE_MUTEX, homeLv1TabOperationModel);
                }
            });
            if (PlatformUtils.isDebug()) {
                KmmLog.printLog("KMM-运营", "展示失败，当前通知任务: " + HomeLv1TabOperationDataMgr.notifyTaskQueue.getTaskCount());
            }
            BackgroundTaskUtilsKt.bgSerialWork(AnonymousClass2.INSTANCE);
        }
        Function0<Unit> function0 = this.$completionCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
