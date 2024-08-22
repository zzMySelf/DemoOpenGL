package com.baidu.searchbox.padhome;

import android.view.KeyEvent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\tJ\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u000fJ\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u000fJ\u001a\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u001a\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u0006\u0010 \u001a\u00020\tJ\u000e\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000fJ\u0006\u0010#\u001a\u00020\tJ\b\u0010$\u001a\u00020\tH\u0007J.\u0010%\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/searchbox/padhome/PadHomeEventRegistry;", "", "()V", "mObserverList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/baidu/searchbox/padhome/IPadHomeEventExt;", "mOutObserverList", "Lcom/baidu/searchbox/padhome/IPadHomeEventListener;", "addObserver", "", "observer", "addOutObserver", "clear", "dispatchConfigurationChanged", "isPadHorizontal", "", "width", "", "height", "dispatchDestroyEvent", "dispatchFontSizeChanged", "dispatchHomePageVisible", "visible", "dispatchHomeStateChanged", "oldState", "newState", "byTouch", "dispatchKeyDownEvent", "keyCode", "event", "Landroid/view/KeyEvent;", "dispatchKeyUpEvent", "dispatchLazyUiReady", "dispatchNightModeChanged", "isNightMode", "dispatchPauseEvent", "dispatchResumeEvent", "dispatchSizeChanged", "oldWidth", "oldHeight", "pad-home-page_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadHomeEventRegistry.kt */
public final class PadHomeEventRegistry {
    private final CopyOnWriteArrayList<IPadHomeEventExt> mObserverList = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<IPadHomeEventListener> mOutObserverList = new CopyOnWriteArrayList<>();

    public final void addObserver(IPadHomeEventExt observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mObserverList.contains(observer)) {
            this.mObserverList.add(observer);
        }
    }

    public final void addOutObserver(IPadHomeEventListener observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (!this.mOutObserverList.contains(observer)) {
            this.mOutObserverList.add(observer);
        }
    }

    public final void clear() {
        this.mObserverList.clear();
        this.mOutObserverList.clear();
    }

    public final boolean dispatchKeyDownEvent(int keyCode, KeyEvent event) {
        boolean z;
        boolean z2;
        Iterator it = this.mObserverList.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                IPadHomeEventExt it2 = (IPadHomeEventExt) it.next();
                if (it2 != null && it2.onFragmentKeyDown(keyCode, event)) {
                    z = true;
                    continue;
                }
            } else {
                for (IPadHomeEventListener it3 : this.mOutObserverList) {
                    if (it3 == null || !it3.onFragmentKeyDown(keyCode, event)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            }
        } while (!z);
        return true;
    }

    public final boolean dispatchKeyUpEvent(int keyCode, KeyEvent event) {
        boolean z;
        boolean z2;
        Iterator it = this.mObserverList.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                IPadHomeEventExt it2 = (IPadHomeEventExt) it.next();
                if (it2 != null && it2.onFragmentKeyUp(keyCode, event)) {
                    z = true;
                    continue;
                }
            } else {
                for (IPadHomeEventListener it3 : this.mOutObserverList) {
                    if (it3 == null || !it3.onFragmentKeyUp(keyCode, event)) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        return true;
                    }
                }
                return false;
            }
        } while (!z);
        return true;
    }

    public final void dispatchResumeEvent() {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onResume();
        }
    }

    public final void dispatchPauseEvent() {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onPause();
        }
    }

    public final void dispatchDestroyEvent() {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onDestroy();
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onDestroy();
        }
    }

    public final void dispatchHomePageVisible(boolean visible) {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onHomePageVisible(visible);
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onHomePageVisible(visible);
        }
    }

    public final void dispatchHomeStateChanged(int oldState, int newState, boolean byTouch) {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onHomeStateChanged(oldState, newState, byTouch);
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onHomeStateChanged(oldState, newState, byTouch);
        }
    }

    public final void dispatchLazyUiReady() {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onLazyUiReady();
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onLazyUiReady();
        }
    }

    public final void dispatchNightModeChanged(boolean isNightMode) {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onNightModeChanged(isNightMode);
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onNightModeChanged(isNightMode);
        }
    }

    public final void dispatchFontSizeChanged() {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onFontSizeChanged();
        }
        for (IPadHomeEventListener it2 : this.mOutObserverList) {
            it2.onFontSizeChanged();
        }
    }

    public final void dispatchSizeChanged(boolean isPadHorizontal, int width, int height, int oldWidth, int oldHeight) {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onHomeSizeChanged(isPadHorizontal, width, height, oldWidth, oldHeight);
        }
    }

    public final void dispatchConfigurationChanged(boolean isPadHorizontal, int width, int height) {
        for (IPadHomeEventExt it : this.mObserverList) {
            it.onConfigurationChanged(isPadHorizontal, width, height);
        }
    }
}
