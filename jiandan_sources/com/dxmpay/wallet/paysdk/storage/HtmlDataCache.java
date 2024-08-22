package com.dxmpay.wallet.paysdk.storage;

public class HtmlDataCache {
    public static final String FROM_BINDCARD_PROTOCOL = "1";
    public String qw;

    public static class ad {
        public static HtmlDataCache qw = new HtmlDataCache();
    }

    public static HtmlDataCache getInstance() {
        return ad.qw;
    }

    public void clearData() {
        this.qw = null;
    }

    public String getHtml() {
        return this.qw;
    }

    public void setHtml(String str) {
        this.qw = str;
    }

    public HtmlDataCache() {
    }
}
