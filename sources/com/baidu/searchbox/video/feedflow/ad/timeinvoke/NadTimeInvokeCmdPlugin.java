package com.baidu.searchbox.video.feedflow.ad.timeinvoke;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.CoreState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.ad.detail.AdData;
import com.baidu.searchbox.video.feedflow.ad.detail.AdDataState;
import com.baidu.searchbox.video.feedflow.ad.timeinvoke.AdTimeInvokeAction;
import com.baidu.searchbox.video.feedflow.ad.timeinvoke.NadTimeInvokeCmdPlugin$playerListener$2;
import com.baidu.searchbox.video.feedflow.detail.player.service.IPlayerComponentService;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/timeinvoke/NadTimeInvokeCmdPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "playerListener", "com/baidu/searchbox/video/feedflow/ad/timeinvoke/NadTimeInvokeCmdPlugin$playerListener$2$1", "getPlayerListener", "()Lcom/baidu/searchbox/video/feedflow/ad/timeinvoke/NadTimeInvokeCmdPlugin$playerListener$2$1;", "playerListener$delegate", "Lkotlin/Lazy;", "invokeCmd", "", "cmd", "", "onAttachToManager", "onCreate", "onDestroy", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTimeInvokeCmdPlugin.kt */
public final class NadTimeInvokeCmdPlugin extends LiveDataPlugin {
    private final Lazy playerListener$delegate = LazyKt.lazy(new NadTimeInvokeCmdPlugin$playerListener$2(this));

    private final NadTimeInvokeCmdPlugin$playerListener$2.AnonymousClass1 getPlayerListener() {
        return (NadTimeInvokeCmdPlugin$playerListener$2.AnonymousClass1) this.playerListener$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final void invokeCmd(String cmd) {
        Store<AbsState> store;
        CharSequence charSequence = cmd;
        if (!(charSequence == null || charSequence.length() == 0) && (store = getStore()) != null) {
            StoreExtKt.post(store, new AdTimeInvokeAction.TimeInvokeCmdAction(cmd));
        }
    }

    public void onAttachToManager() {
        CoreState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d3 = (CoreState) store.subscribe((Class<T>) CoreState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d3.getNestedAction().observe(this, new NadTimeInvokeCmdPlugin$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m5747onAttachToManager$lambda3$lambda2(NadTimeInvokeCmdPlugin this$0, NestedAction action) {
        MutableLiveData<AdData> data;
        AdData value;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store $this$select$iv = this$0.getStore();
        List list = null;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            AdDataState adDataState = (AdDataState) (commonState != null ? commonState.select(AdDataState.class) : null);
            if (!(adDataState == null || (data = adDataState.getData()) == null || (value = data.getValue()) == null)) {
                list = value.getTimeInvokeCmdList();
            }
        }
        List timeInvokeCmdList = list;
        if (action instanceof NestedAction.OnAttachToScreen) {
            if (timeInvokeCmdList != null) {
                for (AdTimeInvokeCmdModel model : timeInvokeCmdList) {
                    if (-1 == model.getDelayTime()) {
                        this$0.invokeCmd(model.getCmd());
                        model.setInvoke(true);
                    }
                }
            }
        } else if ((action instanceof NestedAction.OnDetachFromScreen) && timeInvokeCmdList != null) {
            List<AdTimeInvokeCmdModel> list2 = timeInvokeCmdList;
            if (true ^ list2.isEmpty()) {
                for (AdTimeInvokeCmdModel model2 : list2) {
                    model2.setInvoke(false);
                }
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.addPlayerComponentListener(getPlayerListener());
        }
    }

    public void onDestroy() {
        IPlayerComponentService iPlayerComponentService = (IPlayerComponentService) getManager().getService(IPlayerComponentService.class);
        if (iPlayerComponentService != null) {
            iPlayerComponentService.removePlayerComponentListener(getPlayerListener());
        }
        super.onDestroy();
    }
}
