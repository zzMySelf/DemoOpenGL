package com.baidu.searchbox.net.connectivityinfo.clientip;

import android.text.TextUtils;
import android.util.Base64;
import java.net.InetAddress;
import org.json.JSONException;
import org.json.JSONObject;

public class ClientIPData {
    private static final String ENCODE_VERSION = "1.0";
    private static final String KEY_IP = "ip";
    private static final String KEY_IPV6 = "ipv6";
    private static final String SPLIT_SYMBOL = ",";
    private String mIP;
    private String mIPv6;

    ClientIPData() {
        this((String) null, (String) null);
    }

    ClientIPData(String ip, String ipv6) {
        this.mIP = ip;
        this.mIPv6 = ipv6;
    }

    ClientIPData(String jsonString) {
        if (!TextUtils.isEmpty(jsonString)) {
            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                this.mIP = jsonObject.optString("ip");
                this.mIPv6 = jsonObject.optString(KEY_IPV6);
            } catch (JSONException e2) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getIP() {
        return this.mIP;
    }

    /* access modifiers changed from: package-private */
    public String getIPv6() {
        return this.mIPv6;
    }

    /* access modifiers changed from: package-private */
    public boolean valid() {
        return !TextUtils.isEmpty(getIP()) || !TextUtils.isEmpty(this.mIPv6);
    }

    /* access modifiers changed from: package-private */
    public void update(ClientIPData clientIPData) {
        if (clientIPData != null) {
            this.mIP = clientIPData.mIP;
            this.mIPv6 = clientIPData.getIPv6();
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mIP = null;
        this.mIPv6 = null;
    }

    public String toString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("ip", this.mIP);
            jsonObject.putOpt(KEY_IPV6, this.mIPv6);
        } catch (JSONException e2) {
        }
        return jsonObject.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ClientIPData) || !isSameIP(this.mIP, ((ClientIPData) obj).mIP) || !isSameIP(this.mIPv6, ((ClientIPData) obj).mIPv6)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String toDecodedString() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.putOpt("ip", decodeClientIP(this.mIP));
            jsonObject.putOpt(KEY_IPV6, decodeClientIP(this.mIPv6));
        } catch (JSONException e2) {
        }
        return jsonObject.toString();
    }

    private boolean isSameIP(String ip1, String ip2) {
        if (!TextUtils.isEmpty(ip1) || !TextUtils.isEmpty(ip2)) {
            return TextUtils.equals(ip1, ip2);
        }
        return true;
    }

    static String decodeClientIP(String encodedClientIP) {
        byte[] decodeBytes;
        InetAddress address;
        if (TextUtils.isEmpty(encodedClientIP)) {
            return null;
        }
        try {
            String[] splitStrings = encodedClientIP.split(",");
            if (splitStrings.length != 2 || !splitStrings[1].contains("1.0") || (decodeBytes = Base64.decode(splitStrings[0], 0)) == null || (address = InetAddress.getByName(new String(decodeBytes))) == null) {
                return null;
            }
            return address.getHostAddress();
        } catch (Throwable th2) {
            return null;
        }
    }
}
