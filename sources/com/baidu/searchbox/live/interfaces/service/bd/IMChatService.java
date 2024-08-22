package com.baidu.searchbox.live.interfaces.service.bd;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fJ\b\u0010\u0002\u001a\u00020\u0003H&JC\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\u000bH&¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/IMChatService;", "", "init", "", "invoke", "appId", "", "nickname", "msgType", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "status", "Companion", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: IMChatService.kt */
public interface IMChatService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int MSG_TYPE_USER = 0;
    public static final int STATE_SUCCESS = 0;

    void init();

    void invoke(String str, String str2, int i2, Function1<? super Integer, Unit> function1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/bd/IMChatService$Companion;", "", "()V", "MSG_TYPE_USER", "", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "STATE_SUCCESS", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: IMChatService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int MSG_TYPE_USER = 0;
        private static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef("im_chat");
        public static final int STATE_SUCCESS = 0;

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
