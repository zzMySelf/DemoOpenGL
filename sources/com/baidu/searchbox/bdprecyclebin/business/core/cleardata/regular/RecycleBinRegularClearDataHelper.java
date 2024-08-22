package com.baidu.searchbox.bdprecyclebin.business.core.cleardata.regular;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.bdprecyclebin.business.core.RecycleBinHandlerManagerKt;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinRegularClearHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/business/core/cleardata/regular/RecycleBinRegularClearDataHelper;", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinRegularClearHandler$IRecordsRegularClearCallback;", "()V", "mCleaningRegularBusinessTypes", "", "", "Lcom/baidu/searchbox/bdprecyclebin/business/core/cleardata/regular/RecycleBinDataClearRegularResult;", "getMCleaningRegularBusinessTypes", "()Ljava/util/Map;", "mCleaningRegularBusinessTypes$delegate", "Lkotlin/Lazy;", "mLoginManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "getMLoginManager", "()Lcom/baidu/searchbox/account/BoxAccountManager;", "mLoginManager$delegate", "completion", "", "businessName", "clearRegularResult", "", "triggerRegularDataClear", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecycleBinRegularClearDataHelper.kt */
public final class RecycleBinRegularClearDataHelper implements IRecycleBinRegularClearHandler.IRecordsRegularClearCallback {
    public static final RecycleBinRegularClearDataHelper INSTANCE = new RecycleBinRegularClearDataHelper();
    private static final Lazy mCleaningRegularBusinessTypes$delegate = LazyKt.lazy(RecycleBinRegularClearDataHelper$mCleaningRegularBusinessTypes$2.INSTANCE);
    private static final Lazy mLoginManager$delegate = LazyKt.lazy(RecycleBinRegularClearDataHelper$mLoginManager$2.INSTANCE);

    private RecycleBinRegularClearDataHelper() {
    }

    private final Map<String, RecycleBinDataClearRegularResult> getMCleaningRegularBusinessTypes() {
        return (Map) mCleaningRegularBusinessTypes$delegate.getValue();
    }

    private final BoxAccountManager getMLoginManager() {
        return (BoxAccountManager) mLoginManager$delegate.getValue();
    }

    public final void triggerRegularDataClear() {
        UiThreadUtils.runOnUiThread(new RecycleBinRegularClearDataHelper$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: triggerRegularDataClear$lambda-2  reason: not valid java name */
    public static final void m16103triggerRegularDataClear$lambda2(RecycleBinRegularClearDataHelper this$0) {
        List clearRegularHandlers;
        boolean hasLogin;
        RecycleBinRegularClearDataHelper recycleBinRegularClearDataHelper = this$0;
        Intrinsics.checkNotNullParameter(recycleBinRegularClearDataHelper, "this$0");
        RecycleBinRegularClearDataHelper recycleBinRegularClearDataHelper2 = INSTANCE;
        if (recycleBinRegularClearDataHelper2.getMCleaningRegularBusinessTypes().isEmpty()) {
            BoxAccountManager mLoginManager = recycleBinRegularClearDataHelper2.getMLoginManager();
            boolean hasLogin2 = mLoginManager != null ? mLoginManager.isLogin(2) : false;
            List clearRegularHandlers2 = RecycleBinHandlerManagerKt.getRecycleBinRegularClearHandlers();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : clearRegularHandlers2) {
                IRecycleBinRegularClearHandler clearRegularHandler = (IRecycleBinRegularClearHandler) element$iv$iv;
                boolean canHandleClearRegular = true;
                if (clearRegularHandler.isNeedLogin() && !hasLogin2) {
                    canHandleClearRegular = false;
                }
                if (canHandleClearRegular) {
                    String businessName = clearRegularHandler.getBusinessType();
                    RecycleBinDataClearRegularResult recycleBinDataClearRegularResult = r13;
                    hasLogin = hasLogin2;
                    Map<String, RecycleBinDataClearRegularResult> mCleaningRegularBusinessTypes = INSTANCE.getMCleaningRegularBusinessTypes();
                    clearRegularHandlers = clearRegularHandlers2;
                    RecycleBinDataClearRegularResult recycleBinDataClearRegularResult2 = new RecycleBinDataClearRegularResult(businessName, false, false, 6, (DefaultConstructorMarker) null);
                    mCleaningRegularBusinessTypes.put(businessName, recycleBinDataClearRegularResult2);
                } else {
                    hasLogin = hasLogin2;
                    clearRegularHandlers = clearRegularHandlers2;
                }
                if (canHandleClearRegular) {
                    destination$iv$iv.add(element$iv$iv);
                }
                hasLogin2 = hasLogin;
                clearRegularHandlers2 = clearRegularHandlers;
            }
            List list = clearRegularHandlers2;
            for (IRecycleBinRegularClearHandler clearRegularHandler2 : (List) destination$iv$iv) {
                clearRegularHandler2.clearRecords(7, recycleBinRegularClearDataHelper);
            }
        }
    }

    public void completion(String businessName, boolean clearRegularResult) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        UiThreadUtils.runOnUiThread(new RecycleBinRegularClearDataHelper$$ExternalSyntheticLambda0(businessName, clearRegularResult));
    }

    /* access modifiers changed from: private */
    /* renamed from: completion$lambda-4  reason: not valid java name */
    public static final void m16102completion$lambda4(String $businessName, boolean $clearRegularResult) {
        Intrinsics.checkNotNullParameter($businessName, "$businessName");
        RecycleBinRegularClearDataHelper recycleBinRegularClearDataHelper = INSTANCE;
        RecycleBinDataClearRegularResult resultInfo = recycleBinRegularClearDataHelper.getMCleaningRegularBusinessTypes().get($businessName);
        if (resultInfo != null) {
            boolean isAllCompleted = true;
            resultInfo.setCompleted(true);
            resultInfo.setSuccess($clearRegularResult);
            recycleBinRegularClearDataHelper.getMCleaningRegularBusinessTypes().put($businessName, resultInfo);
            Iterable $this$all$iv = recycleBinRegularClearDataHelper.getMCleaningRegularBusinessTypes().entrySet();
            if (!($this$all$iv instanceof Collection) || !((Collection) $this$all$iv).isEmpty()) {
                Iterator it = $this$all$iv.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((RecycleBinDataClearRegularResult) ((Map.Entry) it.next()).getValue()).isCompleted()) {
                            isAllCompleted = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (isAllCompleted) {
                INSTANCE.getMCleaningRegularBusinessTypes().clear();
            }
        }
    }
}
