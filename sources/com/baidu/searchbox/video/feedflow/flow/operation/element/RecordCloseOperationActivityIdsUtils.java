package com.baidu.searchbox.video.feedflow.flow.operation.element;

import com.baidu.searchbox.video.detail.switcher.VideoSPData;
import com.baidu.searchbox.video.detail.utils.JsonTools;
import com.baidu.searchbox.video.detail.utils.NumberUtilsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/operation/element/RecordCloseOperationActivityIdsUtils;", "", "()V", "<set-?>", "", "closeOperationMapCache", "getCloseOperationMapCache", "()Ljava/lang/String;", "setCloseOperationMapCache", "(Ljava/lang/String;)V", "closeOperationMapCache$delegate", "Lcom/baidu/searchbox/video/detail/switcher/VideoSPData;", "isContainsOperationCloseId", "", "id", "isExpire", "endTime", "obtainCloseActIds", "recordCloseActIds", "", "closeId", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordCloseOperationActivityIdsUtils.kt */
public final class RecordCloseOperationActivityIdsUtils {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(RecordCloseOperationActivityIdsUtils.class, "closeOperationMapCache", "getCloseOperationMapCache()Ljava/lang/String;", 0))};
    public static final RecordCloseOperationActivityIdsUtils INSTANCE = new RecordCloseOperationActivityIdsUtils();
    private static final VideoSPData closeOperationMapCache$delegate = new VideoSPData("key_video_flow_operation_close_ids", "", false, (String) null, 12, (DefaultConstructorMarker) null);

    private RecordCloseOperationActivityIdsUtils() {
    }

    private final String getCloseOperationMapCache() {
        return (String) closeOperationMapCache$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setCloseOperationMapCache(String str) {
        closeOperationMapCache$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void recordCloseActIds(String closeId, String endTime) {
        Intrinsics.checkNotNullParameter(closeId, "closeId");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        if (!(closeId.length() == 0) && !isExpire(endTime)) {
            Map closeOperationMap = JsonTools.json2Map(getCloseOperationMapCache());
            String str = null;
            if (!TypeIntrinsics.isMutableMap(closeOperationMap)) {
                closeOperationMap = null;
            }
            if (closeOperationMap == null) {
                closeOperationMap = new LinkedHashMap();
            }
            if (!closeOperationMap.containsKey(closeId)) {
                closeOperationMap.put(closeId, endTime);
                JSONObject map2Json = JsonTools.map2Json(closeOperationMap);
                if (map2Json != null) {
                    str = map2Json.toString();
                }
                if (str == null) {
                    str = "";
                }
                setCloseOperationMapCache(str);
            }
        }
    }

    public final String obtainCloseActIds() {
        String str;
        Map closeOperationMap = JsonTools.json2Map(getCloseOperationMapCache());
        String str2 = null;
        if (!TypeIntrinsics.isMutableMap(closeOperationMap)) {
            closeOperationMap = null;
        }
        if (closeOperationMap == null) {
            closeOperationMap = new LinkedHashMap();
        }
        Iterator iterator = closeOperationMap.entrySet().iterator();
        while (true) {
            str = "";
            if (!iterator.hasNext()) {
                break;
            }
            Object value = iterator.next().getValue();
            String str3 = value instanceof String ? (String) value : null;
            if (str3 != null) {
                str = str3;
            }
            if (isExpire(str)) {
                iterator.remove();
            }
        }
        JSONObject map2Json = JsonTools.map2Json(closeOperationMap);
        if (map2Json != null) {
            str2 = map2Json.toString();
        }
        if (str2 != null) {
            str = str2;
        }
        setCloseOperationMapCache(str);
        return CollectionsKt.joinToString$default(CollectionsKt.toMutableList(closeOperationMap.keySet()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final boolean isExpire(String endTime) {
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        return (endTime.length() == 0) || System.currentTimeMillis() / 1000 > NumberUtilsKt.toLongSafely(endTime);
    }

    public final boolean isContainsOperationCloseId(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Map closeOperationMap = JsonTools.json2Map(getCloseOperationMapCache());
        if (!TypeIntrinsics.isMutableMap(closeOperationMap)) {
            closeOperationMap = null;
        }
        if (closeOperationMap == null) {
            closeOperationMap = new LinkedHashMap();
        }
        return closeOperationMap.keySet().contains(id);
    }
}
