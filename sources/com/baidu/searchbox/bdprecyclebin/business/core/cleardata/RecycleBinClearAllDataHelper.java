package com.baidu.searchbox.bdprecyclebin.business.core.cleardata;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bdprecyclebin.business.core.RecycleBinHandlerManagerKt;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinClearAllHandler;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/business/core/cleardata/RecycleBinClearAllDataHelper;", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinClearAllHandler$IRecordsClearAllCallback;", "()V", "mCleaningAllBusinessTypes", "", "", "Lcom/baidu/searchbox/bdprecyclebin/business/core/cleardata/RecycleBinDataClearAllResult;", "getMCleaningAllBusinessTypes", "()Ljava/util/Map;", "mCleaningAllBusinessTypes$delegate", "Lkotlin/Lazy;", "mLoginManager", "Lcom/baidu/searchbox/account/BoxAccountManager;", "getMLoginManager", "()Lcom/baidu/searchbox/account/BoxAccountManager;", "mLoginManager$delegate", "completion", "", "businessName", "clearAllResult", "", "triggerDataClearAll", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecycleBinClearAllDataHelper.kt */
public final class RecycleBinClearAllDataHelper implements IRecycleBinClearAllHandler.IRecordsClearAllCallback {
    public static final RecycleBinClearAllDataHelper INSTANCE = new RecycleBinClearAllDataHelper();
    private static final Lazy mCleaningAllBusinessTypes$delegate = LazyKt.lazy(RecycleBinClearAllDataHelper$mCleaningAllBusinessTypes$2.INSTANCE);
    private static final Lazy mLoginManager$delegate = LazyKt.lazy(RecycleBinClearAllDataHelper$mLoginManager$2.INSTANCE);

    private RecycleBinClearAllDataHelper() {
    }

    private final Map<String, RecycleBinDataClearAllResult> getMCleaningAllBusinessTypes() {
        return (Map) mCleaningAllBusinessTypes$delegate.getValue();
    }

    private final BoxAccountManager getMLoginManager() {
        return (BoxAccountManager) mLoginManager$delegate.getValue();
    }

    public final void triggerDataClearAll() {
        UiThreadUtils.runOnUiThread(new RecycleBinClearAllDataHelper$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: triggerDataClearAll$lambda-2  reason: not valid java name */
    public static final void m16100triggerDataClearAll$lambda2(RecycleBinClearAllDataHelper this$0) {
        List clearAllHandlers;
        boolean hasLogin;
        RecycleBinClearAllDataHelper recycleBinClearAllDataHelper = this$0;
        Intrinsics.checkNotNullParameter(recycleBinClearAllDataHelper, "this$0");
        RecycleBinClearAllDataHelper recycleBinClearAllDataHelper2 = INSTANCE;
        if (recycleBinClearAllDataHelper2.getMCleaningAllBusinessTypes().isEmpty()) {
            BoxAccountManager mLoginManager = recycleBinClearAllDataHelper2.getMLoginManager();
            boolean hasLogin2 = mLoginManager != null ? mLoginManager.isLogin(2) : false;
            List clearAllHandlers2 = RecycleBinHandlerManagerKt.getRecycleBinClearAllHandlers();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : clearAllHandlers2) {
                IRecycleBinClearAllHandler clearAllHandler = (IRecycleBinClearAllHandler) element$iv$iv;
                boolean canHandleClearAll = true;
                if (clearAllHandler.isNeedLogin() && !hasLogin2) {
                    canHandleClearAll = false;
                }
                if (canHandleClearAll) {
                    String businessName = clearAllHandler.getBusinessType();
                    RecycleBinDataClearAllResult recycleBinDataClearAllResult = r13;
                    hasLogin = hasLogin2;
                    Map<String, RecycleBinDataClearAllResult> mCleaningAllBusinessTypes = INSTANCE.getMCleaningAllBusinessTypes();
                    clearAllHandlers = clearAllHandlers2;
                    RecycleBinDataClearAllResult recycleBinDataClearAllResult2 = new RecycleBinDataClearAllResult(businessName, false, false, 6, (DefaultConstructorMarker) null);
                    mCleaningAllBusinessTypes.put(businessName, recycleBinDataClearAllResult2);
                } else {
                    hasLogin = hasLogin2;
                    clearAllHandlers = clearAllHandlers2;
                }
                if (canHandleClearAll) {
                    destination$iv$iv.add(element$iv$iv);
                }
                hasLogin2 = hasLogin;
                clearAllHandlers2 = clearAllHandlers;
            }
            List list = clearAllHandlers2;
            for (IRecycleBinClearAllHandler clearAllHandler2 : (List) destination$iv$iv) {
                clearAllHandler2.clearAllRecords(recycleBinClearAllDataHelper);
            }
        }
    }

    public void completion(String businessName, boolean clearAllResult) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        UiThreadUtils.runOnUiThread(new RecycleBinClearAllDataHelper$$ExternalSyntheticLambda1(businessName, clearAllResult));
    }

    /* access modifiers changed from: private */
    /* renamed from: completion$lambda-5  reason: not valid java name */
    public static final void m16099completion$lambda5(String $businessName, boolean $clearAllResult) {
        Iterable $this$all$iv;
        Intrinsics.checkNotNullParameter($businessName, "$businessName");
        RecycleBinClearAllDataHelper recycleBinClearAllDataHelper = INSTANCE;
        RecycleBinDataClearAllResult resultInfo = recycleBinClearAllDataHelper.getMCleaningAllBusinessTypes().get($businessName);
        if (resultInfo != null) {
            boolean isAllSuccess = true;
            resultInfo.setCompleted(true);
            resultInfo.setSuccess($clearAllResult);
            recycleBinClearAllDataHelper.getMCleaningAllBusinessTypes().put($businessName, resultInfo);
            BdEventBus.Companion.getDefault().post(resultInfo);
            Iterable $this$all$iv2 = recycleBinClearAllDataHelper.getMCleaningAllBusinessTypes().entrySet();
            if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
                Iterator it = $this$all$iv2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((RecycleBinDataClearAllResult) ((Map.Entry) it.next()).getValue()).isCompleted()) {
                            $this$all$iv = null;
                            break;
                        }
                    } else {
                        $this$all$iv = 1;
                        break;
                    }
                }
            } else {
                $this$all$iv = 1;
            }
            if ($this$all$iv != null) {
                Iterable $this$all$iv3 = INSTANCE.getMCleaningAllBusinessTypes().entrySet();
                if (!($this$all$iv3 instanceof Collection) || !((Collection) $this$all$iv3).isEmpty()) {
                    Iterator it2 = $this$all$iv3.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((RecycleBinDataClearAllResult) ((Map.Entry) it2.next()).getValue()).isSuccess()) {
                                isAllSuccess = false;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                INSTANCE.getMCleaningAllBusinessTypes().clear();
                BdEventBus.Companion.getDefault().post(new RecycleBinDataClearAllCompletedEvent(isAllSuccess));
            }
        }
    }
}
