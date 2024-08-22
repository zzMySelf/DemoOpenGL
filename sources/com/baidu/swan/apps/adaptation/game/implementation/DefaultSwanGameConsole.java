package com.baidu.swan.apps.adaptation.game.implementation;

import android.app.Activity;
import android.content.DialogInterface;
import com.baidu.swan.apps.adaptation.game.interfaces.ISwanGameConsole;
import com.baidu.swan.apps.util.typedbox.TypedCallback;
import com.baidu.swan.pms.callback.PMSCallback;
import org.json.JSONObject;

public class DefaultSwanGameConsole implements ISwanGameConsole {
    public PMSCallback getConsoleJsDownloadCallback() {
        return null;
    }

    public void postCmdMessageToSwan(JSONObject cmd) {
    }

    public void sendJsConsoleLog(int consoleLogLevel, String log) {
    }

    public void loadConsoleResource(TypedCallback<Boolean> typedCallback) {
    }

    public String getConsoleVersionName() {
        return null;
    }

    public void showLoadFailedDialog(Activity activity, DialogInterface.OnClickListener listener) {
    }
}
