package com.baidu.searchbox.schemedispatch.monitor;

import android.util.Log;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.schemedispatch.SchemeStatisticField;
import com.baidu.searchbox.schemedispatch.forbid.SchemeForbidStatisticUtils;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfo;
import com.baidu.searchbox.schemedispatch.monitor.bean.SchemeCheckInfoKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J \u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0018\u0010\u0017\u001a\u00020\u00112\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0019H\u0002R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/schemedispatch/monitor/OpenAppDeepLinkCheck;", "Lcom/baidu/searchbox/schemedispatch/monitor/OpenAppBaseCheck;", "Lcom/baidu/searchbox/schemedispatch/monitor/IDeepLinkCheck;", "()V", "deepLinkWhiteList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/schemedispatch/monitor/bean/SchemeCheckInfo;", "Lkotlin/collections/ArrayList;", "checkSchemeInDeepLinkWhiteList", "originScheme", "", "fields", "Lcom/baidu/searchbox/schemedispatch/SchemeStatisticField;", "jsonArray2List", "deepLinkWListJson", "Lorg/json/JSONArray;", "loadDeepLinkWhiteList", "", "loadWhiteListAsync", "saveWhiteListDispatch", "", "data", "Lorg/json/JSONObject;", "updateWhiteList", "deepLinkWList", "", "lib-security-openapp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenAppDeepLinkCheck.kt */
public final class OpenAppDeepLinkCheck extends OpenAppBaseCheck implements IDeepLinkCheck {
    private final ArrayList<SchemeCheckInfo> deepLinkWhiteList = new ArrayList<>();

    /* access modifiers changed from: protected */
    public boolean saveWhiteListDispatch(JSONObject data) {
        JSONArray deepLinkWListJson = data != null ? data.optJSONArray("deeplink_wlist") : null;
        if (deepLinkWListJson != null) {
            ArrayList<String> jsonArray2List = jsonArray2List(deepLinkWListJson);
            boolean result = OpenAppBaseCheck.writeCache(jsonArray2List, "scheme_deep_link_white_list_invoke");
            if (result) {
                updateWhiteList(jsonArray2List);
            }
            return result;
        } else if (!OpenAppBaseCheck.DEBUG) {
            return false;
        } else {
            Log.v("OpenAppDeepLinkCheck", "warning!!! deepLink write list is empty");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void loadWhiteListAsync() {
        ExecutorUtilsExt.postOnElastic(new OpenAppDeepLinkCheck$$ExternalSyntheticLambda0(this), "SchemeDeepLinkWhiteListLoad", 2);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadWhiteListAsync$lambda-0  reason: not valid java name */
    public static final void m2724loadWhiteListAsync$lambda0(OpenAppDeepLinkCheck this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.loadDeepLinkWhiteList();
        FileUtils.deleteCache(AppRuntime.getAppContext(), "scheme_deep_link_white_list");
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    private final synchronized void updateWhiteList(List<String> deepLinkWList) {
        if (OpenAppBaseCheck.DEBUG) {
            Log.v("OpenAppDeepLinkCheck", "updateWhiteList deepLinkWList.size = " + (deepLinkWList != null ? deepLinkWList.size() : -1));
        }
        this.deepLinkWhiteList.clear();
        if (deepLinkWList != null) {
            this.deepLinkWhiteList.addAll(SchemeCheckInfoKt.toSchemeCheckInfoList(deepLinkWList));
        }
    }

    private final ArrayList<String> jsonArray2List(JSONArray deepLinkWListJson) {
        ArrayList tempDeepLinkWList = new ArrayList();
        int jsonSize = deepLinkWListJson.length();
        for (int i2 = 0; i2 < jsonSize; i2++) {
            String scheme = deepLinkWListJson.optString(i2);
            CharSequence charSequence = scheme;
            if (!(charSequence == null || charSequence.length() == 0)) {
                tempDeepLinkWList.add(scheme);
            }
        }
        return tempDeepLinkWList;
    }

    private final void loadDeepLinkWhiteList() {
        if (OpenAppBaseCheck.DEBUG) {
            Log.v("OpenAppDeepLinkCheck", "loadDeepLinkWhiteList");
        }
        updateWhiteList(OpenAppBaseCheck.readCache("scheme_deep_link_white_list_invoke"));
    }

    public synchronized SchemeCheckInfo checkSchemeInDeepLinkWhiteList(String originScheme, SchemeStatisticField fields) {
        SchemeCheckInfo match;
        match = OpenAppBaseCheck.getInfoInList(originScheme, this.deepLinkWhiteList);
        if (OpenAppBaseCheck.DEBUG) {
            Log.v("OpenAppDeepLinkCheck", "checkSchemeInDeepLinkWhiteList isInWhitList = " + match);
        }
        if (fields != null) {
            SchemeStatisticField it = fields;
            it.addField("scheme", originScheme).addField("enable", "1").addField("type", "clk_deeplink").addField("invokable", OpenAppBaseCheck.canInvoke(match) ? "1" : "0");
            SchemeForbidStatisticUtils.onEvent(it);
        }
        return match;
    }
}
