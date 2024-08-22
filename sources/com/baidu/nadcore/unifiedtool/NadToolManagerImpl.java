package com.baidu.nadcore.unifiedtool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.nadcore.safe.MapUtils;
import com.baidu.nadcore.sp.SafeSpWrapper;
import com.baidu.nadcore.sp.SpUtils;
import com.baidu.nadcore.tool.frame.INadTool;
import com.baidu.nadcore.tool.frame.INadToolManager;
import com.baidu.nadcore.utils.ActivityUtils;
import com.baidu.nps.main.manager.Bundle;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J#\u0010\u0016\u001a\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\r0\u0018H\u0016¢\u0006\u0002\u0010\u0019J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016R7\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/baidu/nadcore/unifiedtool/NadToolManagerImpl;", "Lcom/baidu/nadcore/tool/frame/INadToolManager;", "()V", "tools", "Ljava/util/HashMap;", "", "Lcom/baidu/nadcore/tool/frame/INadTool;", "Lkotlin/collections/HashMap;", "getTools", "()Ljava/util/HashMap;", "tools$delegate", "Lkotlin/Lazy;", "cast", "T", "data", "", "(Ljava/lang/Object;)Ljava/lang/Object;", "enterPanel", "", "context", "Landroid/content/Context;", "fromSp", "select", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "selectAll", "", "toSp", "nadcore-lib-debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadToolManagerImpl.kt */
public final class NadToolManagerImpl implements INadToolManager {
    private final Lazy tools$delegate = LazyKt.lazy(NadToolManagerImpl$tools$2.INSTANCE);

    private final HashMap<String, INadTool> getTools() {
        return (HashMap) this.tools$delegate.getValue();
    }

    public void enterPanel(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if ((context instanceof Activity ? (Activity) context : null) != null) {
            ActivityUtils.startActivitySafely((Activity) context, new Intent(context, NadToolActivity.class));
        }
    }

    public <T> T select(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, Bundle.EXTRA_KEY_CLAZZ);
        return cast(MapUtils.get(getTools(), clazz.getSimpleName()));
    }

    public List<INadTool> selectAll() {
        Collection<INadTool> values = getTools().values();
        Intrinsics.checkNotNullExpressionValue(values, "tools.values");
        return CollectionsKt.toList(values);
    }

    public void toSp() {
        SafeSpWrapper $this$toSp_u24lambda_u2d3 = SpUtils.getInstance().getSp("nad_sdk_tool");
        Collection<INadTool> values = getTools().values();
        Intrinsics.checkNotNullExpressionValue(values, "tools.values");
        for (INadTool tool : CollectionsKt.toList(values)) {
            JSONObject json = tool.state2Json();
            if (json != null) {
                $this$toSp_u24lambda_u2d3.putString(tool.clazz().getSimpleName(), json.toString());
            }
        }
    }

    public void fromSp() {
        SafeSpWrapper $this$fromSp_u24lambda_u2d5 = SpUtils.getInstance().getSp("nad_sdk_tool");
        Collection<INadTool> values = getTools().values();
        Intrinsics.checkNotNullExpressionValue(values, "tools.values");
        for (INadTool it : CollectionsKt.toList(values)) {
            String s = $this$fromSp_u24lambda_u2d5.getString(it.clazz().getSimpleName(), "");
            JSONObject j2 = null;
            if (TextUtils.isEmpty(s)) {
                JSONObject jSONObject = null;
            } else {
                try {
                    j2 = new JSONObject(s);
                } catch (JSONException e2) {
                    JSONObject jSONObject2 = null;
                }
            }
            it.json2State(j2);
        }
    }

    private final <T> T cast(Object data) {
        return data;
    }
}
