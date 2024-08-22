package com.baidu.browser.explore.network;

import com.baidu.browser.explore.network.proto.SearchNaProtoResponseParser;
import java.io.InputStream;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NaResponseFileUtilsKt$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ SearchNaProtoResponseParser f$0;
    public final /* synthetic */ InputStream f$1;

    public /* synthetic */ NaResponseFileUtilsKt$$ExternalSyntheticLambda0(SearchNaProtoResponseParser searchNaProtoResponseParser, InputStream inputStream) {
        this.f$0 = searchNaProtoResponseParser;
        this.f$1 = inputStream;
    }

    public final void run() {
        NaResponseFileUtilsKt.m12922restoreResponseFromFile$lambda5$lambda3$lambda2(this.f$0, this.f$1);
    }
}
