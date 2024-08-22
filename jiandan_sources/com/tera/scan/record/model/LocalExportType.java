package com.tera.scan.record.model;

import com.tera.scan.business.textrecognition.TextRecognitionActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/tera/scan/record/model/LocalExportType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TextOcr", "TextTranslate", "scan-record_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum LocalExportType {
    TextOcr(TextRecognitionActivity.FROM_TEXT_OCR),
    TextTranslate("text_translate");
    
    @NotNull
    public final String value;

    /* access modifiers changed from: public */
    LocalExportType(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
