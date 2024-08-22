package com.baidu.searchbox.aisearch.comps.conversation;

import com.baidu.searchbox.aisearch.comps.conversation.event.ErrorPage;
import com.baidu.searchbox.aisearch.comps.web.WebViewLoadErrorState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0010\u001a\u00020\u0004*\u00020\u0011H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"CODE_ERROR_PAGE", "", "CUSTOM_ERRORS", "", "Lcom/baidu/searchbox/aisearch/comps/web/WebViewLoadErrorState;", "ERROR_ACCOUNT_CHANGED", "getERROR_ACCOUNT_CHANGED", "()Lcom/baidu/searchbox/aisearch/comps/web/WebViewLoadErrorState;", "ERROR_BACKGROUND_REDIRECT", "getERROR_BACKGROUND_REDIRECT", "ERROR_CONNECT_LOST", "getERROR_CONNECT_LOST", "ERROR_READY_TIMEOUT", "getERROR_READY_TIMEOUT", "ERROR_RENDERER_GONE", "getERROR_RENDERER_GONE", "toWebViewLoadErrorState", "Lcom/baidu/searchbox/aisearch/comps/conversation/event/ErrorPage;", "toWebViewLoadErrorState-VOi_czo", "(Lorg/json/JSONObject;)Lcom/baidu/searchbox/aisearch/comps/web/WebViewLoadErrorState;", "lib-aisearch-impl_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationErrorComponent.kt */
public final class ConversationErrorComponentKt {
    private static final int CODE_ERROR_PAGE = 10001;
    /* access modifiers changed from: private */
    public static final Set<WebViewLoadErrorState> CUSTOM_ERRORS;
    private static final WebViewLoadErrorState ERROR_ACCOUNT_CHANGED;
    private static final WebViewLoadErrorState ERROR_BACKGROUND_REDIRECT;
    private static final WebViewLoadErrorState ERROR_CONNECT_LOST;
    private static final WebViewLoadErrorState ERROR_READY_TIMEOUT;
    private static final WebViewLoadErrorState ERROR_RENDERER_GONE;

    static {
        WebViewLoadErrorState webViewLoadErrorState = new WebViewLoadErrorState(-9900, 404, (String) null, 4, (DefaultConstructorMarker) null);
        ERROR_READY_TIMEOUT = webViewLoadErrorState;
        WebViewLoadErrorState webViewLoadErrorState2 = new WebViewLoadErrorState(-9901, 404, (String) null, 4, (DefaultConstructorMarker) null);
        ERROR_CONNECT_LOST = webViewLoadErrorState2;
        WebViewLoadErrorState webViewLoadErrorState3 = new WebViewLoadErrorState(-9902, 404, (String) null, 4, (DefaultConstructorMarker) null);
        ERROR_RENDERER_GONE = webViewLoadErrorState3;
        WebViewLoadErrorState webViewLoadErrorState4 = new WebViewLoadErrorState(-9903, 404, (String) null, 4, (DefaultConstructorMarker) null);
        ERROR_BACKGROUND_REDIRECT = webViewLoadErrorState4;
        WebViewLoadErrorState webViewLoadErrorState5 = new WebViewLoadErrorState(-9904, 404, (String) null, 4, (DefaultConstructorMarker) null);
        ERROR_ACCOUNT_CHANGED = webViewLoadErrorState5;
        CUSTOM_ERRORS = SetsKt.mutableSetOf(webViewLoadErrorState, webViewLoadErrorState2, webViewLoadErrorState3, webViewLoadErrorState4, webViewLoadErrorState5);
    }

    public static final WebViewLoadErrorState getERROR_READY_TIMEOUT() {
        return ERROR_READY_TIMEOUT;
    }

    public static final WebViewLoadErrorState getERROR_CONNECT_LOST() {
        return ERROR_CONNECT_LOST;
    }

    public static final WebViewLoadErrorState getERROR_RENDERER_GONE() {
        return ERROR_RENDERER_GONE;
    }

    public static final WebViewLoadErrorState getERROR_BACKGROUND_REDIRECT() {
        return ERROR_BACKGROUND_REDIRECT;
    }

    public static final WebViewLoadErrorState getERROR_ACCOUNT_CHANGED() {
        return ERROR_ACCOUNT_CHANGED;
    }

    /* renamed from: toWebViewLoadErrorState-VOi_czo  reason: not valid java name */
    public static final WebViewLoadErrorState m15173toWebViewLoadErrorStateVOi_czo(JSONObject $this$toWebViewLoadErrorState_u2dVOi_czo) {
        return new WebViewLoadErrorState(10001, ErrorPage.m15461getCodeimpl($this$toWebViewLoadErrorState_u2dVOi_czo), ErrorPage.m15463getReasonimpl($this$toWebViewLoadErrorState_u2dVOi_czo));
    }
}
