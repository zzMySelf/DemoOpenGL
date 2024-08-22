package com.google.common.eventbus;

import androidx.core.app.NotificationCompat;
import com.baidu.ubc.UBCManager;
import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

@Beta
public class DeadEvent {
    public final Object event;
    public final Object source;

    public DeadEvent(Object obj, Object obj2) {
        this.source = Preconditions.checkNotNull(obj);
        this.event = Preconditions.checkNotNull(obj2);
    }

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(UBCManager.CONTENT_KEY_SOURCE, this.source).add(NotificationCompat.CATEGORY_EVENT, this.event).toString();
    }
}
