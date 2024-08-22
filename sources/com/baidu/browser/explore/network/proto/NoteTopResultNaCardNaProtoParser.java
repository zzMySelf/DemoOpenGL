package com.baidu.browser.explore.network.proto;

import com.baidu.browser.explore.network.NaResponseInformation;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lcom/baidu/browser/explore/network/proto/NoteTopResultNaCardNaProtoParser;", "Lcom/baidu/browser/explore/network/proto/ResultNaCardNaProtoParser;", "requestHandler", "Lcom/baidu/browser/explore/network/proto/SearchNaProtoRequestHandler;", "handlers", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/baidu/browser/explore/network/proto/SearchNaProtoEventHandler;", "response", "Lcom/baidu/browser/explore/network/NaResponseInformation;", "(Lcom/baidu/browser/explore/network/proto/SearchNaProtoRequestHandler;Ljava/util/Map;Lcom/baidu/browser/explore/network/NaResponseInformation;)V", "getName", "getReqScene", "getReqType", "", "handleEventData", "", "eventHandler", "data", "Lcom/baidu/browser/explore/network/proto/ResultCardData;", "lib_search_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NoteTopResultNaCardNaProtoParser.kt */
public final class NoteTopResultNaCardNaProtoParser extends ResultNaCardNaProtoParser {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteTopResultNaCardNaProtoParser(SearchNaProtoRequestHandler requestHandler, Map<String, ? extends WeakReference<SearchNaProtoEventHandler>> handlers, NaResponseInformation response) {
        super(requestHandler, handlers, response);
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        Intrinsics.checkNotNullParameter(response, "response");
    }

    public String getName() {
        return "NoteTopResultNa";
    }

    public int getReqType() {
        return 20;
    }

    public String getReqScene() {
        return SearchNaProtoConstantKt.REQ_SCENE_NOTE_TOP_RESULT_NA;
    }

    public void handleEventData(SearchNaProtoEventHandler eventHandler, ResultCardData data) {
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual((Object) data.getMainTemplate(), (Object) SearchNaProtoConstantKt.MAIN_TEMPLATE_TAG_SEARCH)) {
            eventHandler.onHandleNaProtoNoteTagSearch(data.getData(), data.getUrl(), 1);
        }
    }
}
