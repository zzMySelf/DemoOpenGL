package com.baidu.browser.components.commonmenu.advancefilter;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.android.util.KVStorageFactory;
import com.baidu.browser.SearchConstants;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J6\u0010\f\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J&\u0010\u0011\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u0012"}, d2 = {"Lcom/baidu/browser/components/commonmenu/advancefilter/SearchVsFilterListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "value", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchVsFilterListener.kt */
public final class SearchVsFilterListener extends JSONObjectCommandListener {
    public SearchVsFilterListener() {
        if (ResultPageABTest.enableVsFilterMockData()) {
            try {
                Result.Companion companion = Result.Companion;
                Result.m8971constructorimpl(Boolean.valueOf(SearchVsFilterDataManager.INSTANCE.saveDataToDiskFromUpdate(new JSONObject("{\"note\":[{\"title\":\"排序方式\",\"items\":[{\"title\":\"最新\", \"params\":{\"sa\":\"no_pv_rk_1\",\"gpc\":\"tr%3D3\",\"debug\":\"1\"}},{\"title\":\"最热\", \"params\":{\"sa\":\"no_pv_rk_2\",\"gpc\":\"tr%3D2\",\"debug\":\"1\"}}]}],\"video\":[{\"title\":\"排序方式\",\"items\":[{\"title\":\"最新\", \"params\":{\"vrs\":\"1\",\"debug\":\"1\"}},{\"title\":\"最热\", \"params\":{\"vrs\":\"2\",\"debug\":\"1\"}}]}]}"))));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
        }
    }

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put(SearchConstants.HEADER_VALUE_VS_FILTER, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> value) {
        SharedPreferences.Editor edit;
        SharedPreferences.Editor putString;
        JSONObject data = value != null ? (JSONObject) value.data : null;
        if (data == null || !Intrinsics.areEqual((Object) module, (Object) "search") || !Intrinsics.areEqual((Object) action, (Object) SearchConstants.HEADER_VALUE_VS_FILTER)) {
            return false;
        }
        if (!SearchVsFilterDataManager.INSTANCE.saveDataToDiskFromUpdate(data) || (edit = KVStorageFactory.getDefaultSharedPreferences().edit()) == null || (putString = edit.putString("vs_filter_gcp_version", value.version)) == null) {
            return true;
        }
        putString.apply();
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = KVStorageFactory.getDefaultSharedPreferences().getString("vs_filter_gcp_version", "0");
        return string == null ? "0" : string;
    }
}
