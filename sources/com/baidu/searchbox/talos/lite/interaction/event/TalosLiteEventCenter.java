package com.baidu.searchbox.talos.lite.interaction.event;

import com.baidu.searchbox.account.im.BoxMessageManagerImpl;
import com.baidu.searchbox.talos.lite.interaction.msg.IMsgCallback;
import com.baidu.searchbox.talos.lite.utils.TalosLiteConstantsKt;
import com.baidu.swan.apps.textarea.info.TextAreaCallbackInfo;
import com.baidu.talos.util.UiThreadUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eJ\"\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0015J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J*\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0018\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001cJ \u0010!\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ&\u0010#\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R?\u0010\u0005\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00060\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR&\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/talos/lite/interaction/event/TalosLiteEventCenter;", "", "()V", "TAG", "", "actionMsgBus", "", "", "Lcom/baidu/searchbox/talos/lite/interaction/msg/IMsgCallback;", "getActionMsgBus", "()Ljava/util/Map;", "actionMsgBus$delegate", "Lkotlin/Lazy;", "rootViewEventMap", "Lcom/baidu/searchbox/talos/lite/interaction/event/ITalosLiteEventDispatcher;", "addEventDispatcher", "", "eventDispatcher", "addEventDispatchers", "rootViewTag", "dispatchers", "", "clearEvents", "createEventDispatcherByName", "eventName", "dispatchEvent", "viewTag", "paramsJson", "Lorg/json/JSONObject;", "getEventDispatcher", "initRootViewEventMapIfNeed", "parseEventDispatcher", "eventJson", "postMsg", "msgKey", "registerMsg", "host", "msgCallback", "unRegisterMsg", "lib-talos-lite-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TalosLiteEventCenter.kt */
public final class TalosLiteEventCenter {
    public static final TalosLiteEventCenter INSTANCE = new TalosLiteEventCenter();
    private static final String TAG = "TalosLiteEventCenter";
    private static final Lazy actionMsgBus$delegate = LazyKt.lazy(TalosLiteEventCenter$actionMsgBus$2.INSTANCE);
    private static final Map<Long, Map<String, ITalosLiteEventDispatcher>> rootViewEventMap = new HashMap();

    private TalosLiteEventCenter() {
    }

    private final Map<Long, Map<String, Map<String, IMsgCallback>>> getActionMsgBus() {
        return (Map) actionMsgBus$delegate.getValue();
    }

    public final void addEventDispatcher(ITalosLiteEventDispatcher eventDispatcher) {
        Intrinsics.checkNotNullParameter(eventDispatcher, "eventDispatcher");
        long rootViewTag = eventDispatcher.getRootViewTag();
        initRootViewEventMapIfNeed(rootViewTag);
        Map map = rootViewEventMap.get(Long.valueOf(rootViewTag));
        if (map != null) {
            ITalosLiteEventDispatcher iTalosLiteEventDispatcher = (ITalosLiteEventDispatcher) map.put(eventDispatcher.getEventName(), eventDispatcher);
        }
    }

    public final void addEventDispatchers(long rootViewTag, Map<String, ? extends ITalosLiteEventDispatcher> dispatchers) {
        Intrinsics.checkNotNullParameter(dispatchers, "dispatchers");
        initRootViewEventMapIfNeed(rootViewTag);
        Map map = rootViewEventMap.get(Long.valueOf(rootViewTag));
        if (map != null) {
            map.putAll(dispatchers);
        }
    }

    private final void initRootViewEventMapIfNeed(long rootViewTag) {
        Map<Long, Map<String, ITalosLiteEventDispatcher>> map = rootViewEventMap;
        if (map.get(Long.valueOf(rootViewTag)) == null) {
            map.put(Long.valueOf(rootViewTag), new HashMap());
        }
    }

