package com.tera.scan.vip.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/vip/model/PrivilegeType;", "", "value", "", "defaultFreeCount", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getDefaultFreeCount", "()I", "getValue", "()Ljava/lang/String;", "ultraScan", "recognitionText", "imageRemoveWatermark", "removeHandWriting", "mergePdf", "wipeWrite", "pdfExtract", "imageToExcel", "pdfToWord", "imageToPdfRemoveLogo", "imageToWord", "cardScan", "imageAiTranslate", "imageAddWatermark", "lib_vip_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum PrivilegeType {
    ultraScan("ultraScan", 0),
    recognitionText("recognitionText", 3),
    imageRemoveWatermark("cloudFilterRemoveImageWatermark", 0),
    removeHandWriting("removeHandWriting", 0),
    mergePdf("pdfMerge", 0),
    wipeWrite("wipeWrite", 0),
    pdfExtract("pdfExtract", 0),
    imageToExcel("imageToExcel", 3),
    pdfToWord("pdfToWord", 0),
    imageToPdfRemoveLogo("imageToPdfRemoveLogo", 3),
    imageToWord("imageToWord", 3),
    cardScan("cardScan", 0),
    imageAiTranslate("imageAiTranslate", 3),
    imageAddWatermark("imageAddWatermark", 0);
    
    public final int defaultFreeCount;
    @NotNull
    public final String value;

    /* access modifiers changed from: public */
    PrivilegeType(String str, int i2) {
        this.value = str;
        this.defaultFreeCount = i2;
    }

    public final int getDefaultFreeCount() {
        return this.defaultFreeCount;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
