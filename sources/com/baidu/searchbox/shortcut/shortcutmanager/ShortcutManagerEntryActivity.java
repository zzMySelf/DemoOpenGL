package com.baidu.searchbox.shortcut.shortcutmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.DataFlowDialog;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.appframework.AppFrameworkRuntime;
import com.baidu.searchbox.appframework.BaseActivity;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.command.CommandUtils;
import com.baidu.searchbox.unitedscheme.SchemeConfig;
import com.baidu.ubc.UBC;
import org.json.JSONException;
import org.json.JSONObject;

public class ShortcutManagerEntryActivity extends BaseActivity {
    protected static final boolean DEBUG = SearchBox.GLOBAL_DEBUG;
    private static final String EXTERNALEND_BACKHOME_TEST_KEY = "Externalend_backhome";
    private static final String FROM_3DSHORTCUTS = "3DShortcuts";
    private static final String ID_SCANQR = "scanqr";
    private static final String SCHEMA_TAG = "";
    protected static final String TAG = "ShortcutManager";
    private static final String UBC_VALUE_NEWSYS_FROM = "android_feature";
    private static final String UBC_VALUE_NEWSYS_TYPE_SHORTCUT_TYPE = "Android_3DShortcuts";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        Bundle bundle;
        boolean invokeResult;
        super.onCreate(savedInstanceState);
        if (!DataFlowDialog.isDataFlowPopDialog(this) && (bundle = getIntent().getExtras()) != null) {
            String command = bundle.getString("command");
            String id = bundle.getString("id");
            if (!TextUtils.isEmpty(command)) {
                if (AbTestManager.getInstance().getSwitch(EXTERNALEND_BACKHOME_TEST_KEY, 0) == 1) {
                    BaseActivity.sBackHomeFrom = FROM_3DSHORTCUTS;
                    BaseActivity.sBackHomeSource = id;
                    if (TextUtils.equals(id, ID_SCANQR) && BdBoxActivityManager.getActivityCount() == 1) {
                        AppFrameworkRuntime.backHome(this, true);
                    }
                }
                if (command.startsWith(SchemeConfig.getSchemeHead())) {
                    invokeResult = Router.invokeScheme(this, Uri.parse(command), "inside");
                } else {
                    invokeResult = CommandUtils.invokeCommand((Context) this, command);
                }
                if (DEBUG) {
                    Log.i(TAG, "invoke result:" + invokeResult);
                }
                try {
                    JSONObject eventObj = new JSONObject();
                    eventObj.put("from", "android_feature");
                    eventObj.put("type", UBC_VALUE_NEWSYS_TYPE_SHORTCUT_TYPE);
                    eventObj.put("value", id);
                    UBC.onEvent("430", eventObj.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        finish();
    }
}
