package com.baidu.speech.dcs.connection;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.speech.LcConstant;
import com.baidu.speech.utils.LogUtil;
import com.baidu.speech.utils.Policy;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class SocketMessage {
    private static final String TAG = "SocketMessage";
    public static final int TYPE_REQUEST_ACTIVE = 16;
    public static final int TYPE_REQUEST_CONTROL = 17;
    public static final int TYPE_REQUEST_DATA = 18;
    private byte[] data;
    private int length;
    private String listenerKey;
    private String message;
    private String name;
    private int offset;
    private String params;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int type2) {
        this.type = type2;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name2) {
        this.name = name2;
    }

    public String getParams() {
        return this.params;
    }

    public void setParams(String params2) {
        this.params = params2;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset2) {
        this.offset = offset2;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length2) {
        this.length = length2;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message2) {
        this.message = message2;
        if (!TextUtils.isEmpty(message2)) {
            try {
                String optionstr = new JSONObject(message2).optString("sdk_data");
                if (!TextUtils.isEmpty(optionstr)) {
                    this.listenerKey = new JSONObject(optionstr).optString("responseListenerkey");
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data2) {
        if (data2 != null && data2.length > 0) {
            byte[] bArr = new byte[data2.length];
            this.data = bArr;
            System.arraycopy(data2, 0, bArr, 0, data2.length);
        }
    }

    public void setControlMessage(String message2, Context context) {
        JSONObject appendedMsg;
        try {
            if (TextUtils.isEmpty(message2)) {
                appendedMsg = new JSONObject();
            } else {
                appendedMsg = new JSONObject(message2);
            }
            appendedMsg.put("pid", Util.getDcsLCPid());
            appendedMsg.put("key", LcConstant.LC_KEY);
            String uid = Util.getDcsLCUid();
            if (TextUtils.isEmpty(uid)) {
                uid = Policy.uid(context);
            }
            appendedMsg.put("cuid", uid);
            this.message = appendedMsg.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.message = message2;
        }
        LogUtil.i(TAG, "this.message=" + this.message);
    }

    public String getListenerKey() {
        return this.listenerKey;
    }

    public String toString() {
        return "SocketMessage{type=" + this.type + ", message='" + this.message + '\'' + ", name='" + this.name + '\'' + ", listenerKey='" + this.listenerKey + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
