package com.baidu.searchbox.hissug.config;

import android.content.Context;
import com.baidu.searchbox.hissug.util.HissugPrefs;
import com.baidu.searchbox.nacomp.extension.util.JSONExtKt;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.ActionData;
import com.baidu.searchbox.net.update.v2.JSONObjectCommandListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J6\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J&\u0010\u0013\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/hissug/config/NoteSearchConfigListener;", "Lcom/baidu/searchbox/net/update/v2/JSONObjectCommandListener;", "()V", "prefs", "Lcom/baidu/searchbox/hissug/util/HissugPrefs;", "addPostData", "", "context", "Landroid/content/Context;", "module", "", "action", "postData", "Lcom/baidu/searchbox/net/update/CommandPostData;", "executeCommand", "", "actionData", "Lcom/baidu/searchbox/net/update/v2/ActionData;", "Lorg/json/JSONObject;", "getLocalVersion", "lib_hissug_frame_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NoteSearchConfigListener.kt */
public final class NoteSearchConfigListener extends JSONObjectCommandListener {
    private final HissugPrefs prefs = HissugPrefs.INSTANCE;

    public void addPostData(Context context, String module, String action, CommandPostData postData) {
        JSONObject version;
        if (postData != null && (version = postData.getVersion()) != null) {
            version.put("note_search_and", getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JSONObject> actionData) {
        JSONObject $this$executeCommand_u24lambda_u2d0;
        boolean z = false;
        if (!Intrinsics.areEqual((Object) "note_search_and", (Object) action) || actionData == null || ($this$executeCommand_u24lambda_u2d0 = (JSONObject) actionData.data) == null) {
            return false;
        }
        HissugPrefs hissugPrefs = this.prefs;
        JSONObject optJSONObject = $this$executeCommand_u24lambda_u2d0.optJSONObject("extra_search_params");
        String str = null;
        String jSONObject = optJSONObject != null ? optJSONObject.toString() : null;
        if (jSONObject == null) {
            jSONObject = "";
        }
        hissugPrefs.putString(NoteSearchConfigListenerKt.SP_EXTRA_SEARCH_PARAMS, jSONObject);
        HissugPrefs hissugPrefs2 = this.prefs;
        JSONArray optJSONArray = $this$executeCommand_u24lambda_u2d0.optJSONArray("disabled_sa_prefix");
        if (optJSONArray != null) {
            str = optJSONArray.toString();
        }
        if (str == null) {
            str = "";
        }
        hissugPrefs2.putString(NoteSearchConfigListenerKt.SP_DISABLED_SA_PREFIX, str);
        this.prefs.putString(NoteSearchConfigListenerKt.SP_HASH_QUERY_REGEX, JSONExtKt.optStringIgnoreNulls($this$executeCommand_u24lambda_u2d0, "hash_query_regex", ""));
        CharSequence charSequence = actionData.version;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            this.prefs.putString("sp_note_search_and_version", actionData.version);
        }
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        String string = this.prefs.getString("sp_note_search_and_version", "0");
        return string == null ? "0" : string;
    }
}
