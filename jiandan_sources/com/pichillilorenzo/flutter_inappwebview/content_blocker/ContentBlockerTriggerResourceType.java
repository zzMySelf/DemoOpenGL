package com.pichillilorenzo.flutter_inappwebview.content_blocker;

import com.baidu.apollon.utils.ResUtils;
import com.baidubce.services.vod.VodClient;
import com.google.common.net.MediaType;

public enum ContentBlockerTriggerResourceType {
    DOCUMENT("document"),
    IMAGE(MediaType.IMAGE_TYPE),
    STYLE_SHEET("style-sheet"),
    SCRIPT("script"),
    FONT("font"),
    SVG_DOCUMENT("svg-document"),
    MEDIA(VodClient.PATH_MEDIA),
    POPUP("popup"),
    RAW(ResUtils.l);
    
    public final String value;

    /* access modifiers changed from: public */
    ContentBlockerTriggerResourceType(String str) {
        this.value = str;
    }

    public static ContentBlockerTriggerResourceType fromValue(String str) {
        for (ContentBlockerTriggerResourceType contentBlockerTriggerResourceType : values()) {
            if (str.equals(contentBlockerTriggerResourceType.value)) {
                return contentBlockerTriggerResourceType;
            }
        }
        throw new IllegalArgumentException("No enum constant: " + str);
    }

    public boolean equalsValue(String str) {
        return this.value.equals(str);
    }

    public String toString() {
        return this.value;
    }
}
