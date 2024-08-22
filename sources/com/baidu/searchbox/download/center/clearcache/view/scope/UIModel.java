package com.baidu.searchbox.download.center.clearcache.view.scope;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u000b\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u00020\nJ\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/scope/UIModel;", "", "()V", "mNotifiers", "", "Lcom/baidu/searchbox/download/center/clearcache/view/scope/UINotifier;", "getMNotifiers", "()Ljava/util/List;", "mUIModelEvents", "", "", "Lcom/baidu/searchbox/download/center/clearcache/view/scope/UIModelEvent;", "attach", "", "detach", "ofUIModelEvent", "T", "key", "onAttach", "onDetach", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UIModel.kt */
public class UIModel {
    private final List<UINotifier<?>> mNotifiers = new ArrayList();
    private final Map<String, UIModelEvent<?>> mUIModelEvents = new LinkedHashMap();

    public final List<UINotifier<?>> getMNotifiers() {
        return this.mNotifiers;
    }

    public final void attach() {
        onAttach();
    }

    public final void detach() {
        for (UINotifier it : this.mNotifiers) {
            it.dispose();
        }
        this.mNotifiers.clear();
        for (Map.Entry<String, UIModelEvent<?>> element$iv : this.mUIModelEvents.entrySet()) {
            ((UIModelEvent) element$iv.getValue()).dispose();
        }
        this.mUIModelEvents.clear();
        onDetach();
    }

    public void onAttach() {
    }

    public void onDetach() {
    }

    public final <T> UIModelEvent<T> ofUIModelEvent(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        UIModelEvent<T> uIModelEvent = this.mUIModelEvents.get(key);
        if (uIModelEvent != null) {
            return uIModelEvent;
        }
        UIModelEvent $this$ofUIModelEvent_u24lambda_u2d2 = new UIModelEvent(key);
        this.mUIModelEvents.put(key, $this$ofUIModelEvent_u24lambda_u2d2);
        return $this$ofUIModelEvent_u24lambda_u2d2;
    }
}
