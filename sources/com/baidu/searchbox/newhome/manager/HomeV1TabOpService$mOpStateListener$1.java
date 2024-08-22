package com.baidu.searchbox.newhome.manager;

import com.baidu.searchbox.newhome.listener.IOperationStateListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\nH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R*\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"com/baidu/searchbox/newhome/manager/HomeV1TabOpService$mOpStateListener$1", "Lcom/baidu/searchbox/newhome/listener/IOperationStateListener;", "hasShowSuccess", "", "getHasShowSuccess", "()Z", "setHasShowSuccess", "(Z)V", "successType", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getSuccessType", "()Ljava/util/ArrayList;", "setSuccessType", "(Ljava/util/ArrayList;)V", "onOpDismiss", "", "isAllDismiss", "type", "onOpShow", "isSuccess", "new-home-top_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeV1TabOpService.kt */
public final class HomeV1TabOpService$mOpStateListener$1 implements IOperationStateListener {
    private boolean hasShowSuccess;
    private ArrayList<String> successType = new ArrayList<>();
    final /* synthetic */ HomeV1TabOpService this$0;

    HomeV1TabOpService$mOpStateListener$1(HomeV1TabOpService $receiver) {
        this.this$0 = $receiver;
    }

    public final boolean getHasShowSuccess() {
        return this.hasShowSuccess;
    }

    public final void setHasShowSuccess(boolean z) {
        this.hasShowSuccess = z;
    }

    public final ArrayList<String> getSuccessType() {
        return this.successType;
    }

    public final void setSuccessType(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.successType = arrayList;
    }

    public void onOpShow(boolean isSuccess, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        HomeV1TabOperationManager.INSTANCE.printLog("收到展示回调，是否成功===" + isSuccess);
        HomeV1TabOpService homeV1TabOpService = this.this$0;
        homeV1TabOpService.mOpNeedShowCount = homeV1TabOpService.mOpNeedShowCount - 1;
        if (isSuccess) {
            this.successType.add(type);
            if (!this.hasShowSuccess) {
                this.hasShowSuccess = true;
                Function2 access$getMOpShowCallback$p = this.this$0.mOpShowCallback;
                if (access$getMOpShowCallback$p != null) {
                    access$getMOpShowCallback$p.invoke(true, null);
                }
                HomeV1TabOperationManager.INSTANCE.printLog("回调给KMM，展示成功");
                return;
            }
        }
        if (this.this$0.mOpNeedShowCount == 0 && !this.hasShowSuccess) {
            Function2 access$getMOpShowCallback$p2 = this.this$0.mOpShowCallback;
            if (access$getMOpShowCallback$p2 != null) {
                access$getMOpShowCallback$p2.invoke(false, null);
            }
            HomeV1TabOperationManager.INSTANCE.printLog("回调给KMM，展示失败");
        }
    }

    public void onOpDismiss(boolean isAllDismiss, String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (isAllDismiss) {
            Function0 access$getMOpDismissCallback$p = this.this$0.mOpDismissCallback;
            if (access$getMOpDismissCallback$p != null) {
                access$getMOpDismissCallback$p.invoke();
            }
            HomeV1TabOperationManager.INSTANCE.printLog("回调给KMM，运营消失");
            this.successType.clear();
            return;
        }
        this.successType.remove(type);
        if (this.successType.isEmpty()) {
            Function0 access$getMOpDismissCallback$p2 = this.this$0.mOpDismissCallback;
            if (access$getMOpDismissCallback$p2 != null) {
                access$getMOpDismissCallback$p2.invoke();
            }
            HomeV1TabOperationManager.INSTANCE.printLog("回调给KMM，运营消失");
        }
    }
}
