package com.baidu.searchbox.feed.news.flowlinkage.linkage;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u000b\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0007J\b\u0010\u0016\u001a\u00020\u0012H\u0007J\b\u0010\u0017\u001a\u00020\u0012H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0007J\b\u0010\u001a\u001a\u00020\u0012H\u0007J\u000e\u0010\u001b\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/feed/news/flowlinkage/linkage/NewsFlowLifecycleDispatchHelper;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "currentActivityEvent", "Landroidx/lifecycle/Lifecycle$Event;", "isAllowDispatchLifecycle", "", "isSelected", "lifecycle", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycle", "()Landroidx/lifecycle/LifecycleRegistry;", "lifecycle$delegate", "Lkotlin/Lazy;", "position", "", "beginLifecycle", "", "endLifecycle", "Landroidx/lifecycle/Lifecycle;", "onCreate", "onDestroy", "onPause", "onResume", "onStart", "onStop", "setSelected", "updatePosition", "lib-feed-news_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewsFlowLifecycleDispatchHelper.kt */
public final class NewsFlowLifecycleDispatchHelper implements LifecycleOwner, LifecycleObserver {
    private Lifecycle.Event currentActivityEvent = Lifecycle.Event.ON_CREATE;
    private boolean isAllowDispatchLifecycle;
    private boolean isSelected;
    private final Lazy lifecycle$delegate = LazyKt.lazy(new NewsFlowLifecycleDispatchHelper$lifecycle$2(this));
    private int position = -1;

    private final LifecycleRegistry getLifecycle() {
        return (LifecycleRegistry) this.lifecycle$delegate.getValue();
    }

    public final void updatePosition(int position2) {
        this.position = position2;
    }

    /* renamed from: getLifecycle  reason: collision with other method in class */
    public Lifecycle m18820getLifecycle() {
        return getLifecycle();
    }

    public final void beginLifecycle() {
        this.isAllowDispatchLifecycle = true;
        if (this.isSelected) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        } else {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent == Lifecycle.Event.ON_RESUME ? Lifecycle.Event.ON_START : this.currentActivityEvent);
        }
    }

    public final void endLifecycle() {
        this.currentActivityEvent = Lifecycle.Event.ON_DESTROY;
        if (this.isAllowDispatchLifecycle) {
            this.isAllowDispatchLifecycle = false;
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    public final void setSelected(boolean isSelected2) {
        this.isSelected = isSelected2;
        if (this.isAllowDispatchLifecycle) {
            if (isSelected2) {
                getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
            } else {
                getLifecycle().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        this.currentActivityEvent = Lifecycle.Event.ON_CREATE;
        if (this.isAllowDispatchLifecycle) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void onStart() {
        this.currentActivityEvent = Lifecycle.Event.ON_START;
        if (this.isAllowDispatchLifecycle) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        this.currentActivityEvent = Lifecycle.Event.ON_RESUME;
        if (this.isSelected && this.isAllowDispatchLifecycle) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        this.currentActivityEvent = Lifecycle.Event.ON_PAUSE;
        if (this.isSelected && this.isAllowDispatchLifecycle) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void onStop() {
        this.currentActivityEvent = Lifecycle.Event.ON_STOP;
        if (this.isAllowDispatchLifecycle) {
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.currentActivityEvent = Lifecycle.Event.ON_DESTROY;
        if (this.isAllowDispatchLifecycle) {
            this.isAllowDispatchLifecycle = false;
            getLifecycle().handleLifecycleEvent(this.currentActivityEvent);
        }
    }
}
