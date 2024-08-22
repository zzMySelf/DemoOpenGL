package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXGameLiveObject implements WXMediaMessage.IMediaObject {
    public static final String TAG = "MicroMsg.SDK.WXGameObject";
    public HashMap<String, String> extraInfoMap = new HashMap<>();

    public boolean checkArgs() {
        return true;
    }

    public String getExtra(String str, String str2) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap == null) {
            return null;
        }
        String str3 = hashMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public void putExtra(String str, String str2) {
        if (this.extraInfoMap == null) {
            this.extraInfoMap = new HashMap<>();
        }
        if (!b.b(str)) {
            this.extraInfoMap.put(str, str2);
        }
    }

    public void serialize(Bundle bundle) {
        HashMap<String, String> hashMap = this.extraInfoMap;
        if (hashMap != null) {
            bundle.putSerializable("_wxgame_extrainfo", hashMap);
        }
    }

    public int type() {
        return 70;
    }

    public void unserialize(Bundle bundle) {
        this.extraInfoMap = (HashMap) bundle.getSerializable("_wxgame_extrainfo");
    }
}
