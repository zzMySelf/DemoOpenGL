package com.tera.scan.business.textrecognition.model;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "paragraphText", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OcrResultData$transformText$1$3 extends Lambda implements Function1<String, Boolean> {
    public static final OcrResultData$transformText$1$3 INSTANCE = new OcrResultData$transformText$1$3();

    public OcrResultData$transformText$1$3() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "paragraphText");
        return Boolean.valueOf(str.length() > 0);
    }
}
