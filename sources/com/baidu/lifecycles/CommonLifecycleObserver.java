package com.baidu.lifecycles;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.config.AppConfig;

public class CommonLifecycleObserver implements ICommonLifecycleEventObserver {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "CommonLifecycleObserver";

    /* renamed from: com.baidu.lifecycles.CommonLifecycleObserver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        switch (AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
            case 1:
                onCreate(source);
                return;
            case 2:
                onStart(source);
                return;
            case 3:
                onResume(source);
                return;
            case 4:
                onPause(source);
                return;
            case 5:
                onStop(source);
                return;
            case 6:
                onDestroy(source);
                return;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                throw new IllegalStateException("Unexpected value: " + event);
        }
    }

    public void onCreate(LifecycleOwner owner) {
    }

    public void onStart(LifecycleOwner owner) {
    }

    public void onResume(LifecycleOwner owner) {
    }

    public void onPause(LifecycleOwner owner) {
    }

    public void onStop(LifecycleOwner owner) {
    }

    public void onDestroy(LifecycleOwner owner) {
    }
}
