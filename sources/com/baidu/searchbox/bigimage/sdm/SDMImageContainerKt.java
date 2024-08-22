package com.baidu.searchbox.bigimage.sdm;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"CONTAINERINDEX", "", "getCONTAINERINDEX", "()I", "setCONTAINERINDEX", "(I)V", "PARAM_KEY_IAMGES", "", "PARAM_KEY_OPEN", "PARAM_KEY_POSITION", "lib-bigimage-bee-runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SDMImageContainer.kt */
public final class SDMImageContainerKt {
    private static int CONTAINERINDEX = 0;
    public static final String PARAM_KEY_IAMGES = "imageInfos";
    public static final String PARAM_KEY_OPEN = "openParam";
    public static final String PARAM_KEY_POSITION = "curIndex";

    public static final int getCONTAINERINDEX() {
        return CONTAINERINDEX;
    }

    public static final void setCONTAINERINDEX(int i2) {
        CONTAINERINDEX = i2;
    }
}
