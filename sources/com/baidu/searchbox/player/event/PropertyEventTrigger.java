package com.baidu.searchbox.player.event;

import com.baidu.searchbox.player.message.IMessenger;
import com.baidu.searchbox.player.property.GlobalScope;
import com.baidu.searchbox.player.property.Property;
import com.baidu.searchbox.player.property.PropertyManagerKt;
import com.baidu.searchbox.player.property.Scope;
import com.baidu.searchbox.player.property.SingleScope;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u0006\u0010\u0011\u001a\u00020\rJ\u001a\u0010\u0012\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0007R-\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/player/event/PropertyEventTrigger;", "Lcom/baidu/searchbox/player/event/IEventTrigger;", "()V", "subscribers", "", "", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/searchbox/player/message/IMessenger;", "getSubscribers", "()Ljava/util/Map;", "subscribers$delegate", "Lkotlin/Lazy;", "bindMessenger", "", "property", "Lcom/baidu/searchbox/player/property/Property;", "messenger", "clear", "onPropertyChanged", "sender", "", "triggerEvent", "event", "Lcom/baidu/searchbox/player/event/VideoEvent;", "unbindMessenger", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PropertyEventTrigger.kt */
public final class PropertyEventTrigger implements IEventTrigger {
    private final Lazy subscribers$delegate = LazyKt.lazy(PropertyEventTrigger$subscribers$2.INSTANCE);

    private final Map<String, CopyOnWriteArrayList<IMessenger>> getSubscribers() {
        return (Map) this.subscribers$delegate.getValue();
    }

    public final void bindMessenger(Property<?> property, IMessenger messenger) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        if (!Intrinsics.areEqual((Object) property.getScope(), (Object) SingleScope.INSTANCE)) {
            CopyOnWriteArrayList $this$bindMessenger_u24lambda_u2d0 = getSubscribers().get(PropertyManagerKt.forKey(property));
            if ($this$bindMessenger_u24lambda_u2d0 == null) {
                CopyOnWriteArrayList subscriber = new CopyOnWriteArrayList();
                subscriber.add(messenger);
                getSubscribers().put(PropertyManagerKt.forKey(property), subscriber);
            } else if (!$this$bindMessenger_u24lambda_u2d0.contains(messenger)) {
                $this$bindMessenger_u24lambda_u2d0.add(messenger);
            }
        }
    }

    public final void unbindMessenger(IMessenger messenger) {
        Intrinsics.checkNotNullParameter(messenger, "messenger");
        for (CopyOnWriteArrayList<IMessenger> list : getSubscribers().values()) {
            list.remove(messenger);
        }
    }

    public final void clear() {
        getSubscribers().clear();
    }

    public final void onPropertyChanged(Property<?> property, Object sender) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(sender, "sender");
        VideoEvent event = VideoEvent.obtain(PropertyEventKt.ACTION_PROPERTY_STATE_CHANGED, 1);
        event.putExtra(1, property.getClass().getName());
        event.putExtra(2, property.getState());
        event.putExtra(3, property.getScope());
        event.setSender(sender);
        Intrinsics.checkNotNullExpressionValue(event, "event");
        triggerEvent(event);
    }

    public void triggerEvent(VideoEvent event) {
        String key;
        Intrinsics.checkNotNullParameter(event, "event");
        Object extra = event.getExtra(3);
        String str = null;
        if (!(extra instanceof Scope)) {
            extra = null;
        }
        Scope scope = (Scope) extra;
        Object extra2 = event.getExtra(1);
        if (!(extra2 instanceof String)) {
            extra2 = null;
        }
        String className = (String) extra2;
        if (!Intrinsics.areEqual((Object) scope, (Object) GlobalScope.INSTANCE)) {
            StringBuilder append = new StringBuilder().append(className);
            if (scope != null) {
                str = scope.getName();
            }
            key = append.append(str).toString();
        } else {
            key = className;
        }
        CopyOnWriteArrayList subscriber = getSubscribers().get(key);
        Collection collection = subscriber;
        if (!(collection == null || collection.isEmpty())) {
            int size = subscriber.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = subscriber.get(i2);
                Intrinsics.checkNotNullExpressionValue(obj, "subscriber[i]");
                IMessenger m = (IMessenger) obj;
                if (i2 == 0) {
                    m.notifyEvent(event);
                } else {
                    m.notifyEvent(VideoEvent.copy(event));
                }
            }
        }
    }
}
