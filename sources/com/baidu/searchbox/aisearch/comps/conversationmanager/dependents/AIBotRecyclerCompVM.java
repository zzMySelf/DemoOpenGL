package com.baidu.searchbox.aisearch.comps.conversationmanager.dependents;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.aisearch.comps.conversationmanager.aibotitem.AIBotItemData;
import com.baidu.searchbox.aisearch.comps.conversationmanager.model.AIBotItem;
import com.baidu.searchbox.aisearch.comps.conversationmanager.model.AIBotModel;
import com.baidu.searchbox.aisearch.comps.conversationmanager.repo.AIBotRepo;
import com.baidu.searchbox.nacomp.recycler.base.MappingRVViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\tH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/conversationmanager/dependents/AIBotRecyclerCompVM;", "Lcom/baidu/searchbox/nacomp/recycler/base/MappingRVViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "repo", "Lcom/baidu/searchbox/aisearch/comps/conversationmanager/repo/AIBotRepo;", "requestState", "Landroidx/lifecycle/MutableLiveData;", "", "getRequestState", "()Landroidx/lifecycle/MutableLiveData;", "subscription", "Lrx/subscriptions/CompositeSubscription;", "requestData", "", "pageSize", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AIBotRecyclerCompVM.kt */
public final class AIBotRecyclerCompVM extends MappingRVViewModel {
    private final AIBotRepo repo = new AIBotRepo();
    private final MutableLiveData<Integer> requestState = new MutableLiveData<>();
    private final CompositeSubscription subscription = new CompositeSubscription();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AIBotRecyclerCompVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Integer> getRequestState() {
        return this.requestState;
    }

    public static /* synthetic */ void requestData$default(AIBotRecyclerCompVM aIBotRecyclerCompVM, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 20;
        }
        aIBotRecyclerCompVM.requestData(i2);
    }

    public final void requestData(int pageSize) {
        clearData();
        this.requestState.setValue(1);
        this.subscription.clear();
        this.subscription.add(this.repo.getAIBotList(pageSize).observeOn(AndroidSchedulers.mainThread()).subscribe(new AIBotRecyclerCompVM$$ExternalSyntheticLambda0(this), new AIBotRecyclerCompVM$$ExternalSyntheticLambda1(this)));
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-1  reason: not valid java name */
    public static final void m15674requestData$lambda1(AIBotRecyclerCompVM this$0, AIBotModel it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it == null) {
            this$0.requestState.setValue(0);
            this$0.clearData();
            return;
        }
        this$0.clearData();
        for (AIBotItem item : it.getAiBotList()) {
            this$0.addData(new AIBotItemData(item));
        }
        if (this$0.getDataCount() > 0) {
            this$0.requestState.setValue(2);
        } else {
            this$0.requestState.setValue(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: requestData$lambda-2  reason: not valid java name */
    public static final void m15675requestData$lambda2(AIBotRecyclerCompVM this$0, Throwable it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.clearData();
        this$0.requestState.setValue(-1);
    }
}
