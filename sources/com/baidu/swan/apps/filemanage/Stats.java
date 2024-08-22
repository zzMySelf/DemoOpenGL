package com.baidu.swan.apps.filemanage;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import org.json.JSONException;
import org.json.JSONObject;

public class Stats {
    private boolean isDirectory;
    private boolean isFile;
    @V8JavascriptField
    public long lastAccessedTime;
    @V8JavascriptField
    public long lastModifiedTime;
    @V8JavascriptField
    public long mode;
    @V8JavascriptField
    public long size;

    @JavascriptInterface
    public boolean isDirectory() {
        return this.isDirectory;
    }

    @JavascriptInterface
    public boolean isFile() {
        return this.isFile;
    }

    public void setIsDirectory(boolean isDirectory2) {
        this.isDirectory = isDirectory2;
    }

    public void setIsFile(boolean isFile2) {
        this.isFile = isFile2;
    }

    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("mode", this.mode);
            obj.put("size", this.size);
            obj.put("lastAccessedTime", this.lastAccessedTime);
            obj.put("lastModifiedTime", this.lastModifiedTime);
            obj.put("isDirectory", this.isDirectory);
            obj.put("isFile", this.isFile);
        } catch (JSONException e2) {
        }
        return obj;
    }
}