    public final void postMsg(long rootViewTag, String msgKey, JSONObject paramsJson) {
        Map map;
        Collection<IMsgCallback> $this$forEach$iv;
        Intrinsics.checkNotNullParameter(msgKey, BoxMessageManagerImpl.KEY_MSG_PARAM);
        Map map2 = getActionMsgBus().get(Long.valueOf(rootViewTag));
        if (map2 != null && (map = (Map) map2.get(msgKey)) != null && ($this$forEach$iv = map.values()) != null) {
            for (IMsgCallback it : $this$forEach$iv) {
                it.onReceive(paramsJson);
            }
        }
    }

    public final void registerMsg(long rootViewTag, String msgKey, String host, IMsgCallback msgCallback) {
        Map map;
        Map map2;
        Intrinsics.checkNotNullParameter(msgKey, BoxMessageManagerImpl.KEY_MSG_PARAM);
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(msgCallback, "msgCallback");
        if (getActionMsgBus().get(Long.valueOf(rootViewTag)) == null) {
            getActionMsgBus().put(Long.valueOf(rootViewTag), new HashMap());
        }
        Map map3 = getActionMsgBus().get(Long.valueOf(rootViewTag));
        if ((map3 != null ? (Map) map3.get(msgKey) : null) == null && (map2 = getActionMsgBus().get(Long.valueOf(rootViewTag))) != null) {
            Map map4 = (Map) map2.put(msgKey, new HashMap());
        }
        Map map5 = getActionMsgBus().get(Long.valueOf(rootViewTag));
        if (map5 != null && (map = (Map) map5.get(msgKey)) != null) {
            IMsgCallback iMsgCallback = (IMsgCallback) map.put(host, msgCallback);
        }
    }

