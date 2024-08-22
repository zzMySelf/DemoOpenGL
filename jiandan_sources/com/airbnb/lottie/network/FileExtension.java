package com.airbnb.lottie.network;

import androidx.multidex.MultiDexExtractor;
import fe.qw.qw.ggg.fe;

public enum FileExtension {
    JSON(".json"),
    ZIP(MultiDexExtractor.EXTRACTED_SUFFIX);
    
    public final String extension;

    /* access modifiers changed from: public */
    FileExtension(String str) {
        this.extension = str;
    }

    public static FileExtension forFile(String str) {
        for (FileExtension fileExtension : values()) {
            if (str.endsWith(fileExtension.extension)) {
                return fileExtension;
            }
        }
        fe.de("Unable to find correct extension for " + str);
        return JSON;
    }

    public String tempExtension() {
        return ".temp" + this.extension;
    }

    public String toString() {
        return this.extension;
    }
}
