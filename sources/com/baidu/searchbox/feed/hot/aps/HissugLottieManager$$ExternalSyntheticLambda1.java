package com.baidu.searchbox.feed.hot.aps;

import java.io.File;
import java.io.FileFilter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HissugLottieManager$$ExternalSyntheticLambda1 implements FileFilter {
    public final /* synthetic */ String f$0;

    public /* synthetic */ HissugLottieManager$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    public final boolean accept(File file) {
        return HissugLottieManager.m18713getLottieFilesPath$lambda10$lambda4(this.f$0, file);
    }
}
