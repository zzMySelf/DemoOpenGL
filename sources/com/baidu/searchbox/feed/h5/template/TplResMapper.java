package com.baidu.searchbox.feed.h5.template;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.feed.h5.H5Runtime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TplResMapper {
    private static final String MANIFEST_JSON = "manifest.json";
    private static final String TAG = "hybrid_sdk_TplResMapper";
    private String ROOT_PATH = "";
    private List<Entry> mEntries = new ArrayList();
    private boolean mIsReady = false;
    private List<Node> mNodes = new ArrayList();
    private String name = "";
    private String version = "-1";

    public void prepare(File tpl) {
        long starTime = System.currentTimeMillis();
        if (tpl == null || TextUtils.isEmpty(tpl.getPath())) {
            this.mIsReady = false;
            return;
        }
        this.mIsReady = construct(tpl.getPath());
        if (H5Runtime.isDebug()) {
            Log.d(TAG, "总共耗时 ：" + (System.currentTimeMillis() - starTime));
        }
    }

    private boolean construct(String rootPath) {
        if (TextUtils.isEmpty(rootPath)) {
            return false;
        }
        this.ROOT_PATH = rootPath;
        JSONObject object = readManifestJson(rootPath);
        if (object == null) {
            return false;
        }
        this.name = object.optString("name");
        this.version = object.optString("version");
        JSONArray entryJsonArray = object.optJSONArray("entry");
        JSONArray nodeJsonArray = object.optJSONArray("files");
        if (entryJsonArray != null) {
            for (int i2 = 0; i2 < entryJsonArray.length(); i2++) {
                try {
                    this.mEntries.add(new Entry(entryJsonArray.getJSONObject(i2)));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (nodeJsonArray == null) {
            return true;
        }
        for (int i3 = 0; i3 < nodeJsonArray.length(); i3++) {
            try {
                this.mNodes.add(new Node(nodeJsonArray.getJSONObject(i3)));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        return true;
    }

    public boolean isReady() {
        return this.mIsReady;
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        if (StringUtil.isNumbers(this.version)) {
            return Long.parseLong(this.version);
        }
        return -1;
    }

    public String getEntryPathUrl(String tpl_id) {
        if (TextUtils.isEmpty(tpl_id)) {
            return "";
        }
        for (Entry item : this.mEntries) {
            if (item != null && tpl_id.contains(item.url)) {
                return "file://" + this.ROOT_PATH + File.separator + item.filePath;
            }
        }
        return "";
    }

    private String getNodePath(String url) {
        if (TextUtils.isEmpty(url)) {
            return "";
        }
        for (Node item : this.mNodes) {
            if (item != null && url.contains(item.url)) {
                return this.ROOT_PATH + File.separator + item.filePath;
            }
        }
        return "";
    }

    public File getNodeFile(String url) {
        String path = getNodePath(url);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = new File(path);
        if (file.exists()) {
            return file;
        }
        return null;
    }

    private JSONObject readManifestJson(String tplFilePath) {
        if (TextUtils.isEmpty(tplFilePath)) {
            return null;
        }
        File tplFile = new File(tplFilePath);
        if (!tplFile.exists() || !tplFile.isDirectory()) {
            return null;
        }
        File packageJsonFile = new File(tplFile, "manifest.json");
        if (packageJsonFile.exists()) {
            try {
                try {
                    return new JSONObject(StreamUtils.streamToString(new FileInputStream(packageJsonFile)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
            }
        }
        return null;
    }

    private class Entry {
        String filePath;
        String prefetchJson;
        String url;

        Entry(JSONObject jsonObject) {
            this.url = jsonObject.optString("tpl_id");
            this.filePath = jsonObject.optString("file");
            this.prefetchJson = jsonObject.optString("prefetch");
        }
    }

    private class Node {
        String filePath;
        String url;

        Node(JSONObject jsonObject) {
            this.url = jsonObject.optString("url");
            this.filePath = jsonObject.optString("file");
        }
    }
}
