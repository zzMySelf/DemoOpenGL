package com.baidu.browser.explore.network.proto;

import com.baidu.browser.explore.network.NaResponseInformation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/browser/explore/network/proto/ResultNaCardNaProtoParser$showCallback$2$1", "invoke", "()Lcom/baidu/browser/explore/network/proto/ResultNaCardNaProtoParser$showCallback$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResultNaCardNaProtoParser.kt */
final class ResultNaCardNaProtoParser$showCallback$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ NaResponseInformation $response;
    final /* synthetic */ ResultNaCardNaProtoParser this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ResultNaCardNaProtoParser$showCallback$2(ResultNaCardNaProtoParser resultNaCardNaProtoParser, NaResponseInformation naResponseInformation) {
        super(0);
        this.this$0 = resultNaCardNaProtoParser;
        this.$response = naResponseInformation;
    }

    public final AnonymousClass1 invoke() {
        SearchNaProtoRequestHandler requestHandler = this.this$0.getRequestHandler();
        boolean z = true;
        if (requestHandler == null || !requestHandler.enableAPageNADispatchOpt()) {
            z = false;
        }
        if (z) {
            final ResultNaCardNaProtoParser resultNaCardNaProtoParser = this.this$0;
            final NaResponseInformation naResponseInformation = this.$response;
            return new NaProtoShowCallback() {
                public void onShowFinished() {
                    switch (resultNaCardNaProtoParser.getReqType()) {
                        case 14:
                        case 15:
                        case 20:
                        case 25:
                            return;
                        default:
                            NaProtoDispatcherShowInterface dispatcher = resultNaCardNaProtoParser.getDispatcher();
                            if (dispatcher != null) {
                                dispatcher.onNACardShowFinished(naResponseInformation.getInputStream());
                                return;
                            }
                            return;
                    }
                }
            };
        }
        AnonymousClass1 r1 = null;
        return null;
    }
}
