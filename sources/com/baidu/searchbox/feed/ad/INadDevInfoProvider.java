package com.baidu.searchbox.feed.ad;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

public interface INadDevInfoProvider {
    public static final INadDevInfoProvider EMPTY = new Impl();

    void addAlsDeviceInfo(StringBuilder sb);

    void addAndroidId(Map<String, String> map);

    void appendDaParam(JSONObject jSONObject);

    String getAndroidId(String str);

    String getBrand(String str);

    String getCommonUrl(String str);

    String getIES(String str);

    String getIMEI(String str);

    String getIad();

    String getIadex();

    JSONObject getLBS();

    String getMac(String str);

    String getManufacturer(String str);

    String getModel(String str);

    String getOaid(String str);

    String getOsVersion(String str);

    boolean isPrivacySwitchOpen();

    boolean isTargetTiramisu(Context context);

    public static class Impl implements INadDevInfoProvider {
        private static INadDevInfoProvider sProvider = AdRuntimeHolder.getNadDevInfoProvider();

        private Impl() {
        }

        public static INadDevInfoProvider get() {
            return sProvider;
        }

        public String getBrand(String purpose) {
            return "";
        }

        public String getManufacturer(String purpose) {
            return "";
        }

        public String getModel(String purpose) {
            return "";
        }

        public String getOsVersion(String purpose) {
            return "";
        }

        public String getAndroidId(String purpose) {
            return "";
        }

        public String getOaid(String purpose) {
            return "";
        }

        public String getMac(String purpose) {
            return "";
        }

        public String getIMEI(String purpose) {
            return "";
        }

        public String getIES(String purpose) {
            return "";
        }

        public String getIadex() {
            return "";
        }

        public String getIad() {
            return "";
        }

        public JSONObject getLBS() {
            return new JSONObject();
        }

        public String getCommonUrl(String url) {
            return "";
        }

        public void appendDaParam(JSONObject jsonObject) {
        }

        public void addAndroidId(Map<String, String> map) {
        }

        public void addAlsDeviceInfo(StringBuilder builder) {
        }

        public boolean isPrivacySwitchOpen() {
            return false;
        }

        public boolean isTargetTiramisu(Context context) {
            return false;
        }
    }
}
