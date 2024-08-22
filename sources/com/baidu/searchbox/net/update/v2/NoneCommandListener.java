package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.searchbox.net.update.CommandPostData;
import com.google.gson.JsonElement;
import org.json.JSONException;

public class NoneCommandListener extends AbstractCommandListener<JsonElement> {
    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<JsonElement> actionData) {
        return false;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return null;
    }
}
