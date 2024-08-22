package com.baidu.map.braavos;

import com.baidu.map.braavos.ModuleMessage;
import com.baidu.map.braavos.util.MLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class CallbackContext {
    private static final String TAG = "Braavos-CallbackContext";
    private String callbackId;
    private int changingThreads;
    protected boolean finished;
    private BraavosWebView webView;

    public CallbackContext(String callbackId2, BraavosWebView webView2) {
        this.callbackId = callbackId2;
        this.webView = webView2;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public boolean isChangingThreads() {
        return this.changingThreads > 0;
    }

    public String getCallbackId() {
        return this.callbackId;
    }

    public void sendModuleMessage(ModuleMessage message) {
        synchronized (this) {
            if (this.finished) {
                MLog.w(TAG, "Attempted to send a second callback for ID: " + this.callbackId + "\nResult was: " + message.getMessage());
                return;
            }
            MLog.d(TAG, "sendModuleMessage(), not finished:" + this.callbackId);
            this.finished = !message.getKeepCallback();
            this.webView.sendModuleMessage(message, this.callbackId);
        }
    }

    public void success(JSONObject message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK, message));
    }

    public void success(String message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK, message));
    }

    public void success(JSONArray message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK, message));
    }

    public void success(byte[] message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK, message));
    }

    public void success(int message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK, message));
    }

    public void success() {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.OK));
    }

    public void error(JSONObject message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.ERROR, message));
    }

    public void error(String message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.ERROR, message));
    }

    public void error(int message) {
        sendModuleMessage(new ModuleMessage(ModuleMessage.Status.ERROR, message));
    }
}
