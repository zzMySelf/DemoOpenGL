package com.baidu.browser.core.data;

import android.net.ParseException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BdUri {
    static final int MATCH_GROUP_AUTHORITY = 2;
    static final int MATCH_GROUP_HOST = 3;
    static final int MATCH_GROUP_PATH = 5;
    static final int MATCH_GROUP_PORT = 4;
    static final int MATCH_GROUP_SCHEME = 1;
    public static final String URL_REGEXP = "(((https|http|ftp|rtsp|mms)?://)?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-z_!~*'()-]+\\.)*([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\.[a-z]{2,6})(:[0-9]{1,4})?((/?)|(/[0-9a-z\\u4e00-\\u9fa5_!~*'().;?:@&=+$,%#-/]+)+/?))|(file://*)";
    static Pattern sAddressPattern = Pattern.compile("(?:(http|HTTP|https|HTTPS|file|FILE)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([-A-Za-z0-9%_]+(?:\\.[-A-Za-z0-9%_]+)*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]+))?(\\/?.*)?");
    public String mAuthInfo;
    public String mHost;
    public List<BdNVPair> mParamList;
    public String mPath;
    public int mPort;
    public String mScheme;

    public BdUri(String aAddress) throws ParseException {
        if (aAddress != null) {
            this.mScheme = "";
            this.mHost = "";
            this.mPort = -1;
            this.mPath = "/";
            this.mAuthInfo = "";
            Matcher m = sAddressPattern.matcher(aAddress);
            if (m.matches()) {
                String t = m.group(1);
                if (t != null) {
                    this.mScheme = t;
                }
                String t2 = m.group(2);
                if (t2 != null) {
                    this.mAuthInfo = t2;
                }
                String t3 = m.group(3);
                if (t3 != null) {
                    this.mHost = t3;
                }
                String t4 = m.group(4);
                if (t4 != null) {
                    try {
                        this.mPort = Integer.parseInt(t4);
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                    }
                }
                String t5 = m.group(5);
                if (t5 != null && t5.length() > 0) {
                    if (t5.charAt(0) == '/') {
                        this.mPath = t5;
                    } else {
                        this.mPath = "/" + t5;
                    }
                }
            }
            if (this.mPort == 443 && this.mScheme.equals("")) {
                this.mScheme = "https";
            } else if (this.mPort == -1) {
                if (this.mScheme.equals("https")) {
                    this.mPort = 443;
                } else {
                    this.mPort = 80;
                }
            }
            if (this.mScheme.equals("")) {
                this.mScheme = "http";
            }
            parseParam(aAddress);
            return;
        }
        throw new NullPointerException();
    }

    public void parseParam(String aUrl) {
        int questIndex;
        String queryString;
        int ampersandIndex;
        String subStr;
        String[] newValues;
        if (this.mParamList == null) {
            this.mParamList = new ArrayList();
        }
        if (aUrl != null && aUrl.length() != 0 && (questIndex = aUrl.indexOf(63)) != -1 && (queryString = aUrl.substring(questIndex + 1, aUrl.length())) != null && queryString.length() > 0) {
            int lastAmpersandIndex = 0;
            do {
                ampersandIndex = queryString.indexOf(38, lastAmpersandIndex) + 1;
                if (ampersandIndex > 0) {
                    subStr = queryString.substring(lastAmpersandIndex, ampersandIndex - 1);
                    lastAmpersandIndex = ampersandIndex;
                } else {
                    subStr = queryString.substring(lastAmpersandIndex);
                }
                String[] paramPair = subStr.split("=");
                if (paramPair != null && paramPair.length == 2) {
                    String param = paramPair[0];
                    String value = paramPair.length == 1 ? "" : paramPair[1];
                    try {
                        value = URLDecoder.decode(value, "utf-8");
                    } catch (UnsupportedEncodingException ignored) {
                        ignored.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    String[] values = getValues(param);
                    if (values != null) {
                        int len = values.length;
                        newValues = new String[(len + 1)];
                        System.arraycopy(values, 0, newValues, 0, len);
                        newValues[len] = value;
                    } else {
                        newValues = new String[]{value};
                    }
                    this.mParamList.add(new BdNVPair(param, newValues));
                    continue;
                }
            } while (ampersandIndex > 0);
        }
    }

    public List<BdNVPair> getParamList() {
        return this.mParamList;
    }

    public String getValue(String aName) {
        String[] values = getValues(aName);
        if (values == null || values.length <= 0) {
            return null;
        }
        return values[0];
    }

    public String[] getValues(String aName) {
        for (BdNVPair pair : this.mParamList) {
            if (pair.getName().equals(aName)) {
                return (String[]) pair.getValue();
            }
        }
        return null;
    }

    public String toString() {
        String port = "";
        if ((this.mPort != 443 && this.mScheme.equals("https")) || (this.mPort != 80 && this.mScheme.equals("http"))) {
            port = ":" + Integer.toString(this.mPort);
        }
        String authInfo = "";
        if (this.mAuthInfo.length() > 0) {
            authInfo = this.mAuthInfo + "@";
        }
        return this.mScheme + "://" + authInfo + this.mHost + port + this.mPath;
    }
}
