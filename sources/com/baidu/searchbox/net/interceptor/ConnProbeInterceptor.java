package com.baidu.searchbox.net.interceptor;

import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.IHttpContext;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.socketinfo.SocketInfo;
import com.baidu.searchbox.network.socketinfo.TCPInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnProbeInterceptor implements Interceptor {
    private static final int MAX_RECORD_CONNECTION = 10;
    private HashMap<String, ArrayList<Integer>> hostAndConnections = new HashMap<>(10);

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Connection connection = chain.connection();
        Object tag = request.tag();
        HttpRequest httpRequest = null;
        if (tag instanceof HttpRequest) {
            httpRequest = (HttpRequest) tag;
        }
        boolean isConnReused = isConnReused(connection, request);
        if (httpRequest != null) {
            httpRequest.isConnReused = isConnReused;
            IHttpContext context = HttpRuntime.getHttpContext();
            if (context != null && context.isRttLogEnabled()) {
                TCPInfo tcpInfo = SocketInfo.getInstance().getTcpInfoBySocket(connection.socket());
                NetworkStatRecord record = httpRequest.getRequestNetStat();
                if (!(tcpInfo == null || record == null)) {
                    record.tcpiRtt = tcpInfo.tcpiRtt;
                    record.tcpiLost = tcpInfo.tcpiLost;
                }
            }
        }
        return chain.proceed(request);
    }

    private synchronized boolean isConnReused(Connection connection, Request request) {
        if (request == null) {
            return false;
        }
        String httpUrl = request.url().toString();
        String host = request.url().host();
        ArrayList<Integer> connectionIds = this.hostAndConnections.get(host);
        if (connectionIds == null) {
            connectionIds = new ArrayList<>(10);
            this.hostAndConnections.put(host, connectionIds);
        }
        return isReused(connectionIds, Integer.valueOf(connection == null ? -1 : connection.hashCode()).intValue());
    }

    private boolean isReused(ArrayList<Integer> connectionIds, int connectionId) {
        if (connectionIds == null) {
            return false;
        }
        boolean reuse = false;
        int i2 = connectionIds.size() - 1;
        while (true) {
            if (i2 < 0) {
                break;
            } else if (connectionIds.get(i2).intValue() == connectionId) {
                connectionIds.remove(i2);
                reuse = true;
                break;
            } else {
                i2--;
            }
        }
        connectionIds.add(Integer.valueOf(connectionId));
        if (connectionIds.size() > 10) {
            connectionIds.remove(0);
        }
        return reuse;
    }
}
