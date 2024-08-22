package com.duxiaoman.okhttp3;

import fe.th.de.ddd;
import fe.th.de.mmm;
import fe.th.de.o;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public abstract class EventListener {
    public static final EventListener NONE = new qw();

    public interface Factory {
        EventListener create(Call call);
    }

    public class ad implements Factory {
        public ad() {
        }

        public EventListener create(Call call) {
            return EventListener.this;
        }
    }

    public class qw extends EventListener {
    }

    public static Factory factory(EventListener eventListener) {
        return new ad();
    }

    public void callEnd(Call call) {
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void callStart(Call call) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void requestBodyEnd(Call call, long j) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestHeadersEnd(Call call, ddd ddd) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyEnd(Call call, long j) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseHeadersEnd(Call call, mmm mmm) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void secureConnectEnd(Call call, o oVar) {
    }

    public void secureConnectStart(Call call) {
    }
}
