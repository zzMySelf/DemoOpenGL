package com.baidu.browser.explore.network;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: NaRequestCache.kt */
final class NaRequestCache$getProtoNaResponseParserInstance$1$parseResponse$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ NaRequestCache$getProtoNaResponseParserInstance$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NaRequestCache$getProtoNaResponseParserInstance$1$parseResponse$1(NaRequestCache$getProtoNaResponseParserInstance$1 naRequestCache$getProtoNaResponseParserInstance$1) {
        super(0);
        this.this$0 = naRequestCache$getProtoNaResponseParserInstance$1;
    }

    public final void invoke() {
        NaResponseInformation it = this.this$0.getResponseInformation();
        if (it != null && Intrinsics.areEqual((Object) it.getHeader().getMimeType(), (Object) NaRequestConstantFileKt.MIME_APPLICATION_X_PROTOBUF)) {
            it.getHeader().setProtoBuf(true);
            it.getHeader().setMimeType("text/html");
            NaResponseHeader header = it.getHeader();
            String charset = Charsets.UTF_8.toString();
            Intrinsics.checkNotNullExpressionValue(charset, "UTF_8.toString()");
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
            String lowerCase = charset.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            header.setEncoding(lowerCase);
            it.getHeader().setContentType(NaRequestConstantFileKt.CONTENT_TYPE_TEXT_HTML);
            it.getHeader().getHeaderMap().put("content-type", NaRequestConstantFileKt.CONTENT_TYPE_TEXT_HTML);
        }
    }
}
