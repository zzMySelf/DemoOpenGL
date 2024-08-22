package com.baidu.searchbox.live.interfaces.service;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J$\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0003H&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/WebNaDataChannelService;", "", "registerWebReceiver", "", "host", "", "page", "action", "sendBroadCast", "ctx", "Landroid/content/Context;", "data", "setWebDataReceiverListener", "receiverMessage", "Lcom/baidu/searchbox/live/interfaces/service/WebNaDataChannelService$IReceiverMessage;", "unregisterAllWebReceiver", "unregisterWebReceiver", "Companion", "IReceiverMessage", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: WebNaDataChannelService.kt */
public interface WebNaDataChannelService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/WebNaDataChannelService$IReceiverMessage;", "", "onReceiverMessage", "", "action", "", "data", "Lorg/json/JSONObject;", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: WebNaDataChannelService.kt */
    public interface IReceiverMessage {
        void onReceiverMessage(String str, JSONObject jSONObject);
    }

    void registerWebReceiver(String str, String str2, String str3);

    void sendBroadCast(Context context, String str, String str2);

    void setWebDataReceiverListener(IReceiverMessage iReceiverMessage);

    void unregisterAllWebReceiver();

    void unregisterWebReceiver(String str, String str2, String str3);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/live/interfaces/service/WebNaDataChannelService$Companion;", "", "()V", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "lib-live-interfaces_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: WebNaDataChannelService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ServiceReference SERVICE_REFERENCE = DI.INSTANCE.getServiceRef(DI.LIVE_WEB_DATA_CHANNEL_BRIDGE);

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
