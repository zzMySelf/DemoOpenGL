package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXStateSceneDataObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXStateJumpChannelProfileInfo implements WXStateSceneDataObject.IWXStateJumpInfo {
    public static final String TAG = "MicroMsg.SDK.WXStateJumpUrlInfo";
    public static final int USERNAME_LENGTH_LIMIT = 1024;
    public String username;

    public boolean checkArgs() {
        String str;
        String str2 = this.username;
        if (str2 == null || str2.length() <= 0) {
            str = "checkArgs fail, username is null";
        } else if (this.username.length() < 1024) {
            return true;
        } else {
            str = "checkArgs fail, username length exceed limit";
        }
        Log.e("MicroMsg.SDK.WXStateJumpUrlInfo", str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("wx_state_jump_channel_profile_username", this.username);
    }

    public int type() {
        return 3;
    }

    public void unserialize(Bundle bundle) {
        this.username = bundle.getString("wx_state_jump_channel_profile_username", "");
    }
}
