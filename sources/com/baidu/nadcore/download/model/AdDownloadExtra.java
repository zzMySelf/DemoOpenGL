package com.baidu.nadcore.download.model;

import com.baidu.nadcore.safe.JSONUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdDownloadExtra {
    public String ext1 = "";
    public String ext2 = "";
    public String ext3 = "";

    public static AdDownloadExtra fromJSON(String sz) {
        AdDownloadExtra ext = new AdDownloadExtra();
        JSONObject o = JSONUtils.newJSONObject(sz);
        ext.ext1 = o.optString("ext1");
        ext.ext2 = o.optString("ext2");
        ext.ext3 = o.optString("ext3");
        return ext;
    }

    public static String toJSON(AdDownloadExtra r) {
        JSONObject o = new JSONObject();
        try {
            o.put("ext1", r.ext1);
            o.put("ext2", r.ext2);
            o.put("ext3", r.ext3);
        } catch (JSONException e2) {
        }
        return o.toString();
    }
}
