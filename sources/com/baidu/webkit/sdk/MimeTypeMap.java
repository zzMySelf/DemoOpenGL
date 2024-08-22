package com.baidu.webkit.sdk;

public class MimeTypeMap {
    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();

    /* access modifiers changed from: protected */
    public String getFileExtensionFromUrlImpl(String str) {
        return "";
    }

    public static String getFileExtensionFromUrl(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return "";
        }
        return WebViewFactory.getProvider().getMimeTypeMap().getFileExtensionFromUrlImpl(str);
    }

    public boolean hasMimeType(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return false;
        }
        return WebViewFactory.getProvider().getMimeTypeMap().hasMimeType(str);
    }

    public String getMimeTypeFromExtension(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return "";
        }
        return WebViewFactory.getProvider().getMimeTypeMap().getMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return false;
        }
        return WebViewFactory.getProvider().getMimeTypeMap().hasExtension(str);
    }

    public String getExtensionFromMimeType(String str) {
        if (!WebViewFactory.isProviderValid()) {
            return "";
        }
        return WebViewFactory.getProvider().getMimeTypeMap().getExtensionFromMimeType(str);
    }

    public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }
}