    public final void unRegisterMsg(long rootViewTag, String msgKey, String host) {
        Map map;
        Intrinsics.checkNotNullParameter(msgKey, BoxMessageManagerImpl.KEY_MSG_PARAM);
        Intrinsics.checkNotNullParameter(host, "host");
        Map map2 = getActionMsgBus().get(Long.valueOf(rootViewTag));
        if (map2 != null && (map = (Map) map2.get(msgKey)) != null) {
            IMsgCallback iMsgCallback = (IMsgCallback) map.remove(host);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher getEventDispatcher(long r5, java.lang.String r7) {
        /*
            r4 = this;
            java.util.Map<java.lang.Long, java.util.Map<java.lang.String, com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher>> r0 = rootViewEventMap
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r1 = r0.get(r1)
            if (r1 != 0) goto L_0x0018
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r0.put(r1, r2)
        L_0x0018:
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r1 = r0.get(r1)
            java.util.Map r1 = (java.util.Map) r1
            r2 = 0
            if (r1 == 0) goto L_0x002c
            java.lang.Object r1 = r1.get(r7)
            com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher r1 = (com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher) r1
            goto L_0x002d
        L_0x002c:
            r1 = r2
        L_0x002d:
            if (r1 != 0) goto L_0x0045
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r1 = r0.get(r1)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x0045
            com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher r3 = r4.createEventDispatcherByName(r5, r7)
            java.lang.Object r1 = r1.put(r7, r3)
            com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher r1 = (com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher) r1
        L_0x0045:
            java.lang.Long r1 = java.lang.Long.valueOf(r5)
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x0058
            java.lang.Object r0 = r0.get(r7)
            r2 = r0
            com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher r2 = (com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher) r2
        L_0x0058:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.talos.lite.interaction.event.TalosLiteEventCenter.getEventDispatcher(long, java.lang.String):com.baidu.searchbox.talos.lite.interaction.event.ITalosLiteEventDispatcher");
    }

    public static /* synthetic */ void dispatchEvent$default(TalosLiteEventCenter talosLiteEventCenter, long j2, long j3, String str, JSONObject jSONObject, int i2, Object obj) {
        JSONObject jSONObject2;
        if ((i2 & 8) != 0) {
            jSONObject2 = null;
        } else {
            jSONObject2 = jSONObject;
        }
        talosLiteEventCenter.dispatchEvent(j2, j3, str, jSONObject2);
    }

    public final void dispatchEvent(long rootViewTag, long viewTag, String eventName, JSONObject paramsJson) {
        Intrinsics.checkNotNullParameter(eventName, TextAreaCallbackInfo.EVENT_NAME_KEY);
        UiThreadUtil.runOnUiThreadImmediately(new TalosLiteEventCenter$$ExternalSyntheticLambda0(rootViewTag, eventName, viewTag, paramsJson));
    }

    /* access modifiers changed from: private */
    /* renamed from: dispatchEvent$lambda-1  reason: not valid java name */
    public static final void m4202dispatchEvent$lambda1(long $rootViewTag, String $eventName, long $viewTag, JSONObject $paramsJson) {
        ITalosLiteEventDispatcher iTalosLiteEventDispatcher;
        Intrinsics.checkNotNullParameter($eventName, "$eventName");
        Map map = rootViewEventMap.get(Long.valueOf($rootViewTag));
        if (map != null && (iTalosLiteEventDispatcher = (ITalosLiteEventDispatcher) map.get($eventName)) != null) {
            iTalosLiteEventDispatcher.dispatch($viewTag, $paramsJson);
        }
    }

    private final ITalosLiteEventDispatcher createEventDispatcherByName(long rootViewTag, String eventName) {
        switch (eventName.hashCode()) {
            case -1411068523:
                if (eventName.equals("appear")) {
                    return new AppearEventDispatcher(rootViewTag, eventName);
                }
                break;
            case -863813940:
                if (eventName.equals(TalosLiteConstantsKt.EVENT_END_OVER_LAP)) {
                    return new ContainerEndOverLapDispatcher(rootViewTag, eventName);
                }
                break;
            case 1081769803:
                if (eventName.equals(TalosLiteConstantsKt.EVENT_RECEIVE_SYNC)) {
                    return new SyncDataDispatcher(rootViewTag, eventName);
                }
                break;
            case 2055124748:
                if (eventName.equals(TalosLiteConstantsKt.EVENT_SCROLL_TO_POS)) {
                    return new ScrollToEventDispatcher(rootViewTag, eventName);
                }
                break;
        }
        return new CommonEventDispatcher(rootViewTag, eventName);
    }

    public final void clearEvents(long rootViewTag) {
        Set<String> $this$forEach$iv;
        Map event = rootViewEventMap.remove(Long.valueOf(rootViewTag));
        if (event != null && ($this$forEach$iv = event.keySet()) != null) {
            for (String key : $this$forEach$iv) {
                Object obj = event.get(key);
                IEventLife iEventLife = obj instanceof IEventLife ? (IEventLife) obj : null;
                if (iEventLife != null) {
                    iEventLife.onDestroy();
                }
            }
        }
    }

    public final void parseEventDispatcher(long rootViewTag, JSONObject eventJson) {
        Intrinsics.checkNotNullParameter(eventJson, "eventJson");
        Iterator eventsNames = eventJson.keys();
        while (eventsNames.hasNext()) {
            String eventName = eventsNames.next();
            JSONArray itemViewEventArray = eventJson.optJSONArray(eventName);
            if (itemViewEventArray != null) {
                int length = itemViewEventArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject it = itemViewEventArray.optJSONObject(i2);
                    if (it != null) {
                        Intrinsics.checkNotNullExpressionValue(it, "optJSONObject(i)");
                        TalosLiteEventCenter talosLiteEventCenter = INSTANCE;
                        Intrinsics.checkNotNullExpressionValue(eventName, TextAreaCallbackInfo.EVENT_NAME_KEY);
                        talosLiteEventCenter.getEventDispatcher(rootViewTag, eventName).addActions(it);
                    }
                }
            }
        }
    }
}
