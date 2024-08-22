package com.baidu.sapi2.utils.enums;

import com.baidu.sapi2.utils.SapiHost;
import com.baidu.sapi2.utils.SapiUtils;

public enum Domain {
    DOMAIN_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==", SapiHost.DOMAIN_ONLINE_WAPPASS_URL, SapiHost.DOMAIN_ONLINE_DEVICE_URL, SapiHost.DOMAIN_ONLINE_CONFIG_HTTPS_URL, SapiHost.DOMAIN_ONLINE_PORTRAIT_URL),
    DOMAIN_QA(SapiHost.DOMAIN_QA_PASSPORT_URL, SapiHost.DOMAIN_QA_WAPPASS_URL, SapiHost.DOMAIN_QA_DEVICE_URL, SapiHost.DOMAIN_QA_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ=="),
    DOMAIN_CAR_ONLINE("aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbTo0NDM=", SapiHost.DOMAIN_CAR_ONLINE_WAPPASS_URL, SapiHost.DOMAIN_CAR_ONLINE_DEVICE_URL, SapiHost.DOMAIN_CAR_ONLINE_CONFIG_HTTPS_URL, "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbTo0NDM=");
    
    public String configHttpsUrl;
    public String deviceUrl;
    public boolean forceHttps;
    public String portraitUrl;
    public String proxyHost;
    public int proxyPort;
    public String url;
    public String wap;

    /* access modifiers changed from: public */
    Domain(String str, String str2, String str3, String str4, String str5) {
        this.proxyPort = 443;
        this.url = SapiHost.getHost(str);
        this.wap = SapiHost.getHost(str2);
        this.deviceUrl = SapiHost.getHost(str3);
        this.configHttpsUrl = SapiHost.getHost(str4);
        this.portraitUrl = SapiHost.getHost(str5);
    }

    public Domain forceHttps(boolean z) {
        this.forceHttps = z;
        if (equals(DOMAIN_CAR_ONLINE)) {
            this.forceHttps = false;
        }
        return this;
    }

    public Domain forceProxy(String str, int i2) {
        if (equals(DOMAIN_CAR_ONLINE)) {
            this.proxyHost = str;
            this.proxyPort = i2;
        }
        return this;
    }

    public String getConfigHttpsUrl() {
        return this.configHttpsUrl;
    }

    public String getDeviceUrl() {
        return this.deviceUrl;
    }

    public String getPortraitUrl() {
        return this.portraitUrl;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public String getURL() {
        return getURL(SapiUtils.getDefaultHttpsEnabled());
    }

    public String getUrlDomain() {
        return getURL().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getWap() {
        if ((!equals(DOMAIN_ONLINE) || !SapiUtils.getDefaultHttpsEnabled()) && (equals(DOMAIN_ONLINE) || !this.forceHttps)) {
            return this.wap;
        }
        return this.wap.replace("http://", "https://");
    }

    public String getWapDomain() {
        return getWap().replace("http://", "").replace("https://", "").replaceAll("(:[0-9]{1,4})?", "");
    }

    public String getURL(boolean z) {
        if ((!equals(DOMAIN_ONLINE) || !z) && (equals(DOMAIN_ONLINE) || !this.forceHttps)) {
            return this.url;
        }
        return this.url.replace("http://", "https://");
    }
}
