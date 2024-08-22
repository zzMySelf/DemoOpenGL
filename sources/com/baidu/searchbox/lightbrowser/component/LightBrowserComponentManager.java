package com.baidu.searchbox.lightbrowser.component;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.baidu.searchbox.lightbrowser.component.adapter.ILightBrowserComponentAdapter;
import com.baidu.searchbox.lightbrowser.component.groupguide.GroupPageGuideComponent;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ,\u0010\u000f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J$\u0010\u0016\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J$\u0010\u0019\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00012\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001a\u0010\u001c\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u001d\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u001e\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u001a\u0010\u001f\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001J\u001a\u0010 \u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001Rv\u0010\u0003\u001aj\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012(\u0012&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u00070\u0004j4\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012(\u0012&\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004j\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u0007`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/lightbrowser/component/LightBrowserComponentManager;", "", "()V", "componentMap", "Ljava/util/HashMap;", "", "Lcom/baidu/searchbox/lightbrowser/component/adapter/ILightBrowserComponentAdapter;", "Lkotlin/collections/HashMap;", "canSlide", "", "activity", "Landroid/app/Activity;", "pageKey", "ev", "Landroid/view/MotionEvent;", "handleKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "initComponent", "", "initJsAbility", "mainDispatcher", "Lcom/baidu/searchbox/unitedscheme/UnitedSchemeMainDispatcher;", "onCreate", "rootView", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "lib-lightbrowser-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LightBrowserComponentManager.kt */
public final class LightBrowserComponentManager {
    public static final LightBrowserComponentManager INSTANCE = new LightBrowserComponentManager();
    private static final HashMap<Object, HashMap<String, ILightBrowserComponentAdapter>> componentMap = new HashMap<>();

    private LightBrowserComponentManager() {
    }

    public final void initComponent(Activity activity, Object pageKey) {
        HashMap hashMap;
        if (activity != null && pageKey != null) {
            HashMap<Object, HashMap<String, ILightBrowserComponentAdapter>> hashMap2 = componentMap;
            if (hashMap2.get(pageKey) == null) {
                hashMap2.put(pageKey, new HashMap());
            }
            String componentName = Reflection.getOrCreateKotlinClass(GroupPageGuideComponent.class).getSimpleName();
            HashMap hashMap3 = hashMap2.get(pageKey);
            if ((hashMap3 != null ? (ILightBrowserComponentAdapter) hashMap3.get(componentName) : null) == null && (hashMap = hashMap2.get(pageKey)) != null) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) hashMap.put(componentName, GroupPageGuideComponent.Companion.createInstance(activity));
            }
        }
    }

    public final void onCreate(Activity activity, Object pageKey, ViewGroup rootView) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.onCreate(activity, rootView);
                }
            }
        }
    }

    public final void onStart(Activity activity, Object pageKey) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.onStart(activity);
                }
            }
        }
    }

    public final void onResume(Activity activity, Object pageKey) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.onResume(activity);
                }
            }
        }
    }

    public final void onPause(Activity activity, Object pageKey) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.onPause(activity);
                }
            }
        }
    }

    public final void onStop(Activity activity, Object pageKey) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.onStop(activity);
                }
            }
        }
    }

    public final void onDestroy(Activity activity, Object pageKey) {
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null) {
            HashMap hashMap = componentMap.get(pageKey);
            if (!(hashMap == null || (entries = hashMap.entrySet()) == null)) {
                for (Map.Entry entry : entries) {
                    ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                    if (iLightBrowserComponentAdapter != null) {
                        iLightBrowserComponentAdapter.onDestroy(activity);
                    }
                }
            }
            componentMap.remove(pageKey);
        }
    }

    public final void initJsAbility(Activity activity, Object pageKey, UnitedSchemeMainDispatcher mainDispatcher) {
        HashMap hashMap;
        Set<Map.Entry> entries;
        if (activity != null && pageKey != null && (hashMap = componentMap.get(pageKey)) != null && (entries = hashMap.entrySet()) != null) {
            for (Map.Entry entry : entries) {
                ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                if (iLightBrowserComponentAdapter != null) {
                    iLightBrowserComponentAdapter.initJsAbility(activity, mainDispatcher);
                }
            }
        }
    }

    public final boolean canSlide(Activity activity, Object pageKey, MotionEvent ev) {
        Set<Map.Entry> entries;
        if (activity == null || pageKey == null) {
            return true;
        }
        boolean canSlide = true;
        HashMap hashMap = componentMap.get(pageKey);
        if (!(hashMap == null || (entries = hashMap.entrySet()) == null)) {
            for (Map.Entry entry : entries) {
                boolean z = false;
                if (canSlide) {
                    ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                    if (iLightBrowserComponentAdapter != null && iLightBrowserComponentAdapter.canSlide(activity, ev)) {
                        z = true;
                    }
                }
                canSlide = z;
            }
        }
        return canSlide;
    }

    public final boolean handleKeyDown(Activity activity, Object pageKey, int keyCode, KeyEvent event) {
        Set<Map.Entry> entries;
        if (activity == null || pageKey == null) {
            return false;
        }
        boolean isConsume = false;
        HashMap hashMap = componentMap.get(pageKey);
        if (!(hashMap == null || (entries = hashMap.entrySet()) == null)) {
            for (Map.Entry entry : entries) {
                boolean z = true;
                if (!isConsume) {
                    ILightBrowserComponentAdapter iLightBrowserComponentAdapter = (ILightBrowserComponentAdapter) entry.getValue();
                    if (!(iLightBrowserComponentAdapter != null && iLightBrowserComponentAdapter.handleKeyDown(activity, keyCode, event))) {
                        z = false;
                    }
                }
                isConsume = z;
            }
        }
        return isConsume;
    }
}
