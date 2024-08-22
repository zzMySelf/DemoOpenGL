package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.mm.opensdk.utils.Log;

public abstract class WXChannelBaseJumpInfo implements IWXChannelJumpInfo {
    public static final String TAG = "MicroMsg.SDK.WXChannelBaseJumpInfo";
    public static final int WORDING_LENGTH_LIMIT = 1024;
    public String extra;
    public String wording;

    public boolean checkArgs() {
        String str = this.wording;
        if (str == null || str.length() < 1024) {
            return true;
        }
        Log.e(TAG, "checkArgs fail, wording is invalid");
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("wx_channel_jump_base_wording", this.wording);
        bundle.putString("wx_channel_jump_base_extra", this.extra);
    }

    public void unserialize(Bundle bundle) {
        this.wording = bundle.getString("wx_channel_jump_base_wording");
        this.extra = bundle.getString("wx_channel_jump_base_extra");
    }
}
